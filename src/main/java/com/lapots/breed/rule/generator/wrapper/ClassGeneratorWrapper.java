package com.lapots.breed.rule.generator.wrapper;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.PebbleTemplateEngineClassGenerator;
import com.lapots.breed.rule.generator.template.api.IClassGenerator;
import com.lapots.breed.rule.generator.template.populator.PackageNamePopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;
import com.lapots.breed.rule.internal.ConfigurationHolder;

/**
 * Wrapper over class generation.
 */
public class ClassGeneratorWrapper implements IClassGenerator {
    @Override
    public String generateClass(DataRule object) {
        String template = ConfigurationHolder.findByKey("class_template");
        Injector injector = Guice.createInjector(new PopulatorModule());
        ITemplatePopulator first = injector.getInstance(PackageNamePopulator.class); // first in chain

        // TODO:implement something similar to file parsing
        IClassGenerator templateEngineGenerator = new PebbleTemplateEngineClassGenerator(template, first);
        return templateEngineGenerator.generateClass(object);
    }
}
