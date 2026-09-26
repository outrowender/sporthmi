/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.event;

import de.audi.app.phone.core.event.AbstractTelEvent;

public abstract class AbstractTelActionProxyEvent
extends AbstractTelEvent {
    public AbstractTelActionProxyEvent(int n) {
        super("AbstractTelActionProxyEvent", String.valueOf(n));
    }
}

