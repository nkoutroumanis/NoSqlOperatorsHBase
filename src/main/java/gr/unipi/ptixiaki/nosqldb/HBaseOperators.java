package gr.unipi.ptixiaki.nosqldb;

import gr.unipi.ptixiaki.filterOperator.FilterOperator;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

public class HBaseOperators implements NoSqlDbOperators {

    private final HBaseConnector connector;
    private final String table;

    private HBaseOperators(HBaseConnector connector, String table) {
        this.connector = connector;
        this.table = table;
    }

    public static HBaseOperators newHBaseOperators(HBaseConnector connector, String s) {
        return new HBaseOperators(connector, s);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {


        if


        filterOperator.getYYY()//geobox

        filterOperators[0].getYYY();//gte

        filterOperators[1].getYYY();//lte


    }

    @Override
    public void printScreen() {

        try {
            Table table = connector.getConnection().getTable(TableName.valueOf(this.table));

            table


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
