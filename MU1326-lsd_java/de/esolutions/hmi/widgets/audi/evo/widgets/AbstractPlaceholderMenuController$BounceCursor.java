/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;

public class AbstractPlaceholderMenuController$BounceCursor
implements AnimationListener,
ATIPEventListener {
    public static final int NO_BOUNCE;
    public static final int BOUNCE_TO_DEFLECTION;
    public static final int BOUNCE_AT_MAX_DEFLECTION;
    public static final int BOUNCE_TO_ORIGIN;
    public static final float BOUNCE_DEFLECTION_TARGET;
    public static final float BOUNCE_DEFLECTION_ORIGIN;
    protected int type;
    protected AbstractAnimation animation;
    protected float progress;
    protected int bounceMode = 0;
    protected TimerEvent maxDeflectionIdleTimer = new TimerEvent(this);
    protected Job maxDeflectionIdleJob;
    private static final int CURSOR_BOUNCE_NO_MOVE_DURATION;
    private final /* synthetic */ AbstractPlaceholderMenuController this$0;

    public AbstractPlaceholderMenuController$BounceCursor(AbstractPlaceholderMenuController abstractPlaceholderMenuController, int n) {
        this.this$0 = abstractPlaceholderMenuController;
        this.type = n;
    }

    public void disconnect() {
        this.cancelAnimation();
        this.cancelIdleTimer();
        this.bounceMode = 0;
        this.animation = null;
    }

    public void abortAnimation() {
        if (this.bounceMode != 0) {
            AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "AbstractPlaceholderMenuController#BounceCursor#abortAnimation aborting bounce animation with mode: %1", (long)this.bounceMode);
            if (this.bounceMode == 1) {
                this.bounceMode = 3;
                this.getCursorAnimation().rollBackAnimation(true);
            } else if (this.bounceMode == 2) {
                this.cancelIdleTimer();
                this.processEvent(null);
            }
        }
    }

    public void animate(int n, float f2) {
        this.progress = this.animation == null ? 1.0f : this.animation.getProgress();
        AbstractPlaceholderMenuController.access$500(this.this$0);
    }

    @Override
    public void animate(int n, float f2, int n2) {
        this.animate(n, n2);
    }

    @Override
    public void animationStarted(int n, int n2) {
        this.progress = this.animation.getProgress();
    }

    @Override
    public void animationFinished(int n, int n2) {
        if (this.bounceMode == 3) {
            AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "AbstractPlaceholderMenuController#BounceCursor#animationFinished bouncing animation finished");
            this.bounceMode = 0;
        } else if (this.bounceMode == 1) {
            AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "AbstractPlaceholderMenuController#BounceCursor#animationFinished bouncing reached max deflection");
            this.bounceMode = 2;
            this.restartIdleTimer();
        }
        AbstractPlaceholderMenuController.access$500(this.this$0);
    }

    public void cancelAnimation() {
        AbstractAnimation abstractAnimation = this.getCursorAnimation();
        if (abstractAnimation == null) {
            return;
        }
        abstractAnimation.stopAnimation();
    }

    public int getBounceMode() {
        return this.bounceMode;
    }

    protected AbstractAnimation getCursorAnimation() {
        if (this.animation != null) {
            return this.animation;
        }
        if (this.type < 0) {
            AbstractPlaceholderMenuController.access$400(this.this$0).log(10000, "AbstractPlaceholderMenuController#BounceCursor#getCursorAnimation cursorAnimationType not set");
            return null;
        }
        this.animation = (AbstractAnimation)this.this$0.getAnimationController().getIAnimation(this.type);
        this.animation.addListener(this);
        return this.animation;
    }

    public float getProgress() {
        return this.progress;
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    protected float getAnimationStart() {
        return this.bounceMode == 1 ? 0.0f : (float)31300;
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    protected float getAnimationTarget() {
        return this.bounceMode == 1 ? 31300 : (int)0.0f;
    }

    public void restartAnimation() {
        AbstractAnimation abstractAnimation = this.getCursorAnimation();
        if (null == abstractAnimation) {
            return;
        }
        if (this.bounceMode == 0) {
            AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "AbstractPlaceholderMenuController#BounceCursor#restartAnimation bounce direction set to deflection point");
            this.bounceMode = 1;
        } else if (this.bounceMode == 2) {
            this.restartIdleTimer();
            return;
        }
        if (!this.animation.isAnimating()) {
            AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "AbstractPlaceholderMenuController#BounceCursor#restartAnimation starting bounce animation");
            abstractAnimation.startDynamicAnimation(this.getAnimationStart(), this.getAnimationTarget(), this.type, false, this.this$0);
        }
    }

    public void cancelIdleTimer() {
        if (this.maxDeflectionIdleJob != null && !this.maxDeflectionIdleJob.isCanceled()) {
            this.maxDeflectionIdleJob.cancel();
        }
    }

    public void restartIdleTimer() {
        this.cancelIdleTimer();
        this.maxDeflectionIdleJob = AbstractWidget.hmiService.getEventDispatcher().postEvent(this.maxDeflectionIdleTimer, 0);
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        this.bounceMode = 3;
        AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "AbstractPlaceholderMenuController#BounceCursor#processEvent bounce direction set to origin point");
        this.restartAnimation();
    }
}

