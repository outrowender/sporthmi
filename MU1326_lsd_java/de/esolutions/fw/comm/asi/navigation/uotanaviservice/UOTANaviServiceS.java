/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.UOTANaviServiceReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface UOTANaviServiceS {
    public void registerClient(int var1, UOTANaviServiceReply var2) throws MethodException;

    public void respondVersionInfo(short var1, ComponentInfo[] var2, int var3, UOTANaviServiceReply var4) throws MethodException;
}

