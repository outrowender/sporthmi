/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.Iterator;
import java.util.List;

public class SpeechFilterRule
extends AbstractPRPRule {
    private RecognizerResult speechTopMatch = null;

    public void execute(List list, Object object, boolean bl) {
        this.speechTopMatch = null;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
            if (this.speechTopMatch != null && recognizerResult.getConfidence() <= this.speechTopMatch.getConfidence()) continue;
            this.speechTopMatch = recognizerResult;
        }
    }

    public String getRuleName() {
        return "Speech-Filter-Rule";
    }

    public RecognizerResult getSpeechTopMatch() {
        return this.speechTopMatch;
    }
}

