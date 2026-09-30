/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.remotehmi.ui.mib2.grid.GeoPosition;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridAction;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IReferencePoint;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.ArrayList;

public class RrdCalculationHandler {
    private boolean immediateDistanceUpdate;
    public static final int INCREMENT_FOR_RRD = 8;
    protected RemoteHMIService remoteHmiService;
    protected LogChannel logChannel;
    protected boolean isRrdCalculationEnabled = false;

    public RrdCalculationHandler(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logChannel = logChannel;
        this.remoteHmiService = remoteHMIService;
    }

    public void triggerRrdCalculation(final IGridList iGridList) {
        Integer n;
        Integer n2;
        GeoPosition geoPosition;
        final ArrayList arrayList = new ArrayList();
        IReferencePoint iReferencePoint = iGridList.getReferencePoint();
        GeoPosition geoPosition2 = geoPosition = iReferencePoint != null ? iReferencePoint.getGeoLocation() : null;
        if (geoPosition == null) {
            n2 = null;
            n = null;
        } else {
            n2 = Util.createInteger(NavigationUtilities.degreeToWgs84(geoPosition.getLatitude()));
            n = Util.createInteger(NavigationUtilities.degreeToWgs84(geoPosition.getLongitude()));
        }
        final Integer n3 = Util.createInteger(iGridList.getIdRangeStart());
        this.logChannel.log(1000000, "RrdCalculationHandler#triggerRrdCalculation: reference point (%1;%2) set for list start=%3", (Object)n2, (Object)n, (Object)n3);
        IGridAction iGridAction = new IGridAction(){

            public boolean modify(IGrid iGrid) {
                GeoPosition geoPosition2 = iGrid.getGeoPosition();
                if (geoPosition2 == null) {
                    return false;
                }
                if (!iGrid.hasRRDItems()) {
                    return false;
                }
                NaviOnlineService.RrdData rrdData = new NaviOnlineService.RrdData();
                rrdData.setIdRangeStart(iGridList.getIdRangeStart());
                arrayList.add(rrdData);
                rrdData.setModelAndContainer(iGridList, iGrid);
                String string = iGrid.getId();
                rrdData.setId(string);
                Integer n4 = Util.createInteger(NavigationUtilities.degreeToWgs84(geoPosition2.getLatitude()));
                Integer n22 = Util.createInteger(NavigationUtilities.degreeToWgs84(geoPosition2.getLongitude()));
                rrdData.setLatitude(n4);
                rrdData.setLongitude(n22);
                RrdCalculationHandler.this.logChannel.log(10000000, "RrdCalculationHandler#triggerRrdCalculation: point (%1;%2) set for gridId='%3', list start=%4", (Object)n4, (Object)n22, (Object)string, (Object)n3);
                if (geoPosition != null) {
                    rrdData.setRrdReferenceLatitude(n2);
                    rrdData.setRrdReferenceLongitude(n);
                }
                return true;
            }
        };
        iGridList.forEachGrid(iGridAction, Integer.MAX_VALUE);
        if (arrayList.isEmpty()) {
            return;
        }
        NaviOnlineService naviOnlineService = this.remoteHmiService.getNaviComponent().getNaviOnlineService();
        if (naviOnlineService == null || !naviOnlineService.getIsNaviFullyOperable()) {
            String string = naviOnlineService != null ? Boolean.toString(naviOnlineService.getIsNaviFullyOperable()) : "null";
            this.logChannel.log(100000, "RrdCalculationHandler#triggerRrdCalculation: navi not available or not fully operable (%1), cannot trigger RRD calculation", (Object)string);
            return;
        }
        this.logChannel.log(1000000, "RrdCalculationHandler#triggerRrdCalculation: RRD calculation enabled = %1, referencePoint=%2", this.isRrdCalculationEnabled, (Object)geoPosition);
        if (this.isRrdCalculationEnabled && geoPosition == null) {
            this.logChannel.log(1000000, "RrdCalculationHandler#triggerRrdCalculation: triggering RRD distance calculation");
            naviOnlineService.triggerRRDRequest(arrayList);
        } else {
            this.logChannel.log(1000000, "RrdCalculationHandler#triggerRrdCalculation: triggering air distance calculation");
            naviOnlineService.triggerADRequest(arrayList);
        }
    }

    public void exitRrd() {
        NaviOnlineService naviOnlineService = this.remoteHmiService.getNaviComponent().getNaviOnlineService();
        if (naviOnlineService != null) {
            this.logChannel.log(1000000, "RrdCalculationHandler#exitRRD(): stopping Rrd calculation");
            naviOnlineService.exitRRD();
            naviOnlineService.exitAD();
        } else {
            this.logChannel.log(100000, "RrdCalculationHandler#exitRrd() rrd calculation not stopped because navi was null");
        }
    }

    public void setRrdCalculationEnabled(boolean bl) {
        this.isRrdCalculationEnabled = bl;
    }

    public void updateGrid(IGridList iGridList, IGrid iGrid, IGrid iGrid2) {
        NaviOnlineService naviOnlineService = this.remoteHmiService.getNaviComponent().getNaviOnlineService();
        if (naviOnlineService != null && naviOnlineService.getIsNaviFullyOperable()) {
            GeoPosition geoPosition = iGrid2.getGeoPosition();
            int n = NavigationUtilities.degreeToWgs84(geoPosition.getLatitude());
            int n2 = NavigationUtilities.degreeToWgs84(geoPosition.getLongitude());
            naviOnlineService.swapModel(iGridList, iGrid, iGrid2, n, n2);
        }
    }

    public boolean isImmediateDistanceUpdate() {
        return this.immediateDistanceUpdate;
    }

    public void setImmediateDistanceUpdate(boolean bl) {
        this.immediateDistanceUpdate = bl;
    }
}

