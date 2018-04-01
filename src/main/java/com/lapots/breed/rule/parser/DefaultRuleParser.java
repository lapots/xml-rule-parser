package com.lapots.breed.rule.parser;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.parser.api.IRuleParser;
import com.lapots.breed.rule.parser.file.api.IFileParser;
import com.lapots.breed.rule.parser.wrapper.RuleFileParserWrapper;

import java.util.List;

/**
 * Basic rule parser that allows to parse file or document.
 */
public class DefaultRuleParser implements IRuleParser {
    private IFileParser fileParserWrapper;

    /**
     * Constructor.
     */
    public DefaultRuleParser() {
        fileParserWrapper = new RuleFileParserWrapper();
    }

    @Override
    public List<DataRule> parseFile(String filename) {
        return fileParserWrapper.parseRuleFile(filename);
    }

    @Override
    public List<DataRule> parseDocument(String documentBody) {
        return null;
    }
}
