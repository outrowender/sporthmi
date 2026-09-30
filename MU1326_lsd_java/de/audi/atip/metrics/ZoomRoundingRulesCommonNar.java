/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.RoundingRulesImpl;
import de.audi.atip.metrics.de.DistanceEntity;
import de.esolutions.fw.util.commons.Buffer;

public class ZoomRoundingRulesCommonNar
extends RoundingRulesImpl {
    public int roundMetric(int n, DistanceEntity distanceEntity) {
        int n2;
        this.log("roundMetric", n, "m");
        if (n <= 0) {
            n2 = 5;
            distanceEntity.setValues(0, 5);
        } else if (n < 95) {
            n2 = 5;
            distanceEntity.setValues(this.roundDistance(n, 10), 5);
        } else if (n < 400) {
            n2 = 5;
            distanceEntity.setValues(this.roundDistance(n, 50), 5);
        } else if (n < 950) {
            n2 = 5;
            distanceEntity.setValues(this.roundDistance(n, 100), 5);
        } else if (n < 9950) {
            n2 = 1;
            int n3 = (int)(Math.floor((double)n / 100.0 + 0.5) * 100.0);
            distanceEntity.setValues(n3 / 1000, 6, n3 % 1000 / 100, 0);
        } else {
            n2 = 1;
            int n4 = (int)(Math.floor((double)n / 1000.0 + 0.5) * 1000.0);
            distanceEntity.setValues(n4 / 1000, 0);
        }
        return n2;
    }

    public int roundImperial(float f2, int n, DistanceEntity distanceEntity) {
        int n2;
        this.log("roundImperial", n, "yd");
        float f3 = this.km2miles(f2);
        if (n <= 0) {
            n2 = 3;
            distanceEntity.setValues(0, 3);
        } else if (f3 < 0.25f) {
            n2 = 3;
            distanceEntity.setValues(this.roundDistance(n * 3, 100), 3);
        } else if (f3 < 0.95f) {
            n2 = this.roundMilesTo1_4(f3, distanceEntity);
        } else if (f3 < 2.95f) {
            n2 = this.roundMilesTo1_2(f3, distanceEntity);
        } else {
            n2 = 2;
            int n3 = Math.round(f3 * 10.0f);
            n3 = (int)Math.floor((double)n3 / 10.0 + 0.5);
            distanceEntity.setValues(n3, 1);
        }
        return n2;
    }

    private float km2miles(float f2) {
        return Distance.km2miles(f2);
    }

    private int roundMilesTo1_4(float f2, DistanceEntity distanceEntity) {
        int n;
        float f3 = (float)Math.round(f2 * 4.0f) / 4.0f;
        int n2 = Math.round((f3 - (float)(n = (int)Math.floor(f3))) * 100.0f);
        int n3 = n2 == 0 ? -1 : 7;
        distanceEntity.setValues(n, n3, n2, 1);
        return 2;
    }

    private int roundMilesTo1_2(float f2, DistanceEntity distanceEntity) {
        int n;
        float f3 = (float)Math.round(f2 * 2.0f) / 2.0f;
        int n2 = Math.round((f3 - (float)(n = (int)Math.floor(f3))) * 100.0f);
        int n3 = n2 == 0 ? -1 : 7;
        distanceEntity.setValues(n, n3, n2, 1);
        return 2;
    }

    private void log(String string, int n, String string2) {
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("ZoomRoundingRulesCommonNar.");
            buffer.append(string);
            buffer.append("() distance:").append(n).append(string2);
            AbstractMetrics.println(buffer);
        }
    }
}

