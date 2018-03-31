package com.lapots.breed.rule.generator.template.populator;

import com.google.common.base.CaseFormat;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;

import java.util.Map;

import static com.lapots.breed.rule.internal.Constants.CLASS_NAME_TOKEN;

/**
 * Populates class name in template.
 */
public class ClassNamePopulator extends AbstractPopulator {

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        String ruleName = src.getRuleName().replaceAll(" ", "_").toUpperCase();
        templateData.put(CLASS_NAME_TOKEN, CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, ruleName));
        return templateData;
    }

    @Override
    @Inject
    protected void injectNext(@Named("fieldsPopulator") ITemplatePopulator next) {
        setNext(next);
    }
}
