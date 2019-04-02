package de.frank.martin.games.rpgguilib.map;

import com.sun.javafx.tk.Toolkit;
import de.elite.games.drawlib.Point;
import de.elite.games.drawlib.Shape;
import de.elite.games.maplib.MapField;
import de.elite.games.mazelib.map.MazeMapEdge;
import de.elite.games.mazelib.map.MazeMapField;
import de.elite.games.mazelib.map.MazeMapNode;
import de.frank.martin.games.rpgguilib.mapdata.RpgMapFieldData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class RpgMapField<D,
        F extends RpgMapField<D, F, E, N>,
        E extends RpgMapEdge<?, F, E, N>,
        N extends RpgMapNode<?, F, E, N>> extends MazeMapField<D, F, E, N> {


    public RpgMapField(D d) {
        super(d);
    }


}
