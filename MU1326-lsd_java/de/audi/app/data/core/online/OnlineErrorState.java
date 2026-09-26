/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.data.core.online.AbstractErrorHandler;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class OnlineErrorState {
    private static final int DISCLAIMER_REQUIRED;
    private static final int DISCLAIMER_CONFIRMED;
    public static final int ERROR_NONE;
    public static final int ERROR_SIM_STATE_NAD_OFF;
    public static final int ERROR_SIM_STATE_NA_DATA_ONLY;
    public static final int ERROR_SIM_STATE_NA;
    public static final int ERROR_SIM_STATE_SAP_NA;
    public static final int ERROR_SIM_STATE_SAP;
    public static final int ERROR_SIM_STATE_PIN_REQUIRED;
    public static final int ERROR_SIM_STATE_PUK_REQUIRED;
    public static final int ERROR_SIM_STATE_PUK_BLOCKED;
    public static final int ERROR_SIM_STATE_FAILURE;
    public static final int ERROR_SIM_STATE_GSM_CALL_ACTIVE;
    public static final int ERROR_SIM_STATE_PENDING_DATA_ONLY;
    public static final int ERROR_SIM_STATE_PENDING;
    public static final int ERROR_PROFILE_INVALID;
    public static final int ERROR_PROFILE_NA;
    public static final int ERROR_PROFILE_MULTI;
    public static final int ERROR_GENERAL_PERMISSION_MANUAL;
    public static final int ERROR_GENERAL_PERMISSION_NEVER;
    public static final int ERROR_PERMISSION_CONFIRMED;
    public static final int ERROR_DATA_DEACTIVATED;
    public static final int ERROR_ROAMING_DEACTIVATED;
    public static final int ERROR_ROAMING_ALLOWED;
    public static final int ERROR_ROAMING_CONFIRMED;
    static final String[] ERROR_NAMES;
    private final LogChannel log;
    private final ChoiceModelApp permissionChoice;
    private final ChoiceModelApp disclaimerConfirmed;
    private final ChoiceModelApp onlineConfirmed;
    private final ChoiceModelApp onlineHotspotConfirmed;
    private final ChoiceModelApp roamingConfirmed;
    private final ChoiceModelApp roamingChoice;
    private final ChoiceModelApp mmiErrorChoice;
    private volatile boolean isLocalNetMode;
    private volatile int simState;
    private volatile int profileState = -1;
    private volatile int settingGeneral = 3;
    private volatile int settingPermissionMmi = -1;
    private volatile int settingPermissionWlan = -1;
    private volatile int settingPermissionRoaming;
    private volatile boolean roamingActive;
    private volatile boolean confirmationMmi;
    private volatile boolean confirmationWlan;
    private volatile boolean confirmationRoaming;
    private volatile boolean simUsageIsToBeShown;
    private volatile int currentErrorMmi;
    private volatile int currentErrorWlan;
    private AbstractErrorHandler errorHandler;
    private IHMIServiceApp hmiService;
    private volatile boolean isNadDataOnly;
    private volatile boolean isPhoneOn;
    private volatile boolean isEsimCodedAndActiveAndLicensed;

    OnlineErrorState(LogChannel logChannel, IHMIServiceApp iHMIServiceApp, AbstractErrorHandler abstractErrorHandler) {
        this.log = logChannel;
        this.errorHandler = abstractErrorHandler;
        this.hmiService = iHMIServiceApp;
        this.permissionChoice = iHMIServiceApp.getChoiceModel(740697600);
        this.disclaimerConfirmed = iHMIServiceApp.getChoiceModel(707143168);
        this.onlineConfirmed = iHMIServiceApp.getChoiceModel(1797662208);
        this.onlineHotspotConfirmed = iHMIServiceApp.getChoiceModel(2032543232);
        this.roamingConfirmed = iHMIServiceApp.getChoiceModel(1998988800);
        this.roamingChoice = iHMIServiceApp.getChoiceModel(908469760);
        this.mmiErrorChoice = iHMIServiceApp.getChoiceModel(4277);
    }

    void updateLocalNetMode() {
        this.isLocalNetMode = true;
    }

    synchronized void updateSimState(int n, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = false;
        if (this.simState != n) {
            this.simState = n;
            bl4 = true;
        }
        if (this.isNadDataOnly != bl) {
            this.isNadDataOnly = bl;
            bl4 = true;
        }
        if (this.isPhoneOn != bl2) {
            this.isPhoneOn = bl2;
            bl4 = true;
        }
        if (this.isEsimCodedAndActiveAndLicensed != bl3) {
            this.isEsimCodedAndActiveAndLicensed = bl3;
            bl4 = true;
        }
        if (bl4) {
            this.updateErrorState();
        }
        if (n == 0 && bl && bl2 && this.simUsageIsToBeShown) {
            this.errorHandler.showUnlockPopup();
            this.log.log(-2137614336, "OnlineErrorState#updateSimState(): Data only, NO PIN expected, no SIM Usage for this SIM => show sim usage popup");
        }
    }

    void updateProfileState(int n) {
        this.profileState = n;
        this.resetConfirmations();
        if (n == -1) {
            this.errorHandler.signalProfileLoss();
            this.settingGeneral = 3;
            this.settingPermissionMmi = -1;
            this.settingPermissionWlan = -1;
        }
        this.updateErrorState();
    }

    private void resetConfirmations() {
        this.log.log(-2137614336, "OnlineErrorState#resetConfirmations(): SIM state has changed, resetting confirmation models");
        this.resetConfirmationMmi();
        this.resetConfirmationWlan();
        this.resetConfirmationRoaming();
        this.setRoamingState(false);
    }

    private void resetConfirmationMmi() {
        this.confirmationMmi = false;
        this.onlineConfirmed.setValue(0);
    }

    private void resetConfirmationWlan() {
        this.confirmationWlan = false;
        this.onlineHotspotConfirmed.setValue(0);
    }

    private void resetConfirmationRoaming() {
        this.confirmationRoaming = false;
        this.roamingConfirmed.setValue(0);
    }

    void updatePermissionGeneral(int n) {
        this.settingGeneral = n;
        this.resetConfirmationMmi();
        this.resetConfirmationWlan();
        this.resetConfirmationRoaming();
        this.updateErrorState();
        this.checkRoamingPopup();
    }

    private void checkRoamingPopup() {
        if (this.settingGeneral == 1 && this.settingPermissionRoaming == 0 && this.currentErrorMmi == 18) {
            this.log.log(-2137614336, "OnlineErrorState#checkRoamingPopup(): Showing ROAMING DEACTIVATED for user action in settings menu");
            this.errorHandler.showPopup(this.currentErrorMmi, 0);
        }
    }

    void updatePermission(int n, int n2) {
        if (n == 8) {
            this.settingPermissionMmi = n2;
            this.resetConfirmationMmi();
            this.resetConfirmationRoaming();
        } else if (n == 6) {
            this.settingPermissionWlan = n2;
            this.resetConfirmationWlan();
        }
        this.updateErrorState();
    }

    void updatePermissionRoaming(int n) {
        this.settingPermissionRoaming = n;
        if (n == 0) {
            this.resetConfirmationRoaming();
        }
        this.updateErrorState();
    }

    void updateConfirmationDisclaimer() {
        this.disclaimerConfirmed.setValue(1);
        this.updateErrorState();
    }

    void updateConfirmationAudiConnect() {
        this.confirmationMmi = true;
        this.onlineConfirmed.setValue(1);
        this.updateErrorState();
    }

    void updateConfirmationWlan() {
        this.confirmationWlan = true;
        this.onlineHotspotConfirmed.setValue(1);
        this.updateErrorState();
    }

    void updateConfirmationRoaming() {
        this.confirmationRoaming = true;
        this.roamingConfirmed.setValue(1);
        this.updateErrorState();
    }

    void updateRoamingState(boolean bl) {
        this.setRoamingState(bl);
        this.updateErrorState();
    }

    private void setRoamingState(boolean bl) {
        this.roamingActive = bl;
        this.roamingChoice.setValue(bl ? 1 : 0);
    }

    private void updateErrorState() {
        int n;
        int n2;
        if (this.isLocalNetMode) {
            n2 = 0;
            n = 0;
        } else {
            int n3 = this.determineNewError();
            if (n3 == 0) {
                n2 = this.determinePermissionMmi();
                n = this.determinePermissionWlan();
            } else {
                n2 = n3;
                n = n3;
            }
        }
        if (n2 != this.currentErrorMmi || n != this.currentErrorWlan) {
            this.currentErrorMmi = n2;
            this.currentErrorWlan = n;
            this.log.log(-2137614336, "OnlineErrorState#updateErrorState(): New error state: mmi=%1, wlan=%2", (Object)ERROR_NAMES[n2], (Object)ERROR_NAMES[n]);
            this.errorHandler.updateErrorState(n2, n);
            this.mmiErrorChoice.setValue(n2);
        } else {
            this.log.log(-2137614336, "OnlineErrorState#updateErrorState(): Nothing changed, doing nothing: mmi=%1, wlan=%2", (Object)ERROR_NAMES[n2], (Object)ERROR_NAMES[n]);
        }
    }

    private int determineNewError() {
        if (this.checkUpdateSimState()) {
            switch (this.simState) {
                case 10: {
                    return 10;
                }
                case 2: {
                    return this.isTetheringActive() ? 0 : 3;
                }
                case 1: {
                    return this.isTetheringActive() ? 0 : 2;
                }
                case 5: {
                    return 6;
                }
                case 7: {
                    return 8;
                }
                case 6: {
                    return 7;
                }
                case 4: {
                    return 5;
                }
                case 3: {
                    return this.isTetheringActive() ? 0 : 4;
                }
                case 8: {
                    return 9;
                }
                case 9: {
                    return this.isTetheringActive() ? 0 : 1;
                }
                case 12: {
                    return this.isTetheringActive() ? 0 : 22;
                }
                case 11: {
                    return this.isTetheringActive() ? 0 : 21;
                }
            }
            this.log.log(-1601830656, "OnlineErrorState#determineNewError(): Missing mapping: %1", (long)this.simState);
            return 9;
        }
        if (this.isEsimCodedAndActiveAndLicensed) {
            return 0;
        }
        if (this.profileState != 1) {
            return this.profileState == 2 ? 13 : (this.profileState == -1 ? 11 : 12);
        }
        return 0;
    }

    private boolean checkUpdateSimState() {
        return this.simState != 0 && (this.profileState != 1 || this.isTetheringActive()) || this.simState == 10;
    }

    private boolean isTetheringActive() {
        return this.hmiService.getChoiceModel(1663444480).getValue() == 1;
    }

    private int determinePermissionMmi() {
        int n;
        if (this.settingPermissionMmi == 0) {
            n = 17;
        } else if (this.settingPermissionMmi == -1) {
            n = this.returnErrorSimPending();
        } else if (this.isEsimCodedAndActiveAndLicensed) {
            this.permissionChoice.setValue(1);
            n = 16;
        } else {
            n = this.settingGeneral == 1 ? (this.roamingActive ? this.checkRoamingPermissionMmi() : 0) : (this.settingGeneral == 0 ? (this.confirmationMmi ? (this.roamingActive ? this.checkRoamingPermissionMmi() : 16) : 14) : (this.settingGeneral == 3 ? this.returnErrorSimPending() : 15));
        }
        return n;
    }

    private int checkRoamingPermissionMmi() {
        return this.settingPermissionRoaming == 1 ? (this.confirmationRoaming ? 20 : 19) : 18;
    }

    private int determinePermissionWlan() {
        int n = this.settingPermissionWlan == 0 ? 17 : (this.settingPermissionWlan == -1 ? this.returnErrorSimPending() : (this.isEsimCodedAndActiveAndLicensed ? 16 : (this.settingGeneral == 1 ? (this.roamingActive ? this.checkRoamingPermissionWlan() : 0) : (this.settingGeneral == 0 ? (this.confirmationWlan ? (this.roamingActive ? this.checkRoamingPermissionWlan() : 16) : 14) : (this.settingGeneral == 3 ? this.returnErrorSimPending() : 15)))));
        return n;
    }

    private int returnErrorSimPending() {
        return this.isNadDataOnly ? 21 : 22;
    }

    private int checkRoamingPermissionWlan() {
        return this.settingPermissionRoaming == 1 ? 20 : 18;
    }

    public String toString() {
        return new StringBuffer().append("MMI: ").append(ERROR_NAMES[this.currentErrorMmi]).append("\nWLAN: ").append(ERROR_NAMES[this.currentErrorWlan]).toString();
    }

    public void updateSimUsageToBeShown(boolean bl) {
        this.simUsageIsToBeShown = bl;
        this.updateSimState(this.simState, this.isNadDataOnly, this.isPhoneOn, this.isEsimCodedAndActiveAndLicensed);
    }

    static {
        ERROR_NAMES = new String[]{"ERROR_NONE", "ERROR_SIM_STATE_NAD_OFF", "ERROR_SIM_STATE_NA_DATA_ONLY", "ERROR_SIM_STATE_NA", "ERROR_SIM_STATE_SAP_NA", "ERROR_SIM_STATE_SAP", "ERROR_SIM_STATE_PIN_REQUIRED", "ERROR_SIM_STATE_PUK_REQUIRED", "ERROR_SIM_STATE_PUK_BLOCKED", "ERROR_SIM_STATE_FAILURE", "ERROR_SIM_STATE_GSM_CALL_ACTIVE", "ERROR_PROFILE_INVALID", "ERROR_PROFILE_NA", "ERROR_PROFILE_MULTI", "ERROR_GENERAL_PERMISSION_MANUAL", "ERROR_GENERAL_PERMISSION_NEVER", "ERROR_PERMISSION_CONFIRMED", "ERROR_DATA_DEACTIVATED", "ERROR_ROAMING_DEACTIVATED", "ERROR_ROAMING_ALLOWED", "ERROR_ROAMING_CONFIRMED", "ERROR_SIM_STATE_PENDING_DATA_ONLY", "ERROR_SIM_STATE_PENDING"};
    }
}

