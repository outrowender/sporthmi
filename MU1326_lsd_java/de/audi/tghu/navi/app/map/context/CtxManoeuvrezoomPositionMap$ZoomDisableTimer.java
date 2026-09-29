/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.map.context.CtxManoeuvrezoomPositionMap;

final class CtxManoeuvrezoomPositionMap$ZoomDisableTimer
implements TimerListener {
    private final Timer mTimer = new Timer("ZoomDisableTimer", 0, true, this);
    private final /* synthetic */ CtxManoeuvrezoomPositionMap this$0;

    CtxManoeuvrezoomPositionMap$ZoomDisableTimer(CtxManoeuvrezoomPositionMap ctxManoeuvrezoomPositionMap) {
        this.this$0 = ctxManoeuvrezoomPositionMap;
    }

    private void restart() {
        CtxManoeuvrezoomPositionMap.access$000(this.this$0).log(1078071040, "CtxManoeuvrezoomPositionMap#ZoomDisableTimer#restart(): timer restarted");
        this.this$0.setAutozoomTemporarilyDisabled(true);
        this.mTimer.restart();
    }

    private void cancel() {
        CtxManoeuvrezoomPositionMap.access$100(this.this$0).log(1078071040, "CtxManoeuvrezoomPositionMap#ZoomDisableTimer#cancel(): timer cancelled");
        this.this$0.setAutozoomTemporarilyDisabled(false);
        this.this$0.container.sZoomTimerActivateMZ = false;
        this.this$0.container.sZoomTimerDeactivateMZ = false;
        this.mTimer.cancel();
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.setAutozoomTemporarilyDisabled(false);
        if (this.this$0.container.sZoomTimerActivateMZ) {
            CtxManoeuvrezoomPositionMap.access$200(this.this$0).log(-2137614336, "CtxManoeuvrezoomPositionMap#ZoomDisableTimer#fireTimer(): activating maneuver zoom");
            this.this$0.container.sZoomTimerActivateMZ = false;
            this.this$0.activateManoeuvreZoom();
        } else if (this.this$0.container.sZoomTimerDeactivateMZ) {
            CtxManoeuvrezoomPositionMap.access$300(this.this$0).log(-2137614336, "CtxManoeuvrezoomPositionMap#ZoomDisableTimer#fireTimer(): deactivating maneuver zoom");
            this.this$0.container.sZoomTimerDeactivateMZ = false;
            this.this$0.restoreState();
            this.this$0.switchBackToPreviousMapIfNecessary();
        } else {
            CtxManoeuvrezoomPositionMap.access$400(this.this$0).log(-2137614336, "CtxManoeuvrezoomPositionMap#ZoomDisableTimer#fireTimer(): setting pending zoom level");
            if (this.this$0.setPendingZoomLevel()) {
                this.this$0.setAutoZoomIcon(true);
                this.this$0.setSoftZoom(true);
            }
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    static /* synthetic */ void access$500(CtxManoeuvrezoomPositionMap$ZoomDisableTimer ctxManoeuvrezoomPositionMap$ZoomDisableTimer) {
        ctxManoeuvrezoomPositionMap$ZoomDisableTimer.cancel();
    }

    static /* synthetic */ void access$600(CtxManoeuvrezoomPositionMap$ZoomDisableTimer ctxManoeuvrezoomPositionMap$ZoomDisableTimer) {
        ctxManoeuvrezoomPositionMap$ZoomDisableTimer.restart();
    }
}

