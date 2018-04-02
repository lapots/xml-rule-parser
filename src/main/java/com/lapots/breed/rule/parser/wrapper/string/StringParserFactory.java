package com.lapots.breed.rule.parser.wrapper.string;

import com.lapots.breed.rule.parser.string.JsonStringParser;
import com.lapots.breed.rule.parser.string.XmlStringParser;
import com.lapots.breed.rule.parser.string.api.IStringParser;
import com.lapots.breed.rule.parser.wrapper.api.IParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * String parser factory.
 */
public class StringParserFactory implements IParserFactory<IStringParser> {
    private Map<String, IStringParser> parsers;
    /**
     * Constructor.
     */
    StringParserFactory() {
        parsers = new HashMap<>();
        parsers.put("xml", new XmlStringParser());
        parsers.put("json", new JsonStringParser());
    }

    @Override
    public IStringParser getParser(String key) {
        IStringParser parser = parsers.get(key);
        if (null == parser) {
            throw new IllegalStateException("Unsupported file format");
        }
        return parser;
    }
}
