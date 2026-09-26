/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$UserHintPartialPopupListenerImpl;

public final class TouchControllerListenerFactory$AnimationListenerImpl
implements AnimationListener {
    public static final int ANIMATION_TARGET_OPEN_SPELLER;
    public static final int ANIMATION_TYPE_OPEN_SPELLER;
    public static final int ANIMATION_TYPE_INFOLINE;
    public static final int ANIMATION_TYPE_CURSOR_BLINK;
    private AbstractAnimation cursorBlinkAnimation = null;
    private AbstractAnimation spellerOpenAnimation;
    private AbstractAnimation infoLineAnimation;
    private TouchController touchController = null;
    private float infoLineProgess = 0.0f;
    private float spellerOpenProgress = 0.0f;
    private float targetSpellerOpenProgress = 0.0f;
    private float startSpellerOpenProgress = 0.0f;
    private boolean focusFirstMenuLineAfterSpellerClose = false;

    private TouchControllerListenerFactory$AnimationListenerImpl(TouchController touchController) {
        this.touchController = touchController;
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        if (n == 77) {
            this.setSpellerOpenProgress(this.getTargetSpellerOpenProgress());
            this.touchController.updateSuggestions();
            this.touchController.calculateCursorPosition();
            if (this.isFocusFirstMenuLineAfterSpellerClose()) {
                this.touchController.focusFirstMenuLineAfterTouchfield();
            }
        } else if (n == 1) {
            this.touchController.setCursorOpacity(0.0f);
            this.touchController.setCompositesDirty(true);
        }
    }

    @Override
    public void animate(int n, float f2, int n2) {
        if (n == 77) {
            float f3 = this.spellerOpenAnimation.getProgress();
            this.setSpellerOpenProgress(TouchControllerListenerFactory$AnimationListenerImpl.getInterpolatedValue(this.getStartSpellerOpenProgress(), this.getTargetSpellerOpenProgress(), f3));
        } else if (n == 96) {
            this.setInfoLineProgress(f2);
            this.touchController.invalidateParentLayout();
            this.touchController.setCompositesDirty(true);
        } else if (n == 1) {
            HMITerminalImpl hMITerminalImpl = (HMITerminalImpl)this.touchController.getTerminal();
            if (hMITerminalImpl.getDrawerFocusManager().getDrawerState() != 16) {
                this.stopCursorBlinkAnimation();
                return;
            }
            this.calculateCursorOpacity();
            this.touchController.setCompositeDirty(0);
        }
    }

    public AbstractAnimation getCursorBlinkAnimation() {
        if (this.cursorBlinkAnimation == null) {
            this.cursorBlinkAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(1);
            this.cursorBlinkAnimation.setBlockRepaint(false);
            this.cursorBlinkAnimation.addListener(this);
        }
        return this.cursorBlinkAnimation;
    }

    public AbstractAnimation getSpellerOpenAnimation() {
        if (this.spellerOpenAnimation == null) {
            this.spellerOpenAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(77);
            this.spellerOpenAnimation.addListener(this);
        }
        return this.spellerOpenAnimation;
    }

    private AbstractAnimation getInfoLineAnimation() {
        if (this.infoLineAnimation == null) {
            this.infoLineAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(96);
            this.infoLineAnimation.addListener(this);
        }
        return this.infoLineAnimation;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.touchController.getTerminal().getIAnimationController();
    }

    private void disposeCursorBlinkAnimation() {
        TouchControllerListenerFactory$AnimationListenerImpl.stopAnimation(this.cursorBlinkAnimation);
        this.cursorBlinkAnimation = null;
    }

    private void disposeSpellerOpenAnimation() {
        TouchControllerListenerFactory$AnimationListenerImpl.stopAnimation(this.spellerOpenAnimation);
        this.spellerOpenAnimation = null;
    }

    private void disposeInfoLineAnimation() {
        TouchControllerListenerFactory$AnimationListenerImpl.stopAnimation(this.infoLineAnimation);
        this.infoLineAnimation = null;
    }

    public void stopCursorBlinkAnimation() {
        TouchControllerListenerFactory$AnimationListenerImpl.stopAnimation(this.cursorBlinkAnimation);
    }

    private void calculateCursorOpacity() {
        if (this.isSpellerOpening()) {
            this.touchController.setCursorOpacity(this.spellerOpenProgress);
            return;
        }
        if (this.isSpellerClosing()) {
            this.touchController.setCursorOpacity(1.0f - this.spellerOpenProgress);
            return;
        }
        if (this.touchController.getCursorOpacity() < 63) {
            this.touchController.setCursorOpacity(1.0f);
        } else {
            this.touchController.setCursorOpacity(0.0f);
        }
    }

    public boolean isSpellerClosing() {
        return this.targetSpellerOpenProgress == 0.0f && this.spellerOpenProgress > 0.0f && this.spellerOpenProgress <= 1.0f;
    }

    public boolean isSpellerOpening() {
        return this.targetSpellerOpenProgress == 1.0f && this.spellerOpenProgress >= 0.0f && this.spellerOpenProgress < 1.0f;
    }

    public boolean isSpellerFading() {
        return this.spellerOpenProgress > 0.0f && this.spellerOpenProgress < 1.0f;
    }

    private static void stopAnimation(AbstractAnimation abstractAnimation) {
        if (abstractAnimation != null && abstractAnimation.isAnimating()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchControllerAsAnimationListenerImp#stopAnimation: an animation will be stoppped (animationType=%1)", (long)abstractAnimation.getType());
            abstractAnimation.stopAnimation();
        }
    }

    private static float getInterpolatedValue(float f2, float f3, float f4) {
        return f2 + (f3 - f2) * f4;
    }

    public float getInfoLineProgress() {
        return this.infoLineProgess;
    }

    public boolean setInfoLineProgress(boolean bl, boolean bl2) {
        float f2;
        float f3 = f2 = bl ? 1.0f : 0.0f;
        if (f2 == this.infoLineProgess) {
            return false;
        }
        if (this.infoLineAnimation == null && !bl2) {
            return this.setInfoLineProgress(f2);
        }
        AbstractAnimation abstractAnimation = this.getInfoLineAnimation();
        if (!bl2) {
            if (abstractAnimation.isAnimating()) {
                abstractAnimation.stopAnimation();
            }
            return this.setInfoLineProgress(f2);
        }
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(f2);
        } else {
            abstractAnimation.startDynamicAnimation(this.infoLineProgess, f2, 96, bl, this.touchController);
        }
        return false;
    }

    public boolean setInfoLineProgress(float f2) {
        boolean bl = this.infoLineProgess != f2;
        this.infoLineProgess = f2;
        return bl;
    }

    public boolean isInfoLineAnimationRunning() {
        return this.infoLineAnimation != null && this.infoLineAnimation.isAnimating();
    }

    public float getSpellerOpenProgress() {
        return this.spellerOpenProgress;
    }

    public void setSpellerOpenProgress(float f2) {
        this.spellerOpenProgress = f2;
        this.touchController.handleSpellerOpenProgressChange(f2);
    }

    public float getTargetSpellerOpenProgress() {
        return this.targetSpellerOpenProgress;
    }

    public void setTargetSpellerOpenProgress(float f2) {
        this.targetSpellerOpenProgress = f2;
    }

    public float getStartSpellerOpenProgress() {
        return this.startSpellerOpenProgress;
    }

    public void setStartSpellerOpenProgress(float f2) {
        this.startSpellerOpenProgress = f2;
    }

    protected void startCursorBlinkAnimation() {
        if (!this.touchController.isEnabled() || TouchControllerListenerFactory$UserHintPartialPopupListenerImpl.access$000() || !this.touchController.isFocused()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchControllerAsAnimationListenerImp#startCursorBlinkAnimation: isEnabled=%1, isFocused=%2", this.touchController.isEnabled(), this.touchController.isFocused());
            return;
        }
        AbstractAnimation abstractAnimation = this.getCursorBlinkAnimation();
        if (!abstractAnimation.isAnimating()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchControllerAsAnimationListenerImp#startCursorBlinkAnimation: animation will be started");
            abstractAnimation.startEndlessAnimation(500, this.touchController);
        }
    }

    public void disconnecting() {
        this.disposeSpellerOpenAnimation();
        this.disposeInfoLineAnimation();
        this.disposeCursorBlinkAnimation();
        this.setTargetSpellerOpenProgress(0.0f);
    }

    public boolean isFocusFirstMenuLineAfterSpellerClose() {
        return this.focusFirstMenuLineAfterSpellerClose;
    }

    public void setFocusFirstMenuLineAfterSpellerClose(boolean bl) {
        this.focusFirstMenuLineAfterSpellerClose = bl;
    }

    /* synthetic */ TouchControllerListenerFactory$AnimationListenerImpl(TouchController touchController, TouchControllerListenerFactory$1 touchControllerListenerFactory$1) {
        this(touchController);
    }
}

