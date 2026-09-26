/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.SDSListEntry;

public interface TVServiceListener {
    default public String getName() {
    }

    default public void updateSourceList(int[] nArray) {
    }

    default public void updateTVStationList(SDSListEntry[] sDSListEntryArray, int n) {
    }
}

