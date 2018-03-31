package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.domain.DataRule
import com.lapots.breed.rule.internal.ConfigurationHolder
import org.mockito.Mockito

class PackageNamePopulatorTestSpec extends PopulatorTestSpecification {

    def "should populate with package name"() {
        when:
            Mockito.when(ConfigurationHolder.findByKey("default_package"))
                    .thenReturn("random_package")
            def populator = new PackageNamePopulator(next: null)
        then:
            assert ["package": "random_package"] == populator.populate([:], new DataRule())
    }
}
