/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class MergeKZBAsyncEvent
extends ATIPEvent {
    private int kzbConstant;

    public MergeKZBAsyncEvent(ATIPEventListener aTIPEventListener, int n, int n2) {
        super(aTIPEventListener, n);
        this.kzbConstant = n2;
    }

    public int getKzbConstant() {
        return this.kzbConstant;
    }
}

