/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.cc;

import de.esolutions.fw.util.commons.IntList;

public class PendingCCIDs {
    private final IntList pendingCCIDs = new IntList(100);

    synchronized void add(int n) {
        if (!this.pendingCCIDs.contains(n)) {
            this.pendingCCIDs.add(n);
        }
    }

    synchronized void remove(int n) {
        this.pendingCCIDs.removeElement(n);
    }

    synchronized void clear() {
        this.pendingCCIDs.clear();
    }

    synchronized int[] toArray() {
        return this.pendingCCIDs.toArray();
    }
}

