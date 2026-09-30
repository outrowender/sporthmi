/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;

public interface IMyLocationAccessorFactory {
    public IMyLocationAccessor createLocationAccessorFromGeoPos(int var1, int var2);

    public IMyLocationAccessor cloneLocationAccessor(IMyLocationAccessor var1);

    public IMyLocationAccessor fromLocation(NavLocation var1);

    public NavLocation toLocation(IMyLocationAccessor var1);

    public IMyLocationAccessor fromTraceId(NavSegmentID var1);
}

