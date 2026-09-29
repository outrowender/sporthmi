/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.tm.TVEngineering;
import de.audi.tv.app.tm.TVEngineering$1;

class TVEngineering$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ TVEngineering this$0;

    private TVEngineering$TimerListener(TVEngineering tVEngineering) {
        this.this$0 = tVEngineering;
    }

    @Override
    public void fireTimer(Timer timer) {
        TVEngineering.access$200(this.this$0);
    }

    /* synthetic */ TVEngineering$TimerListener(TVEngineering tVEngineering, TVEngineering$1 tVEngineering$1) {
        this(tVEngineering);
    }
}

