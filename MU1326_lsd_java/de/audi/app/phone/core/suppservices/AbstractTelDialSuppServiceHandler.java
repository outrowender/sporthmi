/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.suppservices.ITelDialSuppServiceHandler;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Converter;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public abstract class AbstractTelDialSuppServiceHandler
extends AbstractPhoneComponent
implements ITelDialSuppServiceHandler {
    protected static final int CLIRSTATE_DO_NOT_SEND_OWN_NUMBER = 1;
    protected static final int CLIRSTATE_SEND_OWN_NUMBER = 2;
    protected static final int CLIRSTATE_NETWORK_DEPENDENT = 0;
    private static final int REQTYPE_UNKNOWN = -1;
    private static final int REQTYPE_CF_REGISTRATION = 0;
    private static final int REQTYPE_CF_DELETE = 1;
    private static final int REQTYPE_CF_DEACTIVATE = 2;
    private static final int REQTYPE_CF_ACTIVATE = 3;
    private static final int REQTYPE_CF_QUERY = 4;
    private static final int REQTYPE_CW_ACTIVATE = 5;
    private static final int REQTYPE_CW_DEACTIVATE = 6;
    private static final int REQTYPE_CW_QUERY = 7;
    private static final int REQTYPE_CLIR_DO_NOT_SEND_OWN_NUMBER = 8;
    private static final int REQTYPE_CLIR_SEND_OWN_NUMBER = 9;
    private static final int REQTYPE_CLIR_QUERY = 10;
    private static final int REQTYPE_SIMPIN_CHANGE = 11;
    protected static final String SS_CALLWAITING = "SS_CALLWAITING";
    protected static final String SS_CALLFORWARD = "SS_CALLFORWARD";
    protected static final String SS_CLIR = "SS_CLIR";
    protected static final String SS_SIMPINCHANGE = "SS_SIMPINCHANGE";
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

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().addDiagnosisComponent(new TelSuppServiceDiag());
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telMode = iGlobalTelephoneStateStruct.getTelMode();
    }

    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        if (n == 1 && serviceCodeTypeStruct != null && serviceCodeTypeStruct.getTelDialNumberType() != 0) {
            this.serviceCodeType = serviceCodeTypeStruct;
            if (this.telMode == 3) {
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#updateGlobalTelephoneStateProperty] Supplementary service request via HFP.");
                this.updateSuppServiceHFP();
                return;
            }
            int n2 = serviceCodeTypeStruct.getTelDialNumberType();
            if (n2 == 2) {
                this.processSSDRequested(serviceCodeTypeStruct);
            } else if (n2 == 1) {
                this.processUSSDRequested();
            } else {
                this.log.log(100000, "[AbstractTelSuppServiceHandler#updateGlobalTelephoneStateProperty] unknown dial number type %1", (long)n2);
            }
            this.updateSuppServiceRequested();
        }
    }

    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        if (suppServiceResponseStruct != null && this.telMode != 3 && this.serviceCodeType != null) {
            int n2 = this.serviceCodeType.getTelDialNumberType();
            this.log.log(10000000, "[AbstractTelDialSuppServiceHandler#responseDialNumber] result=%2, telSuppServResult=%1, dialNumberType=%3", (Object)suppServiceResponseStruct, (long)n, (long)n2);
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
        this.log.log(10000000, "[AbstractTelDialSuppServiceHandler#processUSSDResponse] suppServiceResponse=%1", (Object)suppServiceResponseStruct);
        if (suppServiceResponseStruct != null) {
            boolean bl;
            int n = suppServiceResponseStruct.getTelServiceState();
            boolean bl2 = bl = n == 0 || n == 3 || n == 1 || n == 2;
            if (bl) {
                this.getLabelModel(301152).setText(suppServiceResponseStruct.getTelResponseText());
            } else {
                this.getLabelModel(301152).setText("");
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
                this.log.log(100000, "[AbstractTelSuppServiceHandler#processSSDResponse] unhandled suppServiceResponse=%1", (Object)suppServiceResponseStruct);
            }
        }
    }

    private void processResultCFActivate(SuppServiceResponseStruct suppServiceResponseStruct) {
        CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
        this.log.log(1000000, "[AbstractTelDialSuppServiceHandler#processResultCFActivate] responseData=%1", (Object)Converter.array2String(cFResponseDataArray));
        this.responseCFActivate(AbstractTelDialSuppServiceHandler.isCallForwardingActive(cFResponseDataArray));
    }

    private void processResultCFDeactivate(SuppServiceResponseStruct suppServiceResponseStruct) {
        CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
        this.log.log(1000000, "[AbstractTelDialSuppServiceHandler#processResultCFDeactivate] responseData=%1", (Object)Converter.array2String(cFResponseDataArray));
        this.responseCFDeactivate(AbstractTelDialSuppServiceHandler.isCallForwardingActive(cFResponseDataArray));
    }

    private void processResultCFDelete(SuppServiceResponseStruct suppServiceResponseStruct) {
        CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
        this.log.log(1000000, "[AbstractTelDialSuppServiceHandler#processResultCFDelete] responseData=%1", (Object)Converter.array2String(cFResponseDataArray));
        this.responseCFDelete(AbstractTelDialSuppServiceHandler.isCallForwardingActive(cFResponseDataArray));
    }

    private void processResultCFQuery(SuppServiceResponseStruct suppServiceResponseStruct) {
        CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
        this.log.log(1000000, "[AbstractTelDialSuppServiceHandler#processResultCFQuery] responseData=%1", (Object)Converter.array2String(cFResponseDataArray));
        this.responseCFQuery(AbstractTelDialSuppServiceHandler.isCallForwardingActive(cFResponseDataArray));
    }

    private void processResultCFRegistration(SuppServiceResponseStruct suppServiceResponseStruct) {
        CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
        this.log.log(1000000, "[AbstractTelDialSuppServiceHandler#processResultCFRegistration] responseData=%1", (Object)Converter.array2String(cFResponseDataArray));
        this.responseCFRegistration(AbstractTelDialSuppServiceHandler.isCallForwardingActive(cFResponseDataArray));
    }

    private void processResultCWDeactivate(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCWStatus();
        this.log.log(1000000, "[AbstractTelSuppServiceHandler#processResultCWDeactivate] telCWStatus=%1", (long)n);
        this.responseCWDeactivate(n);
    }

    private void processResultCWActivate(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCWStatus();
        this.log.log(1000000, "[AbstractTelSuppServiceHandler#processResultCWActivate] telCWStatus=%1", (long)n);
        this.responseCWActivate(n);
    }

    private void processResultCWQuery(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCWStatus();
        this.log.log(1000000, "[AbstractTelSuppServiceHandler#processResultCWQuery] telCWStatus=%1", (long)n);
        this.responseCWQuery(n);
    }

    private void processResultSimPinChanged(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        int n2 = suppServiceResponseStruct.getTelCWStatus();
        this.log.log(1000000, "[AbstractTelSuppServiceHandler#processResultSimPinChanged] result=%1, telCWStatus=%2", (long)n, (long)n2);
        this.responseSimPinChanged(n == 0);
    }

    private void processResultCLIRSendOwnNumber(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCLIRState();
        this.log.log(1000000, "[AbstractTelSuppServiceHandler#processResultCLIRSendOwnNumber] telCLIRState=%1", (long)n);
        this.responseCLIRSendOwnNumber(n);
    }

    private void processResultCLIRDoNotSendOwnNumber(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCLIRState();
        this.log.log(1000000, "[AbstractTelSuppServiceHandler#processResultCLIRDoNotSendOwnNumber] telCLIRState=%1", (long)n);
        this.responseCLIRDoNotSendOwnNumber(n);
    }

    private void processResultCLIRQuery(SuppServiceResponseStruct suppServiceResponseStruct) {
        int n = suppServiceResponseStruct.getTelCLIRState();
        this.log.log(1000000, "[AbstractTelSuppServiceHandler#processResultCLIRQuery] telCLIRState=%1", (long)n);
        this.responseCLIRQuery(n);
    }

    private void processUSSDRequested() {
        this.log.log(1000000, "[AbstractTelSuppServiceHandler#updateGlobalTelephoneStateProperty] USSD detected");
    }

    private void processSSDRequested(ServiceCodeTypeStruct serviceCodeTypeStruct) {
        String string = serviceCodeTypeStruct.getTelServiceCode();
        int n = serviceCodeTypeStruct.getTelServiceCodeRequestType();
        this.log.log(1000000, "[AbstractTelSuppServiceHandler#processSSDRequested] %1 detected, telServiceCodeRequestType=%2", (Object)string, (long)n);
        if (SS_CALLFORWARD.equals(string)) {
            this.processCallForwardingRequested(n);
        } else if (SS_CALLWAITING.equals(string)) {
            this.processCallWaitingRequested(n);
        } else if (SS_CLIR.equals(string)) {
            this.processCallerIdRequested(n);
        } else if (SS_SIMPINCHANGE.equals(string)) {
            this.processSIMPINChangeRequested(n);
        } else {
            this.log.log(100000, "[AbstractTelSuppServiceHandler#processSSDRequested] unknown SSD type: %1", (Object)string);
        }
    }

    private void processSIMPINChangeRequested(int n) {
        this.request = 11;
        this.log.log(1000000, "AbstractTelDialSuppServiceHandler#processSIMPINChangeRequested(): sim PIN change request");
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
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallerIdRequested] do not send own number");
                break;
            }
            case 2: {
                this.request = 9;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallerIdRequested] send own number");
                break;
            }
            case 3: {
                this.request = 10;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallerIdRequested] query");
                break;
            }
            default: {
                this.request = -1;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallerIdRequested] unhandled service code type %1", (long)n);
            }
        }
    }

    private void processCallWaitingRequested(int n) {
        switch (n) {
            case 1: {
                this.request = 5;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallWaitingRequested] activation");
                break;
            }
            case 2: {
                this.request = 6;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallWaitingRequested] deactivation");
                break;
            }
            case 3: {
                this.request = 7;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallWaitingRequested] query");
                break;
            }
            default: {
                this.request = -1;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallWaitingRequested] unhandled service code type %1", (long)n);
            }
        }
    }

    private void processCallForwardingRequested(int n) {
        switch (n) {
            case 1: {
                this.request = 3;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] activation");
                break;
            }
            case 2: {
                this.request = 2;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] deactivation");
                break;
            }
            case 5: {
                this.request = 1;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] delete");
                break;
            }
            case 3: {
                this.request = 4;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] query");
                break;
            }
            case 4: {
                this.request = 0;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] registration");
                break;
            }
            default: {
                this.request = -1;
                this.log.log(1000000, "[AbstractTelSuppServiceHandler#processCallForwardingRequested] unhandled service code type %1", (long)n);
            }
        }
    }

    protected abstract void updateSuppServiceRequested();

    protected abstract void updateSuppServiceResponse(boolean var1);

    protected abstract void updateSuppServiceHFP();

    protected abstract void responseCWQuery(int var1);

    protected abstract void responseCWActivate(int var1);

    protected abstract void responseCWDeactivate(int var1);

    protected abstract void responseCLIRQuery(int var1);

    protected abstract void responseCLIRDoNotSendOwnNumber(int var1);

    protected abstract void responseCLIRSendOwnNumber(int var1);

    protected abstract void responseCFQuery(boolean var1);

    protected abstract void responseCFActivate(boolean var1);

    protected abstract void responseCFDeactivate(boolean var1);

    protected abstract void responseCFDelete(boolean var1);

    protected abstract void responseCFRegistration(boolean var1);

    protected abstract void responseUSSD(boolean var1);

    protected abstract void responseSimPinChanged(boolean var1);

    private class TelSuppServiceDiag
    implements IPhoneDiagComponent {
        private static final String CALLFORWARD_QUERY = "*#21#";
        private static final String CALLFORWARD_DEACTIVATE_ALL = "#002#";
        private static final String CALLFORWARD_DELETE_ALL = "##002#";
        private static final String CALLWAITING_ACTIVATE = "*43#";
        private static final String CALLWAITING_DEACTIVATE = "#43#";
        private static final String CALLWAITING_QUERY = "*#43#";
        private static final String CLIR_QUERY = "*#31#";
        private static final String CLIR_SEND_OWN_NUMBER = "#31#";
        private static final String CLIR_DO_NOT_SEND_OWN_NUMBER = "*31#";

        private TelSuppServiceDiag() {
        }

        private String getCFActivate(String string) {
            Buffer buffer = new Buffer();
            buffer.append("**21*");
            buffer.append(string);
            buffer.append("#");
            return buffer.toString();
        }

        public void cmdDialCLIRSendOwnNumber(String string) {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(new StringBuffer().append(CLIR_DO_NOT_SEND_OWN_NUMBER).append(string).toString(), 0);
        }

        public void cmdDialCLIRDoNotSendOwnNumber(String string) {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(new StringBuffer().append(CLIR_SEND_OWN_NUMBER).append(string).toString(), 0);
        }

        public void cmdDialCallFowardQuery() {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(CALLFORWARD_QUERY, 0);
        }

        public void cmdDialCallForwardRegistration(String string) {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(this.getCFActivate(string), 0);
        }

        public void cmdDialCallFowardDeactivate() {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(CALLFORWARD_DEACTIVATE_ALL, 0);
        }

        public void cmdDialCallFowardDelete() {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(CALLFORWARD_DELETE_ALL, 0);
        }

        public void cmdDialCallWaitingActivate() {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(CALLWAITING_ACTIVATE, 0);
        }

        public void cmdDialCallWaitingDeactivate() {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(CALLWAITING_DEACTIVATE, 0);
        }

        public void cmdDialCallWaitingQuery() {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(CALLWAITING_QUERY, 0);
        }

        public void cmdDialCLIRQuery() {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(CLIR_QUERY, 0);
        }

        public void cmdDialCLIRSendOwnNumber() {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(CLIR_SEND_OWN_NUMBER, 0);
        }

        public void cmdDialCLIRDoNotSendOwnNumber() {
            AbstractTelDialSuppServiceHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(CLIR_DO_NOT_SEND_OWN_NUMBER, 0);
        }
    }
}

