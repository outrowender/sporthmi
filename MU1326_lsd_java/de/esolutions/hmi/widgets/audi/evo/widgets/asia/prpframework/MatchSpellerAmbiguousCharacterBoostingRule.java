/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.List;

public final class MatchSpellerAmbiguousCharacterBoostingRule
extends AbstractPRPRule {
    private static final String CHARS_TO_BOOST = "ckopsuvwxzCKOPSUVWXZ";

    public void execute(List list, Object object, boolean bl) {
        if (bl && !list.isEmpty()) {
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                RecognizerResult recognizerResult = (RecognizerResult)list.get(i2);
                char c2 = recognizerResult.getCharacter();
                if (CHARS_TO_BOOST.indexOf(c2) == -1) continue;
                RecognizerResult recognizerResult2 = null;
                boolean bl2 = false;
                boolean bl3 = c2 > '`' && c2 < '{';
                char c3 = (char)(bl3 ? c2 - 32 : c2 + 32);
                if (i2 + 1 < n && (recognizerResult2 = (RecognizerResult)list.get(i2 + 1)).getCharacter() == c3) {
                    this.boostConfidence(bl3, recognizerResult, recognizerResult2);
                    bl2 = true;
                }
                if (bl2 || i2 == n - 2) continue;
                this.normalBoosting(list, i2, c3, bl3);
            }
        }
    }

    private void normalBoosting(List list, int n, char c2, boolean bl) {
        RecognizerResult recognizerResult = (RecognizerResult)list.get(n);
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            RecognizerResult recognizerResult2 = (RecognizerResult)list.get(i2);
            if (recognizerResult2.getCharacter() != c2) continue;
            this.boostConfidence(bl, recognizerResult, recognizerResult2);
        }
    }

    private void boostConfidence(boolean bl, RecognizerResult recognizerResult, RecognizerResult recognizerResult2) {
        if (bl) {
            recognizerResult2.setConfidence(recognizerResult.getConfidence() + 1);
        } else {
            recognizerResult.setConfidence(recognizerResult2.getConfidence() + 1);
        }
    }

    public String getRuleName() {
        return "MachSpeller-Ambiguous-Character-Boosting-Rule";
    }
}

