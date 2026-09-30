/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.clock;

import org.apache.commons.id.uuid.clock.OverClockedException;

public interface Clock {
    public static final String DEFAULT_CLOCK_IMPL = "org.apache.commons.id.uuid.clock.SystemClockImpl";
    public static final long GREGORIAN_CHANGE_OFFSET = 12219292800000L;
    public static final long INTERVALS_PER_MILLI = 10000L;

    public long getUUIDTime() throws OverClockedException;
}

