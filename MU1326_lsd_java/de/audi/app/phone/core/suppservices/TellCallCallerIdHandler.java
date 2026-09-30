/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.atip.hmi.model.ButtonListener;

public class TellCallCallerIdHandler
extends AbstractPhoneComponent
implements ButtonListener {
    private static final int CHECK_RESULT_ERR_BRANCH_SM_VALUE = 2;
    private int sentRequestMode;

    public TellCallCallerIdHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        this.getButtonModel(300211).setButtonListener(this);
        this.getButtonModel(300213).setButtonListener(this);
        this.getButtonModel(300215).setButtonListener(this);
        this.getButtonModel(300217).setButtonListener(this);
    }

    public void deinit() {
        this.getButtonModel(300211).resetListener();
        this.getButtonModel(300213).resetListener();
        this.getButtonModel(300215).resetListener();
        this.getButtonModel(300217).resetListener();
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "[TellCallCallerIdHandler#keyTyped] id=%1, keyID=%2, terminalId = %3", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 300211: {
                this.keyTypedOwnNumberActivateButton(n3);
                break;
            }
            case 300213: {
                this.keyTypedOwnNumberCheckButton(n3);
                break;
            }
            case 300215: {
                this.keyTypedOwnNumberDeactivateButton(n3);
                break;
            }
            case 300217: {
                this.keyTypedOwnNumberNetworkButton(n3);
                break;
            }
            default: {
                this.log.log(10000, "[TellCallCallerIdHandler#keyTyped]unhandled model ID %1 ", (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void keyTypedOwnNumberActivateButton(int n) {
        this.processClirRequest(2, 300211, 300212, n);
    }

    private void keyTypedOwnNumberDeactivateButton(int n) {
        this.processClirRequest(1, 300215, 300216, n);
    }

    private void keyTypedOwnNumberCheckButton(int n) {
        this.processClirRequest(3, 300213, 300214, n);
    }

    private void keyTypedOwnNumberNetworkButton(int n) {
        this.processClirRequest(0, 300217, 300218, n);
    }

    private void processClirRequest(int n, int n2, int n3, int n4) {
        this.log.log(10000000, "[TellCallCallerIdHandler#processClirRequest] entering ");
        this.setOwnNumberModel(0, 0, n3);
        this.sentRequestMode = n;
        this.requestCLIR(n);
        this.getButtonModel(n2).fireEvent(n4);
    }

    private void setOwnNumberModel(int n, int n2, int n3) {
        this.getChoiceModel(n3).setValue(n2);
        this.getChoiceModel(n3).setStatus(n);
        this.log.log(10000000, "[TellCallCallerIdHandler#setOwnNumberModel] ownNumberActivateStateChoice.value=%2, .status=%1 ", (long)n, (long)n2);
    }

    public void requestCLIR(int n) {
        this.log.log(10000000, "[TellCallCallerIdHandler#requestCLIR] telCLIRState=%1", (long)n);
        this.getApplication().getTelephoneDSIAccess().requestCLIR(n, 0, true, new TelDefaultDSIResponseListener(){

            public void responseCLIR(int n, int n2, int n3, int n4) {
                TellCallCallerIdHandler.this.log.log(10000000, "[TellCallCallerIdHandler#responseCLIR] requested CLIR access mode=%1 ", (long)TellCallCallerIdHandler.this.sentRequestMode);
                if (n3 != 0 || n != TellCallCallerIdHandler.this.sentRequestMode && TellCallCallerIdHandler.this.sentRequestMode != 3) {
                    TellCallCallerIdHandler.this.log.log(10000000, "[TellCallCallerIdHandler#responseCLIR] Unhandled telCLIRState %1 ", (long)n);
                    TellCallCallerIdHandler.this.handleErrorCLIR();
                    return;
                }
                TellCallCallerIdHandler.this.processCLIRSuccessResopnse(n, n2);
            }
        });
    }

    private void handleErrorCLIR() {
        this.log.log(10000000, "[TellCallCallerIdHandler#handleErrorCLIR] mode=%1! ", (long)this.sentRequestMode);
        switch (this.sentRequestMode) {
            case 0: {
                this.setChoiceModel(1, -1, 300218);
                break;
            }
            case 1: {
                this.setChoiceModel(1, -1, 300216);
                break;
            }
            case 2: {
                this.setChoiceModel(1, -1, 300212);
                break;
            }
            case 3: {
                this.getChoiceModel(300386).setValue(2);
                this.setChoiceModel(1, 1, 300214);
                break;
            }
            default: {
                this.log.log(100000, "[TellCallCallerIdHandler#handleErrorCLIR] Unhandled mode %1! ", (long)this.sentRequestMode);
            }
        }
    }

    private void setChoiceModel(int n, int n2, int n3) {
        this.getChoiceModel(n3).setValue(n2);
        this.getChoiceModel(n3).setStatus(n);
        this.log.log(10000000, "[TellCallCallerIdHandler#setChoiceModel] ownNumberNetworkStateChoice.value=%2, .status=%1, modelID = %3", (long)n, (long)n2, (long)n3);
        this.log.log(10000000, "[TellCallCallerIdHandler#setChoiceModel] setting: (model#%1)(st,vl) <- (%2,%3)", (long)n3, (long)n, (long)n2);
    }

    private void processCLIRSuccessResopnse(int n, int n2) {
        this.log.log(10000000, "[TellCallCallerIdHandler#processCLIRSuccessResopnd] new CLIR state=%1, new nwState=%2 ", (long)n, (long)n2);
        switch (this.sentRequestMode) {
            case 1: {
                this.setChoiceModelsAfterSuccess(300216);
                break;
            }
            case 2: {
                this.setChoiceModelsAfterSuccess(300212);
                break;
            }
            case 0: {
                this.setChoiceModelsAfterSuccess(300218);
                break;
            }
            case 3: {
                this.processCheckSuccess(n, n2);
                break;
            }
            default: {
                this.log.log(100000, "[TellCallCallerIdHandler#processCLIRSuccessResopnd] Unhandled mode %1! ", (long)this.sentRequestMode);
            }
        }
    }

    private void processCheckSuccess(int n, int n2) {
        this.log.log(10000000, "[TellCallCallerIdHandler#setModelsAfterCheckSuccess] enter, new CLIR state=%1, new nwState=%2 ", (long)n, (long)n2);
        int n3 = this.getCheckStatusDSIResultCode2SMode(n);
        this.getChoiceModel(300386).setValue(n3);
        this.log.log(10000000, "[TellCallCallerIdHandler#setModelsAfterCheckSuccess]  (ICorePhoneModelBank.TEL_SETUP_NUMBER_CHECK_RESULT_CHOICE)(v) <- (%1)", (long)n3);
        this.setChoiceModel(1, 1, 300214);
        this.log.log(10000000, "[TellCallCallerIdHandler#setModelsAfterCheckSuccess]  (ICorePhoneModelBank.OWN_NUMBER_CHECK_STATE_CHOICE)(s,v) <- (%1,%2)", 1L, 1L);
    }

    private int getCheckStatusDSIResultCode2SMode(int n) {
        switch (n) {
            case 2: {
                return 0;
            }
            case 1: {
                return -1;
            }
            case 0: {
                return 1;
            }
        }
        return 2;
    }

    private void setChoiceModelsAfterSuccess(int n) {
        this.log.log(10000000, "[TellCallCallerIdHandler#setChoiceModelsAfterSuccess]  modelId = %1", (long)n);
        this.setChoiceModel(1, 1, n);
        this.log.log(10000000, "[TellCallCallerIdHandler#setChoiceModelsAfterSuccess]  setting: (modell#%1)(st,vl) <- (STATUS_VALID, VALUE_AVAILABLE)", (long)n);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }
}

