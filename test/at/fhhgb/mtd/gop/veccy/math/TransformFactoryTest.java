package at.fhhgb.mtd.gop.veccy.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransformFactoryTest {

    @Test
    void createTranslation() {
        Vector3 vec = new Vector3(new double[] {5.0, 5.0, 1.0});
        Vector3 vectorSolution = new Vector3(new double[] {7.0, 8.0, 1.0});
        Matrix3 translation = TransformFactory.createTranslation(2, 3);
        Vector3 transformedVec = translation.mult(vec);
        assertArrayEquals(vectorSolution.getValues(), transformedVec.getValues());
    }

    @Test
    void createRotation() {
        Vector3 vec = new Vector3(new double[] {5.0, 5.0, 1.0});
        Vector3 vectorSolution = new Vector3(new double[] {0.0, 7.071, 1.0});
        Matrix3 rotation = TransformFactory.createRotation(Math.toRadians(45));
        Vector3 transformedVec = rotation.mult(vec);
        assertArrayEquals(vectorSolution.getValues(), transformedVec.getValues(), 0.01);
    }

    @Test
    void createHorizontalMirroring() {
        Vector3 vec = new Vector3(new double[] {5.0, 5.0, 1.0});
        Vector3 vectorSolution = new Vector3(new double[] {5.0, -5.0, 1.0});
        Matrix3 mirror = TransformFactory.createHorizontalMirroring();
        Vector3 transformedVec = mirror.mult(vec);
        assertArrayEquals(vectorSolution.getValues(), transformedVec.getValues());
    }

    @Test
    void createVerticalMirroring() {
        Vector3 vec = new Vector3(new double[] {5.0, 5.0, 1.0});
        Vector3 vectorSolution = new Vector3(new double[] {-5.0, 5.0, 1.0});
        Matrix3 mirror = TransformFactory.createVerticalMirroring();
        Vector3 transformedVec = mirror.mult(vec);
        assertArrayEquals(vectorSolution.getValues(), transformedVec.getValues());
    }

    @Test
    void createScaling() {
        Vector3 vec = new Vector3(new double[] {5.0, 5.0, 1.0});
        Vector3 vectorSolution = new Vector3(new double[] {10.0, 10.0, 1.0});
        Matrix3 scale = TransformFactory.createScaling(2, 2);
        Vector3 transformedVec = scale.mult(vec);
        assertArrayEquals(vectorSolution.getValues(), transformedVec.getValues());
    }
}