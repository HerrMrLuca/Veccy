package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.util.Locale;

public class Text extends Shape {
    private String text;
    private int size;
    public Text(int x, int y, String text, int size) {
        super(x, y);
        this.text = text;
        this.size = size;
    }

    public Text(int x, int y, String text) {
        this(x, y, text, 50);
    }



    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.setLineWidth(size / 10);
        for (int i = 0; i < text.length(); i++) {
            int letters = text.toLowerCase(Locale.ROOT).charAt(i) - 96;
            drawText(graphicsContext , letters, (int) ((size + size / 4) * i));
        }

    }

    public void drawText(GraphicsContext graphicsContext, int letter, int offset) {
        switch (letter) {
            case 1: graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 2  + offset, getY());
                    graphicsContext.strokeLine(getX() + size / 2  + offset, getY(), getX() + size  + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + size / 4  + offset, getY() + size / 1.5, getX() + size / 4 * 3 + offset, getY() + size / 1.5);
                    break;
            case 2: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 3 * 2 + offset, getY() + size / 6 * 2);
                    graphicsContext.strokeLine(getX() + size / 3 * 2 + offset, getY() + size / 3, getX() + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 3 * 2 + offset, getY() + size / 6 * 4);
                    graphicsContext.strokeLine(getX() + size / 3 * 2 + offset, getY() + size / 6 * 4, getX() + offset, getY() + size);
                    break;
            case 3: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    break;
            case 4: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 3 * 2 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + size / 3 * 2 + offset, getY() + size / 2, getX() + offset, getY() + size);
                    break;
            case 5: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    break;
            case 6: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    break;
            case 7: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset + size / 1.5, getY() + size, getX() + offset + size / 1.5, getY() + size / 2);
                    break;
            case 8: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset + size / 1.5, getY(), getX() + offset + size / 1.5, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    break;
            case 9: graphicsContext.strokeLine(getX() + size / 2 + offset, getY(), getX() + size / 2 + offset, getY() + size);
                    break;
            case 10: graphicsContext.strokeLine(getX() + size / 1.5 + offset, getY(), getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + offset, getY() + size / 2);
                    break;
            case 11: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY());
                    break;
            case 12: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    break;
            case 13: graphicsContext.strokeLine(getX() + size+ offset, getY(), getX() + size + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX()  + size / 2 + offset, getY()  + size, getX() + size + offset, getY());
                    graphicsContext.strokeLine(getX()  + size / 2 + offset, getY()  + size, getX()+ offset, getY());
                    break;
            case 14: graphicsContext.strokeLine(getX() + size+ offset, getY(), getX() + size + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size + offset, getY()  + size);
                    break;
            case 15:
            case -48:
                graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset + size / 1.5, getY(), getX() + offset + size / 1.5, getY() + size);
                    break;
            case 16: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + size / 1.5 + offset, getY(), getX() + size / 1.5 + offset, getY()+ size / 2);
                    break;
            case 17: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset + size / 1.5, getY(), getX() + offset + size / 1.5, getY() + size);
                    graphicsContext.strokeLine(getX() + offset + size / 1.8, getY() + size - size / 5, getX() + offset + size / 1.3, getY() + size * 1.1);
                    break;
            case 18: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + size / 1.5 + offset, getY(), getX() + size / 1.5 + offset, getY()+ size / 2);
                    break;
            case 19:
            case -43: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + size / 1.5 + offset, getY()  + size / 2, getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    break;
            case 20: graphicsContext.strokeLine(getX() + size / 2 + offset, getY(), getX() + size / 2 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size + offset, getY());
                    break;
            case 21: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset + size / 1.5, getY(), getX() + offset + size / 1.5, getY() + size);
                    break;
            case 22: graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 2 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + size / 2 + offset, getY() + size, getX() + offset + size, getY());
                    break;
            case 23: graphicsContext.strokeLine(getX() + offset, getY(), getX() + 1.5 * size / 6 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + 1.5 * size / 6  + offset, getY() + size, getX() + offset + size / 2, getY());
                    graphicsContext.strokeLine(getX() + size / 2 + offset, getY(), getX() + 4.5 * size / 6 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + 4.5 * size / 6  + offset, getY() + size, getX() + offset + size, getY());
                    break;
            case 24: graphicsContext.strokeLine(getX() + offset, getY(), getX() + size + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + offset + size, getY());
                    break;
            case 25: graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 2 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX()  + size / 2 + offset, getY() + size / 2, getX() + offset + size, getY());
                    graphicsContext.strokeLine(getX() + size / 2 + offset, getY() + size / 2, getX() + size / 2 + offset, getY() + size);
                    break;
            case 26: graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + offset + size / 1.5, getY());
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    break;
            case -47:
                    graphicsContext.strokeLine(getX() + size / 3 + offset, getY() + size / 6, getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + size / 1.5 + offset, getY(), getX() + size / 1.5 + offset, getY() + size);
                    break;
            case -46:
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + size / 1.5 + offset, getY(), getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    break;
            case -45:
                    graphicsContext.strokeLine(getX() + size / 1.5 + offset, getY(), getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    break;
            case -44: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.2 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + size / 2 + offset, getY() + size / 4, getX() + size / 2 + offset, getY() + size);
                    break;
            case -42: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + size / 1.5 + offset, getY()  + size / 2, getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    break;
            case -41: graphicsContext.strokeLine(getX() + size / 6 + offset, getY() + size, getX() + offset + size / 1.3, getY());
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                break;
            case -40: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + size / 1.5 + offset, getY(), getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    break;
            case -39: graphicsContext.strokeLine(getX() + offset, getY(), getX() + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + size / 1.5 + offset, getY(), getX() + size / 1.5 + offset, getY() + size);
                    graphicsContext.strokeLine(getX() + offset, getY(), getX() + size / 1.5 + offset, getY());
                    graphicsContext.strokeLine(getX() + offset, getY() + size / 2, getX() + size / 1.5 + offset, getY() + size / 2);
                    graphicsContext.strokeLine(getX() + offset, getY() + size, getX() + size / 1.5 + offset, getY() + size);
                    break;
        }
    }
}
