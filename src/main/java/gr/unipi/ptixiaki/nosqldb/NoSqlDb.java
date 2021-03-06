package gr.unipi.ptixiaki.nosqldb;

enum NoSqlDb {

    HBASE {
        @Override
        public NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database) {
            return HBaseConnector.newHBaseConnector(host, port, username, password, database);
        }

        @Override
        public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s) {
            return HBaseOperators.newHBaseOperators((HBaseConnector) connector, s);
        }

        @Override
        public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
            noSqlDbConnector.closeConnection();
        }

        @Override
        public int getDefaultPort() {
            return 27017;
        }

        @Override
        public String getDefaultDatabase() {
            return "";
        }

        @Override
        public String getDefaultUsername() {
            return "";
        }

        @Override
        public String getDefaultPassword() {
            return "";
        }

    },

//    MONGODB {//should be deleteed
//        @Override
//        public NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database) {
//            return MongoDBConnector.newMongoDBConnector(host, port, username, password, database);
//        }
//
//        @Override
//        public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
//            return MongoDBOperators.newMongoDBOperators((MongoDBConnector) connector, s, sparkSession);
//        }
//
//        @Override
//        public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
//            MongoDBConnectionManager.getInstance().closeConnection(noSqlDbConnector);
//        }
//
//        @Override
//        public int getDefaultPort() {
//            return 27017;
//        }
//
//        @Override
//        public String getDefaultDatabase() {
//            return "";
//        }
//
//        @Override
//        public String getDefaultUsername() {
//            return "";
//        }
//
//        @Override
//        public String getDefaultPassword() {
//            return "";
//        }
//
//    };


    public abstract NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database);

    public abstract NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s);

    public abstract void closeConnection(NoSqlDbConnector noSqlDbConnector);

    public String getDefaultHost() {
        return "localhost";
    }

    public abstract int getDefaultPort();

    public abstract String getDefaultDatabase();

    public abstract String getDefaultUsername();

    public abstract String getDefaultPassword();

}
