/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.appcore;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficHandler;
import de.audi.tghu.navi.app.util.Util;

public abstract class NaviActionProxyImplCore {
    protected final NavigationEnv env;
    protected final MapInterface mapInterface;
    protected final OnlineTrafficHandler onlineTrafficHandler;
    protected LogChannel logChannel;
    protected final IPoiService poiService;
    protected final int navResetChoiceModel;
    protected final int navVics2PopupResetChoiceModel;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    protected NaviActionProxyImplCore(NavigationEnv navigationEnv, MapInterface mapInterface, OnlineTrafficHandler onlineTrafficHandler, IPoiService iPoiService) {
        this.env = navigationEnv;
        this.mapInterface = mapInterface;
        this.onlineTrafficHandler = onlineTrafficHandler;
        this.poiService = iPoiService;
        this.logChannel = navigationEnv.getLogChannel();
        this.navResetChoiceModel = 170;
        this.navVics2PopupResetChoiceModel = 402513;
    }

    public void exitPoiWarning(int n) {
        this.env.getPoiApproachWarningLogChannel().log(10000000, this.CLASS_NAME + "#exitPoiWarning()");
        if (this.poiService != null) {
            this.poiService.getPoiWarningManager().exitPoiWarning();
        }
    }

    public void setSecureKeyIncludeColor(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setSecureKeyIncludeColor( %1 )", (long)n2);
        if (n2 == 0 && this.env.getChoiceModel(17).getValue() == 1) {
            this.env.getChoiceModel(156).setValue(1);
        } else {
            this.env.getChoiceModel(156).setValue(n2);
        }
    }

    public void setGeActiceCallShown(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setGeActiceCallShown");
        this.env.getChoiceModel(94).setValue(1);
    }

