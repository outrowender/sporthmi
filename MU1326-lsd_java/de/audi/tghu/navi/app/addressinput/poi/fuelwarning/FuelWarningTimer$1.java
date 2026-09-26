/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.FuelWarningTimer;

class FuelWarningTimer$1
implements TimerListener {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ FuelWarningTimer this$0;

    FuelWarningTimer$1(FuelWarningTimer fuelWarningTimer, LogChannel logChannel) {
        this.this$0 = fuelWarningTimer;
        this.val$logChannel = logChannel;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.val$logChannel != null) {
            this.val$logChannel.log(-2137614336, "%1#fireTimer() -> showPopup()", (Object)(FuelWarningTimer.class$de$audi$tghu$navi$app$addressinput$poi$fuelwarning$FuelWarningTimer == null ? (FuelWarningTimer.class$de$audi$tghu$navi$app$addressinput$poi$fuelwarning$FuelWarningTimer = FuelWarningTimer.class$("de.audi.tghu.navi.app.addressinput.poi.fuelwarning.FuelWarningTimer")) : FuelWarningTimer.class$de$audi$tghu$navi$app$addressinput$poi$fuelwarning$FuelWarningTimer).getName());
        }
        FuelWarningTimer.access$000(this.this$0);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

