/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

public interface ToneServiceListener {
    public static final int APS_ENTERTAINMENT_LOWERING_COMBOBOX_OPEN = 1;
    public static final int APS_ENTERTAINMENT_LOWERING_COMBOBOX_CLOSED = 0;

    public void updateApsEntertainmentLoweringComboboxState(int var1);
}

