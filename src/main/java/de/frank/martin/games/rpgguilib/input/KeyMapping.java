package de.frank.martin.games.rpgguilib.input;

import de.frank.martin.games.rpgguilib.config.PropertiesFileReader;
import de.frank.martin.games.rpgguilib.input.event.InputDirectionEvent;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.*;

class KeyMapping {

    private final Map<Integer, DirectionalKey> directionalKeys = new HashMap<>();
//    private static final Logger LOGGER = LoggerFactory.getLogger(KeyMapping.class);

    KeyMapping() {
        for (DirectionalKey key : Arrays.asList(DirectionalKey.LEFT, DirectionalKey.RIGHT, DirectionalKey.UP, DirectionalKey.DOWN)) {
            directionalKeys.put(key.preDefined, key);
        }
        Properties properties = PropertiesFileReader.readPropertiesFile("src/main/resources/keymapping.properties");
        mapDirectionalKeys(properties);

    }

    private void mapDirectionalKeys(Properties properties) {
        for (DirectionalKey directionalKey : directionalKeys.values()) {
            Object mappedKeyValue = null;
            try {
                mappedKeyValue = properties.get(directionalKey.toString());
                Integer key = Integer.parseInt(mappedKeyValue.toString());
                directionalKeys.put(key, directionalKey);
                //FIXME hier wäre noch ne Prüfung nötig, ob ein wert überschrieben wurde
            } catch (NullPointerException | NumberFormatException e) {
//                LOGGER.warn("could not parse keymapping for key {} (value={})", directionalKey, mappedKeyValue);
            }
        }

    }

    public boolean isMovementInput(int code) {
        return directionalKeys.containsKey(code);
    }

    public InputDirectionEvent getMovementInputDirectionForKey(int code) {
        int dx = getDxForKey(directionalKeys.get(code));
        int dy = getDyForKey(directionalKeys.get(code));
        return new InputDirectionEvent(dx, dy);
    }

//    public DirectionalKey getMovementInputDirectionForKey(int code) {
//        return directionalKeys.get(code);
//    }

    private int getDxForKey(KeyMapping.DirectionalKey key) {
        switch (key) {
            case LEFT: return -1;
            case RIGHT: return 1;
        }
        return 0;
    }

    private int getDyForKey(KeyMapping.DirectionalKey key) {
        switch (key) {
            case UP: return -1;
            case DOWN: return 1;
        }
        return 0;
    }

    enum DirectionalKey {
        LEFT(18), RIGHT(16), UP(19), DOWN(17);

        private int preDefined;

        DirectionalKey(int preDefined) {
            this.preDefined = preDefined;
        }
    }
}
