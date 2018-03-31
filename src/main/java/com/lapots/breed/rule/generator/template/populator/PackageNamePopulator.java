package com.lapots.breed.rule.generator.template.populator;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;
import com.lapots.breed.rule.internal.ConfigurationHolder;

import java.util.Map;

import static com.lapots.breed.rule.internal.Constants.CONFIGURATION_PACKAGE_ENTRY;
import static com.lapots.breed.rule.internal.Constants.PACKAGE_NAME_TOKEN;

/**
 * Populates package name in template.
 */
public class PackageNamePopulator extends AbstractPopulator {

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        templateData.put(PACKAGE_NAME_TOKEN, ConfigurationHolder.findByKey(CONFIGURATION_PACKAGE_ENTRY));
        return templateData;
    }

    @Override
    @Inject
    protected void injectNext(@Named("importsPopulator") ITemplatePopulator next) {
        setNext(next);
    }
}
