/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.suppservices.AbstractTelDialSuppServiceHandler$TelSuppServiceDiag;
import de.audi.app.phone.core.suppservices.ITelDialSuppServiceHandler;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public abstract class AbstractTelDialSuppServiceHandler
extends AbstractPhoneComponent
implements ITelDialSuppServiceHandler {
    protected static final int CLIRSTATE_DO_NOT_SEND_OWN_NUMBER;
    protected static final int CLIRSTATE_SEND_OWN_NUMBER;
    protected static final int CLIRSTATE_NETWORK_DEPENDENT;
    private static final int REQTYPE_UNKNOWN;
    private static final int REQTYPE_CF_REGISTRATION;
    private static final int REQTYPE_CF_DELETE;
    private static final int REQTYPE_CF_DEACTIVATE;
    private static final int REQTYPE_CF_ACTIVATE;
    private static final int REQTYPE_CF_QUERY;
    private static final int REQTYPE_CW_ACTIVATE;
    private static final int REQTYPE_CW_DEACTIVATE;
    private static final int REQTYPE_CW_QUERY;
    private static final int REQTYPE_CLIR_DO_NOT_SEND_OWN_NUMBER;
    private static final int REQTYPE_CLIR_SEND_OWN_NUMBER;
    private static final int REQTYPE_CLIR_QUERY;
    private static final int REQTYPE_SIMPIN_CHANGE;
    protected static final String SS_CALLWAITING;
    protected static final String SS_CALLFORWARD;
    protected static final String SS_CLIR;
    protected static final String SS_SIMPINCHANGE;
    private volatile int telMode;
    private volatile ServiceCodeTypeStruct serviceCodeType;
    private int request;

    private static boolean isCallForwardingActive(CFResponseData[] cFResponseDataArray) {
        if (cFResponseDataArray != null && cFResponseDataArray.length > 0) {
            for (int i2 = 0; i2 < cFResponseDataArray.length; ++i2) {
                CFResponseData cFResponseData = cFResponseDataArray[i2];
                if (cFResponseData == null || cFResponseData.getTelCFStatus() != 1) continue;
                return true;
            }
        }
        return false;
    }

    public AbstractTelDialSuppServiceHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().addDiagnosisComponent(new AbstractTelDialSuppServiceHandler$TelSuppServiceDiag(this, null));
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telMode = iGlobalTelephoneStateStruct.getTelMode();
    }

    @Override
    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        if (n == 1 && serviceCodeTypeStruct != null && serviceCodeTypeStruct.getTelDialNumberType() != 0) {
            this.serviceCodeType = serviceCodeTypeStruct;
            if (this.telMode == 3) {
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#updateGlobalTelephoneStateProperty] Supplementary service request via HFP.");
                this.updateSuppServiceHFP();
                return;
            }
            int n2 = serviceCodeTypeStruct.getTelDialNumberType();
            if (n2 == 2) {
                this.processSSDRequested(serviceCodeTypeStruct);
            } else if (n2 == 1) {
                this.processUSSDRequested();
            } else {
                this.log.log(-1601830656, "[AbstractTelSuppServiceHandler#updateGlobalTelephoneStateProperty] unknown dial number type %1", (long)n2);
            }
            this.updateSuppServiceRequested();
        }
    }

    @Override
    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        if (suppServiceResponseStruct != null && this.telMode != 3 && this.serviceCodeType != null) {
            int n2 = this.serviceCodeType.getTelDialNumberType();
            this.log.log(-2137614336, "[AbstractTelDialSuppServiceHandler#responseDialNumber] result=%2, telSuppServResult=%1, dialNumberType=%3", (Object)suppServiceResponseStruct, (long)n, (long)n2);
            if (n == 0) {
                if (n2 == 2) {
                    this.processSSDResponse(n, suppServiceResponseStruct);
                } else if (n2 == 1) {
                    this.processUSSDResponse(suppServiceResponseStruct);
                }
            }
            this.serviceCodeType = null;
        }
        this.updateSuppServiceResponse(n == 0);
    }

    private void processUSSDResponse(SuppServiceResponseStruct suppServiceResponseStruct) {
        this.log.log(-2137614336, "[AbstractTelDialSuppServiceHandler#processUSSDResponse] suppServiceResponse=%1", (Object)suppServiceResponseStruct);
        if (suppServiceResponseStruct != null) {
            boolean bl;
            int n = suppServiceResponseStruct.getTelServiceState();
            boolean bl2 = bl = n == 0 || n == 3 || n == 1 || n == 2;
            if (bl) {
                this.getLabelModel(1620575232).setText(suppServiceResponseStruct.getTelResponseText());
            } else {
                this.getLabelModel(1620575232).setText("");
            }
            this.responseUSSD(bl);
        }
    }

    private void processSSDResponse(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        switch (this.request) {
            case 3: {
                this.processResultCFActivate(suppServiceResponseStruct);
                break;
            }
            case 2: {
                this.processResultCFDeactivate(suppServiceResponseStruct);
                break;
            }
            case 1: {
                this.processResultCFDelete(suppServiceResponseStruct);
                break;
            }
            case 4: {
                this.processResultCFQuery(suppServiceResponseStruct);
                break;
            }
            case 0: {
                this.processResultCFRegistration(suppServiceResponseStruct);
                break;
            }
            case 8: {
                this.processResultCLIRDoNotSendOwnNumber(suppServiceResponseStruct);
                break;
            }
            case 9: {
                this.processResultCLIRSendOwnNumber(suppServiceResponseStruct);
                break;
            }
            case 10: {
                this.processResultCLIRQuery(suppServiceResponseStruct);
                break;
            }
            case 5: {
                this.processResultCWActivate(suppServiceResponseStruct);
                break;
            }
            case 6: {
                this.processResultCWDeactivate(suppServiceResponseStruct);
                break;
            }
            case 7: {
                this.processResultCWQuery(suppServiceResponseStruct);
                break;
            }
            case 11: {
                this.processResultSimPinChanged(n, suppServiceResponseStruct);
                break;
            }
            default: {
                this.log.log(-1601830656, "[AbstractTelSuppServiceHandler#processSSDResponse] unhandled suppServiceResponse=%1", (Object)suppServiceResponseStruct);
            }
        }
    }

    private void processResultCFActivate(SuppServiceResponseStruct suppServiceResponseStruct) {
        CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
        this.log.log(1078071040, "[AbstractTelDialSuppServiceHandler#processResultCFActivate] responseData=%1", (Object)Converter.array2String(cFResponseDataArray));
        this.responseCFActivate(AbstractTelDialSuppServiceHandler.isCallForwardingActive(cFResponseDataArray));
    }

    private void processResultCFDeactivate(SuppServiceResponseStruct suppServiceResponseStruct) {
        CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
        this.log.log(1078071040, "[AbstractTelDialSuppServiceHandler#processResultCFDeactivate] responseData=%1", (Object)Converter.array2String(cFResponseDataArray));
        this.responseCFDeactivate(AbstractTelDialSuppServiceHandler.isCallForwardingActive(cFResponseDataArray));
    }

    private void processResultCFDelete(SuppServiceResponseStruct suppServiceResponseStruct) {
        CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
        this.log.log(1078071040, "[AbstractTelDialSuppServiceHandler#processResultCFDelete] responseData=%1", (Object)Converter.array2String(cFResponseDataArray));
        this.responseCFDelete(AbstractTelDialSuppServiceHandler.isCallForwardingActive(cFResponseDataArray));
    }

    private void processResultCFQuery(SuppServiceResponseStruct suppServiceResponseStruct) {
        CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
        this.log.log(1078071040, "[AbstractTelDialSuppServiceHandler#processResultCFQuery] responseData=%1", (Object)Converter.array2String(cFResponseDataArray));
        this.responseCFQuery(AbstractTelDialSuppServiceHandler.isCallForwardingActive(cFResponseDataArray));
    }

    private void processResultCFRegistration(SuppServiceResponseStruct suppServiceResponseStruct) {
        CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
        this.log.log(1078071040, "[AbstractTelDialSuppServiceHandler#processResultCFRegistration] responseData=%1", (Object)Converter.array2String(cFResponseDataArray));
        this.responseCFRegistration(AbstractTelDialSuppServiceHandler.isCallForwardingActive(cFResponseDataArray));
    }

    private void processResultCWDeactivate(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCWStatus();
        this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processResultCWDeactivate] telCWStatus=%1", (long)n);
        this.responseCWDeactivate(n);
    }

    private void processResultCWActivate(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCWStatus();
        this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processResultCWActivate] telCWStatus=%1", (long)n);
        this.responseCWActivate(n);
    }

    private void processResultCWQuery(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCWStatus();
        this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processResultCWQuery] telCWStatus=%1", (long)n);
        this.responseCWQuery(n);
    }

    private void processResultSimPinChanged(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        int n2 = suppServiceResponseStruct.getTelCWStatus();
        this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processResultSimPinChanged] result=%1, telCWStatus=%2", (long)n, (long)n2);
        this.responseSimPinChanged(n == 0);
    }

    private void processResultCLIRSendOwnNumber(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCLIRState();
        this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processResultCLIRSendOwnNumber] telCLIRState=%1", (long)n);
        this.responseCLIRSendOwnNumber(n);
    }

    private void processResultCLIRDoNotSendOwnNumber(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCLIRState();
        this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processResultCLIRDoNotSendOwnNumber] telCLIRState=%1", (long)n);
        this.responseCLIRDoNotSendOwnNumber(n);
    }

    private void processResultCLIRQuery(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCLIRState();
        this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processResultCLIRQuery] telCLIRState=%1", (long)n);
        this.responseCLIRQuery(n);
    }

    private void processUSSDRequested() {
        this.log.log(1078071040, "[AbstractTelSuppServiceHandler#updateGlobalTelephoneStateProperty] USSD detected");
    }

    private void processSSDRequested(ServiceCodeTypeStruct serviceCodeTypeStruct) {
        String string = serviceCodeTypeStruct.getTelServiceCode();
        int n = serviceCodeTypeStruct.getTelServiceCodeRequestType();
        this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processSSDRequested] %1 detected, telServiceCodeRequestType=%2", (Object)string, (long)n);
        if ("SS_CALLFORWARD".equals(string)) {
            this.processCallForwardingRequested(n);
        } else if ("SS_CALLWAITING".equals(string)) {
            this.processCallWaitingRequested(n);
        } else if ("SS_CLIR".equals(string)) {
            this.processCallerIdRequested(n);
        } else if ("SS_SIMPINCHANGE".equals(string)) {
            this.processSIMPINChangeRequested(n);
        } else {
            this.log.log(-1601830656, "[AbstractTelSuppServiceHandler#processSSDRequested] unknown SSD type: %1", (Object)string);
        }
    }

    private void processSIMPINChangeRequested(int n) {
        this.request = 11;
        this.log.log(1078071040, "AbstractTelDialSuppServiceHandler#processSIMPINChangeRequested(): sim PIN change request");
        switch (n) {
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 5: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 0: {
                break;
            }
        }
    }

    private void processCallerIdRequested(int n) {
        switch (n) {
            case 1: {
                this.request = 8;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallerIdRequested] do not send own number");
                break;
            }
            case 2: {
                this.request = 9;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallerIdRequested] send own number");
                break;
            }
            case 3: {
                this.request = 10;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallerIdRequested] query");
                break;
            }
            default: {
                this.request = -1;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallerIdRequested] unhandled service code type %1", (long)n);
            }
        }
    }

    private void processCallWaitingRequested(int n) {
        switch (n) {
            case 1: {
                this.request = 5;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallWaitingRequested] activation");
                break;
            }
            case 2: {
                this.request = 6;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallWaitingRequested] deactivation");
                break;
            }
            case 3: {
                this.request = 7;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallWaitingRequested] query");
                break;
            }
            default: {
                this.request = -1;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallWaitingRequested] unhandled service code type %1", (long)n);
            }
        }
    }

    private void processCallForwardingRequested(int n) {
        switch (n) {
            case 1: {
                this.request = 3;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] activation");
                break;
            }
            case 2: {
                this.request = 2;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] deactivation");
                break;
            }
            case 5: {
                this.request = 1;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] delete");
                break;
            }
            case 3: {
                this.request = 4;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] query");
                break;
            }
            case 4: {
                this.request = 0;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] registration");
                break;
            }
            default: {
                this.request = -1;
                this.log.log(1078071040, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] unhandled service code type %1", (long)n);
            }
        }
    }

    protected abstract void updateSuppServiceRequested() {
    }

    protected abstract void updateSuppServiceResponse(boolean bl) {
    }

    protected abstract void updateSuppServiceHFP() {
    }

    protected abstract void responseCWQuery(int n) {
    }

    protected abstract void responseCWActivate(int n) {
    }

    protected abstract void responseCWDeactivate(int n) {
    }

    protected abstract void responseCLIRQuery(int n) {
    }

    protected abstract void responseCLIRDoNotSendOwnNumber(int n) {
    }

    protected abstract void responseCLIRSendOwnNumber(int n) {
    }

    protected abstract void responseCFQuery(boolean bl) {
    }

    protected abstract void responseCFActivate(boolean bl) {
    }

    protected abstract void responseCFDeactivate(boolean bl) {
    }

    protected abstract void responseCFDelete(boolean bl) {
    }

    protected abstract void responseCFRegistration(boolean bl) {
    }

    protected abstract void responseUSSD(boolean bl) {
    }

    protected abstract void responseSimPinChanged(boolean bl) {
    }

    static /* synthetic */ ITelApplication access$100(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$200(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$300(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$400(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$500(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$600(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$700(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$800(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$900(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$1000(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$1100(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$1200(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        return abstractTelDialSuppServiceHandler.getApplication();
    }
}

