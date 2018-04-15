package com.lapots.breed.rule.builder;

import com.lapots.breed.rule.compiler.api.IStringCompiler;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.generator.template.api.IClassGenerator;
import com.lapots.breed.rule.parser.api.IRuleParser;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Builder for class generation.
 */
public class RuleClassGenerator {
    private IRuleParser parser;
    private IClassGenerator generator;
    private IStringCompiler compiler;
    private BuilderType type;
    private ClassLoader classLoader;

    /**
     * Sets parser.
     * @param parser parser
     * @return this
     */
    public RuleClassGenerator withParser(IRuleParser parser) {
        this.parser = parser;
        return this;
    }

    /**
     * Sets generator.
     * @param generator generator
     * @return this
     */
    public RuleClassGenerator withGenerator(IClassGenerator generator) {
        this.generator = generator;
        return this;
    }

    /**
     * Sets compiler.
     * @param compiler compiler
     * @return this
     */
    public RuleClassGenerator withCompiler(IStringCompiler compiler) {
        this.compiler = compiler;
        return this;
    }

    /**
     * Sets builder type.
     * @param type type
     * @return this
     */
    public RuleClassGenerator withBuilderType(BuilderType type) {
        this.type = type;
        return this;
    }

    /**
     * Sets builder type.
     * @param classLoader classloader
     * @return this
     */
    public RuleClassGenerator withClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        return this;
    }

    /**
     * Generates classes from the input.
     * @param input input
     * @return classes
     */
    public List<Class<?>> generate(String input) {
        checkArgument(null != parser, "No parser set!");
        checkArgument(null != generator, "No generator set!");
        checkArgument(null != compiler, "No compiler set!");
        checkArgument(null != type, "No type set!");

        List<DataRule> parsedRules;
        switch (type) {
            case STRING:
                parsedRules = parser.parseDocument(input);
                break;
            case FILE:
                parsedRules = parser.parseFile(input);
                break;
            default:
                throw new IllegalStateException("Not supported type to parse");
        }

        List<String> generated = parsedRules
                .stream()
                .map(generator::generateClass)
                .collect(Collectors.toList());

        return generated
                .stream()
                .map(clz -> compiler.compile(clz, classLoader))
                .collect(Collectors.toList());
    }

    /**
     * Enum for build types.
     */
    public enum BuilderType {
        /** File builder type. */
        FILE,
        /** File string type. */
        STRING;
    }
}
