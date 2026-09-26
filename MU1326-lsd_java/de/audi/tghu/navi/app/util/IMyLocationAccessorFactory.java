/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;

public interface IMyLocationAccessorFactory {
    default public IMyLocationAccessor createLocationAccessorFromGeoPos(int n, int n2) {
    }

    default public IMyLocationAccessor cloneLocationAccessor(IMyLocationAccessor iMyLocationAccessor) {
    }

    default public IMyLocationAccessor fromLocation(NavLocation navLocation) {
    }

    default public NavLocation toLocation(IMyLocationAccessor iMyLocationAccessor) {
    }

    default public IMyLocationAccessor fromTraceId(NavSegmentID navSegmentID) {
    }
}

