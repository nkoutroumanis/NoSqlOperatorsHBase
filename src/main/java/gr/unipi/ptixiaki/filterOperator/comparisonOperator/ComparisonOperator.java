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

    protected abstract String getOperatorJsonField();

    @Override
    public StringBuilder getJsonStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if (!getFieldName().contains(".")) {
            sb.append(getFieldName());
        } else {
            sb.append("\"" + getFieldName() + "\"");
        }

        sb.append(": { $");
        sb.append(getOperatorJsonField());
        sb.append(": ");

        if ((getFieldValue().getClass() == String.class)) {
            sb.append("\"" + getFieldValue() + "\"");
        } else if ((getFieldValue().getClass() == Date.class)) {


            sb.append("new Date(\"" + new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z").format(getFieldValue()) + "\")");
        } else {
            sb.append("\"" + getFieldValue() + "\"");
        }

        sb.append("} }");

        return sb;

    }
}
