package at.fhhgb.mtd.gop.veccy.feature;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Polygon;

public class PolygonFeature implements NamedFeature {
    private CanvasModel model;
    private boolean selected;
    private Polygon currentPolygon = null;

    public PolygonFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "★";
    }

    @Override
    public void onSelect() {
        this.selected = true;
    }

    @Override
    public void onDeselect() {
        this.selected = false;
        if (currentPolygon != null) {
            currentPolygon = null;
        }
    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (this.selected && currentPolygon == null) {
            currentPolygon = new Polygon(i, i1);
            currentPolygon.setFillColor(model.getCurrentFillColor());
            currentPolygon.setStrokeColor(model.getCurrentStrokeColor());
            model.addShape(currentPolygon);
            currentPolygon.addPoint(i, i1, currentPolygon.getAmount());
        }

        if (this.selected && currentPolygon != null) {
            currentPolygon.addPoint(i, i1, currentPolygon.getAmount());
            System.out.println(currentPolygon);
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }

}
