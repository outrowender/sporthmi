/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.Iterator;
import java.util.List;

public class SingleCharFilterRule
extends AbstractPRPRule {
    private final String ruleName;
    private final char filteredCharacter;

    public SingleCharFilterRule(char c2) {
        String string = c2 == '\b' ? "\\b" : String.valueOf(c2);
        this.ruleName = new Buffer("Single-character filter rule ('").append(string).append("')").toString();
        this.filteredCharacter = c2;
    }

    public void execute(List list, Object object, boolean bl) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int n = SingleCharFilterRule.searchResultWithHighestConfidence(list);
        if (n == -1) {
            return;
        }
        if (this.parameterCharacterHasHighestConfidence(list, n)) {
            SingleCharFilterRule.removeAllItemsButOne(list, n);
        } else {
            this.removeParameterCharacter(list);
        }
    }

    private static int searchResultWithHighestConfidence(List list) {
        int n = -1;
        int n2 = Integer.MIN_VALUE;
        int n3 = list.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = ((RecognizerResult)list.get(i2)).getConfidence();
            if (n4 <= n2) continue;
            n = i2;
            n2 = n4;
        }
        return n;
    }

    private boolean parameterCharacterHasHighestConfidence(List list, int n) {
        char c2 = ((RecognizerResult)list.get(n)).getCharacter();
        return c2 == this.filteredCharacter;
    }

    private static void removeAllItemsButOne(List list, int n) {
        Object object = list.get(n);
        list.clear();
        list.add(object);
    }

    private void removeParameterCharacter(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            char c2 = ((RecognizerResult)iterator.next()).getCharacter();
            if (c2 != this.filteredCharacter) continue;
            iterator.remove();
            return;
        }
    }

    public String getRuleName() {
        return this.ruleName;
    }
}

