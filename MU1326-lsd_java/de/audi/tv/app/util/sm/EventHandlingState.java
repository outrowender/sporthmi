/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.eventbus.MarkerInterfaceSubscriberFindingStrategy;
import de.audi.tv.app.util.eventbus.ReflectionInvoker;
import de.audi.tv.app.util.sm.State;

public class EventHandlingState
extends State {
    private final ReflectionInvoker invoker;
    private boolean handled = false;

    public EventHandlingState(LogChannel logChannel) {
        this.invoker = new ReflectionInvoker(logChannel, this, new MarkerInterfaceSubscriberFindingStrategy());
    }

    @Override
    public boolean processMessage(Message message) {
        if (message.obj != null) {
            this.handled = true;
            return this.invoker.invoke(message.obj) && this.handled;
        }
        return false;
    }

    protected final void markNotHandled() {
        this.handled = false;
    }
}

