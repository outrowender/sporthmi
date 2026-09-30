/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.AddressBookOptionModelListener;
import de.audi.app.navi.evo.poi.online.CallOptionModelListener;
import de.audi.app.navi.evo.poi.online.DestOptSelectionOnlineListener;
import de.audi.app.navi.evo.poi.online.DetailOptionModelListener;
import de.audi.app.navi.evo.poi.online.FavoritesOptionModelListener;
import de.audi.app.navi.evo.poi.online.OnlineSDSSearchSequenceEvo;
import de.audi.app.navi.evo.poi.online.OnlineSearchForm;
import de.audi.app.navi.evo.poi.online.ParkingAndPoiOptionModelListener;
import de.audi.app.navi.evo.poi.online.ShowInMapOptionModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationBrowser;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListener;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.phone.ITelServiceController;
import de.audi.tghu.navi.app.poi.online.OnlineSDSSearchSequence;
import de.audi.tghu.navi.app.poi.online.OnlineSearchController;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import de.audi.tghu.navi.app.poi.online.PoiOnlineSearchArea;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

public class OnlineSearchControllerEvo
extends OnlineSearchController {
    private OnlineSearchForm form;
    private final IconHandler iconHandler;
    private final IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;
    private final ISDSController sdsController;
    private IRouteManager routeManager;
    private final NavigationBrowser navigationBrowser;
    private final NaviADBHandler naviAdbHandler;
    private final ICommandListFactory naviCommandListFactory;
    private IAddressInputForm inputForm;
    private FavoritesOptionModelListener onlineSearchFavHandler;
    private ParkingAndPoiOptionModelListener onlineSearchPoiAndParkingHandler;
    private ShowInMapOptionModelListener onlineSearchShowInMapHandler;
    private CallOptionModelListener onlineSearchCallHandler;
    private DetailOptionModelListener onlineSearchDetailHandler;
    private AddressBookOptionModelListener onlineSearchAddressBookHandler;

    public OnlineSearchControllerEvo(NavigationEnv navigationEnv, IconHandler iconHandler, LogChannel logChannel, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ISDSController iSDSController, NavigationBrowser navigationBrowser, NaviADBHandler naviADBHandler, ICommandListFactory iCommandListFactory, IAddressInputForm iAddressInputForm) {
        super(logChannel);
        this.naviCommandListFactory = iCommandListFactory;
        logChannel.log(1000000, "OnlineSearchControllerEvo()");
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.sdsController = iSDSController;
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.navigationBrowser = navigationBrowser;
        this.naviAdbHandler = naviADBHandler;
        this.inputForm = iAddressInputForm;
    }

    public void init(IPreviewMap iPreviewMap, IVehicle iVehicle, ITelServiceController iTelServiceController, IRouteManager iRouteManager, IRRDListener iRRDListener, NaviFavoriteHandler naviFavoriteHandler, IPoiService iPoiService, HomeAddressHandler homeAddressHandler) {
        this.logger.log(1000000, "OnlineSearchControllerEvo#init()");
        PoiOnlineSearchArea poiOnlineSearchArea = new PoiOnlineSearchArea(this.logger);
        this.sequence = new OnlineSearchSequence(iVehicle, this.logger, this.env.getFramework(), poiOnlineSearchArea, iPreviewMap, this.naviCommandListFactory, iRouteManager, this.env);
        this.form = new OnlineSearchForm(this.env, this.sequence, this.iconHandler, iVehicle, this.startGuidanceToDestinationSequence, this.sdsController, iTelServiceController, iPreviewMap, this.navigationBrowser, this.naviAdbHandler, this.inputForm, iRRDListener, iRouteManager, homeAddressHandler);
        this.sequence.init(this.form);
        this.onlineSearchFavHandler = new FavoritesOptionModelListener(this.logger, this.env, this.sequence, this.form, naviFavoriteHandler);
        this.onlineSearchPoiAndParkingHandler = new ParkingAndPoiOptionModelListener(this.logger, this.env, this.sequence, this.form, iPoiService);
        this.onlineSearchShowInMapHandler = new ShowInMapOptionModelListener(this.logger, this.env, this.sequence, this.form);
        this.onlineSearchCallHandler = new CallOptionModelListener(this.logger, this.env, this.sequence, this.form, this.sdsController);
        this.onlineSearchDetailHandler = new DetailOptionModelListener(this.logger, this.env, this.sequence, this.form);
        this.onlineSearchAddressBookHandler = new AddressBookOptionModelListener(this.logger, this.env, this.sequence, this.form, this.naviAdbHandler);
        this.sdsSequence = new OnlineSDSSearchSequenceEvo(this.env, this.logger, this.sequence.getCommandListFactory(), this.sequence, this.form);
        new DestOptSelectionOnlineListener(this.form, this.env);
        this.routeManager = iRouteManager;
    }

    public OnlineSearchForm getOnlineSearchForm() {
        return this.form;
    }

    public void configureSearchFromTruffles(String string) {
        this.form.startSearch(string, true);
    }

    public OnlineSDSSearchSequence getSDS() {
        return this.sdsSequence;
    }

    public void updateRgActive(boolean bl) {
        Object object;
        int n;
        this.logger.log(1000000, "OnlineSearchController#updateRGActive() rgActive: " + bl);
        if (!(bl || (n = ((PoiOnlineSearchArea)(object = this.sequence.getSearchContext().getSearchArea())).getSearchContext()) != 1 && n != 2)) {
            this.sequence.setSearchArea(0);
        }
        object = null;
        if (this.routeManager != null) {
            object = this.routeManager.getRoute();
        }
        this.form.updateRGActiveModels(bl, RouteUtil.getNumberOfDestinations((Route)object, 1));
    }

    public void resetMemorySettings() {
        this.form.resetMemory();
    }
}

