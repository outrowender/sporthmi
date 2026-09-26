/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.data;

public final class TimeStamp {
    public static final int UNKNOWN;
    private final int timeSeconds;

    public static TimeStamp getInstanceFromSeconds(int n) {
        return new TimeStamp(n);
    }

    private TimeStamp(int n) {
        this.timeSeconds = n;
    }

    public int getTimeInSeconds() {
        return this.timeSeconds;
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
        TimeStamp timeStamp = (TimeStamp)object;
        return this.timeSeconds == timeStamp.timeSeconds;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.timeSeconds;
        return n;
    }

    public String toString() {
        return new StringBuffer().append("Time [timeSeconds=").append(this.timeSeconds).append("]").toString();
    }
}

