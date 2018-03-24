package com.lapots.breed.rule.parser;

import com.lapots.breed.rule.domain.DataRule;
import lombok.Data;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * Parses xml file.
 */
public class XmlFileParser {
    /**
     * Parses xml file with rules.
     * @param filename file to parse
     * @return list of parsed rules
     */
    public List<DataRule> parseRuleFile(String filename) {
        try {
            URL xmlFile = this.getClass().getClassLoader().getResource(filename);
            DataRules allRules = JAXB.unmarshal(xmlFile.toURI(), DataRules.class);
            return allRules.rules;
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * XML root element for inner use in parser.
     * Should be static as non-static aren't supported by JAXB.
     */
    @Data
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD) // need for lombok
    private static class DataRules {
        @XmlElement(name = "rule")
        private List<DataRule> rules;
    }
}
