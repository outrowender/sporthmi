/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class RemoteProcessState$ExceptionState {
    public static final int NONE;
    public static final int ERROR;
    public static final int ERROR_COMMAND_NOT_SUPPORTED;
    public static final int ERROR_PARAMETER_MISMATCH;
    public static final int ERROR_NO_NETWORK_CONNECTION;
    public static final int ERROR_NO_VERIFIED_ACCOUNT;
    public static final int ERROR_BACKEND_AUTHENTICATION_FAILED;
    public static final int ERROR_BACKEND_SERVICE_NOT_AVAILABLE;
    public static final int ERROR_BACKEND;
    public static final int ERROR_TIMEOUT;
    public static final int ERROR_WRONG_PIN;
    public static final int ERROR_VTAN_NOT_AVAILABLE;

    private RemoteProcessState$ExceptionState() {
        throw new AssertionError((Object)"RemoteProcessState.ExceptionState is not intended to be instantiated.");
    }
}

