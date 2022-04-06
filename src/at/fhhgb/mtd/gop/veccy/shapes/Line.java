package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Line extends Shape {
    private int x2;
    private int y2;
    private int w;

    public Line() {
        this(0,0, 10, 10, 1);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(x1, y1, x2, y2, 1);
    }

    public Line(int x1, int y1, int x2, int y2, int w) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
        this.w = w;
    }

    public Line(int x1, int y1, int x2, int y2, int w, Color c) {
        this(x1, y1, x2, y2, w);
        super.setStrokeColor(c);
    }

    public Line(int x1, int y1, int x2, int y2, Color c) {
        this(x1, y1, x2, y2);
        super.setStrokeColor(c);
    }

    public Line(Line l) {
        this(l.getX(), l.getX2(), l.getY(), l.getY2());
    }

    public Rectangle boundingBox () {
        int width, height;

        width = Math.abs(getX() - this.x2);
        height = Math.abs(getY() - this.y2);

        int x = Math.min(getX(),this.x2);
        int y = Math.min(getY(), this.y2);

        return new Rectangle(x,y, width, height);
    }

    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.setLineWidth(w);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.setLineWidth(1);
    }

    private double[][] getCoordinates() {
        Vector3[] vecArray = new Vector3[2];

        vecArray[0] = new Vector3(new double[] {super.getX(), super.getY(), 1.0});
        vecArray[1] = new Vector3(new double[] {getX2(), getY2(), 1.0});

        Matrix3 center = TransformFactory.createTranslation(-getX()  - (getX2() - getX()) / 2, -getY() - (getY2() - getY()) / 2);
        Matrix3 back = TransformFactory.createTranslation(getX() + (getX2() - getX()) / 2, getY() + (getY2() - getY()) / 2);

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
        if (obj instanceof Line l) {
            return this.getX() == l.getX() && this.getY() == l.getY() && this.getX2() == l.getX2() && this.getY2() == l.getY2();
        }
        return false;
    }

    /** Make the values to a string */
    public String toString() {
        String str;

        str = "x1 = " + getX() + ", y1 = " + getY() + ", x2 = " + this.x2 + ", y2 = " + this.y2 + ", c = " + super.fillColor;

        return str;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x2, y2, w);
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
