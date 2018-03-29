package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.domain.DataRule
import com.lapots.breed.rule.internal.ConfigurationHolder
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Sputnik.class)
@PrepareForTest(ConfigurationHolder.class)
class PackageNamePopulatorTestSpec extends Specification {

    def "should populate with package name"() {
        setup:
            PowerMockito.mockStatic(ConfigurationHolder.class)
        when:
            Mockito.when(ConfigurationHolder.findByKey("default_package"))
                    .thenReturn("random_package")
            def populator = new PackageNamePopulator(null)
        then:
            assert ["package": "random_package"] == populator.populate([:], new DataRule())
    }
}
