/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.SDARSManTune;
import de.audi.tuner.app.sdars.SDARSManTune$1;

class SDARSManTune$TunerActionProxyListenerExt
extends TunerActionProxyListener {
    private final /* synthetic */ SDARSManTune this$0;

    private SDARSManTune$TunerActionProxyListenerExt(SDARSManTune sDARSManTune) {
        this.this$0 = sDARSManTune;
    }

    @Override
    public void manualTuneLeft() {
        if (SDARSManTune.access$1200(this.this$0).getActiveTuner() == 7) {
            SDARSManTune.access$1100(this.this$0);
        }
    }

    /* synthetic */ SDARSManTune$TunerActionProxyListenerExt(SDARSManTune sDARSManTune, SDARSManTune$1 sDARSManTune$1) {
        this(sDARSManTune);
    }
}

