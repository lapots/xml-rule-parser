package com.lapots.breed.rule.generator.template.populator;

import com.lapots.breed.rule.domain.DataRule;
import com.lapots.breed.rule.domain.ExecutionRule;
import com.lapots.breed.rule.domain.ThenBlock;
import com.lapots.breed.rule.domain.WhenBlock;

import java.util.Collections;

/**
 * Modifies object before processing by populators.
 */
public class PreProcessUtils {
    /**
     * Fills null fields with empty values.
     * @param src src
     * @return updated data rule
     */
    public static DataRule fillNulls(DataRule src) {
        if (src.getInputs() == null) {
            src.setInputs(Collections.emptyList());
        }

        if (src.getOutputs() == null) {
            src.setOutputs(Collections.emptyList());
        }

        if (src.getExecution() == null) {
            ExecutionRule exec = new ExecutionRule();
            src.setExecution(exec);

            WhenBlock when = new WhenBlock();
            when.setBindings(Collections.emptyList());
            when.setConditions(Collections.emptyList());
            exec.setWhen(when);

            ThenBlock then = new ThenBlock();
            exec.setThen(then);
        }

        return src;
    }

}
