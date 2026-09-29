/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;

class CarPlayDSIManager$1
implements IPhoneCallController {
    private final /* synthetic */ CarPlayDSIManager this$0;

    CarPlayDSIManager$1(CarPlayDSIManager carPlayDSIManager) {
        this.this$0 = carPlayDSIManager;
    }

    @Override
    public void hook(boolean bl) {
        CarPlayDSIManager.access$000(this.this$0).postDSICarplayButtonEvent(13, bl ? 1 : 0);
    }

    @Override
    public void hangup(boolean bl) {
        CarPlayDSIManager.access$000(this.this$0).postDSICarplayButtonEvent(14, bl ? 1 : 0);
    }

    @Override
    public void flash(boolean bl) {
        CarPlayDSIManager.access$000(this.this$0).postDSICarplayButtonEvent(20, bl ? 1 : 0);
    }
}

