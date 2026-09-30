/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RdvDataProviderReply;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.core.method.MethodException;

public interface RdvDataProviderS {
    public void registerForDataUpdate(RdvDataProviderReply var1) throws MethodException;

    public void unregisterForDataUpdate(RdvDataProviderReply var1) throws MethodException;

    public void setRouteProviderSetting(RouteProviderSetting var1, RdvDataProviderReply var2) throws MethodException;

    public void getCurrentPosition(RdvDataProviderReply var1) throws MethodException;
}

