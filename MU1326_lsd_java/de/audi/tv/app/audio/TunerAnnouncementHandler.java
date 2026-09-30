/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.def.NullTunerService;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSICallListener;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TunerAnnouncementHandler {
    public final DSICallListener callListener = new CallListener();
    private TunerService tunerService;

    public TunerAnnouncementHandler(TVEnv tVEnv) {
        this.tunerService = new NullTunerService(tVEnv.lcAudio);
    }

    public void registerService(TunerService tunerService) {
        this.tunerService = tunerService;
    }

    private class CallListener
    extends DSICallListener {
        private CallListener() {
        }

        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            TunerAnnouncementHandler.this.tunerService.abortActiveTA();
        }

        public void selectNextService(int n) {
            TunerAnnouncementHandler.this.tunerService.abortActiveTA();
        }

        public void switchSource(int n, boolean bl) {
            TunerAnnouncementHandler.this.tunerService.abortActiveTA();
        }
    }
}

