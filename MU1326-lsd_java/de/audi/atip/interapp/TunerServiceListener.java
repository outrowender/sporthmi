/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.SDSListEntry;

public interface TunerServiceListener {
    default public String getName() {
    }

    default public void updateBandList(int[] nArray) {
    }

    default public void updateStationList(SDSListEntry[] sDSListEntryArray, int n) {
    }

    default public void updateEnsembleList(SDSListEntry[] sDSListEntryArray) {
    }

    default public void updateGenreList(SDSListEntry[] sDSListEntryArray) {
    }

    default public void updateChannelNumberList(SDSListEntry[] sDSListEntryArray) {
    }
}

