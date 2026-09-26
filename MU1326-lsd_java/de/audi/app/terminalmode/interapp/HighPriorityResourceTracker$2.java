/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker;
import de.audi.atip.utils.generics.Consumer;

class HighPriorityResourceTracker$2
implements Consumer {
    private final /* synthetic */ HighPriorityResourceTracker this$0;

    HighPriorityResourceTracker$2(HighPriorityResourceTracker highPriorityResourceTracker) {
        this.this$0 = highPriorityResourceTracker;
    }

    public void accept(TMDevice tMDevice) {
        if (((Boolean)HighPriorityResourceTracker.access$000(this.this$0).get()).booleanValue()) {
            HighPriorityResourceTracker.access$100(this.this$0).log(1078071040, "[HighPriorityResourceTracker] ECall Lockscreenchanges");
            HighPriorityResourceTracker.access$200(this.this$0).getChoiceModel(835989504).setValue(tMDevice.isCarplayDevice() ? 1 : (tMDevice.isAndroidAutoDevice() ? 2 : 5));
        } else if (((Boolean)HighPriorityResourceTracker.access$300(this.this$0).get()).booleanValue()) {
            HighPriorityResourceTracker.access$100(this.this$0).log(1078071040, "[HighPriorityResourceTracker] RVC Lockscreenchanges");
            HighPriorityResourceTracker.access$200(this.this$0).getChoiceModel(835989504).setValue(tMDevice.isCarplayDevice() ? 3 : (tMDevice.isAndroidAutoDevice() ? 4 : 6));
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((TMDevice)object);
    }
}

