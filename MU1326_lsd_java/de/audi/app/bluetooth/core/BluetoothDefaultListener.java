/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

class BluetoothDefaultListener
implements DSIBluetoothListener {
    private LogChannel log;

    BluetoothDefaultListener(LogChannel logChannel) {
        this.log = logChannel;
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000000, "BluetoothDefaultListener#asyncException(): errorCode=%2, errorMsg=%1, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    public void deviceDisonnectionInfo(String string, String string2, int n) {
    }

    public void removeAuthenticationNoSupport(String string, String string2) {
    }

    public void serviceRejectNoSupport(String string, String string2) {
    }

    public void responseAbortConnectService(int n) {
        this.log.log(100000, "BluetoothDefaultListener#responseAbortConnectService(): Expected to be handled by a Command!");
    }

    public void responseAbortInquiry(int n) {
        this.log.log(100000, "BluetoothDefaultListener#responseAbortInquiry(): Expected to be handled by a Command!");
    }

    public void responseAcceptIncomingServiceRequest(int n) {
        this.log.log(100000, "BluetoothDefaultListener#responseAcceptIncomingServiceRequest(): Expected to be handled by a Command!");
    }

    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
        this.log.log(100000, "BluetoothDefaultListener#responseConnectService(): Expected to be handled by a Command!");
    }

    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
        this.log.log(100000, "BluetoothDefaultListener#responseConnectServiceToInstance(): Expected to be handled by a Command!");
    }

    public void responseDisconnectService(String string, int n, int n2) {
        this.log.log(100000, "BluetoothDefaultListener#responseDisconnectService(): Expected to be handled by a Command!");
    }

    public void responseGetServices(String string, String string2, int n, int n2) {
        this.log.log(100000, "BluetoothDefaultListener#responseGetServices(): Expected to be handled by a Command!");
    }

    public void responseInquiry(int n, int n2) {
        this.log.log(100000, "BluetoothDefaultListener#responseInquiry(): Expected to be handled by a Command!");
    }

    public void responsePasskeyResponse(String string, String string2, int n) {
        this.log.log(100000, "BluetoothDefaultListener#responsePasskeyResponse(): Expected to be handled by a Command!");
    }

    public void responseReconnectSuspend(int n) {
        this.log.log(100000, "BluetoothDefaultListener#responseReconnectSuspend(): Expected to be handled by a Command!");
    }

    public void responseRemoveAuthentication(String string, String string2, int n) {
        this.log.log(100000, "BluetoothDefaultListener#responseRemoveAuthentication(): Expected to be handled by a Command!");
    }

    public void responseRestoreFactorySettings(int n) {
        this.log.log(100000, "BluetoothDefaultListener#responseRestoreFactorySettings(): Expected to be handled by a Command!");
    }

    public void responseSetA2DPUserSetting(int n) {
        this.log.log(100000, "BluetoothDefaultListener#responseSetA2DPUserSetting(): Expected to be handled by a Command!");
    }

    public void responseSetPriorizedDeviceReconnect(int n) {
        this.log.log(100000, "BluetoothDefaultListener#responseSetPriorizedDeviceReconnect(): Expected to be handled by a Command!");
    }

    public void responseSwitchBTState(int n) {
        this.log.log(100000, "BluetoothDefaultListener#responseSwitchBTState(): Expected to be handled by a Command!");
    }

    public void responseSetAccessibleMode(int n) {
        this.log.log(100000, "BluetoothDefaultListener#responseSetAccessibleMode(): Expected to be handled by a Command!");
    }

    public void updateA2DPUserSetting(boolean bl, int n) {
        this.log.log(100000, "BluetoothDefaultListener#updateA2DPUserSetting(): Unexpected call (no notification)");
    }

    public void updateAccessibleMode(int n, boolean bl, int n2) {
        this.log.log(100000, "BluetoothDefaultListener#updateAccessibleMode(): Unexpected call (no notification)");
    }

    public void updateBTState(int n, int n2) {
        this.log.log(100000, "BluetoothDefaultListener#updateBTState(): Unexpected call (no notification)");
    }

    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
        this.log.log(100000, "BluetoothDefaultListener#updateDiscoveredDevices(): Unexpected call (no notification)");
    }

    public void updateHUCandBTHSState(int n, int n2) {
        this.log.log(100000, "BluetoothDefaultListener#updateHUCandBTHSState(): Unexpected call (no notification)");
    }

    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
        this.log.log(100000, "BluetoothDefaultListener#updateIncomingServiceRequest(): Unexpected call (no notification)");
    }

    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
        this.log.log(100000, "BluetoothDefaultListener#updateMasterRoleRequestError(): Unexpected call (no notification)");
    }

    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
        this.log.log(100000, "BluetoothDefaultListener#updatePasskeyState(): Unexpected call (no notification)");
    }

    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
        this.log.log(100000, "BluetoothDefaultListener#updatePriorizedDeviceReconnect(): Unexpected call (no notification)");
    }

    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
        this.log.log(100000, "BluetoothDefaultListener#updateReconnectIndicator(): Unexpected call (no notification)");
    }

    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
        this.log.log(100000, "BluetoothDefaultListener#updateServiceRequestState(): Unexpected call (no notification)");
    }

    public void updateSupportedBTProfiles(int n, int n2) {
        this.log.log(100000, "BluetoothDefaultListener#updateSupportedBTProfiles(): Unexpected call (no notification)");
    }

    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        this.log.log(100000, "BluetoothDefaultListener#updateTrustedDevices(): Unexpected call (no notification)");
    }

    public void updateUserFriendlyName(String string, int n) {
        this.log.log(100000, "BluetoothDefaultListener#updateUserFriendlyName(): Unexpected call (no notification)");
    }
}

