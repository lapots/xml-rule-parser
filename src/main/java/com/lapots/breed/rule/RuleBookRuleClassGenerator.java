package com.lapots.breed.rule;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.PebbleTemplateEngineClassGenerator;
import com.lapots.breed.rule.generator.template.api.ITemplateEngineClassGenerator;
import com.lapots.breed.rule.generator.template.populator.*;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;
import com.lapots.breed.rule.parser.JsonFileParser;
import com.lapots.breed.rule.parser.XmlFileParser;
import com.lapots.breed.rule.parser.api.IFileParser;
import com.lapots.breed.rule.parser.api.SupportedTypes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generates RuleBook rule class using xml.
 *
 * It's a prototype class so it's TEMPORARY implementation.
 */
public class RuleBookRuleClassGenerator {

    /**
     * Temporary implementation of class generator.
     * @param filename file to process
     * @return list of class bodies with rules
     */
    public List<String> generate(String filename) {
        // prepare parser
        String filetype = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
        SupportedTypes type = SupportedTypes.valueOf(filetype);

        IFileParser parser;
        if (type == SupportedTypes.XML) {
            parser = new XmlFileParser();
        } else if (type == SupportedTypes.JSON) {
            parser = new JsonFileParser();
        } else {
            throw new IllegalStateException("Unsupported file format");
        }
        // do parsing
        List<DataRule> parsedRules = parser.parseRuleFile(filename);

        // prepare class generation
        // from top to bottom
        // TODO:refactor
        ITemplatePopulator rhsPopulator = new RightHandSidePopulator(null);
        ITemplatePopulator lhsPopulator = new LeftHandSidePopulator(rhsPopulator);
        ITemplatePopulator fieldsPopulator = new FieldsPopulator(lhsPopulator);
        ITemplatePopulator classNamePopulator = new ClassNamePopulator(fieldsPopulator);
        ITemplatePopulator ruleNamePopulator = new RuleNamePopulator(classNamePopulator);
        ITemplatePopulator importsPopulator = new ImportsPopulator(ruleNamePopulator);
        ITemplatePopulator packagePopulator = new PackageNamePopulator(importsPopulator);
        ITemplateEngineClassGenerator templateClassGenerator =
                new PebbleTemplateEngineClassGenerator("./template/rule_class_template.template",
                        packagePopulator);
        // generate
        return parsedRules
                .stream()
                .map(templateClassGenerator::generateClass)
                .collect(Collectors.toList());
    }

}
