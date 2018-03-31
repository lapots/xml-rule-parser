package com.lapots.breed.rule;

import com.lapots.breed.rule.compiler.OpenhftCachedCompiler;
import com.lapots.breed.rule.compiler.api.IStringCompiler;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.api.IClassGenerator;
import com.lapots.breed.rule.generator.wrapper.ClassGeneratorWrapper;
import com.lapots.breed.rule.parser.api.IFileParser;
import com.lapots.breed.rule.parser.wrapper.RuleFileParserWrapper;

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
    public List<Class<?>> generate(String filename) {
        // parse file
        IFileParser parser = new RuleFileParserWrapper();
        List<DataRule> parsedRules = parser.parseRuleFile(filename);

        // generate java strings
        IClassGenerator generator = new ClassGeneratorWrapper();
        List<String> generated = parsedRules
                .stream()
                .map(generator::generateClass)
                .collect(Collectors.toList());

        // compile java strings
        IStringCompiler compiler = new OpenhftCachedCompiler();
        ClassLoader cl = this.getClass().getClassLoader();

        // return classes
        return generated
                .stream()
                .map(clz -> compiler.compile(clz, cl))
                .collect(Collectors.toList());
    }

    /**
     * Main method for testing.
     * @param args console args
     */
    public static void main(String[] args) {
        RuleBookRuleClassGenerator clz = new RuleBookRuleClassGenerator();
        List<Class<?>> classes = clz.generate("sample-rule.xml");
        System.out.println("classes: " + classes);
    }
}
