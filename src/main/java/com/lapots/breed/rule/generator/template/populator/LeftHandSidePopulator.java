package com.lapots.breed.rule.generator.template.populator;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.lapots.breed.rule.domain.Binding;
import com.lapots.breed.rule.domain.Condition;
import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.domain.WhenBlock;
import com.lapots.breed.rule.generator.template.populator.api.AbstractPopulator;
import com.lapots.breed.rule.generator.template.populator.api.ITemplatePopulator;
import com.lapots.breed.rule.internal.ConfigurationHolder;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.lapots.breed.rule.internal.Constants.LHS_TOKEN;

/**
 * Populates lhs in template.
 */
public class LeftHandSidePopulator extends AbstractPopulator {

    @Override
    protected Map<String, Object> internalPopulate(Map<String, Object> templateData, DataRule src) {
        WhenBlock when = src.getExecution().getWhen();

        Map<String, String> conditions = when.getConditions()
                .stream()
                .collect(Collectors.toMap(Condition::getConditionId, this::transformCondition));

        // TODO:implement for multiple bindings aka () && () and so on.
        List<String> expressions = when.getBindings()
                .stream()
                .collect(Collectors.toMap(Binding::getType, Function.identity()))
                .entrySet()
                .stream()
                .map(bindingEntry -> formExpression(conditions, bindingEntry.getValue()))
                .collect(Collectors.toList());

        templateData.put(LHS_TOKEN, expressions.isEmpty() ? "true" : expressions.get(0));
        return templateData;
    }

    @Override
    @Inject
    protected void injectNext(@Named("rightHandSidePopulator") ITemplatePopulator next) {
        setNext(next);
    }

    /**
     * Converts condition [id, type, left, right] to [left + type + right] string.
     * @param condition condition
     * @return string of condition
     */
    private String transformCondition(Condition condition) {
        StringBuilder code = new StringBuilder();

        String leftBlock = condition.getLeft().getCode();
        code.append(leftBlock);

        String operator = condition.getConditionType();
        operator = ConfigurationHolder.findByKey("conditions." + operator);
        code.append(" ").append(operator).append(" ");

        String rightBlock = condition.getRight().getCode();
        code.append(rightBlock);
        return code.toString();
    }

    /**
     * Forms expression from left and rights side using binding as intermediate.
     * @param conditions conditions
     * @param binding binding element
     * @return expression
     */
    private String formExpression(Map<String, String> conditions, Binding binding) {
        String operator = " " + ConfigurationHolder.findByKey("bindings." + binding.getType()) + " ";
        return conditions.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .filter(entry -> binding.getConditions().contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(operator));
    }
}
