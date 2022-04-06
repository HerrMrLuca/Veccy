package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.paint.Color;

public class Triangle extends Circle {

    public Triangle(int x, int y, int r, Color c, int smoothness) {
        super(x, y, r, c);
        super.setSmoothness(smoothness);
    }


    public Triangle() {
        this(0, 0, 10, Color.rgb(255,255,255), 3);
    }

    public Triangle(int x, int y, int r) {
        this(x, y, r, Color.rgb(255,255,255), 3);
    }

    public Triangle(int x, int y, int r, int smoothness) {
        this(x, y, r, Color.rgb(255,255,255), smoothness);
    }

    public Triangle(Triangle triangle) {
        this(triangle.getX(), triangle.getY(), triangle.getR(), triangle.fillColor, triangle.getSmoothness());
    }
}
