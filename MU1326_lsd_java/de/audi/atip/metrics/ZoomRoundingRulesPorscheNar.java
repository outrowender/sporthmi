/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.RoundingRulesImpl;
import de.audi.atip.metrics.de.DistanceEntity;
import de.esolutions.fw.util.commons.Buffer;

public class ZoomRoundingRulesPorscheNar
extends RoundingRulesImpl {
    private static final int FEET_PER_MILE = 5280;
    private static final int[][] METRIC_METER = new int[][]{{0, 40, 30}, {40, 62, 50}, {62, 87, 75}, {87, 125, 100}, {125, 175, 150}, {175, 250, 200}, {250, 350, 300}, {350, 450, 400}, {450, 625, 500}, {625, 875, 750}};
    private static final int[][] METRIC_KM = new int[][]{{875, 1250, 1000}, {1250, 1750, 1500}, {1750, 2500, 2000}, {2500, 3500, 3000}, {3500, 4500, 4000}, {4500, 6250, 5000}, {6250, 8750, 7500}, {8750, 12500, 10000}, {12500, 17500, 15000}, {17500, 25000, 20000}, {25000, 35000, 30000}, {35000, 45000, 40000}, {45000, 62500, 50000}, {62500, 87500, 75000}, {87500, 125000, 100000}, {125000, 175000, 150000}, {175000, 250000, 200000}, {250000, 400000, 300000}, {400000, 625000, 500000}, {625000, 875000, 750000}, {875000, 1250000, 1000000}, {1250000, Integer.MAX_VALUE, 1500000}};
    private static final int[][] IMPERIAL_US_FEET = new int[][]{{0, 125, 100}, {125, 225, 150}, {225, 375, 300}, {375, 525, 450}, {525, 700, 600}, {700, 900, 800}, {900, 1160, 1000}, {1160, 1980, 1320}, {1980, 3300, 2640}, {3300, 4620, 3960}};
    private static final int[][] IMPERIAL_US_MILES = new int[][]{{4620, 6600, 1760}, {6600, 9240, 2640}, {9240, 13200, 3520}, {13200, 18480, 5280}, {18480, 23760, 7040}, {23760, 29040, 8800}, {29040, 36960, 10560}, {36960, 47520, 14080}, {47520, 66000, 17600}, {66000, 92400, 26400}, {92400, 118800, 35200}, {118800, 171600, 44000}, {171600, 237600, 70400}, {237600, 330000, 88000}, {330000, 462000, 132000}, {462000, 660000, 176000}, {660000, 0x101D00, 264000}, {0x101D00, 1650000, 440000}, {1650000, 2310000, 660000}, {2310000, 3300000, 880000}, {3300000, 4620000, 1320000}, {4620000, Integer.MAX_VALUE, 1760000}};

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
        if (n >= METRIC_KM[6][0] && n < METRIC_KM[6][1]) {
            distanceEntity.setValues(7, 6, 5, 0);
            return 1;
        }
        if (n >= 875 && n < 1250000) {
            for (n5 = 0; n5 < METRIC_KM.length; ++n5) {
                n4 = METRIC_KM[n5][0];
                n3 = METRIC_KM[n5][1];
                n2 = METRIC_KM[n5][2];
                if (n < n4 || n >= n3) continue;
                distanceEntity.setValues(n2 / 1000, 0);
                return 1;
            }
        }
        distanceEntity.setValues(1500, 0);
        return 1;
    }

    public int roundImperial(float f2, int n, DistanceEntity distanceEntity) {
        int n2;
        int n3;
        int n4;
        int n5;
        this.log("roundImperial", n, "yd");
        int n6 = n * 3;
        if (n < 0) {
            distanceEntity.setValues(0, 3);
            return 3;
        }
        if (n6 >= IMPERIAL_US_FEET[7][0] && n6 < IMPERIAL_US_FEET[7][1]) {
            return this.roundBy1_4Mile_Feet(IMPERIAL_US_FEET[7][2], distanceEntity);
        }
        if (n6 >= IMPERIAL_US_FEET[8][0] && n6 < IMPERIAL_US_FEET[8][1]) {
            return this.roundBy1_4Mile_Feet(IMPERIAL_US_FEET[8][2], distanceEntity);
        }
        if (n6 >= IMPERIAL_US_FEET[9][0] && n6 < IMPERIAL_US_FEET[9][1]) {
            return this.roundBy1_4Mile_Feet(IMPERIAL_US_FEET[9][2], distanceEntity);
        }
        if (n6 >= IMPERIAL_US_MILES[1][0] && n6 < IMPERIAL_US_MILES[1][1]) {
            return this.roundBy1_4Mile(IMPERIAL_US_MILES[1][2], distanceEntity);
        }
        if (n6 >= 0 && n6 < 1160) {
            for (n5 = 0; n5 < IMPERIAL_US_FEET.length; ++n5) {
                n4 = IMPERIAL_US_FEET[n5][0];
                n3 = IMPERIAL_US_FEET[n5][1];
                n2 = IMPERIAL_US_FEET[n5][2];
                if (n6 < n4 || n6 >= n3) continue;
                distanceEntity.setValues(n2, 3);
                return 3;
            }
        }
        if (n6 >= 4620 && n6 < 4620000) {
            for (n5 = 0; n5 < IMPERIAL_US_MILES.length; ++n5) {
                n4 = IMPERIAL_US_MILES[n5][0];
                n3 = IMPERIAL_US_MILES[n5][1];
                n2 = IMPERIAL_US_MILES[n5][2];
                if (n6 < n4 || n6 >= n3) continue;
                return this.roundBy1Mile(n2, distanceEntity);
            }
        }
        distanceEntity.setValues(1000, 1);
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
            Buffer buffer = new Buffer().append("ZoomRoundingRulesPorscheNar.");
            buffer.append(string);
            buffer.append("() distance:").append(n).append(string2);
            AbstractMetrics.println(buffer);
        }
    }
}

