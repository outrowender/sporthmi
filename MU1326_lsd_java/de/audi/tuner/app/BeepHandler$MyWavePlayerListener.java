/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tghu.waveplayer.WavePlayerListener;
import de.audi.tuner.app.BeepHandler;
import de.audi.tuner.app.BeepHandler$1;

class BeepHandler$MyWavePlayerListener
implements WavePlayerListener {
    private final /* synthetic */ BeepHandler this$0;

    private BeepHandler$MyWavePlayerListener(BeepHandler beepHandler) {
        this.this$0 = beepHandler;
    }

    @Override
    public void state(int n) {
        BeepHandler.access$300((BeepHandler)this.this$0).hmi.log(-2137614336, "beepHandler state %1 ", (long)n);
        if (n != 0) {
            BeepHandler.access$500(this.this$0);
        }
    }

    @Override
    public void playToneInfo(int n) {
        BeepHandler.access$300((BeepHandler)this.this$0).hmi.log(-2137614336, "beepHandler playTone %1 set.", (long)n);
    }

    /* synthetic */ BeepHandler$MyWavePlayerListener(BeepHandler beepHandler, BeepHandler$1 beepHandler$1) {
        this(beepHandler);
    }
}

