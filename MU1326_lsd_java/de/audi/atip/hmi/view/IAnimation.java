/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.mmicombi.IMMICombiAnimationInfo;

public interface IAnimation {
    public static final float MIN_DIFFERENCE = 1.0E-7f;
    public static final int TYPE_NO_ANIMATION = 0;
    public static final int TYPE_ENDLESS_ANIMATION = 1;
    public static final int TYPE_WAIT_FADING = 2;

    public void startScreenChangeAnimation(int[] var1, boolean var2, IScreenData var3, IScreenData var4);

    public void rollBackAnimation(boolean var1);

    public void addListener(AnimationListener var1);

    public boolean isAnimating();

    public void setBlocked(boolean var1);

    public boolean isBlocked();

    public int getType();

    public int getCombiSyncType(int var1);

    public void setCombiSyncInfo(IMMICombiAnimationInfo var1);

    public float getProgress();

    public long getPlannedDuration();

    public long getStartTime();

    public long getCurrentDuration();

    public boolean isFadeIn();

    public int getCurrentAnimationStep();

    public void stopAnimation();
}

