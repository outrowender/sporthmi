/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.event;

import de.audi.app.phone.core.event.AbstractTelEvent;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.job.JobLogger;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class TelEventQueue {
    private final DispatcherBase dispatcher;

    public TelEventQueue(IFrameworkAccess iFrameworkAccess) {
        this.dispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("TelEventQueue", new JobLogger(iFrameworkAccess.getLogChannel("App.Phone.EventQueue")));
    }

    public void init() {
        this.dispatcher.start();
    }

    public void deinit() {
        this.dispatcher.stop();
    }

    public void enqueue(AbstractTelEvent abstractTelEvent) {
        this.dispatcher.execute(abstractTelEvent);
    }
}

