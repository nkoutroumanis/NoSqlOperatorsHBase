package gr.unipi.ptixiaki.nosqldb;

public interface NoSqlDbConnector<T> {

    T getConnection();

    void closeConnection();
}
