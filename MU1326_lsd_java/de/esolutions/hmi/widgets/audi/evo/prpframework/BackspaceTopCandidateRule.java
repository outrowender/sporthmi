/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.List;

public class BackspaceTopCandidateRule
extends AbstractPRPRule {
    public void execute(List list, Object object, boolean bl) {
        RecognizerResult recognizerResult;
        if (!list.isEmpty() && (recognizerResult = (RecognizerResult)list.get(0)).getCharacter() == '\b') {
            for (int i2 = list.size() - 1; i2 > 0; --i2) {
                list.remove(i2);
            }
        }
    }

    public String getRuleName() {
        return "Backspace-Top-Candidate-Rule";
    }
}

