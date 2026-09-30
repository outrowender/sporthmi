/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IMMICombiAnimationInfo;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.WatchDog;
import de.audi.atip.util.Util;
import de.audi.tghu.fwhmi.evo.IRootWindowEvo;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationException;
import de.esolutions.hmi.widgets.audi.base.animation.IAnimationCurve;
import java.util.List;

public abstract class AbstractAnimation
implements IAnimation,
WidgetConstants,
AnimationListener,
IWidgetLogChannel {
    private static final int INITIAL_TIMER_DELAY = 1;
    private static final String DEBUG_TEXT_CURRENT_SCREEN = " current screen: ";
    private static final String DEBUG_TEXT_STEP = " step: ";
    private static final String DEBUG_TEXT_FADE_IN = " fade in: ";
    private static final String DEBUG_TEXT_ANIMATION_TYPE = "Animation type: ";
    private static final String DEBUG_TEXT_DELAY = " delay: ";
    private static final int SCREEN_CHANGE_TIMEOUT = 5000;
    private static final boolean SHOW_ANIMATION_STATISTICS = System.getProperty("showAnimationStatistics") != null;
    protected AnimationListener listener;
    protected Job animationStepJob = null;
    protected int type;
    protected volatile boolean isAnimating;
    protected boolean fadeIn;
    protected AbstractAnimationController controller;
    protected Screen animatedScreen;
    private WatchDog animationWatchDog;
    private long pureAnimationTime = 0L;
    private boolean blocked = false;
    protected int animationSteps;
    private IMMICombiAnimationInfo combiSyncInfo;
    protected IAnimationCurve animationCurve;
    private long animationStepStart;
    private long lastAnimationStepStart;
    protected long animationStart;
    protected long animationEnd;
    protected int endlessTimerIntervall;
    protected float start;
    protected float target;
    protected LogChannel logAnimation;
    private boolean blockTriggerRepaint = true;
    protected int plannedDuration = -1;
    private boolean isInitialized;

    public AbstractAnimation(IAnimationController iAnimationController) {
        this.controller = (AbstractAnimationController)iAnimationController;
        this.logAnimation = IWidgetLogChannel.logAnimation;
    }

    protected void initializeAnimation(float f2, float f3, int n, boolean bl, AbstractWidget abstractWidget) {
        this.animationStepStart = AbstractWidget.framework.getMonotonicTime();
        this.blocked = this.controller.isAnimationBlocked(n);
        if (this.blocked) {
            this.logAnimation.log(10000000, "Animation#initializeAnimation animations for type: %1 are blocked", (long)n);
        }
        this.type = n;
        if (abstractWidget.getInitContext() != null) {
            this.animatedScreen = abstractWidget.getInitContext().getScreen();
        } else {
            this.logAnimation.log(100000, "Animation#initializeAnimation cannot extract animated screen because no init context available");
        }
        this.start = f2;
        this.target = f3;
        this.fadeIn = bl;
        this.animationSteps = 0;
        this.animationCurve = this.createAnimationCurve();
        this.pureAnimationTime = 0L;
        this.animationCurve.initialize(f2, f3, 1);
        this.doCustomizedInitialization(abstractWidget);
        this.isInitialized = true;
    }

    protected void doCustomizedInitialization(AbstractWidget abstractWidget) {
    }

    public void cancelTimer(Timer timer) {
        this.logAnimation.log(1000000, "Animation#cancelTimer animation should already be finished, listener be informed and deactivated");
    }

    protected void deactivateAnimation(Exception exception) {
        this.setCombiSyncFinished();
        this.animationEnd = AbstractWidget.framework.getMonotonicTime();
        this.controller.deactivateAnimation(this.type, this, exception);
        this.plannedDuration = -1;
        this.isAnimating = false;
    }

    protected void activateAnimation() {
        this.controller.activateAnimation(this.type, this);
        this.isAnimating = true;
    }

    public void processAnimationStepEvent(boolean bl) {
        if (screenLogChannel.isDebug()) {
            this.logAnimation.log(10000000, "Animation#fireTimer for type: %1 on terminal: %2 called", (long)this.type, (long)this.controller.getTerminal().getTerminalID());
        }
        this.lastAnimationStepStart = this.animationStepStart;
        this.animationStepStart = AbstractWidget.framework.getMonotonicTime();
        int n = this.type;
        try {
            if (bl) {
                if (this.isAnimating) {
                    Buffer buffer = new Buffer(100);
                    buffer.append("Animation timed out!!!: Type: ").append(this.type);
                    buffer.append(" AnimationStart: ").append(this.animationStart);
                    buffer.append(" StartValue: ").append(this.animationCurve.getStart());
                    buffer.append(" CurrentValue: ").append(this.animationCurve.getValue());
                    this.logAnimation.log(10000, "Animation#fireTimer animation with type: %1 takes too long, probably high CPU-load, finish it now, startValue: %2 currentValue: %3", (double)this.type, (double)this.animationCurve.getStart(), (double)this.animationCurve.getValue());
                    this.doErrorHandling(new AnimationException(buffer.toString()));
                }
                return;
            }
            if (this.isAnimating) {
                if (this.animatedScreen != null && !this.animatedScreen.isConnected()) {
                    this.logAnimation.log(10000000, "Animation#fireTimer animatedScreen with id: %1 is not connected stopping animation", (long)this.animatedScreen.getID());
                    this.stopAnimation();
                } else {
                    ++this.animationSteps;
                    this.animationCurve.computeNextStep(this.animationStepStart, this.lastAnimationStepStart);
                    this.doAnimate();
                }
            }
        }
        catch (Exception exception) {
            this.doErrorHandling(exception);
        }
        long l = AbstractWidget.framework.getMonotonicTime() - this.animationStepStart;
        this.pureAnimationTime += l;
        this.logAnimation.log(10000000, "Animation#fireTimer step: %1 for type: %2 took : %3 ms", (long)this.animationSteps, (long)n, l);
    }

    protected void doErrorHandling(Exception exception) {
        if (this.controller.isScreenChangeType(this.type)) {
            try {
                this.doErrorHandlingForScreenChange();
                this.manageRepaint(true);
            }
            catch (RuntimeException runtimeException) {
                this.logAnimation.log(10000, "Animation: error handling errohandling for screenchange: %1, ex: %2", (long)this.type, (Throwable)exception);
            }
        }
        this.deactivateAnimation(exception);
        this.callAnimationFinished();
        if (this.controller.isScreenChangeType(this.type)) {
            try {
                AbstractWidget.hmiService.getEventDispatcherAdmin().unBlockScreenChangeDisturbingEvents();
                AbstractWidget.hmiService.getEventDispatcherAdmin().unBlockHardkeys();
            }
            catch (Exception exception2) {
                this.logAnimation.log(10000, "Animation: error handling errohandling for screenchange: %1, ex: %2", (long)this.type, (Throwable)exception2);
            }
        }
        if (exception != null) {
            this.logAnimation.log(10000, "Animation: error during animation with type: %1, ex: %2", (long)this.type, (Throwable)exception);
        }
    }

    protected void doErrorHandlingForScreenChange() {
    }

    protected void doAnimate() {
        if (this.animationCurve.isFinished()) {
            this.doSpecializedAnimation();
            this.stopSpecializedAnimation();
            this.finishAnimation();
            if (!this.isAnimating && SHOW_ANIMATION_STATISTICS) {
                this.showAnimationStatistics(true);
            }
        } else {
            this.doSpecializedAnimation();
            this.manageRepaint(false);
            this.adjustEventDelay();
            this.rescheduleAnimationEvent(false);
        }
    }

    private void adjustEventDelay() {
        long l;
        long l2 = AbstractWidget.framework.getMonotonicTime() - this.animationStepStart;
        if ((long)this.animationCurve.getTimerIntervall() - l2 < (long)this.getMinimumTimerIntervall()) {
            l = this.getMinimumTimerIntervall();
            if (screenLogChannel.isDebug()) {
                this.logAnimation.log(10000000, "Animation#adjustTimerDelay type: %1 minDelay: %2 next timer in %3", (long)this.type, (long)this.animationCurve.getTimerIntervall(), (long)this.getMinimumTimerIntervall());
            }
        } else {
            l = (long)this.getTimerIntervall() - l2;
            if (screenLogChannel.isDebug()) {
                this.logAnimation.log(10000000, "Animation#adjustTimerDelay type: %1 minDelay: %2 next timer in %3", (long)this.type, (long)this.animationCurve.getTimerIntervall(), (long)this.animationCurve.getTimerIntervall() - l2);
            }
        }
        if (null != this.animationStepJob) {
            AbstractAnimationStepEvent abstractAnimationStepEvent = (AbstractAnimationStepEvent)this.animationStepJob.getPayload();
            abstractAnimationStepEvent.setDelay(l);
        }
    }

    protected void manageRepaint(boolean bl) {
        this.paintRegisteredTargets();
        if (this.controller.drawForAnimation(this) || bl) {
            this.paintAndDrawStandardTarget();
        } else {
            this.paintStandardTarget();
        }
    }

    protected void paintStandardTarget() {
        if (this.animatedScreen != null) {
            if (this.animatedScreen.isConnected() && this.controller.paintForAnimation(this)) {
                this.logAnimation.log(10000000, "Animation#manageRepaint only painting for repaintTarget %1", (Object)this.animatedScreen);
                logRepaintCause.log(10000000, "Animation#paintStandardTarget: animation type: %2, paint standard target: %1", (Object)this.animatedScreen, (long)this.type);
                this.animatedScreen.paint();
            } else if (!this.controller.paintForAnimation(this)) {
                this.logAnimation.log(10000000, "Animation#manageRepaint not painting for screen with id %1 because highest prio animation will paint, current animation type %2", (long)this.animatedScreen.getID(), (long)this.type);
            } else {
                this.logAnimation.log(10000, "Animation#manageRepaint warning: screen with id is not conrected repaintTarget %1 , current animation type %2", (long)this.animatedScreen.getID(), (long)this.type);
            }
        } else {
            Screen screen = this.controller.getConnectedMainScreen();
            if (screen != null) {
                if (screen.isConnected()) {
                    this.logAnimation.log(10000000, "Animation#manageRepaint only painting for repaintTarget %1", (Object)screen);
                    logRepaintCause.log(10000000, "Animation#paintStandardTarget: animation type: %2, paint connected screen: %1", (Object)screen, (long)this.type);
                    screen.paint();
                } else {
                    this.logAnimation.log(10000, "Animation#manageRepaint warning: screen with id is not connected repaintTarget %1 , current animation type %2", (long)screen.getID(), (long)this.type);
                }
            } else {
                this.logAnimation.log(10000, "Animation#manageRepaint no repaintTarget available");
            }
        }
    }

    private void paintAndDrawStandardTarget() {
        if (this.animatedScreen != null) {
            if (this.animatedScreen.isConnected()) {
                this.logAnimation.log(10000000, "Animation#paintAndDrawStandardTarget drawing and painting for repaintTarget %1", (Object)this.animatedScreen);
                logRepaintCause.log(10000000, "Animation#paintAndDrawStandardTarget: trigger repaint. type: %2, animated screen: %1", (Object)this.animatedScreen, (long)this.type);
                this.paintRootWindow();
            } else {
                this.logAnimation.log(10000, "Animation#paintAndDrawStandardTarget not painting for repaintTarget %1, because it is not connected", (Object)this.animatedScreen);
            }
        } else {
            AbstractWidget abstractWidget = (AbstractWidget)((Object)this.controller.getConnectedMainScreen());
            if (abstractWidget != null) {
                this.logAnimation.log(10000000, "Animation#paintAndDrawStandardTarget drawing and painting for repaintTarget %1", (Object)abstractWidget);
                logRepaintCause.log(10000000, "Animation#paintAndDrawStandardTarget: trigger repaint. type: %2, connected screen: %1", (Object)abstractWidget, (long)this.type);
                this.paintRootWindow();
            } else {
                this.logAnimation.log(10000, "Animation#paintAndDrawStandardTarget no repaintTarget available");
            }
        }
    }

    private void paintRootWindow() {
        if (this.controller.getTerminal() != null) {
            this.controller.getTerminal().getRootWindow().repaint();
        } else {
            logChannel.log(10000, "Animation#paintAndDrawStandardTarget terminal is null repaint is ignored at screen with ID");
        }
    }

    private void paintRegisteredTargets() {
        List list = this.controller.getRegisteredPaintTargets();
        int n = list.size();
        if (n > 0) {
            Screen screen = this.animatedScreen;
            if (screen == null) {
                screen = this.controller.getConnectedMainScreen();
            }
            for (int i2 = 0; i2 < n; ++i2) {
                Screen screen2 = (Screen)list.get(i2);
                if (screen != null) {
                    if (Util.equals(screen2, screen)) continue;
                    if (screen2.isConnected()) {
                        this.logAnimation.log(10000000, "Animation#paintRegisteredTargets painting: %1", (Object)screen2);
                        logRepaintCause.log(10000000, "Animation#paintRegisteredTargets: animation type: %2, paint target: %1", (Object)screen2, (long)this.type);
                        screen2.paint();
                        continue;
                    }
                    this.logAnimation.log(100000, "Animation#paintRegisteredTargets not painting: %1 because it is not connected", (Object)screen2);
                    continue;
                }
                if (screen2.isConnected()) {
                    this.logAnimation.log(10000000, "Animation#paintRegisteredTargets painting: %1", (Object)screen2);
                    logRepaintCause.log(10000000, "Animation#paintRegisteredTargets: animation type: %2, paint target: %1", (Object)screen2, (long)this.type);
                    screen2.paint();
                    continue;
                }
                this.logAnimation.log(10000, "Animation#paintRegisteredTargets not painting: %1 because it is not connected", (Object)screen2);
            }
            this.controller.clearRegisteredPaintTargets();
        }
    }

    private void rescheduleAnimationEvent(boolean bl) {
        if (bl) {
            AbstractAnimationStepEvent abstractAnimationStepEvent = new AbstractAnimationStepEvent(1L){

                public void run() {
                    AbstractAnimation.this.processAnimationStepEvent(false);
                }
            };
            if (this.logAnimation.isDebug()) {
                abstractAnimationStepEvent.setDebugInfo(this.type, this.animationSteps, this.fadeIn, null != this.animatedScreen ? this.animatedScreen.getID() : Integer.MIN_VALUE);
            }
            this.animationStepJob = AbstractWidget.hmiService.getEventDispatcher().postEvent(abstractAnimationStepEvent, 1L);
            return;
        }
        this.animationStepJob.cancel();
        AbstractAnimationStepEvent abstractAnimationStepEvent = (AbstractAnimationStepEvent)this.animationStepJob.getPayload();
        if (this.logAnimation.isDebug()) {
            abstractAnimationStepEvent.setDebugInfo(this.type, this.animationSteps, this.fadeIn, null != this.animatedScreen ? this.animatedScreen.getID() : Integer.MIN_VALUE);
        }
        this.animationStepJob = AbstractWidget.hmiService.getEventDispatcher().postEvent(abstractAnimationStepEvent, abstractAnimationStepEvent.getDelay());
    }

    private void finishAnimation() {
        if (this.animationWatchDog != null) {
            this.animationWatchDog.cancel();
        }
        if (this.controller.isScreenChangeType(this.type)) {
            if (this.fadeIn || this.repaintAtFinish()) {
                this.manageRepaint(false);
            }
            this.deactivateAnimation(null);
            if (this.logAnimation.isDebug()) {
                this.logAnimation.log(10000000, "Animation#finishedAnimation  for type: %1, on terminal: %2", (long)this.type, (long)this.controller.getTerminal().getTerminalID());
                this.logAnimation.log(10000000, "Animation#finishedAnimation  steps: %1, consumed time: %2", (long)this.animationSteps, this.pureAnimationTime);
            }
            this.callAnimationFinished();
        } else {
            boolean bl = this.controller.drawForAnimation(this);
            this.deactivateAnimation(null);
            this.callAnimationFinished();
            this.manageRepaint(bl);
            if (this.logAnimation.isDebug()) {
                this.logAnimation.log(10000000, "Animation#finishedAnimation  for type: %1, on terminal: %2", (long)this.type, (long)this.controller.getTerminal().getTerminalID());
                this.logAnimation.log(10000000, "Animation#finishedAnimation  steps: %1, consumed time: %2", (long)this.animationSteps, this.pureAnimationTime);
            }
        }
    }

    private void setCombiSyncFinished() {
        if (this.combiSyncInfo != null) {
            this.combiSyncInfo.setFinished(true);
            this.combiSyncInfo = null;
        }
    }

    protected abstract void doSpecializedAnimation();

    protected abstract void stopSpecializedAnimation();

    protected boolean renderEachStep() {
        return this.controller.isScreenChangeType(this.type);
    }

    public void startDynamicAnimation(float f2, float f3, int n, boolean bl, AbstractWidget abstractWidget) {
        if (10000000 <= this.logAnimation.getCurrentLogThreshold()) {
            this.logAnimation.log(10000000, "Animation#startDynamicAnimation for type: %1, on terminal: %2", (long)n, (long)this.controller.getTerminal().getTerminalID());
            this.logAnimation.log(10000000, "Animation#startDynamicAnimation start: %1, target: %2", (Object)Float.toString(f2), (Object)Float.toString(f3));
        }
        this.initializeAnimation(f2, f3, n, bl, abstractWidget);
        long l = AbstractWidget.framework.getMonotonicTime();
        this.startAnimation();
        this.pureAnimationTime = AbstractWidget.framework.getMonotonicTime() - l;
        this.logAnimation.log(10000000, "Animation#startDynamicAnimation start for type: %1 took : %2 ms", (long)n, this.pureAnimationTime);
    }

    public void startEndlessAnimation(int n, AbstractWidget abstractWidget) {
        this.endlessTimerIntervall = n;
        this.startDynamicAnimation(0.0f, 1.0f, 1, true, abstractWidget);
    }

    private void startAnimation() {
        this.startSpezializedAnimation();
        if (!this.blocked) {
            this.rescheduleAnimationEvent(true);
        } else {
            this.logAnimation.log(10000000, "Animation#Animation with type: %1 not started because it is blocked", (long)this.type);
        }
        this.animationStart = AbstractWidget.framework.getMonotonicTime();
        this.activateAnimation();
        if (this.watchDogNeeded() && !this.blocked) {
            this.restartWatchdog();
        }
    }

    private void restartWatchdog() {
        if (this.animationWatchDog == null) {
            this.animationWatchDog = AbstractWidget.framework.getErrorMgr().createWatchDog(5000L, new AnimationTimeoutAlarm(), "Animation timed out! Type: " + this.type, 0, 3, 0, false);
        } else {
            this.animationWatchDog.restart();
        }
    }

    protected abstract boolean startSpezializedAnimation();

    private boolean watchDogNeeded() {
        return this.controller.isScreenChangeType(this.type);
    }

    public void stopAnimation() {
        if (this.animationStepJob != null) {
            this.animationStepJob.cancel();
        }
        if (this.animationWatchDog != null) {
            this.animationWatchDog.cancel();
        }
        this.checkForCustomizedStop();
        this.deactivateAnimation(null);
        this.callAnimationFinished();
        if (!this.controller.isAnimationRunning()) {
            this.checkMissingPaintAndDraw(false);
        }
    }

    private void callAnimationFinished() {
        if (this.listener != null) {
            logWidgetPerformance.log(1000000, "Animation#callAnimationFinished start, type: %2", (long)this.type);
            long l = AbstractWidget.framework.getMonotonicTime();
            this.listener.animationFinished(this.type, 0);
            long l2 = AbstractWidget.framework.getMonotonicTime();
            logWidgetPerformance.log(1000000, "Animation#callAnimationFinished finished, took %1 ms, animation type: %2", l2 - l, (long)this.type);
        }
    }

    protected void checkForCustomizedStop() {
    }

    private void checkMissingPaintAndDraw(boolean bl) {
        List list = this.controller.getRegisteredPaintTargets();
        int n = list.size();
        boolean bl2 = this.controller.getTerminal().getGUIManager().isDrawMissing();
        if (n > 0) {
            this.paintRegisteredTargets();
            bl2 = true;
        }
        if (bl2) {
            if (bl) {
                this.paintAndDrawStandardTarget();
            } else {
                ((IRootWindowEvo)this.controller.getTerminal().getRootWindow()).postRepaintEvent();
            }
        }
    }

    public void finishAnimationSynchronously() {
        if (this.isAnimating) {
            this.animationCurve.setFinished(true);
            this.doAnimate();
        }
    }

    public boolean isAnimating() {
        return this.isAnimating;
    }

    public void setTarget(float f2) {
        if (this.logAnimation.isDebug()) {
            this.logAnimation.log(10000000, "Animation#setTarget is called. previous target: %1 new target: %2", (Object)Float.toString(this.animationCurve.getTarget()), (Object)Float.toString(f2));
        }
        this.target = f2;
        this.animationCurve.setTarget(f2);
        if (null != this.animationStepJob) {
            AbstractAnimationStepEvent abstractAnimationStepEvent = (AbstractAnimationStepEvent)this.animationStepJob.getPayload();
            abstractAnimationStepEvent.setDelay(this.animationCurve.getTimerIntervall());
        }
    }

    public void setFading(boolean bl) {
        this.fadeIn = bl;
    }

    public boolean isFadeIn() {
        return this.fadeIn;
    }

    public float getTarget() {
        return this.animationCurve.getTarget();
    }

    public float getProgress() {
        return this.animationCurve.getProgress();
    }

    public void addListener(AnimationListener animationListener) {
        this.listener = animationListener;
    }

    public void removeListener() {
        this.listener = null;
    }

    protected void animateListener() {
        if (this.listener != null) {
            long l = (long)this.animationCurve.getProgress();
            this.logAnimation.log(10000000, "Animation#animateListener listener: %1", (Object)this.listener);
            this.logAnimation.log(10000000, "Animation#animateListener progress: %1", l);
            logWidgetPerformance.log(1000000, "Animation#animateListener start animate, type: %1, progress: %2", (long)this.type, l);
            long l2 = AbstractWidget.framework.getMonotonicTime();
            this.listener.animate(this.type, this.animationCurve.getValue(), 0);
            long l3 = AbstractWidget.framework.getMonotonicTime();
            logWidgetPerformance.log(1000000, "Animation#animateListener finished animate, took %1 ms, animation type: %2", l3 - l2, (long)this.type);
        } else {
            this.logAnimation.log(10000000, "Animation#animateListener no listener for animation registered");
        }
    }

    public void setController(AbstractAnimationController abstractAnimationController) {
        this.controller = abstractAnimationController;
    }

    protected abstract boolean repaintAtFinish();

    protected abstract IAnimationCurve createAnimationCurve();

    public void animate(int n, float f2, int n2) {
        this.animate(n, f2);
    }

    public void animate(int n, float f2) {
        this.animationCurve.setValue(f2);
        this.animateListener();
    }

    public void animationFinished(int n) {
        this.deactivateAnimation(null);
        this.callAnimationFinished();
    }

    public int getType() {
        return this.type;
    }

    protected void showAnimationStatistics(boolean bl) {
        if (!this.isAnimating) {
            String[] stringArray = new String[3];
            stringArray[0] = this.controller.getAnimationName(this.type);
            long l = AbstractWidget.framework.getMonotonicTime() - this.animationStart;
            stringArray[1] = "total time: " + l + "ms steps: " + this.animationSteps;
            float f2 = (float)this.animationSteps / ((float)(l + (long)this.animationCurve.getTimerIntervall()) / 1000.0f);
            stringArray[2] = "updates per second: " + f2;
            this.controller.getTerminal().getStatistics().showStatistics(2, stringArray, bl);
        }
    }

    protected abstract int getMinimumDelay();

    protected abstract int getMinimumTimerIntervall();

    public void setBlocked(boolean bl) {
        if (this.blocked && !bl) {
            this.logAnimation.log(10000000, "Animation#Animation with type: %1 is started now because it is unblocked", (long)this.type);
            this.animationStepStart = AbstractWidget.framework.getMonotonicTime();
            this.rescheduleAnimationEvent(true);
            this.restartWatchdog();
        }
        this.blocked = bl;
    }

    public IMMICombiAnimationInfo getCombiSyncInfo() {
        return this.combiSyncInfo;
    }

    public void setCombiSyncInfo(IMMICombiAnimationInfo iMMICombiAnimationInfo) {
        this.combiSyncInfo = iMMICombiAnimationInfo;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public long getPlannedDuration() {
        return this.animationCurve.getPlannedDuration();
    }

    public long getStartTime() {
        return this.animationStart;
    }

    public long getEndTime() {
        if (!this.isAnimating()) {
            return this.animationEnd;
        }
        return -1L;
    }

    public long getCurrentDuration() {
        return System.currentTimeMillis() - this.animationStart;
    }

    public int getCurrentAnimationStep() {
        return this.animationSteps;
    }

    public void rollBackAnimation(boolean bl) {
        if (bl) {
            this.logAnimation.log(10000000, "Animation#rollBackAnimation rollBack for type: %1", (long)this.type);
            if (this.animationCurve.getAnimationDirection() == 1) {
                this.animationCurve.setAnimationDirection(2);
            } else {
                this.animationCurve.setAnimationDirection(1);
            }
        }
    }

    public void setAnimationCurve(IAnimationCurve iAnimationCurve) {
        this.animationCurve = iAnimationCurve;
    }

    public float getValue() {
        return this.animationCurve.getValue();
    }

    public boolean isEndlessAnimation() {
        return this.type == 1;
    }

    public int getTimerIntervall() {
        return this.animationCurve.getTimerIntervall();
    }

    public boolean isAnimationNeeded(int n) {
        return true;
    }

    public boolean blocksRepaint() {
        return this.blockTriggerRepaint;
    }

    public void setBlockRepaint(boolean bl) {
        this.blockTriggerRepaint = bl;
    }

    public Screen getAnimatedScreen() {
        return this.animatedScreen;
    }

    public void setPlannedDuration(int n) {
        this.plannedDuration = n;
    }

    public void setRepaintTarget(AbstractWidget abstractWidget) {
        if (abstractWidget.getInitContext() != null) {
            this.animatedScreen = abstractWidget.getInitContext().getScreen();
        } else {
            this.logAnimation.log(10000, "Animation#setRepaintTarget cannot extract animated screen because no init context available");
        }
    }

    public boolean isInitialized() {
        return this.isInitialized;
    }

    private class AnimationTimeoutAlarm
    implements Runnable {
        private AnimationTimeoutAlarm() {
        }

        public void run() {
            AbstractWidget.hmiService.getEventDispatcher().postEvent(new AbstractAnimationStepEvent(1L){

                public void run() {
                    AbstractAnimation.this.processAnimationStepEvent(true);
                }

                public String toString() {
                    return "AnimationTimeoutEvent";
                }
            }, 1L);
        }
    }

    private static abstract class AbstractAnimationStepEvent
    extends ATIPEvent
    implements Runnable {
        private static final int EVENT_ID = 10552;
        private long delay;
        private int dbgCurrenScreen = Integer.MIN_VALUE;
        private int dbgStep = Integer.MIN_VALUE;
        private int dbgType = Integer.MIN_VALUE;
        private boolean dbgFadeIn = false;

        private AbstractAnimationStepEvent(long l) {
            super((ATIPEventListener)null, 10552);
        }

        public void dispatch() {
            this.run();
        }

        private long getDelay() {
            return this.delay;
        }

        private void setDelay(long l) {
            this.delay = l;
        }

        private void setDebugInfo(int n, int n2, boolean bl, int n3) {
            this.dbgFadeIn = bl;
            this.dbgType = n;
            this.dbgStep = n2;
            this.dbgCurrenScreen = n3;
        }

        public String toString() {
            if (this.dbgType > Integer.MIN_VALUE) {
                Buffer buffer = new Buffer(100);
                buffer.append(AbstractAnimation.DEBUG_TEXT_ANIMATION_TYPE).append(this.dbgType).append(AbstractAnimation.DEBUG_TEXT_FADE_IN).append(this.dbgFadeIn).append(AbstractAnimation.DEBUG_TEXT_STEP).append(this.dbgStep).append(AbstractAnimation.DEBUG_TEXT_DELAY).append(this.delay);
                if (this.dbgCurrenScreen > Integer.MIN_VALUE) {
                    buffer.append(AbstractAnimation.DEBUG_TEXT_CURRENT_SCREEN).append(this.dbgCurrenScreen);
                }
                return buffer.toString();
            }
            return "AnimationStepEvent";
        }
    }
}

