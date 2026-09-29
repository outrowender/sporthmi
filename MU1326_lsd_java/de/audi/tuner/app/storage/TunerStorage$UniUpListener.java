/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.storage.TunerStorage$1;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;

class TunerStorage$UniUpListener
extends UniDsiUpInfo {
    private final /* synthetic */ TunerStorage this$0;

    private TunerStorage$UniUpListener(TunerStorage tunerStorage) {
        this.this$0 = tunerStorage;
    }

    @Override
    public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
        this.this$0.storeLastUniStation(unifiedStationExt);
    }

    /* synthetic */ TunerStorage$UniUpListener(TunerStorage tunerStorage, TunerStorage$1 tunerStorage$1) {
        this(tunerStorage);
    }
}

