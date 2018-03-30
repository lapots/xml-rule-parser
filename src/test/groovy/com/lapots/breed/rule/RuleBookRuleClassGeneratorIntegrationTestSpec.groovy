package com.lapots.breed.rule

import spock.lang.Ignore
import spock.lang.Specification

class RuleBookRuleClassGeneratorIntegrationTestSpec extends Specification {

    @Ignore("Equal visually")
    def "should parse rule xml"() {
        setup:
            def ruleGenerator = new RuleBookRuleClassGenerator()
            def expectedClass = this.getClass().getResource("/integ/classgen/generated.txt").text
        expect:
            [expectedClass] == ruleGenerator.generate("./integ/classgen/integ-simple-rule.xml")
    }

    @Ignore("Equal visually")
    def "should parse rule json"() {
        setup:
            def ruleGenerator = new RuleBookRuleClassGenerator()
            def expectedClass = this.getClass().getResource("/integ/classgen/generated.txt").text
        expect:
            [expectedClass] == ruleGenerator.generate("./integ/classgen/integ-simple-rule.json")
    }
}
