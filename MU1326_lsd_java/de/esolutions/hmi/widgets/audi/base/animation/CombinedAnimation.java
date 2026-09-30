/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IMMICombiAnimationInfo;
import de.audi.atip.mmicombi.IMMICombiAnimationSyncer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;

public class CombinedAnimation
implements IAnimation,
AnimationListener {
    protected AnimationListener listener;
    protected boolean combined = false;
    protected int combinedTypeIndex = 0;
    protected int combinedType = 0;
    protected float[] combinedStarts;
    protected float[] combinedTargets;
    protected int[] combinedTypes;
    protected boolean[] combinedFadeIns;
    protected LogChannel logAnimation;
    protected int animationDirection = 1;
    protected AbstractAnimation nestedAnimation;
    protected AbstractAnimationController controller;
    protected AbstractWidget repaintTarget;
    private IMMICombiAnimationInfo combiSyncInfo;
    private boolean stopped = false;
    private float mainProgress = 0.0f;

    public CombinedAnimation(AbstractAnimationController abstractAnimationController) {
        this.controller = abstractAnimationController;
        this.logAnimation = IWidgetLogChannel.logAnimation;
    }

    public void animate(int n, float f2, int n2) {
        if (this.listener != null && this.combinedTypeIndex == 1) {
            this.listener.animate(n, f2, 0);
        }
    }

    public void animationStarted(int n, int n2) {
        if (this.listener != null) {
            this.listener.animationStarted(n, n2);
        }
    }

    public void animationFinished(int n, int n2) {
        block7: {
            block8: {
                if (!this.stopped && (this.combinedTypeIndex < this.combinedTypes.length - 1 || this.animationDirection != 1) && (this.combinedTypeIndex > 0 || this.animationDirection != 2)) break block8;
                this.logAnimation.log(10000000, "CombinedAnimation#animationFinished type: %1, combinedIndex: %2, direction: %3", (long)n, (long)this.combinedTypeIndex, (long)this.animationDirection);
                if (this.listener != null) {
                    this.listener.animationFinished(-1, 0);
                }
                if (this.combiSyncInfo == null) break block7;
                this.combiSyncInfo.setFinished(true);
                this.combiSyncInfo = null;
                break block7;
            }
            if (this.animationDirection == 1) {
                ++this.combinedTypeIndex;
                while (!this.startNestedAnimation()) {
                    ++this.combinedTypeIndex;
                    if (this.combinedTypeIndex < this.combinedTypes.length) continue;
                    if (this.combiSyncInfo != null) {
                        this.combiSyncInfo.setFinished(true);
                        this.combiSyncInfo = null;
                    }
                    if (this.listener == null) break;
                    this.listener.animationFinished(-1, 0);
                    break;
                }
            } else {
                --this.combinedTypeIndex;
                while (!this.startNestedAnimation()) {
                    --this.combinedTypeIndex;
                    if (this.combinedTypeIndex > -1) continue;
                    if (this.combiSyncInfo != null) {
                        this.combiSyncInfo.setFinished(true);
                        this.combiSyncInfo = null;
                    }
                    if (this.listener == null) break;
                    this.listener.animationFinished(-1, 0);
                    break;
                }
            }
        }
    }

    public void startScreenChangeAnimation(int[] nArray, boolean bl, IScreenData iScreenData, IScreenData iScreenData2) {
    }

    public void rollBackAnimation(boolean bl) {
        if (this.mainProgress >= 1.0f) {
            this.mainProgress = 0.0f;
        }
        for (int i2 = 0; i2 < this.combinedFadeIns.length; ++i2) {
            this.combinedFadeIns[i2] = !this.combinedFadeIns[i2];
        }
        for (int i3 = 0; i3 < this.combinedStarts.length; ++i3) {
            float f2 = this.combinedStarts[i3];
            this.combinedStarts[i3] = this.combinedTargets[i3];
            this.combinedTargets[i3] = f2;
        }
        this.animationDirection = this.animationDirection == 2 ? 1 : 2;
        if (this.nestedAnimation != null && this.nestedAnimation.isAnimating) {
            this.nestedAnimation.setFading(this.combinedFadeIns[this.combinedTypeIndex]);
            this.nestedAnimation.rollBackAnimation(bl);
        }
    }

    public void addListener(AnimationListener animationListener) {
        this.listener = animationListener;
    }

    public boolean isAnimating() {
        return this.nestedAnimation != null && this.nestedAnimation.isAnimating;
    }

    public void setBlocked(boolean bl) {
    }

    public boolean isBlocked() {
        return false;
    }

    public int getType() {
        return 0;
    }

    public int getCombiSyncType(int n) {
        return -1;
    }

    public void setCombiSyncInfo(IMMICombiAnimationInfo iMMICombiAnimationInfo) {
        this.combiSyncInfo = iMMICombiAnimationInfo;
    }

    public float getProgress() {
        if (this.nestedAnimation != null && this.nestedAnimation.isAnimating && this.combinedTypeIndex == 1) {
            this.mainProgress = this.nestedAnimation.getProgress();
        }
        return this.mainProgress;
    }

    public long getPlannedDuration() {
        return 0L;
    }

    public long getStartTime() {
        return 0L;
    }

    public long getCurrentDuration() {
        return 0L;
    }

    public boolean isFadeIn() {
        return false;
    }

    public int getCurrentAnimationStep() {
        return 0;
    }

    public void stopAnimation() {
        this.stopped = true;
        if (this.nestedAnimation != null && this.nestedAnimation.isAnimating) {
            this.nestedAnimation.stopAnimation();
        }
        if (this.combiSyncInfo != null) {
            this.combiSyncInfo.setFinished(true);
            this.combiSyncInfo = null;
        }
        if (this.listener != null) {
            this.listener.animationFinished(this.combinedType, 0);
        }
    }

    public boolean startCombinedAnimation(int n, float[] fArray, float[] fArray2, int[] nArray, boolean[] blArray, AbstractWidget abstractWidget) {
        this.combinedStarts = fArray;
        this.combinedTargets = fArray2;
        this.combinedTypes = nArray;
        this.combinedFadeIns = blArray;
        this.repaintTarget = abstractWidget;
        this.combined = true;
        this.stopped = false;
        this.combinedTypeIndex = 0;
        this.animationDirection = 1;
        this.mainProgress = 0.0f;
        IMMICombiAnimationSyncer iMMICombiAnimationSyncer = this.controller.getAnimationSyncer();
        if (iMMICombiAnimationSyncer != null && iMMICombiAnimationSyncer.isCombiSyncNeeded(n)) {
            iMMICombiAnimationSyncer.animationActivated(this);
        }
        while (!this.startNestedAnimation()) {
            ++this.combinedTypeIndex;
            if (this.combinedTypeIndex != nArray.length) continue;
            if (this.combiSyncInfo == null) break;
            this.combiSyncInfo.setFinished(true);
            this.combiSyncInfo = null;
            break;
        }
        return this.combinedTypeIndex < nArray.length;
    }

    private boolean startNestedAnimation() {
        this.nestedAnimation = (AbstractAnimation)this.controller.getIAnimation(this.combinedTypes[this.combinedTypeIndex]);
        this.nestedAnimation.addListener(this);
        if (this.nestedAnimation.isAnimationNeeded(this.combinedTypes[this.combinedTypeIndex])) {
            this.nestedAnimation.startDynamicAnimation(this.combinedStarts[this.combinedTypeIndex], this.combinedTargets[this.combinedTypeIndex], this.combinedTypes[this.combinedTypeIndex], this.combinedFadeIns[this.combinedTypeIndex], this.repaintTarget);
            return true;
        }
        return false;
    }

    public void setRepaintTarget(AbstractWidget abstractWidget) {
        this.repaintTarget = abstractWidget;
        if (this.nestedAnimation != null && this.nestedAnimation.isAnimating()) {
            this.nestedAnimation.setRepaintTarget(abstractWidget);
        }
    }
}

