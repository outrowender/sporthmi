/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import org.dsi.ifc.global.NavSegmentID;

public final class RouteListData
implements Comparable {
    public final String name;
    public final long id;
    public final int memoryId;
    public final NavSegmentID segmentId;

    public RouteListData(String string, long l, int n) {
        this.name = string;
        this.id = l;
        this.memoryId = n;
        this.segmentId = null;
    }

    public RouteListData(String string, NavSegmentID navSegmentID) {
        this.name = string;
        this.id = -1L;
        this.memoryId = -1;
        this.segmentId = navSegmentID;
    }

    public int compareTo(Object object) {
        if (object == null) {
            return 0;
        }
        if (object == this) {
            return 0;
        }
        if (this.getClass() != object.getClass()) {
            return 0;
        }
        return this.name.compareTo(((RouteListData)object).name);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (int)(this.id ^ this.id >>> 32);
        n = 31 * n + (this.name == null ? 0 : this.name.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        RouteListData routeListData = (RouteListData)object;
        if (this.memoryId != routeListData.memoryId) {
            return false;
        }
        if (this.id != routeListData.id) {
            return false;
        }
        if (this.segmentId != routeListData.segmentId) {
            return false;
        }
        return !(this.name == null ? routeListData.name != null : !this.name.equals(routeListData.name));
    }
}

