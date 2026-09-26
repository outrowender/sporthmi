/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.dvdvideo.AbstractDVDVideoSettingsParentalManagement;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractParentalManagementController
extends AbstractMediaTerminalComponent
implements TimerListener {
    private static final int MAX_WRONG_PASSWORD_TRIALS;
    private static final int STATE_PW_OK;
    private static final int STATE_PW_WRONG;
    private static final int STATE_PW_BLOCKED;
    private static final int CHANGE_PW_SPELLER_STATE_FIRST;
    private static final int CHANGE_PW_SPELLER_STATE_REPEAT;
    private static final String LOGCLASS;
    private final Timer blockedByWrongPasswordTimer = new Timer("BlockedByWrongPasswordTimer", 0, true, this);
    private int passwordTrialCount = 0;
    private String newPassword;
    protected AbstractDVDVideoSettingsParentalManagement pmlSettings;

    public AbstractParentalManagementController(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"AbstractParentalManagementController");
        this.blockedByWrongPasswordTimer.setTimerListener(this);
        this.pmlSettings.init();
        this.setChangeSpellerMessage(0);
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"AbstractParentalManagementController");
        this.pmlSettings.deinit();
    }

    protected void resetSettings() {
        this.pmlSettings.resetSettings();
        this.setPassword("1234");
    }

    protected abstract void triggerLeaveEntryPrompt() {
    }

    protected abstract void triggerChangeToConfirmationPrompt() {
    }

    protected abstract void triggerLeaveChangePasswordPrompt() {
    }

    protected abstract String getEntrySpellerPassword() {
    }

    protected abstract String getChangeSpellerPassword() {
    }

    protected abstract void clearEntrySpellerPassword() {
    }

    protected abstract void clearChangeSpellerPassword() {
    }

    protected abstract void setChangePasswordPromptState(int n) {
    }

    protected abstract void setChangeSpellerMessage(int n) {
    }

    protected abstract int getChangeSpellerMessage() {
    }

    protected abstract void setEntryPromptState(int n) {
    }

    protected abstract BaseListModelApp getPMLBaseListModel() {
    }

    protected abstract ChoiceModelApp getPMLPreviewModel() {
    }

    protected void entrySpellerSelected() {
        this.logger.hmi().log(1078071040, "[%1.entrySpellerSelected] entered.", (Object)"AbstractParentalManagementController");
        String string = this.getEntrySpellerPassword();
        this.clearEntrySpellerPassword();
        if (string.equals(this.getPassword())) {
            this.passwordTrialCount = 0;
            this.setEntryPromptState(0);
        } else {
            ++this.passwordTrialCount;
            if (this.passwordTrialCount >= 3) {
                this.setEntryPromptState(2);
                this.blockedByWrongPasswordTimer.start();
            } else {
                this.setEntryPromptState(1);
            }
        }
        this.triggerLeaveEntryPrompt();
    }

    protected void changeSpellerSelected() {
        this.logger.hmi().log(1078071040, "[%1.changeSpellerSelected]", (Object)"AbstractParentalManagementController");
        if (this.getChangeSpellerMessage() == 0) {
            this.changeSpellerSelectedFirstTime();
        } else {
            this.changeSpellerSelectedConfirmation();
        }
    }

    private void changeSpellerSelectedFirstTime() {
        this.logger.hmi().log(1078071040, "[%1.changeSpellerSelectedFirstTime] entered.", (Object)"AbstractParentalManagementController");
        this.newPassword = this.getChangeSpellerPassword();
        this.logger.hmi().log(1078071040, "[%1.changeSpellerSelectedFirstTime] new password is '%2'.", (Object)"AbstractParentalManagementController", (Object)this.newPassword);
        this.setChangeSpellerMessage(1);
        this.clearChangeSpellerPassword();
        this.triggerChangeToConfirmationPrompt();
    }

    private void changeSpellerSelectedConfirmation() {
        this.logger.hmi().log(1078071040, "[%1.changeSpellerSelectedConfirmation] entered.", (Object)"AbstractParentalManagementController");
        String string = this.getChangeSpellerPassword();
        this.logger.hmi().log(1078071040, "[%1.changeSpellerSelectedConfirmation] repeated password is '%2'.", (Object)"AbstractParentalManagementController", (Object)string);
        if (this.newPassword.equals(string)) {
            this.setChangePasswordPromptState(0);
            this.setPassword(this.newPassword);
        } else {
            this.setChangePasswordPromptState(1);
        }
        this.setChangeSpellerMessage(0);
        this.triggerLeaveChangePasswordPrompt();
        this.clearChangeSpellerPassword();
    }

    private String getPassword() {
        String string = this.getTerminal().getMediaPersistence().getGlobalStringProperty("GLOBAL_KEY_DVDV_PM_PASSWORD");
        this.logger.main().log(1078071040, "[%1.getPassword] getting current password from persistence: '%2'.", (Object)"AbstractParentalManagementController", (Object)string);
        if (string == null) {
            string = "1234";
            this.logger.main().log(1078071040, "[%1.getPassword] got null from persistence, using default value: '%2'.", (Object)"AbstractParentalManagementController", (Object)string);
        }
        return string;
    }

    private void setPassword(String string) {
        this.logger.main().log(1078071040, "[%1.setPassword] storing new password in persistence.", (Object)"AbstractParentalManagementController");
        this.getTerminal().getMediaPersistence().setGlobalStringProperty("GLOBAL_KEY_DVDV_PM_PASSWORD", string);
    }

    @Override
    public void fireTimer(Timer timer) {
        this.setEntryPromptState(0);
        this.passwordTrialCount = 0;
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("AbstractParentalManagementController").append("@").append(this.hashCode());
        return buffer.toString();
    }
}

