package com.lapots.breed.rule.generator.template.populator.api;

import com.lapots.breed.rule.domain.DataRule;

import java.util.Map;

/**
 * Abstract populator.
 */
public abstract class AbstractPopulator implements ITemplatePopulator {
    private ITemplatePopulator next;

    @Override
    public Map<String, Object> populate(Map<String, Object> templateData, DataRule src) {
        templateData = internalPopulate(templateData, src);

        if (null != next) {
            return next.populate(templateData, src);
        }
        return templateData;
    }

    /**
     * Sets next.
     * @param next next
     */
    protected void setNext(ITemplatePopulator next) {
        this.next = next;
    }

    /**
     * Internal action for data population.
     * @param templateData map for template
     * @param src data rule with all data
     * @return map with additional data
     */
    protected abstract Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src);

    /**
     * Injects next in chain.
     * @param next next
     */
    protected abstract void injectNext(ITemplatePopulator next);
}
