package com.lapots.breed.rule.parser.api;

import com.lapots.breed.rule.domain.DataRule;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Abstract parser.
 */
public abstract class AbstractFileParser implements IFileParser {

    /**
     * XML root element for inner use in parser.
     * Should be static as non-static aren't supported by JAXB.
     */
    @Data
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD) // need for lombok
    protected static class DataRules {
        @XmlElement(name = "rule")
        private List<DataRule> rules;
    }

}
