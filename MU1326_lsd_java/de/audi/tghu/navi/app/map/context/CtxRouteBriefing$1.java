/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.context.CtxRouteBriefing;

class CtxRouteBriefing$1
extends DefaultTimerListener {
    private final /* synthetic */ CtxRouteBriefing this$0;

    CtxRouteBriefing$1(CtxRouteBriefing ctxRouteBriefing) {
        this.this$0 = ctxRouteBriefing;
    }

    @Override
    public void fireTimer(Timer timer) {
        CtxRouteBriefing.access$000(this.this$0).log(1078071040, "CtxRouteBriefing#screenSwitchDelayer#fireTimer() - start RG and switch to shown context");
        CtxRouteBriefing.access$100(this.this$0).switchToAShownContext();
    }
}

