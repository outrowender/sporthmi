/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.mmicombi.IMMICombiAnimationPlan;

public interface IMMICombiAnimationPlanner {
    default public IMMICombiAnimationPlan computeAnimationPlan(int n, int n2, int n3, int n4, int n5) {
    }

    default public IMMICombiAnimationPlan getCurrentAnimationPlan() {
    }

    default public void deactivateAnimationPlan() {
    }

    default public void setSkin(int n) {
    }
}

