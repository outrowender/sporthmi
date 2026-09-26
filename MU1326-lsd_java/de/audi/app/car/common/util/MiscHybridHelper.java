/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

public class MiscHybridHelper {
    public static final int BATTERY_CHARGE_MIN_LEVEL_0_SEGMENTS;
    public static final int BATTERY_CHARGE_MIN_LEVEL_1_SEGMENTS;
    public static final int BATTERY_CHARGE_MIN_LEVEL_2_SEGMENTS;
    public static final int BATTERY_CHARGE_MIN_LEVEL_3_SEGMENTS;
    public static final int BATTERY_CHARGE_MIN_LEVEL_4_SEGMENTS;
    public static final int BATTERY_CHARGE_MIN_LEVEL_5_SEGMENTS;
    public static final int BATTERY_CHARGE_MIN_LEVEL_6_SEGMENTS;
    public static final int BATTERY_CHARGE_MIN_LEVEL_7_SEGMENTS;
    public static final int BATTERY_CHARGE_MIN_LEVEL_8_SEGMENTS;
    public static final int BATTERY_CHARGE_MAX_LEVEL_8_SEGMENTS;

    private MiscHybridHelper() {
    }

    public static int getBatterySegmentForPercentage(int n) {
        if (n <= 100 && n >= 88) {
            return 8;
        }
        if (n < 88 && n >= 75) {
            return 7;
        }
        if (n < 75 && n >= 63) {
            return 6;
        }
        if (n < 63 && n >= 50) {
            return 5;
        }
        if (n < 50 && n >= 38) {
            return 4;
        }
        if (n < 38 && n >= 25) {
            return 3;
        }
        if (n < 25 && n >= 10) {
            return 2;
        }
        if (n < 10 && n >= 1) {
            return 1;
        }
        return 0;
    }
}