    public void favoritesNoDataEntered(int n) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(172);
        choiceModelApp.setValue(0);
        this.logChannel.log(10000000, this.CLASS_NAME + "#handleFavorites: navSDSFavoritesStatusChoice=%1!", (long)choiceModelApp.getValue());
    }

    public void navRouteplanHintsTour(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#navRouteplanHintsTour( %1 ) ", (long)n2);
        this.env.getChoiceModel(400394).setValue(n2);
    }

    public void navRouteplanHintsStorage(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#navRouteplanHintsStorage( %1 ) ", (long)n2);
        this.env.getChoiceModel(400393).setValue(n2);
    }

    public void navHintsApps(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#navHintsApps( %1 ) ", (long)n2);
        this.env.getChoiceModel(400391).setValue(n2);
    }

    public void navHintsSettings(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#navHintsSettings( %1 ) ", (long)n2);
        this.env.getChoiceModel(400395).setValue(n2);
    }

    public void navHintsDestDetails(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#navHintsDestDetails( %1 ) ", (long)n2);
        this.env.getChoiceModel(400392).setValue(n2);
    }

    public void exitNavDestPoiGoogleList(int n) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(299);
        choiceModelApp.setValue(-1);
        choiceModelApp.setStatus(0);
    }

    public void enterNavMapShowDestInMapViaAdb2(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(400327);
        choiceModelApp.setValue(n2);
    }

    public void enterMapScreen(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterMapScreen() keepContext=%1", (long)n2);
        this.mapInterface.enterMapScreen(n2);
    }

    public void enterMapScreenFromLeftDrawer(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterMapScreenFromLeftDrawer() ");
        this.mapInterface.enterMapScreenFromLeftDrawer();
    }

    public void exitMapScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitMapScreen() ");
        this.mapInterface.exitMapScreen();
    }

    public void enterMapMainScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterMapMainScreen() ");
        this.mapInterface.enterMapMainScreen();
    }

    public void exitMapMainScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitMapMainScreen() ");
        this.mapInterface.exitMapMainScreen();
    }

    public void enterMapBriefingScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterMapBriefingScreen() ");
        this.mapInterface.enterMapBriefingScreen();
    }

    public void exitMapBriefingScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitMapBriefingScreen() ");
        this.mapInterface.exitMapBriefingScreen();
    }

    public void enterPreviewMapScreen(int n, int n2, int n3, int n4, int n5) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, this.CLASS_NAME + "#enterPreviewMapScreen() - w: %1, h: %2", (long)n2, (long)n3);
            this.logChannel.log(100000000, this.CLASS_NAME + "#enterPreviewMapScreen() - oX: %1, oY: %2", (long)n4, (long)n5);
        }
        try {
            this.mapInterface.getPreviewMap().previewMapScreenEntering(n2, n3, n4, n5);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, this.CLASS_NAME + "#enterPreviewMapScreen() - ERROR=%1", (Throwable)exception);
            exception.printStackTrace();
        }
    }

    public void enterPreviewMapScreen(int n, int n2, int n3) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterPreviewMapScreen() ");
        try {
            this.mapInterface.getPreviewMap().previewMapScreenEntering(n2, n3, 0, 0);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, this.CLASS_NAME + "#enterPreviewMapScreen() - ERROR=%1", (Throwable)exception);
            exception.printStackTrace();
        }
    }

    public void exitPreviewMapScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitPreviewMapScreen() ");
        try {
            this.mapInterface.getPreviewMap().previewMapScreenExited();
        }
        catch (Exception exception) {
            this.logChannel.log(10000, this.CLASS_NAME + "#exitPreviewMapScreen() - ERROR=%1", (Throwable)exception);
            exception.printStackTrace();
        }
    }

    public void navigationEntered(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#navigationEntered()");
        this.env.getInputModeManager().setNavigationActive(true);
        this.mapInterface.navigationEntered();
    }

    public void navigationLeft(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#navigationLeft()");
        this.env.getInputModeManager().setNavigationActive(false);
        this.mapInterface.navigationLeft();
    }

    public void enterNavCalcRoute(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterNavCalcRoute()");
    }

    public void exitNavCalcRoute(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitNavCalcRoute()");
    }

    public void cancelInput(int n) {
    }

    public void onlineMapEntered(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#onlineMapEntered()");
    }

    public void setOnlineMapDataConnectionStatus(int n, boolean bl) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#onlineMapDataConnectionStatus( %1 ) ", bl);
        this.setOnlineMapDataConnectionLicenseStatus(n, bl, true);
    }

    public void setOnlineMapDataConnectionLicenseStatus(int n, boolean bl, boolean bl2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setOnlineMapDataConnectionLicenseStatus() - dataConnectionStatus: %1, licenseStatus: %2 ", bl, bl2);
        this.mapInterface.setOnlineMapDataConnectionLicenseStatus(bl, bl2);
    }

    public void onlineTrafficLicenceActive(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#onlineTrafficLicenceActive()");
        this.onlineTrafficHandler.updateLicenceActive();
    }

    public void weatherMapLicenceActive(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#weatherMapLicenceActive()");
        this.mapInterface.getWeatherLicenseHandler().updateLicenceActiveMainMap();
    }

    public void weatherMapLicenceActiveKombi(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#weatherMapLicenceActiveKombi()");
        this.mapInterface.getWeatherLicenseHandler().updateLicenceActiveKombiMap();
    }

    public void enterPoiMainScreen(int n) {
        this.logChannel.log(10000000, "%1#enterPoiMainScreen()", (Object)this.CLASS_NAME);
        this.poiService.enterPoiMainScreen(true, false);
    }

    public void enterTrafficDetails(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterTrafficDetails( %1 )", (long)n2);
        this.env.getChoiceModel(401703).setValue(n2);
    }

    public void exitTrafficDetails(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitTrafficDetails()");
        this.env.getChoiceModel(401703).setValue(0);
    }

    public void reenterPOIOnline(int n) {
    }

    public void enterShowDetailsOnlinePoiBrowserMain(int n) {
    }

    public void enterGeoCoordInput(int n) {
    }

    public void enterDestOptSaveAsFavorite(int n) {
    }

    public void enterMapOptionsDrawer(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterMapOptionsDrawer() ");
        this.mapInterface.enterMapOptionsDrawer();
    }

    public void exitMapOptionsDrawer(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitMapOptionsDrawer() ");
        this.mapInterface.exitMapOptionsDrawer();
    }

    public void enterOperatorCallMapScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterOperatorCallMapScreen()");
        this.mapInterface.enterOperatorCallMapScreen();
    }

    public void exitOperatorCallMapScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitOperatorCallMapScreen()");
        this.mapInterface.exitOperatorCallMapScreen();
    }

    public void enterGoogleSplashScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterGoogleSplashScreen()");
        this.env.getChoiceModel(402125).setValue(1);
    }

    public void exitGoogleSplashScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitGoogleSplashScreen()");
        this.env.getChoiceModel(402125).setValue(0);
    }

    public void prepareVICS2ShowInMap(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#prepareVICS2ShowInMap()");
        this.mapInterface.getTMCMap().mapEntered();
    }

    public void closeSelectionDrawer(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#closeSelectionDrawer()");
        HMIService hMIService = this.env.getFramework().getHMIService();
        DrawerEvent drawerEvent = new DrawerEvent(hMIService.getRootWindow(0), 7);
        hMIService.getEventDispatcher().postEvent(drawerEvent);
    }
}

