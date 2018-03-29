package com.lapots.breed.rule.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Field entry in XML.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Field {
    @JsonProperty("name")
    @XmlAttribute(name = "name")
    private String fieldName;
    @JsonProperty("type")
    @XmlAttribute(name = "type")
    private String fieldType;
    @JsonProperty("access")
    @XmlAttribute(name = "access")
    private String fieldAccess;
}
