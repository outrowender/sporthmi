/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.Iterator;
import java.util.List;

public class Oo0Rule
extends AbstractPRPRule {
    public void execute(List list, Object object, boolean bl) {
        RecognizerResult recognizerResult;
        boolean bl2 = false;
        int n = Integer.MIN_VALUE;
        boolean bl3 = false;
        int n2 = Integer.MIN_VALUE;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            recognizerResult = (RecognizerResult)iterator.next();
            char c2 = recognizerResult.getCharacter();
            if (c2 == '0') {
                return;
            }
            if (c2 == 'O') {
                bl2 = true;
                n = recognizerResult.getConfidence();
            }
            if (c2 != 'o') continue;
            bl3 = true;
            n2 = recognizerResult.getConfidence();
        }
        int n3 = 0;
        if (bl2 && !bl3) {
            n3 = n - 1;
        } else if (bl3 && !bl2) {
            n3 = n2 - 1;
        } else if (bl2 || bl3) {
            if (n >= n2) {
                n3 = n2 - 1;
            }
            if (n < n2) {
                n3 = n - 1;
            }
        }
        recognizerResult = new RecognizerResult('0', n3);
        list.add(recognizerResult);
    }

    public String getRuleName() {
        return "Oo0-Rule";
    }
}

