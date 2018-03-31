package com.lapots.breed.rule.parser.file.api;

import com.lapots.breed.rule.domain.DataRule;

import java.util.List;

/**
 * Common interface for parsers.
 */
public interface IFileParser {
    /**
     * Parses rule file.
     * @param filename file with rules
     * @return list of rules
     */
    List<DataRule> parseRuleFile(String filename);
}
