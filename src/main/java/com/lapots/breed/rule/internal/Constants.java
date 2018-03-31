package com.lapots.breed.rule.internal;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Contains constants for the application.
 */
@UtilityClass
public class Constants {
    /** Default path to configuration.json .*/
    public static final String CONFIGURATION_JSON_PATH = "/configuration/configuration.json";
    /** default_package entry in configuration.json .*/
    public static final String CONFIGURATION_PACKAGE_ENTRY = "default_package";
    /** Failed to close error message. */
    public static final String JSON_FILE_ERROR = "Failed to close /configuration.json file!";
    /** Default charset for file. */
    public static final String DEFAULT_CHARSET = "UTF-8";
    /** Template ruleName token. */
    public static final String RULE_NAME_TOKEN = "ruleName";
    /** Template packageName token. */
    public static final String PACKAGE_NAME_TOKEN = "package";
    /** Template className token. */
    public static final String CLASS_NAME_TOKEN = "className";
    /** Template rhs token. */
    public static final String RHS_TOKEN = "rhs";
    /** Template lhs token. */
    public static final String LHS_TOKEN = "lhs";
    /** Template fields token. */
    public static final String FIELDS_TOKEN = "fields";
    /** Template imports token. */
    public static final String IMPORTS_TOKEN = "imports";
    /** Implicit JVM imports. */
    public static final List<String> JVM_IMPORTS =
            Collections.unmodifiableList(Arrays.asList("int", "float", "double", "long"));
    /** RuleBook annotation for result fact. */
    public static final String RESULT_ANNOTATION_TEMPLATE = "@Result";
    /** RuleBook annotation for input fact. */
    public static final String INPUT_FACT_ANNOTATION_TEMPLATE = "@Given(\"%s\")";
    /** Substring with package definition. */
    public static final String PACKAGE_CODE = "package";
    /** Substring with top level class definition. */
    public static final String CLASS_CODE = "public class";
}
