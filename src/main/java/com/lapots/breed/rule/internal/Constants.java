package com.lapots.breed.rule.internal;

import lombok.experimental.UtilityClass;

/**
 * Contains constants for the application.
 */
@UtilityClass
public class Constants {
    /** Default path to configuration.json .*/
    public static final String CONFIGURATION_JSON_PATH = "/configuration/configuration.json";
    /** default_package entry in configuration.json .*/
    public static final String CONFIGURATION_PACKAGE_ENTRY = "default_package";
    /** Default charset for file. */
    public static final String DEFAULT_CHARSET = "UTF-8";
    /** Template ruleName token. */
    public static final String RULE_NAME_TOKEN = "ruleName";
    /** Template packageName token. */
    public static final String PACKAGE_NAME_TOKEN = "package";
    /** Template className token. */
    public static final String CLASS_NAME_TOKEN = "className";
}
