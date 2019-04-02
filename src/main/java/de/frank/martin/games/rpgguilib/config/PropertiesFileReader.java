package de.frank.martin.games.rpgguilib.config;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

//    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesFileReader.class);

    public static Properties readPropertiesFile(String propertiesFilename) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(propertiesFilename)) {
            prop.load(input);
        } catch (IOException ex) {
//            LOGGER.warn("could not read properties file {} - using defaults", propertiesFilename);
        }
        return prop;
    }
}
