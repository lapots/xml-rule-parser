package com.lapots.breed.rule.builder

import com.lapots.breed.rule.compiler.OpenhftCachedCompiler
import com.lapots.breed.rule.generator.wrapper.ClassGeneratorWrapper
import com.lapots.breed.rule.parser.DefaultRuleParser
import spock.lang.Ignore
import spock.lang.Specification


class RuleClassGeneratorTestSpec extends Specification {
    def "should build generator and process empty rule"() {
        setup:
        def generator = new RuleClassGenerator()
                .withBuilderType(RuleClassGenerator.BuilderType.FILE)
                .withClassLoader(this.getClass().getClassLoader())
                .withCompiler(new OpenhftCachedCompiler())
                .withGenerator(new ClassGeneratorWrapper())
                .withParser(new DefaultRuleParser())
        when:
        def genClass = generator.generate("sample-empty-rule.xml")[0]
        def genObject = genClass.newInstance()
        then:
        assert genObject.when()
    }

    @Ignore
    def "should build generator and process single rule"() {
        setup:
        def generator = new RuleClassGenerator()
                .withBuilderType(RuleClassGenerator.BuilderType.FILE)
                .withClassLoader(this.getClass().getClassLoader())
                .withCompiler(new OpenhftCachedCompiler())
                .withGenerator(new ClassGeneratorWrapper())
                .withParser(new DefaultRuleParser())
        when:
        def genClass = generator.generate("sample-basic-rule.xml")[0]
        def genObject = genClass.newInstance()
        genObject.input1 = 80
        then:
        assert genObject.when() == false
    }
}
