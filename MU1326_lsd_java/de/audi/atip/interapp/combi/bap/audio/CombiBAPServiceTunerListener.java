/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudioListener;

public interface CombiBAPServiceTunerListener
extends CombiBAPServiceAudioListener {
    public void startStationListUpdate();

    public void cancelStationListUpdate();

    public void cancelAnnouncement();

    public void setProgramStringLength(boolean var1, boolean var2);

    public void resendAllInfoForActiveBand();
}

