package de.frank.martin.games.rpgguilib.map;


import de.elite.games.drawlib.Point;
import de.elite.games.mazelib.map.MazeMapEdge;
import de.frank.martin.games.rpgguilib.mapdata.TestRpgMapEdgeData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TestRpgMapEdge extends RpgMapEdge<TestRpgMapEdgeData, TestRpgMapField, TestRpgMapEdge, TestRpgMapNode> {

    public TestRpgMapEdge(TestRpgMapEdgeData testEdgeData) {
        super(testEdgeData);
    }

    @Override
    public void draw(Object graphics) {
        GraphicsContext gc = (GraphicsContext) graphics;
//        gc.setStroke(getData().getPassage().isClosed() ? Color.BLACK : Color.LIGHTGRAY);
        gc.setStroke(getData().getPassage().isClosed() ? Color.DARKGRAY.darker() : Color.LIGHTGRAY);
        gc.setLineWidth(getData().getPassage().isClosed() ? 2 : 1);
        Point a = getLine().getA().getTransformed();
        Point b = getLine().getB().getTransformed();
        gc.strokeLine(a.getX(), a.getY(), b.getX(), b.getY());

    }

}
