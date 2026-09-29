/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

public interface IRangeCounter {
    default public int getRangeBoundaryStart() {
    }

    default public int getNext(int n) {
    }

    default public boolean isInsideRangeBoundary(int n) {
    }
}

