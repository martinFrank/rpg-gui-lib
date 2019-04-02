package de.frank.martin.games.rpgguilib.map;


import java.util.List;
//import java.util.Optional;

public class TestRpgMapWalker extends RpgMapWalker<TestRpgMapField, TestRpgMapEdge, TestRpgMapNode> {

    @Override
    public boolean canEnter(TestRpgMapField from, TestRpgMapField into) {
//        Optional<TestRpgMapEdge> edge = from.getEdge(into);
//        return edge.map(testMapEdge -> testMapEdge.getData().getPassage().isOpen()).orElse(false);
        TestRpgMapEdge edge = from.getEdge(into);
        return edge.getData().getPassage().isOpen();
    }

    @Override
    public int getEnterCosts(TestRpgMapField from, TestRpgMapField into) {
        return 10;
    }

    @Override
    public List<TestRpgMapField> getNeighbours(TestRpgMapField field) {
        return getNeighboursFromEdges(field);
    }
}
