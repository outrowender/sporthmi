/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.hmi.view.IAnimation;

public interface IMMICombiAnimationInfo {
    default public void setAnimation(IAnimation iAnimation) {
    }

    default public IAnimation getAnimation() {
    }

    default public int getInternalAnimationType() {
    }

    default public int getMMICombiSyncAnimationType(int n) {
    }

    default public long getPlannedDuration() {
    }

    default public long getCurrentAnimationDuration() {
    }

    default public void setPlannedStartTime(long l) {
    }

    default public long getPlannedStartTime() {
    }

    default public long getRealStartTime() {
    }

    default public boolean isRunning() {
    }

    default public boolean isFinished() {
    }

    default public String getAnnotation(int n) {
    }

    default public void setFinished(boolean bl) {
    }
}

