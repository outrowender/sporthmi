/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.invoke;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.SCXMLExecutor;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.model.ModelException;

class AsyncTrigger
implements Runnable {
    private final SCXMLExecutor executor;
    private final TriggerEvent[] events;
    private final Log log = LogFactory.getLog(class$org$apache$commons$scxml$invoke$AsyncTrigger == null ? (class$org$apache$commons$scxml$invoke$AsyncTrigger = AsyncTrigger.class$("org.apache.commons.scxml.invoke.AsyncTrigger")) : class$org$apache$commons$scxml$invoke$AsyncTrigger);
    static /* synthetic */ Class class$org$apache$commons$scxml$invoke$AsyncTrigger;

    AsyncTrigger(SCXMLExecutor sCXMLExecutor, TriggerEvent triggerEvent) {
        this.executor = sCXMLExecutor;
        this.events = new TriggerEvent[1];
        this.events[0] = triggerEvent;
    }

    public void start() {
        new Thread(this).start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            SCXMLExecutor sCXMLExecutor = this.executor;
            synchronized (sCXMLExecutor) {
                this.executor.triggerEvents(this.events);
            }
        }
        catch (ModelException modelException) {
            this.log.error(modelException.getMessage(), modelException);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

