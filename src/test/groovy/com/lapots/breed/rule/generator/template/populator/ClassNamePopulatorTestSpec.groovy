package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.domain.DataRule

class ClassNamePopulatorTestSpec extends PopulatorTestSpecification {

    def "should populate with class name"() {
        setup:
            def populator = new ClassNamePopulator(null)
        expect:
            ["className": "BasicName"] == populator.populate([:], new DataRule(ruleName: "basic name"))
    }
}
