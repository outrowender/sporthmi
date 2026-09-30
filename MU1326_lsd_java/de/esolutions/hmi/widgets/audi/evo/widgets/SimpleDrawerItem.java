/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerIcon;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class SimpleDrawerItem
extends IconController
implements DrawerIcon,
AnimationListener {
    private AbstractAnimation animation;
    private int animationType = 54;
    private final float ANIMATION_TARGET;
    private float startOpacity;
    private float targetOpacity;
    private int mmiCombiSyncMode = 1;

    public SimpleDrawerItem() {
        this.ANIMATION_TARGET = 1000.0f;
    }

    public void showDrawerItem(boolean bl) {
        this.setVisible(true);
        this.setCompositesDirty(true);
        AbstractAnimation abstractAnimation = this.getAnimation();
        this.startOpacity = this.getRenderOpacity();
        this.targetOpacity = 1.0f;
        if (!bl) {
            this.setOpacity(this.targetOpacity);
            this.setVisible(this.targetOpacity > 0.0f);
            return;
        }
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, this.animationType, false, this);
        }
    }

    public void hideDrawerItem(boolean bl) {
        AbstractAnimation abstractAnimation = this.getAnimation();
        this.startOpacity = this.getRenderOpacity();
        this.targetOpacity = 0.0f;
        if (!bl) {
            this.setOpacity(this.targetOpacity);
            this.setVisible(this.targetOpacity > 0.0f);
            return;
        }
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, this.animationType, false, this);
        }
    }

    public void moveToBack() {
        this.hideDrawerItem(true, true);
    }

    public void moveToFront() {
        this.showDrawerItem(true, true);
    }

    private AbstractAnimation getAnimation() {
        if (this.animation == null) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(this.animationType);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    protected void destroyWidget() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        this.animation = null;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    public void animate(int n, float f2) {
        if (this.animationType == n) {
            AbstractAnimation abstractAnimation = this.getAnimation();
            float f3 = abstractAnimation.getProgress();
            float f4 = this.startOpacity + f3 * (this.targetOpacity - this.startOpacity);
            this.setOpacity(f4);
            this.setCompositesDirty(true);
        }
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        if (this.animationType == n) {
            float f2;
            this.startOpacity = f2 = this.targetOpacity;
            this.setOpacity(f2);
            if (f2 <= 0.0f) {
                this.setVisible(false);
            }
        }
    }

    public void setScreenChangeProgress(float f2) {
    }

    public void setScreenChangeTarget(int n) {
    }

    public void resetMainArea(boolean bl) {
        this.setVisible(true);
    }

    public void screenChangeFinished() {
    }

    public AbstractWidget getWidget() {
        return this;
    }

    public void setMMICombiSyncMode(int n) {
        this.mmiCombiSyncMode = n;
    }

    public int getMMICombiSyncMode() {
        return this.mmiCombiSyncMode;
    }

    public boolean isVisible() {
        return this.mmiCombiSyncMode != 2 && super.isVisible();
    }

    public void setAnimationType(int n) {
        this.animationType = n;
    }

    public void showDrawerItem(boolean bl, boolean bl2) {
    }

    public void hideDrawerItem(boolean bl, boolean bl2) {
    }

    public void setDrawerAnimationMask(int n) {
    }

    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    public void drawerSetDrawerAnimation(float[] fArray, float[] fArray2, int n) {
    }

    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
    }

    public int getDrawerAnimationMask() {
        return 0;
    }

    public void setTransitionForward(boolean bl) {
    }

    public boolean isTransitionForward() {
        return false;
    }

    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
    }

    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
    }

    public void setInitialState(int n) {
    }

    public void hideDrawerItem() {
    }

    public void setDrawerAnimationType(int n) {
    }
}

