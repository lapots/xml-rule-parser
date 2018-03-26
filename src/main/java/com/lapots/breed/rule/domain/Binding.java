package com.lapots.breed.rule.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * XML <binding> element.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Binding {
    @XmlAttribute
    private String type;
    @XmlElement(name = "condition")
    private List<String> conditions;
}
