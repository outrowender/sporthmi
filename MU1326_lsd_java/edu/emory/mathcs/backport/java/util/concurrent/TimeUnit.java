/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public abstract class TimeUnit
implements Serializable {
    public static final TimeUnit NANOSECONDS = new TimeUnit(0, "NANOSECONDS"){
        private static final long serialVersionUID = 535148490883208361L;

        public long toNanos(long l) {
            return l;
        }

        public long toMicros(long l) {
            return l / 1000L;
        }

        public long toMillis(long l) {
            return l / 1000000L;
        }

        public long toSeconds(long l) {
            return l / 1000000000L;
        }

        public long toMinutes(long l) {
            return l / 60000000000L;
        }

        public long toHours(long l) {
            return l / 3600000000000L;
        }

        public long toDays(long l) {
            return l / 86400000000000L;
        }

        public long convert(long l, TimeUnit timeUnit) {
            return timeUnit.toNanos(l);
        }

        int excessNanos(long l, long l2) {
            return (int)(l - l2 * 1000000L);
        }
    };
    public static final TimeUnit MICROSECONDS = new TimeUnit(1, "MICROSECONDS"){
        private static final long serialVersionUID = 2185906575929579108L;

        public long toNanos(long l) {
            return 2.x(l, 1000L, 9223372036854775L);
        }

        public long toMicros(long l) {
            return l;
        }

        public long toMillis(long l) {
            return l / 1000L;
        }

        public long toSeconds(long l) {
            return l / 1000000L;
        }

        public long toMinutes(long l) {
            return l / 60000000L;
        }

        public long toHours(long l) {
            return l / 3600000000L;
        }

        public long toDays(long l) {
            return l / 86400000000L;
        }

        public long convert(long l, TimeUnit timeUnit) {
            return timeUnit.toMicros(l);
        }

        int excessNanos(long l, long l2) {
            return (int)(l * 1000L - l2 * 1000000L);
        }
    };
    public static final TimeUnit MILLISECONDS = new TimeUnit(2, "MILLISECONDS"){
        private static final long serialVersionUID = 9032047794123325184L;

        public long toNanos(long l) {
            return 3.x(l, 1000000L, 9223372036854L);
        }

        public long toMicros(long l) {
            return 3.x(l, 1000L, 9223372036854775L);
        }

        public long toMillis(long l) {
            return l;
        }

        public long toSeconds(long l) {
            return l / 1000L;
        }

        public long toMinutes(long l) {
            return l / 60000L;
        }

        public long toHours(long l) {
            return l / 3600000L;
        }

        public long toDays(long l) {
            return l / 86400000L;
        }

        public long convert(long l, TimeUnit timeUnit) {
            return timeUnit.toMillis(l);
        }

        int excessNanos(long l, long l2) {
            return 0;
        }
    };
    public static final TimeUnit SECONDS = new TimeUnit(3, "SECONDS"){
        private static final long serialVersionUID = 227755028449378390L;

        public long toNanos(long l) {
            return 4.x(l, 1000000000L, 0L);
        }

        public long toMicros(long l) {
            return 4.x(l, 1000000L, 9223372036854L);
        }

        public long toMillis(long l) {
            return 4.x(l, 1000L, 9223372036854775L);
        }

        public long toSeconds(long l) {
            return l;
        }

        public long toMinutes(long l) {
            return l / 60L;
        }

        public long toHours(long l) {
            return l / 3600L;
        }

        public long toDays(long l) {
            return l / 86400L;
        }

        public long convert(long l, TimeUnit timeUnit) {
            return timeUnit.toSeconds(l);
        }

        int excessNanos(long l, long l2) {
            return 0;
        }
    };
    public static final TimeUnit MINUTES = new TimeUnit(4, "MINUTES"){
        private static final long serialVersionUID = 1827351566402609187L;

        public long toNanos(long l) {
            return 5.x(l, 60000000000L, 153722867L);
        }

        public long toMicros(long l) {
            return 5.x(l, 60000000L, 153722867280L);
        }

        public long toMillis(long l) {
            return 5.x(l, 60000L, 153722867280912L);
        }

        public long toSeconds(long l) {
            return 5.x(l, 60L, 0x222222222222222L);
        }

        public long toMinutes(long l) {
            return l;
        }

        public long toHours(long l) {
            return l / 60L;
        }

        public long toDays(long l) {
            return l / 1440L;
        }

        public long convert(long l, TimeUnit timeUnit) {
            return timeUnit.toMinutes(l);
        }

        int excessNanos(long l, long l2) {
            return 0;
        }
    };
    public static final TimeUnit HOURS = new TimeUnit(5, "HOURS"){
        private static final long serialVersionUID = -6438436134732089810L;

        public long toNanos(long l) {
            return 6.x(l, 3600000000000L, 2562047L);
        }

        public long toMicros(long l) {
            return 6.x(l, 3600000000L, 2562047788L);
        }

        public long toMillis(long l) {
            return 6.x(l, 3600000L, 2562047788015L);
        }

        public long toSeconds(long l) {
            return 6.x(l, 3600L, 2562047788015215L);
        }

        public long toMinutes(long l) {
            return 6.x(l, 60L, 0x222222222222222L);
        }

        public long toHours(long l) {
            return l;
        }

        public long toDays(long l) {
            return l / 24L;
        }

        public long convert(long l, TimeUnit timeUnit) {
            return timeUnit.toHours(l);
        }

        int excessNanos(long l, long l2) {
            return 0;
        }
    };
    public static final TimeUnit DAYS = new TimeUnit(6, "DAYS"){
        private static final long serialVersionUID = 567463171959674600L;

        public long toNanos(long l) {
            return 7.x(l, 86400000000000L, 106751L);
        }

        public long toMicros(long l) {
            return 7.x(l, 86400000000L, 106751991L);
        }

        public long toMillis(long l) {
            return 7.x(l, 86400000L, 106751991167L);
        }

        public long toSeconds(long l) {
            return 7.x(l, 86400L, 106751991167300L);
        }

        public long toMinutes(long l) {
            return 7.x(l, 1440L, 0x16C16C16C16C16L);
        }

        public long toHours(long l) {
            return 7.x(l, 24L, 0x555555555555555L);
        }

        public long toDays(long l) {
            return l;
        }

        public long convert(long l, TimeUnit timeUnit) {
            return timeUnit.toDays(l);
        }

        int excessNanos(long l, long l2) {
            return 0;
        }
    };
    private static final TimeUnit[] values = new TimeUnit[]{NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS};
    private final int index;
    private final String name;
    static final long C0 = 1L;
    static final long C1 = 1000L;
    static final long C2 = 1000000L;
    static final long C3 = 1000000000L;
    static final long C4 = 60000000000L;
    static final long C5 = 3600000000000L;
    static final long C6 = 86400000000000L;
    static final long MAX = Long.MAX_VALUE;

    public static TimeUnit[] values() {
        return (TimeUnit[])values.clone();
    }

    public static TimeUnit valueOf(String string) {
        for (int i2 = 0; i2 < values.length; ++i2) {
            if (!TimeUnit.values[i2].name.equals(string)) continue;
            return values[i2];
        }
        throw new IllegalArgumentException("No enum const TimeUnit." + string);
    }

    TimeUnit(int n, String string) {
        this.index = n;
        this.name = string;
    }

    static long x(long l, long l2, long l3) {
        if (l > l3) {
            return Long.MAX_VALUE;
        }
        if (l < -l3) {
            return Long.MIN_VALUE;
        }
        return l * l2;
    }

    public abstract long convert(long var1, TimeUnit var3);

    public abstract long toNanos(long var1);

    public abstract long toMicros(long var1);

    public abstract long toMillis(long var1);

    public abstract long toSeconds(long var1);

    public abstract long toMinutes(long var1);

    public abstract long toHours(long var1);

    public abstract long toDays(long var1);

    abstract int excessNanos(long var1, long var3);

    public String name() {
        return this.name;
    }

    public int ordinal() {
        return this.index;
    }

    protected Object readResolve() throws ObjectStreamException {
        try {
            return TimeUnit.valueOf(this.name);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new InvalidObjectException(this.name + " is not a valid enum for TimeUnit");
        }
    }

    public void timedWait(Object object, long l) throws InterruptedException {
        if (l > 0L) {
            long l2 = this.toMillis(l);
            int n = this.excessNanos(l, l2);
            object.wait(l2, n);
        }
    }

    public void timedJoin(Thread thread, long l) throws InterruptedException {
        if (l > 0L) {
            long l2 = this.toMillis(l);
            int n = this.excessNanos(l, l2);
            thread.join(l2, n);
        }
    }

    public void sleep(long l) throws InterruptedException {
        if (l > 0L) {
            long l2 = this.toMillis(l);
            int n = this.excessNanos(l, l2);
            Thread.sleep(l2, n);
        }
    }

    public String toString() {
        return this.name;
    }
}

