package de.frank.martin.games.rpgguilib.map;

import com.sun.javafx.tk.Toolkit;
import de.elite.games.drawlib.Point;
import de.elite.games.drawlib.Shape;
import de.elite.games.mazelib.map.MazeMapField;
import de.frank.martin.games.rpgguilib.mapdata.TestRpgMapFieldData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TestRpgMapField extends RpgMapField<TestRpgMapFieldData, TestRpgMapField, TestRpgMapEdge, TestRpgMapNode> {


    public TestRpgMapField(TestRpgMapFieldData testFieldData) {
        super(testFieldData);
    }

    @Override
    public void draw(Object graphics) {
        Color color =
                getData().isMarkedAsPath() ? Color.YELLOW :
                        getData().isDeadEnd() ? Color.LIGHTGRAY :
                                getData().isBlocked() ? Color.DARKGRAY : Color.WHITE;

        GraphicsContext gc = (GraphicsContext) graphics;
        gc.setFill(color);
        Shape shape = getShape().getTransformed();
//        double[] xs = shape.getPoints().stream().mapToDouble(Point::getX).toArray();
//        double[] ys = shape.getPoints().stream().mapToDouble(Point::getY).toArray();
//        int amount = Math.min(xs.length, ys.length);

        int amount = shape.getPoints().size();
        double[] xs = new double[amount];
        double[] ys = new double[amount];

        for (int i = 0; i < amount; i++) {
            Point point = shape.getPoints().get(i);
            xs[i] = point.getX();
            ys[i] = point.getY();
        }

        gc.fillPolygon(xs, ys, amount);
        for (TestRpgMapEdge e : getEdges()) {
            e.draw(graphics);
        }
        for (TestRpgMapNode n : getNodes()) {
            n.draw(graphics);
        }

        gc.setLineWidth(1);
        gc.setStroke(Color.GREEN);

        if (!getData().isBlocked()) {

            String text = "" + getData().getCounter();
            double width = Toolkit.getToolkit().getFontLoader().computeStringWidth(text, gc.getFont());
            double height = Toolkit.getToolkit().getFontLoader().getFontMetrics(gc.getFont()).getDescent();
            gc.setStroke(Color.MISTYROSE);
            gc.strokeText(text, shape.getCenter().getX() - width / 2, shape.getCenter().getY() + height);
        }
    }

}
