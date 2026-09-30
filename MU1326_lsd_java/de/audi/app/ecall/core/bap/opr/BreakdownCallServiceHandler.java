/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.bap.opr;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.EcallUtil;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.power.EcallPowerHandler;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;

public class BreakdownCallServiceHandler
extends AbstractEcallComponent
implements IGlobalEcallStateListener {
    private final EcallPowerHandler breakDownCallPowerHandler;
    private volatile boolean wasBreakDownCallPendingRequest;
    private final boolean[] IS_SERVICE_STATE_VALID_FOR_SREEN_SHOWING;
    private final boolean[] IS_PHONE_CALL_STATE_VALID_FOR_SREEN_SHOWING;
    private volatile boolean wasCustomerCallActive;
    private volatile boolean activatedEcallOnOprAutomatic;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState;

    BreakdownCallServiceHandler(IEcallApplication iEcallApplication) {
        this(iEcallApplication, new boolean[0], new boolean[0]);
    }

    public BreakdownCallServiceHandler(IEcallApplication iEcallApplication, boolean[] blArray, boolean[] blArray2) {
        super(iEcallApplication, "App.Ecall.OPR");
        this.IS_SERVICE_STATE_VALID_FOR_SREEN_SHOWING = blArray;
        this.IS_PHONE_CALL_STATE_VALID_FOR_SREEN_SHOWING = blArray2;
        this.breakDownCallPowerHandler = new EcallPowerHandler(iEcallApplication, 162, 163);
        this.getApplication().addDiagnosisComponent(new IEcallDiagnosisComponent(){

            public void cmdOPRActivatePopupSession(boolean bl) {
                BreakdownCallServiceHandler.this.getApplication().getOPRPopupHandler().activateEcallSession();
            }

            public void cmdOPRDisactivatePopupSession() {
                BreakdownCallServiceHandler.this.getApplication().getOPRPopupHandler().disactivateEcallSession();
            }

            public void cmdOPRShowScreen(int n) {
                BreakdownCallServiceHandler.this.showScreen(n);
            }
        });
    }

    public void init() {
        super.init();
        this.breakDownCallPowerHandler.init();
        this.getApplication().getEcallStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.breakDownCallPowerHandler.deinit();
        this.getApplication().getEcallStateManager().removeListener(this);
    }

    private void handleServiceCallStates(PhoneCall phoneCall) {
        int n = phoneCall.getState();
        if (EcallUtil.isStateValidForScreenActivation(this.IS_PHONE_CALL_STATE_VALID_FOR_SREEN_SHOWING, n)) {
            this.forceActivationWithouPendingRequestIfNeed();
        }
        switch (n) {
            case 3: {
                this.showScreen(7);
                break;
            }
            case 2: {
                this.showScreen(8);
                break;
            }
            case 4: {
                this.showScreen(9);
                break;
            }
            case 0: {
                this.log.log(10000000, "BreakdownCallServiceHandler#handleServiceCallStates(): unhandled serviceState IDLE");
                break;
            }
            default: {
                this.log.log(1000000, "BreakdownCallServiceHandler#handleServiceCallStates(): unhandled state (%1) for ServiceCall", (long)n);
            }
        }
    }

    public void updateGlobalEcallStateProperty(int n, IEcallStateStruct iEcallStateStruct) {
        if (n == 1 && iEcallStateStruct.getServiceCallKind() == 1) {
            this.handleForPhoneCall(iEcallStateStruct);
        } else if (n == 4) {
            this.onServiceRequests(iEcallStateStruct.getPendingServiceCalls());
        } else if (n == 3) {
            this.onServiceState(iEcallStateStruct);
        } else if (n == 2) {
            this.onCustomerCallStateChanged(iEcallStateStruct);
        }
    }

    private void onServiceRequests(PendingServiceRequests pendingServiceRequests) {
        if (pendingServiceRequests.isBreakdownServicePending() && pendingServiceRequests.isManualEmergencyCallPending()) {
            this.onOprAutomatic();
        } else if (pendingServiceRequests.isBreakdownServicePending()) {
            this.activateBreakdownSession(true);
        }
    }

    private void onOprAutomatic() {
        this.log.log(1000000, "BreakdownCallServiceHandler#onOprAutomatic(): called");
        this.activatedEcallOnOprAutomatic = true;
        this.getApplication().getOPRPopupHandler().activateEcallSession();
        this.showScreen(3);
        this.breakDownCallPowerHandler.activatePowerState();
    }

    private void onCustomerCallStateChanged(IEcallStateStruct iEcallStateStruct) {
        if (1 == iEcallStateStruct.getServiceCallKind() && BreakdownCallServiceHandler.isActive(iEcallStateStruct.getServiceState())) {
            if (this.wasCustomerCallActive && iEcallStateStruct.getCustomerTelState().isCallStateDisconnecting()) {
                this.log.log(10000000, "BreakdownCallServiceHandler#onCustomerCallStateChanged(): disconnecting");
                this.getApplication().getAudioConnectionHandler().scheduleMutePinConnectionRequest();
                this.getApplication().getAudioConnectionHandler().switchAudioSource();
            } else if (iEcallStateStruct.isActiveCustomerCallPresent()) {
                PhoneCall phoneCall;
                this.log.log(10000000, "BreakdownCallServiceHandler#onCustomerCallStateChanged(): terminating breakdown call");
                if (iEcallStateStruct.isCallActive(7) && (phoneCall = iEcallStateStruct.getCurrentPhoneCallByKind(7)) != null) {
                    this.getEcallBapServiceAdapter().endEmergencyCall(phoneCall);
                }
            }
        }
        this.wasCustomerCallActive = iEcallStateStruct.isActiveCustomerCallPresent();
    }

    private static boolean isActive(int n) {
        return 1 == n || 2 == n || 3 == n || 8 == n || 6 == n || 5 == n || 7 == n;
    }

    private void onServiceState(IEcallStateStruct iEcallStateStruct) {
        int n = iEcallStateStruct.getServiceCallKind();
        int n2 = iEcallStateStruct.getServiceState();
        this.log.log(10000000, "BreakdownCallServiceHandler#onServiceState(): start to handle service state serviceCallKind (%1), serviceState (%2)", (long)n, (long)n2);
        if (n == 1) {
            this.handleBreakdownServiceCallKind(iEcallStateStruct);
        } else if (n == 0) {
            this.disactivateBreakdownSession(iEcallStateStruct);
        } else {
            this.log.log(1000000, "BreakdownCallServiceHandler#onServiceState(): unhandled serviceCallKind=%1 (%2)", (Object)String.valueOf(n), (Object)String.valueOf(iEcallStateStruct));
        }
    }

    private void handleForPhoneCall(IEcallStateStruct iEcallStateStruct) {
        PhoneCall phoneCall = null;
        this.log.log(10000000, "BreakdownCallServiceHandler#handleForPhoneCall(): start to handle PhoneCall %1", phoneCall);
        phoneCall = iEcallStateStruct.getCurrentPhoneCallByKind(7);
        if (phoneCall != null) {
            this.handleServiceCallStates(phoneCall);
        } else {
            phoneCall = iEcallStateStruct.getCurrentPhoneCallByKind(0);
            if (phoneCall != null) {
                this.log.log(1000000, "BreakdownCallServiceHandler#handleForPhoneCall(): phoneCallKind UNKNOWN. ending Ecall session ");
                this.disactivateBreakdownSession(iEcallStateStruct);
            } else if (iEcallStateStruct.getPhoneCalls() != null && iEcallStateStruct.getPhoneCalls().length > 0) {
                phoneCall = iEcallStateStruct.getPhoneCalls()[0];
                this.log.log(1000000, "BreakdownCallServiceHandler#handleForPhoneCall(): unhandled kind %1", (long)phoneCall.getKind());
            }
        }
    }

    private void handleBreakdownServiceCallKind(IEcallStateStruct iEcallStateStruct) {
        int n = iEcallStateStruct.getServiceState();
        if (EcallUtil.isStateValidForScreenActivation(this.IS_SERVICE_STATE_VALID_FOR_SREEN_SHOWING, n)) {
            this.forceActivationWithouPendingRequestIfNeed();
        }
        switch (n) {
            case 1: {
                this.showScreen(4);
                break;
            }
            case 9: {
                this.showScreen(19);
                break;
            }
            case 5: {
                if (!iEcallStateStruct.isActiveCustomerCallPresent()) break;
                this.showScreen(6);
                break;
            }
            case 3: {
                this.showScreen(5);
                break;
            }
            case 12: 
            case 21: {
                this.showScreen(18);
                break;
            }
            case 14: {
                this.showScreen(19);
                break;
            }
            case 13: {
                this.getApplication().getOPRPopupHandler().showLicencePopup();
                break;
            }
            default: {
                this.log.log(10000000, "BreakdownCallServiceHandler#handleBreakdownServiceCallKind(): unhandled service call state for BREAKDOWN_SERVICE %1 ", (long)n);
                EcallUtil.logStructFieldForDbg(this.log, class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState == null ? (class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState = BreakdownCallServiceHandler.class$("de.audi.atip.interapp.bap.ecall.data.ServiceRequestState")) : class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState, n);
            }
        }
    }

    private void showScreen(int n) {
        this.getApplication().getOPRPopupHandler().showScreen(n);
    }

    private void forceActivationWithouPendingRequestIfNeed() {
        if (!this.wasBreakDownCallPendingRequest) {
            this.activateBreakdownSession(false);
        }
    }

    private void disactivateBreakdownSession(IEcallStateStruct iEcallStateStruct) {
        if (iEcallStateStruct.isUSMRequestPresent()) {
            this.log.log(1000000, "BreakdownCallServiceHandler#disactivateBreakdownSession(): automatic Mode is Active NOP");
            return;
        }
        if (this.activatedEcallOnOprAutomatic) {
            this.log.log(1000000, "BreakdownCallServiceHandler#disactivateBreakdownSession(): breakdown is activated onOprAutomatic -> disactivate");
        } else if (!this.wasBreakDownCallPendingRequest) {
            this.log.log(1000000, "BreakdownCallServiceHandler#disactivateBreakdownSession(): breakdown is INACTIVE NOP");
            return;
        }
        this.log.log(10000000, "BreakdownCallServiceHandler#disactivateBreakdownSession(): called");
        this.activatedEcallOnOprAutomatic = false;
        this.wasBreakDownCallPendingRequest = false;
        this.getApplication().getOPRPopupHandler().disactivateEcallSession();
        this.getApplication().getSDSHandler().enablePTT();
        this.breakDownCallPowerHandler.disactivatePowerState();
    }

    private void activateBreakdownSession(boolean bl) {
        this.log.log(10000000, "BreakdownCallServiceHandler#activateBreakdownSession(): acceptRoaService %1, ", bl);
        this.wasBreakDownCallPendingRequest = true;
        this.getApplication().getSDSHandler().disablePTT();
        if (bl) {
            this.getEcallBapServiceAdapter().acceptBreakdownCall();
        }
        this.activatedEcallOnOprAutomatic = false;
        this.getApplication().getOPRPopupHandler().activateEcallSession();
        this.breakDownCallPowerHandler.activatePowerState();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

