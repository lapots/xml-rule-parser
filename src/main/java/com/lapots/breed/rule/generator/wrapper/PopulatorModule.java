package com.lapots.breed.rule.generator.wrapper;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.lapots.breed.rule.generator.template.populator.*;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;

/**
 * Guice module with configuration.
 */
public class PopulatorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ITemplatePopulator.class)
                .annotatedWith(Names.named("packageNamePopulator")).to(PackageNamePopulator.class);
        bind(ITemplatePopulator.class)
                .annotatedWith(Names.named("importsPopulator")).to(ImportsPopulator.class);
        bind(ITemplatePopulator.class)
                .annotatedWith(Names.named("ruleNamePopulator")).to(RuleNamePopulator.class);
        bind(ITemplatePopulator.class)
                .annotatedWith(Names.named("classNamePopulator")).to(ClassNamePopulator.class);
        bind(ITemplatePopulator.class)
                .annotatedWith(Names.named("fieldsPopulator")).to(FieldsPopulator.class);
        bind(ITemplatePopulator.class)
                .annotatedWith(Names.named("leftHandSidePopulator")).to(LeftHandSidePopulator.class);
        bind(ITemplatePopulator.class)
                .annotatedWith(Names.named("rightHandSidePopulator")).to(RightHandSidePopulator.class);
    }
}
