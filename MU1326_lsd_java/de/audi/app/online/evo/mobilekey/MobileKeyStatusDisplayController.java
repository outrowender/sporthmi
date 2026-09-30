/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.mobilekey;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.mobilekey.MobileKeyPopupController;
import de.audi.app.online.evo.mobilekey.MobileKeyStatusDisplayModelAccess;
import de.audi.app.online.evo.mobilekey.MobileKeyStatusDisplayStorageAccess;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.FactResetService;
import de.audi.atip.interapp.bap.eni.data.MobileKeyCount;
import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup;
import de.audi.atip.interapp.eni.ENIMobileKeyStatusDisplayListener;
import de.audi.atip.interapp.eni.ENIServiceOnline;
import de.audi.atip.interapp.online.MobileKeyStatusDisplayService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.mobilekey.FactoryResetState;
import de.audi.tghu.online.app.standard.IMobileKeyLicenseListener;

public class MobileKeyStatusDisplayController
implements ENIMobileKeyStatusDisplayListener,
ButtonListener,
FactoryResetState,
IMobileKeyLicenseListener {
    private static final int KEYCARD_PHONEBOX_HINT_POPUP_DEACTIVATE = 0;
    private static final int KEYCARD_PHONEBOX_HINT_POPUP_ACTIVATE = 1;
    private static final int KEY_COUNT_BACKEND_STATE_NORMAL_OPERATION = 1;
    private static final int KEY_COUNT_BACKEND_STATE_DELETION_IN_PROGRESS = 2;
    private ENIServiceOnline eniServiceOnline;
    private MobileKeyStatusDisplayService displayService;
    private MobileKeyStatusDisplayModelAccess modelAccess;
    private MobileKeyStatusDisplayStorageAccess storageAccess;
    private MobileKeyPopupController popupController = null;
    private HMIService hmiService;
    private IFrameworkAccess framework;
    private RemoteHMIServiceEvo remoteHmiService;
    private FactResetService factoryReset = null;
    private LogChannel logChannel;
    private boolean mobileKeyLicenseValid = true;
    private MobileKeySetup lastMobileKeySetup = null;
    private MobileKeyCount lastMobileKeyCount = null;
    private boolean fleetModeActive = true;
    private int carKeyType = 0;

    public MobileKeyStatusDisplayController(MobileKeyStatusDisplayModelAccess mobileKeyStatusDisplayModelAccess, MobileKeyStatusDisplayStorageAccess mobileKeyStatusDisplayStorageAccess, HMIService hMIService, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, boolean bl) {
        this.modelAccess = mobileKeyStatusDisplayModelAccess;
        this.fleetModeActive = bl;
        mobileKeyStatusDisplayModelAccess.getServiceActivateButton().setButtonListener(this);
        mobileKeyStatusDisplayModelAccess.getServiceDeactivateButton().setButtonListener(this);
        mobileKeyStatusDisplayModelAccess.getServiceResetButton().setButtonListener(this);
        this.storageAccess = mobileKeyStatusDisplayStorageAccess;
        this.hmiService = hMIService;
        this.framework = iFrameworkAccess;
        this.logChannel = logChannel;
        if (!this.isMobileKeyCoded()) {
            logChannel.log(1000000, "MobileKeyStatusDisplayController#init: Mobile Key not coded, set value to physical key.");
            mobileKeyStatusDisplayModelAccess.updatecarKeyTypeChoice(2);
            this.fleetModeActive = false;
        } else {
            logChannel.log(1000000, "MobileKeyStatusDisplayController#init: Mobile Key not coded, set value to mobile key until we get an update.");
            mobileKeyStatusDisplayModelAccess.updatecarKeyTypeChoice(1);
        }
        this.updateFactoryResetAllowed();
    }

    public void updateMobileKeyLicense(boolean bl) {
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#updateMobileKeyLicense: valid: %1", bl);
        this.mobileKeyLicenseValid = bl;
        this.updateDisplayService();
    }

    private boolean isMobileKeyCoded() {
        return this.framework.getSysApp().getAdaptationANP().isMobileDeviceKeyProfile();
    }

    public void setEniServiceOnline(ENIServiceOnline eNIServiceOnline) {
        this.eniServiceOnline = eNIServiceOnline;
    }

    public void setDisplayService(MobileKeyStatusDisplayService mobileKeyStatusDisplayService) {
        this.displayService = mobileKeyStatusDisplayService;
        this.updateDisplayService();
    }

    public void setRemoteHmiService(RemoteHMIServiceEvo remoteHMIServiceEvo) {
        if (remoteHMIServiceEvo != null) {
            this.remoteHmiService = remoteHMIServiceEvo;
            remoteHMIServiceEvo.triggerFleetMode(this.fleetModeActive);
        }
    }

    public void setFactResetService(FactResetService factResetService) {
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#setFactResetService: %1", (Object)factResetService);
        if (factResetService != null) {
            this.factoryReset = factResetService;
            this.updateFactoryResetAllowed();
        }
    }

    private int mapCarKeyType(int n) {
        int n2 = 0;
        switch (n) {
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 0;
                break;
            }
            default: {
                this.logChannel.log(1000000, "MobileKeyStatusDisplayController#mapCarKeyType keyType %1 is not valid.", (long)n);
                n2 = -1;
            }
        }
        return n2;
    }

    public MobileKeySetup getLastMobileKeySetup() {
        return this.lastMobileKeySetup;
    }

    public void evaluateModificationReason(int n, String string) {
        int n2 = this.mapCarKeyType(n);
        if (n2 >= 0) {
            this.logChannel.log(1000000, "MobileKeyStatusDisplayController#evaluateModificationReason update for %1 to key %2", (Object)string, (long)n2);
            this.modelAccess.updatecarKeyTypeChoice(n2);
            this.carKeyType = n2;
            this.updateFactoryResetAllowed();
        }
    }

    public boolean isFactoryResetAllowed() {
        boolean bl = !this.fleetModeActive && (this.carKeyType == 2 || !this.isMobileKeyCoded());
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#isFactoryResetAllowed fleet: %1 key: %2, allowed: %3", (Object)Boolean.toString(this.fleetModeActive), (Object)Integer.toString(this.carKeyType), (Object)Boolean.toString(bl));
        return bl;
    }

    private void updateFactoryResetAllowed() {
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#updateFactoryResetAllowed factoryReset: %1 ", (Object)this.factoryReset);
        if (this.factoryReset != null) {
            boolean bl = this.isFactoryResetAllowed();
            this.logChannel.log(1000000, "MobileKeyStatusDisplayController#updateFactoryResetAllowed factoryReset: %1, allowed: %2 ", (Object)this.factoryReset, (Object)Boolean.toString(bl));
            this.factoryReset.setAudiConnectResetBlocked(!bl);
        }
    }

    public void onMobDevKeySetup(MobileKeySetup mobileKeySetup) {
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#onMobDevKeySetup mobileKeySetup: %1", (Object)mobileKeySetup);
        if (mobileKeySetup != null) {
            this.lastMobileKeySetup = mobileKeySetup;
            this.evaluateModificationReason(mobileKeySetup.getModificationReason_Setup(), "Setup");
            this.evaluateModificationReason(mobileKeySetup.getModificationReason_Smartcard(), "Smartcard");
            this.evaluateModificationReason(mobileKeySetup.getModificationReason_Reset(), "Reset");
            this.modelAccess.updateServiceActive(mobileKeySetup.isMobDevKeyEnabled());
            this.updateDisplayService();
            this.modelAccess.updateServiceActiveStateCanBeModified(mobileKeySetup.canBeModified_Setup());
            boolean bl = mobileKeySetup.isSmartCardEnabled();
            this.logChannel.log(10000000, "MobileKeyStatusDisplayController#onMobDevKeySetup smartCardEnabled set to: %1", bl);
            this.modelAccess.updateSmartCardEnabled(bl);
            if (this.hasActivationFailed(mobileKeySetup, bl)) {
                this.logChannel.log(10000000, "MobileKeyStatusDisplayController#onMobDevKeySetup smart card activation failed, attempting to display an error popup");
                this.showSmartCardActivationFailurePopups(mobileKeySetup);
            } else {
                this.showSmartCardPartialPopups(bl, this.storageAccess.wasSmartCardPreviouslyEnabled());
            }
            this.storageAccess.updateSmartCardStatus(bl);
        }
    }

    private boolean hasActivationFailed(MobileKeySetup mobileKeySetup, boolean bl) {
        return mobileKeySetup.isMobDevKeyEnabled() && !bl && mobileKeySetup.isSmartCardActivationRequested() && !mobileKeySetup.canBeModified_Smartcard();
    }

    private void showSmartCardActivationFailurePopups(MobileKeySetup mobileKeySetup) {
        if (mobileKeySetup.getModificationReason_Smartcard() == 2) {
            this.logChannel.log(10000000, "MobileKeyStatusDisplayController#showSmartCardActivationFailurePopups Keycard-Activation Error Popup");
            this.showPopup(2300008, false);
        } else if (mobileKeySetup.getModificationReason_Smartcard() == 6) {
            this.logChannel.log(10000000, "MobileKeyStatusDisplayController#showSmartCardActivationFailurePopups Keycard-Phonebox Hint Popup");
            this.showPopup(2300009, false);
        } else {
            this.logChannel.log(100000, "MobileKeyStatusDisplayController#showSmartCardActivationFailurePopups unsupported smart card modification reason: %1", (long)mobileKeySetup.getModificationReason_Smartcard());
        }
    }

    private void showSmartCardPartialPopups(boolean bl, boolean bl2) {
        if (bl) {
            this.logChannel.log(10000000, "MobileKeyStatusDisplayController#showSmartCardPartialPopups show Keycard-Activation Popup");
            this.hmiService.getChoiceModel(2301814).setValue(1);
            this.hmiService.getChoiceModel(2301814).setValue(0);
            this.hmiService.removePartialPopup(0, 2300208);
            this.showPopup(2300207, true);
        } else if (bl2) {
            this.logChannel.log(10000000, "MobileKeyStatusDisplayController#showSmartCardPartialPopups hide Keycard-Activation Popup - show Keycard-Deactivation Popup");
            this.hmiService.removePartialPopup(0, 2300207);
            this.showPopup(2300208, true);
        }
    }

    public void triggerSmartCardPopup() {
        this.showPopup(2300208, true);
    }

    public void onFleetModeAvailability(boolean bl) {
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#onFleetModeAvailability fleetModeEnabled: %1", bl);
        this.fleetModeActive = bl;
        this.modelAccess.updateFleetModeActive(bl);
        this.updateDisplayService();
        if (this.remoteHmiService != null) {
            this.remoteHmiService.triggerFleetMode(bl);
        }
        this.updateFactoryResetAllowed();
    }

    public void onMobileDeviceKeyCount(MobileKeyCount mobileKeyCount) {
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#onMobileDeviceKeyCount keyCount: %1", (Object)mobileKeyCount);
        if (mobileKeyCount != null) {
            this.lastMobileKeyCount = mobileKeyCount;
            this.modelAccess.updateKeyCount(mobileKeyCount.getKeyCountBackend());
            this.modelAccess.updateBackendState(this.keyBackendStateToHmiState(mobileKeyCount.getKeyCountBackendState()));
            this.updateDisplayService();
        }
    }

    private int keyBackendStateToHmiState(int n) {
        this.logChannel.log(10000000, "MobileKeyStatusDisplayController#keyBackendStateToHmiState backendState: %1", (long)n);
        int n2 = 1;
        if (n == 1) {
            n2 = 0;
        } else if (n == 2) {
            n2 = 2;
        }
        return n2;
    }

    private void updateDisplayService() {
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#updateDisplayService setup: %1, keys: %2", (Object)this.lastMobileKeySetup, (Object)this.lastMobileKeyCount);
        if (this.displayService != null) {
            int n;
            int n2 = 0;
            int n3 = 1;
            if (this.lastMobileKeyCount != null) {
                n2 = this.lastMobileKeyCount.getKeyCountBackend();
                n = this.lastMobileKeyCount.getKeyCountBackendState();
                if (n) {
                    n3 = 0;
                } else if (n == 2) {
                    n3 = 2;
                }
            }
            n = 0;
            if (this.lastMobileKeySetup != null) {
                n = this.lastMobileKeySetup.isMobDevKeyEnabled() ? 1 : 0;
            }
            if (!n) {
                this.logChannel.log(1000000, "MobileKeyStatusDisplayController#updateDisplayService service is disabled.");
                n3 = 3;
            }
            if (!this.mobileKeyLicenseValid) {
                this.logChannel.log(1000000, "MobileKeyStatusDisplayController#updateDisplayService service is not licensed.");
                n3 = 3;
            }
            this.displayService.updateServiceActiveState(n != 0);
            this.displayService.updateKeyCount(n2);
            this.displayService.updateBackendState(n3);
            this.displayService.updateFleetModeState(this.fleetModeActive);
        } else {
            this.logChannel.log(1000000, "MobileKeyStatusDisplayController#updateDisplayService displayService is null.");
        }
    }

    public void requestMobileDeviceKeyCount() {
        this.logChannel.log(10000000, "MobileKeyStatusDisplayController#requestMobileDeviceKeyCount");
        this.eniServiceOnline.requestMobileDeviceKeyCount();
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#keyPressed modelID: %1, keyID: %2, terminalID: %3", (long)n, (long)n2, (long)n3);
        if (n == this.modelAccess.getServiceActivateButton().getID()) {
            this.logChannel.log(10000000, "MobileKeyStatusDisplayController#keyPressed enabling mobile key");
            this.enableMobileKey(n, n3);
        } else if (n == this.modelAccess.getServiceDeactivateButton().getID()) {
            this.logChannel.log(10000000, "MobileKeyStatusDisplayController#keyPressed disabling mobile key");
            this.disableMobileKey(n, n3);
        } else if (n == this.modelAccess.getServiceResetButton().getID()) {
            this.logChannel.log(10000000, "MobileKeyStatusDisplayController#keyPressed re-setting mobile key to active state");
            this.enableMobileKey(n, n3);
        }
    }

    private void enableMobileKey(int n, int n2) {
        this.eniServiceOnline.enableMobileDeviceKey();
        this.hmiService.getButtonModel(n).fireEvent(n2);
    }

    private void disableMobileKey(int n, int n2) {
        this.eniServiceOnline.disableMobileDeviceKey();
        this.hmiService.getButtonModel(n).fireEvent(n2);
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void setMobileKeyPopupController(MobileKeyPopupController mobileKeyPopupController) {
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#setMobileKeyPopupController controller: %1", (Object)mobileKeyPopupController);
        this.popupController = mobileKeyPopupController;
    }

    public MobileKeyPopupController getMobileKeyPopupController() {
        return this.popupController;
    }

    private void showPopup(int n, boolean bl) {
        this.logChannel.log(1000000, "MobileKeyStatusDisplayController#showPopup id: %1, partial: %2", (Object)Integer.toString(n), (Object)Boolean.toString(bl));
        if (this.popupController != null) {
            this.popupController.showPopup(n, bl);
        } else {
            this.logChannel.log(10000, "MobileKeyStatusDisplayController#showPopup controller is null!");
        }
    }
}

