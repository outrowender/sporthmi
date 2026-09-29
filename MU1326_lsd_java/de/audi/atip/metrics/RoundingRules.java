/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.de.DistanceEntity;

public interface RoundingRules {
    public static final int METERS;
    public static final int KM;
    public static final int YARDS;
    public static final int FOOT;
    public static final int MILES;
    public static final float YARDS_PER_MILE;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_UNIT_YARDS;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_SEPARATOR_MILES;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_UNIT_MILES;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_UNIT_METERS;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_SEPARATOR_KM;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_UNIT_KM;
    public static final int TEXT_CONSTANT_METRICS_DISTANCE_UNIT_FOOT;
    public static final int TEXT_CONSTANT_METRICS_NONE;

    default public int roundMetric(int n, DistanceEntity distanceEntity) {
    }

    default public int roundImperial(float f2, int n, DistanceEntity distanceEntity) {
    }
}

