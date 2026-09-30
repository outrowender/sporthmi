/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.model.TelModelGroup;
import de.audi.app.phone.core.sim.AbstractTelLockStateDSIHandler;
import de.audi.app.phone.core.sim.AbstractTelUnlockSpellerHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public abstract class AbstractTelUnlockPresentationHandler
extends AbstractTelLockStateDSIHandler {
    static final int PIN_MIN_LENGTH = 4;
    static final int PIN_MAX_LENGTH = 8;
    static final int PUK_MIN_LENGTH = 8;
    static final int PUK_MAX_LENGTH = 8;
    public static final int ENTER_PUK_CONDITION_PIN_BLOCKED = 0;
    public static final int ENTER_PUK_CONDITION_PUK_EDIT = 1;
    static final int LOCKSTATECHOICE_UNKNOWN = -1;
    static final int LOCKSTATECHOICE_ENTER_PIN = 1;
    static final int LOCKSTATECHOICE_NOLOCK = 0;
    static final int LOCKSTATECHOICE_ENTER_PIN_2_ON_MOBILE = 2;
    static final int LOCKSTATECHOICE_ENTER_PUK = 4;
    static final int LOCKSTATECHOICE_ENTER_PUK_2_ON_MOBILE = 11;
    static final int LOCKSTATECHOICE_PUK_BLOCKED = 6;
    static final int LOCKSTATECHOICE_PUK2_BLOCKED = 3;
    static final int LOCKSTATECHOICE_SIMNOTAVAILABLE = 51;
    static final int LOCKSTATECHOICE_SIMNOTFUNCTIONAL = 53;
    static final int LOCKSTATECHOICE_ENTER_NEW_PIN = 7;
    static final int LOCKSTATECHOICE_CONFIRM_NEW_PIN = 8;
    static final int LOCKSTATECHOICE_SECCO_REQUIRED = 9;
    static final int LOCKSTATECHOICE_SECCO_BLOCKED = 10;
    static final int PIN_SAVE_DIALOG_CHOICE_OFF = 0;
    static final int PIN_SAVE_DIALOG_CHOICE_ON = 1;
    private final String name;
    private final SpellerModelApp pinSpeller;
    private final SpellerModelApp pukSpeller;
    private final ChoiceModelApp pukConditionChoice;
    private final LabelModelApp remainingAttemptsLabel;
    private final ChoiceModelApp lockStateChoice;
    private final ChoiceModelApp unlockInProgressChoice;
    private final ChoiceModelApp pinSaveDialogChoice;
    private final AbstractTelUnlockSpellerHandler pinEntryHandler;
    private final AbstractTelUnlockSpellerHandler pukEntryHandler;
    private final AbstractTelUnlockSpellerHandler newPinHandler;
    private final AbstractTelUnlockSpellerHandler newPinConfirmationHandler;
    private final TelModelGroup modelGroup;
    private String enteredPuk;
    private String enteredNewPinCode;

    public AbstractTelUnlockPresentationHandler(ITelApplication iTelApplication, String string, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        super(iTelApplication);
        this.modelGroup = new TelModelGroup("AbstractTelUnlockPresentationHandler", this.log);
        this.name = string;
        this.pinSpeller = this.getSpellerModel(n);
        this.pukSpeller = this.getSpellerModel(n2);
        this.pukConditionChoice = this.getChoiceModel(n7);
        this.remainingAttemptsLabel = this.getLabelModel(n16);
        this.lockStateChoice = this.getChoiceModel(n5);
        this.unlockInProgressChoice = this.getChoiceModel(n6);
        this.pinSaveDialogChoice = this.getChoiceModel(n8);
        this.pinEntryHandler = new PinEntryHandler(iTelApplication, n, n9);
        this.pukEntryHandler = new PukEntryHandler(iTelApplication, n2, n10);
        this.newPinHandler = new NewPinHandler(iTelApplication, n3, n11);
        this.newPinConfirmationHandler = new NewPinConfirmationHandler(iTelApplication, n4, n12, n17);
        this.addSubPhoneComponent(this.pinEntryHandler);
        this.addSubPhoneComponent(this.pukEntryHandler);
        this.addSubPhoneComponent(this.newPinHandler);
        this.addSubPhoneComponent(this.newPinConfirmationHandler);
        this.addSubPhoneComponent(new DontSavePinButtonListener(iTelApplication, n13));
        this.addSubPhoneComponent(new SavePinButtonListener(iTelApplication, n14));
        this.addSubPhoneComponent(new TelPinSaveDialogHKBackButtonListener(iTelApplication, n15));
    }

    private void groupModels(HMIModelApp[] hMIModelAppArray) {
        if (hMIModelAppArray != null) {
            for (int i2 = 0; i2 < hMIModelAppArray.length; ++i2) {
                if (hMIModelAppArray[i2] == null) continue;
                this.modelGroup.add(hMIModelAppArray[i2]);
            }
        }
    }

    private void ungroupModels() {
        this.modelGroup.flush();
        this.modelGroup.removeAll();
    }

    private void setRemainingAttemptsLabel(int n) {
        this.remainingAttemptsLabel.setText(String.valueOf(n));
    }

    protected void processPINRequired(int n) {
        this.log.log(1000000, "[%1#processPINRequired] remainingAttempts=%2", (Object)this.name, (long)n);
        this.groupModels(new HMIModelApp[]{this.remainingAttemptsLabel, this.pinSpeller, this.lockStateChoice});
        this.setRemainingAttemptsLabel(n);
        this.pinEntryHandler.clearSpeller();
        this.lockStateChoice.setValue(1);
        this.ungroupModels();
    }

    protected void processWrongPINEntered(int n, int n2) {
        this.log.log(1000000, "[%1#processWrongPINEntered] remainingAttempts=%2", (Object)this.name, (long)n);
        this.groupModels(new HMIModelApp[]{this.remainingAttemptsLabel, this.unlockInProgressChoice, this.pinSpeller, this.lockStateChoice});
        this.setRemainingAttemptsLabel(n);
        this.pinEntryHandler.clearSpeller();
        this.lockStateChoice.setValue(1);
        this.processManualUnlockInProgress(false);
        this.ungroupModels();
    }

    protected void processWrongPINEnteredPUKRequired(int n, int n2) {
        this.log.log(1000000, "[%1#processWrongPINEnteredPUKRequired] remainingAttempts=%2", (Object)this.name, (long)n);
        this.groupModels(new HMIModelApp[]{this.remainingAttemptsLabel, this.unlockInProgressChoice, this.lockStateChoice, this.pukSpeller, this.pukConditionChoice});
        this.setRemainingAttemptsLabel(n);
        this.pukConditionChoice.setValue(0);
        this.pukEntryHandler.clearSpeller();
        this.lockStateChoice.setValue(4);
        this.processManualUnlockInProgress(false);
        this.ungroupModels();
    }

    protected void processPUKRequired(int n) {
        this.log.log(1000000, "[%1#processPUKRequired] remainingAttempts=%2", (Object)this.name, (long)n);
        this.groupModels(new HMIModelApp[]{this.remainingAttemptsLabel, this.lockStateChoice, this.pukSpeller, this.pukConditionChoice});
        this.setRemainingAttemptsLabel(n);
        this.pukConditionChoice.setValue(1);
        this.pukEntryHandler.clearSpeller();
        this.lockStateChoice.setValue(4);
        this.ungroupModels();
    }

    protected void processWrongPUKEntered(int n, int n2) {
        this.log.log(1000000, "[%1#processWrongPUKEntered] remainingAttempts=%2", (Object)this.name, (long)n);
        this.groupModels(new HMIModelApp[]{this.remainingAttemptsLabel, this.unlockInProgressChoice, this.lockStateChoice, this.pukSpeller, this.pukConditionChoice});
        this.setRemainingAttemptsLabel(n);
        this.pukConditionChoice.setValue(1);
        this.pukEntryHandler.clearSpeller();
        this.lockStateChoice.setValue(4);
        this.processManualUnlockInProgress(false);
        this.ungroupModels();
    }

    protected void processSIMNotFunctioning() {
        this.log.log(1000000, "[%1#processSIMNotFunctioning]", (Object)this.name);
        this.lockStateChoice.setValue(53);
    }

    protected void processPUKBlocked() {
        this.log.log(1000000, "[%1#processPUKBlocked]", (Object)this.name);
        this.lockStateChoice.setValue(6);
    }

    protected void processManualUnlockInProgress(boolean bl) {
        this.log.log(1000000, "[%1#processManualUnlockInProgress] inProgress=%2", (Object)this.name, (Object)String.valueOf(bl));
        this.unlockInProgressChoice.setValue(bl ? 1 : 0);
        this.unlockInProgressChoice.setStatus(bl ? 0 : 1);
    }

    protected void processLockStateUnknown() {
        this.log.log(1000000, "[%1#processLockStateUnknown]", (Object)this.name);
        this.lockStateChoice.setValue(-1);
    }

    protected void processNoLock(boolean bl) {
        this.log.log(1000000, "[%1#processNoLock] manualUnlock=%2", (Object)this.name, (Object)String.valueOf(bl));
        boolean bl2 = this.getAutomaticPinEntryActiveSetting();
        this.pinSaveDialogChoice.setValue(bl2 && bl ? 1 : 0);
        this.lockStateChoice.setValue(0);
    }

    protected void processUnhandledLockState(int n) {
        this.log.log(100000, "[%1#processUnhandledLockState] lockState=%1", (long)n);
        this.lockStateChoice.setValue(-1);
    }

    protected void resetPukConditionChoice() {
        this.pukConditionChoice.setValue(1);
    }

    protected abstract boolean getAutomaticPinEntryActiveSetting();

    private class NewPinHandler
    extends AbstractTelUnlockSpellerHandler {
        NewPinHandler(ITelApplication iTelApplication, int n, int n2) {
            super(iTelApplication, "NewPinHandler", n, n2, 4, 8);
        }

        protected void codeEntered(String string, int n) {
            this.log.log(1000000, "[%1.NewPinHandler#codeEntered] code=%2", (Object)AbstractTelUnlockPresentationHandler.this.name, (Object)string);
            AbstractTelUnlockPresentationHandler.this.enteredNewPinCode = string;
            AbstractTelUnlockPresentationHandler.this.newPinConfirmationHandler.clearSpeller();
            this.fireEvent(n);
            this.clearSpeller();
        }
    }

    private class PinEntryHandler
    extends AbstractTelUnlockSpellerHandler {
        PinEntryHandler(ITelApplication iTelApplication, int n, int n2) {
            super(iTelApplication, "PinEntryHandler", n, n2, 4, 8);
        }

        protected void codeEntered(String string, int n) {
            this.log.log(1000000, "[%1.PinEntryHandler#codeEntered] code=%2", (Object)AbstractTelUnlockPresentationHandler.this.name, (Object)string);
            this.fireEvent(n);
            AbstractTelUnlockPresentationHandler.this.unlockSIMwithPIN(string, n);
        }
    }

    private class PukEntryHandler
    extends AbstractTelUnlockSpellerHandler {
        PukEntryHandler(ITelApplication iTelApplication, int n, int n2) {
            super(iTelApplication, "PukEntryHandler", n, n2, 8, 8);
        }

        protected void codeEntered(String string, int n) {
            this.log.log(1000000, "[%1.PukEntryHandler#codeEntered] code=%2", (Object)AbstractTelUnlockPresentationHandler.this.name, (Object)string);
            AbstractTelUnlockPresentationHandler.this.enteredPuk = string;
            AbstractTelUnlockPresentationHandler.this.newPinHandler.clearSpeller();
            this.fireEvent(n);
            this.clearSpeller();
        }
    }

    private class SavePinButtonListener
    extends TelDefaultButtonListener {
        public SavePinButtonListener(ITelApplication iTelApplication, int n) {
            super(iTelApplication, "App.Phone.LockState", n);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[%1.SavePinButtonListener#keyTyped]", (Object)AbstractTelUnlockPresentationHandler.this.name);
            this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(true, n3);
            AbstractTelUnlockPresentationHandler.this.pinSaveDialogChoice.setValue(0);
            this.fireEvent(n3);
        }
    }

    private class DontSavePinButtonListener
    extends TelDefaultButtonListener {
        public DontSavePinButtonListener(ITelApplication iTelApplication, int n) {
            super(iTelApplication, "App.Phone.LockState", n);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[%1.DontSavePinButtonListener#keyTyped]", (Object)AbstractTelUnlockPresentationHandler.this.name);
            this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(false, n3);
            AbstractTelUnlockPresentationHandler.this.pinSaveDialogChoice.setValue(0);
            this.fireEvent(n3);
        }
    }

    private class NewPinConfirmationHandler
    extends AbstractTelUnlockSpellerHandler {
        private static final int NEW_PIN_CONFIRMATION_NOT_SUCCESSFULL = 1;
        private static final int NEW_PIN_CONFIRMATION_SUCCESSFULL = 0;
        private final ChoiceModelApp pinConfirmationChoice;

        NewPinConfirmationHandler(ITelApplication iTelApplication, int n, int n2, int n3) {
            super(iTelApplication, "NewPinConfirmationHandler", n, n2, 4, 8);
            this.pinConfirmationChoice = this.getChoiceModel(n3);
        }

        protected void codeEntered(String string, int n) {
            boolean bl = AbstractTelUnlockPresentationHandler.this.enteredNewPinCode != null && AbstractTelUnlockPresentationHandler.this.enteredNewPinCode.equals(string);
            this.pinConfirmationChoice.setValue(bl ? 0 : 1);
            this.fireEvent(n);
            if (bl) {
                this.log.log(1000000, "[%1.NewPinConfirmationHandler#codeEntered] code=%2, pin confirmation successfull -> unlock sim with puk %3", (Object)AbstractTelUnlockPresentationHandler.this.name, (Object)string, (Object)AbstractTelUnlockPresentationHandler.this.enteredPuk);
                AbstractTelUnlockPresentationHandler.this.unlockSIMWithPUK(AbstractTelUnlockPresentationHandler.this.enteredPuk, AbstractTelUnlockPresentationHandler.this.enteredNewPinCode, n);
            } else {
                this.log.log(1000000, "[%1.NewPinConfirmationHandler#codeEntered] code %2 does not match %3", (Object)AbstractTelUnlockPresentationHandler.this.name, (Object)string, (Object)AbstractTelUnlockPresentationHandler.this.enteredNewPinCode);
            }
        }
    }

    private class TelPinSaveDialogHKBackButtonListener
    extends TelDefaultButtonListener {
        public TelPinSaveDialogHKBackButtonListener(ITelApplication iTelApplication, int n) {
            super(iTelApplication, "App.Phone.LockState", n);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[%1.TelPinSaveDialogHKBackButtonListener#keyTyped]", (Object)AbstractTelUnlockPresentationHandler.this.name);
            AbstractTelUnlockPresentationHandler.this.pinSaveDialogChoice.setValue(0);
            this.fireEvent(n3);
        }
    }
}

