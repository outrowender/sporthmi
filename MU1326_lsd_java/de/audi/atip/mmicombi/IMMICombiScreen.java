/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

public interface IMMICombiScreen {
    public static final int MMICOMBI_CONTEXT_POPUP_HMI = 1000;
    public static final int MMICOMBI_CONTEXT_POPUP_COMBI = 1001;

    public int getMmiCombiContextID();

    public void setMmiCombiContextID(int var1, boolean var2);

    public boolean isHMIScreen();

    public void setSelectionDrawerVisible(boolean var1);
}

