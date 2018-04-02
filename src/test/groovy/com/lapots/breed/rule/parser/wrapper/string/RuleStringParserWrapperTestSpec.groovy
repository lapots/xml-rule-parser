package com.lapots.breed.rule.parser.wrapper.string

import com.lapots.breed.rule.parser.string.api.IStringParser
import spock.lang.Specification

class RuleStringParserWrapperTestSpec extends Specification {

    def "should parse json string"() {
        setup:
            IStringParser jsonStringParser = Mock { parseRuleString(_) >> [] }
            StringParserFactory parserFactory = Mock { getParser("json") >> jsonStringParser }
            def rsp = new RuleStringParserWrapper(factory: parserFactory)
        expect:
            [] == rsp.parseRuleString("{ document }") // don't check valid structure
    }


    def "should parse xml string"() {
        setup:
            IStringParser jsonStringParser = Mock { parseRuleString(_) >> [] }
            StringParserFactory parserFactory = Mock { getParser("xml") >> jsonStringParser }
            def rsp = new RuleStringParserWrapper(factory: parserFactory)
        expect:
            [] == rsp.parseRuleString("< document >") // don't check valid structure
    }

    def "should throw exception"() {
        setup:
            def rsp = new RuleStringParserWrapper()
        when:
            rsp.parseRuleString("- document -")
        then:
            thrown IllegalStateException
    }
}
