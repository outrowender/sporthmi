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

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(-2137614336, "BluetoothDefaultListener#asyncException(): errorCode=%2, errorMsg=%1, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void deviceDisonnectionInfo(String string, String string2, int n) {
    }

    @Override
    public void removeAuthenticationNoSupport(String string, String string2) {
    }

    @Override
    public void serviceRejectNoSupport(String string, String string2) {
    }

    @Override
    public void responseAbortConnectService(int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseAbortConnectService(): Expected to be handled by a Command!");
    }

    @Override
    public void responseAbortInquiry(int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseAbortInquiry(): Expected to be handled by a Command!");
    }

    @Override
    public void responseAcceptIncomingServiceRequest(int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseAcceptIncomingServiceRequest(): Expected to be handled by a Command!");
    }

    @Override
    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseConnectService(): Expected to be handled by a Command!");
    }

    @Override
    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseConnectServiceToInstance(): Expected to be handled by a Command!");
    }

    @Override
    public void responseDisconnectService(String string, int n, int n2) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseDisconnectService(): Expected to be handled by a Command!");
    }

    @Override
    public void responseGetServices(String string, String string2, int n, int n2) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseGetServices(): Expected to be handled by a Command!");
    }

    @Override
    public void responseInquiry(int n, int n2) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseInquiry(): Expected to be handled by a Command!");
    }

    @Override
    public void responsePasskeyResponse(String string, String string2, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responsePasskeyResponse(): Expected to be handled by a Command!");
    }

    @Override
    public void responseReconnectSuspend(int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseReconnectSuspend(): Expected to be handled by a Command!");
    }

    @Override
    public void responseRemoveAuthentication(String string, String string2, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseRemoveAuthentication(): Expected to be handled by a Command!");
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseRestoreFactorySettings(): Expected to be handled by a Command!");
    }

    @Override
    public void responseSetA2DPUserSetting(int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseSetA2DPUserSetting(): Expected to be handled by a Command!");
    }

    @Override
    public void responseSetPriorizedDeviceReconnect(int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseSetPriorizedDeviceReconnect(): Expected to be handled by a Command!");
    }

    @Override
    public void responseSwitchBTState(int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseSwitchBTState(): Expected to be handled by a Command!");
    }

    @Override
    public void responseSetAccessibleMode(int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#responseSetAccessibleMode(): Expected to be handled by a Command!");
    }

    @Override
    public void updateA2DPUserSetting(boolean bl, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateA2DPUserSetting(): Unexpected call (no notification)");
    }

    @Override
    public void updateAccessibleMode(int n, boolean bl, int n2) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateAccessibleMode(): Unexpected call (no notification)");
    }

    @Override
    public void updateBTState(int n, int n2) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateBTState(): Unexpected call (no notification)");
    }

    @Override
    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateDiscoveredDevices(): Unexpected call (no notification)");
    }

    @Override
    public void updateHUCandBTHSState(int n, int n2) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateHUCandBTHSState(): Unexpected call (no notification)");
    }

    @Override
    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateIncomingServiceRequest(): Unexpected call (no notification)");
    }

    @Override
    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateMasterRoleRequestError(): Unexpected call (no notification)");
    }

    @Override
    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updatePasskeyState(): Unexpected call (no notification)");
    }

    @Override
    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updatePriorizedDeviceReconnect(): Unexpected call (no notification)");
    }

    @Override
    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateReconnectIndicator(): Unexpected call (no notification)");
    }

    @Override
    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateServiceRequestState(): Unexpected call (no notification)");
    }

    @Override
    public void updateSupportedBTProfiles(int n, int n2) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateSupportedBTProfiles(): Unexpected call (no notification)");
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateTrustedDevices(): Unexpected call (no notification)");
    }

    @Override
    public void updateUserFriendlyName(String string, int n) {
        this.log.log(-1601830656, "BluetoothDefaultListener#updateUserFriendlyName(): Unexpected call (no notification)");
    }
}

