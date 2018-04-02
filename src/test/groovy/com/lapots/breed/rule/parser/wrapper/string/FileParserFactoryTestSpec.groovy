package com.lapots.breed.rule.parser.wrapper.string

import com.lapots.breed.rule.parser.string.JsonStringParser
import com.lapots.breed.rule.parser.string.XmlStringParser
import spock.lang.Specification

class FileParserFactoryTestSpec extends Specification {

    def "should return xml parser"() {
        setup:
            def factory = new StringParserFactory()
        expect:
            factory.getParser("xml") instanceof XmlStringParser
    }

    def "should return json parser"() {
        setup:
            def factory = new StringParserFactory()
        expect:
            factory.getParser("json") instanceof JsonStringParser
    }

    def "should throw exception"() {
        setup:
            def factory = new StringParserFactory()
        when:
            factory.getParser("abc")
        then:
            thrown IllegalStateException
    }
}
