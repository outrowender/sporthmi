/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.hmi.widgets.audi.evo.widgets.ICaseBalancingStrategy;
import java.util.Arrays;
import java.util.List;

public class CaseBalancingStrategyEU
implements ICaseBalancingStrategy {
    protected static final char[] WORD_SEPARATORS_EUROPE = new char[]{' ', '!', '\'', '(', ')', '+', ',', '-', '.', '/', ':', ';', '?', '_', '\u00a1', '\u00bf'};
    protected boolean isHandwrittenActive = false;

    public String refreshForDisplayCaseBalancingText(int n, int n2, IntList intList, List list) {
        Buffer buffer = new Buffer(n2 - n);
        boolean bl = false;
        int n3 = 2;
        if (n2 > 0) {
            n3 = intList.get(n);
        }
        for (int i2 = n; i2 < n2; ++i2) {
            int n4;
            String string = (String)list.get(i2);
            char c2 = string.charAt(0);
            if (i2 - n == 0) {
                bl = Character.isUpperCase(c2);
                if (n3 == 1) {
                    c2 = Character.toUpperCase(c2);
                }
            } else if (n3 == 0) {
                if (!bl) {
                    n4 = this.calculateCaseForRange(n, n2, intList, list);
                    c2 = n4 == 2 ? Character.toUpperCase(c2) : Character.toLowerCase(c2);
                    char c3 = n4 == 2 ? Character.toUpperCase(buffer.charAt(0)) : Character.toLowerCase(buffer.charAt(0));
                    String string2 = buffer.substring(1);
                    buffer.clear();
                    buffer.append(c3);
                    buffer.append(string2);
                } else {
                    n4 = this.calculateCaseForRange(n + 1, n2, intList, list);
                    c2 = n4 == 2 ? Character.toUpperCase(c2) : Character.toLowerCase(c2);
                }
            } else if (intList.get(n) == 1) {
                n4 = this.calculateCaseForRange(n + 1, n2, intList, list);
                c2 = n4 == 2 ? Character.toUpperCase(c2) : Character.toLowerCase(c2);
            }
            buffer.append(c2);
        }
        return buffer.toString();
    }

    public boolean isWordSeparator(char c2) {
        return Arrays.binarySearch(WORD_SEPARATORS_EUROPE, c2) >= 0;
    }

    private int calculateCaseForRange(int n, int n2, IntList intList, List list) {
        int n3 = 0;
        int n4 = 0;
        for (int i2 = n; i2 < n2; ++i2) {
            int n5 = intList.get(i2);
            if (n5 != 0 && n5 != 3) continue;
            if (Character.isUpperCase(((String)list.get(i2)).charAt(0))) {
                ++n3;
                continue;
            }
            ++n4;
        }
        if (n4 > n3) {
            return 1;
        }
        if (n4 < n3) {
            return 2;
        }
        return 0;
    }

    public boolean needRefreshDisplayTextAfterTextChange() {
        return false;
    }

    public void setHandWrittenModeIsActive(boolean bl) {
        this.isHandwrittenActive = bl;
    }
}

