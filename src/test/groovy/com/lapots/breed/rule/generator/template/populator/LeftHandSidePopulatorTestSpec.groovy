package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.domain.Binding
import com.lapots.breed.rule.domain.Condition
import com.lapots.breed.rule.domain.ConditionSide
import com.lapots.breed.rule.domain.DataRule
import com.lapots.breed.rule.domain.ExecutionRule
import com.lapots.breed.rule.domain.WhenBlock
import com.lapots.breed.rule.internal.ConfigurationHolder
import org.mockito.Mockito

class LeftHandSidePopulatorTestSpec extends PopulatorTestSpecification {

    def "should create left hand side"() {
        setup:
            def src = new DataRule(
                    execution: new ExecutionRule(
                            when: new WhenBlock(
                                    conditions: [
                                            new Condition(
                                                    conditionId: "cond_1",
                                                    conditionType: "less_than",
                                                    left: new ConditionSide(
                                                            code: "5"
                                                    ),
                                                    right: new ConditionSide(
                                                            code: "15"
                                                    )
                                            ),
                                            new Condition(
                                                    conditionId: "cond_2",
                                                    conditionType: "more_than",
                                                    left: new ConditionSide(
                                                            code: "10"
                                                    ),
                                                    right: new ConditionSide(
                                                            code: "15"
                                                    )
                                            )
                                    ],
                                    bindings: [
                                            new Binding(
                                                    type: "and",
                                                    conditions: [ "cond_1", "cond_2" ]
                                            )
                                    ]
                            )
                    )
            )
            def populator = new LeftHandSidePopulator(next: null)
        when:
            Mockito.when(ConfigurationHolder.findByKey("bindings.and")).thenReturn("&&")
            Mockito.when(ConfigurationHolder.findByKey("conditions.less_than")).thenReturn("<")
            Mockito.when(ConfigurationHolder.findByKey("conditions.more_than")).thenReturn(">")
        then:
            assert ["lhs" : "5 < 15 && 10 > 15"] == populator.populate([:], src)
    }
}
