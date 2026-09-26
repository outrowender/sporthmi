/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.MasterControlASIProvider;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.comm.core.method.MethodException;

class MasterControlASIProvider$1
implements TimerListener {
    private final /* synthetic */ MasterControlASIProvider this$0;

    MasterControlASIProvider$1(MasterControlASIProvider masterControlASIProvider) {
        this.this$0 = masterControlASIProvider;
    }

    @Override
    public void fireTimer(Timer timer) {
        try {
            this.this$0.updateHUVersion(MasterControlASIProvider.access$000(this.this$0).getHUSwVersion());
        }
        catch (MethodException methodException) {
            MasterControlASIProvider.access$100(this.this$0).log(1078071040, "[MasterControlASIProvider.updateHUVersion] unexpected MethodException", (Throwable)methodException);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

