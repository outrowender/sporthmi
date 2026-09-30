/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.BorderLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.OptionDrawerIcon;

public class OptionDrawerIconController
extends AbstractWidgetController
implements OptionDrawerIcon,
AnimationListener {
    private AbstractAnimation animation;
    private CompositeRenderer renderer;
    private CursorController cursor;
    private IconController icon;
    private int initialIconPositionY;
    private final int ANIMATION_TYPE;
    private final float ANIMATION_TARGET;
    private float startOpacity;
    private float targetOpacity;
    private int mmiCombiSyncMode = 1;

    public OptionDrawerIconController() {
        this.ANIMATION_TYPE = 55;
        this.ANIMATION_TARGET = 1000.0f;
    }

    public void showDrawerItem(boolean bl, boolean bl2) {
        this.startOpacity = this.getRenderOpacity();
        this.targetOpacity = 1.0f;
        if (!bl) {
            if (this.icon != null) {
                this.setLayout(this.initialIconPositionY, this.icon.getHeight());
            }
            this.setOpacity(this.targetOpacity);
            this.setVisible(this.targetOpacity > 0.0f);
            return;
        }
        this.setVisible(true);
        AbstractAnimation abstractAnimation = this.getAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, 55, false, this);
        }
    }

    private AbstractAnimation getAnimation() {
        if (this.animation == null) {
            this.animation = this.getAnimationController().getAnimation(55);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    private AnimationController getAnimationController() {
        return (AnimationController)this.getTerminal().getIAnimationController();
    }

    public void animate(int n, float f2) {
        if (n == 55) {
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
        if (n == 55) {
            float f2;
            this.startOpacity = f2 = this.targetOpacity;
            this.setOpacity(f2);
            this.setVisible(f2 > 0.0f);
        }
    }

    public void hideDrawerItem(boolean bl, boolean bl2) {
        this.startOpacity = this.getRenderOpacity();
        this.targetOpacity = 0.0f;
        if (!bl) {
            this.setOpacity(this.targetOpacity);
            this.setVisible(this.targetOpacity > 0.0f);
            return;
        }
        AbstractAnimation abstractAnimation = this.getAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, 55, false, this);
        }
    }

    public void setLayout(int n, int n2) {
        int n3;
        int n4;
        int n5 = BorderLayout.getMaxBorderWidth(this.width, n, n2);
        if (this.icon != null) {
            if (n5 >= 0) {
                this.icon.setVisible(true);
                int n6 = this.icon.getPreferredWidth();
                n4 = this.icon.getPreferredHeight();
                n3 = n + (n2 - n4) / 2;
                int n7 = this.width - n5 - n6 + 40;
                this.icon.setX(n7);
                this.icon.setY(n3);
            } else {
                this.icon.setVisible(false);
            }
        }
        if (this.cursor != null) {
            n4 = this.icon == null ? 0 : this.icon.getWidth();
            n3 = n5 + 20 + n4;
            this.cursor.setWidth(n3);
            this.cursor.setHeight(n2);
            this.cursor.setX(this.width - n3);
        }
        this.setCompositesDirty(true);
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(CompositeRenderer compositeRenderer) {
        this.renderer = compositeRenderer;
    }

    protected void destroyWidget() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        this.animation = null;
    }

    public void setIcon(IconController iconController) {
        this.icon = iconController;
        this.add(iconController);
        this.initialIconPositionY = iconController.getY();
        this.setLayout(this.initialIconPositionY, iconController.getHeight());
    }

    public void setCursor(CursorController cursorController) {
        this.cursor = cursorController;
        this.add(cursorController);
    }

    public void setMMICombiSyncMode(int n) {
        this.mmiCombiSyncMode = n;
    }

    public int getMMICombiSyncMode() {
        return this.mmiCombiSyncMode;
    }

    public void setAnimationType(int n) {
    }

    public void setScreenChangeProgress(float f2) {
    }

    public void setScreenChangeTarget(int n) {
    }

    public void screenChangeFinished() {
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

