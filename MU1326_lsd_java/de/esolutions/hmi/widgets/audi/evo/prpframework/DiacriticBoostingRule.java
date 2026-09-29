/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.prpframework.TouchCharacterDefinitionEurope;
import java.util.Iterator;
import java.util.List;

public class DiacriticBoostingRule
extends AbstractPRPRule {
    private int languageIndex = 0;

    public DiacriticBoostingRule(int n) {
        this.languageIndex = n;
    }

    @Override
    public void execute(List list, Object object, boolean bl) {
        int n = this.getParam(9);
        if (n == 0) {
            return;
        }
        String string = TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(this.languageIndex);
        String string2 = TouchCharacterDefinitionEurope.getDiacriticSymbols(this.languageIndex);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
            char c2 = recognizerResult.getCharacter();
            if (!StringUtility.containsCharacter(string, c2) || StringUtility.containsCharacter(string2, c2)) continue;
            recognizerResult.boost(n);
        }
    }

    @Override
    public String getRuleName() {
        return "Diacritic-signs-boosting-Rule";
    }
}

