package com.lapots.breed.rule.generator.template.api;

import com.lapots.breed.rule.domain.DataRule;

/**
 * Interface for template engine class generation.
 */
public interface ITemplateEngineClassGenerator {
    /**
     * Generate string representation of class from the object.
     * @param object object with data
     * @return string of generated class
     */
    String generateClass(DataRule object);
}
