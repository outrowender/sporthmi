/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener$1;
import de.audi.app.bluetooth.core.BluetoothDSIListener$10;
import de.audi.app.bluetooth.core.BluetoothDSIListener$11;
import de.audi.app.bluetooth.core.BluetoothDSIListener$12;
import de.audi.app.bluetooth.core.BluetoothDSIListener$13;
import de.audi.app.bluetooth.core.BluetoothDSIListener$14;
import de.audi.app.bluetooth.core.BluetoothDSIListener$15;
import de.audi.app.bluetooth.core.BluetoothDSIListener$16;
import de.audi.app.bluetooth.core.BluetoothDSIListener$17;
import de.audi.app.bluetooth.core.BluetoothDSIListener$18;
import de.audi.app.bluetooth.core.BluetoothDSIListener$19;
import de.audi.app.bluetooth.core.BluetoothDSIListener$2;
import de.audi.app.bluetooth.core.BluetoothDSIListener$20;
import de.audi.app.bluetooth.core.BluetoothDSIListener$21;
import de.audi.app.bluetooth.core.BluetoothDSIListener$22;
import de.audi.app.bluetooth.core.BluetoothDSIListener$23;
import de.audi.app.bluetooth.core.BluetoothDSIListener$24;
import de.audi.app.bluetooth.core.BluetoothDSIListener$25;
import de.audi.app.bluetooth.core.BluetoothDSIListener$26;
import de.audi.app.bluetooth.core.BluetoothDSIListener$27;
import de.audi.app.bluetooth.core.BluetoothDSIListener$28;
import de.audi.app.bluetooth.core.BluetoothDSIListener$29;
import de.audi.app.bluetooth.core.BluetoothDSIListener$3;
import de.audi.app.bluetooth.core.BluetoothDSIListener$30;
import de.audi.app.bluetooth.core.BluetoothDSIListener$31;
import de.audi.app.bluetooth.core.BluetoothDSIListener$32;
import de.audi.app.bluetooth.core.BluetoothDSIListener$33;
import de.audi.app.bluetooth.core.BluetoothDSIListener$4;
import de.audi.app.bluetooth.core.BluetoothDSIListener$5;
import de.audi.app.bluetooth.core.BluetoothDSIListener$6;
import de.audi.app.bluetooth.core.BluetoothDSIListener$7;
import de.audi.app.bluetooth.core.BluetoothDSIListener$8;
import de.audi.app.bluetooth.core.BluetoothDSIListener$9;
import de.audi.app.bluetooth.core.BluetoothDefaultListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

