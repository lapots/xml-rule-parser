package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.domain.DataRule
import spock.lang.Ignore
import spock.lang.Specification

class PackageNamePopulatorTestSpec extends Specification {

    @Ignore("mock static invocation")
    def "should populate with package name"() {
        when:
            def populator = new PackageNamePopulator(null)
        then:
            assert ["package": "random_package"] == populator.populate([:], new DataRule())
    }
}
