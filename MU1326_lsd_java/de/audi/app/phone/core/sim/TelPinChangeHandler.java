/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.sim.TelPinChangeHandler$1;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;

public class TelPinChangeHandler
extends AbstractPhoneComponent
implements SpellerListener,
ButtonListener {
    private static final int PIN_MIN_LENGTH;
    private static final int PIN_MAX_LENGTH;
    private String currentPIN;
    private String changedPIN;
    public static final int SEC_PIN_ERR_1;
    public static final int SEC_PIN_ERR_2;
    public static final int SEC_PIN_VERIFY;
    private static final int[] SPELLER_MODELS;
    private static final int[] BUTTON_MODELS;

    public TelPinChangeHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
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

    @Override
    public void deinit() {
        int n;
        for (n = 0; n < SPELLER_MODELS.length; ++n) {
            this.getSpellerModel(SPELLER_MODELS[n]).resetListener();
        }
        for (n = 0; n < BUTTON_MODELS.length; ++n) {
            this.getButtonModel(BUTTON_MODELS[n]).resetListener();
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "TelPinChangeHandler#keyTyped: id=%1, keyID=%2, terminalID=%3 ", (long)n, (long)n2, (long)n3);
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

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void currentPINEntered() {
        this.log.log(-2137614336, "TelPinChangeHandler#currentPINEntered: called ");
        SpellerModelApp spellerModelApp = this.getSpellerModel(748028928);
        this.currentPIN = spellerModelApp.getText();
        this.log.log(-2137614336, "TelPinChangeHandler#currentPINEntered: currentPIN=%1 ", (Object)this.currentPIN);
        spellerModelApp.fireEvent(0);
        this.getSpellerModel(748028928).clear();
        this.disableOkButtonForSpellers();
    }

    private void newPINEntered() {
        this.log.log(-2137614336, "TelPinChangeHandler#newPINEntered: entered ");
        SpellerModelApp spellerModelApp = this.getSpellerModel(714474496);
        this.changedPIN = spellerModelApp.getText();
        this.log.log(-2137614336, "TelPinChangeHandler#newPINEntered: changedPIN=%1 ", (Object)this.changedPIN);
        spellerModelApp.fireEvent(0);
        this.getSpellerModel(714474496).clear();
        this.getSpellerModel(731251712).setStatus(1);
        this.getSpellerModel(731251712).clear();
        this.disableOkButtonForSpellers();
    }

    private void pinRepeatEntered(int n) {
        this.log.log(-2137614336, "TelPinChangeHandler#pinRepeatEntered: entered ");
        SpellerModelApp spellerModelApp = this.getSpellerModel(731251712);
        String string = spellerModelApp.getText();
        this.log.log(-2137614336, "TelPinChangeHandler#pinRepeatEntered: confirmedPIN=%1 ", (Object)string);
        boolean bl = false;
        if (!string.equals(this.changedPIN)) {
            this.abortRepeatedPinFalse(string);
        } else {
            bl = true;
            this.proceedWithDowncall(n);
        }
        spellerModelApp.fireEvent(0);
        if (!bl) {
            this.getSpellerModel(731251712).setStatus(1);
            this.getSpellerModel(731251712).clear();
            this.disableOkButtonForSpellers();
        }
    }

    private void abortRepeatedPinFalse(String string) {
        this.log.log(1078071040, "TelPinChangeHandler#pinRepeatEntered: confirmedPIN=%1 != changedPIN=%2,  showing wrong repeated PIN indication and aborting", (Object)string, (Object)this.changedPIN);
        this.getChoiceModel(764806144).setValue(1);
        this.log.log(-2137614336, "TelPinChangeHandler#pinRepeatEntered ICorePhoneModelBank.CHANGE_PIN_CHOICE.v <-- 1");
    }

    private void proceedWithDowncall(int n) {
        this.getChoiceModel(764806144).setValue(0);
        this.setChangePINStateModel(0, 0);
        this.getSpellerModel(731251712).setStatus(0);
        this.log.log(-2137614336, "TelPinChangeHandler#pinRepeatEntered: entering wait, ICorePhoneModelBank.CHANGE_PIN_CHOICE.v <-- 0, ICorePhoneModelBank.CHANGE_PIN_STATE_CHOICE.s <-- 0");
        this.log.log(-2137614336, "TelPinChangeHandler#pinRepeatEntered: Invoking PIN Change on DSI, currentPIN=%1 != changedPIN=%2 ", (Object)this.currentPIN, (Object)this.changedPIN);
        this.getApplication().getTelephoneDSIAccess().requestChangeSIMCode(this.currentPIN, this.changedPIN, n, true, new TelPinChangeHandler$1(this));
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelPinChangeHandler#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        }
        this.refreshOkButtonStateForSpeller(n, string);
    }

    private void disableOkButtonForSpellers() {
        this.refreshOkButtonStateForSpeller(748028928, null);
        this.refreshOkButtonStateForSpeller(714474496, null);
        this.refreshOkButtonStateForSpeller(731251712, null);
    }

    private void refreshOkButtonStateForSpeller(int n, String string) {
        if (n == 748028928) {
            this.refreshOKButtonState(string, -1667955712, 748028928);
        } else if (n == 714474496) {
            this.refreshOKButtonState(string, -1651178496, 714474496);
        } else if (n == 731251712) {
            this.refreshOKButtonState(string, -1634401280, 731251712);
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

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    protected void setChangePINStateModel(int n, int n2) {
        this.getChoiceModel(781583360).setValue(n2);
        this.getChoiceModel(781583360).setStatus(n);
        this.log.log(-2137614336, "TelPinChangeHandler#setChangePINStateModel: changePinStateChoice.value=%2, .status=%1 ", (long)n, (long)n2);
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    static /* synthetic */ LogChannel access$000(TelPinChangeHandler telPinChangeHandler) {
        return telPinChangeHandler.log;
    }

    static /* synthetic */ LogChannel access$100(TelPinChangeHandler telPinChangeHandler) {
        return telPinChangeHandler.log;
    }

    static /* synthetic */ LogChannel access$200(TelPinChangeHandler telPinChangeHandler) {
        return telPinChangeHandler.log;
    }

    static /* synthetic */ LogChannel access$300(TelPinChangeHandler telPinChangeHandler) {
        return telPinChangeHandler.log;
    }

    static /* synthetic */ LogChannel access$400(TelPinChangeHandler telPinChangeHandler) {
        return telPinChangeHandler.log;
    }

    static /* synthetic */ SpellerModelApp access$500(TelPinChangeHandler telPinChangeHandler, int n) {
        return telPinChangeHandler.getSpellerModel(n);
    }

    static /* synthetic */ SpellerModelApp access$600(TelPinChangeHandler telPinChangeHandler, int n) {
        return telPinChangeHandler.getSpellerModel(n);
    }

    static /* synthetic */ void access$700(TelPinChangeHandler telPinChangeHandler) {
        telPinChangeHandler.disableOkButtonForSpellers();
    }

    static {
        SPELLER_MODELS = new int[]{748028928, 714474496, 731251712};
        BUTTON_MODELS = new int[]{-1667955712, -1651178496, -1634401280};
    }
}

