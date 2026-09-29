/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.CombiBAPService;

public interface CombiBAPServiceTone
extends CombiBAPService {
    default public void updateMuteState(boolean bl, boolean bl2) {
    }

    default public void updateVolumeProperties(byte by, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
    }

    default public void updateVolume(int n, int n2, int n3, boolean bl, boolean bl2) {
    }
}

