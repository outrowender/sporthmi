/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.RoundingRules;

public interface RoundingRulesFactory {
    default public RoundingRules getZoomRoundingRules() {
    }

    default public RoundingRules getDistanceRoundingRules() {
    }

    default public String getDiagnosisData() {
    }
}

