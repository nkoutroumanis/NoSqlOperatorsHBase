package gr.unipi.ptixiaki.filterOperator;

import gr.unipi.ptixiaki.filterOperator.comparisonOperator.*;
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

}
