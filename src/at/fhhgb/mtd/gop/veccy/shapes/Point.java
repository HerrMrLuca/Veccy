package at.fhhgb.mtd.gop.veccy.shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point extends Shape {

    public Point() {
        this(0,0);
    }

    public Point(Point p) {
        this(p.getX(), p.getY());
    }

    public Point(int x, int y) {
        super(x,y);
    }

    public Point(int x, int y, Color c) {
        super(x,y);
        super.setStrokeColor(c);
    }

    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.setLineWidth(5);
        graphicsContext.strokeLine(super.getX(), super.getY(), super.getX(), super.getY());
        graphicsContext.setLineWidth(1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Point p) {
            return this.getX() == p.getX() && this.getY() == p.getY();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /** Make the values to a string */
    public String toString() {
        String str;

        str = "x = " + getX() + ", y = " + getY() + ", c = " + super.fillColor;

        return str;
    }
}
