/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.List;

public class MinStrokeLengthIsNotReachedRule
extends AbstractPRPRule {
    @Override
    public void execute(List list, Object object) {
        this.execute(list, object, false);
    }

    @Override
    public void execute(List list, Object object, boolean bl) {
        if (!bl && !list.isEmpty()) {
            RecognizerResult recognizerResult = (RecognizerResult)list.get(0);
            int n = recognizerResult.getConfidence();
            if (recognizerResult.getCharacter() == '.' && n >= 99) {
                list.clear();
                this.addRuleDefinedChars(list, recognizerResult);
                return;
            }
            if (list.size() == 1 && MinStrokeLengthIsNotReachedRule.isAllowedMinCharSizeCharacter(recognizerResult.getCharacter())) {
                return;
            }
            list.clear();
        }
    }

    protected void addRuleDefinedChars(List list, RecognizerResult recognizerResult) {
        list.add(recognizerResult);
    }

    @Override
    public boolean isMinimumStokeLengthSensitive() {
        return false;
    }

    @Override
    public String getRuleName() {
        return "Min-Stroke-Length-IsNot-Meet-Rule";
    }
}

