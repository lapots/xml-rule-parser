package com.lapots.breed.rule.parser.file;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.internal.parser.InternalRuleParser;
import com.lapots.breed.rule.parser.file.api.IFileParser;

import java.net.URL;
import java.util.List;

/**
 * Parses xml file.
 */
public class XmlFileParser implements IFileParser {

    @Override
    public List<DataRule> parseRuleFile(String filename) {
        URL xmlFile = this.getClass().getClassLoader().getResource(filename);
        return InternalRuleParser.parseXmlFile(xmlFile);
    }

}
