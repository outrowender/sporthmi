/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.picnav.INaviPicNavService;
import de.audi.atip.interapp.picnav.IPicNavNaviService;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NaviMapConnector;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PicNavNaviInterfaceImpl;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.rp.Routeplan;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class PicNavInterfaceHandler {
    private final IPicNavNaviService picNavNaviService;
    private INaviPicNavService naviPicNavService;

    public PicNavInterfaceHandler(NavigationEnv navigationEnv, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ICommandListFactory iCommandListFactory, Routeplan routeplan, MapInterface mapInterface, IVehicle iVehicle, NaviMapConnector naviMapConnector, IRouteManager iRouteManager, NaviADBHandler naviADBHandler, NaviFavoriteHandler naviFavoriteHandler) {
        this.picNavNaviService = new PicNavNaviInterfaceImpl(navigationEnv, this, iStartGuidanceToDestinationSequence, iCommandListFactory, routeplan, mapInterface, iVehicle, naviMapConnector, iRouteManager, naviADBHandler, naviFavoriteHandler);
        this.naviPicNavService = null;
    }

    public IPicNavNaviService getPicNavNaviService() {
        return this.picNavNaviService;
    }

    public void setNaviPicNavService(INaviPicNavService iNaviPicNavService) {
        this.naviPicNavService = iNaviPicNavService;
    }

    public INaviPicNavService getNaviPicNavService() {
        return this.naviPicNavService;
    }

    public void resetToFactorySettings() {
        if (this.naviPicNavService != null) {
            this.naviPicNavService.resetToFactorySettings();
        }
    }

    public void showPicNavMapDestination(NavLocation navLocation, ResourceLocator resourceLocator) {
        if (this.naviPicNavService != null) {
            this.naviPicNavService.showPicNavMapDestination(navLocation, resourceLocator);
        }
    }

    public void resolvedLocationResult(NavLocation navLocation) {
        if (this.naviPicNavService != null) {
            this.naviPicNavService.resolvedLocationResult(navLocation);
        }
    }

    public void mapUnfrozen() {
        if (this.naviPicNavService != null) {
            this.naviPicNavService.mapUnfrozen();
        }
    }
}

