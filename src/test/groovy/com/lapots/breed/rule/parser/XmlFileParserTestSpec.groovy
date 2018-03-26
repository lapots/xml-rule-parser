package com.lapots.breed.rule.parser

import com.lapots.breed.rule.domain.Binding
import com.lapots.breed.rule.domain.Condition
import com.lapots.breed.rule.domain.ConditionSide
import com.lapots.breed.rule.domain.DataRule
import com.lapots.breed.rule.domain.ExecutionRule
import com.lapots.breed.rule.domain.InputFactField
import com.lapots.breed.rule.domain.OutputResultField
import com.lapots.breed.rule.domain.ThenBlock
import com.lapots.breed.rule.domain.WhenBlock
import spock.lang.Specification

/**
 * Tests for {@link XmlFileParser}.
 */
class XmlFileParserTestSpec extends Specification {

    def "should parse template xml and produce expected object"() {
        setup:
        def filename = "sample-empty-rule.xml"
        def parser = new XmlFileParser()
        def expected = new DataRule(
                ruleName: "sample rule",
                inputs: [],
                outputs: [],
                execution: new ExecutionRule(
                        then: new ThenBlock(),
                        when: new WhenBlock(conditions: [], bindings: [])
                )
        )
        expect:
        [ expected ] == parser.parseRuleFile(filename)
    }

    def "should parse basic xml and produce expected object"() {
        setup:
        def filename = "sample-basic-rule.xml"
        def parser = new XmlFileParser()
        def expected = new DataRule(
                ruleName: "sample rule",
                inputs: [
                    new InputFactField(
                            factName: "input_fact_1",
                            fieldName: "input1",
                            fieldType: "int",
                            fieldAccess: "private"
                    ),
                    new InputFactField(
                            factName: "input_fact_2",
                            fieldName: "input2",
                            fieldType: "int",
                            fieldAccess: "private"
                    ),
                ],
                outputs: [
                    new OutputResultField(
                            fieldName: "result",
                            fieldType: "int",
                            fieldAccess: "private"
                    )
                ],
                execution: new ExecutionRule(
                        then: new ThenBlock(
                                code: "result + 10"
                        ),
                        when: new WhenBlock(
                                conditions: [
                                    new Condition(
                                            conditionId: "cond_1",
                                            conditionType: "less_than",
                                            left: new ConditionSide(
                                                    code: "input"
                                            ),
                                            right: new ConditionSide(
                                                    code: "50"
                                            )
                                    )
                                ],
                                bindings: [
                                        new Binding(
                                                type: "and",
                                                conditions: [
                                                        "cond_1"
                                                ]
                                        )
                                ]
                        )
                )
        )
        expect:
        [ expected ] == parser.parseRuleFile(filename)
    }
}
