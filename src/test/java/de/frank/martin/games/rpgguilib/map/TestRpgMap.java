package de.frank.martin.games.rpgguilib.map;

import de.elite.games.maplib.MapStyle;
import de.elite.games.mazelib.map.MazeMap;
import de.frank.martin.games.rpgguilib.mapdata.TestRpgMapData;

public class TestRpgMap extends RpgMap<TestRpgMapData, TestRpgMapField, TestRpgMapEdge, TestRpgMapNode, TestRpgMapWalker> {

    TestRpgMap(int width, int height, MapStyle style, TestRpgMapData testMapData) {
        super(width, height, style, testMapData);
    }

    @Override
    public void draw(Object graphics) {
        for (TestRpgMapField field : getFields()) {
            field.draw(graphics);
        }
    }

    public double getScrollWidth(double dx, double dy) {
        return getFields().get(0).getShape().getTransformed().getWidth();

    }

    public double getScrollHeight(double dx, double dy) {
        return getFields().get(0).getShape().getTransformed().getHeight();
    }

}
