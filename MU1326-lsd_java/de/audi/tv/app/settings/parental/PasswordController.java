/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.settings.SettingsStorage;
import de.audi.tv.app.settings.parental.PasswordController$EnterPasswordListener;
import de.audi.tv.app.settings.parental.PasswordController$PasswordModifiedListener;
import de.audi.tv.app.util.SynchronizedInteger;

public class PasswordController
implements TimerListener {
    private static final int LOCK_STATE_UNLOCKED;
    private static final int LOCK_STATE_LOCKED_NEED_PWD;
    private static final int LOCK_STATE_LOCKED_FULL;
    private static final int DEFAULT_LOCK_STATE;
    private static final String DEFAULT_PML_PASSWORD;
    private static final int PASSWORDS_DIFFER;
    private static final int PASSWORDS_MATCH;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final ISettingListener provider;
    private String newPassword;
    private final SynchronizedInteger passwordResetCounter;
    private static final int MODE_CHECK_PWD;
    private static final int MODE_CHANGE_PWD_1;
    private static final int MODE_CHANGE_PWD_2;
    private int passwordMode = 0;
    private final ButtonModelApp ratingEnteredButton;
    private final ButtonModelApp ratingEnteredByOptionsButton;
    private final ButtonModelApp passwordChangeButton;
    private final ButtonModelApp passwordConfirmationButton;
    private final SpellerModelApp passwordSpeller;
    private final ChoiceModelApp lockStateChoice;
    private final ChoiceModelApp changePasswordChoice;
    private final Timer blockedByWrongPasswordTimer = new Timer("BlockedByWrongPasswordTimer", 0, true, this);

    public PasswordController(TVEnv tVEnv, SettingsStorage settingsStorage, ISettingListener iSettingListener) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.provider = iSettingListener;
        this.newPassword = null;
        this.passwordResetCounter = new SynchronizedInteger();
        this.ratingEnteredButton = tVEnv.getButtonModel(1420568320);
        this.ratingEnteredByOptionsButton = tVEnv.getButtonModel(-1163122944);
        this.passwordChangeButton = tVEnv.getButtonModel(1286350592);
        this.passwordSpeller = tVEnv.getVarExt().getParentalRatingPasswordSpeller(tVEnv.getHMIService());
        this.lockStateChoice = tVEnv.getChoiceModel(1319905024);
        this.changePasswordChoice = tVEnv.getChoiceModel(1370236672);
        this.passwordConfirmationButton = tVEnv.getButtonModel(-1129568512);
        PasswordController$EnterPasswordListener passwordController$EnterPasswordListener = new PasswordController$EnterPasswordListener(this, null);
        this.ratingEnteredButton.setButtonListener(passwordController$EnterPasswordListener);
        this.ratingEnteredByOptionsButton.setButtonListener(passwordController$EnterPasswordListener);
        this.passwordChangeButton.setButtonListener(passwordController$EnterPasswordListener);
        this.passwordSpeller.setSpellerListener(new PasswordController$PasswordModifiedListener(this, null));
        this.passwordConfirmationButton.setButtonListener(passwordController$EnterPasswordListener);
        this.lockStateChoice.setValue(1);
        this.passwordSpeller.setMinLength(4);
        this.passwordSpeller.setMaxLength(8);
    }

    public void deinit() {
        this.blockedByWrongPasswordTimer.cancel();
    }

    public String getPassword() {
        return this.storage.loadParentalPassword("1234");
    }

    public void setPassword(String string) {
        this.storage.saveParentalPassword(string);
    }

    @Override
    public void fireTimer(Timer timer) {
        this.env.lcHMI.log(-2137614336, "[PasswordController.fireTimer] parental rating unlocked");
        this.lockStateChoice.setValue(1);
        this.passwordResetCounter.setValue(0);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    private void checkConfirmation() {
        switch (this.passwordMode) {
            case 0: {
                if (this.passwordSpeller.getText().equals(this.getPassword())) {
                    this.env.lcHMI.log(-2137614336, "[PasswordController.PasswordModifiedListener] password correct");
                    this.passwordResetCounter.setValue(0);
                    this.lockStateChoice.setValue(0);
                    break;
                }
                this.passwordResetCounter.increment();
                this.env.lcHMI.log(-2137614336, "[PasswordController.PasswordModifiedListener] trial counter:[%1]", (Object)this.passwordResetCounter);
                if (this.passwordResetCounter.isGreaterThan(2)) {
                    this.lockStateChoice.setValue(2);
                    this.blockedByWrongPasswordTimer.start();
                    this.env.lcHMI.log(1078071040, "[PasswordController.PasswordModifiedListener] parental rating locked for 300 seconds");
                    break;
                }
                this.provider.passwordNeedsToBeEnteredAgain();
                break;
            }
            case 1: {
                this.newPassword = this.passwordSpeller.getText();
                this.changePasswordChoice.setValue(2);
                this.passwordSpeller.clear();
                this.passwordConfirmationButton.setStatus(0);
                this.passwordMode = 2;
                break;
            }
            case 2: {
                if (this.newPassword.equals(this.passwordSpeller.getText())) {
                    this.env.lcHMI.log(-2137614336, "[PasswordController.parentalRatingSecondPasswordEntered]");
                    this.setPassword(this.newPassword);
                    this.changePasswordChoice.setValue(1);
                    this.provider.passwordChanged();
                    break;
                }
                this.changePasswordChoice.setValue(0);
                this.provider.passwordNeedsToBeEnteredAgain();
                this.passwordMode = 1;
                break;
            }
        }
    }

    public void resetPasswordConfirmation() {
        this.passwordMode = 0;
        this.passwordSpeller.clear();
        this.passwordConfirmationButton.setStatus(0);
        if (this.lockStateChoice.getValue() == 0) {
            this.lockStateChoice.setValue(1);
        }
    }

    static /* synthetic */ TVEnv access$200(PasswordController passwordController) {
        return passwordController.env;
    }

    static /* synthetic */ ButtonModelApp access$300(PasswordController passwordController) {
        return passwordController.ratingEnteredByOptionsButton;
    }

    static /* synthetic */ ButtonModelApp access$400(PasswordController passwordController) {
        return passwordController.ratingEnteredButton;
    }

    static /* synthetic */ int access$502(PasswordController passwordController, int n) {
        passwordController.passwordMode = n;
        return passwordController.passwordMode;
    }

    static /* synthetic */ SpellerModelApp access$600(PasswordController passwordController) {
        return passwordController.passwordSpeller;
    }

    static /* synthetic */ ButtonModelApp access$700(PasswordController passwordController) {
        return passwordController.passwordConfirmationButton;
    }

    static /* synthetic */ ButtonModelApp access$800(PasswordController passwordController) {
        return passwordController.passwordChangeButton;
    }

    static /* synthetic */ void access$900(PasswordController passwordController) {
        passwordController.checkConfirmation();
    }
}

