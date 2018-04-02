package com.lapots.breed.rule.parser.wrapper.file

import com.lapots.breed.rule.parser.file.api.IFileParser
import com.lapots.breed.rule.parser.wrapper.file.FileParserFactory
import com.lapots.breed.rule.parser.wrapper.file.RuleFileParserWrapper
import spock.lang.Specification

class RuleFileParserWrapperTestSpec extends Specification {

    def "should parse xml file as expected"() {
        setup:
            IFileParser jsonFileParser = Mock { parseRuleFile("file.json") >> [] }
            def fileParserFactory = Mock(FileParserFactory) { getParser("json") >> jsonFileParser }
            def rfp = new RuleFileParserWrapper(factory: fileParserFactory)
        expect:
            [] == rfp.parseRuleFile("file.json")
    }

}
