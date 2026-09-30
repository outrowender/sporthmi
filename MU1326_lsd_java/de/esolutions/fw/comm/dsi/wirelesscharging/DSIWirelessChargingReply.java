/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.wirelesscharging;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIWirelessChargingReply {
    public static final String IPL_COMM_UUID = "a48e6ab6-c735-5b71-aa35-583b9ab06e12";
    public static final String IPL_COMM_INTERFACE_KEY = "ed994bd0-c68b-5fe2-9542-a5fa78f087a8";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public void updateChargingInfo(int var1, int var2) throws MethodException;

    public void updateBatteryLevel(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

