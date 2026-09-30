/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.hmi.view.IAnimation;

public interface IMMICombiAnimationInfo {
    public void setAnimation(IAnimation var1);

    public IAnimation getAnimation();

    public int getInternalAnimationType();

    public int getMMICombiSyncAnimationType(int var1);

    public long getPlannedDuration();

    public long getCurrentAnimationDuration();

    public void setPlannedStartTime(long var1);

    public long getPlannedStartTime();

    public long getRealStartTime();

    public boolean isRunning();

    public boolean isFinished();

    public String getAnnotation(int var1);

    public void setFinished(boolean var1);
}

