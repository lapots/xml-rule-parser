package com.lapots.breed.rule.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("condition")
    @XmlElement(name = "condition")
    private List<String> conditions;
}
