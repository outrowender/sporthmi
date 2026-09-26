/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MatchSpellerCaseInsensitiveCharRule
extends AbstractPRPRule {
    private final String ruleName;
    private final char[] caseInsensitiveChars = new char[]{'c', 'k', 'o', 'p', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public MatchSpellerCaseInsensitiveCharRule() {
        this.ruleName = "SpecialCharacters-CaseInsensitive-NVC-Rule";
    }

    @Override
    public void execute(List list, Object object, boolean bl) {
        if (list == null || list.isEmpty()) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int n = list.size();
        for (int i2 = 0; i2 < n; ++i2) {
            RecognizerResult recognizerResult = (RecognizerResult)list.get(i2);
            char c2 = recognizerResult.getCharacter();
            if (this.isCaseInsensitiveChar(c2)) {
                char c3 = Character.toUpperCase(c2);
                RecognizerResult recognizerResult2 = new RecognizerResult(c3, recognizerResult.getConfidence());
                Character c4 = new Character(c3);
                if (linkedHashMap.containsKey(c4)) continue;
                ((HashMap)linkedHashMap).put(c4, recognizerResult2);
                continue;
            }
            ((HashMap)linkedHashMap).put(new Character(c2), recognizerResult);
        }
        list.clear();
        list.addAll(((HashMap)linkedHashMap).values());
    }

    private boolean isCaseInsensitiveChar(char c2) {
        char c3 = Character.toLowerCase(c2);
        for (int i2 = 0; i2 < this.caseInsensitiveChars.length; ++i2) {
            if (this.caseInsensitiveChars[i2] != c3) continue;
            return true;
        }
        return false;
    }

    @Override
    public String getRuleName() {
        return "SpecialCharacters-CaseInsensitive-NVC-Rule";
    }
}

