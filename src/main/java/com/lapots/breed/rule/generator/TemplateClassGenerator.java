package com.lapots.breed.rule.generator;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.api.IClassGenerator;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Generator of class that uses templates.
 */
public class TemplateClassGenerator implements IClassGenerator {
    private static final String DEFAULT_CLASS_TEMPLATE = "/template/rule_class_template.template";

    @Override
    public Class<?> generateSingleRule(DataRule rule) {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        try {
            PebbleTemplate template = engine.getTemplate(DEFAULT_CLASS_TEMPLATE);
            Map<String, Object> context = new HashMap<>();
        } catch (PebbleException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Class<?>> generateRules(List<DataRule> rules) {
        return rules.stream()
                .map(this::generateSingleRule)
                .collect(Collectors.toList());
    }
}
