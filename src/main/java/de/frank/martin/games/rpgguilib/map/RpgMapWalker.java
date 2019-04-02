package de.frank.martin.games.rpgguilib.map;

import de.elite.games.maplib.MapWalker;
import de.elite.games.mazelib.map.MazeMapEdge;
import de.elite.games.mazelib.map.MazeMapField;
import de.elite.games.mazelib.map.MazeMapNode;
import de.elite.games.mazelib.map.MazeMapWalker;

import java.util.List;
import java.util.Optional;

public abstract class RpgMapWalker<F extends RpgMapField<?, F, E, N>,
        E extends RpgMapEdge<?, F, E, N>,
        N extends RpgMapNode<?, F, E, N>> extends MazeMapWalker<F, E, N> {


}
