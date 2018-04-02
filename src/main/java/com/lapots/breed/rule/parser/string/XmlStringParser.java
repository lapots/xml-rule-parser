package com.lapots.breed.rule.parser.string;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.internal.parser.InternalRuleParser;
import com.lapots.breed.rule.parser.string.api.IStringParser;

import java.util.List;

/**
 * Parses xml string.
 */
public class XmlStringParser implements IStringParser {
    @Override
    public List<DataRule> parseRuleString(String document) {
        return InternalRuleParser.parseXmlString(document);
    }
}
