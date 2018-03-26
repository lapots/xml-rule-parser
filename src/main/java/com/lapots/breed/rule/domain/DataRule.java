package com.lapots.breed.rule.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * XML <rule> entry.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DataRule {
    @XmlAttribute(name = "name")
    private String ruleName;
    @XmlElementWrapper(name = "inputs")
    @XmlElement(name = "input")
    private List<InputFactField> inputs;
    @XmlElementWrapper(name = "outputs")
    @XmlElement(name = "output")
    private List<OutputResultField> outputs;
    @XmlElement
    private ExecutionRule execution;
}
