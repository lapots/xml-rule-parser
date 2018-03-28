package com.lapots.breed.rule.generator.template;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.api.ITemplateEngineClassGenerator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Class generation using Pebble template engine.
 */
public class PebbleTemplateEngineClassGenerator implements ITemplateEngineClassGenerator {

    private String template;
    private ITemplatePopulator populator;

    /**
     * Constructor.
     * @param template path to template
     * @param populator class for template parameter population
     */
    public PebbleTemplateEngineClassGenerator(String template, ITemplatePopulator populator) {
        this.template = template;
        this.populator = populator;
    }

    @Override
    public String generateClass(DataRule object) {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        try {
            PebbleTemplate pbTemplate = engine.getTemplate(template);
            Map<String, Object> context = new HashMap<>();
            context = populator.populate(context, object);

            Writer writer = new StringWriter();
            pbTemplate.evaluate(writer, context);

            return writer.toString();
        } catch (PebbleException | IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
