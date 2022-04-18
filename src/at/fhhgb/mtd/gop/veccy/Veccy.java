package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.veccy.data.DoubleLinkedList;
import at.fhhgb.mtd.gop.veccy.data.Node;
import at.fhhgb.mtd.gop.veccy.feature.*;
import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.*;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Veccy extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();
        model.addFeature(new RectangleFeature(model));
        model.addFeature(new CircleFeature(model));
        model.addFeature(new LineFeature(model));
        model.addFeature(new PointFeature(model));
        model.addFeature(new PolygonFeature(model));
        model.addFeature(new PathFeature(model));
        model.addFeature(new TextFeature(model));
        model.addFeature(new ClearFeature(model));
        model.addFeature(new BezierFeature(model));







        //fractal(model);
        //noise(model);
        //testTransform(model);
    }

    public void noise(CanvasModel model) {
        int width = 25;
        int height = 25;
        int x = 800 / width;
        int y = 600 / height;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int r = (int) (Math.random() * 255);
                Rectangle rec = new Rectangle(width * i, height  * j, width, height);
                rec.setFillColor(Color.rgb(r, r ,r));
                rec.setStrokeColor(Color.rgb(r, r ,r));
                model.addShape(rec);
            }
        }
    }

    public void testTransform(CanvasModel model) {
        Circle b = new Circle(200, 190, 50, Color.rgb(255,255,255));
        Circle c = new Circle(200, 190, 50, Color.rgb(255,255,255));
        b.setSmoothness(5);
        c.setSmoothness(5);
        model.addShape(c);
        c.setFillColor(Color.rgb(100, 255,50, 0.5));
        c.setTransform(TransformFactory.createVerticalMirroring());
        model.addShape(c);

        model.addShape(new Line(400, 140, 450, 200));
        Line l = new Line(400, 140, 450, 200);
        l.setTransform(TransformFactory.createHorizontalMirroring());
        model.addShape(l);

        model.addShape(new Rectangle(150, 350, 100, 100));
        Rectangle rec = new Rectangle(150, 350, 100, 100, Color.rgb(100, 255, 100, 0.5));
        rec.setTransform(TransformFactory.createScaling(2, 1.5));
        model.addShape(rec);

        model.addShape(new Triangle(600, 190, 50, 3));
        Triangle t = new Triangle(600, 190, 50, Color.rgb(100, 255,100, 0.5), 3);
        t.setTransform(TransformFactory.createRotation(Math.toRadians(30)));
        model.addShape(t);

        model.addShape(new Rectangle(550, 320, 100, 100));
        Rectangle rec2 = new Rectangle(550, 320, 100, 100, Color.rgb(100, 255, 100, 0.5));
        rec2.setTransform(TransformFactory.createTranslation(50, 50));
        model.addShape(rec2);

        model.addShape(new Text(100, 100, "Vertical", 10));
        model.addShape(new Text(320, 100, "horizontal", 10));
        model.addShape(new Text(550, 100, "rotation", 10));
        model.addShape(new Text(100, 300, "scale", 10));
        model.addShape(new Text(550, 300, "translate", 10));
        model.addShape(new Text(50, 20, "UE04 Wassermeyer", 35));
    }

    /*public void ocean(CanvasModel model) {
        // background
        for (int i = 0; i < 40; i++) {
            model.addShape(new Rectangle(0, i * 15, 1000, 50, Color.rgb(32 + i * 5, 88 + i * 2, 180 - i * 4)));
        }

        // sun
        model.addShape(new Circle(500, 250, 200, Color.rgb(212, 181, 55)));

        // sea last wave
        for (int i = 0; i <  10; i++) {
            model.addShape(new Circle(-20 + 100 * i, 400, 150, Color.rgb(52, 81, 115)));
        }

        // ship
        model.addShape(new Rectangle(150, 180, 100, 70, Color.rgb(13, 13, 7)));
        model.addShape(new Rectangle(230, 150, 25, 250, Color.rgb(73, 47, 7)));
        model.addShape(new Rectangle(50, 330, 300, 70, Color.rgb(73, 47, 7)));
        model.addShape(new Circle(50, 330, 150, Color.rgb(73, 47, 7)));
        model.addShape(new Circle(125, 330, 150, Color.rgb(73, 47, 7)));
        model.addShape(new Circle(200, 330, 150, Color.rgb(73, 47, 7)));


        // sea second wave
        for (int i = 0; i <  10; i++) {
            model.addShape( new Circle(-20 + 100 * i, 450, 150, Color.rgb(32, 61, 115)));
        }

        // sea first wave
        for (int i = 0; i <  10; i++) {
            model.addShape( new Circle(-20 + 100 * i, 500, 150, Color.rgb(12, 41, 115)));
        }


        // bird
        int x1 = 450;
        int y1 = 250;
        int x2 = x1 + 2;
        int y2 = y1 + 2;
        int w = 3;

        for (int i = 0; i < 5; i++) {
            x2 += 5 + i;
            y2 += i * 4;
            w += 1;
            model.addShape(new Line(x1, y1, x2, y2, w, Color.rgb(0, 0, 0)));
            x1 = x2;
            y1 = y2;
        }

        x1 += 2;

        for (int i = 5; i > 0; i--) {
            x2 += 5 + i;
            y2 -= i * 3;
            w -= 1;
            model.addShape(new Line(x1, y1, x2, y2, w, Color.rgb(0, 0, 0)));
            x1 = x2;
            y1 = y2;
        }

        // bird

        x1 = 650;
        y1 = 300;
        x2 = x1 + 2;
        y2 = y1 + 2;
        w = 3;

        for (int i = 0; i < 5; i++) {
            x2 += 4 + i;
            y2 += i * 4;
            w += 1;
            model.addShape(new Line(x1, y1, x2, y2, w, Color.rgb(0, 0, 0)));
            x1 = x2;
            y1 = y2;
        }

        x1 += 2;
        for (int i = 5; i > 0; i--) {
            x2 += 10 + i;
            y2 -= i * 3;
            w -= 1;
            model.addShape(new Line(x1, y1, x2, y2, w, Color.rgb(0, 0, 0)));
            x1 = x2;
            y1 = y2;
        }

        // bird

        x1 = 550;
        y1 = 200;
        x2 = x1 + 2;
        y2 = y1 + 2;
        w = 3;

        for (int i = 0; i < 4; i++) {
            x2 += 4 + i;
            y2 += i * 4;
            w += 1;
            model.addShape(new Line(x1, y1, x2, y2, w, Color.rgb(0, 0, 0)));
            x1 = x2;
            y1 = y2;
        }

        x1 += 2;
        for (int i = 4; i > 0; i--) {
            x2 += 10 + i;
            y2 -= i * 4;
            w -= 1;
            model.addShape(new Line(x1, y1, x2, y2, w, Color.rgb(0, 0, 0)));
            x1 = x2;
            y1 = y2;
        }
    }*/

    public void fractal(CanvasModel model) {

        // Fractal

        for (int i = 0; i < 190; i++) {
            model.addShape(new Circle((int) (250 + Math.sin(i * 1.77) * (50 + i * 3)), (int) (250 + Math.cos(i * 1.77) * (50 + i * 3)), (int) (10 * i * 0.08), Color.rgb(192, 50, 20)));
        }
        System.out.println("1");

        for (int i = 0; i < 190; i++) {
            model.addShape(new Circle((int) (250 + Math.sin(i * 1.9) * (50 + i * 4)), (int) (250 + Math.cos(i * 1.9) * (50 + i * 4)), (int) (10 * i * 0.08), Color.rgb(192, 100, 55)));
        }
        System.out.println("2");

        for (int i = 0; i < 180; i++) {
            model.addShape(new Circle((int) (250 + Math.sin(i * 2) * (100 + i * 3)), (int) (250 + Math.cos(i * 2) * (100 + i * 3)), (int) (10 * i * 0.08), Color.rgb(212, 181, 55)));
        }
        System.out.println("3");

        for (int i = 0; i < 180; i++) {
            model.addShape(new Circle((int) (250 + Math.sin(i * 3) * (100 + i * 4)), (int) (250 + Math.cos(i * 3) * (100 + i * 4)), (int) (10 * i * 0.08), Color.rgb(152, 181, 65)));
        }
        System.out.println("4");

        for (int i = 0; i < 80; i++) {
            model.addShape(new Circle((int) (250 + Math.sin(i * 4) * (100 + i * 5)), (int) (250 + Math.cos(i * 4) * (100 + i * 5)), (int) (10 * i * 0.08), Color.rgb(112, 181, 255)));
        }
        System.out.println("5");
    }
}