/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudioListener;

public interface CombiBAPServiceTunerListener
extends CombiBAPServiceAudioListener {
    default public void startStationListUpdate() {
    }

    default public void cancelStationListUpdate() {
    }

    default public void cancelAnnouncement() {
    }

    default public void setProgramStringLength(boolean bl, boolean bl2) {
    }

    default public void resendAllInfoForActiveBand() {
    }
}

