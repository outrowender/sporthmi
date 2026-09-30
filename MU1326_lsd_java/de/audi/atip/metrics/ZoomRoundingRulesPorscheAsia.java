/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.RoundingRulesImpl;
import de.audi.atip.metrics.de.DistanceEntity;
import de.esolutions.fw.util.commons.Buffer;

public class ZoomRoundingRulesPorscheAsia
extends RoundingRulesImpl {
    private static final int FEET_PER_MILE = 5280;
    private static final int[][] METRIC_METER = new int[][]{{0, 35, 20}, {35, 62, 50}, {62, 87, 75}, {87, 125, 100}, {125, 175, 150}, {175, 250, 200}, {250, 350, 300}, {350, 450, 400}, {450, 625, 500}, {625, 875, 750}};
    private static final int[][] METRIC_KM = new int[][]{{875, 1250, 1000}, {1250, 1750, 1500}, {1750, 2250, 2000}, {2250, 2750, 2500}, {2750, 3500, 3000}, {3500, 4500, 4000}, {4500, 5500, 5000}, {5500, 6500, 6000}, {6500, 7500, 7000}, {7500, 8500, 8000}, {8500, 9500, 9000}, {9500, 12500, 10000}, {12500, 17500, 15000}, {17500, 25000, 20000}, {25000, 35000, 30000}, {35000, 45000, 40000}, {45000, 55000, 50000}, {55000, 65000, 60000}, {65000, 75000, 70000}, {75000, 85000, 80000}, {85000, 95000, 90000}, {95000, 112500, 100000}, {112500, 137500, 125000}, {137500, 162500, 150000}, {162500, 187500, 175000}, {187500, 225000, 200000}, {225000, 275000, 250000}, {275000, 350000, 300000}, {350000, 450000, 400000}, {450000, 550000, 500000}, {550000, 800000, 600000}, {800000, 1500000, 1000000}, {1500000, 2250000, 2000000}, {2250000, Integer.MAX_VALUE, 2500000}};
    private static final int[][] IMPERIAL_ASIA_YARDS = new int[][]{{0, 38, 20}, {38, 68, 50}, {68, 95, 75}, {95, 136, 100}, {136, 191, 150}, {191, 273, 200}, {273, 382, 300}, {382, 492, 440}, {492, 683, 586}, {683, 956, 880}, {956, 1367, 1320}};
    private static final int[][] IMPERIAL_ASIA_MILES = new int[][]{{1367, 1914, 1760}, {1914, 2461, 2200}, {2461, 3007, 2640}, {3007, 3828, 3080}, {3828, 4921, 4400}, {4921, 6015, 5280}, {6015, 7108, 6160}, {7108, 8202, 7920}, {8202, 9296, 8800}, {9296, 10389, 9680}, {10389, 13670, 10560}, {13670, 19138, 17600}, {19138, 27340, 26400}, {27340, 38276, 35200}, {38276, 49212, 44000}, {49212, 60149, 52800}, {60149, 71085, 70400}, {71085, 82021, 79200}, {82021, 92957, 88000}, {92957, 103893, 96800}, {103893, 123031, 105600}, {123031, 150371, 132000}, {150371, 177712, 158400}, {177712, 205052, 176000}, {205052, 246062, 220000}, {246062, 300743, 264000}, {300743, 382764, 308000}, {382764, 492125, 440000}, {492125, 601486, 528000}, {601486, 874888, 704000}, {874888, 1640415, 1320000}, {1640415, 2460623, 2200000}, {2460623, Integer.MAX_VALUE, 2640000}};

    public int roundMetric(int n, DistanceEntity distanceEntity) {
        int n2;
        int n3;
        int n4;
        int n5;
        this.log("roundMetric", n, "m");
        if (n < 0) {
            distanceEntity.setValues(0, 5);
            return 5;
        }
        if (n >= 0 && n < 875) {
            for (n5 = 0; n5 < METRIC_METER.length; ++n5) {
                n4 = METRIC_METER[n5][0];
                n3 = METRIC_METER[n5][1];
                n2 = METRIC_METER[n5][2];
                if (n < n4 || n >= n3) continue;
                distanceEntity.setValues(n2, 5);
                return 5;
            }
        }
        if (n >= METRIC_KM[1][0] && n < METRIC_KM[1][1]) {
            distanceEntity.setValues(1, 6, 5, 0);
            return 1;
        }
        if (n >= METRIC_KM[3][0] && n < METRIC_KM[3][1]) {
            distanceEntity.setValues(2, 6, 5, 0);
            return 1;
        }
        if (n >= 875 && n < 2250000) {
            for (n5 = 0; n5 < METRIC_KM.length; ++n5) {
                n4 = METRIC_KM[n5][0];
                n3 = METRIC_KM[n5][1];
                n2 = METRIC_KM[n5][2];
                if (n < n4 || n >= n3) continue;
                distanceEntity.setValues(n2 / 1000, 0);
                return 1;
            }
        }
        distanceEntity.setValues(2500, 0);
        return 1;
    }

    public int roundImperial(float f2, int n, DistanceEntity distanceEntity) {
        int n2;
        int n3;
        int n4;
        int n5;
        this.log("roundImperial", n, "yd");
        if (n < 0) {
            distanceEntity.setValues(0, 4);
            return 4;
        }
        if (n >= IMPERIAL_ASIA_YARDS[7][0] && n < IMPERIAL_ASIA_YARDS[7][1]) {
            return this.roundBy1_4Mile(IMPERIAL_ASIA_YARDS[7][2], distanceEntity);
        }
        if (n >= IMPERIAL_ASIA_YARDS[8][0] && n < IMPERIAL_ASIA_YARDS[8][1]) {
            return this.roundBy1_3Mile(IMPERIAL_ASIA_YARDS[8][2], distanceEntity);
        }
        if (n >= IMPERIAL_ASIA_YARDS[9][0] && n < IMPERIAL_ASIA_YARDS[9][1]) {
            return this.roundBy1_4Mile(IMPERIAL_ASIA_YARDS[9][2], distanceEntity);
        }
        if (n >= IMPERIAL_ASIA_YARDS[10][0] && n < IMPERIAL_ASIA_YARDS[10][1]) {
            return this.roundBy1_4Mile(IMPERIAL_ASIA_YARDS[10][2], distanceEntity);
        }
        if (n >= IMPERIAL_ASIA_MILES[1][0] && n < IMPERIAL_ASIA_MILES[1][1]) {
            return this.roundBy1_4Mile(IMPERIAL_ASIA_MILES[1][2], distanceEntity);
        }
        if (n >= IMPERIAL_ASIA_MILES[2][0] && n < IMPERIAL_ASIA_MILES[2][1]) {
            return this.roundBy1_4Mile(IMPERIAL_ASIA_MILES[2][2], distanceEntity);
        }
        if (n >= IMPERIAL_ASIA_MILES[3][0] && n < IMPERIAL_ASIA_MILES[3][1]) {
            return this.roundBy1_4Mile(IMPERIAL_ASIA_MILES[3][2], distanceEntity);
        }
        if (n >= IMPERIAL_ASIA_MILES[4][0] && n < IMPERIAL_ASIA_MILES[4][1]) {
            return this.roundBy1_4Mile(IMPERIAL_ASIA_MILES[4][2], distanceEntity);
        }
        if (n >= IMPERIAL_ASIA_MILES[6][0] && n < IMPERIAL_ASIA_MILES[6][1]) {
            return this.roundBy1_4Mile(IMPERIAL_ASIA_MILES[6][2], distanceEntity);
        }
        if (n >= IMPERIAL_ASIA_MILES[7][0] && n < IMPERIAL_ASIA_MILES[7][1]) {
            return this.roundBy1_4Mile(IMPERIAL_ASIA_MILES[7][2], distanceEntity);
        }
        if (n >= IMPERIAL_ASIA_MILES[9][0] && n < IMPERIAL_ASIA_MILES[9][1]) {
            return this.roundBy1_4Mile(IMPERIAL_ASIA_MILES[9][2], distanceEntity);
        }
        if (n >= 0 && n < 382) {
            for (n5 = 0; n5 < IMPERIAL_ASIA_YARDS.length; ++n5) {
                n4 = IMPERIAL_ASIA_YARDS[n5][0];
                n3 = IMPERIAL_ASIA_YARDS[n5][1];
                n2 = IMPERIAL_ASIA_YARDS[n5][2];
                if (n < n4 || n >= n3) continue;
                distanceEntity.setValues(n2, 4);
                return 4;
            }
        }
        if (n >= 1367) {
            for (n5 = 0; n5 < IMPERIAL_ASIA_MILES.length; ++n5) {
                n4 = IMPERIAL_ASIA_MILES[n5][0];
                n3 = IMPERIAL_ASIA_MILES[n5][1];
                n2 = IMPERIAL_ASIA_MILES[n5][2];
                if (n < n4 || n >= n3) continue;
                distanceEntity.setValues(n2 / 1760, 1);
                return 2;
            }
        }
        distanceEntity.setValues(1500, 7);
        return 2;
    }

    protected int roundBy5Miles(int n, DistanceEntity distanceEntity) {
        int n2 = Math.round((float)n / 1760.0f);
        n2 = this.round(n2, 5);
        distanceEntity.setValues(n2, 1);
        return 2;
    }

    protected int roundBy1Mile(int n, DistanceEntity distanceEntity) {
        int n2 = Math.round((float)n / 1760.0f);
        distanceEntity.setValues(n2, 1);
        return 2;
    }

    protected int roundBy1_4Mile(int n, DistanceEntity distanceEntity) {
        int n2 = (int)((float)n / 1760.0f);
        int n3 = (int)((float)n - (float)n2 * 1760.0f);
        int n4 = (int)((float)(n3 * 100) / 1760.0f);
        n4 = this.round(n4, 25);
        distanceEntity.setValues(n2, 7, n4, 1);
        return 2;
    }

    protected int roundBy1_3Mile(int n, DistanceEntity distanceEntity) {
        int n2 = (int)((float)n / 1760.0f);
        int n3 = (int)((float)n - (float)n2 * 1760.0f);
        int n4 = (int)((float)(n3 * 100) / 1760.0f);
        n4 = this.round(n4, 33);
        distanceEntity.setValues(n2, 7, n4, 1);
        return 2;
    }

    protected int roundBy1_4Mile_Feet(int n, DistanceEntity distanceEntity) {
        int n2 = n / 5280;
        int n3 = n - n2 * 5280;
        int n4 = n3 * 100 / 5280;
        n4 = this.round(n4, 25);
        distanceEntity.setValues(n2, 7, n4, 1);
        return 2;
    }

    protected int round(int n, int n2) {
        return (int)(Math.floor((float)n / (float)n2 + 0.5f) * (double)n2);
    }

    private void log(String string, int n, String string2) {
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("ZoomRoundingRulesPorscheAsia.");
            buffer.append(string);
            buffer.append("() distance:").append(n).append(string2);
            AbstractMetrics.println(buffer);
        }
    }
}

