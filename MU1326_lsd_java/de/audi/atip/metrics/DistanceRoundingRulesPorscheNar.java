/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.ZoomRoundingRulesPorscheEceRow;
import de.audi.atip.metrics.de.DistanceEntity;
import de.esolutions.fw.util.commons.Buffer;
import java.math.BigDecimal;

public class DistanceRoundingRulesPorscheNar
extends ZoomRoundingRulesPorscheEceRow {
    public int roundMetric(int n, DistanceEntity distanceEntity) {
        this.log("roundMetric", n, "m");
        if (n <= 0) {
            distanceEntity.setValues(0, 5);
            return 5;
        }
        if (n < 100) {
            int n2 = this.round(n, 10);
            distanceEntity.setValues(n2, 5);
            return 5;
        }
        if (n < 975) {
            int n3 = this.round(n, 50);
            distanceEntity.setValues(n3, 5);
            return 5;
        }
        if (n < 9950) {
            int n4 = (int)(Math.floor((double)n / 100.0 + 0.5) * 100.0);
            int n5 = this.roundDistance(n4, 100);
            int n6 = n5 / 1000;
            int n7 = n5 % 1000 / 100;
            distanceEntity.setValues(n6, 6, n7, 0);
            return 1;
        }
        int n8 = (int)(Math.floor((double)n / 1000.0 + 0.5) * 1000.0);
        int n9 = this.roundDistance(n8, 1000);
        distanceEntity.setValues(n9 / 1000, 0);
        return 1;
    }

    public int roundImperial(float f2, int n, DistanceEntity distanceEntity) {
        this.log("roundImperial", n, "ft");
        int n2 = n * 3;
        if (n <= 0) {
            distanceEntity.setValues(0, 3);
            return 3;
        }
        if (n2 < 1000) {
            distanceEntity.setValues(this.roundDistance(n2, 50), 3);
            return 3;
        }
        if (n2 < 1584) {
            distanceEntity.setValues(this.roundDistance(n2, 100), 3);
            return 3;
        }
        if (n2 < 52800) {
            return this.roundBy0_1Mile(n, distanceEntity);
        }
        return this.roundBy1Mile(n, distanceEntity);
    }

    private int roundBy0_1Mile(int n, DistanceEntity distanceEntity) {
        BigDecimal bigDecimal = new BigDecimal((float)n / 1760.0f).setScale(1, 4);
        int n2 = bigDecimal.intValue();
        int n3 = (int)(bigDecimal.doubleValue() * 10.0 - (double)(n2 * 10));
        distanceEntity.setValues(n2, 7, n3, 1);
        return 2;
    }

    private void log(String string, int n, String string2) {
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("DistanceRoundingRulesPorsche.");
            buffer.append(string);
            buffer.append("() distance:").append(n).append(string2);
            AbstractMetrics.println(buffer);
        }
    }
}

