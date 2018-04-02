package com.lapots.breed.rule.parser.wrapper.string;

import com.lapots.breed.rule.parser.string.JsonStringParser;
import com.lapots.breed.rule.parser.string.XmlStringParser;
import com.lapots.breed.rule.parser.string.api.IStringParser;

import java.util.HashMap;
import java.util.Map;

/**
 * String parser factory.
 */
public class StringParserFactory {
    private Map<String, IStringParser> parsers;
    /**
     * Constructor.
     */
    StringParserFactory() {
        parsers = new HashMap<>();
        parsers.put("xml", new XmlStringParser());
        parsers.put("json", new JsonStringParser());
    }

    /**
     * Returns parses depending on type.
     * @param parserType parser type
     * @return parser or exception
     */
    public IStringParser getParser(String parserType) {
        IStringParser parser = parsers.get(parserType);
        if (null == parser) {
            throw new IllegalStateException("Unsupported file format");
        }
        return parser;
    }
}
