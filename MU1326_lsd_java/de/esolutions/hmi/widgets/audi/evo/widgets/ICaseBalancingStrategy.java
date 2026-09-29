/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.fw.util.commons.IntList;
import java.util.List;

public interface ICaseBalancingStrategy {
    public static final int GROUP_CASE_SENSITIVE;
    public static final int GROUP_CASE_AMBIGUOUS;
    public static final int GROUP_CASE_INSENSITIVE;
    public static final int GROUP_CASE_LOWER_CASE_ONLY;
    public static final int GROUP_CASE_UPPER_CASE_ONLY;
    public static final int CASE_BALANCED;
    public static final int CASE_LOWER;
    public static final int CASE_UPPER;

    default public String refreshForDisplayCaseBalancingText(int n, int n2, IntList intList, List list) {
    }

    default public boolean isWordSeparator(char c2) {
    }

    default public boolean needRefreshDisplayTextAfterTextChange() {
    }

    default public void setHandWrittenModeIsActive(boolean bl) {
    }
}

