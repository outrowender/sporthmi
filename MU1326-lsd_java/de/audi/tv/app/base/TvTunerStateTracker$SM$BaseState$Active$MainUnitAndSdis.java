/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$SM;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active;

public class TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis
extends AbstractTunerState {
    private final /* synthetic */ TvTunerStateTracker$SM$BaseState$Active this$3;

    public TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis(TvTunerStateTracker$SM$BaseState$Active tvTunerStateTracker$SM$BaseState$Active) {
        this.this$3 = tvTunerStateTracker$SM$BaseState$Active;
    }

    @Override
    protected void onMuLostAudioFocus() {
        TvTunerStateTracker.access$3400(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).onMuLostTvAudioFocus();
        TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3).onMuLostAudioFocus();
        TvTunerStateTracker$SM.access$4900(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$SdisOnly")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly);
    }

    @Override
    protected void onSdisLostAudioFocus() {
        TvTunerStateTracker.access$3400(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).onSdisLostTvAudioFocus();
        TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3).onSdisLostAudioFocus();
        TvTunerStateTracker$SM.access$5000(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly);
    }

    @Override
    protected void onLostSdisConnection() {
        TvTunerStateTracker.access$3400(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).onSdisLostTvAudioFocus();
        TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3).onLostSdisConnection();
        TvTunerStateTracker$SM.access$5100(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly);
    }
}

