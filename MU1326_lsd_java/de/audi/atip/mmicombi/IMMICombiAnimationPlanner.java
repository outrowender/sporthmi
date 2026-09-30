/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.mmicombi.IMMICombiAnimationPlan;

public interface IMMICombiAnimationPlanner {
    public IMMICombiAnimationPlan computeAnimationPlan(int var1, int var2, int var3, int var4, int var5);

    public IMMICombiAnimationPlan getCurrentAnimationPlan();

    public void deactivateAnimationPlan();

    public void setSkin(int var1);
}

