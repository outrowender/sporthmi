/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.DomainHandlerMU;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class DomainHandlerMU$1
implements TimerListener {
    private final /* synthetic */ DomainHandlerMU this$0;

    DomainHandlerMU$1(DomainHandlerMU domainHandlerMU) {
        this.this$0 = domainHandlerMU;
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.updateDomainStatusMedia(8, 1);
    }
}

