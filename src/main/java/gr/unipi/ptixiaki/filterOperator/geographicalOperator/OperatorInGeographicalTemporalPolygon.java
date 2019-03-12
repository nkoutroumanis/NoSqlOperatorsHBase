package gr.unipi.ptixiaki.filterOperator.geographicalOperator;

import org.apache.hadoop.hdfs.server.datanode.DataStorage;

import java.util.Date;
import java.util.List;

public class OperatorInGeographicalTemporalPolygon extends GeographicalTemporalOperatorBasedOnPoints {

    private OperatorInGeographicalTemporalPolygon(String fieldName, Date lowerDate, Date upperDate, Coordinates... coordinates) {
        super(fieldName, lowerDate, upperDate, coordinates);
    }

    public static OperatorInGeographicalTemporalPolygon newOperatorInGeographicalTemporalPolygon(String fieldName, Date lowerDate, Date upperDate, Coordinates... coordinates) {
        return new OperatorInGeographicalTemporalPolygon(fieldName, lowerDate, upperDate, coordinates);
    }

    @Override
    public List<DataStorage> getDataStorage() {

    }

}


