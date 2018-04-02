package com.lapots.breed.rule.parser.wrapper.file;

import com.lapots.breed.rule.parser.file.JsonFileParser;
import com.lapots.breed.rule.parser.file.XmlFileParser;
import com.lapots.breed.rule.parser.file.api.IFileParser;
import com.lapots.breed.rule.parser.wrapper.api.IParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * File parser factory.
 */
public class FileParserFactory implements IParserFactory<IFileParser> {
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
        IFileParser parser = parsers.get(key);
        if (null == parser) {
            throw new IllegalStateException("Unsupported file format");
        }
        return parser;
    }
}
