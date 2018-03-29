package com.lapots.breed.rule.generator.template.populator;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.domain.ThenBlock;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;

import java.util.Map;

/**
 * Populates rhs in template.
 */
public class RightHandSidePopulator extends AbstractPopulator {
    /**
     * Constructor.
     *
     * @param next next populator in chain
     */
    public RightHandSidePopulator(ITemplatePopulator next) {
        super(next);
    }

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        ThenBlock then = src.getExecution().getThen(); // assuming that then will be initialized always
        templateData.put("rhs", then.getCode() == null ? "" : then.getCode());
        return templateData;
    }
}
