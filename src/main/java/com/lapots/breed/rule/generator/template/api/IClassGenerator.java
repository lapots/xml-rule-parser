package com.lapots.breed.rule.generator.template.api;

import com.lapots.breed.rule.domain.DataRule;

/**
 * Interface for class generation.
 */
public interface IClassGenerator {
    /**
     * Generate string representation of class from the object.
     * @param object object with data
     * @return string of generated class
     */
    String generateClass(DataRule object);
}
