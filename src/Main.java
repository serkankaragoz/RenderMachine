// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.



import javafx.util.Pair;

import java.util.List;

public class Main {

    public static final int HALF_SCREEN_SIZE = 30;
    public static final int SCREEN_SIZE = 2*HALF_SCREEN_SIZE+1;
    // plus 1 stands for origin point


    public static Pair<Double, Double> projection(Point point, double screenLocation, double eyeLocation){
        double y = point.y * (eyeLocation - screenLocation) / (eyeLocation - point.x);
        double z = point.z * (eyeLocation - screenLocation) / (eyeLocation - point.x);

        return new Pair<Double, Double>(y, z);
    }

    public static void rotateOnZAxis(Point point, double angle){

        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);

        double[][] simplifiedRotatonMatrix =
                new double[][]
                        {{cosA, -sinA},
                        {sinA, cosA}};

        double[] xyMatrix = new double[]{point.x, point.y};
        double[] newXY = new double[]{0, 0};

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2;j++){
                newXY[i] += xyMatrix[j] * simplifiedRotatonMatrix[i][j];
            }
        }

        point.x = newXY[0];
        point.y = newXY[1];

    }

    public static void drawLine(boolean[][] screen, Pair<Double, Double> proj1, Pair<Double, Double> proj2){
    }

    public static int yToArrayIndex(int y){
        return y + HALF_SCREEN_SIZE;
    }

    public static int zToArrayIndex(int z){
        return HALF_SCREEN_SIZE - z;
    }

    public static void rotateAllOnZAxis(List<Point> vertexList, double angle){
        for (Point point : vertexList) {
            rotateOnZAxis(point, angle);
        }
    }


    public static void main(String[] args) {
        Point[] vertexList = {
                new Point(2, 2, 2),
                new Point(-2, 2, 2),
                new Point(-2, -2, 2),
                new Point(2, -2, 2),
                new Point(2, 2, -2),
                new Point(-2, 2, -2),
                new Point(-2, -2, -2),
                new Point(2, -2, -2),
        };

        Pair<Double, Double>[] edgeList = new Pair[]{
                new Pair<Double, Double>(0.0, 1.0),
                new Pair<Double, Double>(1.0, 2.0),
                new Pair<Double, Double>(2.0, 3.0),
                new Pair<Double, Double>(3.0, 0.0),
                new Pair<Double, Double>(0.0, 4.0),
                new Pair<Double, Double>(1.0, 5.0),
                new Pair<Double, Double>(2.0, 6.0),
                new Pair<Double, Double>(3.0, 7.0),
                new Pair<Double, Double>(4.0, 5.0),
                new Pair<Double, Double>(5.0, 6.0),
                new Pair<Double, Double>(6.0, 7.0),
                new Pair<Double, Double>(7.0, 4.0),
        };

        Point p = vertexList[0];
        Pair projections = projection(p, 5, 10);

        System.out.println(projections.getKey() +  ", " + projections.getValue());


        rotateOnZAxis(p, Math.PI/2);

        System.out.println(p.toString());

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                System.out.print("O");
            }
            System.out.println();
        }

    }


}