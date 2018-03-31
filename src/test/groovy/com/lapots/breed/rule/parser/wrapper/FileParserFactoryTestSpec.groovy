package com.lapots.breed.rule.parser.wrapper

import com.lapots.breed.rule.parser.JsonFileParser
import com.lapots.breed.rule.parser.XmlFileParser
import spock.lang.Specification

class FileParserFactoryTestSpec extends Specification {

    def "should return xml parser"() {
        setup:
        def factory = new FileParserFactory()
        expect:
        factory.getParser("xml") instanceof XmlFileParser
    }

    def "should return json parser"() {
        setup:
        def factory = new FileParserFactory()
        expect:
        factory.getParser("json") instanceof JsonFileParser
    }

    def "should throw exception"() {
        setup:
        def factory = new FileParserFactory()
        when:
        factory.getParser("abc")
        then:
        thrown IllegalStateException
    }
}
