/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation.util;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.util.ILocationAccessor;

public interface ILocationAccessorFactory {
    public ILocationAccessor createLocationAccessorFromGeoPos(int var1, int var2);

    public ILocationAccessor cloneLocationAccessor(ILocationAccessor var1);

    public ILocationAccessor fromLocation(NavLocation var1);

    public NavLocation toLocation(ILocationAccessor var1);

    public ILocationAccessor fromTraceId(NavSegmentID var1);
}

