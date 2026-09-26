/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.tghu.fwhmi.HMIEventDispatcher$1;
import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.Job;

class HMIEventDispatcher$EventInterceptor
extends BaseInterceptor
implements IInterceptor {
    private HMIEventDispatcher$EventInterceptor() {
    }

    @Override
    public void execute(Job job) {
        ((ATIPEvent)job.getPayload()).dispatch();
    }

    /* synthetic */ HMIEventDispatcher$EventInterceptor(HMIEventDispatcher$1 hMIEventDispatcher$1) {
        this();
    }
}

