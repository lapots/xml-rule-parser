package com.lapots.breed.rule.generator.template.populator;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.domain.Field;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.lapots.breed.rule.internal.Constants.IMPORTS_TOKEN;
import static com.lapots.breed.rule.internal.Constants.JVM_IMPORTS;

/**
 * Populates imports in template.
 */
public class ImportsPopulator extends AbstractPopulator {

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        // TODO:add mapping support
        List<String> imports = Stream.concat(src.getInputs().stream(), src.getOutputs().stream())
                .map(Field::getFieldType)
                .filter(type -> !JVM_IMPORTS.contains(type))
                .distinct()
                .sorted() // to have order
                .collect(Collectors.toList());
        templateData.put(IMPORTS_TOKEN, imports);
        return templateData;
    }

    @Override
    @Inject
    protected void injectNext(@Named("ruleNamePopulator") ITemplatePopulator next) {
        setNext(next);
    }
}
