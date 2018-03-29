package com.lapots.breed.rule.generator.template.populator;

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
    /**
     * Constructor.
     *
     * @param next next populator in chain
     */
    public PackageNamePopulator(ITemplatePopulator next) {
        super(next);
    }

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        templateData.put(PACKAGE_NAME_TOKEN, ConfigurationHolder.findByKey(CONFIGURATION_PACKAGE_ENTRY));
        return templateData;
    }
}
