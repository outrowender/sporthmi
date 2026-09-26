/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$SM;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState;
import de.audi.tv.app.util.Message;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class TvTunerStateTracker$SM$BaseState$TunerUnavailable
extends AbstractTunerState {
    private final /* synthetic */ TvTunerStateTracker$SM$BaseState this$2;

    public TvTunerStateTracker$SM$BaseState$TunerUnavailable(TvTunerStateTracker$SM$BaseState tvTunerStateTracker$SM$BaseState) {
        this.this$2 = tvTunerStateTracker$SM$BaseState;
    }

    @Override
    public void enter(Message message) {
        TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)this.this$2))).tunerStatusListener.onTunerUnavailable();
    }

    @Override
    public void exit(Message message) {
        TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)this.this$2))).tunerStatusListener.onTunerAvailable();
    }

    @Override
    protected void onStartUpMUConfig(StartUpConfig startUpConfig) {
        TvTunerStateTracker$SM.access$2002(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TVUtil.doesTunerRequireHmiEsmHandling(startUpConfig));
        TvTunerStateTracker$SM.access$2102(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), true);
        this.makeStartTransition();
    }

    @Override
    protected void onTunerActivated() {
        TvTunerStateTracker$SM.access$1902(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), true);
        this.makeStartTransition();
    }

    private void makeStartTransition() {
        if (TvTunerStateTracker$SM.access$1900(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)) && TvTunerStateTracker$SM.access$2100(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))) {
            if (!TvTunerStateTracker$SM.access$2300(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)) && (TvTunerStateTracker$SM.access$1200(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)) || TvTunerStateTracker$SM.access$1400(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)) && TvTunerStateTracker$SM.access$1500(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)))) {
                TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)this.this$2))).tunerStatusListener.onEsmLeft();
            }
            TvTunerStateTracker$SM.access$2400(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$StartUpMeta")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta);
        }
    }
}

