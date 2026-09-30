/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.clock;

import org.apache.commons.id.uuid.clock.Clock;
import org.apache.commons.id.uuid.clock.OverClockedException;

public final class SystemClockImpl
implements Clock {
    private long generatedThisMilli = 0L;
    private long currentTimeMillis;

    public long getUUIDTime() throws OverClockedException {
        return this.getTimeSynchronized();
    }

    private synchronized long getTimeSynchronized() throws OverClockedException {
        if (this.currentTimeMillis != System.currentTimeMillis()) {
            this.currentTimeMillis = System.currentTimeMillis();
            this.generatedThisMilli = 0L;
        }
        long l = (this.currentTimeMillis + 12219292800000L) * 10000L;
        if (this.generatedThisMilli + 1L >= 10000L) {
            throw new OverClockedException();
        }
        return l + this.generatedThisMilli++;
    }
}

