/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

public interface ITelState {
    public static final int ATTR_NO_CHANGE = 0;
    public static final int ATTR_CONNECTION_STATUS = 1;
    public static final int ATTR_CALL_STATE = 2;
    public static final int CONNECTION_TYPE_NONE = 0;
    public static final int CONNECTION_TYPE_INTERNAL_SIM = 1;
    public static final int CONNECTION_TYPE_SAP = 2;
    public static final int CONNECTION_TYPE_HFP = 3;
    public static final int CONNECTION_TYPE_BTHS = 4;

    public boolean getCallActive();

    public int getConnectionType();

    public boolean isMultipartyActive();

    public boolean isHeldCallPresent();

    public boolean isActiveCallPresent();

    public boolean isOutgoingCallPresent();

    public boolean isIncomingCallPresent();

    public boolean isCallStateIdle();

    public boolean isCallStateDisconnecting();

    public boolean isPhoneReady();
}

