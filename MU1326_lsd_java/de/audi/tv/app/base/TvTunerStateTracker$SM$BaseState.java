/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$SM;

public class TvTunerStateTracker$SM$BaseState
extends AbstractTunerState {
    private final /* synthetic */ TvTunerStateTracker$SM this$1;

    public TvTunerStateTracker$SM$BaseState(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        this.this$1 = tvTunerStateTracker$SM;
    }

    @Override
    protected void onMuGotAudioFocus(boolean bl) {
        TvTunerStateTracker$SM.access$1102(this.this$1, bl);
        if (!TvTunerStateTracker$SM.access$1200(this.this$1)) {
            TvTunerStateTracker$SM.access$1202(this.this$1, true);
            TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)this.this$1)).audioListener.onMuGotTvAudioFocus(bl);
        }
    }

    @Override
    protected void onMuLostAudioFocus() {
        if (TvTunerStateTracker$SM.access$1200(this.this$1)) {
            TvTunerStateTracker$SM.access$1202(this.this$1, false);
            TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)this.this$1)).audioListener.onMuLostTvAudioFocus();
        }
    }

    @Override
    protected void onSdisGotAudioFocus() {
        if (!TvTunerStateTracker$SM.access$1400(this.this$1)) {
            TvTunerStateTracker$SM.access$1402(this.this$1, true);
            if (TvTunerStateTracker$SM.access$1500(this.this$1)) {
                TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)this.this$1)).audioListener.onSdisGotTvAudioFocus();
            }
        }
    }

    @Override
    protected void onSdisLostAudioFocus() {
        if (TvTunerStateTracker$SM.access$1400(this.this$1)) {
            TvTunerStateTracker$SM.access$1402(this.this$1, false);
            if (TvTunerStateTracker$SM.access$1500(this.this$1)) {
                TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)this.this$1)).audioListener.onSdisLostTvAudioFocus();
            }
        }
    }

    @Override
    protected void onGotSdisConnection() {
        if (!TvTunerStateTracker$SM.access$1500(this.this$1)) {
            TvTunerStateTracker$SM.access$1502(this.this$1, true);
            if (TvTunerStateTracker$SM.access$1400(this.this$1)) {
                TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)this.this$1)).audioListener.onSdisGotTvAudioFocus();
            }
        }
    }

    @Override
    protected void onLostSdisConnection() {
        if (TvTunerStateTracker$SM.access$1500(this.this$1)) {
            TvTunerStateTracker$SM.access$1502(this.this$1, false);
            if (TvTunerStateTracker$SM.access$1400(this.this$1)) {
                TvTunerStateTracker.access$700((TvTunerStateTracker)TvTunerStateTracker$SM.access$1300((TvTunerStateTracker$SM)this.this$1)).audioListener.onSdisLostTvAudioFocus();
            }
        }
    }

    @Override
    protected void onFactoryReset() {
        TvTunerStateTracker$SM.access$1602(this.this$1, 0);
    }

    @Override
    protected void onEsmActivated() {
        this.this$1.changeEsmState(true, false);
    }

    @Override
    protected void onEsmDeactivated() {
        this.this$1.changeEsmState(false, false);
    }

    static /* synthetic */ TvTunerStateTracker$SM access$1700(TvTunerStateTracker$SM$BaseState tvTunerStateTracker$SM$BaseState) {
        return tvTunerStateTracker$SM$BaseState.this$1;
    }
}

