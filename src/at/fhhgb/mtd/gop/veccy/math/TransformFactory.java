package at.fhhgb.mtd.gop.veccy.math;

public class TransformFactory {

    /** create Matrix3 for moving the object (x, y) */
    public static Matrix3 createTranslation(int deltaX, int deltaY) {
        return new Matrix3(new double[][] {{1.0, 0.0, deltaX}, {0.0, 1.0, deltaY}, {0.0, 0.0, 1.0}});
    }

    /** create Matrix3 for rotating the object (radiant) */
    public static Matrix3 createRotation(double radians) {
        return new Matrix3(new double[][] {{Math.cos(radians), -Math.sin(radians), 0.0}, {Math.sin(radians), Math.cos(radians), 0.0}, {0.0, 0.0, 1.0}});
    }

    /** create Matrix3 for mirror the object horizontal () */
    public static Matrix3 createHorizontalMirroring() {
        return new Matrix3(new double[][] {{1.0, 0.0, 0.0}, {0.0, -1.0, 0.0}, {0.0, 0.0, 1.0}});
    }

    /** create Matrix3 for mirror the object vertical () */
    public static Matrix3 createVerticalMirroring() {
        return new Matrix3(new double[][] {{-1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}});
    }

    /** create Matrix3 for scaling the object (x, y) */
    public static Matrix3 createScaling(double factorX, double factorY) {
        return new Matrix3(new double[][] {{factorX, 0.0, 0.0}, {0.0, factorY, 0.0}, {0.0, 0.0, 1.0}});
    }
}
