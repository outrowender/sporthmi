/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.env;

import de.audi.atip.interapp.maptmc.MapTmcService;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.TENMIndication;
import de.audi.tghu.navi.app.map.event.IEventBroker;
import de.audi.tghu.navi.app.map.event.MapEventDispatcher;
import de.audi.tghu.navi.app.map.handler.CruiseModeHandler;
import de.audi.tghu.navi.app.map.handler.GoogleMapLicenseHandler;
import de.audi.tghu.navi.app.map.handler.IDrawerStateHandler;
import de.audi.tghu.navi.app.map.handler.IMobilityHorizonHandler;
import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import de.audi.tghu.navi.app.map.handler.IRouteInfoContextHandler;
import de.audi.tghu.navi.app.map.handler.WeatherLicenseHandler;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import de.audi.tghu.navi.app.map.routeinfo.IRouteInfoHelper;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;
import de.audi.tghu.navi.app.sds.ISDSController;

public interface IMapEnv {
    default public IEventBroker getEventBroker() {
    }

    default public IRouteCalculator getRouteCalcHandler() {
    }

    default public IRouteInfoHelper getRouteInfoHelper() {
    }

    default public IRouteInfo getRouteInfoHandler() {
    }

    default public INaviInterface getNaviInterface() {
    }

    default public IRouteInfoContextHandler getRouteInfoContextHandler() {
    }

    default public MapInterface getMapSv() {
    }

    default public GoogleMapLicenseHandler getGoogleMapLicenseHandler() {
    }

    default public WeatherLicenseHandler getWeatherLicenseHandler() {
    }

    default public ISDSController getSdsController() {
    }

    default public IDrawerStateHandler getDrawerStateHandler() {
    }

    default public MapTmcService getTmcMapHandler() {
    }

    default public IMobilityHorizonHandler getMobilityHorizonHandler() {
    }

    default public MapEventDispatcher getMapEventDispatcher() {
    }

    default public CruiseModeHandler getCruiseModelHandler() {
    }

    default public TENMIndication getTenmIndication() {
    }

    default public MapOptionValidator getMapOptionValidator() {
    }
}

