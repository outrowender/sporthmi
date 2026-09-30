/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class ServiceRequestState {
    public static final int IDLE = 0;
    public static final int COLLECTING_DATA = 1;
    public static final int CONNECTING_TO_SERVER = 2;
    public static final int SENDING_DATA_VIA_IP_CONNECTION = 3;
    public static final int DISCONNECTING_FROM_SERVER = 4;
    public static final int VOICE_CALL_PENDING = 5;
    public static final int VOICE_CALL_PRESENT = 6;
    public static final int VOICE_CALL_TERMINATED_REDIAL_PENDING = 7;
    public static final int SENDING_DATA_VIA_INBAND_MODEM = 8;
    public static final int TERMINATED_BY_USER = 9;
    public static final int TERMINATED_REGULARLY = 10;
    public static final int TERMINATED_WITH_ERROR_GOT_NO_RECEIVE_CONFIRMATION = 11;
    public static final int TERMINATED_WITH_ERROR = 12;
    public static final int NO_LICENSE = 13;
    public static final int NOT_STARTED_OR_DENIED_BY_USER = 14;
    public static final int NOT_STARTED_TIMEOUT = 15;
    public static final int TEST_MODE_ACTIVE = 16;
    public static final int VOICE_CALL_TERMINATED = 17;
    public static final int CALL_SETUP_FAILED_REDIAL_PENDING = 18;
    public static final int REDIAL_FAILED_CALLBACK_PENDING = 19;
    public static final int SERVICE_DISABLED_BY_DRIVER = 20;
    public static final int SERVICE_NOT_STARTED_NETWORK_ERROR = 21;
    public static final int VOICE_CALL_PRESENT_SENDING_DATA = 22;

    private ServiceRequestState() {
        throw new AssertionError((Object)"ServiceRequestState is not intended to be instantiated.");
    }
}

