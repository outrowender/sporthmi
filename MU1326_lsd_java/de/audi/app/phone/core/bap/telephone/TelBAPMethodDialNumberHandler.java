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

class TelBAPMethodDialNumberHandler
extends AbstractTel1BAPMethodHandler {
    private static final int DIAL_NUMBER_RESULT_SUCCESSFUL = 0;
    private static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL = 1;
    private static final int DIAL_NUMBER_RESULT_ABORT_SUCCESSFUL = 2;
    private static final int DIAL_NUMBER_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    private static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NUMBER_INVALID = 4;
    private static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NO_NETWORK = 5;
    private static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_CONFIRM_EMERGENCY_CALL = 10;
    private static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE = 12;

    private static int getDialNumberResult(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, int n) {
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

    TelBAPMethodDialNumberHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void dialNumber(String string, String string2) {
        this.log.log(10000000, "[TelBAPMethodDialNumberHandler#dialNumber] telNumber=%1, name=%2", (Object)string, (Object)string2);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodDialNumberHandler#dialNumber] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodDialNumberHandler#dialNumber] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        IEcallState iEcallState = iGlobalTelephoneStateStruct.getConnectedGatewayState();
        if (iEcallState != null && iEcallState.isCustomerCallNotAllowed()) {
            this.sendResultNotSuccessful();
        } else if (iGlobalTelephoneStateStruct.getCallState().isHasOutgoingCall()) {
            this.log.log(1000000, "[TelBAPMethodDialNumberHandler#dialNumber] cannot dial because outgoing call already present!");
            this.sendResult(144);
        } else {
            this.log.log(1000000, "[TelBAPMethodDialNumberHandler#dialNumber] dialing %1", (Object)string);
            this.getApplication().getTelephoneDSIAccess().dialNumber(string, 1, true, this);
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        this.log.log(10000000, "[TelBAPMethodDialNumberHandler#responseDialNumber] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        int n4 = TelBAPMethodDialNumberHandler.getDialNumberResult(this.getTelephoneState(), n);
        this.sendResult(n4);
    }

    private void sendResult(final int n) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodDialNumberHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodDialNumberHandler.this.log.log(1000000, "[TelBAPMethodDialNumberHandler#sendResult] sending result %1 to combi", (long)n);
                    combiBAPServicePhone.dialNumberResult(n);
                } else {
                    TelBAPMethodDialNumberHandler.this.log.log(100000, "[TelBAPMethodDialNumberHandler#sendResult] combi service is null !");
                }
            }
        });
    }
}

