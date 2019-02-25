package gr.unipi.ptixiaki.filterOperator.comparisonOperator;

import java.util.Date;

public class OperatorLessThanEqual extends ComparisonOperator {

    private OperatorLessThanEqual(String fieldName, Date fieldValue) {
        super(fieldName, fieldValue);
    }

    public static OperatorLessThanEqual newOperatorLessThanEqual(String fieldName, Date fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    YYY getYYY(){

    }

    @Override
    protected String getOperatorJsonField() {
        return "lte";
    }


}
