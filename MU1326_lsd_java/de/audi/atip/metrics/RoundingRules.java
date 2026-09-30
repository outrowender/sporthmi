/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.de.DistanceEntity;

public interface RoundingRules {
    public static final int METERS = 5;
    public static final int KM = 1;
    public static final int YARDS = 4;
    public static final int FOOT = 3;
    public static final int MILES = 2;
    public static final float YARDS_PER_MILE = 1760.0f;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_UNIT_YARDS = 4;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_SEPARATOR_MILES = 7;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_UNIT_MILES = 1;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_UNIT_METERS = 5;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_SEPARATOR_KM = 6;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_UNIT_KM = 0;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_UNIT_FOOT = 3;
    public static final int TEXT_CONSTANT_METRICS_NONE = -1;

    public int roundMetric(int var1, DistanceEntity var2);

    public int roundImperial(float var1, int var2, DistanceEntity var3);
}

