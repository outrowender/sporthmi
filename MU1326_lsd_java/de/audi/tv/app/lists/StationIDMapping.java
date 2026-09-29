/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.lists.StationMapper;

class StationIDMapping {
    final long namePID;
    final int servicePID;
    final int sType;
    final long mappedID;

    StationIDMapping(long l, int n, int n2, long l2) {
        this.namePID = l;
        this.servicePID = n;
        this.sType = n2;
        this.mappedID = l2;
    }

    public boolean equals(Object object) {
        if (object instanceof StationIDMapping) {
            return this.namePID == ((StationIDMapping)object).namePID && this.servicePID == ((StationIDMapping)object).servicePID && this.sType == ((StationIDMapping)object).sType;
        }
        return false;
    }

    boolean equalsNamePID(StationIDMapping stationIDMapping) {
        if (stationIDMapping == null) {
            return false;
        }
        return this.namePID == stationIDMapping.namePID;
    }

    public int hashCode() {
        return StationMapper.getCombiID(this.mappedID);
    }
}

