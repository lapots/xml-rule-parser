package com.lapots.breed.rule;

import com.lapots.breed.rule.builder.RuleClassGenerator;
import com.lapots.breed.rule.compiler.OpenhftCachedCompiler;
import com.lapots.breed.rule.generator.wrapper.ClassGeneratorWrapper;
import com.lapots.breed.rule.parser.DefaultRuleParser;

import java.util.List;

/**
 * Generates RuleBook rule class using xml.
 *
 * It's a prototype class so it's TEMPORARY implementation.
 */
public class RuleBookRuleClassGenerator {

    /**
     * Temporary implementation of class generator.
     *
     * May serve as an example of library usage.
     *
     * @param filename file to process
     * @return list of class bodies with rules
     */
    public List<Class<?>> generate(String filename) {
        return new RuleClassGenerator()
                .withClassLoader(this.getClass().getClassLoader())
                .withCompiler(new OpenhftCachedCompiler())
                .withGenerator(new ClassGeneratorWrapper())
                .withBuilderType(RuleClassGenerator.BuilderType.FILE)
                .withParser(new DefaultRuleParser())
                .generate(filename);
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
