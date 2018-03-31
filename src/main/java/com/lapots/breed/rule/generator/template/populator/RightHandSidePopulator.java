package com.lapots.breed.rule.generator.template.populator;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.domain.ThenBlock;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;

import java.util.Map;

import static com.lapots.breed.rule.internal.Constants.RHS_TOKEN;

/**
 * Populates rhs in template.
 */
public class RightHandSidePopulator extends AbstractPopulator {

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        ThenBlock then = src.getExecution().getThen(); // assuming that then will be initialized always
        templateData.put(RHS_TOKEN, then.getCode() == null ? "" : then.getCode());
        return templateData;
    }

    @Override
    @Inject(optional = true) // may God help us
    protected void injectNext(@Named("null") ITemplatePopulator next) {
        setNext(next);
    }
}
