/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.Iterator;
import java.util.List;

public class PlusTRule
extends AbstractPRPRule {
    public void execute(List list, Object object, boolean bl) {
        RecognizerResult recognizerResult = null;
        RecognizerResult recognizerResult2 = null;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult3 = (RecognizerResult)iterator.next();
            char c2 = recognizerResult3.getCharacter();
            if (c2 == '+') {
                recognizerResult2 = recognizerResult3;
            }
            if (c2 != 't') continue;
            recognizerResult = recognizerResult3;
        }
        if (null != recognizerResult2 && null == recognizerResult) {
            list.add(new RecognizerResult('t', recognizerResult2.getConfidence() - 1));
        } else if (null != recognizerResult2 && null != recognizerResult && recognizerResult.getConfidence() < recognizerResult2.getConfidence()) {
            recognizerResult.setConfidence(recognizerResult2.getConfidence() - 1);
        }
    }

    public String getRuleName() {
        return "+t-Rule";
    }
}

