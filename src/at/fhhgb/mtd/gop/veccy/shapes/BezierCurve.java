package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import java.util.Objects;

public class BezierCurve extends Shape {
    ArrayList<Point2D.Float> controlPoints = new ArrayList<>();
    ArrayList<Point2D.Float> curvePoints = new ArrayList<>();
    public int amount = 0;

    public BezierCurve() {
        this(0,0);
    }


    public BezierCurve(Polygon r) {
        this(r.getX(), r.getY());
    }

    public BezierCurve(int x, int y, Color c) {
        this(x,y);
        super.setFillColor(c);
        super.setStrokeColor(c);
    }

    public BezierCurve(int x, int y) {
        super(x, y);
    }

    public void draw(GraphicsContext graphicsContext) {
        curvePoints.clear();
        bezierCurve();
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        //graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
//        for (int i = 0; i < controlPoints.size(); i++) {
//            if (i % 2 != 0 && i + 1 < controlPoints.size()) {
//                graphicsContext.strokeLine(controlPoints.get(i).x, controlPoints.get(i).y, controlPoints.get(i - 1).x, controlPoints.get(i - 1).y);
//                graphicsContext.strokeLine(controlPoints.get(i).x, controlPoints.get(i).y, controlPoints.get(i + 1).x, controlPoints.get(i + 1).y);
//            }
//
//        }
    }

    public void addPoint(int x, int y) {
        this.controlPoints.add(new Point2D.Float((float) x, (float) y));
        this.amount++;
    }

    public void addPoint(int x, int y, int index) {
        this.controlPoints.add(index, new Point2D.Float((float) x, (float) y));
        this.amount++;
    }

    private double[][] getCoordinates() {
        Vector3[] vecArray = new Vector3[this.curvePoints.size()];


        for (int i = 0; i < vecArray.length; i++) {
            vecArray[i] = new Vector3(new double[] {this.getCurvePoints().get(i).x, this.getCurvePoints().get(i).y, 1.0});
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
        StringBuilder str = new StringBuilder("Bezier @ ");
        for (int i = 0; i < controlPoints.size(); i++) {
            str.append("x = ").append(controlPoints.get(i).x).append(", ");
            str.append("y = ").append(controlPoints.get(i).y).append(", ");
        }
        str.append("c = ").append(super.fillColor).append(", amount = ").append(curvePoints.size());
        return String.valueOf(str);
    }


    public void bezierCurve() {
        for (float i = 0; i <  1; i += 0.005) {
            curvePoints.add(getControlPoints(i));
        }
    }

    public Point2D.Float getControlPoints(float t) {
        ArrayList<Point2D.Float> tempPoints2 = new ArrayList<>();

        //int n = 3;
        int n = controlPoints.size();
        //int m = controlPoints.size() - n;

        for (int i = 0; i <  n; i++) {
            Point2D.Float p = new Point2D.Float(controlPoints.get(i).x, controlPoints.get(i).y);

            tempPoints2.add(i,p);
        }

        for (int k = 0; k < n - 1; k++) {
            for (int i = 0; i < n - 1 - k; i++) {
                tempPoints2.get(i).x = t * tempPoints2.get(i).x + (1 - t) * tempPoints2.get(i + 1).x;
                tempPoints2.get(i).y = t * tempPoints2.get(i).y + (1 - t) * tempPoints2.get(i + 1).y;
            }
        }
        return tempPoints2.get(0);
    }

    public ArrayList<Point2D.Float> getControlPoints() {
        return controlPoints;
    }

    public ArrayList<Point2D.Float> getCurvePoints() {
        return curvePoints;
    }
}

