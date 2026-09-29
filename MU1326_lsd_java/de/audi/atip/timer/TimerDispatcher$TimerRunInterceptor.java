/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerDispatcher$1;
import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.Job;

final class TimerDispatcher$TimerRunInterceptor
extends BaseInterceptor
implements IInterceptor {
    private TimerDispatcher$TimerRunInterceptor() {
    }

    @Override
    public void execute(Job job) {
        ((Timer)job.getPayload()).run();
    }

    /* synthetic */ TimerDispatcher$TimerRunInterceptor(TimerDispatcher$1 timerDispatcher$1) {
        this();
    }
}

