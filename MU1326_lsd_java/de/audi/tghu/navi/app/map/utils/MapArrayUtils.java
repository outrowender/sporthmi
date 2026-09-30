/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.handler.MapUserFlag;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.map.MapFlag;

public class MapArrayUtils {
    protected static LogChannel sLogChannel;

    private static LogChannel getLogChannel() {
        return sLogChannel;
    }

    public static void setLogChannel(LogChannel logChannel) {
        sLogChannel = logChannel;
    }

    public static boolean isEmpty(int[] nArray) {
        return nArray == null || nArray.length == 0;
    }

    public static boolean isEmpty(Object[] objectArray) {
        return objectArray == null || objectArray.length == 0;
    }

    public static boolean isNotEmpty(Object[] objectArray) {
        return !MapArrayUtils.isEmpty(objectArray);
    }

    public static String toString(boolean[] blArray) {
        Buffer buffer = new Buffer();
        buffer.append("[");
        if (blArray != null && blArray.length > 0) {
            for (int i2 = 0; i2 < blArray.length; ++i2) {
                if (i2 > 0) {
                    buffer.append(", ");
                }
                buffer.append(blArray[i2]);
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static String toString(int[] nArray) {
        Buffer buffer = new Buffer();
        buffer.append("[");
        if (nArray != null && nArray.length > 0) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (i2 > 0) {
                    buffer.append(", ");
                }
                buffer.append(nArray[i2]);
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static MapUserFlag[] clearFlagsByStyle(MapUserFlag[] mapUserFlagArray, int n) {
        if (mapUserFlagArray == null) {
            return null;
        }
        int n2 = 0;
        for (int i2 = 0; i2 < mapUserFlagArray.length; ++i2) {
            if (mapUserFlagArray[i2].mMapFlag.getStyleIndex() == n) continue;
            ++n2;
        }
        MapUserFlag[] mapUserFlagArray2 = new MapUserFlag[n2];
        int n3 = 0;
        for (int i3 = 0; i3 < mapUserFlagArray.length; ++i3) {
            if (mapUserFlagArray[i3].mMapFlag.getStyleIndex() == n) continue;
            mapUserFlagArray2[n3++] = mapUserFlagArray[i3];
        }
        return mapUserFlagArray2;
    }

    public static MapUserFlag[] clearFlagsByType(MapUserFlag[] mapUserFlagArray, int n) {
        if (mapUserFlagArray == null) {
            return mapUserFlagArray;
        }
        if (n != 0 && n != 1) {
            MapArrayUtils.getLogChannel().log(100000, "MapArrayUtils#clearFlagsOfType() - invalid flag type: %1", (long)n);
            return mapUserFlagArray;
        }
        int n2 = 0;
        for (int i2 = 0; i2 < mapUserFlagArray.length; ++i2) {
            if (n == 0 && MapUtils.isOnlinePOIUserFlag(mapUserFlagArray[i2])) {
                ++n2;
                continue;
            }
            if (n != 1 || !MapUtils.isRemoteHMIUserFlag(mapUserFlagArray[i2])) continue;
            ++n2;
        }
        if (n2 == 0) {
            return mapUserFlagArray;
        }
        MapUserFlag[] mapUserFlagArray2 = new MapUserFlag[mapUserFlagArray.length - n2];
        int n3 = 0;
        for (int i3 = 0; i3 < mapUserFlagArray.length; ++i3) {
            if (n == 0 && !MapUtils.isOnlinePOIUserFlag(mapUserFlagArray[i3])) {
                mapUserFlagArray2[n3++] = mapUserFlagArray[i3];
                continue;
            }
            if (n != 1 || MapUtils.isRemoteHMIUserFlag(mapUserFlagArray[i3])) continue;
            mapUserFlagArray2[n3++] = mapUserFlagArray[i3];
        }
        return mapUserFlagArray2;
    }

    public static MapUserFlag[] concatenate(MapUserFlag[] mapUserFlagArray, MapUserFlag[] mapUserFlagArray2) {
        return MapArrayUtils.concatenate(mapUserFlagArray, mapUserFlagArray2, null);
    }

    public static MapUserFlag[] concatenate(MapUserFlag[] mapUserFlagArray, MapUserFlag[] mapUserFlagArray2, MapUserFlag mapUserFlag) {
        int n;
        int n2 = mapUserFlagArray == null ? 0 : mapUserFlagArray.length;
        n2 += mapUserFlagArray2 == null ? 0 : mapUserFlagArray2.length;
        if ((n2 += mapUserFlag == null ? 0 : 1) == 0) {
            return null;
        }
        MapUserFlag[] mapUserFlagArray3 = new MapUserFlag[n2];
        int n3 = 0;
        if (mapUserFlagArray != null && mapUserFlagArray.length > 0) {
            for (n = 0; n < mapUserFlagArray.length; ++n) {
                mapUserFlagArray3[n3++] = mapUserFlagArray[n];
            }
        }
        if (mapUserFlagArray2 != null && mapUserFlagArray2.length > 0) {
            for (n = 0; n < mapUserFlagArray2.length; ++n) {
                mapUserFlagArray3[n3++] = mapUserFlagArray2[n];
            }
        }
        if (mapUserFlag != null) {
            mapUserFlagArray3[n3] = mapUserFlag;
        }
        return mapUserFlagArray3;
    }

    public static MapPin[] concatenate(MapPin mapPin, MapPin[] mapPinArray, MapPin[] mapPinArray2) {
        int n;
        int n2 = (mapPin == null ? 0 : 1) + (MapArrayUtils.isEmpty(mapPinArray) ? 0 : mapPinArray.length) + (MapArrayUtils.isEmpty(mapPinArray2) ? 0 : mapPinArray2.length);
        MapPin[] mapPinArray3 = new MapPin[n2];
        MapArrayUtils.getLogChannel().log(100000000, "MapArrayUtils#concatenate() - result length: %1", (long)mapPinArray3.length);
        int n3 = 0;
        if (mapPin != null) {
            mapPinArray3[n3++] = mapPin;
        }
        if (MapArrayUtils.isNotEmpty(mapPinArray)) {
            n = 0;
            while (n < mapPinArray.length) {
                mapPinArray3[n3] = mapPinArray[n];
                ++n;
                ++n3;
            }
        }
        if (MapArrayUtils.isNotEmpty(mapPinArray2)) {
            n = 0;
            while (n < mapPinArray2.length) {
                mapPinArray3[n3] = mapPinArray2[n];
                ++n;
                ++n3;
            }
        }
        return mapPinArray3;
    }

    public static MapUserFlag[] clearPOIOnlineFlags(MapUserFlag[] mapUserFlagArray) {
        return MapArrayUtils.clearFlagsByType(mapUserFlagArray, 0);
    }

    public static MapUserFlag[] clearRemoteHMIFlags(MapUserFlag[] mapUserFlagArray) {
        return MapArrayUtils.clearFlagsByType(mapUserFlagArray, 1);
    }

    public static MapUserFlag[] clearPicNavFlag(MapUserFlag[] mapUserFlagArray) {
        if (mapUserFlagArray == null) {
            return mapUserFlagArray;
        }
        boolean bl = false;
        for (int i2 = 0; i2 < mapUserFlagArray.length; ++i2) {
            if (!MapUtils.isPicNavFlag(mapUserFlagArray[i2])) continue;
            bl = true;
            break;
        }
        if (!bl) {
            return mapUserFlagArray;
        }
        MapUserFlag[] mapUserFlagArray2 = new MapUserFlag[mapUserFlagArray.length - 1];
        int n = 0;
        boolean bl2 = false;
        for (int i3 = 0; i3 < mapUserFlagArray.length; ++i3) {
            if (bl2 || !MapUtils.isPicNavFlag(mapUserFlagArray[i3])) {
                mapUserFlagArray2[n++] = mapUserFlagArray[i3];
                continue;
            }
            bl2 = true;
        }
        return mapUserFlagArray2;
    }

    public static MapFlag[] diffUserFlagsForAdding(MapFlag[] mapFlagArray, MapFlag[] mapFlagArray2) {
        int n;
        if (mapFlagArray2 == null || mapFlagArray2.length == 0) {
            return new MapFlag[0];
        }
        if (mapFlagArray == null || mapFlagArray.length == 0) {
            return mapFlagArray2;
        }
        int n2 = mapFlagArray2.length;
        for (n = 0; n < mapFlagArray2.length; ++n) {
            if (MapArrayUtils.findEqualEntry(mapFlagArray2[n], mapFlagArray) == null) continue;
            --n2;
        }
        MapFlag[] mapFlagArray3 = new MapFlag[n2];
        int n3 = 0;
        for (n = 0; n < mapFlagArray2.length; ++n) {
            MapFlag mapFlag = MapArrayUtils.findEqualEntry(mapFlagArray2[n], mapFlagArray);
            if (mapFlag != null) continue;
            mapFlagArray3[n3++] = mapFlagArray2[n];
        }
        return mapFlagArray3;
    }

    public static MapFlag[] diffUserFlagsForRemoval(MapFlag[] mapFlagArray, MapFlag[] mapFlagArray2) {
        int n;
        if (mapFlagArray == null || mapFlagArray.length == 0) {
            return new MapFlag[0];
        }
        if (mapFlagArray2 == null || mapFlagArray2.length == 0) {
            return mapFlagArray;
        }
        int n2 = mapFlagArray.length;
        for (n = 0; n < mapFlagArray.length; ++n) {
            if (MapArrayUtils.findEqualEntry(mapFlagArray[n], mapFlagArray2) == null) continue;
            --n2;
        }
        MapFlag[] mapFlagArray3 = new MapFlag[n2];
        int n3 = 0;
        for (n = 0; n < mapFlagArray.length; ++n) {
            MapFlag mapFlag = MapArrayUtils.findEqualEntry(mapFlagArray[n], mapFlagArray2);
            if (mapFlag != null) continue;
            mapFlagArray3[n3++] = mapFlagArray[n];
        }
        return mapFlagArray3;
    }

    public static MapFlag findEqualEntry(MapFlag mapFlag, MapFlag[] mapFlagArray) {
        for (int i2 = 0; i2 < mapFlagArray.length; ++i2) {
            if (!MapUtils.isEqual(mapFlag, mapFlagArray[i2])) continue;
            return mapFlagArray[i2];
        }
        return null;
    }
}

