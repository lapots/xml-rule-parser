package com.lapots.breed.rule.parser.file;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.internal.parser.InternalRuleParser;
import com.lapots.breed.rule.parser.file.api.IFileParser;

import java.net.URL;
import java.util.List;

/**
 * Parses json file.
 */
public class JsonFileParser implements IFileParser {

    @Override
    public List<DataRule> parseRuleFile(String filename) {
        URL jsonFile = this.getClass().getClassLoader().getResource(filename);
        return InternalRuleParser.parseJsonFile(jsonFile);
    }

}
