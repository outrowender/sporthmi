/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.context.CtxRCCIMap;

class CtxRCCIMap$1
extends DefaultTimerListener {
    private final /* synthetic */ CtxRCCIMap this$0;

    CtxRCCIMap$1(CtxRCCIMap ctxRCCIMap) {
        this.this$0 = ctxRCCIMap;
    }

    @Override
    public void fireTimer(Timer timer) {
        CtxRCCIMap.access$000(this.this$0).log(1078071040, "CtxRCCIMap#screenSwitchDelayer#fireTimer() - switch to shown context");
        CtxRCCIMap.access$100(this.this$0);
    }
}

