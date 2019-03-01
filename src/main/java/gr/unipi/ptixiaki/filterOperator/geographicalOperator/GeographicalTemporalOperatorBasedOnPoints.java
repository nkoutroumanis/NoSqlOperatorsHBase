package gr.unipi.ptixiaki.filterOperator.geographicalOperator;

import java.util.Date;

public abstract class GeographicalTemporalOperatorBasedOnPoints extends GeographicalTemporalOperator {

    protected GeographicalTemporalOperatorBasedOnPoints(String fieldName, Date lowerDate, Date upperDate, Coordinates... coordinatesArray) {
        super(fieldName, lowerDate, upperDate, coordinatesArray);
    }

    @Override
    public StringBuilder getJsonStringBuilder() {

    }

}
