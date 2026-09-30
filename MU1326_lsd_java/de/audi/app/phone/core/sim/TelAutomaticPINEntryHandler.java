/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.model.TelDefaultChoiceListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;

class TelAutomaticPINEntryHandler
extends AbstractPhoneComponent {
    public static final int PIN_SAVE_DIALOG_CHOICE_OFF = 0;
    public static final int PIN_SAVE_DIALOG_CHOICE_ON = 1;
    public static final int AUTO_PIN_ON = 1;
    public static final int AUTO_PIN_OFF = 0;
    private volatile boolean automaticPINEntryActive;

    TelAutomaticPINEntryHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.LockState");
        this.addSubPhoneComponent(new TelAutoPinChoiceListener(iTelApplication));
        this.addSubPhoneComponent(new TelPINSavedConfirmedOkButtonListener(iTelApplication));
        this.addSubPhoneComponent(new TelPinDontSaveButtonListener(iTelApplication));
        this.addSubPhoneComponent(new TelPinSaveButtonListener(iTelApplication));
        this.addSubPhoneComponent(new TelPINSavedConfirmedOkButtonListener(iTelApplication));
        this.addSubPhoneComponent(new TelPinSaveDialogHKBackButtonListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 65540) {
            this.updateAutomaticPINSetting(iGlobalTelephoneStateStruct.isAutomaticPinEntryActive());
        }
    }

    private void updateAutomaticPINSetting(boolean bl) {
        this.log.log(1000000, "[TelAutomaticPINEntryHandler#updateAutomaticPINSetting] %1", bl);
        this.automaticPINEntryActive = bl;
        this.getChoiceModel(300497).setValue(this.automaticPINEntryActive ? 1 : 0);
    }

    void updateLockStateNoLock(boolean bl) {
        if (bl) {
            if (this.automaticPINEntryActive) {
                this.log.log(1000000, "[TelAutomaticPINEntryHandler#processNoLock] preparing to show TEL_UNLOCK_PIN_SAVE_MAIN");
                this.activateShowPINSaveDialog();
            } else {
                this.log.log(1000000, "[TelAutomaticPINEntryHandler#processNoLock] automatic pin entry deactivated --> not showing TEL_UNLOCK_PIN_SAVE_MAIN");
                this.deactivateShowPINSaveDialog();
            }
        } else {
            this.log.log(1000000, "[TelAutomaticPINEntryHandler#processNoLock] no manual unlock performed --> not showing TEL_UNLOCK_PIN_SAVE_MAIN");
            this.deactivateShowPINSaveDialog();
        }
    }

    private void activateShowPINSaveDialog() {
        this.getChoiceModel(300226).setValue(1);
    }

    private void deactivateShowPINSaveDialog() {
        this.getChoiceModel(300226).setValue(0);
    }

    private class TelAutoPinChoiceListener
    extends TelDefaultChoiceListener {
        public TelAutoPinChoiceListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.LockState", 300497);
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            this.log.log(1000000, "[TelAutomaticPINEntryHandler.TelAutoPinChoiceListener#itemSelected] %1", (Object)TelLoggingUtils.itemSelectedChoice(n, n2, n3, n4));
            switch (n2) {
                case 0: {
                    this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(false, n4);
                    break;
                }
                case 1: {
                    this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(true, n4);
                    break;
                }
                default: {
                    this.log.log(10000, "TelAutomaticPINEntryHandler.TelAutoPinChoiceListener#itemSelected: Unhandled itemID %1! ", (long)n2);
                }
            }
        }
    }

    private class TelPinSaveButtonListener
    extends TelDefaultButtonListener {
        public TelPinSaveButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.LockState", 300225);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelAutomaticPINEntryHandler.TelPinSaveButtonListener#keyTyped] switching PIN-Save setting to on.");
            this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(true, n3);
            TelAutomaticPINEntryHandler.this.deactivateShowPINSaveDialog();
            this.getButtonModel(n).fireEvent(n3);
        }
    }

    private class TelPinDontSaveButtonListener
    extends TelDefaultButtonListener {
        public TelPinDontSaveButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.LockState", 300223);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelAutomaticPINEntryHandler.TelPinDontSaveButtonListener#keyTyped] switching PIN-Save setting to off.");
            this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(false, n3);
            TelAutomaticPINEntryHandler.this.deactivateShowPINSaveDialog();
            this.getButtonModel(n).fireEvent(n3);
        }
    }

    private class TelPINSavedConfirmedOkButtonListener
    extends TelDefaultButtonListener {
        public TelPINSavedConfirmedOkButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.LockState", 300751);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelAutomaticPINEntryHandler.TelPINSavedConfirmedOkButtonListener#keyTyped] %1", (Object)TelLoggingUtils.keyTyped(n, n2, n3));
            this.getButtonModel(n).fireEvent(n3);
        }
    }

    private class TelPinSaveDialogHKBackButtonListener
    extends TelDefaultButtonListener {
        public TelPinSaveDialogHKBackButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.LockState", 300826);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelAutomaticPINEntryHandler.TelPinSaveDialogHKBackButtonListener#keyTyped] no modification of automatic PIN entry setting.");
            TelAutomaticPINEntryHandler.this.deactivateShowPINSaveDialog();
            this.getButtonModel(300826).fireEvent(n3);
        }
    }
}

