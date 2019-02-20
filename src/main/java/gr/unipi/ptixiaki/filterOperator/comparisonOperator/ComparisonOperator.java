package gr.unipi.ptixiaki.filterOperator.comparisonOperator;

import gr.unipi.ptixiaki.filterOperator.FilterOperator;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ComparisonOperator implements FilterOperator {

    private final String fieldName;
    private final Date fieldValue;

    protected ComparisonOperator(String fieldName, Date fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Date getFieldValue() {
        return fieldValue;
    }
}
