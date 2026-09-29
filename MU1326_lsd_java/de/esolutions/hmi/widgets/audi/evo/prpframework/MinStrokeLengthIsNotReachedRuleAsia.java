/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.MinStrokeLengthIsNotReachedRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.List;

public class MinStrokeLengthIsNotReachedRuleAsia
extends MinStrokeLengthIsNotReachedRule {
    @Override
    protected void addRuleDefinedChars(List list, RecognizerResult recognizerResult) {
        int n = recognizerResult.getConfidence();
        list.add(recognizerResult);
        list.add(new RecognizerResult('\u3002', n - 1));
        list.add(new RecognizerResult(',', n - 2));
    }

    @Override
    public String getRuleName() {
        return "Min-CharSize_Rule";
    }
}

