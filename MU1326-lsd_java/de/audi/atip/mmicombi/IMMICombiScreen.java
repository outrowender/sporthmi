/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

public interface IMMICombiScreen {
    public static final int MMICOMBI_CONTEXT_POPUP_HMI;
    public static final int MMICOMBI_CONTEXT_POPUP_COMBI;

    default public int getMmiCombiContextID() {
    }

    default public void setMmiCombiContextID(int n, boolean bl) {
    }

    default public boolean isHMIScreen() {
    }

    default public void setSelectionDrawerVisible(boolean bl) {
    }
}

