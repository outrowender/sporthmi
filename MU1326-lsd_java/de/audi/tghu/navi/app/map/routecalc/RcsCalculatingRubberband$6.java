/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.command.via.RgGetLocationOnRouteCommand;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

class RcsCalculatingRubberband$6
extends RgGetLocationOnRouteCommand {
    private final /* synthetic */ RcsCalculatingRubberband this$0;

    RcsCalculatingRubberband$6(RcsCalculatingRubberband rcsCalculatingRubberband, long l) {
        this.this$0 = rcsCalculatingRubberband;
        super(l);
    }

    @Override
    public void execute() {
        long l = this.this$0.manipulatedRoute != null ? this.this$0.manipulatedRoute.distance >> 1 : 0L;
        this.this$0.getLogger().log(-2137614336, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart() - calling rgGetLocationOnRoute( %1 ) ", l);
        this.logger.log(-2137614336, "RgGetLocationOnRouteCommand#execute() - calling rgGetLocationOnRoute( %1 ) ", l);
        this.getDSINavigation().rgGetLocationOnRoute(l);
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation) {
        this.this$0.getLogger().log(-2137614336, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart() - rgGetLocationOnRouteResult( %1 )", (Object)navLocation);
        this.this$0.getData().rbbPoint = new NavLocationWgs84(navLocation.longitude, navLocation.latitude);
        this.this$0.getStateMachine().naviMap.onEvent(205);
        this.getCommandList().commandFinished();
    }
}

