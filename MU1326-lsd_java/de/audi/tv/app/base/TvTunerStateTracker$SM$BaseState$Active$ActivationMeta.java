/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$SM;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active;
import de.audi.tv.app.base.TvTunerStateTracker$TemporaryState;
import de.audi.tv.app.util.Message;

public class TvTunerStateTracker$SM$BaseState$Active$ActivationMeta
extends AbstractTunerState
implements TvTunerStateTracker$TemporaryState {
    private final /* synthetic */ TvTunerStateTracker$SM$BaseState$Active this$3;

    public TvTunerStateTracker$SM$BaseState$Active$ActivationMeta(TvTunerStateTracker$SM$BaseState$Active tvTunerStateTracker$SM$BaseState$Active) {
        this.this$3 = tvTunerStateTracker$SM$BaseState$Active;
    }

    @Override
    public void enter(Message message) {
        if (!TvTunerStateTracker$SM.access$2300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))) {
            this.onEsmDeactivated();
        }
        TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)).changeEsmState(false, false);
    }

    @Override
    protected void onEsmActivated() {
        this.this$3.onEsmActivated();
    }

    @Override
    protected void onEsmDeactivated() {
        TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)TvTunerStateTracker$SM$BaseState$Active.access$3500((TvTunerStateTracker$SM$BaseState$Active)this.this$3)))).tunerStatusListener.onEsmLeft();
        if (TvTunerStateTracker$SM.access$1200(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))) && TvTunerStateTracker$SM.access$1400(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))) && TvTunerStateTracker$SM.access$1500(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))) {
            TvTunerStateTracker.access$3400(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).onMuGotTvAudioFocus(TvTunerStateTracker$SM.access$1100(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))));
            TvTunerStateTracker.access$3400(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).onSdisGotTvAudioFocus();
            TvTunerStateTracker$SM.access$4300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis);
        } else if (TvTunerStateTracker$SM.access$1200(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))) {
            TvTunerStateTracker.access$3400(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).onMuGotTvAudioFocus(TvTunerStateTracker$SM.access$1100(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))));
            TvTunerStateTracker$SM.access$4400(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly);
        } else if (TvTunerStateTracker$SM.access$1400(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))) && TvTunerStateTracker$SM.access$1500(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))) {
            TvTunerStateTracker.access$3400(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).onSdisGotTvAudioFocus();
            TvTunerStateTracker$SM.access$4500(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$SdisOnly")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly);
        } else {
            TvTunerStateTracker.access$3600(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).log(10000, "[SM.ActivationMeta.onEsmDeactivated] no MU AudioFocus and (no SDIS available or no SDIS AudioFocus) ... returning to ESM");
            if (TvTunerStateTracker$SM.access$2000(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))) {
                TvTunerStateTracker.access$900(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).switchSource(6, false);
            }
            TvTunerStateTracker$SM.access$4600(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode);
        }
    }
}

