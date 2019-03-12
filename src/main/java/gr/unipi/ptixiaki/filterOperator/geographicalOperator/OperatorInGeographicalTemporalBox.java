package gr.unipi.ptixiaki.filterOperator.geographicalOperator;

import org.apache.hadoop.hdfs.server.datanode.DataStorage;

import java.util.Date;
import java.util.List;

public class OperatorInGeographicalTemporalBox extends GeographicalTemporalOperatorBasedOnPoints {

    private OperatorInGeographicalTemporalBox(String fieldName, Date lowerDate, Date upperDate, Coordinates lowerBound, Coordinates upperBound) {
        super(fieldName, lowerDate, upperDate, lowerBound, Coordinates.newCoordinates(upperBound.getLongitude(), lowerBound.getLatitude()), upperBound, Coordinates.newCoordinates(lowerBound.getLongitude(), upperBound.getLatitude()));
    }

    public static OperatorInGeographicalTemporalBox newOperatorInGeographicalTemporalBox(String fieldName, Date lowerDate, Date upperDate, Coordinates lowerBound, Coordinates upperBound) {
        return new OperatorInGeographicalTemporalBox(fieldName, lowerDate, upperDate, lowerBound, upperBound);
    }

    public Coordinates getLowerBound(){
        return getCoordinatesArray()[0];
    }

    public Coordinates getUpperBound(){
        return getCoordinatesArray()[2];
    }

    @Override
    public List<DataStorage> getDataStorage() {

        getLowerDate()
                getUpperDate();
    }
}
