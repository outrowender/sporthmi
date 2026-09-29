/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$SM;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active;
import de.audi.tv.app.util.Message;

public class TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode
extends AbstractTunerState {
    private final /* synthetic */ TvTunerStateTracker$SM$BaseState$Active this$3;

    public TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode(TvTunerStateTracker$SM$BaseState$Active tvTunerStateTracker$SM$BaseState$Active) {
        this.this$3 = tvTunerStateTracker$SM$BaseState$Active;
    }

    @Override
    public void enter(Message message) {
        TvTunerStateTracker.access$3600(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).log(1078071040, "[TvTunerStateTracker.EnergySavingMode.enter] entering ESM  %1", (Object)message);
        TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)TvTunerStateTracker$SM$BaseState$Active.access$3500((TvTunerStateTracker$SM$BaseState$Active)this.this$3)))).tunerStatusListener.onEsmEntered();
    }

    @Override
    protected void onTunerDeactivated() {
        TvTunerStateTracker.access$3600(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).log(1078071040, "[TvTunerStateTracker.EnergySavingMode.onTunerDeactivated]");
        TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)).changeEsmState(true, false);
        TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)TvTunerStateTracker$SM$BaseState$Active.access$3500((TvTunerStateTracker$SM$BaseState$Active)this.this$3)))).childLockListener.onChildLockDisabled();
        TvTunerStateTracker.access$1000(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).release();
        TvTunerStateTracker$SM.access$1902(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), false);
        TvTunerStateTracker$SM.access$3700(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnavailable")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable);
    }

    @Override
    protected void onMuGotAudioFocus(boolean bl) {
        TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3).onMuGotAudioFocus(bl);
        TvTunerStateTracker.access$1000(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).release();
        TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)).switchSource(TvTunerStateTracker$SM.access$1600(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))), !bl);
        TvTunerStateTracker.access$3800(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).activate(TvTunerStateTracker$SM.access$1600(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))));
        TvTunerStateTracker$SM.access$3900(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$ActivationMeta")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta);
    }

    @Override
    protected void onSdisGotAudioFocus() {
        TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3).onSdisGotAudioFocus();
        if (TvTunerStateTracker$SM.access$1500(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))) {
            TvTunerStateTracker.access$1000(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).release();
            TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)).switchSource(TvTunerStateTracker$SM.access$1600(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))), false);
            TvTunerStateTracker$SM.access$4000(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$ActivationMeta")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta);
        }
    }

    @Override
    protected void onGotSdisConnection() {
        TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3).onGotSdisConnection();
        if (TvTunerStateTracker$SM.access$1400(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))) {
            TvTunerStateTracker.access$1000(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).release();
            TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)).switchSource(TvTunerStateTracker$SM.access$1600(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))), false);
            TvTunerStateTracker$SM.access$4100(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$ActivationMeta")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta);
        }
    }

    @Override
    protected void onMuLostAudioFocus() {
        TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3).onMuLostAudioFocus();
    }

    @Override
    protected void onSdisLostAudioFocus() {
        TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3).onSdisLostAudioFocus();
    }

    @Override
    protected void onLostSdisConnection() {
        TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3).onLostSdisConnection();
    }

    @Override
    protected void onFactoryReset() {
        TvTunerStateTracker.access$1000(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).release();
        this.this$3.onFactoryReset();
    }

    @Override
    protected void onEsmActivated() {
        TvTunerStateTracker.access$3600(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).log(1078071040, "[TvTunerStateTracker.EnergySavingMode.onEsmActivated]");
        TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)).changeEsmState(true, true);
    }

    @Override
    protected void onEsmDeactivated() {
        TvTunerStateTracker.access$3600(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).log(1078071040, "[TvTunerStateTracker.EnergySavingMode.onEsmDeactivated]");
        TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)).changeEsmState(false, true);
        if (TvTunerStateTracker$SM.access$1200(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))) || TvTunerStateTracker$SM.access$1400(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3))) && TvTunerStateTracker$SM.access$1500(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))) {
            TvTunerStateTracker$SM.access$4200(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$ActivationMeta")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta);
        }
    }
}

