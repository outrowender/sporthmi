/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

public interface IRangeCounter {
    public int getRangeBoundaryStart();

    public int getNext(int var1);

    public boolean isInsideRangeBoundary(int var1);
}

