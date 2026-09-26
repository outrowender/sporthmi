/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.event;

import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractTelEvent
implements Runnable {
    private final String eventName;
    private final String eventDescription;

    public AbstractTelEvent(String string, String string2) {
        this.eventName = string;
        this.eventDescription = string2;
    }

    public String toString() {
        return new Buffer().append(this.eventName).append("(").append(this.eventDescription).append(")").toString();
    }
}

