package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.domain.DataRule
import com.lapots.breed.rule.domain.InputFactField
import com.lapots.breed.rule.domain.OutputResultField
import spock.lang.Specification

class ImportsPopulatorTestSpec extends Specification {

    def "should populate imports"() {
        setup:
            def dr = new DataRule(
                    inputs: [
                            new InputFactField(fieldType: "int"),
                            new InputFactField(fieldType: "long"),
                            new InputFactField(fieldType: "data")
                    ],
                    "outputs": [
                            new OutputResultField(fieldType: "data"),
                            new OutputResultField(fieldType: "another_data")
                    ]
            )
            def populator = new ImportsPopulator(next: null)
        expect:
            ["imports" : ["com.test.another.package.Data", "com.test.package.Data"]] == populator.populate([:], dr)
    }

}
