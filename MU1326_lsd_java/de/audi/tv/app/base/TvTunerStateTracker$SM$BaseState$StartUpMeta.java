/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$SM;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState;
import de.audi.tv.app.base.TvTunerStateTracker$TemporaryState;
import de.audi.tv.app.util.Message;

public class TvTunerStateTracker$SM$BaseState$StartUpMeta
extends AbstractTunerState
implements TvTunerStateTracker$TemporaryState {
    private final /* synthetic */ TvTunerStateTracker$SM$BaseState this$2;

    public TvTunerStateTracker$SM$BaseState$StartUpMeta(TvTunerStateTracker$SM$BaseState tvTunerStateTracker$SM$BaseState) {
        this.this$2 = tvTunerStateTracker$SM$BaseState;
    }

    @Override
    public void enter(Message message) {
        if (TvTunerStateTracker$SM.access$1200(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)) || TvTunerStateTracker$SM.access$1400(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)) && TvTunerStateTracker$SM.access$1500(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))) {
            TvTunerStateTracker$SM$BaseState.access$1700(this.this$2).switchSource(TvTunerStateTracker$SM.access$1600(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)), false);
            TvTunerStateTracker$SM.access$2500(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$ActivationMeta")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta);
        } else {
            if (TvTunerStateTracker$SM.access$2000(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))) {
                TvTunerStateTracker.access$900(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2))).switchSource(6, false);
            } else {
                TvTunerStateTracker$SM$BaseState.access$1700(this.this$2).switchSource(TvTunerStateTracker$SM.access$1600(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2)), false);
            }
            TvTunerStateTracker$SM.access$2600(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode);
        }
    }

    @Override
    protected void onDeinit() {
        TvTunerStateTracker$SM.access$1902(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), false);
        TvTunerStateTracker$SM.access$2700(TvTunerStateTracker$SM$BaseState.access$1700(this.this$2), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnavailable")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable);
    }
}

