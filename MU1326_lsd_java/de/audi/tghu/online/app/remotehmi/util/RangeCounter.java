/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.util;

import de.audi.remotehmi.ui.mib2.grid.IRangeCounter;

public class RangeCounter
implements IRangeCounter {
    private final int rangeBoundaryStart;
    private final int rangeBoundaryEnd;
    private final int rangeBoundarySize;
    private int firstUnusedNumber;
    private int lastRangeSize;

    public RangeCounter(int n, int n2) {
        if (n < 0) {
            throw new IllegalArgumentException("Range start must be positive. But rangeBoundaryStart = " + n);
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException("Range size must be greater than 0. But rangeBoundarySize = " + n2);
        }
        if (n2 >= Integer.MAX_VALUE - n) {
            throw new IllegalArgumentException("Range end must be lesser than Integer.MAX_VALUE. But rangeBoundaryStart (=" + n + ") + rangeBoundarySize (=" + n + ") = " + ((long)n + (long)n2) + " is greater than " + Integer.MAX_VALUE);
        }
        this.rangeBoundaryStart = n;
        this.rangeBoundarySize = n2;
        this.rangeBoundaryEnd = n + n2;
        this.firstUnusedNumber = n;
        this.lastRangeSize = 0;
    }

    public synchronized int getNext(int n) {
        int n2 = this.rangeBoundarySize / 2;
        if (n <= 0 || n > n2) {
            throw new IllegalArgumentException("Illegal argument for range= " + n + ", It must be greater 0 and lesser than " + n2);
        }
        this.lastRangeSize = n;
        if (this.firstUnusedNumber > this.rangeBoundaryEnd - n) {
            this.firstUnusedNumber = this.rangeBoundaryStart;
        }
        int n3 = this.firstUnusedNumber;
        this.firstUnusedNumber += n;
        return n3;
    }

    public boolean isInsideRangeBoundary(int n) {
        return n >= this.rangeBoundaryStart && n < this.rangeBoundaryEnd;
    }

    public int getRangeBoundaryStart() {
        return this.rangeBoundaryStart;
    }
}

