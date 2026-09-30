/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.calllist.ConferenceCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodJoinCallsHandler
extends AbstractTel1BAPMethodHandler {
    private final int MAX_CONFERENCE_MEMBERS;

    TelBAPMethodJoinCallsHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
        this.MAX_CONFERENCE_MEMBERS = 5;
    }

    void joinCalls() {
        boolean bl;
        this.log.log(10000000, "[TelBAPMethodJoinCallsHandler#joinCalls]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiBapServicePhone();
        if (combiBAPServicePhone == null) {
            this.log.log(100000, "[TelBAPMethodJoinCallsHandler#joinCalls] combiService is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(100000, "[TelBAPMethodJoinCallsHandler#joinCalls] telState is null --> NOP!");
            this.sendResultNotSuccessful();
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        CallStateStruct callStateStruct = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        ConferenceCall conferenceCall = callStateStruct != null ? callStateStruct.getConferenceCall() : null;
        boolean bl2 = bl = conferenceCall != null && conferenceCall.getMembers() != null && conferenceCall.getMembers().length == 5;
        if (bl) {
            this.log.log(1000000, "[TelBAPMethodJoinCallsHandler#joinCalls] maximung conference members, returning result 0x07");
            this.sendResult(7);
        } else if (callStateStruct.isMultipartyActive()) {
            this.log.log(1000000, "[TelBAPMethodJoinCallsHandler#joinCalls invoking joinCalls)");
            this.getApplication().getTelephoneDSIAccess().joinCallsToConference(1, true, this);
        } else {
            this.log.log(1000000, "[TelBAPMethodJoinCallsHandler#joinCalls] multy party not active, no join possible");
            this.sendResult(1);
        }
    }

    private void sendResultNotSuccessful() {
        this.sendResult(1);
    }

    public void responseJoinCalls(int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.sendResult(n3);
    }

    private void sendResult(final int n) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodJoinCallsHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodJoinCallsHandler.this.log.log(1000000, "[TelBAPMethodJoinCallsHandler#sendResult] returning result %1 to combi.", (long)n);
                    combiBAPServicePhone.joinCallsResult(n);
                } else {
                    TelBAPMethodJoinCallsHandler.this.log.log(100000, "[TelBAPMethodJoinCallsHandler#sendResult] CombiService is null!");
                }
            }
        });
    }
}

