package com.lapots.breed.rule.parser

import com.lapots.breed.rule.domain.Condition
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

    def "should parse xml and produce expected object"() {
        setup:
            def filename = "sample-empty-rule.xml"
            def parser = new XmlFileParser()
            def expected = new DataRule(
                    ruleName: "sample rule",
                    inputs: [ new InputFactField() ],
                    outputs: [ new OutputResultField() ],
                    execution: new ExecutionRule(
                            then: new ThenBlock(),
                            when: new WhenBlock(conditions: [ new Condition() ])
                    )
            )
        expect:
            [ expected ] == parser.parseRuleFile(filename)
    }
}
