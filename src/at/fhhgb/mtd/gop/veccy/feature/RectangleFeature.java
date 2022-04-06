package at.fhhgb.mtd.gop.veccy.feature;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.scene.paint.Color;

import java.awt.*;

public class RectangleFeature implements NamedFeature {
    private CanvasModel model;
    private boolean selected;
    private Rectangle currentRectangle = null;
    private int originX, originY = 0;

    public RectangleFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "█";
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
        if (this.selected && currentRectangle != null) {
            currentRectangle = null;
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.selected) {
            if (currentRectangle == null) {
                currentRectangle = new Rectangle(i, i1, 0, 0);
                originX = i;
                originY = i1;
                currentRectangle.setFillColor(model.getCurrentFillColor());
                currentRectangle.setStrokeColor(model.getCurrentStrokeColor());
                model.addShape(currentRectangle);
            } else {
                currentRectangle.setWidth(i - originX);
                currentRectangle.setHeight(i1 - originY);
            }
        }
    }
}
