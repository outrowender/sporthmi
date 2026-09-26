/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching$1;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.atip.utils.statemachine.Message;
import de.audi.atip.utils.statemachine.SyncPoint;
import de.audi.atip.utils.statemachine.SyncPoint$Builder;

public class TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching
extends TMDeviceControl$TMDeviceControlState {
    private static final String CLEANUP_DONE;
    private static final String DISCONNECTED;
    private final SyncPoint cleanedUpAndDetached;
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown this$5;

    public TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown) {
        this.this$5 = tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown;
        super(null);
        this.cleanedUpAndDetached = new SyncPoint$Builder().addRequirement("CLEANUP_DONE").addRequirement("DISCONNECTED").setCallback(new TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching$1(this)).setLogChannel(TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5))))))).setName(TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5))))))).build();
    }

    @Override
    public void enter(Message message) {
        this.cleanedUpAndDetached.reset();
        TMDeviceControl.access$1000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5))))), TMDevice$ConnectionState.NOT_ATTACHED, "deviceIsNotDiscovered");
        TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$4500(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5));
        TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))).sendMessageDelayed(12, "DETACHING_TIMEOUT", TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4800(this.this$5));
    }

    @Override
    protected void cleanupDone() {
        TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$4600(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5));
        this.cleanedUpAndDetached.completeRequirement("CLEANUP_DONE");
    }

    @Override
    protected void connectionStateStopped() {
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))))).log(1078071040, "[%1.CleaningUpAndDetaching.connectionStateStopped] waiting for disconnected", (Object)TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))))));
    }

    @Override
    protected void connectionStateDisconnected() {
        this.cleanedUpAndDetached.completeRequirement("DISCONNECTED");
    }

    @Override
    protected void deviceDiscovered(PhysicalDevice physicalDevice) {
        TMDeviceControl$SM.access$5300(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))), TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))).getCurrentMessage());
    }

    @Override
    public void exit(Message message) {
        TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))).removeMessages(12);
    }

    @Override
    protected void timeout(String string) {
        TMDeviceControl.access$100(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown.access$4400(this.this$5)))))).log(-1601830656, "[%1.DetachingState.timeout] did not receive disconnected in time!");
        this.cleanedUpAndDetached.completeRequirement("DISCONNECTED");
    }

    static /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown access$5100(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching) {
        return tMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching.this$5;
    }
}

