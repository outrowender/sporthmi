/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceWidget;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FingerTraceController
extends AbstractWidgetController
implements AnimationListener,
ATIPEventListener,
IFingerTraceWidget {
    protected static final String FINGER_TRACE_FADE_OUT_TIMER_NAME = "FingerTraceFadeOutTimer";
    private static final int MIN_STROKE_LENGTH_AB3 = 100;
    private static final int MIN_STROKE_LENGTH_ALL_IN_TOUCH = 100;
    private static final int MIN_STROKE_LENGTH_TOUCHWHEEL = 250;
    private static final int TOUCH_RELEASE_TIMEOUT = 2500;
    private static final int TYPE_FINGER_TRACE_FADE_OUT = 103;
    private static final int DELAY_FADE_OUT_CHARACTER = 1000;
    private static final int DELAY_FADE_OUT_BACKSPACE = 500;
    private AbstractAnimation fingerTraceRepaintAnimation;
    private long lastTouchReleasedTime = -1L;
    private int minimalStrokeLength;
    private int lastTouchX = -1;
    private int lastTouchY = -1;
    private long fingerTraceLength = 0L;
    private boolean exceedMinStrokeLength = true;
    private IFingerTraceRenderer renderer;
    private boolean blockFingerTrace = false;
    private AbstractAnimation animationFadeOut;
    private Job fadeOutJob = null;
    private TimerEvent fadeOutEvent = null;
    private boolean isFadeOutJobRunning = false;
    private float peepholeTransparency = 0.0f;
    private float lastPeepholeTransparency = 0.0f;
    protected float lastOpacity = 0.0f;
    private float actualOpacity = 0.0f;
    private boolean canceledFadeOut = false;
    private boolean isTouchPadPressed;
    private List registeredFTListeners = new LinkedList();
    private final FingerTraceListener ftListenerNotifier = new FingerTraceListener(){

        public void onVisibilityChange() {
            Iterator iterator = FingerTraceController.this.registeredFTListeners.iterator();
            while (iterator.hasNext()) {
                ((FingerTraceListener)iterator.next()).onVisibilityChange();
            }
        }

        public void onFingerTraceHide() {
            Iterator iterator = FingerTraceController.this.registeredFTListeners.iterator();
            while (iterator.hasNext()) {
                ((FingerTraceListener)iterator.next()).onFingerTraceHide();
            }
        }
    };
    private float maxOpacity = 1.0f;

    public void initializeWidget() {
        this.initMinStrokeLength();
        this.lastOpacity = 0.0f;
        this.peepholeTransparency = 1.0f;
        this.lastPeepholeTransparency = 1.0f;
        this.actualOpacity = 0.0f;
        this.stopTouchRepaintAnimation();
    }

    private void initMinStrokeLength() {
        int n;
        if (this.terminal.getKbdService() != null) {
            n = this.terminal.getKbdService().getCurrentKeyboardType();
        } else {
            tpLogChannelInternal.log(100000, "FingerTraceWidget#connect: no KbdService available - use ALL_IN_TOUCH as default keyboard type");
            n = 6;
        }
        this.minimalStrokeLength = FingerTraceController.getMinStrokeLength(n);
    }

    private static int getMinStrokeLength(int n) {
        switch (n) {
            case 15: {
                return 100;
            }
            case 5: {
                return 250;
            }
            case 6: {
                return 100;
            }
        }
        return 100;
    }

    protected void handleFocusChanged(int n, int n2, int n3) {
        if (n != 1) {
            this.lastOpacity = 0.0f;
            this.lastPeepholeTransparency = 1.0f;
            return;
        }
        this.hideFingerTrace();
        if (this.isRenderer()) {
            this.renderer.clearLine();
        }
        this.stopTouchRepaintAnimation();
    }

    public void disconnecting() {
        this.blockFingerTrace = false;
        this.stopTouchRepaintAnimation();
        this.fingerTraceRepaintAnimation = null;
        this.stopFadeOutJob();
        this.stopAnimation(this.animationFadeOut);
        this.animationFadeOut = null;
        super.disconnecting();
    }

    public void animate(int n, float f2) {
        boolean bl;
        if (!this.isRenderer()) {
            return;
        }
        boolean bl2 = n == 1;
        boolean bl3 = this.lastTouchReleasedTime != -1L && framework.getMonotonicTime() - this.lastTouchReleasedTime > 2500L;
        boolean bl4 = !this.parent.isFocused();
        boolean bl5 = bl2 && bl3 || bl4;
        boolean bl6 = n == 103;
        boolean bl7 = bl = bl6 && this.animationFadeOut != null && this.isOpacityVisible();
        if (bl5) {
            tpLogChannelInternal.log(10000, "Clear Fingertrace because the timeout for waiting for a character has been exceeded");
            this.hideFingerTrace();
            this.parentCalculateCursorPosition();
            this.setCompositesDirty(true);
        } else if (bl) {
            float f3 = this.lastOpacity - this.animationFadeOut.getProgress();
            this.actualOpacity = Math.max(0.0f, f3);
            float f4 = this.lastPeepholeTransparency + this.animationFadeOut.getProgress();
            this.peepholeTransparency = Math.min(1.0f, f4);
            this.renderer.showFingerTrace(this.actualOpacity);
            this.setCompositesDirty(true);
            this.canceledFadeOut = this.isOpacityVisible();
        }
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    protected void startTouchRepaintAnimation() {
        if (this.fingerTraceRepaintAnimation == null) {
            this.fingerTraceRepaintAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(1);
            this.fingerTraceRepaintAnimation.addListener(this);
        }
        if (!this.fingerTraceRepaintAnimation.isAnimating()) {
            tpLogChannelInternal.log(10000000, "FingerTraceWidget#startFingerTraceRepaintAnimation");
            this.fingerTraceRepaintAnimation.startEndlessAnimation(50, this);
        }
    }

    protected void stopTouchRepaintAnimation() {
        this.lastOpacity = this.actualOpacity;
        this.lastPeepholeTransparency = this.peepholeTransparency;
        if (this.fingerTraceRepaintAnimation != null && this.fingerTraceRepaintAnimation.isAnimating()) {
            tpLogChannelInternal.log(10000000, "TouchController#stopFingerTraceRepaintAnimation");
            this.fingerTraceRepaintAnimation.stopAnimation();
        }
        this.resetMinStrokeLengthCalculation();
    }

    public boolean isMinStrokeReached() {
        return this.fingerTraceLength >= (long)this.minimalStrokeLength;
    }

    private void resetMinStrokeLengthCalculation() {
        this.lastTouchX = -1;
        this.lastTouchY = -1;
        this.exceedMinStrokeLength = false;
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        boolean bl;
        boolean bl2 = bl = n == 103 && !this.canceledFadeOut;
        if (bl) {
            this.hideFingerTrace();
        }
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    protected boolean isFadeOutJobRunning() {
        return this.isFadeOutJobRunning;
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        boolean bl;
        boolean bl2;
        if (this.isPresetPopupActive()) {
            return;
        }
        this.lastTouchReleasedTime = -1L;
        this.isTouchPadPressed = true;
        boolean bl3 = this.isFadeOutJobRunning();
        boolean bl4 = this.animationFadeOut != null && this.animationFadeOut.isAnimating();
        boolean bl5 = bl2 = (bl3 || bl4) && this.isRenderer();
        if (bl2) {
            this.stopFadeOutJob();
            this.stopAnimation(this.animationFadeOut);
            this.lastOpacity = this.actualOpacity;
            this.renderer.showFingerTrace(this.actualOpacity);
        }
        tpLogChannelInternal.log(10000000, "FingerTraceWidget#touchPadPressed: touch event recognized. (palm=%1 | fingerCount=%2)", touchEvent.isPalm(), (long)touchEvent.getFingerCount());
        boolean bl6 = bl = this.isRenderer() && touchEvent.getFingerCount() == 1;
        if (touchEvent.isPalm()) {
            this.abortFingerTrace();
            touchEvent.consume();
            return;
        }
        if (bl) {
            this.renderer.startLine(touchEvent.getX(), touchEvent.getY());
            this.lastTouchX = touchEvent.getX();
            this.lastTouchY = touchEvent.getY();
            this.setCompositesDirty(true);
            touchEvent.consume(false);
            this.startTouchRepaintAnimation();
            this.blockFingerTrace = false;
        } else if (touchEvent.getFingerCount() > 1) {
            if (this.isRenderer()) {
                this.renderer.clearLine();
            }
            this.stopTouchRepaintAnimation();
            touchEvent.consume();
            this.blockFingerTrace = true;
            this.abortFingerTrace();
            return;
        }
    }

    public void setEnabled(boolean bl) {
        if (!bl) {
            this.abortFingerTrace();
        }
        super.setEnabled(bl);
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (this.blockFingerTrace || this.isPresetPopupActive()) {
            return;
        }
        this.lastTouchReleasedTime = framework.getMonotonicTime();
        if (touchEvent.isPalm()) {
            this.abortFingerTrace();
            touchEvent.consume();
        } else if (touchEvent.getFingerCount() == 1) {
            if (!this.isRenderer()) {
                return;
            }
            this.addPoint(touchEvent);
            this.calculateStroke(touchEvent);
            this.fadeIn();
        } else if (touchEvent.getFingerCount() > 1) {
            this.abortFingerTrace();
        }
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        boolean bl;
        if (this.isPresetPopupActive()) {
            return;
        }
        tpLogChannelInternal.log(10000000, "FingerTraceWidget#touchPadReleased: touch event released recognized. (palm=%1)", touchEvent.isPalm());
        this.blockFingerTrace = false;
        this.lastTouchReleasedTime = framework.getMonotonicTime();
        this.lastOpacity = this.actualOpacity;
        this.lastPeepholeTransparency = this.peepholeTransparency;
        this.isTouchPadPressed = false;
        if (!this.isRenderer()) {
            return;
        }
        boolean bl2 = bl = touchEvent.getX() <= 0 || touchEvent.getY() <= 0;
        if (bl) {
            return;
        }
        if (touchEvent.isPalm() || touchEvent.getFingerCount() > 1) {
            this.abortFingerTrace();
            touchEvent.consume();
            return;
        }
    }

    private boolean isPresetPopupActive() {
        boolean bl;
        boolean bl2 = bl = this.terminal != null ? this.terminal.getTouchInputManager().isPresetPopupActive() : false;
        if (bl) {
            this.abortFingerTrace();
        }
        return bl;
    }

    private void parentCalculateCursorPosition() {
        this.ftListenerNotifier.onVisibilityChange();
    }

    private void abortFingerTrace() {
        tpLogChannelInternal.log(10000000, "FingerTraceWidget#abortFingerTrace");
        this.resetMinStrokeLengthCalculation();
        this.hideFingerTrace();
    }

    public float getPeepholeTransparency() {
        return this.peepholeTransparency;
    }

    public void hideFingerTrace() {
        if (this.isRenderer()) {
            this.renderer.removeFingerTrace();
        }
        this.lastPeepholeTransparency = 1.0f;
        this.peepholeTransparency = 1.0f;
        this.lastOpacity = 0.0f;
        this.actualOpacity = 0.0f;
        this.isTouchPadPressed = false;
        this.blockFingerTrace = true;
        this.stopTouchRepaintAnimation();
        this.stopAnimation(this.animationFadeOut);
        this.stopFadeOutJob();
        this.parentCalculateCursorPosition();
        this.fingerTraceLength = 0L;
        this.ftListenerNotifier.onFingerTraceHide();
    }

    private void stopAnimation(AbstractAnimation abstractAnimation) {
        if (abstractAnimation != null && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
        }
    }

    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
    }

    public void characterRecognized(char c2) {
        if (!this.isRenderer()) {
            return;
        }
        this.renderer.clearLine();
        this.setCompositesDirty(true);
        this.stopTouchRepaintAnimation();
        boolean bl = c2 == '\b';
        boolean bl2 = c2 != '\u0000';
        boolean bl3 = (bl || bl2) && this.isMinStrokeReached();
        long l = 0L;
        if (bl) {
            l = 500L;
        } else if (bl2) {
            l = 1000L;
        }
        if (bl3) {
            this.lastPeepholeTransparency = 1.0f;
            this.peepholeTransparency = 1.0f;
            this.restartJobFadeOut(l);
        } else if (this.isOpacityVisible()) {
            this.fadeOut();
        }
        this.fingerTraceLength = 0L;
    }

    public boolean exceededMinStrokeLength() {
        return this.exceedMinStrokeLength;
    }

    public boolean isLineVisible() {
        if (this.renderer == null) {
            return false;
        }
        return this.renderer.isFingerTraceVisible() || this.isTouchPadPressed;
    }

    public void setRenderer(IFingerTraceRenderer iFingerTraceRenderer) {
        this.renderer = iFingerTraceRenderer;
    }

    private void restartJobFadeOut(long l) {
        this.stopFadeOutJob();
        this.fadeOutEvent = new TimerEvent(this);
        this.fadeOutJob = framework.getHMIService().getEventDispatcher().postEvent(this.fadeOutEvent, l);
        this.isFadeOutJobRunning = true;
    }

    private void stopFadeOutJob() {
        tpLogChannelInternal.log(10000000, "TouchController#stopFadeOutJob");
        this.isFadeOutJobRunning = false;
        if (this.fadeOutEvent != null) {
            this.fadeOutEvent.consume();
            this.fadeOutEvent = null;
        }
        if (this.fadeOutJob != null) {
            this.fadeOutJob.cancel();
            this.fadeOutJob = null;
        }
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.fadeOutEvent)) {
            this.isFadeOutJobRunning = false;
            this.restartFadeOutAnimation();
        }
    }

    protected void restartFadeOutAnimation() {
        if (this.animationFadeOut == null) {
            this.animationFadeOut = (AbstractAnimation)this.getTerminal().getIAnimationController().getIAnimation(103);
            this.animationFadeOut.addListener(this);
        } else if (this.animationFadeOut.isAnimating()) {
            this.animationFadeOut.stopAnimation();
        }
        float f2 = this.lastOpacity;
        this.animationFadeOut.startDynamicAnimation(f2, 100.0f, 103, false, this);
        this.canceledFadeOut = false;
    }

    public final void registerFTListener(FingerTraceListener fingerTraceListener) {
        this.registeredFTListeners.add(fingerTraceListener);
    }

    public AbstractWidget toAbstractWidget() {
        return this;
    }

    public void writingModeEntered() {
    }

    private void fadeOut() {
        this.restartFadeOutAnimation();
    }

    private void fadeIn() {
        float f2 = this.lastOpacity + (float)this.fingerTraceLength / (float)this.minimalStrokeLength;
        this.actualOpacity = Math.min(1.0f, f2);
        float f3 = this.lastPeepholeTransparency - (float)this.fingerTraceLength / (float)this.minimalStrokeLength;
        this.peepholeTransparency = Math.max(0.0f, f3);
        this.renderer.showFingerTrace(this.actualOpacity);
    }

    private void calculateStroke(TouchEvent touchEvent) {
        int n = touchEvent.getX() - this.lastTouchX;
        int n2 = touchEvent.getY() - this.lastTouchY;
        this.lastTouchX = touchEvent.getX();
        this.lastTouchY = touchEvent.getY();
        this.fingerTraceLength = (long)((double)this.fingerTraceLength + Math.sqrt(n * n + n2 * n2));
        if (this.isMinStrokeReached()) {
            if (!this.exceedMinStrokeLength) {
                tpLogChannelKeypanel.log(10000000, "FingerTraceWidget#calculateStroke exceedMinStrokeLength=true");
            }
            this.exceedMinStrokeLength = true;
        }
    }

    public void setMaxOpacity(float f2) {
        this.maxOpacity = f2;
    }

    public float getMaxOpacity() {
        return this.maxOpacity;
    }

    private void addPoint(TouchEvent touchEvent) {
        this.renderer.addPoint(touchEvent.getX(), touchEvent.getY());
        this.setCompositesDirty(true);
        touchEvent.consume(false);
    }

    protected boolean isRenderer() {
        return this.getRenderer() != null;
    }

    private boolean isOpacityVisible() {
        return this.actualOpacity > 0.0f;
    }

    protected boolean isFadeOutAnimationRunning() {
        return this.animationFadeOut != null && this.animationFadeOut.isAnimating();
    }
}

