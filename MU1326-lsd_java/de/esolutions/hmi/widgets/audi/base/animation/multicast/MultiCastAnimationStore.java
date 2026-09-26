/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation.multicast;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.multicast.AnimationRef;
import de.esolutions.hmi.widgets.audi.base.animation.multicast.AnimationRefCtrlObj;

public class MultiCastAnimationStore {
    protected AnimationRef[] m_uniqueAnimations;

    public static synchronized MultiCastAnimationStore newInstance(HMITerminalImpl hMITerminalImpl, int[] nArray, int[] nArray2) {
        MultiCastAnimationStore multiCastAnimationStore = null;
        if (hMITerminalImpl != null && nArray != null && nArray2 != null && nArray.length > 0 && nArray.length == nArray2.length) {
            boolean bl = false;
            AnimationRef[] animationRefArray = new AnimationRef[nArray.length];
            for (int i2 = 0; i2 < animationRefArray.length; ++i2) {
                AbstractAnimation abstractAnimation = (AbstractAnimation)hMITerminalImpl.getIAnimationController().getIAnimation(1);
                animationRefArray[i2] = AnimationRef.newInstance(i2, nArray[i2], nArray2[i2], abstractAnimation);
                if (animationRefArray[i2] != null) continue;
                bl = true;
                break;
            }
            if (!bl) {
                multiCastAnimationStore = new MultiCastAnimationStore(animationRefArray);
            }
        }
        return multiCastAnimationStore;
    }

    private MultiCastAnimationStore(AnimationRef[] animationRefArray) {
        this.m_uniqueAnimations = animationRefArray;
    }

    public AnimationRefCtrlObj aquireAnimationRef(AnimationListener animationListener, int n) {
        AnimationRefCtrlObj animationRefCtrlObj = null;
        if (animationListener != null && n > -1 && n < this.m_uniqueAnimations.length) {
            AnimationRef animationRef = this.m_uniqueAnimations[n];
            animationRefCtrlObj = animationRef.animationControl;
            if (!animationRef.animationListener.m_refMap.containsKey(animationListener)) {
                ++animationRef.refCount;
                animationRef.animationListener.m_refMap.put(animationListener, animationRef);
            }
        }
        return animationRefCtrlObj;
    }

    public AnimationRefCtrlObj aquireAnimationRef(AnimationListener animationListener, AbstractWidget abstractWidget, int n) {
        AnimationRefCtrlObj animationRefCtrlObj = null;
        if (animationListener != null && n > -1 && n < this.m_uniqueAnimations.length) {
            AnimationRef animationRef = this.m_uniqueAnimations[n];
            animationRefCtrlObj = animationRef.animationControl;
            animationRef.putIfNotContained(animationListener, abstractWidget);
        }
        return animationRefCtrlObj;
    }

    public void releaseAnimationRef(AnimationListener animationListener, int n) {
        if (animationListener != null && n > -1 && n < this.m_uniqueAnimations.length) {
            AnimationRef animationRef = this.m_uniqueAnimations[n];
            AnimationRef animationRef2 = (AnimationRef)animationRef.animationListener.m_refMap.remove(animationListener);
            if (animationRef2 != null) {
                --animationRef.refCount;
                if (animationRef.refCount == 0) {
                    animationRef.animation.stopAnimation();
                }
            }
        }
    }
}

