/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.suppservices.AbstractTelCallForwardingStatusIconHandler;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.CFResponseData;

public abstract class AbstractTelCallForwardingHandler
extends AbstractPhoneComponent
implements ButtonListener,
SpellerListener {
    private static final int MAX_CHARS = 40;
    private int sentRequestType;
    private int recievedCFStatus;
    private String targetCFNumber;
    private volatile IGlobalTelephoneStateStruct telephoneState;
    private AbstractTelCallForwardingStatusIconHandler callForwardingStatusIconHandler = this.createCallForawardingStatusIconHandler();

    public AbstractTelCallForwardingHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    protected abstract AbstractTelCallForwardingStatusIconHandler createCallForawardingStatusIconHandler();

    public void init() {
        super.init();
        SpellerModelApp spellerModelApp = this.getSpellerModel(300525);
        spellerModelApp.setSpellerListener(this);
        this.getButtonModel(300521).setButtonListener(this);
        this.getButtonModel(300522).setButtonListener(this);
        this.getButtonModel(300524).setButtonListener(this);
        this.getButtonModel(300526).setButtonListener(this);
        spellerModelApp.setMinLength(0);
        spellerModelApp.setMaxLength(40);
        if (this.callForwardingStatusIconHandler != null) {
            this.getApplication().getGlobalTelephoneStateManager().registerListener(this.callForwardingStatusIconHandler);
        }
    }

    public void deinit() {
        super.deinit();
        this.getSpellerModel(300525).resetListener();
        this.getButtonModel(300521).resetListener();
        this.getButtonModel(300522).resetListener();
        this.getButtonModel(300524).resetListener();
        this.getButtonModel(300526).resetListener();
        if (this.callForwardingStatusIconHandler != null) {
            this.getApplication().getGlobalTelephoneStateManager().removeListener(this.callForwardingStatusIconHandler);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "TelCallForwardingHandler#keyTyped: modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 300525: 
            case 300526: {
                this.keyTypedCallDivertingNumberSpeller(n3);
                break;
            }
            case 300521: {
                this.keyTypedCallDivertingActivateButton(n3);
                break;
            }
            case 300522: {
                this.keyTypedCallDivertingCancelButton(n3);
                break;
            }
            case 300524: {
                this.keyTypedCallDivertingCheckButton(n3);
                break;
            }
            default: {
                this.log.log(10000000, "[TelCallForwardingHandler#keyTyped] no handling for model %1", (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    private void setDivertMessageNumberModel(String string) {
        this.getLabelModel(300380).setText(string);
    }

    private void setCallDivertingStateModel(int n, int n2) {
        this.getChoiceModel(300527).setValue(n2);
        this.getChoiceModel(300527).setStatus(n);
    }

    private void processResponseSetModels() {
        this.log.log(10000000, "TelCallForwardingHandler#setCallDivertingModels: received status=%1, sent request type was =%2 ", (long)this.recievedCFStatus, (long)this.sentRequestType);
        switch (this.sentRequestType) {
            case 3: {
                this.processResultActivate();
                break;
            }
            case 4: {
                this.processResultDeActivate();
                break;
            }
            case 2: {
                this.processResultQuery();
                break;
            }
            default: {
                this.log.log(10000, "TelCallForwardingHandler#setCallDivertingModels: Unhandled accessMode %1!! ", (long)this.sentRequestType);
            }
        }
    }

    private void processResultActivate() {
        this.log.log(1000000, "[TelCallForwardingHandler#processResultActivat] enter");
        switch (this.recievedCFStatus) {
            case 1: {
                this.setDivertMessageNumberModel(this.targetCFNumber);
                this.resultSuccess();
                break;
            }
            case 0: {
                this.resultFail();
                break;
            }
            default: {
                this.log.log(100000, "[TelCallForwardingHandler#processResultActivate] Unhandled facility status %1! ", (long)this.recievedCFStatus);
            }
        }
    }

    private void processResultDeActivate() {
        this.log.log(1000000, "[TelCallForwardingHandler#processResultDeActivate] enter");
        switch (this.recievedCFStatus) {
            case 1: {
                this.resultFail();
                break;
            }
            case 0: {
                this.resultSuccess();
                break;
            }
            default: {
                this.log.log(100000, "[TelCallForwardingHandler#processResultDeActivate]: Unhandled facility status %1! ", (long)this.recievedCFStatus);
            }
        }
    }

    private void processResultQuery() {
        this.log.log(1000000, "[TelCallForwardingHandler#processResultQuery] enter");
        switch (this.recievedCFStatus) {
            case 1: {
                this.setDivertMessageNumberModel(this.targetCFNumber);
                this.resultSuccess();
                this.log.log(10000000, "[TelCallForwardingHandler#processResultQuery] status check result, status is active, CALL_DIVERTING_STATE_CHOICE(status, value) <- (STATUS_VALID, VALUE_AVAILABLE)");
                break;
            }
            case 0: {
                this.setCallDivertingStateModel(1, -1);
                this.log.log(10000000, "[TelCallForwardingHandler#processResultQuery] status check result, status is inactive, CALL_DIVERTING_STATE_CHOICE(status, value) <- (STATUS_OK, -1)");
                break;
            }
            default: {
                this.resultFail();
                this.log.log(100000, "[TelCallForwardingHandler#processResultQuery] Unhandled facility status %1! ", (long)this.recievedCFStatus);
            }
        }
    }

    private void resultFail() {
        this.log.log(100000, "[TelCallForwardingHandler#resultFail] enter");
        if (this.sentRequestType == 2) {
            this.setCallDivertingStateModel(2, -1);
            this.log.log(100000, "[TelCallForwardingHandler#resultFail] dsi returned an error code,  CALL_DIVERTING_STATE_CHOICE(st,vl) <- (STATUS_ERROR, -1)");
        } else {
            this.setCallDivertingStateModel(1, -1);
            this.log.log(100000, "[TelCallForwardingHandler#resultFail] dsi returned an error code,  CALL_DIVERTING_STATE_CHOICE(st,vl) <- (STATUS_OK, -1)");
        }
    }

    private void resultSuccess() {
        this.log.log(10000000, "[TelCallForwardingHandler#resultSuceess] enter");
        this.setCallDivertingStateModel(1, 1);
        this.log.log(10000000, "[TelCallForwardingHandler#resultSuceess] success received,  CALL_DIVERTING_STATE_CHOICE(st,vl) <- (STATUS_VALID, VALUE_AVAILABLE)");
    }

    private void keyTypedCallDivertingNumberSpeller(int n) {
        this.log.log(10000000, "TelCallForwardingHandler#keyTypedCallDivertingNumberSpeller: called ");
        SpellerModelApp spellerModelApp = this.getSpellerModelApp(300525);
        String string = spellerModelApp.getText();
        this.activateCallForwarding(string, n);
        spellerModelApp.fireEvent(0);
    }

    public void activateCallForwarding(String string, int n) {
        this.sentRequestType = 3;
        this.setCallDivertingStateModel(0, 3);
        CFRequestData cFRequestData = new CFRequestData(this.sentRequestType, 0, string, 1, 0);
        this.requestCallForwarding(new CFRequestData[]{cFRequestData}, n);
    }

    private void requestCallForwarding(CFRequestData[] cFRequestDataArray, int n) {
        this.log.log(10000000, "TelCallForwardingHandler#requestCallForwarding: telCFRequestData=%1", (Object)Converter.array2String(cFRequestDataArray));
        this.getApplication().getTelephoneDSIAccess().requestCallForward(cFRequestDataArray, n, false, new TelDefaultDSIResponseListener(){

            public void responseCallForward(CFResponseData[] cFResponseDataArray, int n, int n2) {
                AbstractTelCallForwardingHandler.this.log.log(1000000, "TelCallForwardingHandler#responseCallForward, telCFData=%1, result=%2", (Object)Converter.array2String(cFResponseDataArray), (long)n);
                if (n != 0) {
                    AbstractTelCallForwardingHandler.this.log.log(10000, "TelCallForwardingHandler#responseCallForward handling error");
                    AbstractTelCallForwardingHandler.this.resultFail();
                    return;
                }
                if (cFResponseDataArray == null || cFResponseDataArray.length == 0 || cFResponseDataArray[0] == null) {
                    AbstractTelCallForwardingHandler.this.log.log(100000, "TelCallForwardingHandler#responseCallForward: Missing or invalid CF response data given! ");
                    return;
                }
                AbstractTelCallForwardingHandler.this.log.log(10000000, "TelCallForwardingHandler#responseCallForward:  requested type =%1!", (long)AbstractTelCallForwardingHandler.this.sentRequestType);
                CFResponseData cFResponseData = cFResponseDataArray[0];
                int n3 = cFResponseData.getTelCFStatus();
                String string = cFResponseData.getTelCFNumber();
                AbstractTelCallForwardingHandler.this.recievedCFStatus = n3;
                AbstractTelCallForwardingHandler.this.targetCFNumber = string;
                AbstractTelCallForwardingHandler.this.processResponseSetModels();
                AbstractTelCallForwardingHandler.this.updateCallForwardingStatusIcon(cFResponseDataArray);
            }
        });
    }

    private void updateCallForwardingStatusIcon(CFResponseData[] cFResponseDataArray) {
        if (this.callForwardingStatusIconHandler != null) {
            this.callForwardingStatusIconHandler.updateCallForwardingStatusIcon(cFResponseDataArray);
        }
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        super.updateGlobalTelephoneStateProperty(n, iGlobalTelephoneStateStruct);
        this.telephoneState = iGlobalTelephoneStateStruct;
    }

    private void keyTypedCallDivertingCancelButton(int n) {
        this.log.log(10000000, "TelCallForwardingHandler#keyTypedCallDivertingCancelButton: called ");
        this.sentRequestType = 4;
        this.setCallDivertingStateModel(0, 0);
        CFRequestData cFRequestData = new CFRequestData(4, 0, "", 1, 0);
        this.requestCallForwarding(new CFRequestData[]{cFRequestData}, n);
        this.getButtonModel(300522).fireEvent(0);
    }

    private void keyTypedCallDivertingActivateButton(int n) {
        this.log.log(10000000, "TelCallForwardingHandler#keyTypedCallDivertingActivateButton: called ");
        this.sentRequestType = 3;
        SpellerModelApp spellerModelApp = this.getSpellerModel(300525);
        spellerModelApp.clear();
        spellerModelApp.setStatus(1);
        this.getButtonModel(300521).fireEvent(0);
    }

    private void keyTypedCallDivertingCheckButton(int n) {
        this.log.log(10000000, "TelCallForwardingHandler#keyTypedCallDivertingCheckButton: called ");
        this.sentRequestType = 2;
        this.setCallDivertingStateModel(0, 0);
        CFRequestData cFRequestData = new CFRequestData(2, 0, "", 1, 0);
        this.requestCallForwarding(new CFRequestData[]{cFRequestData}, n);
        this.getButtonModel(300524).fireEvent(0);
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelCallForwardingHandler#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }
}

