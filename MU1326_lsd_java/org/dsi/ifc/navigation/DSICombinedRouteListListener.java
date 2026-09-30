/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.tmc.TmcMessage;

public interface DSICombinedRouteListListener
extends DSIListener {
    public void windowChanged(int var1);

    public void combinedRouteListResult(long var1, CombinedRouteListElement[] var3, int var4);

    public void trafficInformationResult(TmcMessage var1, int var2);

    public void poiInformationResult(NavPoiInfo var1, int var2);

    public void updateElementsTotal(long var1, long var3, int var5);

    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] var1, NavRectangle var2);

    public void requestPriceInfoResult(NavPriceInfo var1, int var2);
}

