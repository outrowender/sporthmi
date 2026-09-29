/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.AudioInfo;
import de.audi.tuner.app.BeepHandler;
import de.audi.tuner.app.BeepHandler$1;

class BeepHandler$AudioListener
extends AudioInfo {
    private final /* synthetic */ BeepHandler this$0;

    private BeepHandler$AudioListener(BeepHandler beepHandler) {
        this.this$0 = beepHandler;
    }

    @Override
    public void handleFadedIn(int n) {
        if (n == 120 && BeepHandler.access$200(this.this$0)) {
            BeepHandler.access$300((BeepHandler)this.this$0).audio.log(1078071040, "Audio for Tuner system tone connection %1 is audible.", (long)n);
            BeepHandler.access$400(this.this$0);
        }
    }

    /* synthetic */ BeepHandler$AudioListener(BeepHandler beepHandler, BeepHandler$1 beepHandler$1) {
        this(beepHandler);
    }
}

