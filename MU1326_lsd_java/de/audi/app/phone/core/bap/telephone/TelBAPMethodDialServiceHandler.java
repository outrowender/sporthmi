/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodDialServiceHandler$1;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class TelBAPMethodDialServiceHandler
extends AbstractTel1BAPMethodHandler {
    private static final int DIAL_SERVICE_RESULT_SUCCESSFUL;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL;
    private static final int DIAL_SERVICE_RESULT_ABORT_SUCCESSFUL;
    private static final int DIAL_SERVICE_RESULT_ABORT_NOT_SUCCESSFUL;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_SERVICE_NOT_AVAILABLE;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NO_NETWORK;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_MOBILE;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_CONFIRM_EMERGENCY_CALL;
    private static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE;

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
        this.log.log(-2137614336, "[TelBAPMethodDialServiceHandler#dialService] serviceType=%1", (long)n);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[TelBAPMethodDialServiceHandler#dialService] telState is null --> NOP!");
            return;
        }
        if (combiBAPServicePhone == null) {
            this.log.log(-1601830656, "[TelBAPMethodDialServiceHandler#dialService] combiService is null --> NOP!");
            return;
        }
        boolean bl = iGlobalTelephoneStateStruct.getServiceNumbers() != null;
        switch (n) {
            case 1: {
                String string;
                String string2 = string = bl ? iGlobalTelephoneStateStruct.getServiceNumbers().getInfonumber() : null;
                if (string != null && string.length() > 0) {
                    this.log.log(-2137614336, "[TelBAPMethodDialServiceHandler#dialService] invoking dial number for Info Call service type ");
                    this.dialNumber(string, null);
                    break;
                }
                this.log.log(1078071040, "[TelBAPMethodDialServiceHandler#dialService] Info service Number null or empty, terminating dial");
                combiBAPServicePhone.dialServiceResult(1);
                return;
            }
            case 2: {
                String string;
                String string3 = string = bl ? iGlobalTelephoneStateStruct.getServiceNumbers().getBreakdownNumber() : null;
                if (string != null && string.length() > 0) {
                    this.log.log(-2137614336, "[TelBAPMethodDialServiceHandler#dialService] invoking dial number for breakdown Service Call service type ");
                    this.dialNumber(string, null);
                    break;
                }
                this.log.log(-1601830656, "[TelBAPMethodDialServiceHandler#dialService] breakdown service Number null or empty, terminating dial");
                combiBAPServicePhone.dialServiceResult(1);
                return;
            }
            case 3: {
                this.log.log(-1601830656, "[TelBAPMethodDialServiceHandler#dialService] No handling for SERVICE_TYPE_EMERGENCY_CALL");
                combiBAPServicePhone.dialServiceResult(1);
                break;
            }
            case 0: {
                if (iGlobalTelephoneStateStruct.isMailboxNumberAvailable()) {
                    String string = iGlobalTelephoneStateStruct.getMailboxNumber();
                    this.log.log(-2137614336, "[TelBAPMethodDialServiceHandler#dialService] dialing mailbox %1", (Object)string);
                    this.dialNumber(string, null);
                    break;
                }
                this.log.log(-1601830656, "[TelBAPMethodDialServiceHandler#dialService] Mailbox not available, returning DIAL_SERVICE_RESULT_NOT_SUCCESSFUL");
                combiBAPServicePhone.dialServiceResult(1);
                break;
            }
            default: {
                this.log.log(-1601830656, "[TelBAPMethodDialServiceHandler#dialService] serviceType %1 unknown", (long)n);
            }
        }
    }

    private void dialNumber(String string, String string2) {
        this.log.log(-2137614336, "[TelBAPMethodDialServiceHandler#dialNumber] telNumber=%1, name=%2", (Object)string, (Object)string2);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(-1601830656, "[TelBAPMethodDialServiceHandler#dialNumber] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[TelBAPMethodDialServiceHandler#dialNumber] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        IEcallState iEcallState = iGlobalTelephoneStateStruct.getConnectedGatewayState();
        if (iEcallState != null && iEcallState.isCustomerCallNotAllowed()) {
            this.sendResultNotSuccessful();
        } else if (iGlobalTelephoneStateStruct.getCallState().isHasOutgoingCall()) {
            this.log.log(1078071040, "[TelBAPMethodDialServiceHandler#dialNumber] cannot dial because outgoing call already present!");
            this.sendResult(144);
        } else {
            this.log.log(1078071040, "[TelBAPMethodDialServiceHandler#dialNumber] dialing %1", (Object)string);
            this.getApplication().getTelephoneDSIAccess().dialNumber(string, 1, true, this);
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        this.log.log(-2137614336, "[TelBAPMethodDialServiceHandler#responseDialNumber] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        int n4 = TelBAPMethodDialServiceHandler.getDialServiceResult(this.getTelephoneState(), n);
        this.sendResult(n4);
    }

    private void sendResult(int n) {
        this.enqueueResultNotification(new TelBAPMethodDialServiceHandler$1(this, n));
    }

    static /* synthetic */ LogChannel access$000(TelBAPMethodDialServiceHandler telBAPMethodDialServiceHandler) {
        return telBAPMethodDialServiceHandler.log;
    }

    static /* synthetic */ LogChannel access$100(TelBAPMethodDialServiceHandler telBAPMethodDialServiceHandler) {
        return telBAPMethodDialServiceHandler.log;
    }
}

