/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public class TelPinChangeHandler
extends AbstractPhoneComponent
implements SpellerListener,
ButtonListener {
    private static final int PIN_MIN_LENGTH = 4;
    private static final int PIN_MAX_LENGTH = 8;
    private String currentPIN;
    private String changedPIN;
    public static final int SEC_PIN_ERR_1 = 1;
    public static final int SEC_PIN_ERR_2 = 2;
    public static final int SEC_PIN_VERIFY = 0;
    private static final int[] SPELLER_MODELS = new int[]{300588, 300586, 300587};
    private static final int[] BUTTON_MODELS = new int[]{300444, 300445, 300446};

    public TelPinChangeHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        int n;
        for (n = 0; n < SPELLER_MODELS.length; ++n) {
            SpellerModelApp spellerModelApp = this.getSpellerModel(SPELLER_MODELS[n]);
            spellerModelApp.setSpellerListener(this);
            spellerModelApp.setMinLength(4);
            spellerModelApp.setMaxLength(8);
        }
        for (n = 0; n < BUTTON_MODELS.length; ++n) {
            this.getButtonModel(BUTTON_MODELS[n]).setButtonListener(this);
        }
        this.disableOkButtonForSpellers();
    }

    public void deinit() {
        int n;
        for (n = 0; n < SPELLER_MODELS.length; ++n) {
            this.getSpellerModel(SPELLER_MODELS[n]).resetListener();
        }
        for (n = 0; n < BUTTON_MODELS.length; ++n) {
            this.getButtonModel(BUTTON_MODELS[n]).resetListener();
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "TelPinChangeHandler#keyTyped: id=%1, keyID=%2, terminalID=%3 ", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 300444: 
            case 300588: {
                this.currentPINEntered();
                break;
            }
            case 300445: 
            case 300586: {
                this.newPINEntered();
                break;
            }
            case 300446: 
            case 300587: {
                this.pinRepeatEntered(n3);
                break;
            }
            default: {
                this.log.log(10000, "TelPinChangeHandler#keyTyped: No handling for modelId=%1 ", (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void currentPINEntered() {
        this.log.log(10000000, "TelPinChangeHandler#currentPINEntered: called ");
        SpellerModelApp spellerModelApp = this.getSpellerModel(300588);
        this.currentPIN = spellerModelApp.getText();
        this.log.log(10000000, "TelPinChangeHandler#currentPINEntered: currentPIN=%1 ", (Object)this.currentPIN);
        spellerModelApp.fireEvent(0);
        this.getSpellerModel(300588).clear();
        this.disableOkButtonForSpellers();
    }

    private void newPINEntered() {
        this.log.log(10000000, "TelPinChangeHandler#newPINEntered: entered ");
        SpellerModelApp spellerModelApp = this.getSpellerModel(300586);
        this.changedPIN = spellerModelApp.getText();
        this.log.log(10000000, "TelPinChangeHandler#newPINEntered: changedPIN=%1 ", (Object)this.changedPIN);
        spellerModelApp.fireEvent(0);
        this.getSpellerModel(300586).clear();
        this.getSpellerModel(300587).setStatus(1);
        this.getSpellerModel(300587).clear();
        this.disableOkButtonForSpellers();
    }

    private void pinRepeatEntered(int n) {
        this.log.log(10000000, "TelPinChangeHandler#pinRepeatEntered: entered ");
        SpellerModelApp spellerModelApp = this.getSpellerModel(300587);
        String string = spellerModelApp.getText();
        this.log.log(10000000, "TelPinChangeHandler#pinRepeatEntered: confirmedPIN=%1 ", (Object)string);
        boolean bl = false;
        if (!string.equals(this.changedPIN)) {
            this.abortRepeatedPinFalse(string);
        } else {
            bl = true;
            this.proceedWithDowncall(n);
        }
        spellerModelApp.fireEvent(0);
        if (!bl) {
            this.getSpellerModel(300587).setStatus(1);
            this.getSpellerModel(300587).clear();
            this.disableOkButtonForSpellers();
        }
    }

    private void abortRepeatedPinFalse(String string) {
        this.log.log(1000000, "TelPinChangeHandler#pinRepeatEntered: confirmedPIN=%1 != changedPIN=%2,  showing wrong repeated PIN indication and aborting", (Object)string, (Object)this.changedPIN);
        this.getChoiceModel(300589).setValue(1);
        this.log.log(10000000, "TelPinChangeHandler#pinRepeatEntered ICorePhoneModelBank.CHANGE_PIN_CHOICE.v <-- 1");
    }

    private void proceedWithDowncall(int n) {
        this.getChoiceModel(300589).setValue(0);
        this.setChangePINStateModel(0, 0);
        this.getSpellerModel(300587).setStatus(0);
        this.log.log(10000000, "TelPinChangeHandler#pinRepeatEntered: entering wait, ICorePhoneModelBank.CHANGE_PIN_CHOICE.v <-- 0, ICorePhoneModelBank.CHANGE_PIN_STATE_CHOICE.s <-- 0");
        this.log.log(10000000, "TelPinChangeHandler#pinRepeatEntered: Invoking PIN Change on DSI, currentPIN=%1 != changedPIN=%2 ", (Object)this.currentPIN, (Object)this.changedPIN);
        this.getApplication().getTelephoneDSIAccess().requestChangeSIMCode(this.currentPIN, this.changedPIN, n, true, new TelDefaultDSIResponseListener(){

            public void responseChangeSIMCode(int n, int n2, int n3) {
                TelPinChangeHandler.this.log.log(10000000, "TelPinChangeHandler#responseChangeSIMCode result = %1", (long)n2);
                if (n2 == 0) {
                    TelPinChangeHandler.this.log.log(10000000, "TelPinChangeHandler#responseChangeSIMCode: PIN was changed, swhowing confirmation to confirmation ");
                    TelPinChangeHandler.this.setChangePINStateModel(1, 1);
                    TelPinChangeHandler.this.log.log(10000000, "TelPinChangeHandler#responseChangeSIMCode: ICorePhoneModelBank.CHANGE_PIN_STATE_CHOICE(t,v) <-- (STATUS_VALID, VALUE_AVAILABLE");
                    return;
                }
                TelPinChangeHandler.this.log.log(100000, "TelPinChangeHandler#responseChangeSIMCode: Error  occurred, PIN NOT changed, showing Error Indication", (long)n2);
                TelPinChangeHandler.this.setChangePINStateModel(2, -1);
                TelPinChangeHandler.this.log.log(10000000, "TelPinChangeHandler#responseChangeSIMCode: ICorePhoneModelBank.CHANGE_PIN_STATE_CHOICE(t,v) <-- (STATUS_ERROR, VALUE_UNAVAILABLE");
                TelPinChangeHandler.this.getSpellerModel(300587).setStatus(1);
                TelPinChangeHandler.this.getSpellerModel(300587).clear();
                TelPinChangeHandler.this.disableOkButtonForSpellers();
            }
        });
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelPinChangeHandler#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        }
        this.refreshOkButtonStateForSpeller(n, string);
    }

    private void disableOkButtonForSpellers() {
        this.refreshOkButtonStateForSpeller(300588, null);
        this.refreshOkButtonStateForSpeller(300586, null);
        this.refreshOkButtonStateForSpeller(300587, null);
    }

    private void refreshOkButtonStateForSpeller(int n, String string) {
        if (n == 300588) {
            this.refreshOKButtonState(string, 300444, 300588);
        } else if (n == 300586) {
            this.refreshOKButtonState(string, 300445, 300586);
        } else if (n == 300587) {
            this.refreshOKButtonState(string, 300446, 300587);
        }
    }

    private void refreshOKButtonState(String string, int n, int n2) {
        int n3;
        int n4 = this.getSpeller(n2).getMinLength();
        if (this.isValidPin(string, n4, n3 = this.getSpeller(n2).getMaxLength())) {
            this.getButtonModel(n).setStatus(1);
        } else {
            this.getButtonModel(n).setStatus(0);
        }
    }

    private SpellerModelApp getSpeller(int n) {
        return this.getSpellerModel(n);
    }

    private boolean isValidPin(String string, int n, int n2) {
        return string != null && string.length() >= n && string.length() <= n2;
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    protected void setChangePINStateModel(int n, int n2) {
        this.getChoiceModel(300590).setValue(n2);
        this.getChoiceModel(300590).setStatus(n);
        this.log.log(10000000, "TelPinChangeHandler#setChangePINStateModel: changePinStateChoice.value=%2, .status=%1 ", (long)n, (long)n2);
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }
}

