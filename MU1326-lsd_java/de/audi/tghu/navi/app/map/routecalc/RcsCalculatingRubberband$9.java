/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.command.via.RgGetRubberBandPointPositionCmd;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$9$1;
import org.dsi.ifc.global.NavLocationWgs84;

class RcsCalculatingRubberband$9
extends RgGetRubberBandPointPositionCmd {
    private final /* synthetic */ RcsCalculatingRubberband this$0;

    RcsCalculatingRubberband$9(RcsCalculatingRubberband rcsCalculatingRubberband) {
        this.this$0 = rcsCalculatingRubberband;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl) {
        if (!this.this$0.getStateMachine().isCalculatingRubberband()) {
            this.this$0.getLogger().log(-1601830656, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
            this.getCommandList().commandFinished();
            return;
        }
        this.this$0.getLogger().log(-2137614336, "RcsCalculatingRubberband#refreshRubberbandPoint() - available:%1, position:%2", bl, (Object)navLocationWgs84);
        if (bl) {
            Object object = RcsCalculatingRubberband.access$100(this.this$0);
            synchronized (object) {
                this.this$0.getData().rbbPoint = bl ? navLocationWgs84 : null;
                RcsCalculatingRubberband.access$200(this.this$0).cancel();
                this.this$0.getStateMachine().naviMap.onEvent(208);
            }
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new RcsCalculatingRubberband$9$1(this, 0L));
        }
    }

    static /* synthetic */ RcsCalculatingRubberband access$300(RcsCalculatingRubberband$9 rcsCalculatingRubberband$9) {
        return rcsCalculatingRubberband$9.this$0;
    }
}

