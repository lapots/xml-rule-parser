package com.lapots.breed.rule.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * XML <condition> element.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Condition {
    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private String conditionId;
    @JsonProperty("type")
    @XmlAttribute(name = "type")
    private String conditionType;
    @XmlElement
    private ConditionSide left;
    @XmlElement
    private ConditionSide right;
}
