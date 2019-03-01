import gr.unipi.ptixiaki.filterOperator.FilterOperators;
import gr.unipi.ptixiaki.filterOperator.geographicalOperator.Coordinates;
import gr.unipi.ptixiaki.nosqldb.NoSqlDbSystem;

public class SpatialExample {

    public static void main(String args[]) {

        NoSqlDbSystem n = NoSqlDbSystem.HBase().host("").database("").port(1).username("").password("").build();
        n.operateOn("aTable").filter(FilterOperators.inGeoBox("column", Coordinates.newCoordinates(23, 35), Coordinates.newCoordinates(23.5, 35.5))).printScreen();
        ;
        n.closeConnection();

    }

}
