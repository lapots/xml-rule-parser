package com.lapots.breed.rule.generator.template.populator;

import com.google.common.base.CaseFormat;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;

import java.util.Map;

import static com.lapots.breed.rule.internal.Constants.CLASS_NAME_TOKEN;

/**
 * Populates class name in template.
 */
public class ClassNamePopulator extends AbstractPopulator {

    /**
     * Constructor.
     *
     * @param next next populator in chain
     */
    public ClassNamePopulator(ITemplatePopulator next) {
        super(next);
    }

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        String ruleName = src.getRuleName().replaceAll(" ", "_").toUpperCase();
        templateData.put(CLASS_NAME_TOKEN, CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, ruleName));
        return templateData;
    }
}
