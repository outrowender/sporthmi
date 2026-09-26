/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$SM;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState;
import de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active;

public class TvTunerStateTracker$SM$BaseState$Active$SdisOnly
extends AbstractTunerState {
    private final /* synthetic */ TvTunerStateTracker$SM$BaseState$Active this$3;

    public TvTunerStateTracker$SM$BaseState$Active$SdisOnly(TvTunerStateTracker$SM$BaseState$Active tvTunerStateTracker$SM$BaseState$Active) {
        this.this$3 = tvTunerStateTracker$SM$BaseState$Active;
    }

    @Override
    protected void onMuGotAudioFocus(boolean bl) {
        TvTunerStateTracker.access$3400(TvTunerStateTracker$SM.access$1300(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)))).onMuGotTvAudioFocus(bl);
        TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3).onMuGotAudioFocus(bl);
        TvTunerStateTracker$SM.access$5200(TvTunerStateTracker$SM$BaseState.access$1700(TvTunerStateTracker$SM$BaseState$Active.access$3500(this.this$3)), TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis);
    }
}

