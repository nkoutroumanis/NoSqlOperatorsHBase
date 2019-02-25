package gr.unipi.ptixiaki.nosqldb;

import com.mongodb.client.MongoCursor;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;
import gr.unipi.ptixiaki.filterOperator.FilterOperator;
import org.bson.Document;
import org.bson.conversions.Bson;
import scala.collection.JavaConversions;

import java.util.*;

final class MongoDBOperators implements NoSqlDbOperators {

    private final MongoDBConnectionManager mongoDBConnectionManager = MongoDBConnectionManager.getInstance();
    private final MongoDBConnector connector;
    private final String s;
    private final SparkSession sparkSession;
    private final List<Bson> stagesList;

    private MongoDBOperators(MongoDBConnector connector, String s, SparkSession sparkSession) {
        this.connector = connector;
        this.s = s;
        this.sparkSession = sparkSession;
        stagesList = new ArrayList<>();
    }

    public static MongoDBOperators newMongoDBOperators(MongoDBConnector connector, String s, SparkSession sparkSession) {
        return new MongoDBOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {

        if (filterOperator instanceof OperatorNearestNeighbors) {
            stagesList.add(Document.parse(filterOperator.getJsonStringBuilder().toString()));
        } else {
            stagesList.add(Document.parse(" { $match: " + filterOperator.getJsonStringBuilder() + " } "));
        }

        for (FilterOperator fops : filterOperators) {
            if (fops instanceof OperatorNearestNeighbors) {
                stagesList.add(Document.parse(fops.getJsonStringBuilder().toString()));
            } else {
                stagesList.add(Document.parse(" { $match: " + fops.getJsonStringBuilder() + " } "));
            }
        }
        return this;
    }

    @Override
    public void printScreen() {
        MongoCursor<Document> cursor = mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }


}
