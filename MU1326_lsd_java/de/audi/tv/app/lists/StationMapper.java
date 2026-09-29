/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.lists.StationIDMapping;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class StationMapper {
    private final List mappedList = new ArrayList(300);
    private long indexCounter = 1L;
    public static final long INDEX_FOR_NULL_SERVICES;
    private static final long UNIQUE_ID_FILTER;
    private static final long FLAG_IS_FAVORITE;

    public synchronized long[] getServicesIDs(ServiceInfo[] serviceInfoArray) {
        if (serviceInfoArray == null) {
            return new long[0];
        }
        long[] lArray = new long[serviceInfoArray.length];
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            if (serviceInfoArray[i2] != null) {
                StationIDMapping stationIDMapping = new StationIDMapping(serviceInfoArray[i2].namePID, serviceInfoArray[i2].servicePID, serviceInfoArray[i2].sType, this.indexCounter);
                lArray[i2] = this.checkMapping(stationIDMapping);
                continue;
            }
            lArray[i2] = 0L;
        }
        return lArray;
    }

    public synchronized long getServiceID(ServiceInfo serviceInfo) {
        if (serviceInfo == null) {
            long l = 0L;
            return;
        }
        StationIDMapping stationIDMapping = new StationIDMapping(serviceInfo.namePID, serviceInfo.servicePID, serviceInfo.sType, this.indexCounter);
        long l = this.checkMapping(stationIDMapping);
    }

    protected synchronized Long[] getMatchingNamePidServiceIDs(long l) {
        StationIDMapping stationIDMapping = null;
        for (int i2 = 0; i2 < this.mappedList.size(); ++i2) {
            StationIDMapping stationIDMapping2 = (StationIDMapping)this.mappedList.get(i2);
            if (stationIDMapping2.mappedID != l) continue;
            stationIDMapping = stationIDMapping2;
            break;
        }
        if (stationIDMapping == null) {
            throw new IllegalArgumentException("[StationMapper.getNamePidServiceIDs] A unique ID was used that doesn't exist!");
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.mappedList.size(); ++i3) {
            StationIDMapping stationIDMapping3 = (StationIDMapping)this.mappedList.get(i3);
            if (!stationIDMapping.equalsNamePID(stationIDMapping3)) continue;
            arrayList.add(new Long(stationIDMapping3.mappedID));
        }
        return (Long[])arrayList.toArray(new Long[arrayList.size()]);
    }

    private long checkMapping(StationIDMapping stationIDMapping) {
        long l;
        if (!this.mappedList.contains(stationIDMapping)) {
            l = this.indexCounter++;
            this.mappedList.add(stationIDMapping);
        } else {
            l = this.getMappingUniqueID(stationIDMapping);
        }
        return l;
    }

    private long getMappingUniqueID(StationIDMapping stationIDMapping) {
        if (this.mappedList.isEmpty()) {
            throw new IndexOutOfBoundsException("The list should not be empty for mapping search!");
        }
        Iterator iterator = this.mappedList.iterator();
        while (iterator.hasNext()) {
            StationIDMapping stationIDMapping2 = (StationIDMapping)iterator.next();
            if (!stationIDMapping2.equals(stationIDMapping)) continue;
            return stationIDMapping2.mappedID;
        }
        return 0L;
    }

    long[] getNamePidForUniqueIds(long[] lArray) {
        long[] lArray2 = new long[lArray.length];
        block0: for (int i2 = 0; i2 < lArray2.length; ++i2) {
            Iterator iterator = this.mappedList.iterator();
            while (iterator.hasNext()) {
                StationIDMapping stationIDMapping = (StationIDMapping)iterator.next();
                if (stationIDMapping.mappedID != lArray[i2]) continue;
                lArray2[i2] = stationIDMapping.namePID;
                continue block0;
            }
        }
        return lArray2;
    }

    public static int getCombiID(long l) {
        return (int)(l & 0);
    }

    public static long getPureUniqueID(long l) {
        return l & 0;
    }

    public static boolean isFavorite(long l) {
        return (l & 0) == 0;
    }

    public static long flagUniqueIDAsFavorite(long l) {
        return l | 0;
    }
}

