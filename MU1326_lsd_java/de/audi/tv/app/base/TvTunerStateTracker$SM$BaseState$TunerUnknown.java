/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$SM;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class TvTunerStateTracker$SM$BaseState$TunerUnknown
extends AbstractTunerState {
    private final /* synthetic */ TvTunerStateTracker$SM$BaseState this$2;

    public TvTunerStateTracker$SM$BaseState$TunerUnknown(TvTunerStateTracker$SM$BaseState tvTunerStateTracker$SM$BaseState) {
        this.this$2 = tvTunerStateTracker$SM$BaseState;
    }

    @Override
    protected void onMuGotAudioFocus(boolean bl) {
        this.this$2.onMuGotAudioFocus(bl);
        TvTunerStateTracker$SM.access$1800(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnavailable")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable);
    }

    @Override
    protected void onTunerActivated() {
        TvTunerStateTracker$SM.access$1902(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), true);
    }

    @Override
    protected void onStartUpMUConfig(StartUpConfig startUpConfig) {
        TvTunerStateTracker$SM.access$2002(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TVUtil.doesTunerRequireHmiEsmHandling(startUpConfig));
        TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)this.this$2))).tunerStatusListener.onTunerAvailable();
        TvTunerStateTracker$SM.access$2102(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), true);
        TvTunerStateTracker$SM.access$2200(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$StartUpMeta")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta);
    }
}

