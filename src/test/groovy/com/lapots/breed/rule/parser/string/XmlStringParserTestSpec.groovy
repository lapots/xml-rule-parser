package com.lapots.breed.rule.parser.string

import com.lapots.breed.rule.domain.DataRule
import spock.lang.Specification

class XmlStringParserTestSpec extends Specification {

    def "should parse xml string"() {
        setup:
            def xmlString = """<rules><rule name="sample rule"/></rules>"""
            def parser = new XmlStringParser()
        when:
            def result = parser.parseRuleString(xmlString)
        then:
            [ new DataRule(ruleName: "sample rule") ] == result
    }

}
