/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.timer.Timer;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$1;

public class TouchControllerListenerFactory$TimerListenerImpl
implements ATIPEventListener {
    private static final long TIME_USER_HINT_DELETE_SPACE_IDLE_TIME;
    private boolean userHintIdleTimerFiredOnce;
    private Job userHintIdleJob = null;
    private TimerEvent userHintIdleEvent = null;
    private static final long SHOW_ICON_AFTER_FINGER_TRACE_CLEAN_DELAY_VALUE;
    private Job showIconAfterFingerTraceCleanDelayJob = null;
    private TimerEvent showIconAfterFingerTraceCleanDelayEvent = null;
    private boolean showIconAfterFingerTraceCleanDelayJobRunning = false;
    private static final long TIME_LONG_PRESS;
    private Job hkBackLongPressJob = null;
    private TimerEvent hkBackLongPressEvent = null;
    private boolean hkBackLongPressJobRunning = false;
    private final TouchController touchController;

    private TouchControllerListenerFactory$TimerListenerImpl(TouchController touchController) {
        this.touchController = touchController;
        this.userHintIdleTimerFiredOnce = false;
    }

    private void initUserHintIdleJob() {
        this.userHintIdleEvent = new TimerEvent(this);
        this.userHintIdleJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.userHintIdleEvent, 0);
    }

    private void initShowIconJob() {
        this.showIconAfterFingerTraceCleanDelayEvent = new TimerEvent(this);
        this.showIconAfterFingerTraceCleanDelayJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.showIconAfterFingerTraceCleanDelayEvent, 0);
    }

    public final Job getUserHintIdleJob() {
        return this.userHintIdleJob;
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchControllerListenerFactory.TimerListenerImpl#fireTimer: timer fired");
        if (aTIPEvent.equals(this.hkBackLongPressEvent)) {
            this.hkBackLongPressJobRunning = false;
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchController#fireTimer: delete whole textfield because of longPressed HK_BACK");
            this.touchController.handleHKBackLongPress();
            IWidgetLogChannel.logRepaintCause.log(-2137614336, "TouchControllerListenerFactory.TimerListenerImpl#fireTimer: hkBack long press timer. trigger repaint. screen: %1", (long)this.touchController.getScreenId());
            this.touchController.triggerRepaint();
        } else if (aTIPEvent.equals(this.userHintIdleEvent) && !this.touchController.getInputData().isEmpty() && this.touchController.isFocused()) {
            this.userHintIdleTimerFiredOnce = true;
            this.touchController.showUserHintAnimation(76);
        } else if (aTIPEvent.equals(this.showIconAfterFingerTraceCleanDelayEvent)) {
            this.showIconAfterFingerTraceCleanDelayJobRunning = false;
            this.touchController.iconDelayEventFired();
        }
    }

    public void cancelTimer(Timer timer) {
    }

    private void stopJob(Job job) {
        if (job != null) {
            job.cancel();
            if (job.equals(this.showIconAfterFingerTraceCleanDelayJob)) {
                this.showIconAfterFingerTraceCleanDelayJobRunning = false;
            }
            if (job.equals(this.hkBackLongPressJob)) {
                this.hkBackLongPressJobRunning = false;
            }
        }
    }

    private boolean isJobRunning(Job job) {
        if (job != null) {
            if (job.equals(this.showIconAfterFingerTraceCleanDelayJob)) {
                return this.showIconAfterFingerTraceCleanDelayJobRunning;
            }
            if (job.equals(this.hkBackLongPressJob)) {
                return this.hkBackLongPressJobRunning;
            }
        }
        return false;
    }

    public final void stopShowIconAfterFingerTraceCleanDelayJob() {
        this.stopJob(this.showIconAfterFingerTraceCleanDelayJob);
    }

    private final void disposeHKBackLongPressJob() {
        this.stopJob(this.hkBackLongPressJob);
        this.hkBackLongPressJob = null;
    }

    private final void disposeShowIconAfterFingerTraceCleanDelayTimer() {
        this.stopJob(this.showIconAfterFingerTraceCleanDelayJob);
        this.showIconAfterFingerTraceCleanDelayJob = null;
    }

    private final void disposeUserHintIdleTimer() {
        this.stopJob(this.userHintIdleJob);
        this.userHintIdleJob = null;
    }

    public final void stopHKBackLongPressTimer() {
        this.stopJob(this.hkBackLongPressJob);
    }

    public final void stopUserHintIdleJob() {
        this.stopJob(this.userHintIdleJob);
    }

    public final void startHKBackLongPressJobIfNotRunning() {
        if (!this.isJobRunning(this.hkBackLongPressJob)) {
            this.hkBackLongPressJobRunning = true;
            this.hkBackLongPressEvent = new TimerEvent(this);
            this.hkBackLongPressJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.hkBackLongPressEvent, 0);
        }
    }

    public final void restartShowIconAfterFingerTraceCleanDelayTimer() {
        if (this.showIconAfterFingerTraceCleanDelayJob == null) {
            this.initShowIconJob();
        }
        if (this.showIconAfterFingerTraceCleanDelayJob != null) {
            this.showIconAfterFingerTraceCleanDelayJob.cancel();
            this.showIconAfterFingerTraceCleanDelayEvent = new TimerEvent(this);
            this.showIconAfterFingerTraceCleanDelayJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.showIconAfterFingerTraceCleanDelayEvent, 0);
            this.showIconAfterFingerTraceCleanDelayJobRunning = true;
            this.touchController.calculateCursorPosition();
        }
    }

    public final void restartUserHintIdleTimer() {
        if (this.userHintIdleJob == null) {
            this.initUserHintIdleJob();
        }
        if (this.userHintIdleJob != null) {
            this.userHintIdleJob.cancel();
            if (this.userHintIdleEvent != null) {
                this.userHintIdleEvent.consume();
                this.userHintIdleEvent = null;
            }
            this.userHintIdleEvent = new TimerEvent(this);
            this.userHintIdleJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.userHintIdleEvent, 0);
        }
    }

    public final boolean isHKBackLongPressJobRunning() {
        return this.isJobRunning(this.hkBackLongPressJob);
    }

    public final boolean isShowIconAfterFingerTraceCleanDelayJobRunning() {
        return this.isJobRunning(this.showIconAfterFingerTraceCleanDelayJob);
    }

    public final void cancelHKBackLongPressTimer() {
        this.stopJob(this.hkBackLongPressJob);
    }

    public final boolean hasUserHintIdleTimerFiredOnce() {
        return this.userHintIdleTimerFiredOnce;
    }

    public final void preDisconnecting() {
        this.disposeUserHintIdleTimer();
    }

    public void disconnecting() {
        this.disposeHKBackLongPressJob();
        this.disposeShowIconAfterFingerTraceCleanDelayTimer();
    }

    public TimerEvent getHKBackTimeEvent() {
        return this.hkBackLongPressEvent;
    }

    /* synthetic */ TouchControllerListenerFactory$TimerListenerImpl(TouchController touchController, TouchControllerListenerFactory$1 touchControllerListenerFactory$1) {
        this(touchController);
    }
}

