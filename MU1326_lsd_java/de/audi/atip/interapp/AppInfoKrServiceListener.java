/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.SDSListEntry;

public interface AppInfoKrServiceListener {
    default public void responseShowSimpleMap(int n) {
    }

    default public void responseStartSimpleMapFreeSelection(int n) {
    }

    default public void updateSpeakableSimpleMaps(SDSListEntry[] sDSListEntryArray) {
    }

    default public void responseRefreshSpeakableSimpleMaps(int n) {
    }
}

