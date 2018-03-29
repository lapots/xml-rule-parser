package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.internal.ConfigurationHolder
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

/**
 * Used for mocking static class methods.
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Sputnik.class)
@PrepareForTest(ConfigurationHolder.class)
class PopulatorTestSpecification extends Specification {

    def setup() {
        PowerMockito.mockStatic(ConfigurationHolder.class)
    }

}
