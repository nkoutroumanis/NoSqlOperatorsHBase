package gr.unipi.ptixiaki.filterOperator.geographicalOperator;

import java.util.Date;

public abstract class GeographicalTemporalOperator extends GeographicalOperator {

    private final Date upperDate;
    private final Date lowerDate;

    protected GeographicalTemporalOperator(String fieldName, Date lowerDate, Date upperDate, Coordinates... coordinatesArray) {
        super(fieldName, coordinatesArray);
        this.lowerDate = lowerDate;
        this.upperDate = upperDate;
    }

    protected Date getUpperDate() {
        return upperDate;
    }

    protected Date getLowerDate() {
        return lowerDate;
    }

}
