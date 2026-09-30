/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.tmc.TmcMessage;

public interface DSICombinedRouteListReply {
    public static final String IPL_COMM_UUID = "fc4f32e5-c610-5f8f-b354-15f3e219f8d2";
    public static final String IPL_COMM_INTERFACE_KEY = "643fcaa1-9066-5b01-b59d-a05810f472eb";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.71";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.71";

    public void windowChanged(int var1) throws MethodException;

    public void combinedRouteListResult(long var1, CombinedRouteListElement[] var3, int var4) throws MethodException;

    public void trafficInformationResult(TmcMessage var1, int var2) throws MethodException;

    public void poiInformationResult(NavPoiInfo var1, int var2) throws MethodException;

    public void updateElementsTotal(long var1, long var3, int var5) throws MethodException;

    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] var1, NavRectangle var2) throws MethodException;

    public void requestPriceInfoResult(NavPriceInfo var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

