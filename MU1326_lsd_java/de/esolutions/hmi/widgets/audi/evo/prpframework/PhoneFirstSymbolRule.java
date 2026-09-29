/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.Iterator;
import java.util.List;

public class PhoneFirstSymbolRule
extends AbstractPRPRule {
    @Override
    public void execute(List list, Object object, boolean bl) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
            char c2 = recognizerResult.getCharacter();
            if (Character.isDigit(c2)) {
                recognizerResult.boost(this.getParam(8));
                continue;
            }
            if (c2 != '+') continue;
            recognizerResult.boost(this.getParam(7));
        }
    }

    @Override
    public String getRuleName() {
        return "Phone-First-Symbol-Rule";
    }

    @Override
    public int getValidity() {
        return 1;
    }
}

