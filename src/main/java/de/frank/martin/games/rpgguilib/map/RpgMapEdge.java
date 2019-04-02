package de.frank.martin.games.rpgguilib.map;


import de.elite.games.maplib.MapEdge;
import de.elite.games.mazelib.map.MazeMapEdge;
import de.elite.games.mazelib.map.MazeMapField;
import de.elite.games.mazelib.map.MazeMapNode;
import de.frank.martin.games.rpgguilib.mapdata.RpgMapEdgeData;

public abstract class RpgMapEdge<D,
        F extends RpgMapField<?, F, E, N>,
        E extends RpgMapEdge<D, F, E, N>,
        N extends RpgMapNode<?, F, E, N>> extends MazeMapEdge<D, F, E, N> {

    public RpgMapEdge(D d) {
        super(d);
    }
}
