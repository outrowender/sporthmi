/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.car;

public interface ICarRemainingRangeListener {
    public static final int UNIT_KM = 0;
    public static final int UNIT_MI = 1;
    public static final int STATE_NOT_AVAILABLE = 0;
    public static final int STATE_INVALID = 1;
    public static final int STATE_VALID = 2;

    public void updateRemainingRange(int var1, int var2, int var3);
}

