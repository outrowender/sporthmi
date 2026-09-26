/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband;
import de.audi.tghu.navi.app.util.Util;

class RcsCalculatingRubberband$1
extends DefaultTimerListener {
    private final /* synthetic */ RcsCalculatingRubberband this$0;

    RcsCalculatingRubberband$1(RcsCalculatingRubberband rcsCalculatingRubberband) {
        this.this$0 = rcsCalculatingRubberband;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.getLogger().log(-2137614336, "RcsCalculatingRubberband#updateRgCalculatedRoutesTimeoutTimer#fireTimer()");
        if (!Util.isHURegionAsia()) {
            this.this$0.getStateMachine().naviMap.onEvent(209);
        } else {
            this.this$0.getLogger().log(-2137614336, "RcsCalculatingRubberband#updateRgCalculatedRoutesTimeoutTimer#fireTimer() -- ignoring");
        }
    }
}

