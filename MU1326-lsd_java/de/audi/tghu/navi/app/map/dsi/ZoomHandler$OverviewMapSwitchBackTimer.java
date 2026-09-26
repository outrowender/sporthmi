/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.map.dsi.ZoomHandler;
import de.audi.tghu.navi.app.util.Util;

final class ZoomHandler$OverviewMapSwitchBackTimer
implements TimerListener {
    private final Timer mTimer;
    private boolean mActive;
    private final /* synthetic */ ZoomHandler this$0;

    ZoomHandler$OverviewMapSwitchBackTimer(ZoomHandler zoomHandler) {
        this.this$0 = zoomHandler;
        int n = Util.isHURegionAsia() ? 10000 : 20000;
        this.mTimer = new Timer("OverviewMapSwitchBackTimer", n, true, this);
        this.mActive = false;
    }

    private void restart() {
        this.mTimer.restart();
        this.mActive = true;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.getLogChannel().log(1078071040, "ZoomHandler#OverviewMapSwitchBackTimer#fireTimer() - activeContextID: %2 (%1)", (Object)this.this$0.naviMap.getActiveContext(), (long)this.this$0.naviMap.getActiveContextIndex());
        this.mActive = false;
        if (this.this$0.naviMap.getSetup().getMapType(true) == 3 && ZoomHandler.access$300(this.this$0).getRouteActiveOrRangeMapReady() && this.this$0.isAllowedToSwitchToOverviewMap(this.this$0.naviMap.getActiveContext())) {
            this.this$0.naviMap.switchToContext(10);
        }
    }

    private void cancel() {
        this.mTimer.cancel();
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.mActive = false;
    }

    static /* synthetic */ void access$000(ZoomHandler$OverviewMapSwitchBackTimer zoomHandler$OverviewMapSwitchBackTimer) {
        zoomHandler$OverviewMapSwitchBackTimer.cancel();
    }

    static /* synthetic */ boolean access$100(ZoomHandler$OverviewMapSwitchBackTimer zoomHandler$OverviewMapSwitchBackTimer) {
        return zoomHandler$OverviewMapSwitchBackTimer.mActive;
    }

    static /* synthetic */ void access$200(ZoomHandler$OverviewMapSwitchBackTimer zoomHandler$OverviewMapSwitchBackTimer) {
        zoomHandler$OverviewMapSwitchBackTimer.restart();
    }
}

