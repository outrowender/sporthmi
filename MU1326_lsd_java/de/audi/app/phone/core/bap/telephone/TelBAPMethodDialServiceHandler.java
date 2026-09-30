/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.phone.IEcallState;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class TelBAPMethodDialServiceHandler
extends AbstractTel1BAPMethodHandler {
    private static final int DIAL_SERVICE_RESULT_SUCCESSFUL = 0;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL = 1;
    private static final int DIAL_SERVICE_RESULT_ABORT_SUCCESSFUL = 2;
    private static final int DIAL_SERVICE_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_SERVICE_NOT_AVAILABLE = 4;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NO_NETWORK = 5;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK = 6;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_MOBILE = 7;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_CONFIRM_EMERGENCY_CALL = 10;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE = 12;

    private static int getDialServiceResult(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 12: 
            case 13: {
                return 5;
            }
        }
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isAutomaticRedialActive() ? 12 : 1;
    }

    TelBAPMethodDialServiceHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void dialService(int n) {
        this.log.log(10000000, "[TelBAPMethodDialServiceHandler#dialService] serviceType=%1", (long)n);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodDialServiceHandler#dialService] telState is null --> NOP!");
            return;
        }
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodDialServiceHandler#dialService] combiService is null --> NOP!");
            return;
        }
        boolean bl = iGlobalTelephoneStateStruct.getServiceNumbers() != null;
        switch (n) {
            case 1: {
                String string;
                String string2 = string = bl ? iGlobalTelephoneStateStruct.getServiceNumbers().getInfonumber() : null;
                if (string != null && string.length() > 0) {
                    this.log.log(10000000, "[TelBAPMethodDialServiceHandler#dialService] invoking dial number for Info Call service type ");
                    this.dialNumber(string, null);
                    break;
                }
                this.log.log(1000000, "[TelBAPMethodDialServiceHandler#dialService] Info service Number null or empty, terminating dial");
                combiBAPServicePhone.dialServiceResult(1);
                return;
            }
            case 2: {
                String string;
                String string3 = string = bl ? iGlobalTelephoneStateStruct.getServiceNumbers().getBreakdownNumber() : null;
                if (string != null && string.length() > 0) {
                    this.log.log(10000000, "[TelBAPMethodDialServiceHandler#dialService] invoking dial number for breakdown Service Call service type ");
                    this.dialNumber(string, null);
                    break;
                }
                this.log.log(100000, "[TelBAPMethodDialServiceHandler#dialService] breakdown service Number null or empty, terminating dial");
                combiBAPServicePhone.dialServiceResult(1);
                return;
            }
            case 3: {
                this.log.log(100000, "[TelBAPMethodDialServiceHandler#dialService] No handling for SERVICE_TYPE_EMERGENCY_CALL");
                combiBAPServicePhone.dialServiceResult(1);
                break;
            }
            case 0: {
                if (iGlobalTelephoneStateStruct.isMailboxNumberAvailable()) {
                    String string = iGlobalTelephoneStateStruct.getMailboxNumber();
                    this.log.log(10000000, "[TelBAPMethodDialServiceHandler#dialService] dialing mailbox %1", (Object)string);
                    this.dialNumber(string, null);
                    break;
                }
                this.log.log(100000, "[TelBAPMethodDialServiceHandler#dialService] Mailbox not available, returning DIAL_SERVICE_RESULT_NOT_SUCCESSFUL");
                combiBAPServicePhone.dialServiceResult(1);
                break;
            }
            default: {
                this.log.log(100000, "[TelBAPMethodDialServiceHandler#dialService] serviceType %1 unknown", (long)n);
            }
        }
    }

    private void dialNumber(String string, String string2) {
        this.log.log(10000000, "[TelBAPMethodDialServiceHandler#dialNumber] telNumber=%1, name=%2", (Object)string, (Object)string2);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodDialServiceHandler#dialNumber] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodDialServiceHandler#dialNumber] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        IEcallState iEcallState = iGlobalTelephoneStateStruct.getConnectedGatewayState();
        if (iEcallState != null && iEcallState.isCustomerCallNotAllowed()) {
            this.sendResultNotSuccessful();
        } else if (iGlobalTelephoneStateStruct.getCallState().isHasOutgoingCall()) {
            this.log.log(1000000, "[TelBAPMethodDialServiceHandler#dialNumber] cannot dial because outgoing call already present!");
            this.sendResult(144);
        } else {
            this.log.log(1000000, "[TelBAPMethodDialServiceHandler#dialNumber] dialing %1", (Object)string);
            this.getApplication().getTelephoneDSIAccess().dialNumber(string, 1, true, this);
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        this.log.log(10000000, "[TelBAPMethodDialServiceHandler#responseDialNumber] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        int n4 = TelBAPMethodDialServiceHandler.getDialServiceResult(this.getTelephoneState(), n);
        this.sendResult(n4);
    }

    private void sendResult(final int n) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodDialServiceHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodDialServiceHandler.this.log.log(1000000, "[TelBAPMethodDialServiceHandler#sendResult] sending result %1 to combi", (long)n);
                    combiBAPServicePhone.dialServiceResult(n);
                } else {
                    TelBAPMethodDialServiceHandler.this.log.log(100000, "[TelBAPMethodDialServiceHandler#sendResult] combi service is null !");
                }
            }
        });
    }
}

