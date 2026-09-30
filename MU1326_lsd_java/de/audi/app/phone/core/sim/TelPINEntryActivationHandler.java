/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.model.TelModelGroup;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public class TelPINEntryActivationHandler
extends AbstractPhoneComponent
implements SpellerListener,
ButtonListener {
    private static final int VALUE_AVAILABLE = 1;
    private static final int VALUE_UNKNOWN = 0;
    private static final int PIN_ACTIVATED_YES = 1;
    private static final int PIN_ACTIVATED_NO = 2;
    private static final int PIN_ACTIVATED_ERROR = 3;
    private static final int PIN_ACTIVATED_WRONG_PIN = 4;
    protected static final int PIN_ACTIVATE_YES = 0;
    protected static final int PIN_ACTIVATE_NO = 1;
    private boolean requestSIMPINRequiredType;
    private volatile boolean simPINRequired;

    public TelPINEntryActivationHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getSpellerModel(300634).setSpellerListener(this);
        this.getSpellerModel(300634).setMinLength(4);
        this.getSpellerModel(300634).setMaxLength(8);
        this.getButtonModel(300950).setButtonListener(this);
        this.getButtonModel(300735).setButtonListener(this);
        this.getButtonModel(300735).setStatus(0);
    }

    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getSpellerModel(300634).resetListener();
        this.getButtonModel(300950).resetListener();
        this.getButtonModel(300735).resetListener();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 262147 || n == 65538 || n == 196610 || n == 131074) {
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
        telModelGroup.add(this.getChoiceModel(300635));
        telModelGroup.add(this.getSpellerModel(300634));
        this.getSpellerModel(300634).setStatus(0);
        this.getChoiceModel(300635).setValue(0);
        this.getChoiceModel(300635).setStatus(0);
        telModelGroup.flush();
        telModelGroup.removeAll();
    }

    private void triggerWaitSyncDsiResponseRecieved() {
        TelModelGroup telModelGroup = new TelModelGroup("TelPINEntryActivationHandler#triggerWaitSyncDsiResponseRecieved", this.log);
        telModelGroup.add(this.getChoiceModel(300635));
        telModelGroup.add(this.getSpellerModel(300634));
        this.getSpellerModel(300634).setStatus(1);
        this.getChoiceModel(300635).setValue(1);
        this.getChoiceModel(300635).setStatus(1);
        telModelGroup.flush();
        telModelGroup.removeAll();
    }

    protected void updateSIMPINRequired(boolean bl) {
        this.log.log(1000000, "[TelPINEntryActivationHandler#updateSIMPINRequired] simPINRequired=%1", bl);
        this.simPINRequired = bl;
        this.setModelsForSIMPINRequiredStatus();
    }

    private void setModelsForSIMPINRequiredStatus() {
        this.log.log(1000000, "TelPINEntryActivationHandler#setModelsForSIMPINRequiredStatus(): %1", this.simPINRequired);
        if (this.simPINRequired) {
            this.getChoiceModel(300742).setValue(1);
            this.getChoiceModel(300222).setValue(1);
        } else {
            this.getChoiceModel(300742).setValue(2);
            this.getChoiceModel(300222).setValue(0);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "[TelPINEntryActivationHandler#keyTyped] %1", (Object)TelLoggingUtils.keyTyped(n, n2, n3));
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
                this.log.log(100000, "TelPINEntryActivationHandler#keyTyped: No handling for modelId=%1 ", (long)n);
            }
        }
    }

    private void keyTypedDisablePINSpeller(int n) {
        SpellerModelApp spellerModelApp = this.getSpellerModel(300634);
        String string = spellerModelApp.getText();
        this.log.log(10000000, "[TelPINEntryActivationHandler#keyTypedDisablePINSpeller] entered pin: %1", (Object)string);
        this.clearSpellerDisableButton();
        this.setModelsForSIMPINRequiredStatus();
        this.setupWaitSyncForDSIResponse();
        spellerModelApp.fireEvent(n);
        this.activatePINRequired(string, this.requestSIMPINRequiredType, n);
    }

    protected void keyTypedChangePINRequestActivation(int n, boolean bl) {
        this.log.log(10000000, "[TelPINEntryActivationHandler#keyTypedChangePINRequestActivation] activate=%1", bl);
        this.clearSpellerDisableButton();
        this.requestSIMPINRequiredType = bl;
        this.getChoiceModel(300222).setValue(bl ? 0 : 1);
        this.getChoiceModel(301131).setValue(bl ? 0 : 1);
        this.getButtonModel(300950).fireEvent(n);
    }

    private void clearSpellerDisableButton() {
        this.log.log(10000000, "[TelPINEntryActivationHandler#clearSpellerDisableButton] called");
        this.getSpellerModel(300634).clear();
        this.getButtonModel(300735).setStatus(0);
    }

    private void activatePINRequired(String string, boolean bl, int n) {
        this.log.log(1000000, "[TelPINEntryActivationHandler#activatePINRequired] pin=%1, simPINrequired=%2", (Object)string, (Object)String.valueOf(bl));
        this.getApplication().getTelephoneDSIAccess().requestSIMPINRequired(string, bl, n, false, new TelDefaultDSIResponseListener(){

            public void responseSIMPINRequired(int n, int n2) {
                TelPINEntryActivationHandler.this.log.log(1000000, "[TelPINEntryActivationHandler.activatePINRequired(...).new TelDefaultDSIResponseListener() {...}#responseSIMPINRequired] result=%1", (long)n);
                TelPINEntryActivationHandler.this.simPinRequiredResponse(n);
            }
        });
    }

    protected void simPinRequiredResponse(int n) {
        this.log.log(10000000, "[TelPINEntryActivationHandler#responseSIMPINRequired] result=%1", (long)n);
        if (n == 0) {
            this.log.log(1000000, "[TelPINEntryActivationHandler#responseSIMPINRequired] RESULT_OK, update should have already been recieved.");
        } else if (n == 5) {
            this.log.log(1000000, "[TelPINEntryActivationHandler#responseSIMPINRequired] RESULT_ERROR_CODE_WRONG");
            this.getChoiceModel(300742).setValue(4);
        } else {
            this.log.log(1000000, "[TelPINEntryActivationHandler#responseSIMPINRequired] error response type %1", (long)n);
            this.getChoiceModel(300742).setValue(3);
        }
        this.triggerWaitSyncDsiResponseRecieved();
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelPINEntryActivationHandler#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        }
        if (n == 300634) {
            int n3 = this.getSpellerModel(300634).getMinLength();
            int n4 = this.getSpellerModel(300634).getMaxLength();
            if (string != null) {
                if (string.length() >= n3 && string.length() <= n4) {
                    this.getButtonModel(300735).setStatus(1);
                } else {
                    this.getButtonModel(300735).setStatus(0);
                }
            } else {
                this.getButtonModel(300735).setStatus(0);
            }
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

