package com.lapots.breed.rule.generator.template

import com.lapots.breed.rule.domain.DataRule
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator
import spock.lang.Specification

class PebbleTemplateEngineClassGeneratorTestSpec extends Specification {

    def "should generate class expected"() {
        setup:
            ITemplatePopulator populator = Mock {
                populate(_, _) >> [
                        "package" : "com.lapots.test",
                        "fields" : [ "private String field1", "private String field2" ],
                        "className" : "Basic"
                ]
            }
            def pebbleEngine = new PebbleTemplateEngineClassGenerator(
                    "./template/class_template.template", populator)
            def fileTemplate = this.getClass().getResource("/template/class_template.java").text
        expect:
            fileTemplate == pebbleEngine.generateClass(new DataRule())
    }
}
