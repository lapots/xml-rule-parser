package com.lapots.breed.rule.internal;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;

import static com.lapots.breed.rule.internal.Constants.CONFIGURATION_JSON_PATH;
import static com.lapots.breed.rule.internal.Constants.DEFAULT_CHARSET;

/**
 * Contains configuration for parser.
 */
public class ConfigurationHolder {

    private static Object json;

    static {
        InputStream jsonFile = ConfigurationHolder.class.getResourceAsStream(CONFIGURATION_JSON_PATH);
        json = Configuration.defaultConfiguration().jsonProvider().parse(jsonFile, DEFAULT_CHARSET);

        try {
            jsonFile.close();
        } catch (IOException e) {
            throw new IllegalStateException("Failed to close /configuration.json file!");
        }
    }

    /**
     * Returns value according to a key.
     * @param key path to json value
     * @return json value
     */
    public static String findByKey(String key) {
        return JsonPath.read(json, key);
    }
}
