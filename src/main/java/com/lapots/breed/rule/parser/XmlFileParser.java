package com.lapots.breed.rule.parser;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.parser.api.AbstractFileParser;

import javax.xml.bind.JAXB;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * Parses xml file.
 */
public class XmlFileParser extends AbstractFileParser {

    @Override
    public List<DataRule> parseRuleFile(String filename) {
        try {
            URL xmlFile = this.getClass().getClassLoader().getResource(filename);
            DataRules allRules = JAXB.unmarshal(xmlFile.toURI(), DataRules.class);
            return allRules.getRules();
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

}
