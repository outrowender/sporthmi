/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.RoundingRulesImpl;
import de.audi.atip.metrics.de.DistanceEntity;
import de.esolutions.fw.util.commons.Buffer;

public class ZoomRoundingRulesPorscheEceRow
extends RoundingRulesImpl {
    private static final int FEET_PER_MILE = 5280;
    private static final int[][] METRIC_METER = new int[][]{{0, 40, 30}, {40, 62, 50}, {62, 87, 75}, {87, 125, 100}, {125, 175, 150}, {175, 250, 200}, {250, 350, 300}, {350, 450, 400}, {450, 625, 500}, {625, 875, 750}};
    private static final int[][] METRIC_KM = new int[][]{{875, 1250, 1000}, {1250, 1750, 1500}, {1750, 2500, 2000}, {2500, 3500, 3000}, {3500, 4500, 4000}, {4500, 6250, 5000}, {6250, 8750, 7500}, {8750, 12500, 10000}, {12500, 17500, 15000}, {17500, 25000, 20000}, {25000, 35000, 30000}, {35000, 45000, 40000}, {45000, 62500, 50000}, {62500, 87500, 75000}, {87500, 125000, 100000}, {125000, 175000, 150000}, {175000, 250000, 200000}, {250000, 400000, 300000}, {400000, 625000, 500000}, {625000, 875000, 750000}, {875000, 1250000, 1000000}, {1250000, Integer.MAX_VALUE, 1500000}};
    private static final int[][] IMPERIAL_UK_YARDS = new int[][]{{0, 40, 30}, {40, 62, 50}, {62, 87, 75}, {87, 125, 100}, {125, 175, 150}, {175, 250, 200}, {250, 370, 300}, {370, 660, 440}, {660, 1100, 880}, {1100, 1540, 1320}};
    private static final int[][] IMPERIAL_UK_MILES = new int[][]{{1540, 2200, 1760}, {2200, 3080, 2640}, {3080, 4400, 3520}, {4400, 6160, 5280}, {6160, 7920, 7040}, {7920, 9680, 8800}, {9680, 12320, 10560}, {12320, 15840, 14080}, {15840, 22000, 17600}, {22000, 30800, 26400}, {30800, 39600, 35200}, {39600, 57200, 44000}, {57200, 79200, 70400}, {79200, 110000, 88000}, {110000, 154000, 132000}, {154000, 220000, 176000}, {220000, 352000, 264000}, {352000, 550000, 440000}, {550000, 770000, 660000}, {770000, 1100000, 880000}, {1100000, 1540000, 1320000}, {1540000, Integer.MAX_VALUE, 1760000}};

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
        if (n < 0) {
            distanceEntity.setValues(0, 4);
            return 4;
        }
        if (n >= IMPERIAL_UK_YARDS[7][0] && n < IMPERIAL_UK_YARDS[7][1]) {
            return this.roundBy1_4Mile(IMPERIAL_UK_YARDS[7][2], distanceEntity);
        }
        if (n >= IMPERIAL_UK_YARDS[8][0] && n < IMPERIAL_UK_YARDS[8][1]) {
            return this.roundBy1_4Mile(IMPERIAL_UK_YARDS[8][2], distanceEntity);
        }
        if (n >= IMPERIAL_UK_YARDS[9][0] && n < IMPERIAL_UK_YARDS[9][1]) {
            return this.roundBy1_4Mile(IMPERIAL_UK_YARDS[9][2], distanceEntity);
        }
        if (n >= IMPERIAL_UK_MILES[1][0] && n < IMPERIAL_UK_MILES[1][1]) {
            return this.roundBy1_4Mile(IMPERIAL_UK_MILES[1][2], distanceEntity);
        }
        if (n >= 0 && n < 370) {
            for (n5 = 0; n5 < IMPERIAL_UK_YARDS.length; ++n5) {
                n4 = IMPERIAL_UK_YARDS[n5][0];
                n3 = IMPERIAL_UK_YARDS[n5][1];
                n2 = IMPERIAL_UK_YARDS[n5][2];
                if (n < n4 || n >= n3) continue;
                distanceEntity.setValues(n2, 4);
                return 4;
            }
        }
        if (n >= 1540 && n < 1540000) {
            for (n5 = 0; n5 < IMPERIAL_UK_MILES.length; ++n5) {
                n4 = IMPERIAL_UK_MILES[n5][0];
                n3 = IMPERIAL_UK_MILES[n5][1];
                n2 = IMPERIAL_UK_MILES[n5][2];
                if (n < n4 || n >= n3) continue;
                distanceEntity.setValues(n2 / 1760, 1);
                return 2;
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
            Buffer buffer = new Buffer().append("ZoomRoundingRulesPorscheEceRow.");
            buffer.append(string);
            buffer.append("() distance:").append(n).append(string2);
            AbstractMetrics.println(buffer);
        }
    }
}

