package gr.unipi.ptixiaki.nosqldb;

import gr.unipi.ptixiaki.filterOperator.FilterOperator;

public interface NoSqlDbOperators {

    NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators);

    void printScreen();

}
