package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Rectangle extends Shape {
    private int width, height;

    public Rectangle() {
        this(0,0,10,10);
    }


    public Rectangle(Rectangle r) {
        this(r.getX(), r.getY());
        this.width = r.width;
        this.height = r.height;
    }


    public Rectangle(int x, int y, int width, int height) {
        this(x,y);
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int width, int height, Color c) {
        this(x,y);
        this.width = width;
        this.height = height;
        super.setFillColor(c);
        super.setStrokeColor(c);
    }

    public Rectangle(int x, int y) {
        super(x, y);
    }



    public int area() {
        return this.width * this.height;
    }

    public Rectangle boundingBox() {
        return new Rectangle(getX(), getY(), this.width, this.height);
    }

    public boolean isOverlapping(Rectangle other) {
        return getX() <= other.getX() + other.width && this.getX() + width >= other.getX() && getY() + height >= other.getY() && this.getY() <= other.getY() + other.height;
    }

    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private double[][] getCoordinates() {
        Vector3[] vecArray = new Vector3[4];

        vecArray[0] = new Vector3(new double[] {super.getX(), super.getY(), 1.0});
        vecArray[1] = new Vector3(new double[] {this.getWidth() + super.getX(), super.getY(), 1.0});
        vecArray[2] = new Vector3(new double[] {this.getWidth() + super.getX(), this.getHeight() + super.getY(), 1.0});
        vecArray[3] = new Vector3(new double[] {super.getX(), this.getHeight() + super.getY(), 1.0});

        Matrix3 center = TransformFactory.createTranslation(-getX() - this.getWidth() / 2, -getY() - this.getHeight() / 2);
        Matrix3 back = TransformFactory.createTranslation(getX() + this.getWidth() / 2, getY() + this.getHeight() / 2);

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
        if (obj instanceof Rectangle r) {
            return this.getX() == r.getX() && this.getY() == r.getY() && this.width == r.width && this.height == r.height;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }

    /** Make the values to a string */
    public String toString() {

        return "Rectangle @ " +
                "x = " + getX() +
                ", y = " + getY() +
                ", w = " + this.width +
                ", h = " + this.height +
                ", c = " + super.fillColor;
    }
}
