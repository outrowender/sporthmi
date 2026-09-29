/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation.multicast;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.multicast.AnimationRefCtrlObj;
import de.esolutions.hmi.widgets.audi.base.animation.multicast.MultiCastAnimationListener;

public class AnimationRef {
    public int index;
    public int refCount;
    public AbstractAnimation animation;
    public MultiCastAnimationListener animationListener;
    public AnimationRefCtrlObj animationControl;

    public static AnimationRef newInstance(int n, int n2, int n3, AbstractAnimation abstractAnimation) {
        AnimationRef animationRef = null;
        if (n > -1 && n2 > -1 && n3 > -1 && abstractAnimation != null) {
            animationRef = new AnimationRef();
            animationRef.index = n;
            animationRef.refCount = 0;
            animationRef.animation = abstractAnimation;
            animationRef.animationListener = MultiCastAnimationListener.newInstance(animationRef, n3);
            if (animationRef.animationListener != null) {
                abstractAnimation.addListener(animationRef.animationListener);
                animationRef.animationControl = AnimationRefCtrlObj.newInstance(animationRef, n2);
                animationRef = animationRef.animationControl != null ? animationRef : null;
            }
        }
        return animationRef;
    }

    private AnimationRef() {
    }

    public void putIfNotContained(AnimationListener animationListener, AbstractWidget abstractWidget) {
        if (!this.animationListener.m_refMap.containsKey(animationListener)) {
            ++this.refCount;
            this.animationListener.m_refMap.put(animationListener, this);
            this.animation.setRepaintTarget(abstractWidget);
        }
    }
}

