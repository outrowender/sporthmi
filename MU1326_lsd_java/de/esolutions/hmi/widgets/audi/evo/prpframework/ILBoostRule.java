/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;
import java.util.List;

public class ILBoostRule
extends AbstractPRPRule {
    public void execute(List list, Object object, boolean bl) {
        if (AbstractWidget.isArabia() && TouchControllerArabia.isArabicCharSetActivated()) {
            return;
        }
        RecognizerResult[] recognizerResultArray = ILBoostRule.searchCharacters(list, new char[]{'I', 'l'});
        if (recognizerResultArray[0] != null && recognizerResultArray[1] != null) {
            String string = this.getInfoProvider().getCurrentDisplayString();
            char c2 = '\u0000';
            if (string != null && string.length() > 0) {
                c2 = string.charAt(string.length() - 1);
            }
            if (Character.isUpperCase(c2) || this.getInfoProvider().isStartOfWord()) {
                recognizerResultArray[0].boost(this.getParam(1));
                recognizerResultArray[1].boost(-this.getParam(1));
            } else if (Character.isLowerCase(c2)) {
                recognizerResultArray[0].boost(-this.getParam(1));
                recognizerResultArray[1].boost(this.getParam(1));
            }
        }
    }

    public String getRuleName() {
        return "I-L-Boosting-Rule";
    }
}

