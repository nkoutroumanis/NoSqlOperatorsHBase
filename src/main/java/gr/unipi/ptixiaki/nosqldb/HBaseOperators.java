package gr.unipi.ptixiaki.nosqldb;

import gr.unipi.ptixiaki.filterOperator.FilterOperator;
import gr.unipi.ptixiaki.filterOperator.geographicalOperator.GeographicalTemporalOperatorBasedOnPoints;
import gr.unipi.ptixiaki.filterOperator.geographicalOperator.OperatorInGeographicalBox;
import gr.unipi.ptixiaki.filterOperator.geographicalOperator.OperatorInGeographicalPolygon;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hdfs.server.datanode.DataStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HBaseOperators implements NoSqlDbOperators {

    private final HBaseConnector connector;
    private final String table;

    private List<DataStorage> l = new ArrayList<>();


    private HBaseOperators(HBaseConnector connector, String table) {
        this.connector = connector;
        this.table = table;
    }

    public static HBaseOperators newHBaseOperators(HBaseConnector connector, String s) {
        return new HBaseOperators(connector, s);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {

        l = filterOperator.getDataStorage();

        return this;
    }

    @Override
    public void printScreen() {

        try {
            Table table = connector.getConnection().getTable(TableName.valueOf(this.table));

            l
//query hbase


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
