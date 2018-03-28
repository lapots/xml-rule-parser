package com.lapots.breed.rule.generator.template.populators;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.populators.api.ITemplatePopulator;

import java.util.Map;

/**
 * Populates package name in template.
 */
public class PackageNamePopulator implements ITemplatePopulator {
    private ITemplatePopulator next;

    /**
     * Constructor.
     * @param next next populator in chain
     */
    public PackageNamePopulator(ITemplatePopulator next) {
        this.next = next;
    }

    @Override
    public Map<String, Object> populate(Map<String, Object> templateData, DataRule src) {
        if (null != next) {
            return next.populate(templateData, src);
        }
        return templateData;
    }
}
