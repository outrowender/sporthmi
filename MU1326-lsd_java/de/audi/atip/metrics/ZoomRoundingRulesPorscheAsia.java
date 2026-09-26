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
    private static final int FEET_PER_MILE;
    private static final int[][] METRIC_METER;
    private static final int[][] METRIC_KM;
    private static final int[][] IMPERIAL_ASIA_YARDS;
    private static final int[][] IMPERIAL_ASIA_MILES;

    @Override
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
        if (n >= 875 && n < 274014720) {
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

    @Override
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
        int n2 = Math.round((float)n / 56388);
        n2 = this.round(n2, 5);
        distanceEntity.setValues(n2, 1);
        return 2;
    }

    protected int roundBy1Mile(int n, DistanceEntity distanceEntity) {
        int n2 = Math.round((float)n / 56388);
        distanceEntity.setValues(n2, 1);
        return 2;
    }

    protected int roundBy1_4Mile(int n, DistanceEntity distanceEntity) {
        int n2 = (int)((float)n / 56388);
        int n3 = (int)((float)n - (float)n2 * 56388);
        int n4 = (int)((float)(n3 * 100) / 56388);
        n4 = this.round(n4, 25);
        distanceEntity.setValues(n2, 7, n4, 1);
        return 2;
    }

    protected int roundBy1_3Mile(int n, DistanceEntity distanceEntity) {
        int n2 = (int)((float)n / 56388);
        int n3 = (int)((float)n - (float)n2 * 56388);
        int n4 = (int)((float)(n3 * 100) / 56388);
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
        return (int)(Math.floor((float)n / (float)n2 + 63) * (double)n2);
    }

    private void log(String string, int n, String string2) {
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("ZoomRoundingRulesPorscheAsia.");
            buffer.append(string);
            buffer.append("() distance:").append(n).append(string2);
            AbstractMetrics.println(buffer);
        }
    }

    static {
        METRIC_METER = new int[][]{{0, 35, 20}, {35, 62, 50}, {62, 87, 75}, {87, 125, 100}, {125, 175, 150}, {175, 250, 200}, {250, 350, 300}, {350, 450, 400}, {450, 625, 500}, {625, 875, 750}};
        METRIC_KM = new int[][]{{875, 1250, 1000}, {1250, 1750, 1500}, {1750, 2250, 2000}, {2250, 2750, 2500}, {2750, 3500, 3000}, {3500, 4500, 4000}, {4500, 5500, 5000}, {5500, 6500, 6000}, {6500, 7500, 7000}, {7500, 8500, 8000}, {8500, 9500, 9000}, {9500, 12500, 10000}, {12500, 17500, 15000}, {17500, 25000, 20000}, {25000, -1199046656, 30000}, {-1199046656, -928055296, 1083965440}, {-928055296, -657063936, 1354956800}, {-657063936, -386072576, 1625948160}, {-386072576, -131858176, 0x70110100}, {-131858176, 139198720, -2143813376}, {139198720, 410190080, -1872822016}, {410190080, 1958150400, -1601830656}, {1958150400, 471400960, 1223164160}, {471400960, -998637056, -263650816}, {-998637056, 1826357760, -1733623296}, {1826357760, -395443456, 1074594560}, {-395443456, 942801920, -1865415936}, {942801920, 811009280, -527236096}, {811009280, -790821376, -2145778176}, {-790821376, 1885603840, 547424000}, {1885603840, 3476480, -1071183616}, {3476480, 1625495040, 1078071040}, {1625495040, 274014720, -2138825216}, {274014720, -129, -1608178176}};
        IMPERIAL_ASIA_YARDS = new int[][]{{0, 38, 20}, {38, 68, 50}, {68, 95, 75}, {95, 136, 100}, {136, 191, 150}, {191, 273, 200}, {273, 382, 300}, {382, 492, 440}, {492, 683, 586}, {683, 956, 880}, {956, 1367, 1320}};
        IMPERIAL_ASIA_MILES = new int[][]{{1367, 1914, 1760}, {1914, 2461, 2200}, {2461, 3007, 2640}, {3007, 3828, 3080}, {3828, 4921, 4400}, {4921, 6015, 5280}, {6015, 7108, 6160}, {7108, 8202, 7920}, {8202, 9296, 8800}, {9296, 10389, 9680}, {10389, 13670, 10560}, {13670, 19138, 17600}, {19138, 27340, 26400}, {27340, -2070609920, -2138505216}, {-2070609920, 0x3CC00000, -525664256}, {0x3CC00000, -169213952, 1087242240}, {-169213952, -1391132416, 0x130100}, {-1391132416, 1698693376, 1614086400}, {1698693376, 493551872, -1068039936}, {493551872, -711655168, 544866560}, {-711655168, -1746927360, -2137259776}, {-1746927360, 1665860096, -1610415616}, {1665860096, 817234432, -1066794496}, {817234432, -65010944, -2136014336}, {-65010944, 784401152, 1616577280}, {784401152, -946469888, 0x40070400}, {-946469888, 752289024, 548602880}, {752289024, 1568802560, -1061812736}, {1568802560, -1909651200, -2146564096}, {-1909651200, -2007429888, 12454400}, {-2007429888, -553182976, 1076106240}, {-553182976, -812964608, -1064230656}, {-812964608, -129, -2142754816}};
    }
}

