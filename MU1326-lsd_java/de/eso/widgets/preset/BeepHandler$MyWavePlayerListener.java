/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.tghu.waveplayer.WavePlayerListener;
import de.eso.widgets.preset.BeepHandler;
import de.eso.widgets.preset.BeepHandler$1;

class BeepHandler$MyWavePlayerListener
implements WavePlayerListener {
    private final /* synthetic */ BeepHandler this$0;

    private BeepHandler$MyWavePlayerListener(BeepHandler beepHandler) {
        this.this$0 = beepHandler;
    }

    @Override
    public void state(int n) {
        BeepHandler.access$100().log(-2137614336, "BeepHandler#MyWavePlayerListener#state %1", (long)n);
        if (n != 0) {
            BeepHandler.access$200(this.this$0);
        }
    }

    @Override
    public void playToneInfo(int n) {
        BeepHandler.access$100().log(-2137614336, "BeepHandler#MyWavePlayerListener#playToneInfo playTone=%1 set.", (long)n);
    }

    /* synthetic */ BeepHandler$MyWavePlayerListener(BeepHandler beepHandler, BeepHandler$1 beepHandler$1) {
        this(beepHandler);
    }
}

