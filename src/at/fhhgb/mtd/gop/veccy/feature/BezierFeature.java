package at.fhhgb.mtd.gop.veccy.feature;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.*;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Polygon;

import java.awt.*;

public class BezierFeature implements NamedFeature {
    private CanvasModel model;
    private boolean selected;
    private BezierCurve currentBezier = null;
    private int originX, originY = 0;
    private int extraPointsX, extraPointsY, extraPointsX2, extraPointsY2;
    private int calculateX, calculateY;
    private Point currentPoint = null;

    public BezierFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "\uD83D\uDD8B";
    }

    @Override
    public void onSelect() {
        this.selected = true;
    }

    @Override
    public void onDeselect() {
        this.selected = false;
        if (currentBezier != null) {
            currentBezier.addPoint(originX, originY);
            currentBezier = null;
        }

    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (this.selected && currentBezier == null) {

            currentBezier = new BezierCurve(i, i1);
            currentBezier.addPoint(i, i1);
            originX = i;
            originY = i1;
            currentBezier.setFillColor(model.getCurrentFillColor());
            currentBezier.setStrokeColor(model.getCurrentStrokeColor());
            currentBezier.amount--;

        } else if (this.selected) {

//            currentPoint = new Point(i, i1);
//            currentPoint.setFillColor(model.getCurrentFillColor());
//            currentPoint.setStrokeColor(model.getCurrentStrokeColor());
//            model.addShape(currentPoint);
//            currentPoint = null;

            currentBezier.addPoint(i, i1);
            model.addShape(currentBezier);
            if (currentBezier.amount % 2 == 0) {
                if (currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 3).x > currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 1).x)  {
                    extraPointsX = (int)(( currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 3).x + currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 1).x) / 2);
                } else {
                    extraPointsX = (int)(( currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 1).x + currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 3).x) / 2);
                }
                if (currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 3).y > currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 1).y)  {
                    extraPointsY = (int)(( currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 3).y + currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 1).y) / 2);
                } else {
                    extraPointsY = (int)(( currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 1).y + currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 3).y) / 2);
                }

                calculateX = (int) (extraPointsX - currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 2).x);
                calculateY = (int) (extraPointsY - currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 2).y);



                extraPointsX = (int) currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 3).x - calculateX;
                extraPointsY = (int) currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 3).y - calculateY;
                extraPointsX2 = (int) currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 1).x - calculateX;
                extraPointsY2 = (int) currentBezier.getControlPoints().get(currentBezier.getControlPoints().size() - 1).y - calculateY;
//                model.addShape(new Circle(extraPointsX, extraPointsY, 10));
//                model.addShape(new Circle(extraPointsX2, extraPointsY2, 10));
//                model.addShape(new Line(extraPointsX, extraPointsY, extraPointsX2, extraPointsY2, 2));

                currentBezier.addPoint(extraPointsX, extraPointsY, currentBezier.getControlPoints().size() - 2);

                currentBezier.addPoint(extraPointsX2, extraPointsY2, currentBezier.getControlPoints().size() - 1);

                currentBezier.amount -= 2;
            }
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }

}
