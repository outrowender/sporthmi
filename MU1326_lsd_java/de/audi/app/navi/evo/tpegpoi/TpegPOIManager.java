/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.tpegpoi;

import de.audi.app.navi.evo.tpegpoi.listeners.TpegPOIAdditionalInfoScreenListener;
import de.audi.app.navi.evo.tpegpoi.listeners.TpegPOICategoryScreenListener;
import de.audi.app.navi.evo.tpegpoi.listeners.TpegPOIResultListScreenListener;
import de.audi.app.navi.evo.tpegpoi.listeners.TpegPOIRightDrawerListener;
import de.audi.app.navi.evo.tpegpoi.models.TpegPOICategoryScreenModelAccess;
import de.audi.app.navi.evo.tpegpoi.models.TpegPOIResultListScreenModelAccess;
import de.audi.app.navi.evo.tpegpoi.models.TpegPoiAdditionInfoScreenModelAccess;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.tpegpoi.AbstractTpegPOIManager;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOICategoryListSequence;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIDetailSequence;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIRightDrawerSequence;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;

public class TpegPOIManager
extends AbstractTpegPOIManager {
    private final MapInterface mapInterface;
    private final IStartGuidanceToDestinationSequence startGuidanceSequence;
    private final INaviFavoriteHandler naviFavoriteHandler;
    private final IPoiService poiService;
    private final IVehicle vehicle;
    private final IconHandler iconHandler;
    private final IRouteManager routeManager;
    private final NaviADBHandler navAdbHandler;
    private final ITelService telService;
    private final HomeAddressHandler homeAddressHandler;
    private final IDetailsScreen detailsHMIListener;
    private TpegPOICategoryScreenListener categoryScreenListener;
    private TpegPOIResultListScreenListener resultListScreenListener;
    private TpegPOIAdditionalInfoScreenListener additionalInfoScreenListener;
    private TpegPOIRightDrawerListener rightDrawerListener;

    public TpegPOIManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IPreviewMap iPreviewMap, MapInterface mapInterface, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, INaviFavoriteHandler iNaviFavoriteHandler, IPoiService iPoiService, IDetailsScreen iDetailsScreen, SpellerStack spellerStack, IVehicle iVehicle, IconHandler iconHandler, IRouteManager iRouteManager, NaviADBHandler naviADBHandler, ITelService iTelService, HomeAddressHandler homeAddressHandler) {
        super(navigationEnv, iCommandListFactory, spellerStack, iPreviewMap);
        this.mapInterface = mapInterface;
        this.startGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.naviFavoriteHandler = iNaviFavoriteHandler;
        this.poiService = iPoiService;
        this.detailsHMIListener = iDetailsScreen;
        this.vehicle = iVehicle;
        this.iconHandler = iconHandler;
        this.routeManager = iRouteManager;
        this.navAdbHandler = naviADBHandler;
        this.telService = iTelService;
        this.homeAddressHandler = homeAddressHandler;
        this.initListeners();
    }

    private void initListeners() {
        this.initCategoryScreenListener();
        this.initResultListScreenListener();
        this.initRightDrawerListener();
        this.initAdditionalInfoScreenListener();
    }

    private void initCategoryScreenListener() {
        int n = 402065;
        int n2 = 402067;
        TpegPOICategoryScreenModelAccess tpegPOICategoryScreenModelAccess = new TpegPOICategoryScreenModelAccess(this.env, n, n2);
        TpegPOICategoryListSequence tpegPOICategoryListSequence = new TpegPOICategoryListSequence(this.env, this.commandListFactory, tpegPOICategoryScreenModelAccess, this.spellerStack, this.vehicle);
        this.categoryScreenListener = new TpegPOICategoryScreenListener(this.env, this.previewMap, tpegPOICategoryListSequence, this, n);
    }

    private void initResultListScreenListener() {
        int n = 402068;
        TpegPOIResultListScreenModelAccess tpegPOIResultListScreenModelAccess = new TpegPOIResultListScreenModelAccess(this.env, n, this.iconHandler, this.vehicle, this.routeManager);
        TpegPOIResultListSequence tpegPOIResultListSequence = new TpegPOIResultListSequence(this.env, this.commandListFactory, tpegPOIResultListScreenModelAccess, this.spellerStack, this.startGuidanceSequence, this.previewMap);
        this.resultListScreenListener = new TpegPOIResultListScreenListener(this.env, tpegPOIResultListSequence, n, this.homeAddressHandler);
    }

    private void initRightDrawerListener() {
        TpegPOIRightDrawerSequence tpegPOIRightDrawerSequence = new TpegPOIRightDrawerSequence(this.env, this.commandListFactory, this.spellerStack, this.poiService, this.detailsHMIListener);
        this.rightDrawerListener = new TpegPOIRightDrawerListener(this.env, this.commandListFactory, this.naviFavoriteHandler, this.mapInterface, this.navAdbHandler, this.telService, tpegPOIRightDrawerSequence, 402068);
    }

    private void initAdditionalInfoScreenListener() {
        TpegPoiAdditionInfoScreenModelAccess tpegPoiAdditionInfoScreenModelAccess = new TpegPoiAdditionInfoScreenModelAccess(this.env);
        TpegPOIDetailSequence tpegPOIDetailSequence = new TpegPOIDetailSequence(this.env, this.commandListFactory, this.spellerStack, this.previewMap, tpegPoiAdditionInfoScreenModelAccess);
        this.additionalInfoScreenListener = new TpegPOIAdditionalInfoScreenListener(this.env, tpegPOIDetailSequence, 402320);
    }

    public TpegPOICategoryScreenListener getCategoryScreenListener() {
        return this.categoryScreenListener;
    }

    public TpegPOIResultListScreenListener getResultListListener() {
        return this.resultListScreenListener;
    }

    public TpegPOIRightDrawerListener getRightDrawerListener() {
        return this.rightDrawerListener;
    }
}

