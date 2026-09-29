/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.privacysettings;

import de.audi.app.online.privacysettings.PrivacySettingsController$TelServiceCallback;
import de.audi.app.online.privacysettings.PrivacySettingsModelAccess;
import de.audi.app.online.privacysettings.PrivacySettingsStorageAccess;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.phone.ITelServiceConnectivity;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.AbstractStandardController;
import de.audi.tghu.online.app.standard.IStandardController;

public class PrivacySettingsController
implements ButtonListener,
MsgListener {
    static final int PRIVACY_MODE_ON;
    static final int PRIVACY_MODE_OFF;
    private ITelServiceConnectivity telService;
    private ButtonModelApp deactivateNadButtonModel;
    private LogChannel logChannel;
    private IStandardController standardController;
    private ChoiceModelApp privacyModeOnOffChoice;
    private OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem;
    private ButtonModelApp activateNadButtonModel;
    private RemoteHMIService remoteHMIService;
    private PrivacySettingsStorageAccess privacySettingsStorageAccess;
    private boolean nadModuleCoded;
    private boolean cgwOnlyCoded;
    private boolean privacyModeFeatureAvailable = true;

    public PrivacySettingsController(PrivacySettingsModelAccess privacySettingsModelAccess, PrivacySettingsStorageAccess privacySettingsStorageAccess, boolean bl, boolean bl2, LogChannel logChannel) {
        this.nadModuleCoded = bl;
        this.cgwOnlyCoded = bl2;
        this.deactivateNadButtonModel = privacySettingsModelAccess.deactivateNadButtonModel;
        if (bl2) {
            this.deactivateNadButtonModel.setStatus(1);
        }
        this.activateNadButtonModel = privacySettingsModelAccess.activateNadButtonModel;
        this.privacyModeOnOffChoice = privacySettingsModelAccess.privacyModeOnOffChoice;
        this.privacySettingsStorageAccess = privacySettingsStorageAccess;
        this.logChannel = logChannel;
        this.registerAsButtonListener();
    }

    public void setPrivacyModeFeatureAvailable(boolean bl) {
        this.logChannel.log(1078071040, "PrivacySettingsController#setPrivacyModeFeatureAvailable: %1", bl);
        this.privacyModeFeatureAvailable = bl;
    }

    public void initFromPersistence() {
        if (!this.nadModuleCoded) {
            this.logChannel.log(1078071040, "PrivacySettingsController#initFromPersistence: No NAD module available; initializing the privacy mode using the persisted value");
            this.triggerPrivacyMode(this.privacySettingsStorageAccess.getPersistedPrivacyMode());
        } else {
            this.logChannel.log(1078071040, "PrivacySettingsController#initFromPersistence: NAD module available and responsible for initializing the privacy mode");
        }
    }

    private void registerAsButtonListener() {
        if (this.deactivateNadButtonModel != null) {
            this.deactivateNadButtonModel.setButtonListener(this);
        }
        if (this.activateNadButtonModel != null) {
            this.activateNadButtonModel.setButtonListener(this);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.deactivateNadButtonModel.getID()) {
            this.triggerSMTransition(n3, this.deactivateNadButtonModel);
            this.triggerPrivacyMode(true);
        } else if (n == this.activateNadButtonModel.getID()) {
            this.triggerSMTransition(n3, this.activateNadButtonModel);
            this.triggerPrivacyMode(false);
        }
    }

    private void triggerPrivacyMode(boolean bl) {
        if (this.isPrivacyModeActive() == bl) {
            this.logChannel.log(-1601830656, "PrivacySettingsController#triggerPrivacyMode: Privacy mode already in requested state %1, no action", bl);
            return;
        }
        this.triggerMainUnitPrivacySettingWithPersistence(bl);
        this.triggerPrivacyModeFlags(bl);
        this.triggerNadDeactivation(bl);
        this.triggerCgwDeactivation(bl);
        this.triggerRHMIPrivacyModeAction(bl);
    }

    private void triggerMainUnitPrivacySettingWithPersistence(boolean bl) {
        this.privacyModeOnOffChoice.setValue(bl ? 1 : 0);
        this.privacySettingsStorageAccess.setPersistedPrivacyMode(bl);
    }

    private void triggerPrivacyModeFlags(boolean bl) {
        if (this.onlineServiceRegistrationSubsystem == null) {
            this.logChannel.log(-1601830656, "PrivacySettingsController#triggerPrivacyModeFlags: No onlineServiceRegistrationSubsystem was registered, no calls are made");
        } else {
            this.onlineServiceRegistrationSubsystem.triggerPrivacyMode(bl);
        }
    }

    private void triggerCgwDeactivation(boolean bl) {
        if (this.standardController == null) {
            this.logChannel.log(-1601830656, "PrivacySettingsController#triggerCgwDeactivation: No cGW gateway was registered, no calls are made");
        } else {
            this.logChannel.log(-2137614336, "PrivacySettingsController#triggerCgwDeactivation: Call to deactivate cGW module");
            this.standardController.triggerPrivacyMode(bl);
        }
    }

    private void triggerNadDeactivation(boolean bl) {
        if (this.telService == null) {
            this.logChannel.log(-1601830656, "PrivacySettingsController#triggerNadDeactivation: No telService was registered, no calls to NAD module!");
        } else if (this.nadModuleCoded) {
            this.logChannel.log(-2137614336, "PrivacySettingsController#triggerNadDeactivation: Call to deactivate NAD module");
            this.telService.changePhoneModulePowerState(!bl, new PrivacySettingsController$TelServiceCallback(this));
        } else {
            this.logChannel.log(1078071040, "PrivacySettingsController#triggerNadDeactivation: NAD module is not available. Do nothing.");
        }
    }

    private void triggerSMTransition(int n, ButtonModelApp buttonModelApp) {
        this.logChannel.log(-2137614336, "PrivacySettingsController#triggerSMTransition: triggering SM transition");
        buttonModelApp.fireEvent(n);
    }

    @Override
    public void processMsg(int n) {
        if (!this.nadModuleCoded || this.cgwOnlyCoded || !this.privacyModeFeatureAvailable) {
            this.logChannel.log(-1601830656, "PrivacySettingsController#processMsg: NAD power state change ignored! nad:%1 cgw:%2 privacy:%3", this.nadModuleCoded, this.cgwOnlyCoded, this.privacyModeFeatureAvailable);
            return;
        }
        this.logChannel.log(-2137614336, "PrivacySettingsController#processMsg: %2, current privacy mode is %1", this.isPrivacyModeActive(), (long)n);
        this.setDeactivateButtonStatus(n);
        if (n == 208 && this.isPrivacyModeActive()) {
            this.triggerMainUnitPrivacySettingWithPersistence(false);
            this.triggerPrivacyModeFlags(false);
            this.triggerCgwDeactivation(false);
            this.triggerRHMIPrivacyModeAction(false);
        } else if (n == 209 && !this.isPrivacyModeActive()) {
            this.triggerMainUnitPrivacySettingWithPersistence(true);
            this.triggerPrivacyModeFlags(true);
            this.triggerCgwDeactivation(true);
            this.triggerRHMIPrivacyModeAction(true);
        }
        if (this.standardController instanceof AbstractStandardController && (n == 208 || n == 209)) {
            AbstractStandardController abstractStandardController = (AbstractStandardController)this.standardController;
            abstractStandardController.triggerCgwSync(this.isPrivacyModeActive());
            abstractStandardController.reportNadModuleFeedback();
        }
    }

    private void setDeactivateButtonStatus(int n) {
        if (n == 208) {
            this.deactivateNadButtonModel.setStatus(1);
        } else if (n == 209 || n == 210) {
            this.deactivateNadButtonModel.setStatus(0);
        }
    }

    private boolean isPrivacyModeActive() {
        return this.privacyModeOnOffChoice.getValue() == 1;
    }

    public void setTelService(ITelServiceConnectivity iTelServiceConnectivity) {
        this.logChannel.log(-2137614336, "PrivacySettingsController#setTelService: %1", (Object)iTelServiceConnectivity);
        this.telService = iTelServiceConnectivity;
        this.telService.requestCurrentNadModulePowerState();
    }

    public void setOnlineServiceRegistrationSubsystem(OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        this.onlineServiceRegistrationSubsystem = onlineServiceRegistrationSubsystem;
    }

    private void triggerRHMIPrivacyModeAction(boolean bl) {
        if (this.remoteHMIService == null) {
            this.logChannel.log(1078071040, "PrivacySettingsController#triggerRHMIPrivacyModeAction: No action, RHMI not coded?");
            return;
        }
        this.remoteHMIService.triggerPrivacyMode(bl);
    }

    public void setOnlineEvoStandardController(IStandardController iStandardController) {
        this.standardController = iStandardController;
        if (this.telService != null) {
            this.telService.requestCurrentNadModulePowerState();
        }
    }

    public void setRemoteHMIService(RemoteHMIService remoteHMIService) {
        this.remoteHMIService = remoteHMIService;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    static /* synthetic */ LogChannel access$000(PrivacySettingsController privacySettingsController) {
        return privacySettingsController.logChannel;
    }
}

