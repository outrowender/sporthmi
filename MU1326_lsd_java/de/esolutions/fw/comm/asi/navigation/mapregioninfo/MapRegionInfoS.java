/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfoReply;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;

public interface MapRegionInfoS {
    public void requestGetDatabaseInfo(NavLocationWgs84 var1, int var2, MapRegionInfoReply var3) throws MethodException;

    public void requestGetMultipleDatabaseInfo(NavLocationWgs84[] var1, int var2, MapRegionInfoReply var3) throws MethodException;

    public void requestGetRegionsInVicinity(NavRectangle var1, int var2, MapRegionInfoReply var3) throws MethodException;
}

