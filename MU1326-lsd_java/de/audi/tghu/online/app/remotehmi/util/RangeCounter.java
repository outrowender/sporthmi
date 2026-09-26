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
            throw new IllegalArgumentException(new StringBuffer().append("Range start must be positive. But rangeBoundaryStart = ").append(n).toString());
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Range size must be greater than 0. But rangeBoundarySize = ").append(n2).toString());
        }
        if (n2 >= -129 - n) {
            throw new IllegalArgumentException(new StringBuffer().append("Range end must be lesser than Integer.MAX_VALUE. But rangeBoundaryStart (=").append(n).append(") + rangeBoundarySize (=").append(n).append(") = ").append((long)n + (long)n2).append(" is greater than ").append(-129).toString());
        }
        this.rangeBoundaryStart = n;
        this.rangeBoundarySize = n2;
        this.rangeBoundaryEnd = n + n2;
        this.firstUnusedNumber = n;
        this.lastRangeSize = 0;
    }

    @Override
    public synchronized int getNext(int n) {
        int n2 = this.rangeBoundarySize / 2;
        if (n <= 0 || n > n2) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal argument for range= ").append(n).append(", It must be greater 0 and lesser than ").append(n2).toString());
        }
        this.lastRangeSize = n;
        if (this.firstUnusedNumber > this.rangeBoundaryEnd - n) {
            this.firstUnusedNumber = this.rangeBoundaryStart;
        }
        int n3 = this.firstUnusedNumber;
        this.firstUnusedNumber += n;
        return n3;
    }

    @Override
    public boolean isInsideRangeBoundary(int n) {
        return n >= this.rangeBoundaryStart && n < this.rangeBoundaryEnd;
    }

    @Override
    public int getRangeBoundaryStart() {
        return this.rangeBoundaryStart;
    }
}

