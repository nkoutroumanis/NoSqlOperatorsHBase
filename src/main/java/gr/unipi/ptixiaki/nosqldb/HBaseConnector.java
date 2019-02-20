package gr.unipi.ptixiaki.nosqldb;

import java.util.Objects;

public class HBaseConnector implements NoSqlDbConnector {

    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String database;


    private HBaseConnector(String host, int port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    @Override
    public XXX getConnection() {

    }

    @Override
    public void closeConnection() {

    }

    public static HBaseConnector newHBaseConnector(String host, int port, String username, String password, String database) {
        return new HBaseConnector(host, port, username, password, database);
    }

    public String getDatabase() {
        return database;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

}
