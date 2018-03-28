package com.lapots.breed.rule.internal;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;

/**
 * Contains configuration for parser.
 */
public class ConfigurationHolder {

    private static Object json;

    static {
        InputStream jsonFile = ConfigurationHolder.class.getResourceAsStream("/configuration/configuration.json");
        json = Configuration.defaultConfiguration().jsonProvider().parse(jsonFile, "UTF-8");

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
