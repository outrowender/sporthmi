/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.sim.TelAutomaticPINEntryHandler$TelAutoPinChoiceListener;
import de.audi.app.phone.core.sim.TelAutomaticPINEntryHandler$TelPINSavedConfirmedOkButtonListener;
import de.audi.app.phone.core.sim.TelAutomaticPINEntryHandler$TelPinDontSaveButtonListener;
import de.audi.app.phone.core.sim.TelAutomaticPINEntryHandler$TelPinSaveButtonListener;
import de.audi.app.phone.core.sim.TelAutomaticPINEntryHandler$TelPinSaveDialogHKBackButtonListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;

class TelAutomaticPINEntryHandler
extends AbstractPhoneComponent {
    public static final int PIN_SAVE_DIALOG_CHOICE_OFF;
    public static final int PIN_SAVE_DIALOG_CHOICE_ON;
    public static final int AUTO_PIN_ON;
    public static final int AUTO_PIN_OFF;
    private volatile boolean automaticPINEntryActive;

    TelAutomaticPINEntryHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.LockState");
        this.addSubPhoneComponent(new TelAutomaticPINEntryHandler$TelAutoPinChoiceListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelAutomaticPINEntryHandler$TelPINSavedConfirmedOkButtonListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelAutomaticPINEntryHandler$TelPinDontSaveButtonListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelAutomaticPINEntryHandler$TelPinSaveButtonListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelAutomaticPINEntryHandler$TelPINSavedConfirmedOkButtonListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelAutomaticPINEntryHandler$TelPinSaveDialogHKBackButtonListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0x4000100) {
            this.updateAutomaticPINSetting(iGlobalTelephoneStateStruct.isAutomaticPinEntryActive());
        }
    }

    private void updateAutomaticPINSetting(boolean bl) {
        this.log.log(1078071040, "[TelAutomaticPINEntryHandler#updateAutomaticPINSetting] %1", bl);
        this.automaticPINEntryActive = bl;
        this.getChoiceModel(-778763264).setValue(this.automaticPINEntryActive ? 1 : 0);
    }

    void updateLockStateNoLock(boolean bl) {
        if (bl) {
            if (this.automaticPINEntryActive) {
                this.log.log(1078071040, "[TelAutomaticPINEntryHandler#processNoLock] preparing to show TEL_UNLOCK_PIN_SAVE_MAIN");
                this.activateShowPINSaveDialog();
            } else {
                this.log.log(1078071040, "[TelAutomaticPINEntryHandler#processNoLock] automatic pin entry deactivated --> not showing TEL_UNLOCK_PIN_SAVE_MAIN");
                this.deactivateShowPINSaveDialog();
            }
        } else {
            this.log.log(1078071040, "[TelAutomaticPINEntryHandler#processNoLock] no manual unlock performed --> not showing TEL_UNLOCK_PIN_SAVE_MAIN");
            this.deactivateShowPINSaveDialog();
        }
    }

    private void activateShowPINSaveDialog() {
        this.getChoiceModel(-1030487040).setValue(1);
    }

    private void deactivateShowPINSaveDialog() {
        this.getChoiceModel(-1030487040).setValue(0);
    }

    static /* synthetic */ void access$000(TelAutomaticPINEntryHandler telAutomaticPINEntryHandler) {
        telAutomaticPINEntryHandler.deactivateShowPINSaveDialog();
    }
}

