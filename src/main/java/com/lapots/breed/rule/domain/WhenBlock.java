package com.lapots.breed.rule.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * XML <when> element.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class WhenBlock {
    @XmlElementWrapper(name = "conditions")
    @XmlElement(name = "condition")
    private List<Condition> conditions;
    @XmlElementWrapper(name = "bindings")
    @XmlElement(name = "binding")
    private List<Binding> bindings;
}
