package gr.unipi.ptixiaki.nosqldb;

import gr.unipi.ptixiaki.filterOperator.FilterOperator;

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
        return null;
    }

    @Override
    public void printScreen() {

    }

}
