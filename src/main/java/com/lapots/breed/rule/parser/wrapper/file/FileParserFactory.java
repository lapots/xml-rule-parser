package com.lapots.breed.rule.parser.wrapper.file;

import com.lapots.breed.rule.parser.file.JsonFileParser;
import com.lapots.breed.rule.parser.file.XmlFileParser;
import com.lapots.breed.rule.parser.file.api.IFileParser;
import com.lapots.breed.rule.parser.wrapper.api.IParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * File parser factory.
 */
public class FileParserFactory implements IParserFactory<IFileParser> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileParserFactory.class);

    private Map<String, IFileParser> parsers;
    /**
     * Constructor.
     */
    FileParserFactory() {
        parsers = new HashMap<>();
        parsers.put("xml", new XmlFileParser());
        parsers.put("json", new JsonFileParser());
    }

    @Override
    public IFileParser getParser(String key) {
        LOGGER.debug("Retrieving parser for [{}].", key);
        IFileParser parser = parsers.get(key);
        checkArgument(parser != null, "Unsupported file format!");
        return parser;
    }
}
