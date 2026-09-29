/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.interapp;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.NaviADBService$LocationInputHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.GeoMetric;
import de.audi.atip.preset.DefinitionRequest;
import org.dsi.ifc.organizer.AdbEntry;

public class NaviGateway {
    private volatile NaviADBService naviService;
    private AbstractAddressBookApplication appAdr;
    private LogChannel log;
    private static final String[] EMPTY_FORMATTED_LOCATION_STRINGS = new String[]{"", ""};
    private static final String EMPTY_LOCATION_TITLE_STRING;

    public NaviGateway(LogChannel logChannel, AbstractAddressBookApplication abstractAddressBookApplication) {
        this.log = logChannel;
        this.appAdr = abstractAddressBookApplication;
    }

    public void setNaviService(NaviADBService naviADBService) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#setNaviService(): naviService: %1", (Object)naviADBService);
        this.naviService = naviADBService;
    }

    public boolean isNaviReady() {
        return this.getCheckedNaviService() != null;
    }

    private NaviADBService getCheckedNaviService() {
        if (this.appAdr.getFramework().getSysConst(459) == 0) {
            this.log.log(-2137614336, "NaviGateway#getCheckedNaviService(): current system does not have a navi.");
            return null;
        }
        NaviADBService naviADBService = this.naviService;
        if (naviADBService == null) {
            this.log.log(10000, "NaviGateway#getCheckedNaviService(): navi service not available!");
            return null;
        }
        if (this.appAdr.getHMIService().getChoiceModel(177).getValue() == 0) {
            this.log.log(10000, "NaviGateway#getCheckedNaviService(): navi not ready!");
            return null;
        }
        return naviADBService;
    }

    private int getDefaultLogLevel() {
        return this.appAdr.getFramework().getSysConst(459) == 0 ? -2137614336 : 1078071040;
    }

    public void setDestination(byte[] byArray, String string) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#setDestination( navLocation )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.setDestination(byArray, string);
        }
    }

    public void setDestination(AdbEntry adbEntry, int n, String string) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#setDestination( tryBestMatch )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.setDestination(adbEntry, n, string);
        }
    }

    public void setDestination(String string, String string2, String string3) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#setDestination( geoPos )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.setDestination(string, string2, string3);
        }
    }

    public void showDestinationInMap(byte[] byArray, String string) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#showDestinationInMap(): navLocation: %1, generalDescription: %2", (Object)byArray, (Object)string);
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.showDestinationInMap(byArray, string);
        }
    }

    public void showDestinationInMap(String string, String string2, String string3) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#showDestinationInMap( geoPos )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.showDestinationInMap(string, string2, string3);
        }
    }

    public void enterPreviewMap(int n, int n2) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#enterPreviewMap( width, height )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.enterPreviewMap(n, n2);
        } else {
            this.showPreviewMap(false);
        }
    }

    public void showPreviewMap(boolean bl) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#showPreviewMap( %1 )", bl);
        this.appAdr.getHMIService().getChoiceModel(2075134464).setValue(bl ? 1 : 0);
    }

    public void focusPreviewMap(byte[] byArray) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#focusPreviewMap( navLocation )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            this.showPreviewMap(true);
            naviADBService.focusPreviewMap(byArray);
        } else {
            this.showPreviewMap(false);
        }
    }

    public void focusPreviewMap(String string, String string2) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#focusPreviewMap( longitude, latitude )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            this.showPreviewMap(true);
            naviADBService.focusPreviewMap(string, string2);
        } else {
            this.showPreviewMap(false);
        }
    }

    public void focusPreviewMap(AdbEntry adbEntry, int n) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#focusPreviewMap( entry, adrIndex )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            this.showPreviewMap(true);
            naviADBService.focusPreviewMap(adbEntry, n);
        } else {
            this.showPreviewMap(false);
        }
    }

    public void exitPreviewMap() {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#exitPreviewMap()");
        this.showPreviewMap(false);
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.exitPreviewMap();
        }
    }

    public void parkNearDestination(byte[] byArray, String string) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#parkNearDestination( navLocation )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.parkNearDestination(byArray, string);
        }
    }

    public void parkNearDestination(String string, String string2, String string3) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#parkNearDestination( geoPos )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.parkNearDestination(string, string2, string3);
        }
    }

    public void poiNearDestination(byte[] byArray, String string) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#poiNearDestination( navLocation )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.poiNearDestination(byArray, string);
        }
    }

    public void poiNearDestination(String string, String string2, String string3) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#poiNearDestination( geoPos )");
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.poiNearDestination(string, string2, string3);
        }
    }

    public void editLocation(NaviADBService$LocationInputHandler naviADBService$LocationInputHandler, byte[] byArray) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#editLocation( navLocation ): navLocation: %1", (Object)byArray);
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            this.appAdr.getHMIService().getChoiceModel(581962240).setValue(0);
            this.appAdr.getLocationInputHandler().init(byArray);
            naviADBService.editLocation(naviADBService$LocationInputHandler, byArray);
        }
    }

    public void editLocation(NaviADBService$LocationInputHandler naviADBService$LocationInputHandler, AdbEntry adbEntry, int n) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#editLocation( tryBestMatch ): entry: %1, adrIndex: %2", (Object)adbEntry, (Object)(n == 0 ? "business" : "private"));
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            this.appAdr.getHMIService().getChoiceModel(581962240).setValue(1);
            this.appAdr.getLocationInputHandler().init(null);
            naviADBService.editLocation(naviADBService$LocationInputHandler, adbEntry, n);
        }
    }

    public String[] getLocationName(byte[] byArray) {
        if (ADBAddressUtils.isEmptyLocation(byArray)) {
            this.log.log(this.getDefaultLogLevel(), "NaviGateway#getLocationName(): navLocation is empty.");
            return EMPTY_FORMATTED_LOCATION_STRINGS;
        }
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            String[] stringArray = naviADBService.getLocationName(byArray);
            this.log.log(this.getDefaultLogLevel(), "NaviGateway#getLocationName(): result: %1", (Object)stringArray);
            return stringArray;
        }
        return EMPTY_FORMATTED_LOCATION_STRINGS;
    }

    public String getLocationNameSingleline(byte[] byArray) {
        if (ADBAddressUtils.isEmptyLocation(byArray)) {
            this.log.log(this.getDefaultLogLevel(), "NaviGateway#getLocationNameSingleline(): navLocation is empty.");
            return "";
        }
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            String string = naviADBService.getLocationNameSingleLine(byArray);
            this.log.log(this.getDefaultLogLevel(), "NaviGateway#getLocationNameSingleline(): result: %1", (Object)string);
            return string;
        }
        return "";
    }

    public GeoMetric convertDecimalsToGeoMetric(String string, String string2) {
        this.log.log(-2137614336, "NaviGateway#convertDecimalsToGeoMetric(): longitude: %1, latitude: %2", (Object)string, (Object)string2);
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            return naviADBService.convertDecimalsToGeoMetric(string, string2);
        }
        return null;
    }

    public void addToFavorites(byte[] byArray, String string) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#addToFavorites(): navLocation: %1, defaultName: %2", (Object)byArray, (Object)string);
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.addToFavorites(byArray, string);
        }
    }

    public void addToFavorites(String string, String string2, String string3) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#addToFavorites(): longitude: %1, latitude: %2, defaultName: %3", (Object)string, (Object)string2, (Object)string3);
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.addToFavorites(string, string2, string3);
        }
    }

    public void definePreset(DefinitionRequest definitionRequest, byte[] byArray, String string) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#definePreset(): navLocation: %1, name: %2", (Object)byArray, (Object)string);
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.definePreset(definitionRequest, byArray, string);
        }
    }

    public void definePreset(DefinitionRequest definitionRequest, String string, String string2, String string3) {
        this.log.log(this.getDefaultLogLevel(), "NaviGateway#definePreset(): longitude: %1, latitude: %2, name: %3", (Object)string, (Object)string2, (Object)string3);
        NaviADBService naviADBService = this.getCheckedNaviService();
        if (naviADBService != null) {
            naviADBService.definePreset(definitionRequest, string, string2, string3);
        }
    }
}

