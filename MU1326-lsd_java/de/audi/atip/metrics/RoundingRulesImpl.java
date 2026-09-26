/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.RoundingRules;

public abstract class RoundingRulesImpl
implements RoundingRules {
    protected final int roundDistance(int n, int n2) {
        return Distance.roundDistance(n, n2);
    }
}

