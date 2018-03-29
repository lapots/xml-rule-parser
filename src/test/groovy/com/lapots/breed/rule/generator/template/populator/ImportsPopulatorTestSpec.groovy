package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.domain.DataRule
import com.lapots.breed.rule.domain.InputFactField
import com.lapots.breed.rule.domain.OutputResultField

class ImportsPopulatorTestSpec extends PopulatorTestSpecification {

    def "should populate imports"() {
        setup:
            def dr = new DataRule(
                    inputs: [
                            new InputFactField(
                                    fieldType: "int"
                            ),
                            new InputFactField(
                                    fieldType: "long"
                            ),
                            new InputFactField(
                                    fieldType: "com.test.package.Data"
                            )
                    ],
                    "outputs": [
                            new OutputResultField(
                                    fieldType: "com.test.package.Data"
                            ),
                            new OutputResultField(
                                    fieldType: "com.test.another.package.Data"
                            )
                    ]
            )
            def populator = new ImportsPopulator(null)
        expect:
            ["imports" : ["com.test.another.package.Data", "com.test.package.Data"]] == populator.populate([:], dr)
    }

}
