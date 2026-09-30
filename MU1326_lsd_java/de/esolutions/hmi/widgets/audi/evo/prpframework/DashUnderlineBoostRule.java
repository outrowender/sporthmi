/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.List;

public class DashUnderlineBoostRule
extends AbstractPRPRule {
    public void execute(List list, Object object, boolean bl) {
        RecognizerResult[] recognizerResultArray = DashUnderlineBoostRule.searchCharacters(list, new char[]{'-', '_'});
        RecognizerResult recognizerResult = recognizerResultArray[0];
        RecognizerResult recognizerResult2 = recognizerResultArray[1];
        if (recognizerResult2 == null && recognizerResult == null) {
            return;
        }
        if (recognizerResult2 == null) {
            list.add(new RecognizerResult('_', recognizerResult.getConfidence() - 1));
        } else if (recognizerResult == null) {
            list.add(new RecognizerResult('-', recognizerResult2.getConfidence() + 1));
        } else {
            int n = Math.max(recognizerResult2.getConfidence(), recognizerResult.getConfidence());
            recognizerResult2.setConfidence(n - 1);
            recognizerResult.setConfidence(n);
        }
    }

    public String getRuleName() {
        return "Dash-Underline-Boost-Rule";
    }
}

