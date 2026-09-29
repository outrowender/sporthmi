/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class ServiceRequestState {
    public static final int IDLE;
    public static final int COLLECTING_DATA;
    public static final int CONNECTING_TO_SERVER;
    public static final int SENDING_DATA_VIA_IP_CONNECTION;
    public static final int DISCONNECTING_FROM_SERVER;
    public static final int VOICE_CALL_PENDING;
    public static final int VOICE_CALL_PRESENT;
    public static final int VOICE_CALL_TERMINATED_REDIAL_PENDING;
    public static final int SENDING_DATA_VIA_INBAND_MODEM;
    public static final int TERMINATED_BY_USER;
    public static final int TERMINATED_REGULARLY;
    public static final int TERMINATED_WITH_ERROR_GOT_NO_RECEIVE_CONFIRMATION;
    public static final int TERMINATED_WITH_ERROR;
    public static final int NO_LICENSE;
    public static final int NOT_STARTED_OR_DENIED_BY_USER;
    public static final int NOT_STARTED_TIMEOUT;
    public static final int TEST_MODE_ACTIVE;
    public static final int VOICE_CALL_TERMINATED;
    public static final int CALL_SETUP_FAILED_REDIAL_PENDING;
    public static final int REDIAL_FAILED_CALLBACK_PENDING;
    public static final int SERVICE_DISABLED_BY_DRIVER;
    public static final int SERVICE_NOT_STARTED_NETWORK_ERROR;
    public static final int VOICE_CALL_PRESENT_SENDING_DATA;

    private ServiceRequestState() {
        throw new AssertionError((Object)"ServiceRequestState is not intended to be instantiated.");
    }
}

