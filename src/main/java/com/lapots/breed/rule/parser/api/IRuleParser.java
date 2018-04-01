package com.lapots.breed.rule.parser.api;

import com.lapots.breed.rule.domain.DataRule;

import java.util.List;

/**
 * Interface for rule parser.
 */
public interface IRuleParser {
    /**
     * Parses rule from xml or json file.
     * @param filename file name
     * @return parsed rules
     */
    List<DataRule> parseFile(String filename);

    /**
     * Parses rules from document body (xml, json).
     * @param documentBody document body
     * @return parsed rules
     */
    List<DataRule> parseDocument(String documentBody);
}
