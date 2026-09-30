/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.SDSListEntry;

public interface AppInfoKrServiceListener {
    public void responseShowSimpleMap(int var1);

    public void responseStartSimpleMapFreeSelection(int var1);

    public void updateSpeakableSimpleMaps(SDSListEntry[] var1);

    public void responseRefreshSpeakableSimpleMaps(int var1);
}

