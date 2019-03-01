package gr.unipi.ptixiaki.nosqldb;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class HBaseConnector implements NoSqlDbConnector {

    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String database;//namespace

    private Connection conn;

    private HBaseConnector(String host, int port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;

        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.property.clientPort", String.valueOf(port));
        conf.set("hbase.zookeeper.quorum", host);
        //fill namespace

        try {
            this.conn = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public void closeConnection() {
        try {
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
