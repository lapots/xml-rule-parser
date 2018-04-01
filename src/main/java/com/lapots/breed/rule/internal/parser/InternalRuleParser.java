package com.lapots.breed.rule.internal.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lapots.breed.rule.domain.DataRule;
import lombok.Data;
import lombok.experimental.UtilityClass;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * Internal parser.
 */
@UtilityClass
public class InternalRuleParser {

    /**
     * Parses xml file.
     * @param xmlFile xml file
     * @return list of rules
     */
    public List<DataRule> parseXmlFile(URL xmlFile) {
        DataRules allRules = null;
        try {
            allRules = JAXB.unmarshal(xmlFile.toURI(), DataRules.class);
            return allRules.getRules();
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Parses json file.
     * @param jsonFile json file
     * @return list of rules
     */
    public List<DataRule> parseJsonFile(URL jsonFile) {
        ObjectMapper mapper = new ObjectMapper();
        DataRules allRules = null;
        try {
            allRules = mapper.readValue(jsonFile, DataRules.class);
            return allRules.getRules();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Parses xml string.
     * @param xmlString xml string
     * @return list of rules
     */
    public List<DataRule> parseXmlString(String xmlString) {
        DataRules allRules = JAXB.unmarshal(xmlString, DataRules.class);
        return allRules.getRules();
    }

    /**
     * Parses json string.
     * @param jsonString json string
     * @return list of rules
     */
    public List<DataRule> parseJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        DataRules allRules = null;
        try {
            allRules = mapper.readValue(jsonString, DataRules.class);
            return allRules.getRules();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Internal class that wraps top level element.
     */
    @Data
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD) // need for lombok
    private static class DataRules {
        @XmlElement(name = "rule")
        private List<DataRule> rules;
    }
}
