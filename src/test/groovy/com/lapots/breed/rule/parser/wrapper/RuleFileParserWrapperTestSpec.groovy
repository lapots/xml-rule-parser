package com.lapots.breed.rule.parser.wrapper

import com.lapots.breed.rule.parser.api.IFileParser
import spock.lang.Specification

class RuleFileParserWrapperTestSpec extends Specification {

    def "should parse xml file as expected"() {
        setup:
            IFileParser jsonFileParser = Mock { parseRuleFile("file.json") >> [] }
            FileParserFactory fileParserFactory = Mock { getParser("json") >> jsonFileParser }
            def rfp = new RuleFileParserWrapper(factory: fileParserFactory)
        expect:
            [] == rfp.parseRuleFile("file.json")
    }

}
