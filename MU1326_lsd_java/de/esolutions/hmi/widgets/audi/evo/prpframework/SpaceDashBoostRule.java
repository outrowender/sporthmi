/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.List;

public class SpaceDashBoostRule
extends AbstractPRPRule {
    public void execute(List list, Object object, boolean bl) {
        RecognizerResult[] recognizerResultArray = SpaceDashBoostRule.searchCharacters(list, new char[]{' ', '-'});
        RecognizerResult recognizerResult = recognizerResultArray[0];
        RecognizerResult recognizerResult2 = recognizerResultArray[1];
        if (recognizerResult == null && recognizerResult2 == null) {
            return;
        }
        if (recognizerResult == null) {
            list.add(new RecognizerResult(' ', recognizerResult2.getConfidence() + 1));
        } else if (recognizerResult2 == null) {
            list.add(new RecognizerResult('-', recognizerResult.getConfidence() - 1));
        } else {
            int n = Math.max(recognizerResult.getConfidence(), recognizerResult2.getConfidence());
            recognizerResult.setConfidence(n + 1);
            recognizerResult2.setConfidence(n);
        }
    }

    public String getRuleName() {
        return "Space-Dash-Boost-Rule";
    }
}

