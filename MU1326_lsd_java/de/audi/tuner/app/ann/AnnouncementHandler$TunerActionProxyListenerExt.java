/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.ann;

import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.ann.AnnouncementHandler$1;
import de.audi.tuner.app.ap.TunerActionProxyListener;

class AnnouncementHandler$TunerActionProxyListenerExt
extends TunerActionProxyListener {
    private final /* synthetic */ AnnouncementHandler this$0;

    private AnnouncementHandler$TunerActionProxyListenerExt(AnnouncementHandler announcementHandler) {
        this.this$0 = announcementHandler;
    }

    @Override
    public void taVolumeAdjustmentActivated() {
        AnnouncementHandler.access$700(this.this$0, this.terminalID);
    }

    @Override
    public void taVolumeAdjustmentDeactivated() {
        AnnouncementHandler.access$800(this.this$0, this.terminalID);
    }

    /* synthetic */ AnnouncementHandler$TunerActionProxyListenerExt(AnnouncementHandler announcementHandler, AnnouncementHandler$1 announcementHandler$1) {
        this(announcementHandler);
    }
}

