package de.frank.martin.games.rpgguilib.map;

import de.elite.games.maplib.MapStyle;
import de.elite.games.mazelib.map.MazeMapPartFactory;
import de.frank.martin.games.rpgguilib.mapdata.TestRpgMapData;
import de.frank.martin.games.rpgguilib.mapdata.TestRpgMapEdgeData;
import de.frank.martin.games.rpgguilib.mapdata.TestRpgMapFieldData;
import de.frank.martin.games.rpgguilib.mapdata.TestRpgMapNodeData;

public class TestRpgMapPartFactory extends RpgMapPartFactory<TestRpgMap, TestRpgMapField, TestRpgMapEdge, TestRpgMapNode, TestRpgMapWalker> {

    @Override
    public TestRpgMapNode createMapNode() {
        return new TestRpgMapNode(new TestRpgMapNodeData());
    }

    @Override
    public TestRpgMapEdge createMapEdge() {
        return new TestRpgMapEdge(new TestRpgMapEdgeData());
    }

    @Override
    public TestRpgMapField createMapField() {
        return new TestRpgMapField(new TestRpgMapFieldData());
    }

    @Override
    public TestRpgMap createMap(int columns, int rows, MapStyle style) {
        return new TestRpgMap(columns, rows, style, new TestRpgMapData());
    }

    @Override
    public TestRpgMapWalker createWalker() {
        return new TestRpgMapWalker();
    }
}
