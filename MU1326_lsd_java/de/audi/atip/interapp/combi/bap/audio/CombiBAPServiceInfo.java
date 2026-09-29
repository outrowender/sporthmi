/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.CombiBAPService;

public interface CombiBAPServiceInfo
extends CombiBAPService {
    default public void skipResult(boolean bl) {
    }

    default public void updateTPMemoInfo(short s, short s2, short s3, short s4, String string) {
    }

    default public void notifyMessagePlaybackActive(boolean bl) {
    }

    default public void updateTAMessageRecordingActive(boolean bl) {
    }
}

