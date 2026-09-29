/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.mmicombi.IMMICombiAnimationInfo;

public interface IAnimation {
    public static final float MIN_DIFFERENCE;
    public static final int TYPE_NO_ANIMATION;
    public static final int TYPE_ENDLESS_ANIMATION;
    public static final int TYPE_WAIT_FADING;

    default public void startScreenChangeAnimation(int[] nArray, boolean bl, IScreenData iScreenData, IScreenData iScreenData2) {
    }

    default public void rollBackAnimation(boolean bl) {
    }

    default public void addListener(AnimationListener animationListener) {
    }

    default public boolean isAnimating() {
    }

    default public void setBlocked(boolean bl) {
    }

    default public boolean isBlocked() {
    }

    default public int getType() {
    }

    default public int getCombiSyncType(int n) {
    }

    default public void setCombiSyncInfo(IMMICombiAnimationInfo iMMICombiAnimationInfo) {
    }

    default public float getProgress() {
    }

    default public long getPlannedDuration() {
    }

    default public long getStartTime() {
    }

    default public long getCurrentDuration() {
    }

    default public boolean isFadeIn() {
    }

    default public int getCurrentAnimationStep() {
    }

    default public void stopAnimation() {
    }
}

