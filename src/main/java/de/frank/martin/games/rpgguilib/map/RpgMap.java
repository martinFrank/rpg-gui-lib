package de.frank.martin.games.rpgguilib.map;

import de.elite.games.maplib.MapStyle;
import de.elite.games.mazelib.map.MazeMap;
import de.elite.games.mazelib.mapdata.MazeMapEdgeData;
import de.elite.games.mazelib.mapdata.MazeMapFieldData;

public abstract class RpgMap<D,
        F extends RpgMapField<? extends MazeMapFieldData, F, E, N>,
        E extends RpgMapEdge<? extends MazeMapEdgeData, F, E, N>,
        N extends RpgMapNode<?, F, E, N>,
        W extends RpgMapWalker<F, E, N>> extends MazeMap<D, F, E, N, W> {

    public RpgMap(int width, int height, MapStyle style, D d) {
        super(width, height, style, d);
    }


    public double getScrollWidth(double dx, double dy) {
        return getFields().get(0).getShape().getTransformed().getWidth();

    }

    public double getScrollHeight(double dx, double dy) {
        return getFields().get(0).getShape().getTransformed().getHeight();
    }

}
