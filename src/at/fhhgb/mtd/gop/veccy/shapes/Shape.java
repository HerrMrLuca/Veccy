package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.data.DoubleLinkedList;
import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;


public class Shape implements DrawableShape {

    protected Vector3 position;
    protected Matrix3 transform;
    protected Color fillColor = Color.WHITE;
    protected Color strokeColor = Color.WHITE;
    public Shape(int x, int y) {
        this.position = new Vector3(new double[] {x,y,1});
    }
    // Returniert die x Koordinate von 'position'
    public int getX() {
        return (int) position.getValues()[0];
    }
    // Returniert die y Koordinate von 'position'
    public int getY() {
        return (int) position.getValues()[1];
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    // Setzt die 'fillColor' Instanzvariable
    public void setFillColor(Color c) {
        this.fillColor = c;
    }
    // Setzt die 'strokeColor' Instanzvariable
    public void setStrokeColor(Color c) {
        this.strokeColor = c;
    }
    // Setzt die 'transform' Instanzvariable
    public void setTransform(Matrix3 transform) {
        this.transform = transform;
    }
    // Setzt die fillColor und strokeColor am ‚graphicsContext‘

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(fillColor);
        graphicsContext.setStroke(strokeColor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Shape other) {
            return other.position.getValues()[0] == position.getValues()[0] &&
                    other.position.getValues()[1] == position.getValues()[1];
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        String sb = "Shape @ " +
                position.getValues()[0] +
                " / " +
                position.getValues()[1];
        return sb;
    }
}
