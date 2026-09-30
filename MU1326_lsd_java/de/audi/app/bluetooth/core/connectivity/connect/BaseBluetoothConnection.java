/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.connect;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.connectivity.connect.CommandConnectService;
import de.audi.app.bluetooth.core.connectivity.connect.CommandDisconnectService;
import de.audi.app.bluetooth.core.connectivity.connect.IConnection;
import de.audi.app.bluetooth.core.connectivity.reconnect.CommandRequestReconnectSuspend;
import de.audi.app.connectivity.core.common.CommandSetNadMode;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;

public class BaseBluetoothConnection
extends AbstractBluetoothComponent
implements IConnection,
ButtonListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[0];
    private final LabelModelApp bondingDeviceNameLabel = this.getLabelModel(2500100);
    private final ChoiceModelApp blueDisconnectServiceResult = this.getChoiceModel(2500185);
    private final ButtonModelApp blueConnectAbortButton = this.getButtonModel(0x262662);
    protected ConnectionRequest connectionRequest;
    private volatile ConnectionRequest pendingRequest = null;
    private boolean hfpSupported = false;
    private volatile boolean isAutoReconnect = true;

    private static final int getUniqueService(int n) {
        if (n == 6) {
            return 4;
        }
        if ((n & 0x600020) > 0) {
            if ((n & 0x20) > 0) {
                return 32;
            }
            if ((n & 0x400000) > 0) {
                return 0x400000;
            }
            return 0x200000;
        }
        return n;
    }

    private static final int getDeviceRoleForService(int n, boolean bl) {
        if (n == 65536) {
            return 0;
        }
        if (!(bl || n != 2 && n != 4)) {
            return 2;
        }
        return 1;
    }

    public BaseBluetoothConnection(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    protected final int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    public void connectService(String string, int n, String string2, boolean bl) {
        this.connectService(string, n, string2, bl, true);
    }

    public void connectService(String string, int n, String string2, boolean bl, boolean bl2) {
        this.isAutoReconnect = bl2;
        if (!this.bluetoothApplication.getClampStateProvider().isClampSOn()) {
            this.log.log(1000000, "BaseBluetoothConnection#connectService(): Not doing anything, because clamp S is OFF");
            return;
        }
        this.bluetoothApplication.getAccessibility().activateBluetooth();
        int n2 = this.bluetoothApplication.getSupportedBtProfiles().getConnectableServices(6, true);
        int n3 = BaseBluetoothConnection.getUniqueService(n & n2);
        this.connectionRequest = new ConnectionRequest(string, n3, string2, BaseBluetoothConnection.getDeviceRoleForService(n3, bl));
        this.log.log(1000000, "BaseBluetoothConnection#connectService(): %1", (Object)this.connectionRequest);
        if (n3 != 0) {
            this.processConnectionRequest();
        } else {
            this.log.log(1000000, "BaseBluetoothConnection#connectService(): Unable to process connection request: %1", (Object)this.connectionRequest);
            this.bluetoothApplication.getBondingState().updateBondingResult(4);
            this.bluetoothApplication.getBondingState().updateBondingState(0);
        }
        this.bluetoothApplication.getInquiry().abortInquiry();
    }

    private void processConnectionRequest() {
        this.bondingDeviceNameLabel.setText(this.connectionRequest.deviceName);
        this.bluetoothApplication.getBondingState().updateDeviceName(this.connectionRequest.deviceName);
        this.bluetoothApplication.getBondingState().updateDeviceAddress(this.connectionRequest.address);
        this.bluetoothApplication.getBondingState().updateBondingState(1);
        if (this.connectionRequest.service == 2 && this.bluetoothApplication.getSupportedBtProfiles().isHfpSupportFaked()) {
            this.log.log(1000000, "BaseBluetoothConnection#connectService(): Downgrading NAD mode before connecting HFP");
            CommandRequestReconnectSuspend.schedule(this.bluetoothApplication, this.dsiBluetooth, true);
            CommandSetNadMode.schedule(this.bluetoothApplication.getCommandListManager(), this.log, this.bluetoothApplication.getPhone(), false);
            this.pendingRequest = this.connectionRequest;
        } else {
            if (this.connectionRequest.service == 65536) {
                this.bluetoothApplication.getAudio().requestSetA2DPUserSetting(true, this.isAutoReconnect);
            }
            this.connectService(this.connectionRequest);
        }
    }

    protected void connectService(ConnectionRequest connectionRequest) {
        this.bluetoothApplication.getSecurity().connectionActive(true);
        this.bluetoothApplication.getSapUpgrade().updateConnectionActive(true);
        this.bluetoothApplication.getMediaBluetoothStateProvider().connectionProcessStarted();
        CommandConnectService.schedule(this.bluetoothApplication, this.dsiBluetooth, connectionRequest.address, connectionRequest.service, connectionRequest.deviceRole);
    }

    public void abortConnectService() {
        Command command;
        CommandList commandList = this.bluetoothApplication.getCommandListManager().getActiveCommandList();
        if (commandList != null && (command = commandList.getActiveCommand()) instanceof CommandConnectService) {
            ((CommandConnectService)command).abortConnectService();
        }
    }

    protected ChoiceModelApp getDisconnectServiceMonitor() {
        return this.blueDisconnectServiceResult;
    }

    public void disconnectService(String string, int n) {
        this.log.log(10000000, "BaseBluetoothConnection#disconnectService(): %1", (long)n);
        int n2 = BaseBluetoothConnection.getUniqueService(n);
        this.log.log(1000000, "BaseBluetoothConnection#disconnectService(): unique: %1", (long)n2);
        CommandDisconnectService.schedule(this.bluetoothApplication, this.dsiBluetooth, string, n2, this.getDisconnectServiceMonitor());
    }

    public void responseConnectService(String string, int n, int n2, int n3) {
        int n4 = this.getHmiResultValue(n3);
        this.propagateBondingResult(string, n4, n, n2);
        if (this.connectionRequest.service == 65536 && !this.isAutoReconnect) {
            CommandRequestReconnectSuspend.schedule(this.bluetoothApplication, this.dsiBluetooth, false);
            this.isAutoReconnect = true;
        }
    }

    private int getHmiResultValue(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 5: {
                n2 = 1;
                break;
            }
            case 6: {
                n2 = 2;
                break;
            }
            case 15: 
            case 16: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 5;
                break;
            }
            default: {
                this.log.log(100000, "BaseBluetoothConnection#responseConnectService(): Unhandled RESULT_ERROR: %1", (long)n);
            }
            case 8: {
                n2 = 4;
            }
        }
        return n2;
    }

    protected void propagateBondingResult(String string, int n, int n2, int n3) {
        if (n == 0) {
            this.bluetoothApplication.getDeviceProfileList().updateConnectedProfiles(string, true);
        }
        CommandRequestReconnectSuspend.schedule(this.bluetoothApplication, this.dsiBluetooth, false);
        this.bluetoothApplication.getBondingState().updateBondingResult(n);
        this.bluetoothApplication.getBondingState().updateBondingState(0);
        this.bluetoothApplication.getSecurity().connectionActive(false);
        this.bluetoothApplication.getSapUpgrade().updateConnectionActive(false);
        this.bluetoothApplication.getMediaBluetoothStateProvider().connectionProcessStopped();
    }

    public void connectionExitAction() {
    }

    public void updateHfpSupport(boolean bl) {
        if (this.pendingRequest != null && !this.hfpSupported && bl) {
            this.log.log(10000000, "BaseBluetoothConnection#updateHfpSupport(): executing pending HFP connection request");
            this.connectService(this.pendingRequest);
            this.pendingRequest = null;
        }
        this.hfpSupported = bl;
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == this.blueConnectAbortButton.getID()) {
            this.log.log(1000000, "BaseBluetoothConnection#keyTyped(): Abort connect service");
            this.abortConnectService();
            this.blueConnectAbortButton.fireEvent(n3);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void init() {
        super.init();
        this.blueConnectAbortButton.setButtonListener(this);
    }

    public void deinit() {
        this.blueConnectAbortButton.resetListener();
        super.deinit();
    }

    protected final class ConnectionRequest {
        private final String address;
        public int service;
        private final String deviceName;
        private final int deviceRole;

        ConnectionRequest(String string, int n, String string2, int n2) {
            this.address = string;
            this.service = n;
            this.deviceName = string2;
            this.deviceRole = n2;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("Requesting to connect ");
            buffer.append(this.deviceName);
            buffer.append(' ');
            buffer.append(this.address);
            buffer.append(" with service ");
            buffer.append(this.service);
            buffer.append(" (role: ");
            buffer.append(this.deviceRole);
            buffer.append(")");
            return buffer.toString();
        }
    }
}

