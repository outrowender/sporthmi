/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.eni;

import de.audi.atip.interapp.bap.eni.data.PrivacySetup;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.User;

public interface ENIServiceOnlineListener {
    public static final int SET_MAIN_USER_RESULT_OK = 0;
    public static final int SET_MAIN_USER_RESULT_ERROR_WRONG_PIN = 1;
    public static final int SET_MAIN_USER_RESULT_ERROR_GEN = 2;
    public static final int SET_MAIN_USER_RESULT_WRONG_MAX_REACHED = 3;
    public static final int SET_MAIN_USER_RESULT_ERROR_NO_VERIFIED_ACCOUNT = 4;

    public void onServiceList(Service[] var1);

    public void onUserList(User[] var1);

    public void triggerMainUserSetUsingVehiclePINResponse(int var1, int var2);

    public void triggerMainUserResetResponse(boolean var1);

    public void triggerUpdateUserListResponse(boolean var1);

    public void onMonitorings(int var1, int var2, int var3);

    public void setAlertServicesPrivacyDisclaimerTextVisible(boolean var1);

    public void onPrivacySetup(PrivacySetup var1);

    public void onRemoteProcessPrivacyModeReturnedToIdle();

    public void updatePrivacyModeFeatureAvailable(boolean var1);
}

