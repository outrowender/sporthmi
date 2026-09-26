/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GList
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.AutomaticDeviceActivator;
import de.audi.app.terminalmode.AutomaticDeviceActivator$1;
import de.audi.app.terminalmode.AutomaticDeviceActivator$LastModeTracker$1;
import de.audi.app.terminalmode.AutomaticDeviceActivator$LastModeTracker$2;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.esolutions.fw.util.commons.job.Job;

class AutomaticDeviceActivator$LastModeTracker
extends DefaultEventListener
implements IActiveDeviceStateListener {
    private volatile Job lastModeTimer = new Job("");
    private final GList devicesSkippedDuringLastmodeTracking = Generics.newArrayList();
    private final /* synthetic */ AutomaticDeviceActivator this$0;

    private AutomaticDeviceActivator$LastModeTracker(AutomaticDeviceActivator automaticDeviceActivator) {
        this.this$0 = automaticDeviceActivator;
    }

    @Override
    public void updateActiveDeviceState(TMDevice tMDevice) {
        if (tMDevice.isActive()) {
            this.startNormalOperation();
        }
    }

    public void stopLastmodeTracking() {
        this.lastModeTimer.cancel();
        AutomaticDeviceActivator.access$900(this.this$0).unregisterListener(this);
        AutomaticDeviceActivator.access$800(this.this$0).removeActiveDeviceListener(this);
        this.devicesSkippedDuringLastmodeTracking.clear();
    }

    public void startLastmodeTracking() {
        AutomaticDeviceActivator.access$800(this.this$0).addActiveDeviceListener(AutomaticDeviceActivator.access$1000(this.this$0));
        AutomaticDeviceActivator.access$900(this.this$0).registerListener(AutomaticDeviceActivator.access$1000(this.this$0));
        this.lastModeTimer = AutomaticDeviceActivator.access$1400(this.this$0).execute(new AutomaticDeviceActivator$LastModeTracker$1(this), 0);
    }

    @Override
    public void readyForActivation(TMDevice tMDevice) {
        boolean bl;
        boolean bl2 = bl = tMDevice.userAcceptState().is(TMDevice$UserAcceptState.DISCLAIMER_ACCEPTED) || AutomaticDeviceActivator.access$300(this.this$0).isAutoConnect();
        if (bl) {
            boolean bl3;
            String string = (String)AutomaticDeviceActivator.access$500(this.this$0).get();
            String string2 = String.valueOf(tMDevice.smartphoneType().ordinal());
            int n = string.lastIndexOf("#");
            boolean bl4 = n == -1 || n != string.length() - string2.length() - 1;
            boolean bl5 = bl3 = string.equals(AutomaticDeviceActivator.access$600(this.this$0, tMDevice, bl4)) || string.equals("no_lastmode_id");
            if (bl3) {
                AutomaticDeviceActivator.access$700(this.this$0).log(1078071040, "<!> [%1.LastModeHandler.readyForActivation] Activate lastmode device %2", (Object)"AutomaticDeviceActivator", (Object)tMDevice);
                AutomaticDeviceActivator.access$800(this.this$0).control(tMDevice).activateDevice();
                this.startNormalOperation();
            } else {
                AutomaticDeviceActivator.access$700(this.this$0).log(1078071040, "<!> [%1.LastModeHandler.readyForActivation] device ready, but we are waiting for lastmode (%2) - %3", (Object)"AutomaticDeviceActivator", (Object)string, (Object)tMDevice);
                this.devicesSkippedDuringLastmodeTracking.add((Object)tMDevice);
                AutomaticDeviceActivator.access$800(this.this$0).control(tMDevice).deactivateDevice();
            }
        }
    }

    private void startNormalOperation() {
        this.stopLastmodeTracking();
        AutomaticDeviceActivator.access$1400(this.this$0).execute(new AutomaticDeviceActivator$LastModeTracker$2(this));
    }

    /* synthetic */ AutomaticDeviceActivator$LastModeTracker(AutomaticDeviceActivator automaticDeviceActivator, AutomaticDeviceActivator$1 automaticDeviceActivator$1) {
        this(automaticDeviceActivator);
    }

    static /* synthetic */ GList access$1100(AutomaticDeviceActivator$LastModeTracker automaticDeviceActivator$LastModeTracker) {
        return automaticDeviceActivator$LastModeTracker.devicesSkippedDuringLastmodeTracking;
    }

    static /* synthetic */ AutomaticDeviceActivator access$1200(AutomaticDeviceActivator$LastModeTracker automaticDeviceActivator$LastModeTracker) {
        return automaticDeviceActivator$LastModeTracker.this$0;
    }

    static /* synthetic */ void access$1300(AutomaticDeviceActivator$LastModeTracker automaticDeviceActivator$LastModeTracker) {
        automaticDeviceActivator$LastModeTracker.startNormalOperation();
    }
}

