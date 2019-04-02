package de.frank.martin.games.rpgguilib.input;

import de.frank.martin.games.rpgguilib.gui.GuiListener;
import de.frank.martin.games.rpgguilib.gui.MapCanvas;
import de.frank.martin.games.rpgguilib.input.event.InputDirectionEvent;
import de.frank.martin.games.rpgguilib.input.event.InputEvent;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class InputHandler implements GuiListener {

//    private static final Logger LOGGER = LoggerFactory.getLogger(InputHandler.class);

    private final MapCanvas canvas;
    private boolean isInputBlocked;
    private KeyMapping keyMapping = new KeyMapping();

    public InputHandler(MapCanvas canvas) {
//        LOGGER.debug("starting inputHandler");
        this.canvas = canvas;
        canvas.setGuiListener(this);
    }

    public void handleKeyEvent(int code) {
        if (isInputBlocked) {
//            LOGGER.debug("input is blocked, wait a bit");
        } else {
            if (keyMapping.isMovementInput(code)) {
                InputDirectionEvent directionEvent = keyMapping.getMovementInputDirectionForKey(code);
                handleInputEvent(directionEvent);
            }
        }
    }

    public void handleInputEvent(InputEvent event) {
        if (isInputBlocked) {
//            LOGGER.debug("input is blocked, wait a bit");
        } else {
            if (event instanceof InputDirectionEvent) {
                InputDirectionEvent inputDirectionEvent = (InputDirectionEvent) event;
                canvas.moveMap(inputDirectionEvent.getDx(), inputDirectionEvent.getDy());
            }
        }
    }

    @Override
    public void releaseInputLock() {
        isInputBlocked = false;
    }

    @Override
    public void setInputLock() {
        isInputBlocked = true;
    }

}
