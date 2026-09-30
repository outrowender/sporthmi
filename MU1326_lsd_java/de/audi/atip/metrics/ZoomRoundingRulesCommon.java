/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.RoundingRulesImpl;
import de.audi.atip.metrics.de.DistanceEntity;
import de.esolutions.fw.util.commons.Buffer;

public class ZoomRoundingRulesCommon
extends RoundingRulesImpl {
    public int roundImperial(float f2, int n, DistanceEntity distanceEntity) {
        int n2;
        this.log("roundImperial", n, "yd");
        if (n <= 0) {
            n2 = 4;
            distanceEntity.setValues(0, 4);
        } else if (n < 95) {
            n2 = 4;
            distanceEntity.setValues(this.roundDistance(n, 10), 4);
        } else if (n < 350) {
            n2 = 4;
            distanceEntity.setValues(this.roundDistance(n, 50), 4);
        } else if ((double)n < 1672.0) {
            n2 = 4;
            distanceEntity.setValues(this.roundDistance(n, 100), 4);
        } else if ((double)n < 17512.0) {
            n2 = 2;
            int n3 = Math.round(this.km2miles(f2) * 100.0f);
            n3 = (int)(Math.floor((double)n3 / 10.0 + 0.5) * 10.0);
            distanceEntity.setValues(n3 / 100, 7, n3 % 100 / 10, 1);
        } else {
            n2 = 2;
            int n4 = Math.round(this.km2miles(f2) * 10.0f);
            n4 = (int)Math.floor((double)n4 / 10.0 + 0.5);
            distanceEntity.setValues(n4, 1);
        }
        return n2;
    }

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

    private float km2miles(float f2) {
        return Distance.km2miles(f2);
    }

    private void log(String string, int n, String string2) {
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("ZoomRoundingRulesCommon.");
            buffer.append(string);
            buffer.append("() distance:").append(n).append(string2);
            AbstractMetrics.println(buffer);
        }
    }
}

