/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

public final class CallStartTime {
    private static final int HOURS_MASK;
    private static final int MINUTES_MASK;
    private static final int SECONDS_MASK;
    private static final int LEAST_SIGNIFICANT_4_BITS;
    private static final int LEAST_SIGNIFICANT_6_BITS;
    private static final int HOURS_BIT_SHIFT;
    private static final int MINUTES_BIT_SHIFT;
    private static final int SECONDS_BIT_SHIFT;
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
        return (this.timeStamp & 0xF00000) >> 12;
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
        if (super.getClass() != object.getClass()) {
            return false;
        }
        CallStartTime callStartTime = (CallStartTime)object;
        return this.timeStamp == callStartTime.timeStamp;
    }

    public String toString() {
        return new StringBuffer().append("CallDuration [hours=").append(this.getHours()).append(" minutes=").append(this.getMinutes()).append(" seconds=").append(this.getSeconds()).append(" timeStamp=").append(this.timeStamp).append("]").toString();
    }
}

