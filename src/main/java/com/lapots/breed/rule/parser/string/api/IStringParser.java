package com.lapots.breed.rule.parser.string.api;

import com.lapots.breed.rule.domain.DataRule;

import java.util.List;

/**
 * Common interface for string parsers.
 */
public interface IStringParser {
    /**
     * Parses string into object.
     * @param document string
     * @return parsed list of objects
     */
    List<DataRule> parseRuleString(String document);
}
