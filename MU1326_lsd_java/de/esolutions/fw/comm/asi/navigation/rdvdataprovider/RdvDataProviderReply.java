/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvRouteOptions;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocationWgs84;

public interface RdvDataProviderReply {
    public static final String IPL_COMM_UUID = "3ee92857-84ba-4dfa-9faf-1d67977f4b5d";
    public static final String IPL_COMM_INTERFACE_KEY = "0b921357-9ff8-587c-9c54-67ccfc58e880";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.6";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.6";

    public void registerForDataUpdateResult(int var1) throws MethodException;

    public void unregisterForDataUpdateResult(int var1) throws MethodException;

    public void updateDemoModeStatus(boolean var1) throws MethodException;

    public void updateRouteGuidanceStatus(boolean var1) throws MethodException;

    public void updateCurrentRouteOptions(RdvRouteOptions var1) throws MethodException;

    public void updateCurrentRoute(NavLocationWgs84[] var1) throws MethodException;

    public void updateStopovers(NavLocationWgs84[] var1) throws MethodException;

    public void setRouteProviderSettingResult(RouteProviderSetting var1, int var2) throws MethodException;

    public void getCurrentPositionResult(NavLocationWgs84 var1) throws MethodException;
}

