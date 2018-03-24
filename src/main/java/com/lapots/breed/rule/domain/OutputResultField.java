package com.lapots.breed.rule.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * XML <output> element.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class OutputResultField {
    @XmlAttribute(name = "name")
    private String fieldName;
    @XmlAttribute(name = "type")
    private String fieldType;
    @XmlAttribute(name = "access")
    private String fieldAccess;
}
