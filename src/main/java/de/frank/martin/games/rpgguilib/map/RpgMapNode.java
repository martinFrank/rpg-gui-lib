package de.frank.martin.games.rpgguilib.map;

import de.elite.games.maplib.MapNode;
import de.elite.games.mazelib.map.MazeMapEdge;
import de.elite.games.mazelib.map.MazeMapField;
import de.elite.games.mazelib.map.MazeMapNode;

public abstract class RpgMapNode<D,
        F extends RpgMapField<?, F, E, N>,
        E extends RpgMapEdge<?, F, E, N>,
        N extends RpgMapNode<D, F, E, N>> extends MazeMapNode<D, F, E, N> {

    public RpgMapNode(D d) {
        super(d);
    }

}

