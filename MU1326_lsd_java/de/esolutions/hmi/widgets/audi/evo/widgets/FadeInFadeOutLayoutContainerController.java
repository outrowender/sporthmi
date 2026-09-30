/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class FadeInFadeOutLayoutContainerController
extends LayoutContainerController
implements AnimationListener {
    private static final int TYPE_FADE = 0;
    private static final int TYPE_MOVE_LEFT = 1;
    private static final int TYPE_FADE_OUT_ONLY = 2;
    private static final int ANIMATION_FADE_IN = 1;
    private static final int ANIMATION_FADE_OUT = 2;
    private AbstractAnimation animation;
    private int currentAnimationID;
    private float animationValue;
    private int type;
    private int x0 = -1;

    public void animate(int n, float f2, int n2) {
        float f3;
        this.animationValue = f3 = f2 / 1000.0f;
        this.animation(this.currentAnimationID, f3);
    }

    private void animation(int n, float f2) {
        float f3 = n == 1 ? f2 : 1.0f - f2;
        switch (this.type) {
            case 0: 
            case 2: {
                mapOverlayLogCh.log(10000000, "VisibilityAnimationContainer#animation opacity = %1", (double)f3);
                this.setOpacity(f3);
                break;
            }
            case 1: {
                this.setX(this.x0 - (int)(f3 * (float)this.getWidth()));
                break;
            }
            default: {
                mapOverlayLogCh.log(10000, "FadeInFadeOutLayoutContainerController#animation unknown typ=%1 for animation", (long)this.type);
            }
        }
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        switch (this.currentAnimationID) {
            case 2: {
                mapOverlayLogCh.log(10000000, "VisibilityAnimationContainer#animation animationFinished");
                this.setVisibleInternal(false);
                break;
            }
        }
        if (this.type == 1) {
            int n3 = this.currentAnimationID == 1 ? 1 : 0;
            this.setX(this.x0 - n3 * this.getWidth());
        }
        this.currentAnimationID = -1;
    }

    public void connected(InitializationContext initializationContext) {
        if (this.type == 1) {
            if (this.x0 == -1) {
                this.x0 = this.getX();
            }
            if (this.isVisible()) {
                this.setX(this.x0 - this.getWidth());
            } else {
                this.setX(this.x0);
            }
        }
        super.connected(initializationContext);
        mapOverlayLogCh.log(10000000, "VisibilityAnimationContainer#connected isVisible = %1.", this.isVisible());
    }

    public void disconnecting() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.skipAnimation();
        }
        super.disconnecting();
    }

    private AbstractAnimation getAnimation(int n) {
        if (this.animation == null || this.animation.getType() != n) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(n);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    public void setTypeOfAnimation(int n) {
        this.type = n;
    }

    public void setVisible(boolean bl) {
        boolean bl2;
        if (!this.isConnected()) {
            super.setVisible(bl);
            return;
        }
        mapOverlayLogCh.log(10000000, "VisibilityAnimationContainer#setVisible isVisible = %1, visible = %2", this.isVisible(), bl);
        if (this.animation != null && this.animation.isAnimating()) {
            if (!(this.currentAnimationID == 1 && bl || this.currentAnimationID == 2 && !bl)) {
                mapOverlayLogCh.log(10000000, "VisibilityAnimationContainer#setVisible Stop animation.");
                this.skipAnimation();
            } else {
                mapOverlayLogCh.log(10000000, "VisibilityAnimationContainer#setVisible No state change. Return (1).");
                return;
            }
        }
        boolean bl3 = this.isVisible() && !bl;
        boolean bl4 = bl2 = !this.isVisible() && bl;
        if (bl3) {
            this.currentAnimationID = 2;
            this.startAnimation(95);
        } else if (bl2) {
            if (this.type != 2) {
                this.setOpacity(this.type == 0 ? 0.0f : 1.0f);
                this.setVisibleInternal(bl);
                this.currentAnimationID = 1;
                this.startAnimation(95);
            } else {
                this.setOpacity(1.0f);
                this.setVisibleInternal(bl);
            }
        }
    }

    private void setVisibleInternal(boolean bl) {
        mapOverlayLogCh.log(10000000, "VisibilityAnimationContainer#setVisibleInternal visible = %1", bl);
        super.setVisible(bl);
        this.setCompositesDirty(true);
    }

    public void setOpacity(float f2) {
        super.setOpacity(f2);
        mapOverlayLogCh.log(10000000, "VisibilityAnimationContainer#setOpacity opacity = %1", (double)f2);
    }

    private void startAnimation(int n) {
        if (this.animation == null || !this.animation.isAnimating()) {
            this.getAnimation(n);
            this.animation.startDynamicAnimation(0.0f, 1000.0f, n, false, this);
        } else if (this.animation.isAnimating()) {
            // empty if block
        }
    }

    private void skipAnimation() {
        if (this.animation != null && this.animation.isAnimating()) {
            mapOverlayLogCh.log(10000000, "VisibilityAnimationContainer#skipAnimation Last animation value was %1.", (double)this.animationValue);
            this.animation(this.currentAnimationID, 1.0f);
            this.animation.stopAnimation();
        }
    }
}

