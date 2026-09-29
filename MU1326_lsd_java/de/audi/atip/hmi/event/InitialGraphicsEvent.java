/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.RunnableEvent;

public class InitialGraphicsEvent
extends RunnableEvent {
    public InitialGraphicsEvent(Runnable runnable) {
        super(true, runnable);
    }
}

