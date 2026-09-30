/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.mmicombi.IMMICombiAnimationInfo;
import java.util.List;

public interface IMMICombiAnimationPlan {
    public int getStartTime();

    public int getCombiDelay();

    public int getHmiDelay();

    public List getPlannedAnimations();

    public String getAnnotation(int var1);

    public boolean isFinished();

    public void addPlannedAnimation(IMMICombiAnimationInfo var1);

    public boolean isAnimationPartOfCurrentPlan(IAnimation var1);

    public void animationFinished(IMMICombiAnimationInfo var1);

    public boolean isActivationNeeded(IMMICombiAnimationInfo var1);

    public void setViewSizeRequestPending(boolean var1);

    public void setSkin(int var1);
}

