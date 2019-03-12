package gr.unipi.ptixiaki;

import org.apache.hadoop.hdfs.server.datanode.DataStorage;

import java.util.List;

public interface Operator {

    StringBuilder getJsonStringBuilder();//method for mongodb

    List<DataStorage> getDataStorage();


}
