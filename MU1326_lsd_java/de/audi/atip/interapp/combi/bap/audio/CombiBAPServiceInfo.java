/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.CombiBAPService;

public interface CombiBAPServiceInfo
extends CombiBAPService {
    public void skipResult(boolean var1);

    public void updateTPMemoInfo(short var1, short var2, short var3, short var4, String var5);

    public void notifyMessagePlaybackActive(boolean var1);

    public void updateTAMessageRecordingActive(boolean var1);
}

