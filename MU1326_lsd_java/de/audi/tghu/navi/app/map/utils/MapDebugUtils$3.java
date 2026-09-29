/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

final class MapDebugUtils$3
implements Runnable {
    private final /* synthetic */ IRouteInfo val$routeInfoHandler;
    private final /* synthetic */ NavRouteListData val$nrld;
    private final /* synthetic */ TurnListElement val$mtwIC;
    private final /* synthetic */ TurnListElement val$mtwSAPA;
    private final /* synthetic */ TurnListElement val$mtwJCT;
    private final /* synthetic */ TmcMessage val$tmcTEC;

    MapDebugUtils$3(IRouteInfo iRouteInfo, NavRouteListData navRouteListData, TurnListElement turnListElement, TurnListElement turnListElement2, TurnListElement turnListElement3, TmcMessage tmcMessage) {
        this.val$routeInfoHandler = iRouteInfo;
        this.val$nrld = navRouteListData;
        this.val$mtwIC = turnListElement;
        this.val$mtwSAPA = turnListElement2;
        this.val$mtwJCT = turnListElement3;
        this.val$tmcTEC = tmcMessage;
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
        this.val$mtwIC.distance = 0;
        this.val$mtwIC.eta = 0;
        this.val$mtwSAPA.distance = 0;
        this.val$mtwSAPA.eta = 0;
        this.val$mtwJCT.distance = 0;
        this.val$mtwJCT.eta = 0;
        this.val$routeInfoHandler.updateTmcMessagesAhead(new TmcMessage[]{this.val$tmcTEC});
        this.val$routeInfoHandler.updateRgTurnList(new TurnListElement[]{this.val$mtwIC, this.val$mtwSAPA});
        this.val$routeInfoHandler.forceRouteInfo(true);
    }
}

