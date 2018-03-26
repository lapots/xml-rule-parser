package com.lapots.breed.rule.generator.api;

import com.lapots.breed.rule.domain.DataRule;

import java.util.List;

/**
 * Common interface for class generators.
 */
public interface IClassGenerator {
    /**
     * Generates single class from data rule.
     * @param rule rule
     * @return class
     */
    Class<?> generateSingleRule(DataRule rule);

    /**
     * Generates list of classes from list of rules
     * @param rules rule
     * @return class
     */
    List<Class<?>> generateRules(List<DataRule> rules);
}
