package at.fhhgb.mtd.gop.veccy.feature;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Path;

public class PathFeature implements NamedFeature {
    private CanvasModel model;
    private boolean selected;
    private Path currentPath = null;

    public PathFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "✩";
    }

    @Override
    public void onSelect() {
        this.selected = true;
    }

    @Override
    public void onDeselect() {
        this.selected = false;
        if (currentPath != null) {
            currentPath = null;
        }
    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (this.selected && currentPath == null) {
            currentPath = new Path(i, i1);
            currentPath.setStrokeColor(model.getCurrentStrokeColor());
            model.addShape(currentPath);
            currentPath.addPoint(i, i1, currentPath.getAmount());
        }

        if (this.selected && currentPath != null) {
            currentPath.addPoint(i, i1, currentPath.getAmount());
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }

}
