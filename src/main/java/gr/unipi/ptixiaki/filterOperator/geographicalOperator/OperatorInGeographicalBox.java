package gr.unipi.ptixiaki.filterOperator.geographicalOperator;

import org.apache.hadoop.hdfs.server.datanode.DataStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperatorInGeographicalBox extends GeographicalOperatorBasedOnPoints {

    private OperatorInGeographicalBox(String fieldName, Coordinates lowerBound, Coordinates upperBound) {
        super(fieldName, lowerBound, Coordinates.newCoordinates(upperBound.getLongitude(), lowerBound.getLatitude()), upperBound, Coordinates.newCoordinates(lowerBound.getLongitude(), upperBound.getLatitude()));
    }

    public Coordinates getLowerBound(){
        return getCoordinatesArray()[0];
    }

    public Coordinates getUpperBound(){
        return getCoordinatesArray()[2];
    }

    public static OperatorInGeographicalBox newOperatorInGeographicalBox(String fieldName, Coordinates lowerBound, Coordinates upperBound) {
        return new OperatorInGeographicalBox(fieldName, lowerBound, upperBound);
    }

    @Override
    public List<DataStorage> getDataStorage() {


        getLowerBound().getLongitude()
        getUpperBound().getLongitude()


        Morton64 m = new Morton64(3, (long) bitNum);

        //X1 , X2 SEARCH LONGITUDE  FROM X1 TO X2
        //Y1 , Y2 SEARCH LATITUDE   FROM Y1 TO Y2
        //Z1 , Z2 SEARCH TIME       FROM Z1 TO Z2


        float minX = 0;
        float maxX = 398;
        float minY = 0;
        float maxY = 398;
        float minZ = 0;
        float maxZ = 398;


    }//returns list ofkeyvalues to be retuned



}
