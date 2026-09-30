/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.Iterator;
import java.util.List;

public class PunctuationMarkEnforcementRule
extends AbstractPRPRule {
    private static final String PUNCTUATION_LIST = "!.;?\u00a1\u00bf";

    public void execute(List list, Object object, boolean bl) {
        if (this.getInfoProvider().isEmpty() || this.isPunctuation()) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
                char c2 = recognizerResult.getCharacter();
                RecognizerResult recognizerResult2 = null;
                if (!Character.isLowerCase(c2) || (recognizerResult2 = this.contains(list, recognizerResult, true)) == null || recognizerResult.getConfidence() <= recognizerResult2.getConfidence()) continue;
                recognizerResult2.setConfidence(recognizerResult.getConfidence());
                recognizerResult.boost(-1);
            }
        }
    }

    private boolean isPunctuation() {
        String string = this.getInfoProvider().getCurrentText();
        boolean bl = false;
        if (string.length() > 0) {
            boolean bl2 = bl = PUNCTUATION_LIST.indexOf(string.charAt(string.length() - 1)) > -1;
        }
        if (!bl && string.length() >= 2) {
            bl = PUNCTUATION_LIST.indexOf(string.charAt(string.length() - 2)) > -1;
            bl &= string.charAt(string.length() - 1) == ' ';
        }
        return bl;
    }

    public String getRuleName() {
        return "Punctuation-Mark Enforcement Rule";
    }

    public int getValidity() {
        return 2;
    }
}

