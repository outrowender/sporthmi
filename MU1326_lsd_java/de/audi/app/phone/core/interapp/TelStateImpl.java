/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.phone.ITelState;
import de.esolutions.fw.util.commons.Buffer;

public class TelStateImpl
implements ITelState {
    final IGlobalTelephoneStateStruct telState;
    final int attr;

    private static String getKeyName(int n) {
        switch (n) {
            case 2: {
                return "ATTR_CALL_STATE";
            }
            case 1: {
                return "ATTR_CONNECTION_STATUS";
            }
            case 0: {
                return "ATTR_NO_CHANGE";
            }
        }
        return new StringBuffer().append("Unknown key ").append(n).toString();
    }

    private static String getConnectionTypeName(int n) {
        switch (n) {
            case 4: {
                return "CONNECTION_TYPE_BTHS";
            }
            case 1: {
                return "CONNECTION_TYPE_INTERNAL_SIM";
            }
            case 2: {
                return "CONNECTION_TYPE_SAP";
            }
            case 3: {
                return "CONNECTION_TYPE_HFP";
            }
            case 0: {
                return "CONNECTION_TYPE_NONE";
            }
        }
        return new StringBuffer().append("Unknown connection type ").append(n).toString();
    }

    public TelStateImpl(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct == null) {
            throw new IllegalArgumentException("TelStateImpl: State is null!");
        }
        switch (n) {
            case 65539: 
            case 65551: {
                this.attr = 1;
                break;
            }
            case 65544: 
            case 131080: 
            case 196616: {
                this.attr = 2;
                break;
            }
            default: {
                this.attr = 0;
            }
        }
        this.telState = iGlobalTelephoneStateStruct;
    }

    int getKey() {
        return this.attr;
    }

    @Override
    public boolean getCallActive() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.telState.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState() != null && !iTelDSIMobileEquipmentDeviceState.getCallState().isIdle();
        }
        return false;
    }

    @Override
    public boolean isCallStateIdle() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.telState.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isIdle();
        }
        return true;
    }

    @Override
    public boolean isIncomingCallPresent() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.telState.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasIncomingCall();
        }
        return false;
    }

    @Override
    public boolean isOutgoingCallPresent() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.telState.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasOutgoingCall();
        }
        return false;
    }

    @Override
    public boolean isActiveCallPresent() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.telState.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasActiveCall();
        }
        return false;
    }

    @Override
    public boolean isHeldCallPresent() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.telState.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isHasOnHoldCall();
        }
        return false;
    }

    @Override
    public boolean isMultipartyActive() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.telState.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            return iTelDSIMobileEquipmentDeviceState.getCallState().isMultipartyActive();
        }
        return false;
    }

    @Override
    public boolean isCallStateDisconnecting() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.telState.getCallLeadingDevice();
        return iTelDSIMobileEquipmentDeviceState.getCallState() != null && (iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState() == 3 || iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState() == 32);
    }

    @Override
    public boolean isPhoneReady() {
        return this.telState.isPhoneReady();
    }

    @Override
    public int getConnectionType() {
        int n = this.telState.getTelMode();
        switch (n) {
            case 0: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 1: {
                return 4;
            }
        }
        return 0;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelStateImpl(");
        buffer.append("key=");
        buffer.append(TelStateImpl.getKeyName(this.getKey()));
        buffer.append(", ");
        buffer.append("callActive=");
        buffer.append(this.getCallActive());
        buffer.append(", ");
        buffer.append("callStateIdle=");
        buffer.append(this.isCallStateIdle());
        buffer.append(", ");
        buffer.append("incomingCallPresent=");
        buffer.append(this.isIncomingCallPresent());
        buffer.append(", ");
        buffer.append("outgoingCallPreset=");
        buffer.append(this.isOutgoingCallPresent());
        buffer.append(", ");
        buffer.append("activeCallPresent=");
        buffer.append(this.isActiveCallPresent());
        buffer.append(", ");
        buffer.append("heldCallPresent=");
        buffer.append(this.isHeldCallPresent());
        buffer.append(", ");
        buffer.append("multipartyActive=");
        buffer.append(this.isMultipartyActive());
        buffer.append(", ");
        buffer.append("phoneReady=");
        buffer.append(this.isPhoneReady());
        buffer.append(", ");
        buffer.append("connectionType=");
        buffer.append(TelStateImpl.getConnectionTypeName(this.getConnectionType()));
        buffer.append(")");
        return buffer.toString();
    }
}

