package com.lapots.breed.rule.parser.wrapper.file;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.parser.file.api.IFileParser;
import com.lapots.breed.rule.parser.wrapper.api.IParserFactory;
import org.apache.commons.io.FilenameUtils;

import java.util.List;

/**
 * Wrapper over file parsing.
 */
public class RuleFileParserWrapper implements IFileParser {
    private IParserFactory<IFileParser> factory;

    /**
     * Constructor.
     */
    public RuleFileParserWrapper() {
        factory = new FileParserFactory();
    }

    @Override
    public List<DataRule> parseRuleFile(String filename) {
        String extension = FilenameUtils.getExtension(filename);
        IFileParser parser = factory.getParser(extension);
        return parser.parseRuleFile(filename);
    }
}
