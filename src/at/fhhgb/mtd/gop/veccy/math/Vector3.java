package at.fhhgb.mtd.gop.veccy.math;

public class Vector3 {
    private double[] values;

    /** Construct a new Vector3 with no values */
    public Vector3() {
        this.values = new double[] { 0.0, 0.0, 1.0 };
    }

    /** Construct a new Vector3 with a new double[] */
    public Vector3(double[] values) {
        this.values = values;
    }

    /** Construct a new Vector3 with a Vector3 */
    public Vector3(Vector3 vector) {
        this.values = vector.getValues();
    }

    /** Return the values */
    public double[] getValues() {
        return this.values;
    }

    /** Print the values in the console */
    public void printValues() {
        double[] v = this.getValues();
        System.out.println("Vector3:");
        System.out.print("{" + v[0] + ", ");
        System.out.print(v[1] + ", ");
        System.out.println(v[2] + "}");
    }

}
