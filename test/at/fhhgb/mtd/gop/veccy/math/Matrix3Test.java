package at.fhhgb.mtd.gop.veccy.math;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Matrix3Test {

    @Test
    public void testMult() {
        double[][] m1 = {{6.0,7.0,8.0},{2.0,5.0,3.0},{7.0,1.0,2.0}};
        Matrix3 matrixOne = new Matrix3(m1);

        double[][] m2 = {{2.0,1.0,3.0},{5.0,4.0,3.0},{2.0,2.0,2.0}};
        Matrix3 matrixTwo = new Matrix3(m2);

        matrixOne = matrixOne.mult(matrixTwo);

        double[][] m3 = {{63.0,50.0,55.0},{35.0,28.0,27.0},{23.0,15.0,28.0}};
        Matrix3 matrixSolution = new Matrix3(m3);
        assertTrue(Arrays.deepEquals(matrixSolution.getValues(), matrixOne.getValues()));
    }

    @Test
    public void testVectorMult() {
        double[][] m2 = {{2.0,7.0,35.0},{2.0,2.0,1.0},{0.0,21.0,9.0}};
        Matrix3 matrixOne = new Matrix3(m2);

        double[] v1 = {5.0,23.0,7.0};
        Vector3 vectorOne = new Vector3(v1);

        vectorOne = matrixOne.mult(vectorOne);

        double[] v2 = {416.0, 63.0, 546.0};
        Vector3 vectorSolution = new Vector3(v2);
        assertArrayEquals(vectorSolution.getValues(), vectorOne.getValues());
    }
}
