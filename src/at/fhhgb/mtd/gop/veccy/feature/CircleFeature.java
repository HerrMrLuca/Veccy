package at.fhhgb.mtd.gop.veccy.feature;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.scene.paint.Color;

public class CircleFeature implements NamedFeature {
    private CanvasModel model;
    private boolean selected;
    private Circle currentCircle = null;
    private int originX, originY = 0;

    public CircleFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "⚫";
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
        if (this.selected && currentCircle != null) {
            currentCircle = null;
        }
     }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.selected) {
            if (currentCircle == null) {
                currentCircle = new Circle(i, i1, 0);
                originX = i;
                originY = i1;
                currentCircle.setFillColor(model.getCurrentFillColor());
                currentCircle.setStrokeColor(model.getCurrentStrokeColor());
                model.addShape(currentCircle);
            } else {
                currentCircle.setR((int) Math.sqrt((i - originX) * (i - originX) + (i1 - originY) * (i1 -
                        originY)));
            }
        }
    }
}
