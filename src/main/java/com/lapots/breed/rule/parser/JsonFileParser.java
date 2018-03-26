package com.lapots.breed.rule.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.parser.api.AbstractFileParser;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Parses json file.
 */
public class JsonFileParser extends AbstractFileParser {

    @Override
    public List<DataRule> parseRuleFile(String filename) {
        try {
            URL jsonFile = this.getClass().getClassLoader().getResource(filename);
            ObjectMapper mapper = new ObjectMapper();
            DataRules allRules = mapper.readValue(jsonFile, DataRules.class);
            return allRules.getRules();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}
