package com.lapots.breed.rule.domain

import com.openpojo.validation.ValidatorBuilder
import com.openpojo.validation.rule.impl.EqualsAndHashCodeMatchRule
import com.openpojo.validation.test.impl.GetterTester
import com.openpojo.validation.test.impl.SetterTester
import nl.jqno.equalsverifier.EqualsVerifier
import nl.jqno.equalsverifier.Warning
import org.junit.Test

/**
 * Tests for domain.
 */
// not really necessary because of lombok
class PojoTest {
    @Test
    void validate() {
        def validator = ValidatorBuilder.create()
                .with(new EqualsAndHashCodeMatchRule())
                .with(new SetterTester(), new GetterTester())
                .build()
        validator.validate("com.lapots.breed.rule.domain")
    }

    @Test
    void validateEquals() {
        // TODO: investigate package usage
        EqualsVerifier.forClass(Binding.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .verify()
        EqualsVerifier.forClass(Condition.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .verify()
        EqualsVerifier.forClass(ConditionSide.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .verify()
        EqualsVerifier.forClass(DataRule.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .verify()
        EqualsVerifier.forClass(ExecutionRule.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .verify()
        EqualsVerifier.forClass(InputFactField.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .verify()
        EqualsVerifier.forClass(OutputResultField.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .verify()
        EqualsVerifier.forClass(ThenBlock.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .verify()
        EqualsVerifier.forClass(WhenBlock.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .verify()
    }
}
