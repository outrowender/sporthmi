/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.SDSListEntry;

public interface TVServiceListener {
    public String getName();

    public void updateSourceList(int[] var1);

    public void updateTVStationList(SDSListEntry[] var1, int var2);
}

