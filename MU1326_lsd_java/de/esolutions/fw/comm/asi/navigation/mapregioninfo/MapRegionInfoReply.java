/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MapRegionInfoReply {
    public static final String IPL_COMM_UUID = "f6ed3bd2-c174-4a4c-a99f-5ca2e73a72e5";
    public static final String IPL_COMM_INTERFACE_KEY = "ea59591a-319c-5eba-8c59-1bc981eda986";
    public static final String IPL_COMM_INTERFACE_VERSION = "0.0.3";
    public static final String IPL_COMM_MODULE_VERSION = "0.0.3";

    public void replyGetDatabaseInfo(int var1, ComponentInfo var2, int var3) throws MethodException;

    public void replyGetMultipleDatabaseInfo(int var1, ComponentInfo[] var2, int var3) throws MethodException;

    public void replyGetRegionsInVicinity(int var1, ComponentInfo[] var2, int var3) throws MethodException;
}

