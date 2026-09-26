/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.Iterator;
import java.util.List;

public class NumberLetterAlternationBoostRule
extends AbstractPRPRule {
    private int boostParamId = 3;
    private static final String PHONE_SEPARATOR_CHARS_CALL_LIST = String.valueOf(new char[]{' ', '!', '\'', '(', ')', ',', '-', '.', '/', ':', ';', '?', '_', '\u00a1', '\u00bf'});

    public NumberLetterAlternationBoostRule(int n) {
        this.boostParamId = n;
    }

    @Override
    public void execute(List list, Object object, boolean bl) {
        char c2 = '\u0000';
        if (this.boostParamId == 3 || this.boostParamId == 14) {
            c2 = NumberLetterAlternationBoostRule.findLastDigitOrLetter(this.getInfoProvider().getCurrentWord());
        } else if (this.boostParamId == 6) {
            String string = this.getInfoProvider().getCurrentText();
            c2 = NumberLetterAlternationBoostRule.findLastDigitOrLetterIntellicall(string);
        }
        if (c2 == '\u0000') {
            return;
        }
        int n = Character.isDigit(c2) || c2 == '+' ? 1 : -1;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
            char c3 = recognizerResult.getCharacter();
            if (!Character.isDigit(c3) && c3 != '+') continue;
            recognizerResult.boost(n * this.getParam(this.boostParamId));
        }
    }

    private static char findLastDigitOrLetterIntellicall(String string) {
        for (int i2 = string.length() - 1; i2 >= 0; --i2) {
            char c2 = string.charAt(i2);
            if (PHONE_SEPARATOR_CHARS_CALL_LIST.indexOf(c2) >= 0) {
                return '\u0000';
            }
            if (!Character.isLetterOrDigit(c2) && c2 != '+') continue;
            return c2;
        }
        return '\u0000';
    }

    static char findLastDigitOrLetter(String string) {
        for (int i2 = string.length() - 1; i2 >= 0; --i2) {
            char c2 = string.charAt(i2);
            if (!Character.isLetterOrDigit(c2) && c2 != '+') continue;
            return c2;
        }
        return '\u0000';
    }

    @Override
    public String getRuleName() {
        return "Number-Letter-Alternation-Boost-Rule";
    }
}

