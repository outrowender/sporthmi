/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;

public interface CombiBAPServiceAudioListener
extends CombiBAPServiceListener {
    public static final int SEEK_FORWARD = 0;
    public static final int SEEK_BACKWARD = 1;

    public void switchSource(int var1, int var2, int var3);

    public void setActiveSourceState(int var1, int var2);

    public void selectListEntry(int var1);

    public void selectListEntryPresetList(int var1);

    public void skip(int var1);

    public void startSeek(int var1);

    public void cancelSeek();

    public void setPreferredList(int var1);

    public void getNextListPos(int var1, int var2);

    public void activateSource(int var1);
}

