/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.util;

import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.remotehmi.RemoteHMILocation;
import org.dsi.ifc.global.NavLocation;

public class NavUtil {
    public static RemoteHMILocation getRemoteLocationFromNavLocation(IMyLocationAccessor iMyLocationAccessor) {
        double d2 = NavigationUtilities.wgs84ToDegree(iMyLocationAccessor.getLatitude());
        double d3 = NavigationUtilities.wgs84ToDegree(iMyLocationAccessor.getLongitude());
        RemoteHMILocation remoteHMILocation = new RemoteHMILocation();
        remoteHMILocation.setCountry(iMyLocationAccessor.getCountry());
        remoteHMILocation.setCountryAbbreviation(iMyLocationAccessor.getCountryAbbreviation());
        remoteHMILocation.setTown(iMyLocationAccessor.getTown());
        remoteHMILocation.setStreet(iMyLocationAccessor.getStreet());
        remoteHMILocation.setHouseNumber(iMyLocationAccessor.getHousenumber());
        remoteHMILocation.setState(iMyLocationAccessor.getState());
        remoteHMILocation.setLatitude(d2);
        remoteHMILocation.setLongitude(d3);
        return remoteHMILocation;
    }

    public static RemoteHMILocation getRemoteLocationFromNavLocation(NavLocation navLocation) {
        double d2 = NavigationUtilities.wgs84ToDegree(navLocation.latitude);
        double d3 = NavigationUtilities.wgs84ToDegree(navLocation.longitude);
        RemoteHMILocation remoteHMILocation = new RemoteHMILocation();
        remoteHMILocation.setCountry(navLocation.getCountry());
        remoteHMILocation.setCountryAbbreviation(navLocation.getCountryAbbreviation());
        remoteHMILocation.setTown(navLocation.getTown());
        remoteHMILocation.setStreet(navLocation.getStreet());
        remoteHMILocation.setHouseNumber(navLocation.getHousenumber());
        remoteHMILocation.setLatitude(d2);
        remoteHMILocation.setLongitude(d3);
        return remoteHMILocation;
    }
}

