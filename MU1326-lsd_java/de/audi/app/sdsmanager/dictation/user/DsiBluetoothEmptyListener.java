/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.user;

import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

class DsiBluetoothEmptyListener
implements DSIBluetoothListener {
    DsiBluetoothEmptyListener() {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void responseAbortConnectService(int n) {
    }

    @Override
    public void responseAbortInquiry(int n) {
    }

    @Override
    public void responseAcceptIncomingServiceRequest(int n) {
    }

    @Override
    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
    }

    @Override
    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
    }

    @Override
    public void responseDisconnectService(String string, int n, int n2) {
    }

    @Override
    public void responseGetServices(String string, String string2, int n, int n2) {
    }

    @Override
    public void responseInquiry(int n, int n2) {
    }

    @Override
    public void responsePasskeyResponse(String string, String string2, int n) {
    }

    @Override
    public void responseRemoveAuthentication(String string, String string2, int n) {
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
    }

    @Override
    public void responseSetA2DPUserSetting(int n) {
    }

    @Override
    public void responseSwitchBTState(int n) {
    }

    @Override
    public void removeAuthenticationNoSupport(String string, String string2) {
    }

    @Override
    public void updateAccessibleMode(int n, boolean bl, int n2) {
    }

    @Override
    public void updateBTState(int n, int n2) {
    }

    @Override
    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
    }

    @Override
    public void updateHUCandBTHSState(int n, int n2) {
    }

    @Override
    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
    }

    @Override
    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
    }

    @Override
    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
    }

    @Override
    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
    }

    @Override
    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
    }

    @Override
    public void updateSupportedBTProfiles(int n, int n2) {
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
    }

    @Override
    public void updateUserFriendlyName(String string, int n) {
    }

    @Override
    public void updateA2DPUserSetting(boolean bl, int n) {
    }

    @Override
    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
    }

    @Override
    public void deviceDisonnectionInfo(String string, String string2, int n) {
    }

    @Override
    public void serviceRejectNoSupport(String string, String string2) {
    }

    @Override
    public void responseReconnectSuspend(int n) {
    }

    @Override
    public void responseSetPriorizedDeviceReconnect(int n) {
    }

    @Override
    public void responseSetAccessibleMode(int n) {
    }
}

