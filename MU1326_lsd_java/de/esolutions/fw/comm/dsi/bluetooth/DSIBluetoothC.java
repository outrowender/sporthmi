/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIBluetoothC {
    public void abortConnectService(String var1) throws MethodException;

    public void abortInquiry() throws MethodException;

    public void requestAcceptIncomingServiceRequest(String var1, int var2, boolean var3) throws MethodException;

    public void requestConnectService(String var1, int var2, int var3) throws MethodException;

    public void requestConnectServiceToInstance(String var1, int var2, int var3) throws MethodException;

    public void requestDisconnectService(String var1, int var2) throws MethodException;

    public void requestGetServices(String var1) throws MethodException;

    public void requestInquiry(int var1, int var2, int var3) throws MethodException;

    public void requestPasskeyResponse(String var1, String var2, int var3) throws MethodException;

    public void requestReconnectSuspend(boolean var1) throws MethodException;

    public void requestRemoveAuthentication(String var1) throws MethodException;

    public void requestRestoreFactorySettings() throws MethodException;

    public void requestSetA2DPUserSetting(boolean var1) throws MethodException;

    public void requestSwitchBTState(int var1) throws MethodException;

    public void setAccessibleMode(int var1) throws MethodException;

    public void setUserFriendlyName(String var1) throws MethodException;

    public void requestSetPriorizedDeviceReconnect(boolean var1, String var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

