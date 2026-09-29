/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.ITMDeviceSubsystem;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.app.terminalmode.statemachine.commands.StopService;
import de.audi.atip.utils.statemachine.Message;

public class TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive this$5;

    public TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive tMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive) {
        this.this$5 = tMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive;
        super(null);
    }

    @Override
    public void enter(Message message) {
        ITMDeviceSubsystem iTMDeviceSubsystem = (ITMDeviceSubsystem)TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).get(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).smartphoneType(), TMDeviceControl.class$de$audi$app$terminalmode$ITMDeviceSubsystem == null ? (TMDeviceControl.class$de$audi$app$terminalmode$ITMDeviceSubsystem = TMDeviceControl.class$("de.audi.app.terminalmode.ITMDeviceSubsystem")) : TMDeviceControl.class$de$audi$app$terminalmode$ITMDeviceSubsystem);
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).log(-2137614336, "[%1.enter] activating %2", (Object)this.getName(), (Object)iTMDeviceSubsystem);
        TMDeviceControl.access$1000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5))))), TMDevice$ConnectionState.ACTIVATING, "ActivateDeviceSubsystem");
        iTMDeviceSubsystem.activate();
        TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))).sendMessageDelayed(12, "ACTIVATING_SUBSYSTEM_TIMEOUT", 0);
    }

    @Override
    protected void connectionStateStarted() {
        TMDeviceControl$SM.access$3700(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active);
    }

    @Override
    protected void timeout(String string) {
        ITMDeviceSubsystem iTMDeviceSubsystem = (ITMDeviceSubsystem)TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).get(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).smartphoneType(), TMDeviceControl.class$de$audi$app$terminalmode$ITMDeviceSubsystem == null ? (TMDeviceControl.class$de$audi$app$terminalmode$ITMDeviceSubsystem = TMDeviceControl.class$("de.audi.app.terminalmode.ITMDeviceSubsystem")) : TMDeviceControl.class$de$audi$app$terminalmode$ITMDeviceSubsystem);
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).log(1078071040, "[%1.ActivatingSubsystem.timeout] deactivating %2", (Object)this.getName(), (Object)iTMDeviceSubsystem);
        TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).getCommandListHelper().create().addSingle(new StopService(TMDeviceControl.access$3800(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))), TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))), TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))), TMDeviceControl.access$1600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))), TMDeviceControl.access$3900(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))))).execute("TMDeviceControl.ActivatingSubsystem.timeout(String)");
        iTMDeviceSubsystem.deactivate();
        TMDeviceControl$SM.access$4000(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
    }

    @Override
    public void exit(Message message) {
        TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))).removeMessages(12);
    }
}

