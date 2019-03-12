package gr.unipi.ptixiaki.filterOperator.geographicalOperator;

import org.apache.hadoop.hdfs.server.datanode.DataStorage;

import java.util.List;

public class OperatorInGeographicalPolygon extends GeographicalOperatorBasedOnPoints {

    private OperatorInGeographicalPolygon(String fieldName, Coordinates... coordinates) {
        super(fieldName, coordinates);

    }

    public static OperatorInGeographicalPolygon newOperatorInGeographicalPolygon(String fieldName, Coordinates... coordinates) {
        return new OperatorInGeographicalPolygon(fieldName, coordinates);
    }

    @Override
    protected void checkCoordinates() {
        super.checkCoordinates();

        if (getCoordinatesArray().length < 3) {
            try {
                throw new Exception("Three points-coordinates should be defined at least for Polygon formation");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<DataStorage> getDataStorage() {

        for(Coordinates c : getCoordinatesArray()){

        }

    }

}
