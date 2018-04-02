package com.lapots.breed.rule.parser.string

import com.lapots.breed.rule.domain.DataRule
import spock.lang.Specification

class JsonStringParserTestSpec extends Specification {

    def "should parse json string"() {
        setup:
            def jsonString = """{ "rules": [ { "name": "sample rule" } ] }"""
            def parser = new JsonStringParser()
        when:
            def result = parser.parseRuleString(jsonString)
        then:
            [ new DataRule(ruleName: "sample rule") ] == result
    }
}
