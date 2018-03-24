package com.lapots.breed.rule.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * XML <binding> element.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Binding {
    @XmlAttribute
    private String type;
    @XmlElement
    private String condition;
}
