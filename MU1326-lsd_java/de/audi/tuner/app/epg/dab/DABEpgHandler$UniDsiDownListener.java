/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.tuner.app.epg.dab.DABEpgHandler;
import de.audi.tuner.app.epg.dab.DABEpgHandler$1;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;

class DABEpgHandler$UniDsiDownListener
extends UniDsiDownInfo {
    private final /* synthetic */ DABEpgHandler this$0;

    private DABEpgHandler$UniDsiDownListener(DABEpgHandler dABEpgHandler) {
        this.this$0 = dABEpgHandler;
    }

    @Override
    public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
        DABEpgHandler.access$800(this.this$0, unifiedStationExt);
    }

    /* synthetic */ DABEpgHandler$UniDsiDownListener(DABEpgHandler dABEpgHandler, DABEpgHandler$1 dABEpgHandler$1) {
        this(dABEpgHandler);
    }
}

