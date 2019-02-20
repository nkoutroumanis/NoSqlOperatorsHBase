package gr.unipi.ptixiaki.filterOperator.geographicalOperator;

public abstract class GeographicalOperatorBasedOnPoints extends GeographicalOperator {

    protected GeographicalOperatorBasedOnPoints(String fieldName, Coordinates... coordinates) {
        super(fieldName, coordinates);
    }


}
