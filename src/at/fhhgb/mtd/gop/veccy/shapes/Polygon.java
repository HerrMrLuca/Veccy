package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Polygon extends Shape {
    private int[][] points = new int[2][128];
    private int amount = 0;

    public Polygon() {
        this(0,0);
    }


    public Polygon(Polygon r) {
        this(r.getX(), r.getY());
    }

    public Polygon(int x, int y, Color c) {
        this(x,y);
        super.setFillColor(c);
        super.setStrokeColor(c);
    }

    public Polygon(int x, int y) {
        super(x, y);
    }

    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }

    public int[][] getPoints() {
        return points;
    }

    public void setPoints(int[][] points) {
        this.points = points;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addPoint(int x, int y,int amount) {
        this.points[0][amount] = x;
        this.points[1][amount] = y;
        this.amount++;
    }

    private double[][] getCoordinates() {
        Vector3[] vecArray = new Vector3[amount];

        for (int i = 0; i < vecArray.length; i++) {
            vecArray[i] = new Vector3(new double[] {points[0][i], points[1][i], 1.0});
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
        if (obj instanceof Rectangle r) {
            return this.getX() == r.getX() && this.getY() == r.getY();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /** Make the values to a string */
    public String toString() {
        StringBuilder str = new StringBuilder("Polygone @ ");
        for (int i = 0; i < amount; i++) {
            str.append("x = ").append(points[0][i]);
            str.append("y = ").append(points[1][i]);
        }

        str.append("y = ").append(super.fillColor);
        return String.valueOf(str);
    }
}
