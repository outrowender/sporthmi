/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.security;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.security.AbstractCommandRequestPasskeyResponse;
import de.audi.app.bluetooth.core.security.CommandRequestPasskeyResponse;
import de.audi.app.bluetooth.core.security.ConnectivitySpeedThresholdListener;
import de.audi.app.bluetooth.core.security.ISecurity;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;

public abstract class AbstractSecurity
extends AbstractBluetoothComponent
implements ISecurity,
ButtonListener,
SpellerListener {
    private static final int PIN_MIN_LENGTH_4 = 4;
    private static final int PIN_MAX_LENGTH_16 = 16;
    private static final int PIN_SSP_LENGTH_6 = 6;
    private static final char SEPARATOR = ' ';
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{7};
    private final ConnectivitySpeedThresholdListener speedListener;
    private final LabelModelApp deviceNameLabel = this.getLabelModel(2500100);
    private final LabelModelApp pinLabel = this.getLabelModel(2500103);
    private final ButtonModelApp acceptButton = this.getButtonModel(2500099);
    private final ButtonModelApp rejectButton = this.getButtonModel(2500104);
    private final ButtonModelApp externalAcceptButton = this.getButtonModel(2500101);
    private final ButtonModelApp externalRejectButton = this.getButtonModel(0x262606);
    private final ButtonModelApp pinAcceptButton = this.getButtonModel(2500120);
    private final ButtonModelApp pinDeclineButton = this.getButtonModel(2500240);
    private final ButtonModelApp pinApplyButton = this.getButtonModel(2500121);
    protected final SpellerModelApp pinSpeller = this.getSpellerModel(2500119);
    private PasskeyStateStruct passkeyState;
    protected String userPin = "";
    private boolean inquiryActive = false;
    private boolean connectionActive = false;
    private boolean serviceDiscoveryActive = false;
    private boolean waitingUserInput = false;
    private boolean bondingStateActive = false;

    public AbstractSecurity(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
        this.speedListener = new ConnectivitySpeedThresholdListener(this.log, this.getChoiceModel(0x262616));
    }

    protected final int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    protected abstract void showExternalBonding();

    protected abstract void leaveExternalBonding();

    public void inquiryActive(boolean bl) {
        this.inquiryActive = bl;
    }

    public void connectionActive(boolean bl) {
        this.connectionActive = bl;
    }

    public void serviceDiscoveryActive(boolean bl) {
        this.serviceDiscoveryActive = bl;
    }

    public void securityEntryAction() {
        this.bondingStateActive = true;
        this.executeUserActionPhase(this.getPinLabelText(), this.waitingUserInput, this.bondingStateActive);
    }

    public void securityExitAction() {
        this.bondingStateActive = false;
        this.executeUserActionPhase(this.getPinLabelText(), this.waitingUserInput, this.bondingStateActive);
        this.leaveExternalBonding();
    }

    public void speedDisclaimerEntered() {
        this.abortPairing();
    }

    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
        int n2;
        if (n != 1 || passkeyStateStruct == null) {
            return;
        }
        this.passkeyState = passkeyStateStruct;
        int n3 = passkeyStateStruct.getBtPasskeyState();
        String string = passkeyStateStruct.getBtDeviceName();
        this.log.log(1000000, "AbstractSecurity#updatePasskeyState(): %1 %2 is in state %3 BtPasskey: %4", (Object)string, (Object)passkeyStateStruct.getBtDeviceAddress(), (Object)String.valueOf(n3), (Object)passkeyStateStruct.getBtPasskey());
        boolean bl = false;
        switch (n3) {
            case 1: {
                n2 = 4;
                this.pinSpeller.setMinLength(passkeyStateStruct.getBtPasskey().length() == 16 ? 16 : 4);
                bl = true;
                break;
            }
            case 2: {
                n2 = 3;
                this.pinSpeller.setMinLength(passkeyStateStruct.getBtPasskey().length() == 16 ? 16 : 4);
                bl = true;
                break;
            }
            case 7: {
                n2 = 2;
                bl = true;
                break;
            }
            case 3: {
                this.bluetoothApplication.getBondingState().updateBondingResult(4);
                n2 = 0;
                this.initPinSpeller();
                break;
            }
            case 5: {
                this.bluetoothApplication.getBondingState().updateBondingResult(1);
                n2 = 0;
                this.initPinSpeller();
                break;
            }
            case 4: {
                this.bluetoothApplication.getBondingState().updateBondingResult(2);
                n2 = 0;
                break;
            }
            case 0: {
                this.bluetoothApplication.getDeviceProfileList().updateConnectedProfiles(passkeyStateStruct.getBtDeviceAddress(), true);
                this.leaveExternalBonding();
                this.initPinSpeller();
                return;
            }
            default: {
                this.log.log(10000, "AbstractSecurity#updatePasskeyState(): Unhandled passkey! Update ignored!");
                this.bondingStateActive = false;
                this.leaveExternalBonding();
                this.initPinSpeller();
                return;
            }
        }
        this.updateBondingModels(string, passkeyStateStruct.getBtDeviceAddress(), passkeyStateStruct.getBtPasskey(), n2);
        this.checkPopup(bl);
    }

    private void abortPairing() {
        this.requestPasskeyResponse(this.passkeyState.getBtPasskey(), false);
    }

    private void updateBondingModels(String string, String string2, String string3, int n) {
        this.deviceNameLabel.setText(string);
        if (n != 0) {
            this.setPinLabel(string3);
        }
        this.bluetoothApplication.getBondingState().updateDeviceName(string);
        this.bluetoothApplication.getBondingState().updateDeviceAddress(string2);
        this.bluetoothApplication.getBondingState().updateBondingState(n);
    }

    private void setPinLabel(String string) {
        if (string.length() == 16) {
            String string2 = string.substring(0, 4) + ' ' + string.substring(4, 8) + ' ' + string.substring(8, 12) + ' ' + string.substring(12, 16);
            this.pinLabel.setText(string2);
        } else if (string.length() == 6) {
            String string3 = string.substring(0, 3) + ' ' + string.substring(3, 6);
            this.pinLabel.setText(string3);
        } else {
            this.pinLabel.setText(string);
        }
    }

    private String getPinLabelText() {
        String string = this.pinLabel.getText();
        if (string == null) {
            return "";
        }
        if (string.length() == 19) {
            return string.substring(0, 4) + string.substring(5, 9) + string.substring(10, 14) + string.substring(15, 19);
        }
        if (string.length() == 7 && string.charAt(3) == ' ') {
            return string.substring(0, 3) + string.substring(4, 7);
        }
        return string;
    }

    private void checkPopup(boolean bl) {
        this.log.log(10000000, "AbstractSecurity#checkPopup(): inquiryActive=%1 connectionActive=%2 serviceDiscoveryActive=%3", this.inquiryActive, this.connectionActive, this.serviceDiscoveryActive);
        if (bl) {
            this.waitingUserInput = true;
            if (!(this.inquiryActive || this.connectionActive || this.serviceDiscoveryActive)) {
                this.log.log(10000000, "AbstractSecurity#checkPopup(): No ongoing Bluetooth process - showing pop-up");
                this.bluetoothApplication.getBondingState().updateBondingResult(0);
                this.bondingStateActive = true;
                this.showExternalBonding();
            }
            this.executeUserActionPhase(this.passkeyState.getBtPasskey(), this.waitingUserInput, this.bondingStateActive);
        } else {
            this.waitingUserInput = false;
            this.leaveExternalBonding();
        }
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(100000000, "AbstractSecurity#textChanged(): Text=\"%1\"", (Object)string);
        this.userPin = string;
        if (string.length() >= this.pinSpeller.getMinLength() && string.length() <= this.pinSpeller.getMaxLength()) {
            this.pinSpeller.setStatus(0);
        } else {
            this.pinSpeller.setStatus(1);
        }
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(10000000, "AbstractSecurity#keyTyped(): modelID=%1", (long)n);
        if (n == this.acceptButton.getID()) {
            this.log.log(1000000, "AbstractSecurity#keyTyped(): Numeric comparison accepted.");
            this.requestPasskeyResponse(this.passkeyState.getBtPasskey(), true);
        } else if (n == this.rejectButton.getID()) {
            this.log.log(1000000, "AbstractSecurity#keyTyped(): Numeric comparison rejected.");
            this.requestPasskeyResponse(this.passkeyState.getBtPasskey(), false);
            this.initPinSpeller();
        } else if (n == this.externalAcceptButton.getID()) {
            this.log.log(1000000, "AbstractSecurity#keyTyped(): Accept external pairing/ pairing due to reconnect.");
            this.externalAcceptButton.fireEvent(n3);
            this.leaveExternalBonding();
            this.executeUserActionPhase(this.passkeyState.getBtPasskey(), this.waitingUserInput, this.bondingStateActive);
        } else if (n == this.externalRejectButton.getID()) {
            this.log.log(1000000, "AbstractSecurity#keyTyped(): External pairing/ Pairing due to reconnect rejected.");
            this.bondingStateActive = false;
            this.requestPasskeyResponse(this.passkeyState.getBtPasskey(), false);
            this.leaveExternalBonding();
            this.initPinSpeller();
        } else if (n == this.pinAcceptButton.getID()) {
            this.log.log(1000000, "AbstractSecurity#keyTyped(): Generated PIN for entry on ME accepted.");
            this.requestPasskeyResponse(this.passkeyState.getBtPasskey(), true);
            this.pinAcceptButton.fireEvent(n3);
        } else if (n == this.pinApplyButton.getID() || n == this.pinSpeller.getID()) {
            this.log.log(1000000, "AbstractSecurity#keyTyped(): User entered PIN for entry on ME applied.");
            this.setPinLabel(this.userPin);
            this.requestPasskeyResponse(this.userPin, true);
            this.pinApplyButton.fireEvent(n3);
            this.initPinSpeller();
        } else if (n == this.pinDeclineButton.getID()) {
            this.log.log(1000000, "AbstractSecurity#keyTyped(): Generated PIN for entry on ME declined, enter new one.");
            this.initPinSpeller();
            this.pinDeclineButton.fireEvent(n3);
        }
    }

    private void initPinSpeller() {
        this.log.log(10000000, "AbstractSecurity#initPinSpeller(): Speller reseted.");
        this.pinSpeller.clear();
        this.pinSpeller.setStatus(1);
    }

    protected abstract void executeUserActionPhase(String var1, boolean var2, boolean var3);

    protected void requestPasskeyResponse(String string, boolean bl) {
        this.waitingUserInput = false;
        CommandList commandList = this.bluetoothApplication.getCommandListManager().getActiveCommandList();
        if (commandList != null) {
            Command command = commandList.getActiveCommand();
            if (command instanceof AbstractCommandRequestPasskeyResponse) {
                ((AbstractCommandRequestPasskeyResponse)command).requestPasskeyResponse(string, bl);
            }
        } else {
            CommandRequestPasskeyResponse.schedule(this.bluetoothApplication, this.dsiBluetooth, this.passkeyState.getBtDeviceAddress(), string, bl);
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void init() {
        super.init();
        this.acceptButton.setButtonListener(this);
        this.rejectButton.setButtonListener(this);
        this.externalAcceptButton.setButtonListener(this);
        this.externalRejectButton.setButtonListener(this);
        this.pinAcceptButton.setButtonListener(this);
        this.pinApplyButton.setButtonListener(this);
        this.pinDeclineButton.setButtonListener(this);
        this.pinSpeller.setSpellerListener(this);
        this.pinSpeller.setMinLength(4);
        this.pinSpeller.setMaxLength(16);
        this.bluetoothApplication.getFramework().getSysApp().registerSpeedThresholdListener(this.speedListener, 10);
    }

    public void deinit() {
        this.acceptButton.resetListener();
        this.rejectButton.resetListener();
        this.externalAcceptButton.resetListener();
        this.externalRejectButton.resetListener();
        this.pinAcceptButton.resetListener();
        this.pinDeclineButton.resetListener();
        this.pinApplyButton.resetListener();
        this.pinSpeller.resetListener();
        this.bluetoothApplication.getFramework().getSysApp().unregisterSpeedThresholdListener(this.speedListener);
        super.deinit();
    }
}

