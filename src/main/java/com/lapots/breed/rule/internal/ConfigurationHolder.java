package com.lapots.breed.rule.internal;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

import static com.lapots.breed.rule.internal.Constants.*;

/**
 * Contains configuration for parser.
 */
public class ConfigurationHolder {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationHolder.class);

    private static Object json;
    private static Object extJson;

    static {
        // load core
        InputStream jsonFile = ConfigurationHolder.class.getResourceAsStream(CONFIGURATION_JSON_PATH);
        json = Configuration
                .defaultConfiguration()
                .jsonProvider()
                .parse(jsonFile, DEFAULT_CHARSET);

        try {
            jsonFile.close();
        } catch (IOException e) {
            throw new IllegalStateException(JSON_FILE_ERROR);
        }

        // load extensions
        jsonFile = ConfigurationHolder.class.getResourceAsStream(EXT_CONFIGURATION_JSON_PATH);
        if (null != jsonFile) {
            extJson = Configuration
                    .defaultConfiguration()
                    .jsonProvider()
                    .parse(jsonFile, DEFAULT_CHARSET);
            try {
                jsonFile.close();
            } catch (IOException e) {
                throw new IllegalStateException(EXT_JSON_FILE_ERROR);
            }
        }
    }

    /**
     * Returns value according to a key.
     * @param key path to json value
     * @return json value
     */
    public static String findByKey(String key) {
        // read from both and choose the existing or overriden
        String core, ovrd;
        try {
            core = JsonPath.read(json, key);
        } catch (PathNotFoundException e) {
            LOGGER.warn("No key [{}] found in core file!", key);
            core = null;
        }

        try {
            ovrd = JsonPath.read(extJson, key);
        } catch (PathNotFoundException e) {
            LOGGER.warn("No key [{}] found in extension file!", key);
            ovrd = null;
        }

        return ovrd == null ? core : ovrd;
    }
}
