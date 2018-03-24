package com.lapots.breed.rule.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * XML <when> element.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class WhenBlock {
    @XmlElement
    private List<Condition> conditions;
}
