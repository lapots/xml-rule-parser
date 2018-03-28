package com.lapots.breed.rule.internal;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.io.InputStream;

/**
 * Contains configuration for parser.
 */
public class ConfigurationHolder {

    private static Object json;

    static {
        InputStream jsonFile = ConfigurationHolder.class.getResourceAsStream("/configuration/configuration.json");
        json = Configuration.defaultConfiguration().jsonProvider().parse(jsonFile, "UTF-8");
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
