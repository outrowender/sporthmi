/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.audio.CombiServiceHandler;
import de.audi.audio.CombiServiceHandler$1;

class CombiServiceHandler$HideTimerListener
extends DefaultTimerListener {
    private final /* synthetic */ CombiServiceHandler this$0;

    private CombiServiceHandler$HideTimerListener(CombiServiceHandler combiServiceHandler) {
        this.this$0 = combiServiceHandler;
    }

    @Override
    public void fireTimer(Timer timer) {
        CombiServiceHandler.access$200(this.this$0).log(-2137614336, "[CombiServiceHandler.HideTimerListener.fireTimer]");
        this.this$0.showVolumePopup(false);
    }

    /* synthetic */ CombiServiceHandler$HideTimerListener(CombiServiceHandler combiServiceHandler, CombiServiceHandler$1 combiServiceHandler$1) {
        this(combiServiceHandler);
    }
}

