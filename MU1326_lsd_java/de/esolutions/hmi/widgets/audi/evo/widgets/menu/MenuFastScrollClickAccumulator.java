/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import java.util.Arrays;

public class MenuFastScrollClickAccumulator
implements IWidgetLogChannel {
    private static final int TIMESTAMP_EMPTY = 0;
    private long[] tickTimestamps = new long[4];

    public boolean keyTurned(int n, long l) {
        int n2 = this.getObsoleteTickCount(l);
        int n3 = this.deleteObsoleteTicks(n2);
        this.clearGarbageAfterTicks(n3);
        int n4 = n3 + n;
        if (n4 >= this.tickTimestamps.length) {
            menuLogCh.log(10000000, "MenuFastScrollClickAccumulator#keyTurned: Start FastScroll. removed %1 obsolete ticks, %2 ticks remaining, with new ticks reached %3 ticks", (long)n2, (long)n3, (long)n4);
            return true;
        }
        this.addTicks(n3, n, l);
        menuLogCh.log(10000000, "MenuFastScrollClickAccumulator#keyTurned: removed %1 obsolete ticks, %2 ticks remaining, with new ticks reached %3 ticks within timeout", (long)n2, (long)n3, (long)n4);
        return false;
    }

    public void clear() {
        Arrays.fill(this.tickTimestamps, 0L);
    }

    private int getObsoleteTickCount(long l) {
        if (this.tickTimestamps[0] == 0L) {
            return 0;
        }
        for (int i2 = 0; i2 < this.tickTimestamps.length; ++i2) {
            long l2 = l - this.tickTimestamps[i2];
            if (l2 >= 250L) continue;
            return i2;
        }
        return this.tickTimestamps.length;
    }

    private int deleteObsoleteTicks(int n) {
        int n2 = this.tickTimestamps.length - n;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2 + n;
            if (this.tickTimestamps[n3] == 0L) {
                return i2;
            }
            this.tickTimestamps[i2] = this.tickTimestamps[n3];
        }
        return n2;
    }

    private void clearGarbageAfterTicks(int n) {
        Arrays.fill(this.tickTimestamps, n, this.tickTimestamps.length, 0L);
    }

    private void addTicks(int n, int n2, long l) {
        Arrays.fill(this.tickTimestamps, n, n + n2, l);
    }

    long[] getTickTimestamps() {
        return this.tickTimestamps;
    }
}

