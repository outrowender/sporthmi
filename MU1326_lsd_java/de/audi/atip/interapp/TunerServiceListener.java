/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.SDSListEntry;

public interface TunerServiceListener {
    public String getName();

    public void updateBandList(int[] var1);

    public void updateStationList(SDSListEntry[] var1, int var2);

    public void updateEnsembleList(SDSListEntry[] var1);

    public void updateGenreList(SDSListEntry[] var1);

    public void updateChannelNumberList(SDSListEntry[] var1);
}

