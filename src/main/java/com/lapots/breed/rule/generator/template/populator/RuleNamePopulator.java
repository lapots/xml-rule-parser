package com.lapots.breed.rule.generator.template.populator;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;

import java.util.Map;

/**
 * Populates rule name in template.
 */
public class RuleNamePopulator extends AbstractPopulator {
    /**
     * Constructor.
     *
     * @param next next populator in chain
     */
    public RuleNamePopulator(ITemplatePopulator next) {
        super(next);
    }

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        templateData.put("ruleName", src.getRuleName());
        return templateData;
    }
}
