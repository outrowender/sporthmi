/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.widgets.CaseBalancingStrategyEU;
import de.esolutions.hmi.widgets.audi.evo.widgets.ICaseBalancingStrategy;
import java.util.Arrays;
import java.util.List;

public final class CaseBalancingStrategyAsia
extends CaseBalancingStrategyEU
implements ICaseBalancingStrategy {
    protected static final char[] WORD_SEPERATORS_ASIA = new char[]{' ', '!', '\'', '(', ')', '+', ',', '-', '.', '/', ':', ';', '?', '_', '\u00a1', '\u00bf', '\u3002', '\u300a', '\u300b'};

    @Override
    public String refreshForDisplayCaseBalancingText(int n, int n2, IntList intList, List list) {
        Buffer buffer = new Buffer(n2 - n);
        for (int i2 = n; i2 < n2; ++i2) {
            String string = (String)list.get(i2);
            char c2 = string.charAt(0);
            if (i2 - n != 0) {
                int n3 = this.calculateCaseForRange(n, n2, list);
                switch (n3) {
                    case 3: {
                        c2 = Character.toLowerCase(c2);
                        break;
                    }
                    case 4: {
                        c2 = Character.toUpperCase(c2);
                        break;
                    }
                }
            }
            buffer.append(c2);
        }
        return buffer.toString();
    }

    private int calculateCaseForRange(int n, int n2, List list) {
        String string = (String)list.get(n);
        char c2 = string.charAt(0);
        boolean bl = Character.isLowerCase(c2);
        boolean bl2 = Character.isUpperCase(c2);
        if (bl) {
            return 3;
        }
        if (bl2 && n2 - n > 1) {
            String string2 = (String)list.get(n + 1);
            char c3 = string2.charAt(0);
            boolean bl3 = Character.isLowerCase(c3);
            boolean bl4 = Character.isUpperCase(c3);
            if (bl3) {
                return 3;
            }
            if (bl4) {
                return 4;
            }
        }
        return 2;
    }

    @Override
    public boolean isWordSeparator(char c2) {
        boolean bl = Arrays.binarySearch(WORD_SEPERATORS_ASIA, c2) >= 0;
        return bl |= StringUtility.isAsiaCharacter(c2);
    }

    @Override
    public boolean needRefreshDisplayTextAfterTextChange() {
        return this.isHandwrittenActive;
    }
}

