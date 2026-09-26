/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.def.NullTunerService;
import de.audi.tv.app.audio.TunerAnnouncementHandler$CallListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSICallListener;

public class TunerAnnouncementHandler {
    public final DSICallListener callListener = new TunerAnnouncementHandler$CallListener(this, null);
    private TunerService tunerService;

    public TunerAnnouncementHandler(TVEnv tVEnv) {
        this.tunerService = new NullTunerService(tVEnv.lcAudio);
    }

    public void registerService(TunerService tunerService) {
        this.tunerService = tunerService;
    }

    static /* synthetic */ TunerService access$100(TunerAnnouncementHandler tunerAnnouncementHandler) {
        return tunerAnnouncementHandler.tunerService;
    }
}

