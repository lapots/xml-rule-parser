package com.lapots.breed.rule.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lapots.breed.rule.domain.DataRule;
import lombok.Data;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Parses json file.
 */
public class JsonFileParser {

    /**
     * Parses json file with rules.
     * @param filename filename
     * @return list of parsed rules
     */
    public List<DataRule> parseRuleFile(String filename) {
        try {
            URL jsonFile = this.getClass().getClassLoader().getResource(filename);
            ObjectMapper mapper = new ObjectMapper();
            DataRules allRules = mapper.readValue(jsonFile, DataRules.class);
            return allRules.rules;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * JSON root element for inner use in parser.
     */
    @Data
    private static class DataRules {
        private List<DataRule> rules;
    }
}
