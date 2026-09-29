/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class AbstractBAPModuleInitializationManagerASG$1
implements TimerListener {
    private final /* synthetic */ AbstractBAPModuleInitializationManagerASG this$0;

    AbstractBAPModuleInitializationManagerASG$1(AbstractBAPModuleInitializationManagerASG abstractBAPModuleInitializationManagerASG) {
        this.this$0 = abstractBAPModuleInitializationManagerASG;
    }

    @Override
    public void fireTimer(Timer timer) {
        AbstractBAPModuleInitializationManagerASG.access$400(this.this$0);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

