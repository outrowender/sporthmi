/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.map.handler.MapUserFlag;
import de.audi.tghu.navi.app.map.utils.MapArrayUtils;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;

public class MapFlagUtils {
    protected static LogChannel sLogChannel;
    public static volatile Object sUserFlagsMutex;

    private static LogChannel getLogChannel() {
        return sLogChannel;
    }

    public static void setLogChannel(LogChannel logChannel) {
        sLogChannel = logChannel;
    }

    public static MapFlag convertAdbEntryToTopDestBusiness(AdbEntry adbEntry, LocationSerializer locationSerializer) {
        if (adbEntry == null) {
            return null;
        }
        MapFlag mapFlag = null;
        AddressData addressData = MapUtils.extractAddressDataOfEntryType(adbEntry.getAddressData(), 1);
        if (addressData != null) {
            NavLocation navLocation = locationSerializer.streamToLocation(addressData.getNavLocation());
            MapFlagUtils.getLogChannel().log(14808325, "MapFlagUtils#convertAdbEntryToTopDestBusiness: loc = %1", (Object)navLocation);
            mapFlag = new MapFlag(navLocation.getLongitude(), navLocation.getLatitude(), 1, -1L);
            MapFlagUtils.getLogChannel().log(14808325, "MapFlagUtils#convertAdbEntryToTopDestBusiness: mf = %1", (Object)mapFlag);
        }
        return mapFlag;
    }

    public static MapFlag convertAdbEntryToTopDestPrivate(AdbEntry adbEntry, LocationSerializer locationSerializer) {
        if (adbEntry == null) {
            return null;
        }
        MapFlag mapFlag = null;
        AddressData addressData = MapUtils.extractAddressDataOfEntryType(adbEntry.getAddressData(), 2);
        if (addressData != null) {
            NavLocation navLocation = locationSerializer.streamToLocation(addressData.getNavLocation());
            MapFlagUtils.getLogChannel().log(14808325, "MapFlagUtils#convertAdbEntryToTopDestPrivate: loc = %1", (Object)navLocation);
            mapFlag = new MapFlag(navLocation.getLongitude(), navLocation.getLatitude(), 0, -1L);
            MapFlagUtils.getLogChannel().log(14808325, "MapFlagUtils#convertAdbEntryToTopDestPrivate: mf = %1", (Object)mapFlag);
        }
        return mapFlag;
    }

    public static MapFlag clone(MapFlag mapFlag) {
        return new MapFlag(mapFlag.geoX, mapFlag.geoY, mapFlag.styleIndex, mapFlag.handle);
    }

    public static MapFlag[] getMapFlags(MapUserFlag[] mapUserFlagArray) {
        if (MapArrayUtils.isEmpty(mapUserFlagArray)) {
            return new MapFlag[0];
        }
        MapFlag[] mapFlagArray = new MapFlag[mapUserFlagArray.length];
        for (int i2 = 0; i2 < mapUserFlagArray.length; ++i2) {
            mapFlagArray[i2] = mapUserFlagArray[i2].mMapFlag;
        }
        return mapFlagArray;
    }

    public static MapUserFlag[] convert2MapUserFlags(OnlinePOIResultList onlinePOIResultList, int n) {
        MapUserFlag[] mapUserFlagArray = null;
        if (onlinePOIResultList != null && onlinePOIResultList.length() > 0) {
            int n2 = onlinePOIResultList.length();
            mapUserFlagArray = new MapUserFlag[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                MapFlag mapFlag = new MapFlag(onlinePOIResultList.getPOIElementAt((int)i2).longitude, onlinePOIResultList.getPOIElementAt((int)i2).latitude, onlinePOIResultList.getStyleTypeAt(i2), -1L);
                mapUserFlagArray[i2] = new MapUserFlag(mapFlag, i2, onlinePOIResultList.getPOIElementAt((int)i2).name, n);
            }
        }
        return mapUserFlagArray;
    }

    public static boolean isEqual(Object object, Object object2) {
        if (object == null && object2 == null) {
            return true;
        }
        if (object != null && object2 == null) {
            return false;
        }
        if (object == null && object2 != null) {
            return false;
        }
        return object.equals(object2);
    }

    public static MapUserFlag createUserFlag(MapFlag mapFlag, int n, String string) {
        return MapFlagUtils.createUserFlag(mapFlag, n, string, -1);
    }

    public static MapUserFlag createUserFlag(MapFlag mapFlag, int n, String string, int n2) {
        return new MapUserFlag(mapFlag, n, string, n2);
    }

    public static MapUserFlag[] convertResultListToUserFlags(OnlinePOIResultList onlinePOIResultList, int n) {
        if (onlinePOIResultList == null) {
            return null;
        }
        int n2 = onlinePOIResultList.length();
        MapUserFlag[] mapUserFlagArray = new MapUserFlag[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            MapFlag mapFlag = new MapFlag(onlinePOIResultList.getPOIElementAt((int)i2).longitude, onlinePOIResultList.getPOIElementAt((int)i2).latitude, onlinePOIResultList.getStyleTypeAt(i2), -1L);
            mapUserFlagArray[i2] = MapFlagUtils.createUserFlag(mapFlag, i2, onlinePOIResultList.getPOIElementAt((int)i2).name, n);
            MapFlagUtils.getLogChannel().log(14808325, "MapFlagUtils#convertResultListToUserFlags(): result[%2]=%1", (Object)mapUserFlagArray[i2], (long)i2);
        }
        return mapUserFlagArray;
    }

    public static MapFlag[] convertResultListToMapFlags(OnlinePOIResultList onlinePOIResultList) {
        if (onlinePOIResultList == null) {
            return null;
        }
        int n = onlinePOIResultList.length();
        MapFlag[] mapFlagArray = new MapFlag[n];
        for (int i2 = 0; i2 < n; ++i2) {
            mapFlagArray[i2] = new MapFlag(onlinePOIResultList.getPOIElementAt((int)i2).longitude, onlinePOIResultList.getPOIElementAt((int)i2).latitude, onlinePOIResultList.getStyleTypeAt(i2), -1L);
        }
        return mapFlagArray;
    }

    public static MapPin[] convertResultListToMapPins(OnlinePOIResultList onlinePOIResultList) {
        if (onlinePOIResultList == null) {
            return null;
        }
        int n = onlinePOIResultList.length();
        MapPin[] mapPinArray = new MapPin[n];
        for (int i2 = 0; i2 < n; ++i2) {
            mapPinArray[i2] = new MapPin(onlinePOIResultList.getPOIElementAt((int)i2).longitude, onlinePOIResultList.getPOIElementAt((int)i2).latitude, onlinePOIResultList.getStyleTypeAt(i2), i2, 2);
        }
        return mapPinArray;
    }

    public static MapUserFlag convertPicNavCoordinateToUserFlag(NavLocationWgs84 navLocationWgs84) {
        MapFlagUtils.getLogChannel().log(14808325, "MapFlagUtils#convertPicNavCoordinateToUserFlag(): picNavCoordinate: %1", (Object)navLocationWgs84);
        if (navLocationWgs84 == null) {
            return null;
        }
        MapFlag mapFlag = new MapFlag(navLocationWgs84.getLongitude(), navLocationWgs84.getLatitude(), 35, -1L);
        return MapFlagUtils.createUserFlag(mapFlag, -1, "");
    }

    static {
        sUserFlagsMutex = new Object();
    }
}

