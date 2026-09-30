/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public interface DSIBluetoothReply {
    public static final String IPL_COMM_UUID = "34b09f77-0209-59b5-b249-c330b33effb4";
    public static final String IPL_COMM_INTERFACE_KEY = "ad7487e6-9b49-5fc8-9838-2ae2d9bc0388";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.13";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.13";

    public void responseAbortConnectService(int var1) throws MethodException;

    public void responseAbortInquiry(int var1) throws MethodException;

    public void responseAcceptIncomingServiceRequest(int var1) throws MethodException;

    public void responseConnectService(String var1, String var2, int var3, int var4, int var5) throws MethodException;

    public void responseConnectServiceToInstance(String var1, String var2, int var3, int var4, int var5) throws MethodException;

    public void responseDisconnectService(String var1, int var2, int var3) throws MethodException;

    public void responseGetServices(String var1, String var2, int var3, int var4) throws MethodException;

    public void responseInquiry(int var1, int var2) throws MethodException;

    public void responsePasskeyResponse(String var1, String var2, int var3) throws MethodException;

    public void responseRemoveAuthentication(String var1, String var2, int var3) throws MethodException;

    public void responseRestoreFactorySettings(int var1) throws MethodException;

    public void responseSetA2DPUserSetting(int var1) throws MethodException;

    public void responseSetAccessibleMode(int var1) throws MethodException;

    public void responseSwitchBTState(int var1) throws MethodException;

    public void removeAuthenticationNoSupport(String var1, String var2) throws MethodException;

    public void updateAccessibleMode(int var1, boolean var2, int var3) throws MethodException;

    public void updateBTState(int var1, int var2) throws MethodException;

    public void updateDiscoveredDevices(DiscoveredDevice var1, int var2) throws MethodException;

    public void updateHUCandBTHSState(int var1, int var2) throws MethodException;

    public void updateIncomingServiceRequest(RequestIncomingService var1, int var2) throws MethodException;

    public void updateMasterRoleRequestError(MasterRoleRequestStruct var1, int var2) throws MethodException;

    public void updatePasskeyState(PasskeyStateStruct var1, int var2) throws MethodException;

    public void updateReconnectIndicator(ReconnectInfo var1, int var2) throws MethodException;

    public void updateServiceRequestState(ServiceRequestStateStruct var1, int var2) throws MethodException;

    public void updateSupportedBTProfiles(int var1, int var2) throws MethodException;

    public void updateTrustedDevices(TrustedDevice[] var1, int var2) throws MethodException;

    public void updateUserFriendlyName(String var1, int var2) throws MethodException;

    public void updateA2DPUserSetting(boolean var1, int var2) throws MethodException;

    public void updatePriorizedDeviceReconnect(boolean var1, String var2, int var3) throws MethodException;

    public void deviceDisonnectionInfo(String var1, String var2, int var3) throws MethodException;

    public void serviceRejectNoSupport(String var1, String var2) throws MethodException;

    public void responseReconnectSuspend(int var1) throws MethodException;

    public void responseSetPriorizedDeviceReconnect(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

