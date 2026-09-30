/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceStateModelAccess;
import org.dsi.ifc.global.NavSegmentID;

public class RGStartGuidanceCalculatedRouteByUID
extends NavCommand {
    private final NavSegmentID routeSegmentId;
    private final boolean isPredictiveRoute;
    private final IRouteGuidanceStateModelAccess routeGuidanceStateModelAccess;

    public RGStartGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID, boolean bl, IRouteGuidanceStateModelAccess iRouteGuidanceStateModelAccess) {
        this.routeSegmentId = navSegmentID;
        this.isPredictiveRoute = bl;
        this.routeGuidanceStateModelAccess = iRouteGuidanceStateModelAccess;
    }

    public void execute() {
        boolean bl = this.dsiResponseContainer.isRgActive();
        this.logger.log(10000000, "RGStartGuidanceCalculatedRouteByUID#execute() - calling rgStartGuidanceCalculatedRouteByUID( %1, %2 ) ", (Object)this.routeSegmentId, (Object)this.isPredictiveRoute);
        this.getDSINavigation().rgStartGuidanceCalculatedRouteByUID(this.routeSegmentId);
        if (bl) {
            this.getCommandList().commandFinished();
        }
    }

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        if (n == 0) {
            this.logger.log(10000000, "RGStartGuidanceCalculatedRouteByUID#rgStartGuidanceCalculatedRouteByUIDResult()");
            this.routeGuidanceStateModelAccess.setPredictiveRgRunning(this.isPredictiveRoute);
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "RGStartGuidanceCalculatedRouteByUID#rgStartGuidanceCalculatedRouteByUIDResult() - got error code %1 !", (long)n);
            this.routeGuidanceStateModelAccess.setPredictiveRgRunning(false);
            this.getCommandList().commandAborted(n);
        }
    }

    public void rgStartGuidanceCalculatedRouteResult(int n) {
    }
}

