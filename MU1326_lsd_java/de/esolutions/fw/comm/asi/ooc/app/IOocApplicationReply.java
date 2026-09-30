/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface IOocApplicationReply {
    public static final String IPL_COMM_UUID = "41a9d241-c39d-4427-aafb-b8d8cb9db3a5";
    public static final String IPL_COMM_INTERFACE_KEY = "60a20cee-c632-5bc3-8a99-ef22ee11b8a8";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.3.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.3.1";

    public void updatePowerState(long var1) throws MethodException;

    public void updateShutdownRequest(int var1) throws MethodException;

    public void updateClampSignal(boolean var1, boolean var2, boolean var3, boolean var4) throws MethodException;

    public void updateVoltageLevel(int var1) throws MethodException;

    public void updateRunMode(int var1) throws MethodException;

    public void updateCarLockSignal(boolean var1) throws MethodException;

    public void updatePowerOnPinStatus(boolean var1) throws MethodException;
}

