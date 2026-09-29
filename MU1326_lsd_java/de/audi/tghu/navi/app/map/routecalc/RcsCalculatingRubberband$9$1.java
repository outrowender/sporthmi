/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.command.via.RgGetLocationOnRouteCommand;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$9;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

class RcsCalculatingRubberband$9$1
extends RgGetLocationOnRouteCommand {
    private final /* synthetic */ RcsCalculatingRubberband$9 this$1;

    RcsCalculatingRubberband$9$1(RcsCalculatingRubberband$9 rcsCalculatingRubberband$9, long l) {
        this.this$1 = rcsCalculatingRubberband$9;
        super(l);
    }

    @Override
    public void execute() {
        long l = RcsCalculatingRubberband$9.access$300((RcsCalculatingRubberband$9)this.this$1).manipulatedRoute != null ? RcsCalculatingRubberband$9.access$300((RcsCalculatingRubberband$9)this.this$1).manipulatedRoute.distance >> 1 : 0L;
        RcsCalculatingRubberband$9.access$300(this.this$1).getLogger().log(-2137614336, "RcsCalculatingRubberband#refreshRubberbandPoint() - calling rgGetLocationOnRoute( %1 ) ", l);
        this.getDSINavigation().rgGetLocationOnRoute(l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation) {
        RcsCalculatingRubberband$9.access$300(this.this$1).getLogger().log(-2137614336, "RcsCalculatingRubberband#refreshRubberbandPoint() - rgGetLocationOnRouteResult( %1 )", (Object)navLocation);
        Object object = RcsCalculatingRubberband.access$100(RcsCalculatingRubberband$9.access$300(this.this$1));
        synchronized (object) {
            RcsCalculatingRubberband$9.access$300((RcsCalculatingRubberband$9)this.this$1).getData().rbbPoint = new NavLocationWgs84(navLocation.longitude, navLocation.latitude);
            RcsCalculatingRubberband.access$200(RcsCalculatingRubberband$9.access$300(this.this$1)).cancel();
            RcsCalculatingRubberband$9.access$300((RcsCalculatingRubberband$9)this.this$1).getStateMachine().naviMap.onEvent(208);
        }
        this.getCommandList().commandFinished();
    }
}

