package at.fhhgb.mtd.gop.veccy.feature;

import at.fhhgb.mtd.gop.veccy.math.Vector3;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.scene.paint.Color;

public class PointFeature implements NamedFeature {
    private CanvasModel model;
    private boolean selected;
    private Point currentPoint = null;

    public PointFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "•";
    }

    @Override
    public void onSelect() {
        this.selected = true;
    }

    @Override
    public void onDeselect() {
        this.selected = false;
    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (this.selected && currentPoint != null) {
            currentPoint = null;
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.selected) {
            if (currentPoint == null) {
                currentPoint = new Point(i, i1);
                currentPoint.setFillColor(model.getCurrentFillColor());
                currentPoint.setStrokeColor(model.getCurrentStrokeColor());
                model.addShape(currentPoint);
            } else {
                currentPoint.setPosition(new Vector3(new double[] {i, i1, 0}));
            }
        }
    }
}
