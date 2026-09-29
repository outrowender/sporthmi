/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.Context$GridMaskWatchdogTimer;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;

final class Context$GridMaskDelayTimer
implements TimerListener {
    private final Timer mTimer = new Timer("GridMaskDelayTimer", 0, true, this);
    private final /* synthetic */ Context this$0;

    Context$GridMaskDelayTimer(Context context) {
        this.this$0 = context;
    }

    private void restart() {
        this.this$0.getLogChannel().log(1078071040, "Context#GridMaskDelayTimer#restart(): timer restarted");
        this.mTimer.restart();
    }

    private void cancel() {
        this.this$0.getLogChannel().log(1078071040, "Context#GridMaskDelayTimer#cancel(): timer cancelled");
        this.mTimer.cancel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        this.this$0.getLogChannel().log(1078071040, "Context#GridMaskDelayTimer#fireTimer(): timer fired");
        MVRequestControl mVRequestControl = this.this$0.naviMap.getMVRequest().getMVRequestControlActive();
        synchronized (mVRequestControl) {
            Context$GridMaskWatchdogTimer context$GridMaskWatchdogTimer = Context.access$000(this.this$0);
            if (context$GridMaskWatchdogTimer != null) {
                Context$GridMaskWatchdogTimer.access$100(context$GridMaskWatchdogTimer);
            }
            this.this$0.getGUI().setGridMaskVisible(false);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    static /* synthetic */ void access$300(Context$GridMaskDelayTimer context$GridMaskDelayTimer) {
        context$GridMaskDelayTimer.cancel();
    }

    static /* synthetic */ void access$500(Context$GridMaskDelayTimer context$GridMaskDelayTimer) {
        context$GridMaskDelayTimer.restart();
    }
}

