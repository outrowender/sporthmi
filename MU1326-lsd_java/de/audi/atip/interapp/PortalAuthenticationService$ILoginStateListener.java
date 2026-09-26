/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import java.util.Arrays;
import java.util.List;

public interface PortalAuthenticationService$ILoginStateListener {
    public static final int STATE_IDLE;
    public static final int STATE_LOGGIN_IN;
    public static final int STATE_LOGGIN_OUT;
    public static final int STATE_LOG_IN_FINISHED_SUCCESS;
    public static final int STATE_LOG_OUT_FINISHED;
    public static final int STATE_LOGIN_FAILED_PIN;
    public static final int STATE_LOGIN_FAILED_BACKEND;
    public static final int STATE_LOGIN_FAILED_CONNECTIVITY;
    public static final int STATE_LOGIN_FAILED_ACCOUNT;
    public static final int STATE_EMPTY_PAIRINGCODE;
    public static final int STATE_LOG_IN_FINISHED_FOLLOWUP;
    public static final List stateString;

    default public void updateState(int n) {
    }

    static {
        stateString = Arrays.asList(new String[]{"STATE_IDLE", "STATE_LOGGIN_IN", "STATE_LOGGIN_OUT", "STATE_LOG_IN_FINISHED_SUCCESS", "STATE_LOG_OUT_FINISHED", "STATE_LOGIN_FAILED_PIN", "STATE_LOGIN_FAILED_BACKEND", "STATE_LOGIN_FAILED_CONNECTIVITY", "STATE_LOGIN_FAILED_ACCOUNT", "STATE_EMPTY_PAIRINGCODE", "STATE_LOG_IN_FINISHED_FOLLOWUP"});
    }
}

