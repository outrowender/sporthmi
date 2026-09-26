/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation.multicast;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.animation.multicast.AnimationRef;

public class AnimationRefCtrlObj {
    private AnimationRef m_animRef;
    private int m_timerInterval;

    public static AnimationRefCtrlObj newInstance(AnimationRef animationRef, int n) {
        AnimationRefCtrlObj animationRefCtrlObj = null;
        if (animationRef != null && n > 0) {
            animationRefCtrlObj = new AnimationRefCtrlObj();
            animationRefCtrlObj.m_animRef = animationRef;
            animationRefCtrlObj.m_timerInterval = n;
        }
        return animationRefCtrlObj;
    }

    private AnimationRefCtrlObj() {
    }

    public void start() {
        if (!this.isAnimationRunning()) {
            this.m_animRef.animationListener.m_progress = 0.0f;
            this.m_animRef.animationListener.m_value = 0;
            Object[] objectArray = this.m_animRef.animationListener.m_refKeySet.toArray();
            if (objectArray != null && objectArray.length > 0 && objectArray[0] instanceof AbstractWidget) {
                this.m_animRef.animation.startEndlessAnimation(this.m_timerInterval, (AbstractWidget)objectArray[0]);
            }
        }
    }

    public void stop() {
        if (this.m_animRef.refCount <= 1) {
            this.m_animRef.animation.stopAnimation();
            this.m_animRef.animationListener.m_progress = 0.0f;
            this.m_animRef.animationListener.m_value = 0;
        }
    }

    public boolean isAnimationRunning() {
        return this.m_animRef.animation.isAnimating();
    }

    public float getProgress() {
        return this.m_animRef.animationListener.m_progress;
    }

    public float getValue() {
        return this.m_animRef.animationListener.m_value;
    }
}

