/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class SignalQuality {
    private static final int MIN_STRENGTH = 0;
    private static final int MAX_STRENGTH = 100;
    private final int strengthPercent;

    public static SignalQuality getInstanceFromSignalStrengthPercent(int n) {
        return new SignalQuality(n);
    }

    private SignalQuality(int n) {
        this.strengthPercent = Math.max(0, Math.min(n, 100));
    }

    public int getStrengthPercent() {
        return this.strengthPercent;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.strengthPercent;
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
        SignalQuality signalQuality = (SignalQuality)object;
        return this.strengthPercent == signalQuality.strengthPercent;
    }

    public String toString() {
        return "SignalQuality [strengthPercent=" + this.strengthPercent + "]";
    }
}

