/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$ErrorCode;
import de.audi.atip.utils.statemachine.Message;

public class TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy this$4;

    public TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting(TMDeviceControl$SM$BaseState$DiscoveredState$Busy tMDeviceControl$SM$BaseState$DiscoveredState$Busy) {
        this.this$4 = tMDeviceControl$SM$BaseState$DiscoveredState$Busy;
        super(null);
    }

    @Override
    public void enter(Message message) {
        TMDeviceControl.access$1000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4)))), TMDevice$ConnectionState.ACTIVATING, "Connecting");
        TMDeviceControl.access$1400(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))))).connectDevice(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4)))));
        TMDeviceControl$SM.access$3100(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4)))).connectDevice(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))))).getDeviceId(), TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))))).smartphoneType());
        TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))).sendMessageDelayed(12, "CONNECTING_TIMEOUT", 0);
    }

    @Override
    protected void connectionStateConnected() {
        TMDeviceControl$SM.access$3200(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem);
    }

    @Override
    protected void connectDeviceFailed(SmartphoneIntegrationDSILifecycleController$ErrorCode smartphoneIntegrationDSILifecycleController$ErrorCode) {
        this.handleError();
    }

    @Override
    protected void connectionStateFailed(int n) {
        if (n == 8) {
            TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))).sendMessageDelayed(15, (long)0);
        }
        if (n == 4) {
            TMDeviceControl$SM$BaseState$DiscoveredState.access$3308(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4));
        }
        if (n == 6) {
            TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))))).setUserAcceptState(TMDevice$UserAcceptState.INITIAL).setWasDisclaimerPreviouslyAccepted(false).setStoreUserAcceptState(false).setConnectionState(TMDevice$ConnectionState.ATTACHED);
            TMDeviceControl.access$700(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))))).notifyAboutChange(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))))), "handleNoCarplayDeviceError");
        }
        this.handleError();
    }

    @Override
    protected void connectionStateStopped() {
        this.handleError();
    }

    @Override
    protected void connectionStateDisconnected() {
        this.handleError();
    }

    @Override
    protected void timeout(String string) {
        this.handleError();
    }

    private void handleError() {
        TMDeviceControl$SM.access$3400(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
    }

    @Override
    public void exit(Message message) {
        TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))).removeMessages(12);
    }

    @Override
    protected void deviceNotDiscovered() {
        TMDeviceControl$SM.access$3500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))), TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))).getCurrentMessage());
    }
}

