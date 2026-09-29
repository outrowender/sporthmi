/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelModelGroup;
import de.audi.app.phone.core.sim.AbstractTelLockStateDSIHandler;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler$DontSavePinButtonListener;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler$NewPinConfirmationHandler;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler$NewPinHandler;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler$PinEntryHandler;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler$PukEntryHandler;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler$SavePinButtonListener;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler$TelPinSaveDialogHKBackButtonListener;
import de.audi.app.phone.core.sim.AbstractTelUnlockSpellerHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public abstract class AbstractTelUnlockPresentationHandler
extends AbstractTelLockStateDSIHandler {
    static final int PIN_MIN_LENGTH;
    static final int PIN_MAX_LENGTH;
    static final int PUK_MIN_LENGTH;
    static final int PUK_MAX_LENGTH;
    public static final int ENTER_PUK_CONDITION_PIN_BLOCKED;
    public static final int ENTER_PUK_CONDITION_PUK_EDIT;
    static final int LOCKSTATECHOICE_UNKNOWN;
    static final int LOCKSTATECHOICE_ENTER_PIN;
    static final int LOCKSTATECHOICE_NOLOCK;
    static final int LOCKSTATECHOICE_ENTER_PIN_2_ON_MOBILE;
    static final int LOCKSTATECHOICE_ENTER_PUK;
    static final int LOCKSTATECHOICE_ENTER_PUK_2_ON_MOBILE;
    static final int LOCKSTATECHOICE_PUK_BLOCKED;
    static final int LOCKSTATECHOICE_PUK2_BLOCKED;
    static final int LOCKSTATECHOICE_SIMNOTAVAILABLE;
    static final int LOCKSTATECHOICE_SIMNOTFUNCTIONAL;
    static final int LOCKSTATECHOICE_ENTER_NEW_PIN;
    static final int LOCKSTATECHOICE_CONFIRM_NEW_PIN;
    static final int LOCKSTATECHOICE_SECCO_REQUIRED;
    static final int LOCKSTATECHOICE_SECCO_BLOCKED;
    static final int PIN_SAVE_DIALOG_CHOICE_OFF;
    static final int PIN_SAVE_DIALOG_CHOICE_ON;
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
        this.pinEntryHandler = new AbstractTelUnlockPresentationHandler$PinEntryHandler(this, iTelApplication, n, n9);
        this.pukEntryHandler = new AbstractTelUnlockPresentationHandler$PukEntryHandler(this, iTelApplication, n2, n10);
        this.newPinHandler = new AbstractTelUnlockPresentationHandler$NewPinHandler(this, iTelApplication, n3, n11);
        this.newPinConfirmationHandler = new AbstractTelUnlockPresentationHandler$NewPinConfirmationHandler(this, iTelApplication, n4, n12, n17);
        this.addSubPhoneComponent(this.pinEntryHandler);
        this.addSubPhoneComponent(this.pukEntryHandler);
        this.addSubPhoneComponent(this.newPinHandler);
        this.addSubPhoneComponent(this.newPinConfirmationHandler);
        this.addSubPhoneComponent(new AbstractTelUnlockPresentationHandler$DontSavePinButtonListener(this, iTelApplication, n13));
        this.addSubPhoneComponent(new AbstractTelUnlockPresentationHandler$SavePinButtonListener(this, iTelApplication, n14));
        this.addSubPhoneComponent(new AbstractTelUnlockPresentationHandler$TelPinSaveDialogHKBackButtonListener(this, iTelApplication, n15));
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

    @Override
    protected void processPINRequired(int n) {
        this.log.log(1078071040, "[%1#processPINRequired] remainingAttempts=%2", (Object)this.name, (long)n);
        this.groupModels(new HMIModelApp[]{this.remainingAttemptsLabel, this.pinSpeller, this.lockStateChoice});
        this.setRemainingAttemptsLabel(n);
        this.pinEntryHandler.clearSpeller();
        this.lockStateChoice.setValue(1);
        this.ungroupModels();
    }

    @Override
    protected void processWrongPINEntered(int n, int n2) {
        this.log.log(1078071040, "[%1#processWrongPINEntered] remainingAttempts=%2", (Object)this.name, (long)n);
        this.groupModels(new HMIModelApp[]{this.remainingAttemptsLabel, this.unlockInProgressChoice, this.pinSpeller, this.lockStateChoice});
        this.setRemainingAttemptsLabel(n);
        this.pinEntryHandler.clearSpeller();
        this.lockStateChoice.setValue(1);
        this.processManualUnlockInProgress(false);
        this.ungroupModels();
    }

    @Override
    protected void processWrongPINEnteredPUKRequired(int n, int n2) {
        this.log.log(1078071040, "[%1#processWrongPINEnteredPUKRequired] remainingAttempts=%2", (Object)this.name, (long)n);
        this.groupModels(new HMIModelApp[]{this.remainingAttemptsLabel, this.unlockInProgressChoice, this.lockStateChoice, this.pukSpeller, this.pukConditionChoice});
        this.setRemainingAttemptsLabel(n);
        this.pukConditionChoice.setValue(0);
        this.pukEntryHandler.clearSpeller();
        this.lockStateChoice.setValue(4);
        this.processManualUnlockInProgress(false);
        this.ungroupModels();
    }

    @Override
    protected void processPUKRequired(int n) {
        this.log.log(1078071040, "[%1#processPUKRequired] remainingAttempts=%2", (Object)this.name, (long)n);
        this.groupModels(new HMIModelApp[]{this.remainingAttemptsLabel, this.lockStateChoice, this.pukSpeller, this.pukConditionChoice});
        this.setRemainingAttemptsLabel(n);
        this.pukConditionChoice.setValue(1);
        this.pukEntryHandler.clearSpeller();
        this.lockStateChoice.setValue(4);
        this.ungroupModels();
    }

    @Override
    protected void processWrongPUKEntered(int n, int n2) {
        this.log.log(1078071040, "[%1#processWrongPUKEntered] remainingAttempts=%2", (Object)this.name, (long)n);
        this.groupModels(new HMIModelApp[]{this.remainingAttemptsLabel, this.unlockInProgressChoice, this.lockStateChoice, this.pukSpeller, this.pukConditionChoice});
        this.setRemainingAttemptsLabel(n);
        this.pukConditionChoice.setValue(1);
        this.pukEntryHandler.clearSpeller();
        this.lockStateChoice.setValue(4);
        this.processManualUnlockInProgress(false);
        this.ungroupModels();
    }

    @Override
    protected void processSIMNotFunctioning() {
        this.log.log(1078071040, "[%1#processSIMNotFunctioning]", (Object)this.name);
        this.lockStateChoice.setValue(53);
    }

    @Override
    protected void processPUKBlocked() {
        this.log.log(1078071040, "[%1#processPUKBlocked]", (Object)this.name);
        this.lockStateChoice.setValue(6);
    }

    @Override
    protected void processManualUnlockInProgress(boolean bl) {
        this.log.log(1078071040, "[%1#processManualUnlockInProgress] inProgress=%2", (Object)this.name, (Object)String.valueOf(bl));
        this.unlockInProgressChoice.setValue(bl ? 1 : 0);
        this.unlockInProgressChoice.setStatus(bl ? 0 : 1);
    }

    @Override
    protected void processLockStateUnknown() {
        this.log.log(1078071040, "[%1#processLockStateUnknown]", (Object)this.name);
        this.lockStateChoice.setValue(-1);
    }

    @Override
    protected void processNoLock(boolean bl) {
        this.log.log(1078071040, "[%1#processNoLock] manualUnlock=%2", (Object)this.name, (Object)String.valueOf(bl));
        boolean bl2 = this.getAutomaticPinEntryActiveSetting();
        this.pinSaveDialogChoice.setValue(bl2 && bl ? 1 : 0);
        this.lockStateChoice.setValue(0);
    }

    @Override
    protected void processUnhandledLockState(int n) {
        this.log.log(-1601830656, "[%1#processUnhandledLockState] lockState=%1", (long)n);
        this.lockStateChoice.setValue(-1);
    }

    protected void resetPukConditionChoice() {
        this.pukConditionChoice.setValue(1);
    }

    protected abstract boolean getAutomaticPinEntryActiveSetting() {
    }

    static /* synthetic */ String access$000(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler) {
        return abstractTelUnlockPresentationHandler.name;
    }

    static /* synthetic */ String access$102(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler, String string) {
        abstractTelUnlockPresentationHandler.enteredPuk = string;
        return abstractTelUnlockPresentationHandler.enteredPuk;
    }

    static /* synthetic */ AbstractTelUnlockSpellerHandler access$200(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler) {
        return abstractTelUnlockPresentationHandler.newPinHandler;
    }

    static /* synthetic */ String access$302(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler, String string) {
        abstractTelUnlockPresentationHandler.enteredNewPinCode = string;
        return abstractTelUnlockPresentationHandler.enteredNewPinCode;
    }

    static /* synthetic */ AbstractTelUnlockSpellerHandler access$400(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler) {
        return abstractTelUnlockPresentationHandler.newPinConfirmationHandler;
    }

    static /* synthetic */ String access$300(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler) {
        return abstractTelUnlockPresentationHandler.enteredNewPinCode;
    }

    static /* synthetic */ String access$100(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler) {
        return abstractTelUnlockPresentationHandler.enteredPuk;
    }

    static /* synthetic */ ChoiceModelApp access$500(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler) {
        return abstractTelUnlockPresentationHandler.pinSaveDialogChoice;
    }
}

