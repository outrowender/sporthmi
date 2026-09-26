/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.suppservices.AbstractTelCallForwardingHandler$1;
import de.audi.app.phone.core.suppservices.AbstractTelCallForwardingStatusIconHandler;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.CFResponseData;

public abstract class AbstractTelCallForwardingHandler
extends AbstractPhoneComponent
implements ButtonListener,
SpellerListener {
    private static final int MAX_CHARS;
    private int sentRequestType;
    private int recievedCFStatus;
    private String targetCFNumber;
    private volatile IGlobalTelephoneStateStruct telephoneState;
    private AbstractTelCallForwardingStatusIconHandler callForwardingStatusIconHandler = this.createCallForawardingStatusIconHandler();

    public AbstractTelCallForwardingHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    protected abstract AbstractTelCallForwardingStatusIconHandler createCallForawardingStatusIconHandler() {
    }

    @Override
    public void init() {
        super.init();
        SpellerModelApp spellerModelApp = this.getSpellerModel(-309001216);
        spellerModelApp.setSpellerListener(this);
        this.getButtonModel(-376110080).setButtonListener(this);
        this.getButtonModel(-359332864).setButtonListener(this);
        this.getButtonModel(-325778432).setButtonListener(this);
        this.getButtonModel(-292224000).setButtonListener(this);
        spellerModelApp.setMinLength(0);
        spellerModelApp.setMaxLength(40);
        if (this.callForwardingStatusIconHandler != null) {
            this.getApplication().getGlobalTelephoneStateManager().registerListener(this.callForwardingStatusIconHandler);
        }
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getSpellerModel(-309001216).resetListener();
        this.getButtonModel(-376110080).resetListener();
        this.getButtonModel(-359332864).resetListener();
        this.getButtonModel(-325778432).resetListener();
        this.getButtonModel(-292224000).resetListener();
        if (this.callForwardingStatusIconHandler != null) {
            this.getApplication().getGlobalTelephoneStateManager().removeListener(this.callForwardingStatusIconHandler);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "TelCallForwardingHandler#keyTyped: modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
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
                this.log.log(-2137614336, "[TelCallForwardingHandler#keyTyped] no handling for model %1", (long)n);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    private void setDivertMessageNumberModel(String string) {
        this.getLabelModel(1553269760).setText(string);
    }

    private void setCallDivertingStateModel(int n, int n2) {
        this.getChoiceModel(-275446784).setValue(n2);
        this.getChoiceModel(-275446784).setStatus(n);
    }

    private void processResponseSetModels() {
        this.log.log(-2137614336, "TelCallForwardingHandler#setCallDivertingModels: received status=%1, sent request type was =%2 ", (long)this.recievedCFStatus, (long)this.sentRequestType);
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
        this.log.log(1078071040, "[TelCallForwardingHandler#processResultActivat] enter");
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
                this.log.log(-1601830656, "[TelCallForwardingHandler#processResultActivate] Unhandled facility status %1! ", (long)this.recievedCFStatus);
            }
        }
    }

    private void processResultDeActivate() {
        this.log.log(1078071040, "[TelCallForwardingHandler#processResultDeActivate] enter");
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
                this.log.log(-1601830656, "[TelCallForwardingHandler#processResultDeActivate]: Unhandled facility status %1! ", (long)this.recievedCFStatus);
            }
        }
    }

    private void processResultQuery() {
        this.log.log(1078071040, "[TelCallForwardingHandler#processResultQuery] enter");
        switch (this.recievedCFStatus) {
            case 1: {
                this.setDivertMessageNumberModel(this.targetCFNumber);
                this.resultSuccess();
                this.log.log(-2137614336, "[TelCallForwardingHandler#processResultQuery] status check result, status is active, CALL_DIVERTING_STATE_CHOICE(status, value) <- (STATUS_VALID, VALUE_AVAILABLE)");
                break;
            }
            case 0: {
                this.setCallDivertingStateModel(1, -1);
                this.log.log(-2137614336, "[TelCallForwardingHandler#processResultQuery] status check result, status is inactive, CALL_DIVERTING_STATE_CHOICE(status, value) <- (STATUS_OK, -1)");
                break;
            }
            default: {
                this.resultFail();
                this.log.log(-1601830656, "[TelCallForwardingHandler#processResultQuery] Unhandled facility status %1! ", (long)this.recievedCFStatus);
            }
        }
    }

    private void resultFail() {
        this.log.log(-1601830656, "[TelCallForwardingHandler#resultFail] enter");
        if (this.sentRequestType == 2) {
            this.setCallDivertingStateModel(2, -1);
            this.log.log(-1601830656, "[TelCallForwardingHandler#resultFail] dsi returned an error code,  CALL_DIVERTING_STATE_CHOICE(st,vl) <- (STATUS_ERROR, -1)");
        } else {
            this.setCallDivertingStateModel(1, -1);
            this.log.log(-1601830656, "[TelCallForwardingHandler#resultFail] dsi returned an error code,  CALL_DIVERTING_STATE_CHOICE(st,vl) <- (STATUS_OK, -1)");
        }
    }

    private void resultSuccess() {
        this.log.log(-2137614336, "[TelCallForwardingHandler#resultSuceess] enter");
        this.setCallDivertingStateModel(1, 1);
        this.log.log(-2137614336, "[TelCallForwardingHandler#resultSuceess] success received,  CALL_DIVERTING_STATE_CHOICE(st,vl) <- (STATUS_VALID, VALUE_AVAILABLE)");
    }

    private void keyTypedCallDivertingNumberSpeller(int n) {
        this.log.log(-2137614336, "TelCallForwardingHandler#keyTypedCallDivertingNumberSpeller: called ");
        SpellerModelApp spellerModelApp = this.getSpellerModelApp(-309001216);
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
        this.log.log(-2137614336, "TelCallForwardingHandler#requestCallForwarding: telCFRequestData=%1", (Object)Converter.array2String(cFRequestDataArray));
        this.getApplication().getTelephoneDSIAccess().requestCallForward(cFRequestDataArray, n, false, new AbstractTelCallForwardingHandler$1(this));
    }

    private void updateCallForwardingStatusIcon(CFResponseData[] cFResponseDataArray) {
        if (this.callForwardingStatusIconHandler != null) {
            this.callForwardingStatusIconHandler.updateCallForwardingStatusIcon(cFResponseDataArray);
        }
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        super.updateGlobalTelephoneStateProperty(n, iGlobalTelephoneStateStruct);
        this.telephoneState = iGlobalTelephoneStateStruct;
    }

    private void keyTypedCallDivertingCancelButton(int n) {
        this.log.log(-2137614336, "TelCallForwardingHandler#keyTypedCallDivertingCancelButton: called ");
        this.sentRequestType = 4;
        this.setCallDivertingStateModel(0, 0);
        CFRequestData cFRequestData = new CFRequestData(4, 0, "", 1, 0);
        this.requestCallForwarding(new CFRequestData[]{cFRequestData}, n);
        this.getButtonModel(-359332864).fireEvent(0);
    }

    private void keyTypedCallDivertingActivateButton(int n) {
        this.log.log(-2137614336, "TelCallForwardingHandler#keyTypedCallDivertingActivateButton: called ");
        this.sentRequestType = 3;
        SpellerModelApp spellerModelApp = this.getSpellerModel(-309001216);
        spellerModelApp.clear();
        spellerModelApp.setStatus(1);
        this.getButtonModel(-376110080).fireEvent(0);
    }

    private void keyTypedCallDivertingCheckButton(int n) {
        this.log.log(-2137614336, "TelCallForwardingHandler#keyTypedCallDivertingCheckButton: called ");
        this.sentRequestType = 2;
        this.setCallDivertingStateModel(0, 0);
        CFRequestData cFRequestData = new CFRequestData(2, 0, "", 1, 0);
        this.requestCallForwarding(new CFRequestData[]{cFRequestData}, n);
        this.getButtonModel(-325778432).fireEvent(0);
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelCallForwardingHandler#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    static /* synthetic */ LogChannel access$000(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        return abstractTelCallForwardingHandler.log;
    }

    static /* synthetic */ LogChannel access$100(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        return abstractTelCallForwardingHandler.log;
    }

    static /* synthetic */ void access$200(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        abstractTelCallForwardingHandler.resultFail();
    }

    static /* synthetic */ LogChannel access$300(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        return abstractTelCallForwardingHandler.log;
    }

    static /* synthetic */ int access$400(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        return abstractTelCallForwardingHandler.sentRequestType;
    }

    static /* synthetic */ LogChannel access$500(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        return abstractTelCallForwardingHandler.log;
    }

    static /* synthetic */ int access$602(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler, int n) {
        abstractTelCallForwardingHandler.recievedCFStatus = n;
        return abstractTelCallForwardingHandler.recievedCFStatus;
    }

    static /* synthetic */ String access$702(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler, String string) {
        abstractTelCallForwardingHandler.targetCFNumber = string;
        return abstractTelCallForwardingHandler.targetCFNumber;
    }

    static /* synthetic */ void access$800(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        abstractTelCallForwardingHandler.processResponseSetModels();
    }

    static /* synthetic */ void access$900(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler, CFResponseData[] cFResponseDataArray) {
        abstractTelCallForwardingHandler.updateCallForwardingStatusIcon(cFResponseDataArray);
    }
}

