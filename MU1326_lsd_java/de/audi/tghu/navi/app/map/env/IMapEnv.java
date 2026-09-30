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
    public IEventBroker getEventBroker();

    public IRouteCalculator getRouteCalcHandler();

    public IRouteInfoHelper getRouteInfoHelper();

    public IRouteInfo getRouteInfoHandler();

    public INaviInterface getNaviInterface();

    public IRouteInfoContextHandler getRouteInfoContextHandler();

    public MapInterface getMapSv();

    public GoogleMapLicenseHandler getGoogleMapLicenseHandler();

    public WeatherLicenseHandler getWeatherLicenseHandler();

    public ISDSController getSdsController();

    public IDrawerStateHandler getDrawerStateHandler();

    public MapTmcService getTmcMapHandler();

    public IMobilityHorizonHandler getMobilityHorizonHandler();

    public MapEventDispatcher getMapEventDispatcher();

    public CruiseModeHandler getCruiseModelHandler();

    public TENMIndication getTenmIndication();

    public MapOptionValidator getMapOptionValidator();
}

