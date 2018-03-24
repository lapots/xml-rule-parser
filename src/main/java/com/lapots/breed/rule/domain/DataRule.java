package com.lapots.breed.rule.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * XML <rule> entry.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DataRule {
    @XmlAttribute(name = "name")
    private String ruleName;
    @XmlElement
    private List<InputFactField> inputs;
    @XmlElement
    private List<OutputResultField> outputs;
    @XmlElement
    private ExecutionRule execution;
}
