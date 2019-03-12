import gr.unipi.ptixiaki.filterOperator.FilterOperators;
import gr.unipi.ptixiaki.filterOperator.geographicalOperator.Coordinates;
import gr.unipi.ptixiaki.nosqldb.NoSqlDbSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static gr.unipi.ptixiaki.filterOperator.FilterOperators.gte;
import static gr.unipi.ptixiaki.filterOperator.FilterOperators.lte;

public class SpatiotemporalExample {
    public static void main(String args[]) throws ParseException {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Date d1 = s.parse("2017-12-01T00:00:00.000Z");
        Date d2 = s.parse("2017-12-02T23:59:59.999Z");

        NoSqlDbSystem n = NoSqlDbSystem.HBase().host("").database("").port(1).username("").password("").build();
        n.operateOn("aTable").filter(FilterOperators.inGeoBox("column", Coordinates.newCoordinates(23, 35), Coordinates.newCoordinates(23.5, 35.5))).printScreen();
        n.closeConnection();


    }
}
