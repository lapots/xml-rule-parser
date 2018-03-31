package com.lapots.breed.rule.parser.file

import com.lapots.breed.rule.parser.file.JsonFileParser
import com.lapots.breed.rule.parser.file.XmlFileParser
import spock.lang.Specification

class FileParserEqualTestSpec extends Specification {

    def "parsed equal xml and json should produce same object"(){
        setup:
            def xmlParser = new XmlFileParser()
            def jsonParser = new JsonFileParser()
        expect:
            xmlParser.parseRuleFile("sample-basic-rule.xml") ==
                    jsonParser.parseRuleFile("sample-basic-rule.json")
    }
}
