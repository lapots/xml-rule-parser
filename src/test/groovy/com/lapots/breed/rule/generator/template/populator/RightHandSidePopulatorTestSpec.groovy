package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.domain.DataRule
import com.lapots.breed.rule.domain.ExecutionRule
import com.lapots.breed.rule.domain.ThenBlock

class RightHandSidePopulatorTestSpec extends PopulatorTestSpecification {

    def "should add rhs to map"() {
        setup:
        def populator = new RightHandSidePopulator(next: null)
        def src = new DataRule(
                execution: new ExecutionRule(
                        then: new ThenBlock(code: "int x = 1")
                )
        )
        expect:
        ["rhs": "int x = 1"] == populator.populate([:], src)
    }

    def "should add empty to map"() {
        setup:
        def populator = new RightHandSidePopulator(next: null)
        def src = new DataRule(
                execution: new ExecutionRule(
                        then: new ThenBlock()
                )
        )
        expect:
        ["rhs": ""] == populator.populate([:], src)
    }
}
