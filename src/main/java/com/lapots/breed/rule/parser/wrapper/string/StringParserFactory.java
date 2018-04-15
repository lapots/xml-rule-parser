package com.lapots.breed.rule.parser.wrapper.string;

import com.lapots.breed.rule.parser.string.JsonStringParser;
import com.lapots.breed.rule.parser.string.XmlStringParser;
import com.lapots.breed.rule.parser.string.api.IStringParser;
import com.lapots.breed.rule.parser.wrapper.api.IParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * String parser factory.
 */
public class StringParserFactory implements IParserFactory<IStringParser> {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringParserFactory.class);

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
        LOGGER.debug("Retrieving parser for [{}].", key);
        IStringParser parser = parsers.get(key);
        checkArgument(null != parser, "Unsupported format for data!");
        return parser;
    }
}
