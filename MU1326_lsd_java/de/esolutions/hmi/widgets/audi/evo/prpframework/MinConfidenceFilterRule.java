/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.Iterator;
import java.util.List;

public class MinConfidenceFilterRule
extends AbstractPRPRule {
    @Override
    public void execute(List list, Object object, boolean bl) {
        int n = this.getParam(5);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
            int n2 = recognizerResult.getOriginalConfidence();
            if (n2 >= n) continue;
            iterator.remove();
        }
    }

    @Override
    public String getRuleName() {
        return "Min-Confidence-Filter-Rule";
    }
}

