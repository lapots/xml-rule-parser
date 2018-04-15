package com.lapots.breed.rule.parser.wrapper.file;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.parser.file.api.IFileParser;
import com.lapots.breed.rule.parser.wrapper.api.IParserFactory;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Wrapper over file parsing.
 */
public class RuleFileParserWrapper implements IFileParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(RuleFileParserWrapper.class);

    private IParserFactory<IFileParser> factory;

    /**
     * Constructor.
     */
    public RuleFileParserWrapper() {
        factory = new FileParserFactory();
    }

    @Override
    public List<DataRule> parseRuleFile(String filename) {
        LOGGER.debug("Attempt to parse: [{}].", filename);
        String extension = FilenameUtils.getExtension(filename);
        IFileParser parser = factory.getParser(extension);
        return parser.parseRuleFile(filename);
    }
}
