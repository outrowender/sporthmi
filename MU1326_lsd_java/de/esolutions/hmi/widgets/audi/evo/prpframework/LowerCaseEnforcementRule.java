/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;
import java.util.Iterator;
import java.util.List;

public class LowerCaseEnforcementRule
extends AbstractPRPRule {
    public void execute(List list, Object object, boolean bl) {
        if (AbstractWidget.isArabia() && TouchControllerArabia.isArabicCharSetActivated()) {
            return;
        }
        String string = this.getInfoProvider().getCurrentWord();
        if (string.length() < 1) {
            return;
        }
        int n = string.length();
        boolean bl2 = false;
        boolean bl3 = false;
        if (n >= 2) {
            bl2 = Character.isUpperCase(string.charAt(n - 1));
            bl3 = Character.isUpperCase(string.charAt(n - 2));
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
            RecognizerResult recognizerResult2 = null;
            if (bl2 && bl3) {
                if (Character.isLowerCase(recognizerResult.getCharacter())) {
                    recognizerResult2 = this.contains(list, recognizerResult, true);
                }
            } else if (Character.isUpperCase(recognizerResult.getCharacter())) {
                recognizerResult2 = this.contains(list, recognizerResult, false);
            }
            if (recognizerResult2 == null || recognizerResult.getConfidence() <= recognizerResult2.getConfidence()) continue;
            recognizerResult2.setConfidence(recognizerResult.getConfidence());
            recognizerResult.boost(-1);
        }
    }

    public String getRuleName() {
        return "Lower-Upper-Case Enforcement Rule";
    }

    public int getValidity() {
        return 2;
    }
}

