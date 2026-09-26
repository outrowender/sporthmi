/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap.sos;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.IEcallComponent;
import de.audi.app.ecall.core.bap.sos.EcallBluetoothHandler;
import de.audi.app.ecall.core.bap.sos.EmergencyCallServiceHandler$1;
import de.audi.app.ecall.core.bap.sos.EmergencyCallServiceHandler$ScreenHandler;
import de.audi.app.ecall.core.bap.sos.ScreenContext$Builder;
import de.audi.app.ecall.core.power.EcallPowerHandler;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.log.LogChannel;

public class EmergencyCallServiceHandler
extends AbstractEcallComponent
implements IGlobalEcallStateListener {
    private final EcallPowerHandler ecallPowerHandling;
    private final EcallBluetoothHandler ecallBluetoothHandler;
    private volatile boolean wasEmergencyCallPendingRequest;
    private final boolean[] IS_SERVICE_STATE_VALID_FOR_SREEN_SHOWING;
    private final EmergencyCallServiceHandler$ScreenHandler mecScreenHandler;
    private final EmergencyCallServiceHandler$ScreenHandler acnScreenHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState;

    EmergencyCallServiceHandler(IEcallApplication iEcallApplication) {
        this(iEcallApplication, new boolean[0]);
    }

    public EmergencyCallServiceHandler(IEcallApplication iEcallApplication, boolean[] blArray) {
        super(iEcallApplication, "App.Ecall.SOS");
        this.IS_SERVICE_STATE_VALID_FOR_SREEN_SHOWING = blArray;
        this.ecallPowerHandling = new EcallPowerHandler(iEcallApplication, 164, 165);
        this.ecallBluetoothHandler = new EcallBluetoothHandler(iEcallApplication);
        ScreenContext$Builder screenContext$Builder = new ScreenContext$Builder();
        screenContext$Builder.setConnectingScreen(25);
        screenContext$Builder.setConnectedScreen(27);
        screenContext$Builder.setCallBackIncomingScreen(14);
        screenContext$Builder.setSendingDataScreen(28);
        screenContext$Builder.setAccomplishedScreen(29);
        screenContext$Builder.setFailedScreen(31);
        screenContext$Builder.setCanceledScreen(26);
        screenContext$Builder.setRedialScreen(30);
        this.mecScreenHandler = new EmergencyCallServiceHandler$ScreenHandler(this, screenContext$Builder.build());
        ScreenContext$Builder screenContext$Builder2 = new ScreenContext$Builder();
        screenContext$Builder2.setConnectingScreen(11);
        screenContext$Builder2.setConnectedScreen(12);
        screenContext$Builder2.setCallBackIncomingScreen(14);
        screenContext$Builder2.setSendingDataScreen(13);
        screenContext$Builder2.setAccomplishedScreen(20);
        screenContext$Builder2.setFailedScreen(21);
        screenContext$Builder2.setCanceledScreen(22);
        screenContext$Builder2.setRedialScreen(32);
        this.acnScreenHandler = new EmergencyCallServiceHandler$ScreenHandler(this, screenContext$Builder2.build());
        this.getApplication().addDiagnosisComponent(new EmergencyCallServiceHandler$1(this));
    }

    @Override
    protected IEcallComponent[] getSubComponents() {
        return new IEcallComponent[]{this.ecallPowerHandling, this.ecallBluetoothHandler};
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getEcallStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getEcallStateManager().removeListener(this);
    }

    private void activateEcall() {
        this.log.log(1078071040, "EmergencyCallServiceHandler#activateEcall(): called");
        this.wasEmergencyCallPendingRequest = true;
        this.ecallPowerHandling.activatePowerState();
        this.getApplication().getSDSHandler().disablePTT();
        this.getApplication().getSOSPopupHandler().activateEcallSession();
        this.getApplication().getTelServiceEcallHandler().hangupAllCalls();
        this.ecallBluetoothHandler.switchOffBluetooth();
    }

    private void disactivateEcall() {
        if (!this.wasEmergencyCallPendingRequest) {
            this.log.log(1078071040, "EmergencyCallServiceHandler#disactivateEcall(): emergency call is inactive. NOP");
            return;
        }
        this.log.log(1078071040, "EmergencyCallServiceHandler#disactivateEcall(): called");
        this.wasEmergencyCallPendingRequest = false;
        this.ecallBluetoothHandler.switchOnBluetooth();
        this.getApplication().getSDSHandler().enablePTT();
        this.getApplication().getSOSPopupHandler().disactivateEcallSession();
        this.ecallPowerHandling.disactivatePowerState();
    }

    @Override
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
        this.log.log(-2137614336, "EmergencyCallServiceHandler#onServiceState(): start to handle service state serviceCallKind (%1), serviceState (%2)", (Object)String.valueOf(n), (Object)String.valueOf(n2));
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
            this.log.log(1078071040, "EmergencyCallServiceHandler#onServiceState(): unhandled serviceCallKind=%1 (%2)", (Object)String.valueOf(n), (Object)String.valueOf(iEcallStateStruct));
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

    static /* synthetic */ void access$000(EmergencyCallServiceHandler emergencyCallServiceHandler) {
        emergencyCallServiceHandler.activateEcall();
    }

    static /* synthetic */ void access$100(EmergencyCallServiceHandler emergencyCallServiceHandler) {
        emergencyCallServiceHandler.disactivateEcall();
    }

    static /* synthetic */ void access$200(EmergencyCallServiceHandler emergencyCallServiceHandler, int n) {
        emergencyCallServiceHandler.showScreen(n);
    }

    static /* synthetic */ void access$300(EmergencyCallServiceHandler emergencyCallServiceHandler, int n) {
        emergencyCallServiceHandler.showEmergencyConnectScreen(n);
    }

    static /* synthetic */ boolean[] access$400(EmergencyCallServiceHandler emergencyCallServiceHandler) {
        return emergencyCallServiceHandler.IS_SERVICE_STATE_VALID_FOR_SREEN_SHOWING;
    }

    static /* synthetic */ void access$500(EmergencyCallServiceHandler emergencyCallServiceHandler) {
        emergencyCallServiceHandler.forceActivationWithouPendingRequestIfNeed();
    }

    static /* synthetic */ IEcallApplication access$600(EmergencyCallServiceHandler emergencyCallServiceHandler) {
        return emergencyCallServiceHandler.getApplication();
    }

    static /* synthetic */ LogChannel access$700(EmergencyCallServiceHandler emergencyCallServiceHandler) {
        return emergencyCallServiceHandler.log;
    }

    static /* synthetic */ LogChannel access$800(EmergencyCallServiceHandler emergencyCallServiceHandler) {
        return emergencyCallServiceHandler.log;
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

