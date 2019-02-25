package gr.unipi.ptixiaki.nosqldb;

import java.util.ArrayList;
import java.util.List;

public final class NoSqlDbSystem {

    public static class Builder {

        private final NoSqlDb nsdb;

        private String host;
        private int port;
        private String database; // the name of the database in which the user is defined
        private String username; // the user name
        private String password; // the password as a character array

        public Builder(NoSqlDb nsdb) {

            this.nsdb = nsdb;
            this.host = nsdb.getDefaultHost();
            this.port = nsdb.getDefaultPort();
            this.database = nsdb.getDefaultDatabase();
            this.username = nsdb.getDefaultUsername();
            this.password = nsdb.getDefaultPassword();
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder database(String database) {
            this.database = database;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public NoSqlDbSystem build() {

            return new NoSqlDbSystem(nsdb, nsdb.createNoSqlDbConnector(host, port, username, password, database));
        }

    }

    private final NoSqlDb nsdb;
    private final NoSqlDbConnector connector;

    private NoSqlDbSystem(NoSqlDb nsdb, NoSqlDbConnector connector) {
        this.nsdb = nsdb;
        this.connector = connector;
    }

    public void closeConnection() {
        nsdb.closeConnection(connector);
    }

    public NoSqlDbOperators operateOn(String s) {
        return nsdb.noSqlDbOperators(connector, s);
    }

    public static Builder HBase() {
        return new NoSqlDbSystem.Builder(NoSqlDb.HBASE);
    }

    public static Builder MongoDB() {
        return new NoSqlDbSystem.Builder(NoSqlDb.MONGODB);
    }

}
