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
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

    protected NaviActionProxyImplCore(NavigationEnv navigationEnv, MapInterface mapInterface, OnlineTrafficHandler onlineTrafficHandler, IPoiService iPoiService) {
        this.env = navigationEnv;
        this.mapInterface = mapInterface;
        this.onlineTrafficHandler = onlineTrafficHandler;
        this.poiService = iPoiService;
        this.logChannel = navigationEnv.getLogChannel();
        this.navResetChoiceModel = 170;
        this.navVics2PopupResetChoiceModel = 1361315328;
    }

    public void exitPoiWarning(int n) {
        this.env.getPoiApproachWarningLogChannel().log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitPoiWarning()").toString());
        if (this.poiService != null) {
            this.poiService.getPoiWarningManager().exitPoiWarning();
        }
    }

    public void setSecureKeyIncludeColor(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setSecureKeyIncludeColor( %1 )").toString(), (long)n2);
        if (n2 == 0 && this.env.getChoiceModel(17).getValue() == 1) {
            this.env.getChoiceModel(156).setValue(1);
        } else {
            this.env.getChoiceModel(156).setValue(n2);
        }
    }

    public void setGeActiceCallShown(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setGeActiceCallShown").toString());
        this.env.getChoiceModel(94).setValue(1);
    }

    public void favoritesNoDataEntered(int n) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(172);
        choiceModelApp.setValue(0);
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#handleFavorites: navSDSFavoritesStatusChoice=%1!").toString(), (long)choiceModelApp.getValue());
    }

    public void navRouteplanHintsTour(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#navRouteplanHintsTour( %1 ) ").toString(), (long)n2);
        this.env.getChoiceModel(169608704).setValue(n2);
    }

    public void navRouteplanHintsStorage(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#navRouteplanHintsStorage( %1 ) ").toString(), (long)n2);
        this.env.getChoiceModel(152831488).setValue(n2);
    }

    public void navHintsApps(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#navHintsApps( %1 ) ").toString(), (long)n2);
        this.env.getChoiceModel(119277056).setValue(n2);
    }

    public void navHintsSettings(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#navHintsSettings( %1 ) ").toString(), (long)n2);
        this.env.getChoiceModel(186385920).setValue(n2);
    }

    public void navHintsDestDetails(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#navHintsDestDetails( %1 ) ").toString(), (long)n2);
        this.env.getChoiceModel(136054272).setValue(n2);
    }

    public void exitNavDestPoiGoogleList(int n) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(299);
        choiceModelApp.setValue(-1);
        choiceModelApp.setStatus(0);
    }

    public void enterNavMapShowDestInMapViaAdb2(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-954530304);
        choiceModelApp.setValue(n2);
    }

    public void enterMapScreen(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterMapScreen() keepContext=%1").toString(), (long)n2);
        this.mapInterface.enterMapScreen(n2);
    }

    public void enterMapScreenFromLeftDrawer(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterMapScreenFromLeftDrawer() ").toString());
        this.mapInterface.enterMapScreenFromLeftDrawer();
    }

    public void exitMapScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitMapScreen() ").toString());
        this.mapInterface.exitMapScreen();
    }

    public void enterMapMainScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterMapMainScreen() ").toString());
        this.mapInterface.enterMapMainScreen();
    }

    public void exitMapMainScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitMapMainScreen() ").toString());
        this.mapInterface.exitMapMainScreen();
    }

    public void enterMapBriefingScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterMapBriefingScreen() ").toString());
        this.mapInterface.enterMapBriefingScreen();
    }

    public void exitMapBriefingScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitMapBriefingScreen() ").toString());
        this.mapInterface.exitMapBriefingScreen();
    }

    public void enterPreviewMapScreen(int n, int n2, int n3, int n4, int n5) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, new StringBuffer().append(this.CLASS_NAME).append("#enterPreviewMapScreen() - w: %1, h: %2").toString(), (long)n2, (long)n3);
            this.logChannel.log(14808325, new StringBuffer().append(this.CLASS_NAME).append("#enterPreviewMapScreen() - oX: %1, oY: %2").toString(), (long)n4, (long)n5);
        }
        try {
            this.mapInterface.getPreviewMap().previewMapScreenEntering(n2, n3, n4, n5);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, new StringBuffer().append(this.CLASS_NAME).append("#enterPreviewMapScreen() - ERROR=%1").toString(), (Throwable)exception);
            exception.printStackTrace();
        }
    }

    public void enterPreviewMapScreen(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterPreviewMapScreen() ").toString());
        try {
            this.mapInterface.getPreviewMap().previewMapScreenEntering(n2, n3, 0, 0);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, new StringBuffer().append(this.CLASS_NAME).append("#enterPreviewMapScreen() - ERROR=%1").toString(), (Throwable)exception);
            exception.printStackTrace();
        }
    }

    public void exitPreviewMapScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitPreviewMapScreen() ").toString());
        try {
            this.mapInterface.getPreviewMap().previewMapScreenExited();
        }
        catch (Exception exception) {
            this.logChannel.log(10000, new StringBuffer().append(this.CLASS_NAME).append("#exitPreviewMapScreen() - ERROR=%1").toString(), (Throwable)exception);
            exception.printStackTrace();
        }
    }

    public void navigationEntered(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#navigationEntered()").toString());
        this.env.getInputModeManager().setNavigationActive(true);
        this.mapInterface.navigationEntered();
    }

    public void navigationLeft(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#navigationLeft()").toString());
        this.env.getInputModeManager().setNavigationActive(false);
        this.mapInterface.navigationLeft();
    }

    public void enterNavCalcRoute(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterNavCalcRoute()").toString());
    }

    public void exitNavCalcRoute(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitNavCalcRoute()").toString());
    }

    public void cancelInput(int n) {
    }

    public void onlineMapEntered(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onlineMapEntered()").toString());
    }

    public void setOnlineMapDataConnectionStatus(int n, boolean bl) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onlineMapDataConnectionStatus( %1 ) ").toString(), bl);
        this.setOnlineMapDataConnectionLicenseStatus(n, bl, true);
    }

    public void setOnlineMapDataConnectionLicenseStatus(int n, boolean bl, boolean bl2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setOnlineMapDataConnectionLicenseStatus() - dataConnectionStatus: %1, licenseStatus: %2 ").toString(), bl, bl2);
        this.mapInterface.setOnlineMapDataConnectionLicenseStatus(bl, bl2);
    }

    public void onlineTrafficLicenceActive(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onlineTrafficLicenceActive()").toString());
        this.onlineTrafficHandler.updateLicenceActive();
    }

    public void weatherMapLicenceActive(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#weatherMapLicenceActive()").toString());
        this.mapInterface.getWeatherLicenseHandler().updateLicenceActiveMainMap();
    }

    public void weatherMapLicenceActiveKombi(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#weatherMapLicenceActiveKombi()").toString());
        this.mapInterface.getWeatherLicenseHandler().updateLicenceActiveKombiMap();
    }

    public void enterPoiMainScreen(int n) {
        this.logChannel.log(-2137614336, "%1#enterPoiMainScreen()", (Object)this.CLASS_NAME);
        this.poiService.enterPoiMainScreen(true, false);
    }

    public void enterTrafficDetails(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterTrafficDetails( %1 )").toString(), (long)n2);
        this.env.getChoiceModel(656475648).setValue(n2);
    }

    public void exitTrafficDetails(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitTrafficDetails()").toString());
        this.env.getChoiceModel(656475648).setValue(0);
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
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterMapOptionsDrawer() ").toString());
        this.mapInterface.enterMapOptionsDrawer();
    }

    public void exitMapOptionsDrawer(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitMapOptionsDrawer() ").toString());
        this.mapInterface.exitMapOptionsDrawer();
    }

    public void enterOperatorCallMapScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterOperatorCallMapScreen()").toString());
        this.mapInterface.enterOperatorCallMapScreen();
    }

    public void exitOperatorCallMapScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitOperatorCallMapScreen()").toString());
        this.mapInterface.exitOperatorCallMapScreen();
    }

    public void enterGoogleSplashScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterGoogleSplashScreen()").toString());
        this.env.getChoiceModel(-853408256).setValue(1);
    }

    public void exitGoogleSplashScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitGoogleSplashScreen()").toString());
        this.env.getChoiceModel(-853408256).setValue(0);
    }

    public void prepareVICS2ShowInMap(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#prepareVICS2ShowInMap()").toString());
        this.mapInterface.getTMCMap().mapEntered();
    }

    public void closeSelectionDrawer(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#closeSelectionDrawer()").toString());
        HMIService hMIService = this.env.getFramework().getHMIService();
        DrawerEvent drawerEvent = new DrawerEvent(hMIService.getRootWindow(0), 7);
        hMIService.getEventDispatcher().postEvent(drawerEvent);
    }
}

