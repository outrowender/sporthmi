/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import java.util.Arrays;
import java.util.List;
import org.dsi.ifc.online.OSRDevice;

public interface PortalAuthenticationService {
    public void logoutCurrentUser();

    public void logoutAllUsers();

    public void requestUsersList();

    public void init();

    public void loginUserWithSavedCredentials();

    public void registerUpdateProfileInfoListener(UpdateProfileInfoListener var1);

    public boolean isAuthenticated();

    public void indicateAuthenticationDialogFinsihed();

    public void indicateLogoutDialogFinsihed();

    public void addLoginStateListener(ILoginStateListener var1);

    public static interface ILoginStateListener {
        public static final int STATE_IDLE = 0;
        public static final int STATE_LOGGIN_IN = 1;
        public static final int STATE_LOGGIN_OUT = 2;
        public static final int STATE_LOG_IN_FINISHED_SUCCESS = 3;
        public static final int STATE_LOG_OUT_FINISHED = 4;
        public static final int STATE_LOGIN_FAILED_PIN = 5;
        public static final int STATE_LOGIN_FAILED_BACKEND = 6;
        public static final int STATE_LOGIN_FAILED_CONNECTIVITY = 7;
        public static final int STATE_LOGIN_FAILED_ACCOUNT = 8;
        public static final int STATE_EMPTY_PAIRINGCODE = 9;
        public static final int STATE_LOG_IN_FINISHED_FOLLOWUP = 10;
        public static final List stateString = Arrays.asList(new String[]{"STATE_IDLE", "STATE_LOGGIN_IN", "STATE_LOGGIN_OUT", "STATE_LOG_IN_FINISHED_SUCCESS", "STATE_LOG_OUT_FINISHED", "STATE_LOGIN_FAILED_PIN", "STATE_LOGIN_FAILED_BACKEND", "STATE_LOGIN_FAILED_CONNECTIVITY", "STATE_LOGIN_FAILED_ACCOUNT", "STATE_EMPTY_PAIRINGCODE", "STATE_LOG_IN_FINISHED_FOLLOWUP"});

        public void updateState(int var1);
    }

    public static interface UpdateProfileInfoListener {
        public void updateProfileInfo(Object var1);

        public void updateDeviceInfo(OSRDevice[] var1);
    }
}

