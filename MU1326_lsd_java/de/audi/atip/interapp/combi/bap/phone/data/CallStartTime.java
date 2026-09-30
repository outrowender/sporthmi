/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

public final class CallStartTime {
    private static final int HOURS_MASK = 61440;
    private static final int MINUTES_MASK = 4032;
    private static final int SECONDS_MASK = 63;
    private static final int LEAST_SIGNIFICANT_4_BITS = 15;
    private static final int LEAST_SIGNIFICANT_6_BITS = 63;
    private static final int HOURS_BIT_SHIFT = 12;
    private static final int MINUTES_BIT_SHIFT = 6;
    private static final int SECONDS_BIT_SHIFT = 0;
    private final int timeStamp;

    public CallStartTime(int n) {
        this.timeStamp = n;
    }

    public CallStartTime(int n, int n2, int n3) {
        int n4 = 0;
        n4 |= (n & 0xF) << 12;
        n4 |= (n2 & 0x3F) << 6;
        this.timeStamp = n4 |= (n3 & 0x3F) << 0;
    }

    public int getHours() {
        return (this.timeStamp & 0xF000) >> 12;
    }

    public int getMinutes() {
        return (this.timeStamp & 0xFC0) >> 6;
    }

    public int getSeconds() {
        return (this.timeStamp & 0x3F) >> 0;
    }

    public int getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.timeStamp;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        CallStartTime callStartTime = (CallStartTime)object;
        return this.timeStamp == callStartTime.timeStamp;
    }

    public String toString() {
        return "CallDuration [hours=" + this.getHours() + " minutes=" + this.getMinutes() + " seconds=" + this.getSeconds() + " timeStamp=" + this.timeStamp + "]";
    }
}

