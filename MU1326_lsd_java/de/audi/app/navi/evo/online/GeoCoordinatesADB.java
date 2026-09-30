/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.GeoCoordinates;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.ADBRemoteHMIAddress;
import de.audi.atip.interapp.ADBRemoteHMIService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class GeoCoordinatesADB
implements GeoCoordinates {
    private final LogChannel logChannel;
    private final ADBRemoteHMIService adbRemoteHMIService2;
    private final LocationSerializer locationSerializer2;
    private final ADBInterAppService adbInterAppService2;

    public GeoCoordinatesADB(LogChannel logChannel, ADBRemoteHMIService aDBRemoteHMIService, LocationSerializer locationSerializer, ADBInterAppService aDBInterAppService) {
        this.logChannel = logChannel;
        this.adbRemoteHMIService2 = aDBRemoteHMIService;
        this.locationSerializer2 = locationSerializer;
        this.adbInterAppService2 = aDBInterAppService;
    }

    public NavLocation extractGeoCoordinates(int n, int n2, NavigationEnv navigationEnv) {
        this.logChannel.log(10000000, "GeoCoordinatesADB#extractGeoCoordinates: Called with targetModelID '%1' and targetRow '%2'", (long)n, (long)n2);
        BaseListModelApp baseListModelApp = navigationEnv.getHMIService().getBaseListModel(n);
        EvoListRow evoListRow = baseListModelApp.getRow(n2);
        ADBRemoteHMIService aDBRemoteHMIService = this.adbRemoteHMIService2;
        if (aDBRemoteHMIService == null) {
            this.logChannel.log(100000, "GeoCoordinatesADB#extractGeoCoordinates: ADBRemoteHMIService is null");
            return null;
        }
        ADBRemoteHMIAddress aDBRemoteHMIAddress = aDBRemoteHMIService.getAddress(evoListRow);
        NavLocation navLocation = null;
        if (aDBRemoteHMIAddress == null) {
            this.logChannel.log(100000, "GeoCoordinatesADB#extractGeoCoordinates: ADBRemoteHMIAddress retrieved is null");
            return null;
        }
        byte[] byArray = aDBRemoteHMIAddress.getNavLocation();
        if (aDBRemoteHMIAddress.isNavLocation() && byArray != null) {
            LocationSerializer locationSerializer = this.locationSerializer2;
            navLocation = locationSerializer.streamToLocation(byArray);
        } else {
            String[] stringArray = aDBRemoteHMIAddress.getGeoPos();
            if (stringArray != null) {
                int n3 = Util.degreeStringToWgs84(stringArray[0]);
                int n4 = Util.degreeStringToWgs84(stringArray[1]);
                ADBInterAppService aDBInterAppService = this.adbInterAppService2;
                navLocation = aDBInterAppService.resolveGeoCoordsNavLocation(n3, n4);
            }
        }
        return navLocation;
    }
}

