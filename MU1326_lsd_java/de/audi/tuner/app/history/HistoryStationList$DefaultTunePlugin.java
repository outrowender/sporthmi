/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.history.HistoryStationList$1;
import de.audi.tuner.app.history.ITunePlugin;

class HistoryStationList$DefaultTunePlugin
implements ITunePlugin {
    private HistoryStationList$DefaultTunePlugin() {
    }

    @Override
    public void doTune(TunerObjectContainer tunerObjectContainer, int n) {
        TunerProxyManager.getInstance().prepareAndTune(tunerObjectContainer, n);
    }

    @Override
    public boolean doTune(TunerObjectContainer tunerObjectContainer, int n, int n2) {
        this.doTune(tunerObjectContainer, n);
        return true;
    }

    /* synthetic */ HistoryStationList$DefaultTunePlugin(HistoryStationList$1 historyStationList$1) {
        this();
    }
}

