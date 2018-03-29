package com.lapots.breed.rule.generator.template.populator;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.domain.Field;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Populates imports in template.
 */
public class ImportsPopulator extends AbstractPopulator {
    private static final List<String> JVM_IMPORTS = Arrays.asList("int", "float", "double", "long");

    /**
     * Constructor.
     *
     * @param next next populator in chain
     */
    public ImportsPopulator(ITemplatePopulator next) {
        super(next);
    }

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        // TODO:add mapping support
        List<String> imports = Stream.concat(src.getInputs().stream(), src.getOutputs().stream())
                .map(Field::getFieldType)
                .filter(type -> !JVM_IMPORTS.contains(type))
                .distinct()
                .sorted() // to have order
                .collect(Collectors.toList());
        templateData.put("imports", imports);
        return templateData;
    }
}
