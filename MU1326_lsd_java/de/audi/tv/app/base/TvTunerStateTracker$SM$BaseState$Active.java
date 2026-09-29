/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$SM;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState;

public class TvTunerStateTracker$SM$BaseState$Active
extends AbstractTunerState {
    private final /* synthetic */ TvTunerStateTracker$SM$BaseState this$2;

    public TvTunerStateTracker$SM$BaseState$Active(TvTunerStateTracker$SM$BaseState tvTunerStateTracker$SM$BaseState) {
        this.this$2 = tvTunerStateTracker$SM$BaseState;
    }

    @Override
    protected void onTunerDeactivated() {
        TvTunerStateTracker$SM$BaseState.access$1700(this.this$2).changeEsmState(true, false);
        this.deactivateAudio();
        TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)this.this$2))).childLockListener.onChildLockDisabled();
        TvTunerStateTracker$SM.access$1902(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), false);
        TvTunerStateTracker$SM.access$2800(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnavailable")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable);
    }

    @Override
    protected void onDeinit() {
        TvTunerStateTracker$SM.access$1902(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), false);
        TvTunerStateTracker$SM.access$2900(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnavailable")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable);
    }

    @Override
    protected void onHighTemperatureShutdown() {
        this.deactivateAudio();
        if (TvTunerStateTracker$SM.access$2000(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))) {
            TvTunerStateTracker.access$900(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))).switchSource(6, false);
        }
        TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)this.this$2))).tunerStatusListener.onHighTemperatureShutdown();
        TvTunerStateTracker$SM.access$3000(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode);
    }

    @Override
    protected void onChildLockEnabled() {
        if (!TvTunerStateTracker$SM.access$3100(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))) {
            TvTunerStateTracker$SM.access$3102(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), true);
            TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)this.this$2))).childLockListener.onChildLockEnabled();
        }
    }

    @Override
    protected void onChildLockDisabled() {
        if (TvTunerStateTracker$SM.access$3100(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))) {
            TvTunerStateTracker$SM.access$3102(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), false);
            TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)TvTunerStateTracker$SM$BaseState.access$1700((TvTunerStateTracker$SM$BaseState)this.this$2))).childLockListener.onChildLockDisabled();
        }
    }

    @Override
    protected void onMuLostAudioFocus() {
        this.this$2.onMuLostAudioFocus();
        this.checkLostAllAudioFocus();
    }

    @Override
    protected void onSdisLostAudioFocus() {
        this.this$2.onSdisLostAudioFocus();
        this.checkLostAllAudioFocus();
    }

    @Override
    protected void onLostSdisConnection() {
        this.this$2.onLostSdisConnection();
        this.checkLostAllAudioFocus();
    }

    @Override
    protected void onSourceSwitchRequested(int n) {
        if (TvTunerStateTracker$SM.access$1100(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)) && n != TvTunerStateTracker$SM.access$1600(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))) {
            TvTunerStateTracker$SM.access$1102(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), false);
        }
        TvTunerStateTracker$SM$BaseState.access$1700(this.this$2).switchSource(n, !TvTunerStateTracker$SM.access$1100(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)));
    }

    @Override
    protected void onFactoryReset() {
        this.this$2.onFactoryReset();
        TvTunerStateTracker$SM$BaseState.access$1700(this.this$2).switchSource(TvTunerStateTracker$SM.access$1600(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)), false);
    }

    @Override
    protected void onEsmActivated() {
        if (TvTunerStateTracker$SM.access$2000(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))) {
            TvTunerStateTracker.access$900(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))).switchSource(6, false);
        }
        TvTunerStateTracker$SM$BaseState.access$1700(this.this$2).changeEsmState(true, true);
        TvTunerStateTracker$SM.access$3200(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode);
    }

    private void checkLostAllAudioFocus() {
        if (!(TvTunerStateTracker$SM.access$1200(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)) || TvTunerStateTracker$SM.access$1400(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)) && TvTunerStateTracker$SM.access$1500(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)))) {
            this.deactivateAudio();
            if (TvTunerStateTracker$SM.access$2000(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))) {
                TvTunerStateTracker.access$900(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))).switchSource(6, false);
            }
            TvTunerStateTracker$SM.access$3300(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode);
        }
    }

    private void deactivateAudio() {
        TvTunerStateTracker.access$3400(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))).onMuLostTvAudioFocus();
        TvTunerStateTracker.access$3400(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))).onSdisLostTvAudioFocus();
    }

    static /* synthetic */ TvTunerStateTracker$SM$BaseState access$3500(TvTunerStateTracker$SM$BaseState$Active tvTunerStateTracker$SM$BaseState$Active) {
        return tvTunerStateTracker$SM$BaseState$Active.this$2;
    }
}

