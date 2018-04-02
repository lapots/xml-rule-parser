package com.lapots.breed.rule.parser.wrapper.string;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.parser.string.api.IStringParser;

import java.util.List;

/**
 * Wrapper over string parsing.
 */
public class RuleStringParserWrapper implements IStringParser {
    private StringParserFactory factory;

    /**
     * Constructor.
     */
    public RuleStringParserWrapper() {
        factory = new StringParserFactory();
    }

    @Override
    public List<DataRule> parseRuleString(String document) {
        String type = getDocumentType(document);
        IStringParser parser = factory.getParser(type);
        return parser.parseRuleString(document);
    }

    /**
     * Finds out the document type.
     * @param document document
     * @return type
     */
    private String getDocumentType(String document) {
        // TODO:find something better
        if (document.startsWith("<")) {
            return "xml";
        } else if (document.startsWith("{")) {
            return "json";
        } else {
            throw new IllegalStateException("Unsupported document type");
        }
    }
}
