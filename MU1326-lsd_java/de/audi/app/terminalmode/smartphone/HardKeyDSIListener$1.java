/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.smartphone.HardKeyDSIListener;
import de.audi.atip.utils.dispatching.ITimerListener$Stub;

class HardKeyDSIListener$1
extends ITimerListener$Stub {
    private final /* synthetic */ HardKeyDSIListener this$0;

    HardKeyDSIListener$1(HardKeyDSIListener hardKeyDSIListener) {
        this.this$0 = hardKeyDSIListener;
    }

    @Override
    public void fireTimer() {
        HardKeyDSIListener.access$000(this.this$0).log(-2137614336, "[%1.fireTimer] SEEK FW.", (Object)"HardKeyDSIListener");
        HardKeyDSIListener.access$100(this.this$0).seek(true, true);
    }
}

