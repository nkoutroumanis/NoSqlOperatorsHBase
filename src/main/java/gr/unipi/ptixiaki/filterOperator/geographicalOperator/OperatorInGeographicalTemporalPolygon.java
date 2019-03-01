package gr.unipi.ptixiaki.filterOperator.geographicalOperator;

import java.util.Date;

public class OperatorInGeographicalTemporalPolygon extends GeographicalTemporalOperatorBasedOnPoints {

    private OperatorInGeographicalTemporalPolygon(String fieldName, Date lowerDate, Date upperDate, Coordinates... coordinates) {
        super(fieldName, lowerDate, upperDate, coordinates);
    }

    public static OperatorInGeographicalTemporalPolygon newOperatorInGeographicalTemporalPolygon(String fieldName, Date lowerDate, Date upperDate, Coordinates... coordinates) {
        return new OperatorInGeographicalTemporalPolygon(fieldName, lowerDate, upperDate, coordinates);
    }

    @Override
    public YYY getYYY() {

    }

}


