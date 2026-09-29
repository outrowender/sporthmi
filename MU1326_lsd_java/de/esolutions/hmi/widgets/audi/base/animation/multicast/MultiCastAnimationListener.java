/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation.multicast;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.animation.multicast.AnimationRef;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MultiCastAnimationListener
implements AnimationListener {
    public HashMap m_refMap = new HashMap();
    public Set m_refKeySet = this.m_refMap.keySet();
    public AnimationRef m_animationRef = null;
    public int noSteps;
    public int m_value;
    public float m_progress;

    public static MultiCastAnimationListener newInstance(AnimationRef animationRef, int n) {
        return animationRef != null ? new MultiCastAnimationListener(animationRef, Math.max(1, Math.abs(n))) : null;
    }

    private MultiCastAnimationListener(AnimationRef animationRef, int n) {
        this.m_animationRef = animationRef;
        this.noSteps = n;
        this.m_progress = 0.0f;
        this.m_value = 0;
    }

    @Override
    public void animate(int n, float f2, int n2) {
        Iterator iterator = this.m_refKeySet.iterator();
        this.m_value = (this.m_value + 1) % this.noSteps;
        this.m_progress = MultiCastAnimationListener.norm1(0.0f, this.noSteps, this.m_value);
        while (iterator.hasNext()) {
            AnimationListener animationListener = (AnimationListener)iterator.next();
            animationListener.animate(n, this.m_value, this.m_animationRef.index);
        }
    }

    @Override
    public void animationStarted(int n, int n2) {
        Iterator iterator = this.m_refKeySet.iterator();
        while (iterator.hasNext()) {
            AnimationListener animationListener = (AnimationListener)iterator.next();
            animationListener.animationStarted(n, this.m_animationRef.index);
        }
    }

    @Override
    public void animationFinished(int n, int n2) {
        Iterator iterator = this.m_refKeySet.iterator();
        while (iterator.hasNext()) {
            AnimationListener animationListener = (AnimationListener)iterator.next();
            animationListener.animationFinished(n, this.m_animationRef.index);
        }
    }

    public static float norm1(float f2, float f3, float f4) {
        float f5 = 1.0f;
        if (f2 != f3) {
            float f6 = Math.min(f2, f3);
            float f7 = Math.max(f2, f3);
            f5 = (f4 - f6) / (f7 - f6);
        }
        return f5;
    }
}

