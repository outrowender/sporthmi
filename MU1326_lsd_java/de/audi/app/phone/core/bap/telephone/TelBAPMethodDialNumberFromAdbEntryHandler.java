/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.interapp.phone.TelAdbEntryStruct;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class TelBAPMethodDialNumberFromAdbEntryHandler
extends AbstractTel1BAPMethodHandler {
    private static final int DIAL_NUMBER_RESULT_SUCCESSFUL = 0;
    private static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL = 1;
    private static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NO_NETWORK = 5;
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

    TelBAPMethodDialNumberFromAdbEntryHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void dialNumberFromAdbEntry(String string, String string2, TelAdbEntryStruct telAdbEntryStruct) {
        if (telAdbEntryStruct == null) {
            this.log.log(10000, "TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry adbEntry is null");
            return;
        }
        this.log.log(10000000, "[TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry] telNumber=%1, name=%2", (Object)telAdbEntryStruct.getClNumber(), (Object)telAdbEntryStruct.getClName());
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        IEcallState iEcallState = iGlobalTelephoneStateStruct.getConnectedGatewayState();
        if (iEcallState != null && iEcallState.isCustomerCallNotAllowed()) {
            this.sendResultNotSuccessful();
        } else if (iGlobalTelephoneStateStruct.getCallState().isHasOutgoingCall()) {
            this.log.log(1000000, "[TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry] cannot dial because outgoing call already present!");
            this.sendResult(144);
        } else {
            this.log.log(1000000, "[TelBAPMethodDialNumberFromAdbEntryHandler#dialNumberFromAdbEntry] dialing %1", (Object)"");
            this.getApplication().getTelephoneDSIAccess().dialNumberFromDBEntry(telAdbEntryStruct.getClNumber(), telAdbEntryStruct.getAdbEntryID(), telAdbEntryStruct.getClName(), (short)telAdbEntryStruct.getAdbNumberType(), (short)0, telAdbEntryStruct.getAdbPictureID(), telAdbEntryStruct.getAdbPhoneDataIndex(), telAdbEntryStruct.getAdbPhoneDataCount(), 1, true, this);
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        this.log.log(10000000, "[TelBAPMethodDialNumberFromAdbEntryHandler#responseDialNumber] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        int n4 = TelBAPMethodDialNumberFromAdbEntryHandler.getDialNumberResult(this.getTelephoneState(), n);
        this.sendResult(n4);
    }

    private void sendResult(final int n) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodDialNumberFromAdbEntryHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodDialNumberFromAdbEntryHandler.this.log.log(1000000, "[TelBAPMethodDialNumberFromAdbEntryHandler#sendResult] sending result %1 to combi", (long)n);
                    combiBAPServicePhone.dialNumberFromAdbEntryResult(n);
                } else {
                    TelBAPMethodDialNumberFromAdbEntryHandler.this.log.log(100000, "[TelBAPMethodDialNumberFromAdbEntryHandler#sendResult] combi service is null !");
                }
            }
        });
    }
}

