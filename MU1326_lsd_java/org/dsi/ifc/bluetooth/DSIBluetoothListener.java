/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public interface DSIBluetoothListener
extends DSIListener {
    public void responseAbortConnectService(int var1);

    public void responseAbortInquiry(int var1);

    public void responseAcceptIncomingServiceRequest(int var1);

    public void responseConnectService(String var1, String var2, int var3, int var4, int var5);

    public void responseConnectServiceToInstance(String var1, String var2, int var3, int var4, int var5);

    public void responseDisconnectService(String var1, int var2, int var3);

    public void responseGetServices(String var1, String var2, int var3, int var4);

    public void responseInquiry(int var1, int var2);

    public void responsePasskeyResponse(String var1, String var2, int var3);

    public void responseRemoveAuthentication(String var1, String var2, int var3);

    public void responseRestoreFactorySettings(int var1);

    public void responseSetA2DPUserSetting(int var1);

    public void responseSetAccessibleMode(int var1);

    public void responseSwitchBTState(int var1);

    public void removeAuthenticationNoSupport(String var1, String var2);

    public void updateAccessibleMode(int var1, boolean var2, int var3);

    public void updateBTState(int var1, int var2);

    public void updateDiscoveredDevices(DiscoveredDevice var1, int var2);

    public void updateHUCandBTHSState(int var1, int var2);

    public void updateIncomingServiceRequest(RequestIncomingService var1, int var2);

    public void updateMasterRoleRequestError(MasterRoleRequestStruct var1, int var2);

    public void updatePasskeyState(PasskeyStateStruct var1, int var2);

    public void updateReconnectIndicator(ReconnectInfo var1, int var2);

    public void updateServiceRequestState(ServiceRequestStateStruct var1, int var2);

    public void updateSupportedBTProfiles(int var1, int var2);

    public void updateTrustedDevices(TrustedDevice[] var1, int var2);

    public void updateUserFriendlyName(String var1, int var2);

    public void updateA2DPUserSetting(boolean var1, int var2);

    public void updatePriorizedDeviceReconnect(boolean var1, String var2, int var3);

    public void deviceDisonnectionInfo(String var1, String var2, int var3);

    public void serviceRejectNoSupport(String var1, String var2);

    public void responseReconnectSuspend(int var1);

    public void responseSetPriorizedDeviceReconnect(int var1);
}

