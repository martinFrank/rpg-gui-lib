package de.frank.martin.games.rpgguilib;

import de.elite.games.maplib.MapStyle;
import de.frank.martin.games.rpgguilib.gui.JavaFxMapCanvas;
import de.frank.martin.games.rpgguilib.input.InputHandler;
import de.frank.martin.games.rpgguilib.map.TestRpgMap;
import de.frank.martin.games.rpgguilib.map.TestRpgMapFactory;
import de.frank.martin.games.rpgguilib.map.TestRpgMapPartFactory;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class RpgApp extends Application {

//    private static final Logger LOGGER = LoggerFactory.getLogger(RpgApp.class);

    private TestRpgMap rpgMap;
    private InputHandler inputHandler;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        //----------------------------
        TestRpgMapPartFactory mapPartFactory = new TestRpgMapPartFactory();
        TestRpgMapFactory mapFactory = new TestRpgMapFactory(mapPartFactory);
        rpgMap = mapFactory.createMap(12, 8, MapStyle.SQUARE);
//        rpgMap = mapFactory.createMap(12, 6, MapStyle.HEX_VERTICAL);
        rpgMap.scale(14f);
//        rpgMap.generateMaze(new MazeGenerationParams(MazeGenerationParams.AlgorithmType.RECURSIVE_BACKTRACKER_PASSAGES));
        //----------------------------

        BorderPane border = new BorderPane();
        Canvas canvas = new Canvas(rpgMap.getTransformed().getWidth(), rpgMap.getTransformed().getHeight());
        Scene scene = new Scene(border);
        border.setCenter(canvas);

        JavaFxMapCanvas mapCanvas = new JavaFxMapCanvas(rpgMap, canvas);
        inputHandler = new InputHandler(mapCanvas);
        //----------------------------

//        scene.setOnKeyPressed(event -> inputHandler.handleKeyEvent(event.getCode().ordinal()));
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                inputHandler.handleKeyEvent(event.getCode().ordinal());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        rpgMap.draw(canvas.getGraphicsContext2D());
    }
}
