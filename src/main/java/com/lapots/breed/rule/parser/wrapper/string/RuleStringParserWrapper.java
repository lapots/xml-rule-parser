package com.lapots.breed.rule.parser.wrapper.string;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.parser.string.api.IStringParser;
import com.lapots.breed.rule.parser.wrapper.api.IParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Wrapper over string parsing.
 */
public class RuleStringParserWrapper implements IStringParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(RuleStringParserWrapper.class);

    private IParserFactory<IStringParser> factory;

    /**
     * Constructor.
     */
    public RuleStringParserWrapper() {
        factory = new StringParserFactory();
    }

    @Override
    public List<DataRule> parseRuleString(String document) {
        LOGGER.debug("Attempt to parse: [{}].", document);
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
        String startSymbol = document.substring(0, 1);
        LOGGER.debug("Attempt to get document type for [{}].", startSymbol);
        String type = null;
        switch (startSymbol) {
            case "<":
                type = "xml";
                break;
            case "{":
                type = "json";
                break;
            default:
                break;
        }

        checkArgument(type != null, "Unsupported document type");
        return type;
    }
}
