package com.lapots.breed.rule.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * XML <left> or <right> element.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ConditionSide {
    @XmlElement
    private String code;
}
