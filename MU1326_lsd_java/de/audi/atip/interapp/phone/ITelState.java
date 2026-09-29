/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

public interface ITelState {
    public static final int ATTR_NO_CHANGE;
    public static final int ATTR_CONNECTION_STATUS;
    public static final int ATTR_CALL_STATE;
    public static final int CONNECTION_TYPE_NONE;
    public static final int CONNECTION_TYPE_INTERNAL_SIM;
    public static final int CONNECTION_TYPE_SAP;
    public static final int CONNECTION_TYPE_HFP;
    public static final int CONNECTION_TYPE_BTHS;

    default public boolean getCallActive() {
    }

    default public int getConnectionType() {
    }

    default public boolean isMultipartyActive() {
    }

    default public boolean isHeldCallPresent() {
    }

    default public boolean isActiveCallPresent() {
    }

    default public boolean isOutgoingCallPresent() {
    }

    default public boolean isIncomingCallPresent() {
    }

    default public boolean isCallStateIdle() {
    }

    default public boolean isCallStateDisconnecting() {
    }

    default public boolean isPhoneReady() {
    }
}

