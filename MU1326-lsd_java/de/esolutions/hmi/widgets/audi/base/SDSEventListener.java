/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.event.SDSEvent;

public interface SDSEventListener {
    default public void processSDSEvent(SDSEvent sDSEvent) {
    }
}

