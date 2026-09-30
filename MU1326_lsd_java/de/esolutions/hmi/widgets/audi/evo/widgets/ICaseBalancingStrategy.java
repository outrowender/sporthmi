/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.fw.util.commons.IntList;
import java.util.List;

public interface ICaseBalancingStrategy {
    public static final int GROUP_CASE_SENSITIVE = 0;
    public static final int GROUP_CASE_AMBIGUOUS = 1;
    public static final int GROUP_CASE_INSENSITIVE = 2;
    public static final int GROUP_CASE_LOWER_CASE_ONLY = 3;
    public static final int GROUP_CASE_UPPER_CASE_ONLY = 4;
    public static final int CASE_BALANCED = 0;
    public static final int CASE_LOWER = 1;
    public static final int CASE_UPPER = 2;

    public String refreshForDisplayCaseBalancingText(int var1, int var2, IntList var3, List var4);

    public boolean isWordSeparator(char var1);

    public boolean needRefreshDisplayTextAfterTextChange();

    public void setHandWrittenModeIsActive(boolean var1);
}

