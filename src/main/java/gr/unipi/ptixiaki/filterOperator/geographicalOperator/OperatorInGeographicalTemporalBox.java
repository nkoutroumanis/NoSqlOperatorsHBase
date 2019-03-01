package gr.unipi.ptixiaki.filterOperator.geographicalOperator;

import java.util.Date;

public class OperatorInGeographicalTemporalBox extends GeographicalTemporalOperatorBasedOnPoints {

    private OperatorInGeographicalTemporalBox(String fieldName, Date lowerDate, Date upperDate, Coordinates lowerBound, Coordinates upperBound) {
        super(fieldName, lowerDate, upperDate, lowerBound, Coordinates.newCoordinates(upperBound.getLongitude(), lowerBound.getLatitude()), upperBound, Coordinates.newCoordinates(lowerBound.getLongitude(), upperBound.getLatitude()));
    }

    public static OperatorInGeographicalTemporalBox newOperatorInGeographicalTemporalBox(String fieldName, Date lowerDate, Date upperDate, Coordinates lowerBound, Coordinates upperBound) {
        return new OperatorInGeographicalTemporalBox(fieldName, lowerDate, upperDate, lowerBound, upperBound);
    }

    @Override
    public YYY getYYY() {

    }
}