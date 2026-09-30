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
    private static final int MAX_WRONG_PASSWORD_TRIALS = 3;
    private static final int STATE_PW_OK = 0;
    private static final int STATE_PW_WRONG = 1;
    private static final int STATE_PW_BLOCKED = 2;
    private static final int CHANGE_PW_SPELLER_STATE_FIRST = 0;
    private static final int CHANGE_PW_SPELLER_STATE_REPEAT = 1;
    private static final String LOGCLASS = "AbstractParentalManagementController";
    private final Timer blockedByWrongPasswordTimer = new Timer("BlockedByWrongPasswordTimer", 60000L, true, this);
    private int passwordTrialCount = 0;
    private String newPassword;
    protected AbstractDVDVideoSettingsParentalManagement pmlSettings;

    public AbstractParentalManagementController(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.blockedByWrongPasswordTimer.setTimerListener(this);
        this.pmlSettings.init();
        this.setChangeSpellerMessage(0);
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.pmlSettings.deinit();
    }

    protected void resetSettings() {
        this.pmlSettings.resetSettings();
        this.setPassword("1234");
    }

    protected abstract void triggerLeaveEntryPrompt();

    protected abstract void triggerChangeToConfirmationPrompt();

    protected abstract void triggerLeaveChangePasswordPrompt();

    protected abstract String getEntrySpellerPassword();

    protected abstract String getChangeSpellerPassword();

    protected abstract void clearEntrySpellerPassword();

    protected abstract void clearChangeSpellerPassword();

    protected abstract void setChangePasswordPromptState(int var1);

    protected abstract void setChangeSpellerMessage(int var1);

    protected abstract int getChangeSpellerMessage();

    protected abstract void setEntryPromptState(int var1);

    protected abstract BaseListModelApp getPMLBaseListModel();

    protected abstract ChoiceModelApp getPMLPreviewModel();

    protected void entrySpellerSelected() {
        this.logger.hmi().log(1000000, "[%1.entrySpellerSelected] entered.", (Object)LOGCLASS);
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
        this.logger.hmi().log(1000000, "[%1.changeSpellerSelected]", (Object)LOGCLASS);
        if (this.getChangeSpellerMessage() == 0) {
            this.changeSpellerSelectedFirstTime();
        } else {
            this.changeSpellerSelectedConfirmation();
        }
    }

    private void changeSpellerSelectedFirstTime() {
        this.logger.hmi().log(1000000, "[%1.changeSpellerSelectedFirstTime] entered.", (Object)LOGCLASS);
        this.newPassword = this.getChangeSpellerPassword();
        this.logger.hmi().log(1000000, "[%1.changeSpellerSelectedFirstTime] new password is '%2'.", (Object)LOGCLASS, (Object)this.newPassword);
        this.setChangeSpellerMessage(1);
        this.clearChangeSpellerPassword();
        this.triggerChangeToConfirmationPrompt();
    }

    private void changeSpellerSelectedConfirmation() {
        this.logger.hmi().log(1000000, "[%1.changeSpellerSelectedConfirmation] entered.", (Object)LOGCLASS);
        String string = this.getChangeSpellerPassword();
        this.logger.hmi().log(1000000, "[%1.changeSpellerSelectedConfirmation] repeated password is '%2'.", (Object)LOGCLASS, (Object)string);
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
        this.logger.main().log(1000000, "[%1.getPassword] getting current password from persistence: '%2'.", (Object)LOGCLASS, (Object)string);
        if (string == null) {
            string = "1234";
            this.logger.main().log(1000000, "[%1.getPassword] got null from persistence, using default value: '%2'.", (Object)LOGCLASS, (Object)string);
        }
        return string;
    }

    private void setPassword(String string) {
        this.logger.main().log(1000000, "[%1.setPassword] storing new password in persistence.", (Object)LOGCLASS);
        this.getTerminal().getMediaPersistence().setGlobalStringProperty("GLOBAL_KEY_DVDV_PM_PASSWORD", string);
    }

    public void fireTimer(Timer timer) {
        this.setEntryPromptState(0);
        this.passwordTrialCount = 0;
    }

    public void cancelTimer(Timer timer) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

