package at.fhhgb.mtd.gop.veccy.feature;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.scene.paint.Color;

public class LineFeature implements NamedFeature {
    private CanvasModel model;
    private boolean selected;
    private Line currentLine = null;


    public LineFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "|";
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
        if (this.selected && currentLine != null) {
            currentLine = null;
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (this.selected) {
            if (currentLine == null) {
                currentLine = new Line(i, i1, i, i1);
                currentLine.setFillColor(model.getCurrentFillColor());
                currentLine.setStrokeColor(model.getCurrentStrokeColor());
                model.addShape(currentLine);
            } else {
                currentLine.setX2(i);
                currentLine.setY2(i1);
            }
        }
    }
}
