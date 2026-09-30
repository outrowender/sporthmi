/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.prpframework.SpaceDashBoostRule;
import java.util.List;

public class SpaceDashBoostRuleAsia
extends SpaceDashBoostRule {
    private static final char[] ruleDefinedChars = new char[]{' ', '\u4e00', '-'};

    public void execute(List list, Object object, boolean bl) {
        int n;
        RecognizerResult[] recognizerResultArray = SpaceDashBoostRuleAsia.searchCharacters(list, this.getRuleDefinedChars());
        int n2 = 0;
        int n3 = 0;
        for (n = 0; n < recognizerResultArray.length; ++n) {
            if (null == recognizerResultArray[n]) {
                ++n2;
                continue;
            }
            n3 = Math.max(n3, recognizerResultArray[n].getConfidence());
        }
        if (n2 == recognizerResultArray.length) {
            return;
        }
        for (n = 0; n < recognizerResultArray.length; ++n) {
            RecognizerResult recognizerResult = recognizerResultArray[n];
            if (null == recognizerResult) {
                list.add(new RecognizerResult(this.getRuleDefinedChars()[n], this.getNewConfidence(recognizerResultArray, n3, n)));
                continue;
            }
            recognizerResult.setConfidence(this.getNewConfidence(recognizerResultArray, n3, n));
        }
    }

    private int getNewConfidence(RecognizerResult[] recognizerResultArray, int n, int n2) {
        return recognizerResultArray.length - n2 + n;
    }

    protected char[] getRuleDefinedChars() {
        return ruleDefinedChars;
    }

    public String getRuleName() {
        return "Space-Dash-Boost-Rule-Asia";
    }
}

