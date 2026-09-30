/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.earlyfunc.core.parking.pla;

public interface IPLAStatusCallbackListener {
    public void updateFocusedSpotInSelectionMode(int var1, int var2);

    public void updateSelectedSpotInSelectionMode(int var1, int var2);

    public void updateFocusedSpotOutSelectionMode(int var1, int var2);

    public void updateSelectedSpotOutSelectionMode(int var1, int var2);
}

