/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.maptmc.MapTmcMessage;
import de.audi.atip.interapp.maptmc.MapTmcService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class TmcMapHandler
implements MapTmcService {
    private LogChannel logger;
    private AbstractMap naviMap;
    private NavigationEnv env;

    public TmcMapHandler(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        this.naviMap = abstractMap;
        this.logger = navigationEnv.getLogChannel("App.Map.Main");
        this.env = navigationEnv;
    }

    @Override
    public void mapEntered() {
        this.logger.log(-2137614336, "TmcMapHandler#mapEntered()");
        this.naviMap.show(6);
    }

    @Override
    public void mapLeft() {
        this.logger.log(-2137614336, "TmcMapHandler#mapLeft()");
    }

    @Override
    public void showTmcMessage(MapTmcMessage mapTmcMessage) {
        this.logger.log(-1601830656, "MapInterface#showTmcMessage() - unexpected call");
    }

    @Override
    public void enableAutomaticRouteDiversion(boolean bl) {
        this.logger.log(-2137614336, "TmcMapHandler#enableAutomaticRouteDiversion( %1 )", bl);
    }

    @Override
    public void showInMap(long[] lArray, NavRectangle navRectangle, TmcListElement tmcListElement) {
        this.logger.log(-2137614336, "TmcMapHandler#showTmcMessage() - Ids = {%1}, NavRec = %2", (Object)MapUtils.toString(lArray), (Object)navRectangle);
        this.logger.log(-2137614336, "TmcMapHandler#showTmcMessage() - TmcMessage = %1", (Object)tmcListElement);
        this.naviMap.getMapDataContainer().sTmcMessageIds = lArray;
        this.naviMap.getMapDataContainer().sTmcNavRectangle = navRectangle;
        this.naviMap.getMapDataContainer().sTmcListElement = tmcListElement;
        this.naviMap.getMapDataContainer().tmcMessageToBeShown = null;
        this.naviMap.switchToContext(3);
        this.naviMap.switchToContext(18);
    }

    @Override
    public void showInMap(TmcMessage tmcMessage, NavRectangle navRectangle) {
        this.logger.log(-2137614336, "TmcMapHandler#showTmcMessage() - tmcMessage: %1", (Object)tmcMessage);
        if (tmcMessage == null) {
            this.logger.log(10000, "TmcMapHandler#showTmcMessage() - tmcMessage is null");
            return;
        }
        this.naviMap.getMapDataContainer().sTmcMessageIds = new long[]{tmcMessage.getMessageID()};
        this.naviMap.getMapDataContainer().sTmcNavRectangle = navRectangle;
        this.naviMap.getMapDataContainer().sTmcListElement = null;
        this.naviMap.getMapDataContainer().tmcMessageToBeShown = tmcMessage;
        this.naviMap.switchToContext(3);
        this.naviMap.switchToContext(18);
    }

    @Override
    public void updateMapTooltipInformation(TmcMessage tmcMessage) {
        this.logger.log(-2137614336, "TmcMapHandler#updateMapTooltipInformation() - tmcMessage: %1", (Object)tmcMessage);
        if (tmcMessage == null) {
            this.logger.log(10000, "TmcMapHandler#updateMapTooltipInformation() - tmcMessage is null");
            return;
        }
        this.naviMap.getGuiInterface().checkToShowToolTipForTmc(tmcMessage);
    }

    @Override
    public boolean isInMapApplicationContext() {
        return this.naviMap.getMapDataContainer().activeNaviOrMapContext == 1;
    }

    @Override
    public boolean isTabMapNavActive() {
        return this.naviMap.getMapDataContainer().currentNavTab == 0;
    }

    @Override
    public boolean isTabRouteActive() {
        return this.naviMap.getMapDataContainer().currentNavTab == 2;
    }
}