class BluetoothDSIListener
implements DSIBluetoothListener,
ICommandResponseSupplier {
    private final BluetoothDefaultListener bluetoothDefaultListener;
    private final CommandListManager cmdListManager;
    private final LogChannel log;

    BluetoothDSIListener(CommandListManager commandListManager, LogChannel logChannel) {
        this.cmdListManager = commandListManager;
        this.bluetoothDefaultListener = new BluetoothDefaultListener(logChannel);
        this.log = logChannel;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "[BluetoothDSIListener#asyncException] called, error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void deviceDisonnectionInfo(String string, String string2, int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#deviceDisonnectionInfo] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$1(this, string, string2, n));
    }

    @Override
    public void removeAuthenticationNoSupport(String string, String string2) {
        this.log.log(-2137614336, "[BluetoothDSIListener#removeAuthenticationNoSupport] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$2(this, string, string2));
    }

    @Override
    public void responseAbortConnectService(int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseAbortConnectService] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$3(this, n));
    }

    @Override
    public void responseAbortInquiry(int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseAbortInquiry] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$4(this, n));
    }

    @Override
    public void responseAcceptIncomingServiceRequest(int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseAcceptIncomingServiceRequest] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$5(this, n));
    }

    @Override
    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseConnectService] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$6(this, string, string2, n, n2, n3));
    }

    @Override
    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseConnectServiceToInstance] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$7(this, string, string2, n, n2, n3));
    }

    @Override
    public void responseDisconnectService(String string, int n, int n2) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseDisconnectService] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$8(this, string, n, n2));
    }

    @Override
    public void responseGetServices(String string, String string2, int n, int n2) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseGetServices] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$9(this, string, string2, n, n2));
    }

    @Override
    public void responseInquiry(int n, int n2) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseInquiry] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$10(this, n, n2));
    }

    @Override
    public void responsePasskeyResponse(String string, String string2, int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responsePasskeyResponse] Called, device address: %1, device name: %2, result: %3", (Object)string, (Object)string2, (long)n);
        CommandResponse.execute(this, new BluetoothDSIListener$11(this, string, string2, n));
    }

    @Override
    public void responseReconnectSuspend(int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseReconnectSuspend] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$12(this, n));
    }

    @Override
    public void responseRemoveAuthentication(String string, String string2, int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseRemoveAuthentication] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$13(this, string, string2, n));
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseRestoreFactorySettings] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$14(this, n));
    }

    @Override
    public void responseSetA2DPUserSetting(int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseSetA2DPUserSetting] Called, result: %1", (long)n);
        CommandResponse.execute(this, new BluetoothDSIListener$15(this, n));
    }

    @Override
    public void responseSetPriorizedDeviceReconnect(int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseSetPriorizedDeviceReconnect] Called, result: %1", (long)n);
        CommandResponse.execute(this, new BluetoothDSIListener$16(this, n));
    }

    @Override
    public void responseSwitchBTState(int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseSwitchBTState] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$17(this, n));
    }

    @Override
    public void responseSetAccessibleMode(int n) {
        this.log.log(-2137614336, "[BluetoothDSIListener#responseSetAccessibleMode] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$18(this, n));
    }

    @Override
    public void serviceRejectNoSupport(String string, String string2) {
        this.log.log(-2137614336, "[BluetoothDSIListener#serviceRejectNoSupport] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$19(this, string, string2));
    }

    @Override
    public void updateA2DPUserSetting(boolean bl, int n) {
        if (n == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateA2DP_UserSetting] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$20(this, bl, n));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateA2DP_UserSetting] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    @Override
    public void updateAccessibleMode(int n, boolean bl, int n2) {
        if (n2 == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateAccessibleMode] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$21(this, n, bl, n2));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateAccessibleMode] Data is not valid, valid flag value: %1", (long)n2);
        }
    }

    @Override
    public void updateBTState(int n, int n2) {
        if (n2 == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateBTState] Called, state: %1, validFlag: %2", (long)n, (long)n2);
            CommandResponse.execute(this, new BluetoothDSIListener$22(this, n, n2));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateBTState] Data not valid, valid flag value: %1", (long)n2);
        }
    }

    @Override
    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
        if (n == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateDiscoveredDevices] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$23(this, discoveredDevice, n));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateDiscoveredDevices] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    @Override
    public void updateHUCandBTHSState(int n, int n2) {
        this.log.log(-2137614336, "[BluetoothDSIListener#updateHUCandBTHSState] Called");
        CommandResponse.execute(this, new BluetoothDSIListener$24(this, n, n2));
    }

    @Override
    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
        if (n == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateIncomingServiceRequest] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$25(this, requestIncomingService, n));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateIncomingServiceRequest] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    @Override
    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
        if (n == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateMasterRoleRequestError] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$26(this, masterRoleRequestStruct, n));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateMasterRoleRequestError] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    @Override
    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
        if (n == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updatePasskeyState] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$27(this, passkeyStateStruct, n));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updatePasskeyState] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    @Override
    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
        if (n == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updatePriorizedDeviceReconnect] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$28(this, bl, string, n));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updatePriorizedDeviceReconnect] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    @Override
    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
        if (n == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateReconnectIndicator] Called");
            if (reconnectInfo == null) {
                this.log.log(-2137614336, "[BluetoothDSIListener#updateReconnectIndicator] reconnectInfo is null! Ignoring update.");
            } else {
                CommandResponse.execute(this, new BluetoothDSIListener$29(this, reconnectInfo, n));
            }
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateReconnectIndicator] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    @Override
    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
        if (n == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateServiceRequestState] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$30(this, serviceRequestStateStruct, n));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateServiceRequestState] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    @Override
    public void updateSupportedBTProfiles(int n, int n2) {
        if (n2 == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateSupportedBTProfiles] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$31(this, n, n2));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateSupportedBTProfiles] Data is not valid, valid flag value: %1", (long)n2);
        }
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if (n == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateTrustedDevices] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$32(this, trustedDeviceArray, n));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateTrustedDevices] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    @Override
    public void updateUserFriendlyName(String string, int n) {
        if (n == 1) {
            this.log.log(-2137614336, "[BluetoothDSIListener#updateUserFriendlyName] Called");
            CommandResponse.execute(this, new BluetoothDSIListener$33(this, string, n));
        } else {
            this.log.log(-1601830656, "[BluetoothDSIListener#updateUserFriendlyName] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.bluetoothDefaultListener;
    }

    @Override
    public String getHandlerName() {
        return super.getClass().getName();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.log;
    }
}

