package com.lapots.breed.rule.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * XML <input> mirror.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class InputFactField {
    @JsonProperty("fact")
    @XmlAttribute(name = "fact")
    private String factName;
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
