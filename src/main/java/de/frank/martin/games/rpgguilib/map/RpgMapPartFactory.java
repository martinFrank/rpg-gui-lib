package de.frank.martin.games.rpgguilib.map;

import de.elite.games.mazelib.map.*;
import de.elite.games.mazelib.mapdata.MazeMapEdgeData;
import de.elite.games.mazelib.mapdata.MazeMapFieldData;

public abstract class RpgMapPartFactory<M extends MazeMap<?, F, E, N, W>,
        F extends MazeMapField<? extends MazeMapFieldData, F, E, N>,
        E extends MazeMapEdge<? extends MazeMapEdgeData, F, E, N>,
        N extends MazeMapNode<?, F, E, N>,
        W extends MazeMapWalker<F, E, N>> extends MazeMapPartFactory<M, F, E, N, W> {


}
