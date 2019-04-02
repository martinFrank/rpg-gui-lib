package de.frank.martin.games.rpgguilib.map;

import de.elite.games.maplib.MapFactory;
import de.elite.games.mazelib.map.*;
import de.elite.games.mazelib.mapdata.MazeMapEdgeData;
import de.elite.games.mazelib.mapdata.MazeMapFieldData;

public abstract class RpgMapFactory<M extends MazeMap<?, F, E, N, W>,
        F extends RpgMapField<? extends MazeMapFieldData, F, E, N>,
        E extends RpgMapEdge<? extends MazeMapEdgeData, F, E, N>,
        N extends RpgMapNode<?, F, E, N>,
        W extends RpgMapWalker<F, E, N>> extends MazeMapFactory<M, F, E, N, W> {


    public RpgMapFactory(MazeMapPartFactory<M, F, E, N, W> mapPartFactory) {
        super(mapPartFactory);
    }

}
