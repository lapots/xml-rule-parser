package com.lapots.breed.rule.generator.template.populator

import com.lapots.breed.rule.domain.DataRule
import com.lapots.breed.rule.domain.InputFactField
import com.lapots.breed.rule.domain.OutputResultField
import com.lapots.breed.rule.internal.ConfigurationHolder
import org.mockito.Mockito

class FieldsPopulatorTestSpec  extends PopulatorTestSpecification {

    def "should add fields to map"() {
        setup:
        def dataRule = new DataRule(
                inputs: [
                        new InputFactField(
                                fieldName: "field1",
                                factName: "input_field1",
                                fieldAccess: "private",
                                fieldType: "int"
                        ),
                        new InputFactField(
                                fieldName: "field2",
                                factName: "input_field2",
                                fieldAccess: "private",
                                fieldType: "int"
                        )
                ],
                outputs: [
                        new OutputResultField(
                                fieldName: "result",
                                fieldAccess: "private",
                                fieldType: "int"
                        )
                ]
        )
        //FIXME: investigate order!
        def expected = ["fields": [
                "@Result private int result",
                "@Given(\"input_field1\") private int field1",
                "@Given(\"input_field2\") private int field2"
        ]]
        def populator = new FieldsPopulator(next: null)
        expect:
        expected == populator.populate([:], dataRule)
    }

    def "should add fields with multiple annotations to map"() {
        setup:
        def dataRule = new DataRule(
                inputs: [
                        new InputFactField(
                                fieldName: "field1",
                                factName: "input_field1",
                                fieldAccess: "private",
                                fieldType: "int"
                        ),
                        new InputFactField(
                                fieldName: "result",
                                factName: "result",
                                fieldAccess: "private",
                                fieldType: "int"
                        )
                ],
                outputs: [
                        new OutputResultField(
                                fieldName: "result",
                                fieldAccess: "private",
                                fieldType: "int"
                        )
                ]
        )
        //FIXME: investigate order!
        def expected = ["fields": [
                "@Given(\"result\") @Result private int result",
                "@Given(\"input_field1\") private int field1"
        ]]
        def populator = new FieldsPopulator(next: null)
        expect:
        expected == populator.populate([:], dataRule)
    }

    def "should add mapped fields to map"() {
        setup:
        def dataRule = new DataRule(
                inputs: [
                        new InputFactField(
                                fieldName: "field1",
                                factName: "input_field1",
                                fieldAccess: "private",
                                fieldType: "data"
                        )
                ],
                outputs: []
        )
        def expected = ["fields": ["@Given(\"input_field1\") private Data field1"]]
        def populator = new FieldsPopulator(next: null)
        when:
        Mockito.when(ConfigurationHolder.findByKey("mapping.data")).thenReturn("com.data.package.Data")
        then:
        expected == populator.populate([:], dataRule)
    }

    def "should add not mapped fields to map"() {
        setup:
        def dataRule = new DataRule(
                inputs: [
                        new InputFactField(
                                fieldName: "field1",
                                factName: "input_field1",
                                fieldAccess: "private",
                                fieldType: "datax"
                        )
                ],
                outputs: []
        )
        def expected = ["fields": ["@Given(\"input_field1\") private ??? field1"]]
        def populator = new FieldsPopulator(next: null)
        when:
        Mockito.when(ConfigurationHolder.findByKey("mapping.datax")).thenReturn(null)
        then:
        expected == populator.populate([:], dataRule)
    }
}
