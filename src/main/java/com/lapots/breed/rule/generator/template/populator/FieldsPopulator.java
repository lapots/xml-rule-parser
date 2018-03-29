package com.lapots.breed.rule.generator.template.populator;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.domain.Field;
import com.lapots.breed.rule.domain.InputFactField;
import com.lapots.breed.rule.domain.OutputResultField;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Populate fields in template.
 */
public class FieldsPopulator extends AbstractPopulator {
    /**
     * Constructor.
     *
     * @param next next populator in chain
     */
    public FieldsPopulator(ITemplatePopulator next) {
        super(next);
    }

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        List<String> fieldStrings = Stream.concat(src.getInputs().stream(), src.getOutputs().stream())
                // I assume that no fields with same names and different types are presented
                .collect(Collectors.groupingBy(Field::getFieldName)) // [ field : [ Input, Output ]
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(o -> o.getValue().get(0).getFieldType())) // type is a superclass field
                .map(entry -> mapFieldToString(entry.getValue()))
                .collect(Collectors.toList());
        templateData.put("fields", fieldStrings);
        return templateData;
    }

    /**
     * Maps field to string annotation.
     * @param field field to map
     * @return annotation
     */
    private String mapFieldToAnnotation(Field field) {
        if (field instanceof InputFactField) {
            InputFactField inputFactField = (InputFactField) field;
            return String.format("@Given(\"%s\")", inputFactField.getFactName());
        } else if (field instanceof OutputResultField) {
            return "@Result";
        } else { // probably impossible if XML model is strict
            return "???";
        }
    }

    /**
     * Maps list of fields to string.
     * @param fields list of fields
     * @return string
     */
    private String mapFieldToString(List<Field> fields) {
        String annotations = fields
                .stream()
                .map(this::mapFieldToAnnotation)
                .collect(Collectors.joining(" "));
        Field field = fields.get(0);
        // TODO:add mapping support
        String importType = field.getFieldType();
        return String.format("%s %s %s %s", annotations, field.getFieldAccess(), importType,
                field.getFieldName());
    }
}
