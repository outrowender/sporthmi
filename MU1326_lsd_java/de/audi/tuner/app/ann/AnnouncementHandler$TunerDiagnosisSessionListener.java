/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.ann;

import de.audi.tuner.app.TunerDiagnosisApplication$ITunerDiagnosisSessionListener;
import de.audi.tuner.app.ann.AnnouncementHandler$1;

class AnnouncementHandler$TunerDiagnosisSessionListener
implements TunerDiagnosisApplication$ITunerDiagnosisSessionListener {
    private volatile boolean diagSessionRunning = false;

    private AnnouncementHandler$TunerDiagnosisSessionListener() {
    }

    @Override
    public void diagnosisSessionStarted() {
        this.diagSessionRunning = true;
    }

    @Override
    public void diagnosisSessionStopped() {
        this.diagSessionRunning = false;
    }

    /* synthetic */ AnnouncementHandler$TunerDiagnosisSessionListener(AnnouncementHandler$1 announcementHandler$1) {
        this();
    }

    static /* synthetic */ boolean access$600(AnnouncementHandler$TunerDiagnosisSessionListener announcementHandler$TunerDiagnosisSessionListener) {
        return announcementHandler$TunerDiagnosisSessionListener.diagSessionRunning;
    }
}

