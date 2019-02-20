package gr.unipi.ptixiaki.nosqldb;

import gr.unipi.ptixiaki.filterOperator.FilterOperator;

import java.util.Optional;

public interface NoSqlDbOperators {

    NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators);

    void printScreen();

}
