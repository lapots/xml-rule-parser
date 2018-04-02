package com.lapots.breed.rule.parser.wrapper.file

import com.lapots.breed.rule.parser.file.JsonFileParser
import com.lapots.breed.rule.parser.file.XmlFileParser
import com.lapots.breed.rule.parser.wrapper.file.FileParserFactory
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
