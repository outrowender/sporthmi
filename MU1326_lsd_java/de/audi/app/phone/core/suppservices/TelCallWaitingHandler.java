/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.suppservices.TelCallWaitingHandler$1;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;

public class TelCallWaitingHandler
extends AbstractPhoneComponent
implements ButtonListener {
    private static final int VALUE_RESULT_UNSUCCESSFULL;
    private static final int VALUE_RESULT_SUCCESS;
    private static final int VALUE_DSI_RESULT_ERROR;
    private static final int SERVICE_ACTIVE;
    private static final int SERVICE_INACTIVE;
    private int sentRequestType;
    private int responseStatus;

    public TelCallWaitingHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getButtonModel(278266880).setButtonListener(this);
        this.getButtonModel(295044096).setButtonListener(this);
        this.getButtonModel(328598528).setButtonListener(this);
    }

    @Override
    public void deinit() {
        this.getButtonModel(278266880).resetListener();
        this.getButtonModel(295044096).resetListener();
        this.getButtonModel(328598528).resetListener();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelTelCallWaitingHandler#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 300560: {
                this.keyTypedCallWaitingActivateButton(n3);
                break;
            }
            case 300561: {
                this.keyTypedCallWaitingCheckButton(n3);
                break;
            }
            case 300563: {
                this.keyTypedCallWaitingDeactivateButton(n3);
                break;
            }
            default: {
                this.log.log(10000, "[TelTelCallWaitingHandler#keyTyped]: unhandled model ID %1 ", (long)n);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void keyTypedCallWaitingDeactivateButton(int n) {
        this.log.log(-2137614336, "[TelTelCallWaitingHandler#keyTypedCallWaitingDeactivateButton]");
        this.executeRequest(0, 580256768, 328598528, n);
    }

    private void keyTypedCallWaitingCheckButton(int n) {
        this.log.log(-2137614336, "[TelTelCallWaitingHandler#keyTypedCallWaitingCheckButton]");
        this.executeRequest(2, 815137792, 295044096, n);
    }

    private void keyTypedCallWaitingActivateButton(int n) {
        this.log.log(-2137614336, "[TelTelCallWaitingHandler#keyTypedCallWaitingActivateButton]");
        this.executeRequest(1, -1047198720, 278266880, n);
    }

    private void executeRequest(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "[TelTelCallWaitingHandler#executeRequest] enter");
        this.sentRequestType = n;
        ButtonModelApp buttonModelApp = this.getButtonModel(n3);
        this.setWaitSyncModelStateValue(n2, 0, 0);
        this.getApplication().getTelephoneDSIAccess().requestCallWaiting(n, n4, false, new TelCallWaitingHandler$1(this));
        buttonModelApp.fireEvent(n4);
    }

    private void processRespondToActivate() {
        this.log.log(-2137614336, "TelTelCallWaitingHandler#processRespondToActivate: enter");
        switch (this.responseStatus) {
            case 1: {
                this.setWaitSyncModelStateValue(-1047198720, 1, 1);
                this.log.log(-2137614336, "TelTelCallWaitingHandler#processRespondToActivate  ACTIVATE_CALL_WAITING_STATE_CHOICE <- (VALUE_RESULT_SUCCESS, STATUS_OK)");
                break;
            }
            case 0: {
                this.setWaitSyncModelStateValue(-1047198720, 0, 2);
                this.log.log(-2137614336, "TelTelCallWaitingHandler#processRespondToActivate ACTIVATE_CALL_WAITING_STATE_CHOICE <- (VALUE_RESULT_UNSUCCESSFULL, STATUS_ERROR)");
                break;
            }
            default: {
                this.log.log(-1601830656, "TelTelCallWaitingHandler#processRespondToActivate: Unhandled status %1! ", (long)this.responseStatus);
            }
        }
    }

    private void processRespondToDeactivate() {
        this.log.log(-2137614336, "TelCallWaitingHandler#processRespondToDeactivate: enter");
        switch (this.responseStatus) {
            case 0: {
                this.setWaitSyncModelStateValue(580256768, 1, 1);
                this.log.log(-2137614336, "TelTelCallWaitingHandler#processRespondToDeactivate CANCEL_CALL_WAITING_STATE_CHOICE <- (VALUE_RESULT_SUCCESS, STATUS_OK)");
                break;
            }
            case 1: {
                this.setWaitSyncModelStateValue(580256768, 0, 2);
                this.log.log(-2137614336, "TelTelCallWaitingHandler#processRespondToDeactivate CANCEL_CALL_WAITING_STATE_CHOICE <- (VALUE_RESULT_SUCCESS, STATUS_ERROR)");
                break;
            }
            default: {
                this.log.log(-1601830656, "TelTelCallWaitingHandler#processRespondToDeactivate status %1! ", (long)this.responseStatus);
            }
        }
    }

    private void processRespondToQuery() {
        this.log.log(-2137614336, "TelCallWaitingHandler#processRespondToQuery: enter");
        switch (this.responseStatus) {
            case 1: {
                this.setWaitSyncModelStateValue(815137792, 1, 1);
                this.log.log(-2137614336, "TelTelCallWaitingHandler#processRespondToQuery CHECK_CALL_WAITING_STATE_CHOICE <- (SERVICE_ACTIVE, STATUS_OK)");
                break;
            }
            case 0: {
                this.setWaitSyncModelStateValue(815137792, -1, 1);
                this.log.log(-2137614336, "TelTelCallWaitingHandler#processRespondToQuery CHECK_CALL_WAITING_STATE_CHOICE <- (SERVICE_INACTIVE, STATUS_OK)");
                break;
            }
            default: {
                this.setWaitSyncModelStateValue(815137792, 0, 2);
                this.log.log(-1601830656, "TelCallWaitingHandler#processRespondToQuery: Unhandled status %1! ", (long)this.responseStatus);
            }
        }
    }

    private void handleDSIResultError() {
        int n = this.sentRequestType;
        this.log.log(10000, "[TelTelCallWaitingHandler#handleDSIResultError requested mode = %1", (long)n);
        switch (n) {
            case 1: {
                this.setWaitSyncModelStateValue(-1047198720, -1, 1);
                this.log.log(10000, "[TelTelCallWaitingHandler#handleDSIResultError] ACTIVATE_CALL_WAITING_STATE_CHOICE <- (VALUE_DSI_RESULT_ERROR, STATUS_OK");
                break;
            }
            case 0: {
                this.setWaitSyncModelStateValue(580256768, -1, 1);
                this.log.log(10000, "[TelTelCallWaitingHandler#handleDSIResultError]  CANCEL_CALL_WAITING_STATE_CHOICE <- (VALUE_DSI_RESULT_ERROR, STATUS_OK");
                break;
            }
            case 2: {
                this.setWaitSyncModelStateValue(815137792, -1, 2);
                this.log.log(10000, "[TelTelCallWaitingHandler#handleDSIResultError] CHECK_CALL_WAITING_STATE_CHOICE <- (VALUE_DSI_RESULT_ERROR, STATUS_ERROR");
                break;
            }
            default: {
                this.log.log(10000, "[TelTelCallWaitingHandler#handleDSIResultError]  Result not OK! Unhandled mode %1! ", (long)n);
            }
        }
    }

    private void setWaitSyncModelStateValue(int n, int n2, int n3) {
        this.getChoiceModel(n).setValue(n2);
        this.getChoiceModel(n).setStatus(n3);
    }

    static /* synthetic */ int access$002(TelCallWaitingHandler telCallWaitingHandler, int n) {
        telCallWaitingHandler.responseStatus = n;
        return telCallWaitingHandler.responseStatus;
    }

    static /* synthetic */ LogChannel access$100(TelCallWaitingHandler telCallWaitingHandler) {
        return telCallWaitingHandler.log;
    }

    static /* synthetic */ int access$200(TelCallWaitingHandler telCallWaitingHandler) {
        return telCallWaitingHandler.sentRequestType;
    }

    static /* synthetic */ LogChannel access$300(TelCallWaitingHandler telCallWaitingHandler) {
        return telCallWaitingHandler.log;
    }

    static /* synthetic */ void access$400(TelCallWaitingHandler telCallWaitingHandler) {
        telCallWaitingHandler.handleDSIResultError();
    }

    static /* synthetic */ void access$500(TelCallWaitingHandler telCallWaitingHandler) {
        telCallWaitingHandler.processRespondToActivate();
    }

    static /* synthetic */ void access$600(TelCallWaitingHandler telCallWaitingHandler) {
        telCallWaitingHandler.processRespondToDeactivate();
    }

    static /* synthetic */ void access$700(TelCallWaitingHandler telCallWaitingHandler) {
        telCallWaitingHandler.processRespondToQuery();
    }

    static /* synthetic */ LogChannel access$800(TelCallWaitingHandler telCallWaitingHandler) {
        return telCallWaitingHandler.log;
    }
}

