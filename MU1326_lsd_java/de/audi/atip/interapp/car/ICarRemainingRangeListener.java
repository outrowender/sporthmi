/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.car;

public interface ICarRemainingRangeListener {
    public static final int UNIT_KM;
    public static final int UNIT_MI;
    public static final int STATE_NOT_AVAILABLE;
    public static final int STATE_INVALID;
    public static final int STATE_VALID;

    default public void updateRemainingRange(int n, int n2, int n3) {
    }
}

