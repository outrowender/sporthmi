/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.event;

import de.audi.app.phone.core.event.AbstractTelEvent;

public abstract class AbstractTelMsgDistEvent
extends AbstractTelEvent {
    public AbstractTelMsgDistEvent(int n) {
        super("AbstractTelMsgDistEvent", String.valueOf(n));
    }
}

