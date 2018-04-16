package com.lapots.breed.rule.internal

import spock.lang.Specification

class ConfiugrationHolderTestSpec extends Specification {

    def "should process and retrieve json"() {
        expect:
            "John" == ConfigurationHolder.findByKey("name")
            "London" == ConfigurationHolder.findByKey("location.city")
            "Orme Square" == ConfigurationHolder.findByKey("location.street")
    }

    def "should process and retrieve external json"() {
        expect:
        "Extension" == ConfigurationHolder.findByKey("ext")
    }

    def "should use overriden json"() {
        expect:
        "overridden" == ConfigurationHolder.findByKey("to_override")
    }
}
