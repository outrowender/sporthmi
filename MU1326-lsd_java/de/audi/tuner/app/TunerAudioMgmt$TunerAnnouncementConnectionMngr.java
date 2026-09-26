/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.AudioInfo;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerAudioMgmt$1;

class TunerAudioMgmt$TunerAnnouncementConnectionMngr {
    boolean announcementConnectionActive = false;
    private final /* synthetic */ TunerAudioMgmt this$0;

    private TunerAudioMgmt$TunerAnnouncementConnectionMngr(TunerAudioMgmt tunerAudioMgmt) {
        this.this$0 = tunerAudioMgmt;
    }

    public void announcementConnStarted() {
        if (!this.announcementConnectionActive) {
            this.announcementConnectionActive = true;
            this.informListeners();
        }
    }

    private void informListeners() {
        AudioInfo[] audioInfoArray = TunerAudioMgmt.access$200(this.this$0);
        for (int i2 = 0; i2 < audioInfoArray.length; ++i2) {
            audioInfoArray[i2].tunerAnnouncementConnectionStarted(this.announcementConnectionActive);
        }
    }

    public void announcementConnectionStopped() {
        if (this.announcementConnectionActive) {
            this.announcementConnectionActive = false;
            this.informListeners();
        }
    }

    /* synthetic */ TunerAudioMgmt$TunerAnnouncementConnectionMngr(TunerAudioMgmt tunerAudioMgmt, TunerAudioMgmt$1 tunerAudioMgmt$1) {
        this(tunerAudioMgmt);
    }
}

