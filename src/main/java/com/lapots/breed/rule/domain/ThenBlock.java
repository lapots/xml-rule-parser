package com.lapots.breed.rule.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * XML <then> element.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ThenBlock {
    @XmlElement
    private String code;
}
