package gr.unipi.ptixiaki.filterOperator.geographicalOperator;

import java.util.ArrayList;
import java.util.Collections;

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
    YYY getYYY() {


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

        //if our search values are outside of our data set stop the range search
        if ((X1 < minX && X2 < minX) || (X1 > maxX && X2 > maxX)) {
            System.out.println("Wrong range inputs for X. X is out of range.");
            return;
        }
        if ((Y1 < minY && Y2 < minY) || (Y1 > maxY && Y2 > maxY)) {
            System.out.println("Wrong range inputs for Y. Y is out of range.");
            return;
        }
        if ((Z1 < minZ && Z2 < minZ) || (Z1 > maxZ && Z2 > maxZ)) {
            System.out.println("Wrong range inputs for Z. Z is out of range.");
            return;
        }
        //1.if the given search value is smaller than the values in our data set, start from the smallest value of our data set
        //2.if the given search value is bigger than the values in our data set, start from the maximum value of our data set
        if (X1 < minX) {
            X1 = minX;
            System.out.println("X1 number too small. Lowest value in the dataset for X1 was " + minX + " . Setting value for X1 to " + minX);
        }
        if (X2 > maxX) {
            X2 = maxX;
            System.out.println("X2 number too big. Biggest value in the dataset for X2 was " + maxX + " . Setting value for X2 to " + maxX);
        }
        if (Y1 < minY) {
            Y1 = minY;
            System.out.println("Y1 number too small. Lowest value in the dataset for Y1 was " + minY + " . Setting value for Y1 to " + minY);
        }
        if (Y2 > maxY) {
            Y2 = maxY;
            System.out.println("Y2 number too big. Biggest value in the dataset for Y2 was " + maxY + " . Setting value for Y2 to " + maxY);
        }
        if (Z1 < minZ) {
            Z1 = minZ;
            System.out.println("Z1 number too small. Lowest value in the dataset for Z1 was " + minZ + " . Setting value for Z1 to " + minZ);
        }
        if (Z2 > maxZ) {
            Z2 = maxZ;
            System.out.println("Z2 number too big. Biggest value in the dataset for Z2 was " + maxZ + " . Setting value for Z2 to " + maxZ);
        }
        //finished checking if the range input is valid

        //find the cells where our values in (x1,x2) (y1,y2) (z1,z2) belong
        int power = (int) Math.pow(2, bitNum);

        int startCellX = (int) ((((X1 - minX) * (power - 1)) / (maxX - minX)));
        int startCellY = (int) ((((Y1 - minY) * (power - 1)) / (maxY - minY)));
        int startCellZ = (int) ((((Z1 - minZ) * (power - 1)) / (maxZ - minZ)));


        int endCellX = (int) Math.floor((((X2 - minX) * (power - 1)) / (maxX - minX)));
        int endCellY = (int) Math.floor((((Y2 - minY) * (power - 1)) / (maxY - minY)));
        int endCellZ = (int) Math.floor((((Z2 - minZ) * (power - 1)) / (maxZ - minZ)));


        int numOfCellsX = (endCellX - startCellX) + 1; /////////// <-------- added +1 last value was not showing because x2-x1 takes out the first value
        int numOfCellsY = (endCellY - startCellY) + 1;
        int numOfCellsZ = (endCellZ - startCellZ) + 1;


        System.out.println(power + "       " + ((startCellX)) + "   " + startCellY + "   " + startCellZ + "   " + "startCell");
        System.out.println(power + "       " + ((endCellX)) + "   " + endCellY + "   " + endCellZ + "   " + "endCell");
        System.out.println(power + "       " + ((numOfCellsX)) + "   " + numOfCellsY + "   " + numOfCellsZ + "   " + "numOfCells");


        long[] x = new long[numOfCellsX];
        long[] y = new long[numOfCellsY];
        long[] z = new long[numOfCellsZ];

        ArrayList<Long> mortonGuess = new ArrayList<Long>();

        for (int i = 0; i < x.length; i++) {
            x[i] = startCellX + i; // find all cells of x,y,z of our range query and save to indexes
            //System.out.println(x[i]);
        }
        for (int j = 0; j < y.length; j++) {
            y[j] = startCellY + j;
            //System.out.println(y[j]);
        }
        for (int k = 0; k < z.length; k++) {
            z[k] = startCellZ + k;
            //System.out.println(z[k]);
        }

        System.out.println("Hello!!!");
        //finished checking if the range input is valid
        /*
         */
        /*
         */

        int count = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                for (int k = 0; k < z.length; k++) {
                    //System.out.println("Packing");
                    long pack = m.pack(x[i], y[j], z[k]);
                    mortonGuess.add(pack);
                    //System.out.println("X "+x[i]+" Y "+y[j]+" Z "+z[k]+" packing... "+pack);
                    //System.out.println("Test Element :"+mortonGuess.get(count));
                }
            }
        }
        System.out.println("*************\n*************\n*************\n*************\n*************\n");

        Collections.sort(mortonGuess);  //sort the list

        //System.out.println(mortonGuess);

        //find number ranges
        ArrayList<ConsecutiveNumbers> dataStorageList = new ArrayList<>();

        long currentValue;
        long nextValue;
        int counter = 0;

        for (int i = 0; i < mortonGuess.size(); i++) {

            long startValue = mortonGuess.get(i);
            long endValue = mortonGuess.get(i);
            currentValue = startValue;

            for (int j = i + 1; j < mortonGuess.size(); j++) {
                nextValue = mortonGuess.get(j);

                //System.out.println(" i = " + i + " currentValue = " + currentValue + " nextValue = " + nextValue);

                if (nextValue - currentValue == 1) {
                    endValue = nextValue;
                    currentValue = nextValue;
                    i = j;
                } else if (nextValue == currentValue) {
                    i = j;
                } else {
                    i = j - 1;
                    break;
                }
                //System.out.println();


            }
            counter++;

            //System.out.println(" i = " + i + " startValue = " + startValue + " endValue = " + endValue);
            //System.out.println("------------------------Create object from : "+startValue+" to "+endValue+"------------------------");
            ConsecutiveNumbers consecutive = new ConsecutiveNumbers(startValue, endValue);
            dataStorageList.add(consecutive);

        }

        System.out.println("Counter = " + counter);

    }


}
