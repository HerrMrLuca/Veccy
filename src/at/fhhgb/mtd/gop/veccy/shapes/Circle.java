package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Circle extends Shape {
    private int r;
    private int smoothness = 128;

    public Circle() {
        this(0,0, 10);
    }

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    public Circle(int x, int y, int r, Color c) {
        this(x, y, r);
        super.setFillColor(c);
        super.setStrokeColor(c);
    }

    public Circle(Circle circle) {
        this(circle.getX(), circle.getY(), circle.getR());
    }


    public int area() {
        return (int) Math.round(r * r * Math.PI);
    }

    public Rectangle boundingBox() {
        return new Rectangle(getX() - r, getY() - r, r * 2, r * 2);
    }

    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }

    private double[][] getCoordinates() {
        Vector3[] vecArray = new Vector3[smoothness];

        for (int i = 0; i < smoothness; i++) {
            int x = (int) (this.getR() * Math.cos(Math.PI / smoothness * i * 2)) + super.getX();
            int y = (int) (this.getR() * Math.sin(Math.PI / smoothness * i * 2)) + super.getY();
            vecArray[i] = new Vector3(new double[] {x, y, 1.0});
        }

        Matrix3 center = TransformFactory.createTranslation(-getX(), -getY());
        Matrix3 back = TransformFactory.createTranslation(getX(), getY());

        double[][] c = new double[2][vecArray.length];

        if (super.transform != null) {
            for (int j = 0; j < c[1].length; j++) {
                c[0][j] = back.mult(super.transform.mult(center.mult(vecArray[j]))).getValues()[0];
                c[1][j] = back.mult(super.transform.mult(center.mult(vecArray[j]))).getValues()[1];
            }
        } else {
            for (int i = 0; i < c[1].length; i++) {
                c[0][i] = vecArray[i].getValues()[0];
                c[1][i] = vecArray[i].getValues()[1];
            }
        }

        return c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Circle c) {
            return this.getX() == c.getX() && this.getY() == c.getY() && this.getR() == c.getR();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), r);
    }

    /** Make the values to a string */
    public String toString() {
        String str;

        str = "x = " + getX() + ", y = " + getY() + ", r = " + this.r + ", c = " + super.fillColor;

        return str;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public int getSmoothness() {
        return smoothness;
    }

    public void setSmoothness(int s) {
        this.smoothness = s;
    }
}
