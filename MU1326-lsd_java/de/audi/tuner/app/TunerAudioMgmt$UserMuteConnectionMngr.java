/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.AudioInfo;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerAudioMgmt$1;

class TunerAudioMgmt$UserMuteConnectionMngr {
    boolean userMuteConnectionActive = false;
    private final /* synthetic */ TunerAudioMgmt this$0;

    private TunerAudioMgmt$UserMuteConnectionMngr(TunerAudioMgmt tunerAudioMgmt) {
        this.this$0 = tunerAudioMgmt;
    }

    public void userMuteConnStarted() {
        if (!this.userMuteConnectionActive) {
            this.userMuteConnectionActive = true;
            this.informListeners();
        }
    }

    private void informListeners() {
        AudioInfo[] audioInfoArray = TunerAudioMgmt.access$200(this.this$0);
        for (int i2 = 0; i2 < audioInfoArray.length; ++i2) {
            audioInfoArray[i2].userMuteConnectionStarted(this.userMuteConnectionActive);
        }
    }

    public void userMuteConnectionStopped() {
        if (this.userMuteConnectionActive) {
            this.userMuteConnectionActive = false;
            this.informListeners();
        }
    }

    /* synthetic */ TunerAudioMgmt$UserMuteConnectionMngr(TunerAudioMgmt tunerAudioMgmt, TunerAudioMgmt$1 tunerAudioMgmt$1) {
        this(tunerAudioMgmt);
    }
}

