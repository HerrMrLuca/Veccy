package at.fhhgb.mtd.gop.veccy.feature;

import at.fhhgb.mtd.gop.veccy.math.Vector3;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Point;

public class ClearFeature implements NamedFeature {
    private CanvasModel model;

    public ClearFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "\uD83E\uDDFC";
    }

    @Override
    public void onSelect() {
        model.clearShapes();
    }

    @Override
    public void onDeselect() {

    }

    @Override
    public void onMouseClick(int i, int i1) {

    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}
