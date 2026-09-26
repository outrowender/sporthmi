/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.tuner.app.epg.dab.DABEpgHandler;
import de.audi.tuner.app.epg.dab.DABEpgHandler$1;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;

class DABEpgHandler$UniDsiUpListener
extends UniDsiUpInfo {
    private final /* synthetic */ DABEpgHandler this$0;

    private DABEpgHandler$UniDsiUpListener(DABEpgHandler dABEpgHandler) {
        this.this$0 = dABEpgHandler;
    }

    @Override
    public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
        DABEpgHandler.access$800(this.this$0, unifiedStationExt);
    }

    /* synthetic */ DABEpgHandler$UniDsiUpListener(DABEpgHandler dABEpgHandler, DABEpgHandler$1 dABEpgHandler$1) {
        this(dABEpgHandler);
    }
}

