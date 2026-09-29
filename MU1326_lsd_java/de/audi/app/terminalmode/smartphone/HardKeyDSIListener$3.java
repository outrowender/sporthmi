/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.smartphone.HardKeyDSIListener;
import de.audi.atip.utils.dispatching.ITimerListener$Stub;

class HardKeyDSIListener$3
extends ITimerListener$Stub {
    private final /* synthetic */ HardKeyDSIListener this$0;

    HardKeyDSIListener$3(HardKeyDSIListener hardKeyDSIListener) {
        this.this$0 = hardKeyDSIListener;
    }

    @Override
    public void fireTimer() {
        HardKeyDSIListener.access$000(this.this$0).log(-2137614336, "[%1.fireTimer] SKIP('%2').", (Object)"HardKeyDSIListener", (long)HardKeyDSIListener.access$200(this.this$0));
        if (HardKeyDSIListener.access$200(this.this$0) == 0) {
            return;
        }
        HardKeyDSIListener.access$100(this.this$0).skip(HardKeyDSIListener.access$200(this.this$0) > 0, Math.abs(HardKeyDSIListener.access$200(this.this$0)));
        HardKeyDSIListener.access$202(this.this$0, 0);
    }
}

