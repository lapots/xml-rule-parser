package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.domain.DataRule

class RuleNamePopulatorTestSpec extends PopulatorTestSpecification {

    def "should populate with rule name"() {
        setup:
            def populator = new RuleNamePopulator(next: null)
        expect:
            [ "ruleName" : "basic name" ] == populator.populate([:], new DataRule(ruleName: "basic name"))
    }
}
