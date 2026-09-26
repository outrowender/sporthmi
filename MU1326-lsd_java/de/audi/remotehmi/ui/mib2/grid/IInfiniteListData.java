/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

public interface IInfiniteListData {
    public static final int REQUEST_ID_REMOTEHMI;
    public static final int DEFAULT_PROXY_RANGE;
    public static final int DEFAULT_MAX_ELEMENTS_IN_SCREEN;
    public static final int DEFAULT_OVERLAP_SIZE;

    default public int getTotalLength() {
    }

    default public void setTotalLength(int n) {
    }

    default public int getStartIndex() {
    }

    default public void setStartIndex(int n) {
    }

    default public int getProxyRange() {
    }

    default public void setProxyRange(int n) {
    }

    default public int getOverlapSize() {
    }

    default public void setOverlapSize(int n) {
    }

    default public int getMaxElementsInScreen() {
    }

    default public void setMaxElementsInScreen(int n) {
    }

    default public boolean isConsistent(int n) {
    }
}

