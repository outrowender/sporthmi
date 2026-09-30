/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bluetooth;

import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class TelDefaultBluetoothListener
implements DSIBluetoothListener {
    public void asyncException(int n, String string, int n2) {
    }

    public void responseAbortConnectService(int n) {
    }

    public void responseAbortInquiry(int n) {
    }

    public void responseAcceptIncomingServiceRequest(int n) {
    }

    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
    }

    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
    }

    public void responseDisconnectService(String string, int n, int n2) {
    }

    public void responseGetServices(String string, String string2, int n, int n2) {
    }

    public void responseInquiry(int n, int n2) {
    }

    public void responsePasskeyResponse(String string, String string2, int n) {
    }

    public void responseRemoveAuthentication(String string, String string2, int n) {
    }

    public void responseRestoreFactorySettings(int n) {
    }

    public void responseSetA2DPUserSetting(int n) {
    }

    public void responseSwitchBTState(int n) {
    }

    public void removeAuthenticationNoSupport(String string, String string2) {
    }

    public void updateAccessibleMode(int n, boolean bl, int n2) {
    }

    public void updateBTState(int n, int n2) {
    }

    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
    }

    public void updateHUCandBTHSState(int n, int n2) {
    }

    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
    }

    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
    }

    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
    }

    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
    }

    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
    }

    public void updateSupportedBTProfiles(int n, int n2) {
    }

    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
    }

    public void updateUserFriendlyName(String string, int n) {
    }

    public void updateA2DPUserSetting(boolean bl, int n) {
    }

    public void deviceDisonnectionInfo(String string, String string2, int n) {
    }

    public void serviceRejectNoSupport(String string, String string2) {
    }

    public void responseReconnectSuspend(int n) {
    }

    public void responseSetPriorizedDeviceReconnect(int n) {
    }

    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
    }

    public void responseSetAccessibleMode(int n) {
    }
}

