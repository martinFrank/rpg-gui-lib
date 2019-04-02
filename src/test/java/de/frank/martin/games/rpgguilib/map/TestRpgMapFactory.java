package de.frank.martin.games.rpgguilib.map;

import de.elite.games.maplib.MapFactory;
import de.elite.games.maplib.MapPartFactory;

public class TestRpgMapFactory extends RpgMapFactory<TestRpgMap, TestRpgMapField, TestRpgMapEdge, TestRpgMapNode, TestRpgMapWalker> {

    public TestRpgMapFactory(TestRpgMapPartFactory mapPartFactory) {
        super(mapPartFactory);
    }

}
