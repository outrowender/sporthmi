/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callcontrol;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.hmi.model.ButtonListener;

public abstract class AbstractTelMFLKeyHandler
extends AbstractPhoneComponent
implements ButtonListener {
    protected volatile IGlobalTelephoneStateStruct telephoneState;

    public AbstractTelMFLKeyHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getButtonModel(3859).setButtonListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getButtonModel(3859).resetListener();
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    protected void triggerJumpToPhone() {
        PhoneUtils.triggerJumpToPhone(this.getApplication().getFrameworkAccess().getHmiServiceApp());
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelMFLKeyHandler#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        if (iGlobalTelephoneStateStruct != null) {
            boolean bl;
            if (iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
                this.log.log(-2137614336, "[TelMFLKeyHandler#keyTyped] hanging up low priority SOS call.");
                this.getApplication().getCallControl().hangupCall(0);
                return;
            }
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
            CallStateStruct callStateStruct = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
            CallStateStruct callStateStruct2 = iTelDSIMobileEquipmentDeviceState2 != null ? iTelDSIMobileEquipmentDeviceState2.getCallState() : null;
            boolean bl2 = callStateStruct != null ? callStateStruct.isHasIncomingCall() : false;
            boolean bl3 = callStateStruct2 != null ? callStateStruct2.isHasIncomingCall() : false;
            boolean bl4 = callStateStruct != null ? callStateStruct.isIdle() : true;
            boolean bl5 = bl = callStateStruct2 != null ? callStateStruct2.isIdle() : true;
            if (bl3 && !bl2) {
                this.log.log(-2137614336, "[TelMFLKeyHandler#keyTyped] incoming call on non call leading device");
                this.getApplication().getTelephoneDSIAccess().acceptIncomingCallOnNonCallLeadingDevice(0);
            } else if (bl2) {
                this.log.log(-2137614336, "[TelMFLKeyHandler#keyTyped] accepting incoming call.");
                this.getApplication().getCallControl().acceptIncomingCall(0);
            } else if (callStateStruct != null && callStateStruct.isMultipartyActive() && bl2) {
                this.log.log(-2137614336, "[TelMFLKeyHandler#keyTyped] rejecting incoming call since two calls are already present.");
                this.getApplication().getCallControl().rejectIncomingCall(0);
            } else if (callStateStruct != null && !bl4) {
                this.log.log(-2137614336, "[TelMFLKeyHandler#keyTyped] hanging up call.");
                this.getApplication().getCallControl().hangupCall(0);
            } else if (bl4 && bl) {
                IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct2 = this.telephoneState;
                this.handleTelKeyTypedIdle(iGlobalTelephoneStateStruct2.isPhoneReady());
            }
        } else {
            this.log.log(10000, "TelMFLKeyHandler#keyTyped currentState is null");
        }
    }

    protected abstract void handleTelKeyTypedIdle(boolean bl) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

