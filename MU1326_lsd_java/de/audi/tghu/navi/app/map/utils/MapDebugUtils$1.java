/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import de.audi.tghu.navi.app.map.utils.MapDebugUtils;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.TurnListElement;

final class MapDebugUtils$1
implements Runnable {
    private final /* synthetic */ IRouteInfo val$routeInfoHandler;
    private final /* synthetic */ NavRouteListData val$nrld;
    private final /* synthetic */ TurnListElement val$etc3;
    private final /* synthetic */ TurnListElement val$etc2;
    private final /* synthetic */ TurnListElement val$etc1;

    MapDebugUtils$1(IRouteInfo iRouteInfo, NavRouteListData navRouteListData, TurnListElement turnListElement, TurnListElement turnListElement2, TurnListElement turnListElement3) {
        this.val$routeInfoHandler = iRouteInfo;
        this.val$nrld = navRouteListData;
        this.val$etc3 = turnListElement;
        this.val$etc2 = turnListElement2;
        this.val$etc1 = turnListElement3;
    }

    @Override
    public void run() {
        this.val$routeInfoHandler.updateRgTurnList(new TurnListElement[0]);
        this.val$routeInfoHandler.updateRgPoiInfo(new NavPoiInfo[0]);
        this.val$routeInfoHandler.updateRgDestinationInfo(new NavRouteListData[]{this.val$nrld});
        this.val$routeInfoHandler.setTravelParameters(true, true, 0, 0, 10000, 0, 0, 0, 10000, 0, 0);
        this.val$routeInfoHandler.forceRouteInfo(true);
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        Object[] objectArray = new TurnListElement[]{this.val$etc3, this.val$etc2, this.val$etc1};
        MapDebugUtils.adjustEtaAndDist(objectArray);
        this.val$routeInfoHandler.updateRgTurnList((TurnListElement[])objectArray);
        this.val$routeInfoHandler.forceRouteInfo(true);
    }
}

