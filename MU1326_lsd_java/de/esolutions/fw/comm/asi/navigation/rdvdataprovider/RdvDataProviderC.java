/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.core.method.MethodException;

public interface RdvDataProviderC {
    public void registerForDataUpdate() throws MethodException;

    public void unregisterForDataUpdate() throws MethodException;

    public void setRouteProviderSetting(RouteProviderSetting var1) throws MethodException;

    public void getCurrentPosition() throws MethodException;
}

