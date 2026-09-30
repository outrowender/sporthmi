/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.atip.interapp.phone.ITelMESlotState;
import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.PhoneInformation;
import org.dsi.ifc.telephoneng.RegisterStateStruct;

public class TelMESlotState
implements ITelMESlotState {
    private final int activationState;
    private final int telMode;
    private final String simCardID;
    private final String macAddress;
    private final int lockState;
    private final CallStateStruct callState;
    private final int mpCallState;
    private final int networkType;
    private final int registerState;

    public TelMESlotState(ActivationStateStruct activationStateStruct, LockStateStruct lockStateStruct, PhoneInformation phoneInformation, int n, CallStateStruct callStateStruct, RegisterStateStruct registerStateStruct) {
        this.activationState = activationStateStruct != null ? activationStateStruct.getTelActivationState() : 0;
        this.lockState = lockStateStruct != null ? lockStateStruct.getTelLockState() : 0;
        this.telMode = activationStateStruct != null ? activationStateStruct.getTelMode() : 4;
        this.simCardID = phoneInformation != null ? phoneInformation.getSimId() : null;
        this.macAddress = phoneInformation != null ? phoneInformation.getMeBtAddress() : null;
        this.networkType = n;
        this.callState = callStateStruct;
        this.mpCallState = callStateStruct != null ? callStateStruct.getMpCallState() : 0;
        this.registerState = registerStateStruct != null ? registerStateStruct.getTelRegisterState() : 0;
    }

    public int getActivationState() {
        return this.activationState;
    }

    public int getTelMode() {
        return this.telMode;
    }

    public int getLockState() {
        return this.lockState;
    }

    public String getSimCardID() {
        return this.simCardID;
    }

    public String getBTMacAddress() {
        return this.macAddress;
    }

    public int getRegisterState() {
        return this.registerState;
    }

    public boolean isCallActive() {
        return this.callState != null && !this.callState.isIdle() && this.callState.getMpCallState() != 15;
    }

    public boolean isCallActiveOrPhoneRinging() {
        return this.callState != null && !this.callState.isIdle();
    }

    public boolean isNetworkGSM() {
        return this.networkType == 1;
    }

    public int getMpCallState() {
        return this.mpCallState;
    }

    public int getNetworkType() {
        return this.networkType;
    }

    public boolean isBluetoothCallActive() {
        return this.isBluetoothPhone() && this.isCallActive();
    }

    public boolean isGsmCallActive() {
        return this.isCallActive() && this.isNetworkGSM();
    }

    public boolean isSim() {
        return this.isInternalSim() || this.telMode == 2 || this.telMode == 1;
    }

    public boolean isBluetoothPhone() {
        return this.telMode == 3 || this.telMode == 2 || this.telMode == 1;
    }

    public boolean isInternalSim() {
        return this.telMode == 0;
    }

    public boolean isPhoneOn() {
        return this.activationState == 5 || this.activationState == 2;
    }

    public boolean isDevicePossiblyAvailable() {
        return this.activationState != 1 && this.activationState != 12 && this.activationState != 4;
    }

    public boolean isUnlocked() {
        return this.isPhoneOn() && this.lockState == 2;
    }

    public boolean isEqual(ITelMESlotState iTelMESlotState) {
        if (iTelMESlotState != null) {
            boolean bl = iTelMESlotState.getActivationState() == this.activationState;
            boolean bl2 = iTelMESlotState.getTelMode() == this.telMode;
            boolean bl3 = iTelMESlotState.getLockState() == this.lockState;
            boolean bl4 = StringUtilities.equals(this.simCardID, iTelMESlotState.getSimCardID());
            boolean bl5 = StringUtilities.equals(this.macAddress, iTelMESlotState.getBTMacAddress());
            boolean bl6 = iTelMESlotState.getMpCallState() == this.mpCallState;
            boolean bl7 = iTelMESlotState.getNetworkType() == this.networkType;
            boolean bl8 = iTelMESlotState.getRegisterState() == this.registerState;
            return bl && bl2 && bl3 && bl4 && bl5 && bl6 && bl7 && bl8;
        }
        return false;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelMESlotState");
        buffer.append("(");
        buffer.append("activationState=");
        buffer.append(this.activationState);
        buffer.append(", ");
        buffer.append("lockState=");
        buffer.append(this.lockState);
        buffer.append(", ");
        buffer.append("telMode=");
        buffer.append(this.telMode);
        buffer.append(", ");
        buffer.append("macAddress=");
        buffer.append(this.macAddress);
        buffer.append(", ");
        buffer.append("simCardID=");
        buffer.append(this.simCardID);
        buffer.append(", ");
        buffer.append("isCallActive=");
        buffer.append(this.isCallActive());
        buffer.append(", ");
        buffer.append("isNetworkGSM=");
        buffer.append(this.isNetworkGSM());
        buffer.append(", ");
        buffer.append("registerState=");
        buffer.append(this.getRegisterState());
        buffer.append(")");
        return buffer.toString();
    }
}

