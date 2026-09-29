/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

final class MapDebugUtils$4
implements Runnable {
    private final /* synthetic */ IRouteInfo val$routeInfoHandler;
    private final /* synthetic */ NavRouteListData val$nrld;
    private final /* synthetic */ TurnListElement val$turn1;
    private final /* synthetic */ TurnListElement val$turn2;
    private final /* synthetic */ TurnListElement val$turn3;

    MapDebugUtils$4(IRouteInfo iRouteInfo, NavRouteListData navRouteListData, TurnListElement turnListElement, TurnListElement turnListElement2, TurnListElement turnListElement3) {
        this.val$routeInfoHandler = iRouteInfo;
        this.val$nrld = navRouteListData;
        this.val$turn1 = turnListElement;
        this.val$turn2 = turnListElement2;
        this.val$turn3 = turnListElement3;
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
        this.val$turn1.distance = 0;
        this.val$turn1.eta = 0;
        this.val$turn2.distance = 0;
        this.val$turn2.eta = 0;
        this.val$turn3.distance = 0;
        this.val$turn3.eta = 0;
        this.val$routeInfoHandler.updateRgTurnList(new TurnListElement[]{this.val$turn1, this.val$turn2, this.val$turn3});
        this.val$routeInfoHandler.forceRouteInfo(true);
    }
}

