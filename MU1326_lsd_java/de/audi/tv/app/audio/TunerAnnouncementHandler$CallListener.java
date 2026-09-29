/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.tv.app.audio.TunerAnnouncementHandler;
import de.audi.tv.app.audio.TunerAnnouncementHandler$1;
import de.audi.tv.app.dsi.DSICallListener;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TunerAnnouncementHandler$CallListener
extends DSICallListener {
    private final /* synthetic */ TunerAnnouncementHandler this$0;

    private TunerAnnouncementHandler$CallListener(TunerAnnouncementHandler tunerAnnouncementHandler) {
        this.this$0 = tunerAnnouncementHandler;
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        TunerAnnouncementHandler.access$100(this.this$0).abortActiveTA();
    }

    @Override
    public void selectNextService(int n) {
        TunerAnnouncementHandler.access$100(this.this$0).abortActiveTA();
    }

    @Override
    public void switchSource(int n, boolean bl) {
        TunerAnnouncementHandler.access$100(this.this$0).abortActiveTA();
    }

    /* synthetic */ TunerAnnouncementHandler$CallListener(TunerAnnouncementHandler tunerAnnouncementHandler, TunerAnnouncementHandler$1 tunerAnnouncementHandler$1) {
        this(tunerAnnouncementHandler);
    }
}

