/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.CombiBAPService;

public interface CombiBAPServiceTone
extends CombiBAPService {
    public void updateMuteState(boolean var1, boolean var2);

    public void updateVolumeProperties(byte var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9);

    public void updateVolume(int var1, int var2, int var3, boolean var4, boolean var5);
}

