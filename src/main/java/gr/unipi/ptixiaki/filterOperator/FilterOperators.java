package gr.unipi.ptixiaki.filterOperator;

import gr.unipi.ptixiaki.filterOperator.comparisonOperator.OperatorGreaterThanEqual;
import gr.unipi.ptixiaki.filterOperator.comparisonOperator.OperatorLessThanEqual;
import gr.unipi.ptixiaki.filterOperator.geographicalOperator.*;

import java.util.Date;

public class FilterOperators {

    public static FilterOperator gte(String fieldName, Date fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, Date fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator inGeoPolygon(String fieldName, Coordinates... coordinates) {
        return OperatorInGeographicalPolygon.newOperatorInGeographicalPolygon(fieldName, coordinates);
    }

    public static FilterOperator inGeoBox(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerBoundPoint, upperBoundPoint);
    }

    public static FilterOperator inGeoTemporalPolygon(String fieldName, Date lowerDate, Date upperDate, Coordinates... coordinates) {
        return OperatorInGeographicalTemporalPolygon.newOperatorInGeographicalTemporalPolygon(fieldName, lowerDate, upperDate, coordinates);
    }

    public static FilterOperator inGeoTemporalBox(String fieldName, Date lowerDate, Date upperDate, Coordinates lowerBoundPoint, Coordinates upperBoundPoint) {
        return OperatorInGeographicalTemporalBox.newOperatorInGeographicalTemporalBox(fieldName, lowerDate, upperDate, lowerBoundPoint, upperBoundPoint);
    }


}
