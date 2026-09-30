/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface UOTANaviServiceC {
    public void registerClient(int var1) throws MethodException;

    public void respondVersionInfo(short var1, ComponentInfo[] var2, int var3) throws MethodException;
}

