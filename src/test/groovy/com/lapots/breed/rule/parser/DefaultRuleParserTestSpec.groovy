package com.lapots.breed.rule.parser

import com.lapots.breed.rule.parser.wrapper.RuleFileParserWrapper
import com.lapots.breed.rule.parser.wrapper.string.RuleStringParserWrapper
import spock.lang.Specification

class DefaultRuleParserTestSpec extends Specification {

    def "should parse file"() {
        setup:
            def wrapper = Mock(RuleFileParserWrapper) {
                parseRuleFile('filename.txt') >> []
            }
            def parser = new DefaultRuleParser(fileParserWrapper: wrapper)
        expect:
            [] == parser.parseFile('filename.txt')
    }


    def "should parse string"() {
        setup:
            def wrapper = Mock(RuleStringParserWrapper) {
                parseRuleString('file data') >> []
            }
            def parser = new DefaultRuleParser(stringParserWrapper: wrapper)
        expect:
            [] == parser.parseDocument('file data')
    }
}
