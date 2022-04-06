package at.fhhgb.mtd.gop.veccy.math;

public class Matrix3 {
    private double[][] values = {
            {1.0, 0.0, 0.0},
            {0.0, 1.0, 0.0},
            {0.0, 0.0, 1.0}
    };

    /** Construct a new Matrix3 with no values */
    public Matrix3() {
    }

    /** Construct a new Matrix3 with a double[][] */
    public Matrix3(double[][] values) {
        this.values = values;
    }

    /** Construct a new Matrix3 with a Matrix3 */
    public Matrix3(Matrix3 matrix) {
        this.values = matrix.values;
    }

    /** Multiplication between this.Matrix3 and a second Matrix3 */
    public Matrix3 mult(Matrix3 matrix) {
        Matrix3 mult = new Matrix3();
        mult.values[0][0] =  this.values[0][0] * matrix.values[0][0] + this.values[0][1] * matrix.values[1][0] + this.values[0][2] * matrix.values[2][0];
        mult.values[0][1] =  this.values[0][0] * matrix.values[0][1] + this.values[0][1] * matrix.values[1][1] + this.values[0][2] * matrix.values[2][1];
        mult.values[0][2] =  this.values[0][0] * matrix.values[0][2] + this.values[0][1] * matrix.values[1][2] + this.values[0][2] * matrix.values[2][2];

        mult.values[1][0] =  this.values[1][0] * matrix.values[0][0] + this.values[1][1] * matrix.values[1][0] + this.values[1][2] * matrix.values[2][0];
        mult.values[1][1] =  this.values[1][0] * matrix.values[0][1] + this.values[1][1] * matrix.values[1][1] + this.values[1][2] * matrix.values[2][1];
        mult.values[1][2] =  this.values[1][0] * matrix.values[0][2] + this.values[1][1] * matrix.values[1][2] + this.values[1][2] * matrix.values[2][2];

        mult.values[2][0] =  this.values[2][0] * matrix.values[0][0] + this.values[2][1] * matrix.values[1][0] + this.values[2][2] * matrix.values[2][0];
        mult.values[2][1] =  this.values[2][0] * matrix.values[0][1] + this.values[2][1] * matrix.values[1][1] + this.values[2][2] * matrix.values[2][1];
        mult.values[2][2] =  this.values[2][0] * matrix.values[0][2] + this.values[2][1] * matrix.values[1][2] + this.values[2][2] * matrix.values[2][2];
        return mult;
    }

    /** Multiplication between this.Matrix3 and a Vector3 */
    public Vector3 mult(Vector3 vector) {

        Vector3 mult = new Vector3();
        double v[] = vector.getValues();
        double m[] = mult.getValues();

        m[0] =  this.values[0][0] * v[0] + this.values[0][1] * v[1] + this.values[0][2] * v[2];
        m[1] =  this.values[1][0] * v[0] + this.values[1][1] * v[1] + this.values[1][2] * v[2];
        m[2] =  this.values[2][0] * v[0] + this.values[2][1] * v[1] + this.values[2][2] * v[2];
        return new Vector3(m);
    }

    /** Return the values */
    public double[][] getValues() {
        return this.values;
    }

    /** Print the values in the console */
    public void printValues() {
        double[][] m1 = this.getValues();
        System.out.println("Matrix3: ");
        System.out.print("{" + m1[0][0] + ", ");
        System.out.print(m1[0][1] + ", ");
        System.out.println(m1[0][2] + "}");
        System.out.print("{" + m1[1][0] + ", ");
        System.out.print(m1[1][1] + ", ");
        System.out.println(m1[1][2] + "}");
        System.out.print("{" + m1[2][0] + ", ");
        System.out.print(m1[2][1] + ", ");
        System.out.println(m1[2][2] + "}");
    }
}
