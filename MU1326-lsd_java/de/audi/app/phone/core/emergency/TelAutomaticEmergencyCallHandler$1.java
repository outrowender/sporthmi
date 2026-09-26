/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.emergency;

import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class TelAutomaticEmergencyCallHandler$1
implements TimerListener {
    private final /* synthetic */ TelAutomaticEmergencyCallHandler this$0;

    TelAutomaticEmergencyCallHandler$1(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler) {
        this.this$0 = telAutomaticEmergencyCallHandler;
    }

    @Override
    public void fireTimer(Timer timer) {
        TelAutomaticEmergencyCallHandler.access$000(this.this$0).log(1078071040, "[TelAutomaticEmergencyCallHandler.TelAutomaticEmergencyCallHandler(...).new TimerListener() {...}#fireTimer] checking for dialing emergency.");
        TelAutomaticEmergencyCallHandler.access$100(this.this$0, true);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

