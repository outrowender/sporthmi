/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.bap.sos;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.EcallUtil;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.IEcallComponent;
import de.audi.app.ecall.core.bap.sos.EcallBluetoothHandler;
import de.audi.app.ecall.core.bap.sos.ScreenContext;
import de.audi.app.ecall.core.power.EcallPowerHandler;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;

public class EmergencyCallServiceHandler
extends AbstractEcallComponent
implements IGlobalEcallStateListener {
    private final EcallPowerHandler ecallPowerHandling;
    private final EcallBluetoothHandler ecallBluetoothHandler;
    private volatile boolean wasEmergencyCallPendingRequest;
    private final boolean[] IS_SERVICE_STATE_VALID_FOR_SREEN_SHOWING;
    private final ScreenHandler mecScreenHandler;
    private final ScreenHandler acnScreenHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState;

    EmergencyCallServiceHandler(IEcallApplication iEcallApplication) {
        this(iEcallApplication, new boolean[0]);
    }

    public EmergencyCallServiceHandler(IEcallApplication iEcallApplication, boolean[] blArray) {
        super(iEcallApplication, "App.Ecall.SOS");
        this.IS_SERVICE_STATE_VALID_FOR_SREEN_SHOWING = blArray;
        this.ecallPowerHandling = new EcallPowerHandler(iEcallApplication, 164, 165);
        this.ecallBluetoothHandler = new EcallBluetoothHandler(iEcallApplication);
        ScreenContext.Builder builder = new ScreenContext.Builder();
        builder.setConnectingScreen(25);
        builder.setConnectedScreen(27);
        builder.setCallBackIncomingScreen(14);
        builder.setSendingDataScreen(28);
        builder.setAccomplishedScreen(29);
        builder.setFailedScreen(31);
        builder.setCanceledScreen(26);
        builder.setRedialScreen(30);
        this.mecScreenHandler = new ScreenHandler(builder.build());
        ScreenContext.Builder builder2 = new ScreenContext.Builder();
        builder2.setConnectingScreen(11);
        builder2.setConnectedScreen(12);
        builder2.setCallBackIncomingScreen(14);
        builder2.setSendingDataScreen(13);
        builder2.setAccomplishedScreen(20);
        builder2.setFailedScreen(21);
        builder2.setCanceledScreen(22);
        builder2.setRedialScreen(32);
        this.acnScreenHandler = new ScreenHandler(builder2.build());
        this.getApplication().addDiagnosisComponent(new IEcallDiagnosisComponent(){

            public void cmdSOSActivatePopupSession() {
                EmergencyCallServiceHandler.this.activateEcall();
            }

            public void cmdSOSDisactivatePopupSession() {
                EmergencyCallServiceHandler.this.disactivateEcall();
            }

            public void cmdSOSShowScreen(int n) {
                EmergencyCallServiceHandler.this.showScreen(n);
            }
        });
    }

    protected IEcallComponent[] getSubComponents() {
        return new IEcallComponent[]{this.ecallPowerHandling, this.ecallBluetoothHandler};
    }

    public void init() {
        super.init();
        this.getApplication().getEcallStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getEcallStateManager().removeListener(this);
    }

    private void activateEcall() {
        this.log.log(1000000, "EmergencyCallServiceHandler#activateEcall(): called");
        this.wasEmergencyCallPendingRequest = true;
        this.ecallPowerHandling.activatePowerState();
        this.getApplication().getSDSHandler().disablePTT();
        this.getApplication().getSOSPopupHandler().activateEcallSession();
        this.getApplication().getTelServiceEcallHandler().hangupAllCalls();
        this.ecallBluetoothHandler.switchOffBluetooth();
    }

    private void disactivateEcall() {
        if (!this.wasEmergencyCallPendingRequest) {
            this.log.log(1000000, "EmergencyCallServiceHandler#disactivateEcall(): emergency call is inactive. NOP");
            return;
        }
        this.log.log(1000000, "EmergencyCallServiceHandler#disactivateEcall(): called");
        this.wasEmergencyCallPendingRequest = false;
        this.ecallBluetoothHandler.switchOnBluetooth();
        this.getApplication().getSDSHandler().enablePTT();
        this.getApplication().getSOSPopupHandler().disactivateEcallSession();
        this.ecallPowerHandling.disactivatePowerState();
    }

    public void updateGlobalEcallStateProperty(int n, IEcallStateStruct iEcallStateStruct) {
        if (n == 1) {
            PhoneCall phoneCall = iEcallStateStruct.getCurrentHighPriorityPhoneCall();
            if (phoneCall != null) {
                int n2 = phoneCall.getKind();
                if (n2 == 9 || n2 == 4) {
                    this.mecScreenHandler.onCallServiceStateChanged(iEcallStateStruct);
                } else if (n2 == 8) {
                    this.acnScreenHandler.onCallServiceStateChanged(iEcallStateStruct);
                }
            }
        } else if (n == 4) {
            PendingServiceRequests pendingServiceRequests = iEcallStateStruct.getPendingServiceCalls();
            if (pendingServiceRequests.isManualEmergencyCallPending() && !pendingServiceRequests.isBreakdownServicePending()) {
                this.activateEcall();
                this.showScreen(24);
            }
        } else if (n == 3) {
            this.onServiceState(iEcallStateStruct);
        } else if (n == 2 && this.isEcallType(iEcallStateStruct) && iEcallStateStruct.getCustomerTelState() != null && iEcallStateStruct.getCustomerTelState().isCallStateDisconnecting()) {
            this.getApplication().getAudioConnectionHandler().scheduleMutePinConnectionRequest();
        }
    }

    private boolean isEcallType(IEcallStateStruct iEcallStateStruct) {
        return 5 == iEcallStateStruct.getServiceCallKind() || 2 == iEcallStateStruct.getServiceCallKind();
    }

    private void onServiceState(IEcallStateStruct iEcallStateStruct) {
        int n = iEcallStateStruct.getServiceCallKind();
        int n2 = iEcallStateStruct.getServiceState();
        this.log.log(10000000, "EmergencyCallServiceHandler#onServiceState(): start to handle service state serviceCallKind (%1), serviceState (%2)", (Object)String.valueOf(n), (Object)String.valueOf(n2));
        if (n == 5) {
            this.mecScreenHandler.onCallServiceStateChanged(iEcallStateStruct);
            this.mecScreenHandler.handleServiceState(n2);
            if (n2 == 11) {
                this.showScreen(33);
            }
        } else if (n == 4) {
            if (n2 == 5) {
                this.activateEcall();
            }
            this.acnScreenHandler.onCallServiceStateChanged(iEcallStateStruct);
            this.acnScreenHandler.handleServiceState(n2);
        } else if (n == 0 && n2 == 0) {
            this.disactivateEcall();
        } else {
            this.log.log(1000000, "EmergencyCallServiceHandler#onServiceState(): unhandled serviceCallKind=%1 (%2)", (Object)String.valueOf(n), (Object)String.valueOf(iEcallStateStruct));
        }
    }

    private void showScreen(int n) {
        this.getApplication().getSOSPopupHandler().showScreen(n);
    }

    private void showEmergencyConnectScreen(int n) {
        this.forceActivationWithouPendingRequestIfNeed();
        this.showScreen(n);
    }

    void setWasEmergencyCallPendingRequest(boolean bl) {
        this.wasEmergencyCallPendingRequest = bl;
    }

    private void forceActivationWithouPendingRequestIfNeed() {
        if (!this.wasEmergencyCallPendingRequest) {
            this.activateEcall();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class ScreenHandler {
        private final ScreenContext screenContext;

        public ScreenHandler(ScreenContext screenContext) {
            this.screenContext = screenContext;
        }

        public void onCallServiceStateChanged(IEcallStateStruct iEcallStateStruct) {
            if (iEcallStateStruct.isEmergencyCallBackIncoming()) {
                EmergencyCallServiceHandler.this.activateEcall();
                EmergencyCallServiceHandler.this.showScreen(this.screenContext.callBackIncomingScreen);
            } else if (iEcallStateStruct.isEmergencyConnecting()) {
                EmergencyCallServiceHandler.this.showEmergencyConnectScreen(this.screenContext.connectingScreen);
            } else if (iEcallStateStruct.isEmergencyConnected()) {
                EmergencyCallServiceHandler.this.showEmergencyConnectScreen(this.screenContext.connectedScreen);
            }
        }

        public void handleServiceState(int n) {
            if (EcallUtil.isStateValidForScreenActivation(EmergencyCallServiceHandler.this.IS_SERVICE_STATE_VALID_FOR_SREEN_SHOWING, n)) {
                EmergencyCallServiceHandler.this.forceActivationWithouPendingRequestIfNeed();
            }
            switch (n) {
                case 8: {
                    EmergencyCallServiceHandler.this.showScreen(this.screenContext.sendingDataScreen);
                    break;
                }
                case 10: {
                    EmergencyCallServiceHandler.this.showScreen(this.screenContext.accomplishedScreen);
                    break;
                }
                case 12: 
                case 21: {
                    EmergencyCallServiceHandler.this.showScreen(this.screenContext.failedScreen);
                    break;
                }
                case 13: {
                    EmergencyCallServiceHandler.this.getApplication().getSOSPopupHandler().showLicencePopup();
                    break;
                }
                case 9: 
                case 14: {
                    EmergencyCallServiceHandler.this.showScreen(this.screenContext.canceledScreen);
                    break;
                }
                case 18: {
                    EmergencyCallServiceHandler.this.showScreen(this.screenContext.redialScreen);
                    break;
                }
                case 7: {
                    EmergencyCallServiceHandler.this.showScreen(this.screenContext.redialScreen);
                    break;
                }
                default: {
                    EmergencyCallServiceHandler.this.log.log(10000000, "EmergencyCallServiceHandler#handleServiceState(): unhandled service call state for MEC/ACN %1 ", (long)n);
                    EcallUtil.logStructFieldForDbg(EmergencyCallServiceHandler.this.log, class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState == null ? (class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState = EmergencyCallServiceHandler.class$("de.audi.atip.interapp.bap.ecall.data.ServiceRequestState")) : class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState, n);
                }
            }
        }
    }
}

