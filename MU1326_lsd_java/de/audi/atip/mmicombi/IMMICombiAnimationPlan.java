/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.mmicombi.IMMICombiAnimationInfo;
import java.util.List;

public interface IMMICombiAnimationPlan {
    default public int getStartTime() {
    }

    default public int getCombiDelay() {
    }

    default public int getHmiDelay() {
    }

    default public List getPlannedAnimations() {
    }

    default public String getAnnotation(int n) {
    }

    default public boolean isFinished() {
    }

    default public void addPlannedAnimation(IMMICombiAnimationInfo iMMICombiAnimationInfo) {
    }

    default public boolean isAnimationPartOfCurrentPlan(IAnimation iAnimation) {
    }

    default public void animationFinished(IMMICombiAnimationInfo iMMICombiAnimationInfo) {
    }

    default public boolean isActivationNeeded(IMMICombiAnimationInfo iMMICombiAnimationInfo) {
    }

    default public void setViewSizeRequestPending(boolean bl) {
    }

    default public void setSkin(int n) {
    }
}

