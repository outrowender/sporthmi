/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.Iterator;
import java.util.List;

public class LetterOverSpecialCharBoostRule
extends AbstractPRPRule {
    private static final String ADDITIONAL_LETTERS;

    @Override
    public void execute(List list, Object object, boolean bl) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
            char c2 = recognizerResult.getCharacter();
            if (!this.letterOrDigitModified(c2)) continue;
            recognizerResult.boost(this.getParam(4));
        }
    }

    private boolean letterOrDigitModified(char c2) {
        boolean bl = Character.isLetterOrDigit(c2);
        if (this.getInfoProvider().getKeyboardType() == 6) {
            bl |= "', ".indexOf(c2) != -1;
        }
        return bl;
    }

    @Override
    public String getRuleName() {
        return "Letter-Over-SpecialCharacter-Boost-Rule";
    }
}

