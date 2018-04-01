package com.lapots.breed.rule.parser

import com.lapots.breed.rule.parser.wrapper.RuleFileParserWrapper
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

}
