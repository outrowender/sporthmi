/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.browser;

import de.audi.atip.browser.EfiUrlHandler;
import de.audi.atip.browser.FunctionalLink;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.util.UtilOnline;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public class RemoteHMIEfiUrlHandler
implements EfiUrlHandler {
    private static String LOG_CLASS = UtilOnline.getSuffix((class$de$audi$tghu$online$app$remotehmi$browser$RemoteHMIEfiUrlHandler == null ? (class$de$audi$tghu$online$app$remotehmi$browser$RemoteHMIEfiUrlHandler = RemoteHMIEfiUrlHandler.class$("de.audi.tghu.online.app.remotehmi.browser.RemoteHMIEfiUrlHandler")) : class$de$audi$tghu$online$app$remotehmi$browser$RemoteHMIEfiUrlHandler).getName(), ".");
    private LogChannel logChannel;
    private RemoteHMIService remoteHMIservice;
    private HMIService hmiService;
    private IEfiUrlListener listener;
    static /* synthetic */ Class class$de$audi$tghu$online$app$remotehmi$browser$RemoteHMIEfiUrlHandler;

    public RemoteHMIEfiUrlHandler(LogChannel logChannel, RemoteHMIService remoteHMIService, HMIService hMIService, IEfiUrlListener iEfiUrlListener) {
        this.logChannel = logChannel;
        this.remoteHMIservice = remoteHMIService;
        this.hmiService = hMIService;
        this.listener = iEfiUrlListener;
    }

    public RemoteHMIEfiUrlHandler(LogChannel logChannel, RemoteHMIService remoteHMIService, HMIService hMIService) {
        this(logChannel, remoteHMIService, hMIService, null);
    }

    public void updateActiveUrl(String string) {
    }

    public byte updateEfiUrl(final String string) {
        this.logChannel.log(1000000, "RemoteHMIEfiUrlHandler#updateEfiUrl: %1", (Object)string);
        FunctionalLink functionalLink = new FunctionalLink(this.logChannel, string);
        String string2 = functionalLink.getCommand();
        int n = 1;
        if ("use_address".equalsIgnoreCase(string2) || "navigate_to".equalsIgnoreCase(string2) || "add_stopover".equalsIgnoreCase(string2)) {
            double[] dArray = this.extractLocationAsDoubleArray(functionalLink);
            int n2 = NavigationUtilities.degreeToWgs84(dArray[0]);
            int n3 = NavigationUtilities.degreeToWgs84(dArray[1]);
            NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(n3, n2);
            String string3 = this.extractName(functionalLink);
            String string4 = this.extractPoiID(functionalLink);
            if (this.remoteHMIservice.getNaviComponent() == null) {
                this.logChannel.log(100000, "RemoteHMIEfiUrlHandler#updateEfiUrl: the navigation component is null");
                return -1;
            }
            NaviOnlineService naviOnlineService = this.remoteHMIservice.getNaviComponent().getNaviOnlineService();
            if (naviOnlineService == null || !naviOnlineService.getIsNaviFullyOperable()) {
                this.logChannel.log(100000, "RemoteHMIEfiUrlHandler#updateEfiUrl: the navigation is not fully operable and route guidance not possible");
                return -1;
            }
            this.switchToNavigation(string2, naviOnlineService, navLocationWgs84, string3, string4);
        } else if ("use_phone_number".equalsIgnoreCase(string2)) {
            String string5 = this.resolvePhoneNumber(functionalLink);
            if (this.remoteHMIservice.getNaviComponent() == null) {
                this.logChannel.log(100000, "RemoteHMIEfiUrlHandler#updateEfiUrl: the phone component is null");
                return -1;
            }
            ITelService iTelService = this.remoteHMIservice.getPhoneComponent().getTelService();
            if (iTelService == null) {
                this.logChannel.log(100000, "RemoteHMIEfiUrlHandler#updateEfiUrl: failed to dial current phone number: ITeLService is null");
                return -1;
            }
            if (string5.length() == 0) {
                this.logChannel.log(100000, "RemoteHMIEfiUrlHandler#updateEfiUrl: failed to dial current phone number: invalid phoneData");
                return -1;
            }
            ChoiceModelApp choiceModelApp = this.remoteHMIservice.getFrameworkAccess().getHmiServiceApp().getChoiceModel(186);
            if (choiceModelApp.getValue() == 0) {
                this.logChannel.log(100000, "RemoteHMIEfiUrlHandler#updateEfiUrl: phone is not ready");
                return -1;
            }
            this.logChannel.log(1000000, "RemoteHMIEfiUrlHandler#dialNumber: phoneData %1", (Object)string5);
            n = 3;
            iTelService.dialNumber(string5, new ITelServiceListener(){

                public void dialNumberResponse(int n) {
                    int n2;
                    RemoteHMIEfiUrlHandler.this.logChannel.log(1000000, "RemoteHMIEfiUrlHandler#dialNumberResponse: result: %1", (long)n);
                    if (n == 0) {
                        n2 = 1;
                    } else {
                        n2 = -1;
                        RemoteHMIEfiUrlHandler.this.logChannel.log(100000, "RemoteHMIEfiUrlHandler#dialNumberResponse: failed to dial current phone number");
                    }
                    if (RemoteHMIEfiUrlHandler.this.listener != null) {
                        RemoteHMIEfiUrlHandler.this.listener.indicateEfiResult(n2, string);
                    }
                }
            }, false);
            ChoiceModelApp choiceModelApp2 = this.hmiService.getChoiceModel(2300984);
            choiceModelApp2.setValue(choiceModelApp2.getValue() ^ 1);
        } else {
            if ("save_as_favorite".equalsIgnoreCase(string2)) {
                return this.handleAddToFavoriteCommand(functionalLink, (byte)n);
            }
            n = -1;
            this.logChannel.log(100000, "%1#updateEfiUrl: - command <%2> not supported yet!", (Object)LOG_CLASS, (Object)string2);
        }
        return (byte)n;
    }

    private byte handleAddToFavoriteCommand(FunctionalLink functionalLink, byte by) {
        String string = this.extractLatitude(functionalLink);
        String string2 = this.extractLongitude(functionalLink);
        String string3 = this.extractName(functionalLink);
        this.logChannel.log(1000000, "%1#updateEfiUrl(): called for %2(%3; %4)", (Object)LOG_CLASS, (Object)string3, (Object)string, (Object)string2);
        if (this.hasValidNameAndCoordinates(string, string2, string3)) {
            this.logChannel.log(100000, "%1#updateEfiUrl: failed to add the favorite. Some parameters are null or empty", (Object)LOG_CLASS);
            return -1;
        }
        if (this.remoteHMIservice.getNaviComponent() == null) {
            this.logChannel.log(100000, "RemoteHMIEfiUrlHandler#updateEfiUrl: the navigation component is null");
            return -1;
        }
        NaviADBService naviADBService = this.remoteHMIservice.getNaviComponent().getNaviADBService();
        if (naviADBService == null) {
            this.logChannel.log(100000, "%1#updateEfiUrl: failed to add the favorite. NaviADBService is null", (Object)LOG_CLASS);
            return -1;
        }
        naviADBService.addToFavorites(string2, string, string3);
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2301371);
        choiceModelApp.setValue(choiceModelApp.getValue() ^ 1);
        return by;
    }

    private boolean hasValidNameAndCoordinates(String string, String string2, String string3) {
        return StringUtilities.isNullOrEmpty(string) || StringUtilities.isNullOrEmpty(string2) || StringUtilities.isNullOrEmpty(string3);
    }

    private void switchToNavigation(String string, NaviOnlineService naviOnlineService, NavLocationWgs84 navLocationWgs84, String string2, String string3) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(4146);
        if ("add_stopover".equalsIgnoreCase(string)) {
            this.logChannel.log(10000000, "RemoteHMIEfiUrlHandler#triggerNavigation: insert as stopover");
            naviOnlineService.insertAsStopover(navLocationWgs84, string2, choiceModelApp, -1, true);
        } else {
            this.logChannel.log(10000000, "RemoteHMIEfiUrlHandler#triggerNavigation: start route guidance");
            naviOnlineService.startRouteGuidance(navLocationWgs84, string2, choiceModelApp, string3);
        }
    }

    private String resolvePhoneNumber(FunctionalLink functionalLink) {
        String string = functionalLink.getValue("phone");
        if (StringUtilities.isNullOrEmpty(string)) {
            this.logChannel.log(100000, "RemoteHMIEfiUrlHandler#resolvePhoneNumber: phone number is empty, phone=%1", (Object)string);
            return "";
        }
        return string;
    }

    private double[] extractLocationAsDoubleArray(FunctionalLink functionalLink) {
        String string = this.extractLongitude(functionalLink);
        String string2 = this.extractLatitude(functionalLink);
        double d2 = this.convertCoordinateStringToDouble(string2);
        double d3 = this.convertCoordinateStringToDouble(string);
        return new double[]{d2, d3};
    }

    private double convertCoordinateStringToDouble(String string) {
        try {
            if (string == null) {
                return 0.0;
            }
            return Double.parseDouble(string.trim());
        }
        catch (Exception exception) {
            this.logChannel.log(100000, "RemoteHMIEfiUrlHandler#convertCoordinateStringToDouble: could not parse lat %1", (Object)string);
            return 0.0;
        }
    }

    private String extractLatitude(FunctionalLink functionalLink) {
        return functionalLink.getValue("lat");
    }

    private String extractLongitude(FunctionalLink functionalLink) {
        return functionalLink.getValue("lon");
    }

    private String extractName(FunctionalLink functionalLink) {
        String string = functionalLink.getValue("name");
        this.logChannel.log(1000000, "RemoteHMIEfiUrlHandler#extractName: extracted Name: %1", (Object)string);
        return string == null ? "" : string;
    }

    private String extractPoiID(FunctionalLink functionalLink) {
        String string = functionalLink.getValue("poiid");
        this.logChannel.log(1000000, "RemoteHMIEfiUrlHandler#extractingPoiID: extracted POIID: %1", (Object)string);
        return string == null ? "" : string;
    }

    private NavLocation extractNavLocation(FunctionalLink functionalLink) {
        String string = functionalLink.getValue("city");
        String string2 = functionalLink.getValue("street");
        String string3 = functionalLink.getValue("country");
        String string4 = functionalLink.getValue("zip");
        NavLocation navLocation = new NavLocation();
        navLocation.street = string2;
        navLocation.town = string;
        navLocation.country = string3;
        navLocation.zipCode = string4;
        return navLocation;
    }

    public void gotoHomeURL() {
    }

    public void showSpeller(String string, String string2, String string3, boolean bl, short s) {
    }

    public boolean goForward() {
        return false;
    }

    public boolean goBack() {
        return false;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static interface IEfiUrlListener {
        public void indicateEfiResult(int var1, String var2);
    }
}

