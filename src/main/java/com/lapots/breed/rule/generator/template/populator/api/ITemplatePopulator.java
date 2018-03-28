package com.lapots.breed.rule.generator.template.populator.api;

import com.lapots.breed.rule.domain.DataRule;

import java.util.Map;

/**
 * Interface for data populator.
 */
public interface ITemplatePopulator {
    /**
     * Populates map with data.
     * @param templateData map for template
     * @param src data rule with all data
     * @return map with additional data
     */
    Map<String, Object> populate(Map<String, Object> templateData, DataRule src);
}
