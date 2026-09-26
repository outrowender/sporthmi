/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.DomainHandlerMU;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class DomainHandlerMU$3
implements TimerListener {
    private final /* synthetic */ DomainHandlerMU this$0;

    DomainHandlerMU$3(DomainHandlerMU domainHandlerMU) {
        this.this$0 = domainHandlerMU;
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.updateDomainStatusPostStartup(8, 1);
    }
}

