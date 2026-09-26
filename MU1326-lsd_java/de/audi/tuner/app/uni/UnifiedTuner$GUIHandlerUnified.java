/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.uni.UnifiedTuner;
import de.audi.tuner.app.uni.UnifiedTuner$1;
import de.audi.tuner.app.uni.UnifiedTuner$GUIHandlerUnified$1;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;

class UnifiedTuner$GUIHandlerUnified
implements ITunerGUIHandler {
    private final /* synthetic */ UnifiedTuner this$0;

    private UnifiedTuner$GUIHandlerUnified(UnifiedTuner unifiedTuner) {
        this.this$0 = unifiedTuner;
    }

    @Override
    public void register(IStoreStationHandler iStoreStationHandler) {
    }

    @Override
    public IStationListHandler getStationListHandler() {
        return UnifiedTuner.access$1000(this.this$0);
    }

    @Override
    public boolean tuneById(long l, int n) {
        return UnifiedTuner.access$1000(this.this$0).tuneById(l, n);
    }

    @Override
    public TunerObjectContainer[] getStationList() {
        return UnifiedTuner.access$1000(this.this$0).getStationList();
    }

    @Override
    public TunerObjectContainer[] getStationList(int n) {
        return new TunerObjectContainer[0];
    }

    @Override
    public TunerObjectContainer getCurrentStation() {
        return new TunerObjectContainer(UnifiedTuner.access$1000(this.this$0).getActiveStation());
    }

    @Override
    public IPowerEvent getPoPowerStateListener() {
        return new UnifiedTuner$GUIHandlerUnified$1(this);
    }

    /* synthetic */ UnifiedTuner$GUIHandlerUnified(UnifiedTuner unifiedTuner, UnifiedTuner$1 unifiedTuner$1) {
        this(unifiedTuner);
    }
}

