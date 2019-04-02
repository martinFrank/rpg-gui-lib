package de.frank.martin.games.rpgguilib.gui;

import de.frank.martin.games.rpgguilib.RpgApp;
import de.frank.martin.games.rpgguilib.map.TestRpgMap;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class JavaFxMapCanvas extends MapCanvas<TestRpgMap, Canvas> {

    private TestRpgMap demoMap = null;

//    private static final Logger LOGGER = LoggerFactory.getLogger(RpgApp.class);

    public JavaFxMapCanvas(TestRpgMap rpgMap, Canvas canvas) {
        super(rpgMap, canvas);
    }

    @Override
    public void startAnimation(final TestRpgMap rpgMap, final GuiListener guiListener, final int dx, final int dy) {

        AnimationTimer timer = new AnimationTimer() {

            private static final long SLEEP_TIME_IN_MILLIS = 10;
            private static final long FACTOR_MILLIS_TO_NANOS = 1_000_000;
            private static final long SLEEP_TIME = SLEEP_TIME_IN_MILLIS * FACTOR_MILLIS_TO_NANOS;
            private static final int ANIMATION_AMOUNT = 8;
            private long lastMeasuredTime = 0;
            private int animationCount = 0;

            private double deltaPanX = dx * rpgMap.getScrollWidth(dx, dy) / ANIMATION_AMOUNT;
            private double panX = 0;

            private double deltaPanY = dy * rpgMap.getScrollHeight(dx, dy) / ANIMATION_AMOUNT;
            private double panY = 0;

            @Override
            public void handle(long now) {
                // some delay
                if ((now - lastMeasuredTime) < SLEEP_TIME) {
                    return;
                }
                lastMeasuredTime = now;
                handle();
            }

            private void handle() {
                panX = panX + deltaPanX;
                panY = panY + deltaPanY;
                rpgMap.pan(panX, panY);
                animationCount = animationCount + 1;
                if (animationCount > ANIMATION_AMOUNT) {
                    rpgMap.pan(0, 0);
                    stop();
                    guiListener.releaseInputLock();
                }
                rpgMap.draw(getCanvas().getGraphicsContext2D());
            }

        };
        guiListener.setInputLock();
        timer.start();
    }


}
