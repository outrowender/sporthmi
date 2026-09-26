/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.ConvenientCommandList;
import de.audi.app.terminalmode.ITMDeviceSubsystem;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$1;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.app.terminalmode.statemachine.commands.StopService;

public class TMDeviceControl$SM$BaseState$DiscoveredState$Busy
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState this$3;

    public TMDeviceControl$SM$BaseState$DiscoveredState$Busy(TMDeviceControl$SM$BaseState$DiscoveredState tMDeviceControl$SM$BaseState$DiscoveredState) {
        this.this$3 = tMDeviceControl$SM$BaseState$DiscoveredState;
        super(null);
    }

    @Override
    protected void deviceNotDiscovered() {
        TMDeviceControl$SM.access$2700(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching);
    }

    @Override
    protected void deactivate() {
        TMDeviceControl$SM.access$2800(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)), TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)).getCurrentMessage());
    }

    @Override
    protected void handleDelete() {
        if (TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).getConfiguration().supportsDeletionOfConnectedDevices()) {
            TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).log(-2137614336, "[%1.handleDelete] resetting the device", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))));
            TMDeviceControl.access$700(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).requestDeactivation(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3))));
            TMDeviceControl$SM.access$2900(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)), TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)).getCurrentMessage());
        } else {
            TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).log(-1601830656, "[TMDeviceControl.handleDelete] cannot delete an attached device if not explicitely configured!");
        }
    }

    private void cleanupAndNotify() {
        ConvenientCommandList convenientCommandList = TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).getCommandListHelper().create();
        convenientCommandList.add(TMDeviceControl.access$5400(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).cleanupAfterDeviceDisconnected(TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), TMDeviceControl.access$1600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3))))));
        convenientCommandList.add(new TMDeviceControl$SM$BaseState$DiscoveredState$Busy$1(this, TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), new StringBuffer().append("NotifyCleanupDone(").append(TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3))))).append(")").toString(), TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3))))));
        convenientCommandList.execute("TMDeviceControl.Busy.cleanupAndNotify()");
    }

    private void deactivateSubsystem() {
        ITMDeviceSubsystem iTMDeviceSubsystem = (ITMDeviceSubsystem)TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).get(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).smartphoneType(), TMDeviceControl.class$de$audi$app$terminalmode$ITMDeviceSubsystem == null ? (TMDeviceControl.class$de$audi$app$terminalmode$ITMDeviceSubsystem = TMDeviceControl.class$("de.audi.app.terminalmode.ITMDeviceSubsystem")) : TMDeviceControl.class$de$audi$app$terminalmode$ITMDeviceSubsystem);
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).log(1078071040, "[%1.deactivateSubsystem] deactivating %2", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), (Object)iTMDeviceSubsystem);
        TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))).getCommandListHelper().create().addSingle(new StopService(TMDeviceControl.access$3800(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), TMDeviceControl.access$1600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))), TMDeviceControl.access$3900(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(this.this$3)))))).execute("TMDeviceControl.Busy.deactivateSubsystem()");
        iTMDeviceSubsystem.deactivate();
    }

    static /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy tMDeviceControl$SM$BaseState$DiscoveredState$Busy) {
        return tMDeviceControl$SM$BaseState$DiscoveredState$Busy.this$3;
    }

    static /* synthetic */ void access$4500(TMDeviceControl$SM$BaseState$DiscoveredState$Busy tMDeviceControl$SM$BaseState$DiscoveredState$Busy) {
        tMDeviceControl$SM$BaseState$DiscoveredState$Busy.cleanupAndNotify();
    }

    static /* synthetic */ void access$4600(TMDeviceControl$SM$BaseState$DiscoveredState$Busy tMDeviceControl$SM$BaseState$DiscoveredState$Busy) {
        tMDeviceControl$SM$BaseState$DiscoveredState$Busy.deactivateSubsystem();
    }
}

