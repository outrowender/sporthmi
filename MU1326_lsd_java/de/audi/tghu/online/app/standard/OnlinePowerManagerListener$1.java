/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.online.app.standard.OnlinePowerManagerListener;

class OnlinePowerManagerListener$1
implements TimerListener {
    private final /* synthetic */ OnlinePowerManagerListener this$0;

    OnlinePowerManagerListener$1(OnlinePowerManagerListener onlinePowerManagerListener) {
        this.this$0 = onlinePowerManagerListener;
    }

    @Override
    public void fireTimer(Timer timer) {
        OnlinePowerManagerListener.access$000(this.this$0);
    }

    @Override
    public void cancelTimer(Timer timer) {
        OnlinePowerManagerListener.access$000(this.this$0);
    }
}

