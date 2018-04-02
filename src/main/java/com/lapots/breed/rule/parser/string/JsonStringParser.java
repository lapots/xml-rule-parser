package com.lapots.breed.rule.parser.string;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.internal.parser.InternalRuleParser;
import com.lapots.breed.rule.parser.string.api.IStringParser;

import java.util.List;

/**
 * Parses json string.
 */
public class JsonStringParser implements IStringParser {
    @Override
    public List<DataRule> parseRuleString(String document) {
        return InternalRuleParser.parseJsonString(document);
    }
}
