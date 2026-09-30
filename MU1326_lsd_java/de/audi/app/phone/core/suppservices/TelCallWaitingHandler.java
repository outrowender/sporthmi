/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class TelCallWaitingHandler
extends AbstractPhoneComponent
implements ButtonListener {
    private static final int VALUE_RESULT_UNSUCCESSFULL = 0;
    private static final int VALUE_RESULT_SUCCESS = 1;
    private static final int VALUE_DSI_RESULT_ERROR = -1;
    private static final int SERVICE_ACTIVE = 1;
    private static final int SERVICE_INACTIVE = -1;
    private int sentRequestType;
    private int responseStatus;

    public TelCallWaitingHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        this.getButtonModel(300560).setButtonListener(this);
        this.getButtonModel(300561).setButtonListener(this);
        this.getButtonModel(300563).setButtonListener(this);
    }

    public void deinit() {
        this.getButtonModel(300560).resetListener();
        this.getButtonModel(300561).resetListener();
        this.getButtonModel(300563).resetListener();
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "[TelTelCallWaitingHandler#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
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

    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void keyTypedCallWaitingDeactivateButton(int n) {
        this.log.log(10000000, "[TelTelCallWaitingHandler#keyTypedCallWaitingDeactivateButton]");
        this.executeRequest(0, 300578, 300563, n);
    }

    private void keyTypedCallWaitingCheckButton(int n) {
        this.log.log(10000000, "[TelTelCallWaitingHandler#keyTypedCallWaitingCheckButton]");
        this.executeRequest(2, 300592, 300561, n);
    }

    private void keyTypedCallWaitingActivateButton(int n) {
        this.log.log(10000000, "[TelTelCallWaitingHandler#keyTypedCallWaitingActivateButton]");
        this.executeRequest(1, 300481, 300560, n);
    }

    private void executeRequest(int n, int n2, int n3, int n4) {
        this.log.log(10000000, "[TelTelCallWaitingHandler#executeRequest] enter");
        this.sentRequestType = n;
        ButtonModelApp buttonModelApp = this.getButtonModel(n3);
        this.setWaitSyncModelStateValue(n2, 0, 0);
        this.getApplication().getTelephoneDSIAccess().requestCallWaiting(n, n4, false, new TelDefaultDSIResponseListener(){

            public void responseCallWaiting(int n, int n2, int n3, int n4) {
                TelCallWaitingHandler.this.responseStatus = n2;
                TelCallWaitingHandler.this.log.log(10000000, "[TelTelCallWaitingHandler#responseCallWaiting] telCWMode=%1, telCWStatus=%2, result=%3", (long)n, (long)n2, (long)n3);
                TelCallWaitingHandler.this.log.log(10000000, "[TelTelCallWaitingHandler#responseCallWaiting] most recent request type=%1", (long)TelCallWaitingHandler.this.sentRequestType);
                if (n3 != 0) {
                    TelCallWaitingHandler.this.handleDSIResultError();
                } else {
                    switch (TelCallWaitingHandler.this.sentRequestType) {
                        case 1: {
                            TelCallWaitingHandler.this.processRespondToActivate();
                            break;
                        }
                        case 0: {
                            TelCallWaitingHandler.this.processRespondToDeactivate();
                            break;
                        }
                        case 2: {
                            TelCallWaitingHandler.this.processRespondToQuery();
                            break;
                        }
                        default: {
                            TelCallWaitingHandler.this.log.log(10000, "TelCallWaitingHandler#setCallWaitingModels: Unhandled mode %1! ", (long)n);
                        }
                    }
                }
            }
        });
        buttonModelApp.fireEvent(n4);
    }

    private void processRespondToActivate() {
        this.log.log(10000000, "TelTelCallWaitingHandler#processRespondToActivate: enter");
        switch (this.responseStatus) {
            case 1: {
                this.setWaitSyncModelStateValue(300481, 1, 1);
                this.log.log(10000000, "TelTelCallWaitingHandler#processRespondToActivate  ACTIVATE_CALL_WAITING_STATE_CHOICE <- (VALUE_RESULT_SUCCESS, STATUS_OK)");
                break;
            }
            case 0: {
                this.setWaitSyncModelStateValue(300481, 0, 2);
                this.log.log(10000000, "TelTelCallWaitingHandler#processRespondToActivate ACTIVATE_CALL_WAITING_STATE_CHOICE <- (VALUE_RESULT_UNSUCCESSFULL, STATUS_ERROR)");
                break;
            }
            default: {
                this.log.log(100000, "TelTelCallWaitingHandler#processRespondToActivate: Unhandled status %1! ", (long)this.responseStatus);
            }
        }
    }

    private void processRespondToDeactivate() {
        this.log.log(10000000, "TelCallWaitingHandler#processRespondToDeactivate: enter");
        switch (this.responseStatus) {
            case 0: {
                this.setWaitSyncModelStateValue(300578, 1, 1);
                this.log.log(10000000, "TelTelCallWaitingHandler#processRespondToDeactivate CANCEL_CALL_WAITING_STATE_CHOICE <- (VALUE_RESULT_SUCCESS, STATUS_OK)");
                break;
            }
            case 1: {
                this.setWaitSyncModelStateValue(300578, 0, 2);
                this.log.log(10000000, "TelTelCallWaitingHandler#processRespondToDeactivate CANCEL_CALL_WAITING_STATE_CHOICE <- (VALUE_RESULT_SUCCESS, STATUS_ERROR)");
                break;
            }
            default: {
                this.log.log(100000, "TelTelCallWaitingHandler#processRespondToDeactivate status %1! ", (long)this.responseStatus);
            }
        }
    }

    private void processRespondToQuery() {
        this.log.log(10000000, "TelCallWaitingHandler#processRespondToQuery: enter");
        switch (this.responseStatus) {
            case 1: {
                this.setWaitSyncModelStateValue(300592, 1, 1);
                this.log.log(10000000, "TelTelCallWaitingHandler#processRespondToQuery CHECK_CALL_WAITING_STATE_CHOICE <- (SERVICE_ACTIVE, STATUS_OK)");
                break;
            }
            case 0: {
                this.setWaitSyncModelStateValue(300592, -1, 1);
                this.log.log(10000000, "TelTelCallWaitingHandler#processRespondToQuery CHECK_CALL_WAITING_STATE_CHOICE <- (SERVICE_INACTIVE, STATUS_OK)");
                break;
            }
            default: {
                this.setWaitSyncModelStateValue(300592, 0, 2);
                this.log.log(100000, "TelCallWaitingHandler#processRespondToQuery: Unhandled status %1! ", (long)this.responseStatus);
            }
        }
    }

    private void handleDSIResultError() {
        int n = this.sentRequestType;
        this.log.log(10000, "[TelTelCallWaitingHandler#handleDSIResultError requested mode = %1", (long)n);
        switch (n) {
            case 1: {
                this.setWaitSyncModelStateValue(300481, -1, 1);
                this.log.log(10000, "[TelTelCallWaitingHandler#handleDSIResultError] ACTIVATE_CALL_WAITING_STATE_CHOICE <- (VALUE_DSI_RESULT_ERROR, STATUS_OK");
                break;
            }
            case 0: {
                this.setWaitSyncModelStateValue(300578, -1, 1);
                this.log.log(10000, "[TelTelCallWaitingHandler#handleDSIResultError]  CANCEL_CALL_WAITING_STATE_CHOICE <- (VALUE_DSI_RESULT_ERROR, STATUS_OK");
                break;
            }
            case 2: {
                this.setWaitSyncModelStateValue(300592, -1, 2);
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
}

