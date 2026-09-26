/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class ComponentConditionEvent
extends ATIPEvent {
    private final int[] changedCCIDs;

    public ComponentConditionEvent(ATIPEventListener[] aTIPEventListenerArray, int[] nArray) {
        super(aTIPEventListenerArray, -1);
        this.changedCCIDs = nArray;
    }

    public int[] getChangedComponentConditions() {
        return this.changedCCIDs;
    }
}

