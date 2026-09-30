/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.RoundingRules;

public interface RoundingRulesFactory {
    public RoundingRules getZoomRoundingRules();

    public RoundingRules getDistanceRoundingRules();

    public String getDiagnosisData();
}

