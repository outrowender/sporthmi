/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

public interface IInfiniteListData {
    public static final int REQUEST_ID_REMOTEHMI = Integer.MIN_VALUE;
    public static final int DEFAULT_PROXY_RANGE = 5;
    public static final int DEFAULT_MAX_ELEMENTS_IN_SCREEN = 10;
    public static final int DEFAULT_OVERLAP_SIZE = 20;

    public int getTotalLength();

    public void setTotalLength(int var1);

    public int getStartIndex();

    public void setStartIndex(int var1);

    public int getProxyRange();

    public void setProxyRange(int var1);

    public int getOverlapSize();

    public void setOverlapSize(int var1);

    public int getMaxElementsInScreen();

    public void setMaxElementsInScreen(int var1);

    public boolean isConsistent(int var1);
}

