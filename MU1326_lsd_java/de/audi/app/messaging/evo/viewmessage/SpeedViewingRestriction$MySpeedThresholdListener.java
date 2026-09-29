/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.viewmessage;

import de.audi.app.messaging.evo.viewmessage.SpeedViewingRestriction;
import de.audi.app.messaging.evo.viewmessage.SpeedViewingRestriction$1;
import de.audi.atip.sysapp.SpeedThresholdListener;

final class SpeedViewingRestriction$MySpeedThresholdListener
implements SpeedThresholdListener {
    private final /* synthetic */ SpeedViewingRestriction this$0;

    private SpeedViewingRestriction$MySpeedThresholdListener(SpeedViewingRestriction speedViewingRestriction) {
        this.this$0 = speedViewingRestriction;
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        if (n == 11) {
            SpeedViewingRestriction.access$100(this.this$0).log(1078071040, "[SpeedViewingRestriction#exceedsUpperThreshold]");
            SpeedViewingRestriction.access$200(this.this$0, true);
        }
    }

    @Override
    public void belowLowerThreshold(int n) {
        if (n == 11) {
            SpeedViewingRestriction.access$300(this.this$0).log(1078071040, "[SpeedViewingRestriction#belowLowerThreshold]");
            SpeedViewingRestriction.access$200(this.this$0, false);
        }
    }

    /* synthetic */ SpeedViewingRestriction$MySpeedThresholdListener(SpeedViewingRestriction speedViewingRestriction, SpeedViewingRestriction$1 speedViewingRestriction$1) {
        this(speedViewingRestriction);
    }
}

