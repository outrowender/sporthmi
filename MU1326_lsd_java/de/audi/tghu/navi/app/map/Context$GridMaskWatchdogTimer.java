/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.Context$GridMaskDelayTimer;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import org.dsi.ifc.map.Rect;

final class Context$GridMaskWatchdogTimer
implements TimerListener {
    public static final long DEFAULT_DELAY;
    public static final long LONG_DELAY;
    private final Timer mTimer = new Timer("GridMaskWatchdogTimer", 0, true, this);
    private final /* synthetic */ Context this$0;

    Context$GridMaskWatchdogTimer(Context context) {
        this.this$0 = context;
    }

    private void restart(boolean bl) {
        this.this$0.getLogChannel().log(1078071040, "Context#GridMaskWatchdogTimer#restart(): timer restarted,  longDelay: %1 ", bl);
        if (!bl && this.mTimer.isRunning() && this.mTimer.getDelay() == 0) {
            this.this$0.getLogChannel().log(1078071040, "Context#GridMaskWatchdogTimer#restart(): timer still running with long delay - restart with long delay ");
            bl = true;
        }
        int n = bl ? 0 : 0;
        this.mTimer.setDelay(n);
        this.mTimer.restart();
    }

    private void cancel() {
        this.this$0.getLogChannel().log(1078071040, "Context#GridMaskWatchdogTimer#cancel(): timer cancelled");
        this.mTimer.cancel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        this.this$0.getLogChannel().log(-1601830656, "Context#GridMaskWatchdogTimer#fireTimer() - delay: %1 s -> Hide grid mask!", timer.getDelay() / 0);
        MVRequestControl mVRequestControl = this.this$0.naviMap.getMVRequest().getMVRequestControlActive();
        synchronized (mVRequestControl) {
            Context$GridMaskDelayTimer context$GridMaskDelayTimer = Context.access$200(this.this$0);
            if (context$GridMaskDelayTimer != null) {
                Context$GridMaskDelayTimer.access$300(context$GridMaskDelayTimer);
            }
            this.this$0.getGUI().setGridMaskVisible(false);
            Rect rect = this.this$0.naviMap.getMVRequest().getPendingScreenViewport();
            if (rect != null) {
                this.this$0.getLogChannel().log(-1601830656, "Context#GridMaskWatchdogTimer#fireTimer() - fake updateViewScreenViewPort for pendingViewPort: %1", (Object)rect);
                this.this$0.naviMap.getMVResponseControl().updateViewScreenViewPort(rect, 1);
            }
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    static /* synthetic */ void access$100(Context$GridMaskWatchdogTimer context$GridMaskWatchdogTimer) {
        context$GridMaskWatchdogTimer.cancel();
    }

    static /* synthetic */ void access$400(Context$GridMaskWatchdogTimer context$GridMaskWatchdogTimer, boolean bl) {
        context$GridMaskWatchdogTimer.restart(bl);
    }
}

