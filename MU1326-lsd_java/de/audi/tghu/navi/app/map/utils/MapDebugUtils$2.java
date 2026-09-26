/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import de.audi.tghu.navi.app.map.utils.MapDebugUtils;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

final class MapDebugUtils$2
implements Runnable {
    private final /* synthetic */ IRouteInfo val$routeInfoHandler;
    private final /* synthetic */ NavRouteListData val$nrld;
    private final /* synthetic */ TurnListElement val$saigaro;
    private final /* synthetic */ TurnListElement val$ferry;
    private final /* synthetic */ TurnListElement val$mtwWithTurnArrow;

    MapDebugUtils$2(IRouteInfo iRouteInfo, NavRouteListData navRouteListData, TurnListElement turnListElement, TurnListElement turnListElement2, TurnListElement turnListElement3) {
        this.val$routeInfoHandler = iRouteInfo;
        this.val$nrld = navRouteListData;
        this.val$saigaro = turnListElement;
        this.val$ferry = turnListElement2;
        this.val$mtwWithTurnArrow = turnListElement3;
    }

    @Override
    public void run() {
        this.val$routeInfoHandler.updateRgTurnList(new TurnListElement[0]);
        this.val$routeInfoHandler.updateRgPoiInfo(new NavPoiInfo[0]);
        this.val$routeInfoHandler.updateTmcMessagesAhead(new TmcMessage[0]);
        this.val$routeInfoHandler.updateRgDestinationInfo(new NavRouteListData[]{this.val$nrld});
        this.val$routeInfoHandler.setTravelParameters(true, true, 0, 0, 10000, 0, 0, 0, 10000, 0, 0);
        this.val$routeInfoHandler.forceRouteInfo(true);
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        MapDebugUtils.adjustEtaAndDist(new Object[]{this.val$saigaro, this.val$ferry, this.val$mtwWithTurnArrow});
        this.val$routeInfoHandler.updateRgTurnList(new TurnListElement[]{this.val$saigaro, this.val$ferry, this.val$mtwWithTurnArrow});
        this.val$routeInfoHandler.forceRouteInfo(true);
    }
}

