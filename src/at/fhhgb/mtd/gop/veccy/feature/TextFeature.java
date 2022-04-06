package at.fhhgb.mtd.gop.veccy.feature;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Text;
import at.fhhgb.mtd.gop.veccy.view.BlockingTextInputDialog;

public class TextFeature implements NamedFeature {
    private CanvasModel model;
    private boolean selected;
    private Text currentText = null;
    private String text;

    public TextFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "T";
    }

    @Override
    public void onSelect() {
        this.selected = true;
        text = BlockingTextInputDialog.requestTextInput();
    }

    @Override
    public void onDeselect() {
        this.selected = false;
        if (currentText != null) {
            currentText = null;
        }
    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (this.selected) {
            if (text != null) {
                currentText = new Text(i, i1, text, 20);
                currentText.setFillColor(model.getCurrentFillColor());
                currentText.setStrokeColor(model.getCurrentStrokeColor());
                model.addShape(currentText);
            }
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}
