package com.lapots.breed.rule.generator.template.populator;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;

import java.util.Map;

import static com.lapots.breed.rule.internal.Constants.RULE_NAME_TOKEN;

/**
 * Populates rule name in template.
 */
public class RuleNamePopulator extends AbstractPopulator {

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        templateData.put(RULE_NAME_TOKEN, src.getRuleName());
        return templateData;
    }

    @Override
    @Inject
    protected void injectNext(@Named("classNamePopulator") ITemplatePopulator next) {
        setNext(next);
    }
}
