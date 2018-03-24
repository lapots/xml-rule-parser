package com.lapots.breed.rule.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * XML <execution> entry.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecutionRule {
    @XmlElement
    private ThenBlock then;
    @XmlElement
    private WhenBlock when;
}
