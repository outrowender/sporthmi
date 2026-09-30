/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.settings.SettingsStorage;
import de.audi.tv.app.util.SynchronizedInteger;

public class PasswordController
implements TimerListener {
    private static final int LOCK_STATE_UNLOCKED = 0;
    private static final int LOCK_STATE_LOCKED_NEED_PWD = 1;
    private static final int LOCK_STATE_LOCKED_FULL = 2;
    private static final int DEFAULT_LOCK_STATE = 1;
    private static final String DEFAULT_PML_PASSWORD = "1234";
    private static final int PASSWORDS_DIFFER = 0;
    private static final int PASSWORDS_MATCH = 1;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final ISettingListener provider;
    private String newPassword;
    private final SynchronizedInteger passwordResetCounter;
    private static final int MODE_CHECK_PWD = 0;
    private static final int MODE_CHANGE_PWD_1 = 1;
    private static final int MODE_CHANGE_PWD_2 = 2;
    private int passwordMode = 0;
    private final ButtonModelApp ratingEnteredButton;
    private final ButtonModelApp ratingEnteredByOptionsButton;
    private final ButtonModelApp passwordChangeButton;
    private final ButtonModelApp passwordConfirmationButton;
    private final SpellerModelApp passwordSpeller;
    private final ChoiceModelApp lockStateChoice;
    private final ChoiceModelApp changePasswordChoice;
    private final Timer blockedByWrongPasswordTimer = new Timer("BlockedByWrongPasswordTimer", 300000L, true, this);

    public PasswordController(TVEnv tVEnv, SettingsStorage settingsStorage, ISettingListener iSettingListener) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.provider = iSettingListener;
        this.newPassword = null;
        this.passwordResetCounter = new SynchronizedInteger();
        this.ratingEnteredButton = tVEnv.getButtonModel(2600020);
        this.ratingEnteredByOptionsButton = tVEnv.getButtonModel(2600122);
        this.passwordChangeButton = tVEnv.getButtonModel(2600012);
        this.passwordSpeller = tVEnv.getVarExt().getParentalRatingPasswordSpeller(tVEnv.getHMIService());
        this.lockStateChoice = tVEnv.getChoiceModel(2600014);
        this.changePasswordChoice = tVEnv.getChoiceModel(2600017);
        this.passwordConfirmationButton = tVEnv.getButtonModel(2600124);
        EnterPasswordListener enterPasswordListener = new EnterPasswordListener();
        this.ratingEnteredButton.setButtonListener(enterPasswordListener);
        this.ratingEnteredByOptionsButton.setButtonListener(enterPasswordListener);
        this.passwordChangeButton.setButtonListener(enterPasswordListener);
        this.passwordSpeller.setSpellerListener(new PasswordModifiedListener());
        this.passwordConfirmationButton.setButtonListener(enterPasswordListener);
        this.lockStateChoice.setValue(1);
        this.passwordSpeller.setMinLength(4);
        this.passwordSpeller.setMaxLength(8);
    }

    public void deinit() {
        this.blockedByWrongPasswordTimer.cancel();
    }

    public String getPassword() {
        return this.storage.loadParentalPassword(DEFAULT_PML_PASSWORD);
    }

    public void setPassword(String string) {
        this.storage.saveParentalPassword(string);
    }

    public void fireTimer(Timer timer) {
        this.env.lcHMI.log(10000000, "[PasswordController.fireTimer] parental rating unlocked");
        this.lockStateChoice.setValue(1);
        this.passwordResetCounter.setValue(0);
    }

    public void cancelTimer(Timer timer) {
    }

    private void checkConfirmation() {
        switch (this.passwordMode) {
            case 0: {
                if (this.passwordSpeller.getText().equals(this.getPassword())) {
                    this.env.lcHMI.log(10000000, "[PasswordController.PasswordModifiedListener] password correct");
                    this.passwordResetCounter.setValue(0);
                    this.lockStateChoice.setValue(0);
                    break;
                }
                this.passwordResetCounter.increment();
                this.env.lcHMI.log(10000000, "[PasswordController.PasswordModifiedListener] trial counter:[%1]", (Object)this.passwordResetCounter);
                if (this.passwordResetCounter.isGreaterThan(2)) {
                    this.lockStateChoice.setValue(2);
                    this.blockedByWrongPasswordTimer.start();
                    this.env.lcHMI.log(1000000, "[PasswordController.PasswordModifiedListener] parental rating locked for 300 seconds");
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
                    this.env.lcHMI.log(10000000, "[PasswordController.parentalRatingSecondPasswordEntered]");
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

    private class EnterPasswordListener
    extends DefaultButtonListener {
        private EnterPasswordListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            switch (n) {
                case 2600020: {
                    ((PasswordController)PasswordController.this).env.lcHMI.log(10000000, "[PasswordController.EnterPasswordListener.keyTyped] parental rating entered.");
                    PasswordController.this.ratingEnteredByOptionsButton.setStatus(1);
                    PasswordController.this.resetPasswordConfirmation();
                    PasswordController.this.ratingEnteredButton.fireEvent(n3);
                    break;
                }
                case 2600122: {
                    ((PasswordController)PasswordController.this).env.lcHMI.log(10000000, "[PasswordController.EnterPasswordListener.keyTyped] parental rating entered through options.");
                    PasswordController.this.ratingEnteredByOptionsButton.setStatus(0);
                    PasswordController.this.resetPasswordConfirmation();
                    PasswordController.this.ratingEnteredByOptionsButton.fireEvent(n3);
                    break;
                }
                case 2600012: {
                    ((PasswordController)PasswordController.this).env.lcHMI.log(10000000, "[PasswordController.EnterPasswordListener.keyTyped] entered changing password mode.");
                    PasswordController.this.passwordMode = 1;
                    PasswordController.this.passwordSpeller.clear();
                    PasswordController.this.passwordConfirmationButton.setStatus(0);
                    PasswordController.this.passwordChangeButton.fireEvent(n3);
                    break;
                }
                case 2600124: {
                    ((PasswordController)PasswordController.this).env.lcHMI.log(10000000, "[PasswordController.EnterPasswordListener.keyTyped] confirmation button pressed.");
                    PasswordController.this.checkConfirmation();
                    PasswordController.this.passwordConfirmationButton.fireEvent(n3);
                    break;
                }
            }
        }
    }

    private class PasswordModifiedListener
    extends DefaultSpellerListener {
        private PasswordModifiedListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            ((PasswordController)PasswordController.this).env.lcHMI.log(10000000, "[PasswordController.PasswordModifiedListener.keyTyped] confirmation button pressed.");
            PasswordController.this.checkConfirmation();
            PasswordController.this.passwordSpeller.fireEvent(n3);
        }

        public void textChanged(int n, String string, char c2, int n2) {
            ((PasswordController)PasswordController.this).env.lcHMI.log(10000000, "[PasswordController.PasswordModifiedListener.textChanged] %1", (Object)string);
            PasswordController.this.passwordSpeller.setText(string);
            PasswordController.this.passwordSpeller.setStatus(1);
            if (string.length() < 4 || string.length() > 8) {
                PasswordController.this.passwordConfirmationButton.setStatus(0);
            } else {
                PasswordController.this.passwordConfirmationButton.setStatus(1);
            }
        }
    }
}

