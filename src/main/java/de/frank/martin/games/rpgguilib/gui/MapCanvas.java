package de.frank.martin.games.rpgguilib.gui;

import de.frank.martin.games.rpgguilib.map.RpgMap;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public abstract class MapCanvas<M extends RpgMap, T> {

//    private static final Logger LOGGER = LoggerFactory.getLogger(MapCanvas.class);

    private final M rpgMap;
    private GuiListener guiListener;
    private T canvas;

    public MapCanvas(M rpgMap, T canvas) {
        this.rpgMap = rpgMap;
        this.canvas = canvas;
    }

    public void moveMap(int dx, int dy) {
//        LOGGER.debug("move map...");
        startAnimation(rpgMap, guiListener, dx, dy);

    }

    public abstract void startAnimation(M rpgMap, GuiListener listener, int dx, int dy);

    public void setGuiListener(GuiListener listener) {
        this.guiListener = listener;
    }

    public T getCanvas() {
        return canvas;
    }
}
