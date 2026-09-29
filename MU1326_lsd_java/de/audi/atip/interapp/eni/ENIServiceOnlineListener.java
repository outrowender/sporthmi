/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.eni;

import de.audi.atip.interapp.bap.eni.data.PrivacySetup;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.User;

public interface ENIServiceOnlineListener {
    public static final int SET_MAIN_USER_RESULT_OK;
    public static final int SET_MAIN_USER_RESULT_ERROR_WRONG_PIN;
    public static final int SET_MAIN_USER_RESULT_ERROR_GEN;
    public static final int SET_MAIN_USER_RESULT_WRONG_MAX_REACHED;
    public static final int SET_MAIN_USER_RESULT_ERROR_NO_VERIFIED_ACCOUNT;

    default public void onServiceList(Service[] serviceArray) {
    }

    default public void onUserList(User[] userArray) {
    }

    default public void triggerMainUserSetUsingVehiclePINResponse(int n, int n2) {
    }

    default public void triggerMainUserResetResponse(boolean bl) {
    }

    default public void triggerUpdateUserListResponse(boolean bl) {
    }

    default public void onMonitorings(int n, int n2, int n3) {
    }

    default public void setAlertServicesPrivacyDisclaimerTextVisible(boolean bl) {
    }

    default public void onPrivacySetup(PrivacySetup privacySetup) {
    }

    default public void onRemoteProcessPrivacyModeReturnedToIdle() {
    }

    default public void updatePrivacyModeFeatureAvailable(boolean bl) {
    }
}

