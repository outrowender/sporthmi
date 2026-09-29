/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.suppservices.TellCallCallerIdHandler$1;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;

public class TellCallCallerIdHandler
extends AbstractPhoneComponent
implements ButtonListener {
    private static final int CHECK_RESULT_ERR_BRANCH_SM_VALUE;
    private int sentRequestMode;

    public TellCallCallerIdHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getButtonModel(-1282145280).setButtonListener(this);
        this.getButtonModel(-1248590848).setButtonListener(this);
        this.getButtonModel(-1215036416).setButtonListener(this);
        this.getButtonModel(-1181481984).setButtonListener(this);
    }

    @Override
    public void deinit() {
        this.getButtonModel(-1282145280).resetListener();
        this.getButtonModel(-1248590848).resetListener();
        this.getButtonModel(-1215036416).resetListener();
        this.getButtonModel(-1181481984).resetListener();
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TellCallCallerIdHandler#keyTyped] id=%1, keyID=%2, terminalId = %3", (long)n, (long)n2, (long)n3);
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

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void keyTypedOwnNumberActivateButton(int n) {
        this.processClirRequest(2, -1282145280, -1265368064, n);
    }

    private void keyTypedOwnNumberDeactivateButton(int n) {
        this.processClirRequest(1, -1215036416, -1198259200, n);
    }

    private void keyTypedOwnNumberCheckButton(int n) {
        this.processClirRequest(3, -1248590848, -1231813632, n);
    }

    private void keyTypedOwnNumberNetworkButton(int n) {
        this.processClirRequest(0, -1181481984, -1164704768, n);
    }

    private void processClirRequest(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "[TellCallCallerIdHandler#processClirRequest] entering ");
        this.setOwnNumberModel(0, 0, n3);
        this.sentRequestMode = n;
        this.requestCLIR(n);
        this.getButtonModel(n2).fireEvent(n4);
    }

    private void setOwnNumberModel(int n, int n2, int n3) {
        this.getChoiceModel(n3).setValue(n2);
        this.getChoiceModel(n3).setStatus(n);
        this.log.log(-2137614336, "[TellCallCallerIdHandler#setOwnNumberModel] ownNumberActivateStateChoice.value=%2, .status=%1 ", (long)n, (long)n2);
    }

    public void requestCLIR(int n) {
        this.log.log(-2137614336, "[TellCallCallerIdHandler#requestCLIR] telCLIRState=%1", (long)n);
        this.getApplication().getTelephoneDSIAccess().requestCLIR(n, 0, true, new TellCallCallerIdHandler$1(this));
    }

    private void handleErrorCLIR() {
        this.log.log(-2137614336, "[TellCallCallerIdHandler#handleErrorCLIR] mode=%1! ", (long)this.sentRequestMode);
        switch (this.sentRequestMode) {
            case 0: {
                this.setChoiceModel(1, -1, -1164704768);
                break;
            }
            case 1: {
                this.setChoiceModel(1, -1, -1198259200);
                break;
            }
            case 2: {
                this.setChoiceModel(1, -1, -1265368064);
                break;
            }
            case 3: {
                this.getChoiceModel(1653933056).setValue(2);
                this.setChoiceModel(1, 1, -1231813632);
                break;
            }
            default: {
                this.log.log(-1601830656, "[TellCallCallerIdHandler#handleErrorCLIR] Unhandled mode %1! ", (long)this.sentRequestMode);
            }
        }
    }

    private void setChoiceModel(int n, int n2, int n3) {
        this.getChoiceModel(n3).setValue(n2);
        this.getChoiceModel(n3).setStatus(n);
        this.log.log(-2137614336, "[TellCallCallerIdHandler#setChoiceModel] ownNumberNetworkStateChoice.value=%2, .status=%1, modelID = %3", (long)n, (long)n2, (long)n3);
        this.log.log(-2137614336, "[TellCallCallerIdHandler#setChoiceModel] setting: (model#%1)(st,vl) <- (%2,%3)", (long)n3, (long)n, (long)n2);
    }

    private void processCLIRSuccessResopnse(int n, int n2) {
        this.log.log(-2137614336, "[TellCallCallerIdHandler#processCLIRSuccessResopnd] new CLIR state=%1, new nwState=%2 ", (long)n, (long)n2);
        switch (this.sentRequestMode) {
            case 1: {
                this.setChoiceModelsAfterSuccess(-1198259200);
                break;
            }
            case 2: {
                this.setChoiceModelsAfterSuccess(-1265368064);
                break;
            }
            case 0: {
                this.setChoiceModelsAfterSuccess(-1164704768);
                break;
            }
            case 3: {
                this.processCheckSuccess(n, n2);
                break;
            }
            default: {
                this.log.log(-1601830656, "[TellCallCallerIdHandler#processCLIRSuccessResopnd] Unhandled mode %1! ", (long)this.sentRequestMode);
            }
        }
    }

    private void processCheckSuccess(int n, int n2) {
        this.log.log(-2137614336, "[TellCallCallerIdHandler#setModelsAfterCheckSuccess] enter, new CLIR state=%1, new nwState=%2 ", (long)n, (long)n2);
        int n3 = this.getCheckStatusDSIResultCode2SMode(n);
        this.getChoiceModel(1653933056).setValue(n3);
        this.log.log(-2137614336, "[TellCallCallerIdHandler#setModelsAfterCheckSuccess]  (ICorePhoneModelBank.TEL_SETUP_NUMBER_CHECK_RESULT_CHOICE)(v) <- (%1)", (long)n3);
        this.setChoiceModel(1, 1, -1231813632);
        this.log.log(-2137614336, "[TellCallCallerIdHandler#setModelsAfterCheckSuccess]  (ICorePhoneModelBank.OWN_NUMBER_CHECK_STATE_CHOICE)(s,v) <- (%1,%2)", 1L, 1L);
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
        this.log.log(-2137614336, "[TellCallCallerIdHandler#setChoiceModelsAfterSuccess]  modelId = %1", (long)n);
        this.setChoiceModel(1, 1, n);
        this.log.log(-2137614336, "[TellCallCallerIdHandler#setChoiceModelsAfterSuccess]  setting: (modell#%1)(st,vl) <- (STATUS_VALID, VALUE_AVAILABLE)", (long)n);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    static /* synthetic */ int access$000(TellCallCallerIdHandler tellCallCallerIdHandler) {
        return tellCallCallerIdHandler.sentRequestMode;
    }

    static /* synthetic */ LogChannel access$100(TellCallCallerIdHandler tellCallCallerIdHandler) {
        return tellCallCallerIdHandler.log;
    }

    static /* synthetic */ LogChannel access$200(TellCallCallerIdHandler tellCallCallerIdHandler) {
        return tellCallCallerIdHandler.log;
    }

    static /* synthetic */ void access$300(TellCallCallerIdHandler tellCallCallerIdHandler) {
        tellCallCallerIdHandler.handleErrorCLIR();
    }

    static /* synthetic */ void access$400(TellCallCallerIdHandler tellCallCallerIdHandler, int n, int n2) {
        tellCallCallerIdHandler.processCLIRSuccessResopnse(n, n2);
    }
}

