package com.lapots.breed.rule.parser.wrapper;

import com.lapots.breed.rule.parser.JsonFileParser;
import com.lapots.breed.rule.parser.XmlFileParser;
import com.lapots.breed.rule.parser.api.IFileParser;

import java.util.HashMap;
import java.util.Map;

/**
 * File parser factory.
 */
public class FileParserFactory {
    private Map<String, IFileParser> parsers;
    /**
     * Constructor.
     */
    FileParserFactory() {
        parsers = new HashMap<>();
        parsers.put("xml", new XmlFileParser());
        parsers.put("json", new JsonFileParser());
    }

    /**
     * Returns parser depending of file extension.
     * @param extension extension
     * @return parser or exception
     */
    public IFileParser getParser(String extension) {
        IFileParser parser = parsers.get(extension);
        if (null == parser) {
            throw new IllegalStateException("Unsupported file format");
        }

        return parser;
    }
}
