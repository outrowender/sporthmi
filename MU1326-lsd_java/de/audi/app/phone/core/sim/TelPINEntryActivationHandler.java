/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelModelGroup;
import de.audi.app.phone.core.sim.TelPINEntryActivationHandler$1;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;

public class TelPINEntryActivationHandler
extends AbstractPhoneComponent
implements SpellerListener,
ButtonListener {
    private static final int VALUE_AVAILABLE;
    private static final int VALUE_UNKNOWN;
    private static final int PIN_ACTIVATED_YES;
    private static final int PIN_ACTIVATED_NO;
    private static final int PIN_ACTIVATED_ERROR;
    private static final int PIN_ACTIVATED_WRONG_PIN;
    protected static final int PIN_ACTIVATE_YES;
    protected static final int PIN_ACTIVATE_NO;
    private boolean requestSIMPINRequiredType;
    private volatile boolean simPINRequired;

    public TelPINEntryActivationHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getSpellerModel(1519780864).setSpellerListener(this);
        this.getSpellerModel(1519780864).setMinLength(4);
        this.getSpellerModel(1519780864).setMaxLength(8);
        this.getButtonModel(-1768487936).setButtonListener(this);
        this.getButtonModel(-1080687616).setButtonListener(this);
        this.getButtonModel(-1080687616).setStatus(0);
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getSpellerModel(1519780864).resetListener();
        this.getButtonModel(-1768487936).resetListener();
        this.getButtonModel(-1080687616).resetListener();
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0x3000400 || n == 0x2000100 || n == 0x2000300 || n == 0x2000200) {
            int n2 = iGlobalTelephoneStateStruct.getNadMode();
            if (n2 == 1) {
                this.updateSIMPINRequired(iGlobalTelephoneStateStruct.isSimPINRequired());
            } else if (n2 == 2) {
                this.updateSIMPINRequired(iGlobalTelephoneStateStruct.isSimPINRequiredDSINAD());
            }
        }
    }

    private void setupWaitSyncForDSIResponse() {
        TelModelGroup telModelGroup = new TelModelGroup("TelPINEntryActivationHandler#setupWaitSyncForDSIResponse", this.log);
        telModelGroup.add(this.getChoiceModel(1536558080));
        telModelGroup.add(this.getSpellerModel(1519780864));
        this.getSpellerModel(1519780864).setStatus(0);
        this.getChoiceModel(1536558080).setValue(0);
        this.getChoiceModel(1536558080).setStatus(0);
        telModelGroup.flush();
        telModelGroup.removeAll();
    }

    private void triggerWaitSyncDsiResponseRecieved() {
        TelModelGroup telModelGroup = new TelModelGroup("TelPINEntryActivationHandler#triggerWaitSyncDsiResponseRecieved", this.log);
        telModelGroup.add(this.getChoiceModel(1536558080));
        telModelGroup.add(this.getSpellerModel(1519780864));
        this.getSpellerModel(1519780864).setStatus(1);
        this.getChoiceModel(1536558080).setValue(1);
        this.getChoiceModel(1536558080).setStatus(1);
        telModelGroup.flush();
        telModelGroup.removeAll();
    }

    protected void updateSIMPINRequired(boolean bl) {
        this.log.log(1078071040, "[TelPINEntryActivationHandler#updateSIMPINRequired] simPINRequired=%1", bl);
        this.simPINRequired = bl;
        this.setModelsForSIMPINRequiredStatus();
    }

    private void setModelsForSIMPINRequiredStatus() {
        this.log.log(1078071040, "TelPINEntryActivationHandler#setModelsForSIMPINRequiredStatus(): %1", this.simPINRequired);
        if (this.simPINRequired) {
            this.getChoiceModel(-963247104).setValue(1);
            this.getChoiceModel(-1097595904).setValue(1);
        } else {
            this.getChoiceModel(-963247104).setValue(2);
            this.getChoiceModel(-1097595904).setValue(0);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelPINEntryActivationHandler#keyTyped] %1", (Object)TelLoggingUtils.keyTyped(n, n2, n3));
        switch (n) {
            case 300634: {
                this.keyTypedDisablePINSpeller(n3);
                break;
            }
            case 300735: {
                this.keyTypedDisablePINSpeller(n3);
                break;
            }
            case 300950: {
                this.keyTypedChangePINRequestActivation(n3, !this.simPINRequired);
                break;
            }
            default: {
                this.log.log(-1601830656, "TelPINEntryActivationHandler#keyTyped: No handling for modelId=%1 ", (long)n);
            }
        }
    }

    private void keyTypedDisablePINSpeller(int n) {
        SpellerModelApp spellerModelApp = this.getSpellerModel(1519780864);
        String string = spellerModelApp.getText();
        this.log.log(-2137614336, "[TelPINEntryActivationHandler#keyTypedDisablePINSpeller] entered pin: %1", (Object)string);
        this.clearSpellerDisableButton();
        this.setModelsForSIMPINRequiredStatus();
        this.setupWaitSyncForDSIResponse();
        spellerModelApp.fireEvent(n);
        this.activatePINRequired(string, this.requestSIMPINRequiredType, n);
    }

    protected void keyTypedChangePINRequestActivation(int n, boolean bl) {
        this.log.log(-2137614336, "[TelPINEntryActivationHandler#keyTypedChangePINRequestActivation] activate=%1", bl);
        this.clearSpellerDisableButton();
        this.requestSIMPINRequiredType = bl;
        this.getChoiceModel(-1097595904).setValue(bl ? 0 : 1);
        this.getChoiceModel(1268253696).setValue(bl ? 0 : 1);
        this.getButtonModel(-1768487936).fireEvent(n);
    }

    private void clearSpellerDisableButton() {
        this.log.log(-2137614336, "[TelPINEntryActivationHandler#clearSpellerDisableButton] called");
        this.getSpellerModel(1519780864).clear();
        this.getButtonModel(-1080687616).setStatus(0);
    }

    private void activatePINRequired(String string, boolean bl, int n) {
        this.log.log(1078071040, "[TelPINEntryActivationHandler#activatePINRequired] pin=%1, simPINrequired=%2", (Object)string, (Object)String.valueOf(bl));
        this.getApplication().getTelephoneDSIAccess().requestSIMPINRequired(string, bl, n, false, new TelPINEntryActivationHandler$1(this));
    }

    protected void simPinRequiredResponse(int n) {
        this.log.log(-2137614336, "[TelPINEntryActivationHandler#responseSIMPINRequired] result=%1", (long)n);
        if (n == 0) {
            this.log.log(1078071040, "[TelPINEntryActivationHandler#responseSIMPINRequired] RESULT_OK, update should have already been recieved.");
        } else if (n == 5) {
            this.log.log(1078071040, "[TelPINEntryActivationHandler#responseSIMPINRequired] RESULT_ERROR_CODE_WRONG");
            this.getChoiceModel(-963247104).setValue(4);
        } else {
            this.log.log(1078071040, "[TelPINEntryActivationHandler#responseSIMPINRequired] error response type %1", (long)n);
            this.getChoiceModel(-963247104).setValue(3);
        }
        this.triggerWaitSyncDsiResponseRecieved();
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelPINEntryActivationHandler#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        }
        if (n == 1519780864) {
            int n3 = this.getSpellerModel(1519780864).getMinLength();
            int n4 = this.getSpellerModel(1519780864).getMaxLength();
            if (string != null) {
                if (string.length() >= n3 && string.length() <= n4) {
                    this.getButtonModel(-1080687616).setStatus(1);
                } else {
                    this.getButtonModel(-1080687616).setStatus(0);
                }
            } else {
                this.getButtonModel(-1080687616).setStatus(0);
            }
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    static /* synthetic */ LogChannel access$000(TelPINEntryActivationHandler telPINEntryActivationHandler) {
        return telPINEntryActivationHandler.log;
    }
}

