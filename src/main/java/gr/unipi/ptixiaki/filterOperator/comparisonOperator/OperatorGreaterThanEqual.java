package gr.unipi.ptixiaki.filterOperator.comparisonOperator;

import java.util.Date;

public class OperatorGreaterThanEqual extends ComparisonOperator {

    private OperatorGreaterThanEqual(String fieldName, Date fieldValue) {
        super(fieldName, fieldValue);
    }

    public static OperatorGreaterThanEqual newOperatorGreaterThanEqual(String fieldName, Date fieldValue) {
        return new OperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    YYY getYYY(){

    }

    @Override
    protected String getOperatorJsonField() {
        return "gte";
    }

}
