/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.hmi.evo.IRightDrawerActionReceiver;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractToneAndCaseTogglingTable;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionDataFetcherWordPrediction;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionCandidateSelectionHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ISpellerListenerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.PartialConversionHelperWithUndoImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchInputDataAsia;

public final class TouchControllerListenerFactory {
    private final TouchController touchController;
    private final TouchControllerAsia touchControllerAsia;
    private final boolean isAsianTouchController;
    private static String lastOldText = "";
    private static String lastNewText = "";
    private static char lastCalculateLastInputCharRersult = '\u0000';

    public TouchControllerListenerFactory(TouchController touchController) {
        if (touchController == null) {
            throw new IllegalArgumentException("touchController is null");
        }
        this.touchController = touchController;
        this.isAsianTouchController = touchController instanceof TouchControllerAsia;
        this.touchControllerAsia = this.isAsianTouchController ? (TouchControllerAsia)touchController : null;
    }

    public AnimationListenerImpl createAnimationListener() {
        return new AnimationListenerImpl(this.touchController);
    }

    public TimerListenerImpl createJobEventListener() {
        if (this.isAsianTouchController) {
            return new TimerListenerImplAsia(this.touchControllerAsia);
        }
        return new TimerListenerImpl(this.touchController);
    }

    public IUserHintPartialPopupListener createUserHintPartialPopupListener() {
        return new UserHintPartialPopupListenerImpl(this.touchController);
    }

    public FingerTraceListener createFingertraceListener() {
        return new FingerTraceListenerImpl(this.touchController);
    }

    public IRightDrawerActionReceiverTextController createRightDrawerActionReceiver() {
        RightDrawerActionReceiverImpl rightDrawerActionReceiverImpl = new RightDrawerActionReceiverImpl(this.touchController);
        if (this.isAsianTouchController) {
            return new RightDrawerActionReceiverImplAsia(this.touchControllerAsia, rightDrawerActionReceiverImpl);
        }
        return rightDrawerActionReceiverImpl;
    }

    public ISpellerListener createSpellerListener() {
        SpellerListenerImpl spellerListenerImpl = new SpellerListenerImpl(this.touchController);
        if (this.isAsianTouchController) {
            return new SpellerListenerImplAsia(this.touchControllerAsia, spellerListenerImpl);
        }
        return spellerListenerImpl;
    }

    public IConversionCandidateSelectionHandler createConversionCandidateSelectionHandler() {
        if (this.isAsianTouchController) {
            return new ConversionCandidateSelectionHandlerImpl(this.touchControllerAsia);
        }
        IWidgetLogChannel.tpLogChannelInternal.log(1000, "TouchControllerListenerHelper#createConversionCandidateSelectionHandler not an Asian touchController! returning null.");
        return null;
    }

    public static char calculateLastInputChar(String string, String string2) {
        if (lastOldText.equals(string) && lastNewText.equals(string2)) {
            return lastCalculateLastInputCharRersult;
        }
        char c2 = string != null && string.length() > string2.length() ? (char)'\b' : (string2.length() > 0 ? string2.charAt(string2.length() - 1) : (char)'\u0000');
        return c2;
    }

    public static class TimerListenerImpl
    implements ATIPEventListener {
        private static final long TIME_USER_HINT_DELETE_SPACE_IDLE_TIME = 8000L;
        private boolean userHintIdleTimerFiredOnce;
        private Job userHintIdleJob = null;
        private TimerEvent userHintIdleEvent = null;
        private static final long SHOW_ICON_AFTER_FINGER_TRACE_CLEAN_DELAY_VALUE = 2000L;
        private Job showIconAfterFingerTraceCleanDelayJob = null;
        private TimerEvent showIconAfterFingerTraceCleanDelayEvent = null;
        private boolean showIconAfterFingerTraceCleanDelayJobRunning = false;
        private static final long TIME_LONG_PRESS = 1000L;
        private Job hkBackLongPressJob = null;
        private TimerEvent hkBackLongPressEvent = null;
        private boolean hkBackLongPressJobRunning = false;
        private final TouchController touchController;

        private TimerListenerImpl(TouchController touchController) {
            this.touchController = touchController;
            this.userHintIdleTimerFiredOnce = false;
        }

        private void initUserHintIdleJob() {
            this.userHintIdleEvent = new TimerEvent(this);
            this.userHintIdleJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.userHintIdleEvent, 8000L);
        }

        private void initShowIconJob() {
            this.showIconAfterFingerTraceCleanDelayEvent = new TimerEvent(this);
            this.showIconAfterFingerTraceCleanDelayJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.showIconAfterFingerTraceCleanDelayEvent, 2000L);
        }

        public final Job getUserHintIdleJob() {
            return this.userHintIdleJob;
        }

        public void processEvent(ATIPEvent aTIPEvent) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TouchControllerListenerFactory.TimerListenerImpl#fireTimer: timer fired");
            if (aTIPEvent.equals(this.hkBackLongPressEvent)) {
                this.hkBackLongPressJobRunning = false;
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TouchController#fireTimer: delete whole textfield because of longPressed HK_BACK");
                this.touchController.handleHKBackLongPress();
                IWidgetLogChannel.logRepaintCause.log(10000000, "TouchControllerListenerFactory.TimerListenerImpl#fireTimer: hkBack long press timer. trigger repaint. screen: %1", (long)this.touchController.getScreenId());
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
                this.hkBackLongPressJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.hkBackLongPressEvent, 1000L);
            }
        }

        public final void restartShowIconAfterFingerTraceCleanDelayTimer() {
            if (this.showIconAfterFingerTraceCleanDelayJob == null) {
                this.initShowIconJob();
            }
            if (this.showIconAfterFingerTraceCleanDelayJob != null) {
                this.showIconAfterFingerTraceCleanDelayJob.cancel();
                this.showIconAfterFingerTraceCleanDelayEvent = new TimerEvent(this);
                this.showIconAfterFingerTraceCleanDelayJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.showIconAfterFingerTraceCleanDelayEvent, 2000L);
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
                this.userHintIdleJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.userHintIdleEvent, 8000L);
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
    }

    private static final class SpellerListenerImpl
    implements ISpellerListener {
        private TouchController touchController = null;

        private SpellerListenerImpl(TouchController touchController) {
            this.touchController = touchController;
        }

        public void buttonPressed(SpellerController.SpellerButtonType spellerButtonType, SpellerButtonArgument spellerButtonArgument) {
            if (spellerButtonType == SpellerController.SpellerButtonType.CLOSE) {
                this.touchController.closeSpeller();
            } else if (spellerButtonType == SpellerController.SpellerButtonType.OK) {
                this.touchController.okPressed(spellerButtonArgument);
            } else if (spellerButtonType == SpellerController.SpellerButtonType.RIGHT) {
                this.touchController.moveCursorRight();
            } else if (spellerButtonType == SpellerController.SpellerButtonType.LEFT) {
                this.touchController.moveCursorLeft();
            }
        }

        public void buttonLongPressed(SpellerController.SpellerButtonType spellerButtonType) {
            if (spellerButtonType == SpellerController.SpellerButtonType.DELETE) {
                this.touchController.clear(true);
            }
        }

        public void buttonReleased(SpellerController.SpellerButtonType spellerButtonType) {
            if (spellerButtonType == SpellerController.SpellerButtonType.DELETE) {
                this.characterPressed("\b", false, false);
            }
        }

        public void characterPressed(String string, boolean bl, boolean bl2) {
            if (!bl2 || bl2 && !bl) {
                this.touchController.setFastDelete(false);
                this.touchController.stringEntered(string, null);
                if (string != null && string.length() > 0) {
                    this.touchController.notifyPRPAboutSpellerInput(string.charAt(0));
                }
                this.touchController.setCompositesDirty(true);
            }
        }

        public void focusedCharacterChanged(String string) {
            this.touchController.spellerCharacterFocused(TouchController.extractFirstCharacter(string));
        }

        public void focusChanged(SpellerController.ISpellerItem iSpellerItem, int n) {
        }
    }

    public static final class AnimationListenerImpl
    implements AnimationListener {
        public static final int ANIMATION_TARGET_OPEN_SPELLER = 1000;
        public static final int ANIMATION_TYPE_OPEN_SPELLER = 77;
        public static final int ANIMATION_TYPE_INFOLINE = 96;
        public static final int ANIMATION_TYPE_CURSOR_BLINK = 1;
        private AbstractAnimation cursorBlinkAnimation = null;
        private AbstractAnimation spellerOpenAnimation;
        private AbstractAnimation infoLineAnimation;
        private TouchController touchController = null;
        private float infoLineProgess = 0.0f;
        private float spellerOpenProgress = 0.0f;
        private float targetSpellerOpenProgress = 0.0f;
        private float startSpellerOpenProgress = 0.0f;
        private boolean focusFirstMenuLineAfterSpellerClose = false;

        private AnimationListenerImpl(TouchController touchController) {
            this.touchController = touchController;
        }

        public void animationStarted(int n, int n2) {
        }

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

        public void animate(int n, float f2, int n2) {
            if (n == 77) {
                float f3 = this.spellerOpenAnimation.getProgress();
                this.setSpellerOpenProgress(AnimationListenerImpl.getInterpolatedValue(this.getStartSpellerOpenProgress(), this.getTargetSpellerOpenProgress(), f3));
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
            AnimationListenerImpl.stopAnimation(this.cursorBlinkAnimation);
            this.cursorBlinkAnimation = null;
        }

        private void disposeSpellerOpenAnimation() {
            AnimationListenerImpl.stopAnimation(this.spellerOpenAnimation);
            this.spellerOpenAnimation = null;
        }

        private void disposeInfoLineAnimation() {
            AnimationListenerImpl.stopAnimation(this.infoLineAnimation);
            this.infoLineAnimation = null;
        }

        public void stopCursorBlinkAnimation() {
            AnimationListenerImpl.stopAnimation(this.cursorBlinkAnimation);
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
            if (this.touchController.getCursorOpacity() < 0.5f) {
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
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TouchControllerAsAnimationListenerImp#stopAnimation: an animation will be stoppped (animationType=%1)", (long)abstractAnimation.getType());
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
            if (!this.touchController.isEnabled() || UserHintPartialPopupListenerImpl.hintIsShown || !this.touchController.isFocused()) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TouchControllerAsAnimationListenerImp#startCursorBlinkAnimation: isEnabled=%1, isFocused=%2", this.touchController.isEnabled(), this.touchController.isFocused());
                return;
            }
            AbstractAnimation abstractAnimation = this.getCursorBlinkAnimation();
            if (!abstractAnimation.isAnimating()) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TouchControllerAsAnimationListenerImp#startCursorBlinkAnimation: animation will be started");
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
    }

    public static class TimerListenerImplAsia
    extends TimerListenerImpl {
        public static final String TIMER_NAME_DELAY_SPEAKING_OF_TOUCH_RESULT_PREVIEW = "delaySpeakingOfPreviewTimer";
        private static final long TIME_DELAY_SPEAKING_OF_TOUCH_RESULT_PREVIEW_DEFAULT = 700L;
        private long timeDelaySpeakingOfResultPreview;
        private Job delaySpeakingOfPreviewJob = null;
        private TimerEvent delaySpeakingOfPreviewEvent = null;
        private String lastPreviewCharacterToSpeak = null;
        private final TouchControllerAsia touchControllerAsia;

        public TimerListenerImplAsia(TouchControllerAsia touchControllerAsia) {
            super(touchControllerAsia);
            this.touchControllerAsia = touchControllerAsia;
            this.setDelayForSpeakingResultPreview(700L);
        }

        public final void setDelayForSpeakingResultPreview(long l) {
            this.timeDelaySpeakingOfResultPreview = l;
            if (l > 0L) {
                this.disposeDelayJob();
            }
        }

        private void createAndStartDelaySpeakingOfPreviewTimer() {
            if (this.delaySpeakingOfPreviewJob == null) {
                this.delaySpeakingOfPreviewEvent = new TimerEvent(this);
                this.delaySpeakingOfPreviewJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.delaySpeakingOfPreviewEvent, this.timeDelaySpeakingOfResultPreview);
            } else {
                this.delaySpeakingOfPreviewJob.cancel();
                this.delaySpeakingOfPreviewJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.delaySpeakingOfPreviewEvent, this.timeDelaySpeakingOfResultPreview);
            }
        }

        public void speakPreviewCharacter(String string) {
            this.lastPreviewCharacterToSpeak = string;
            if (this.timeDelaySpeakingOfResultPreview == 0L) {
                this.doSpeakLastPreviewCharacterNow();
            } else {
                this.createAndStartDelaySpeakingOfPreviewTimer();
            }
        }

        public void processEvent(ATIPEvent aTIPEvent) {
            super.processEvent(aTIPEvent);
            if (aTIPEvent.equals(this.delaySpeakingOfPreviewEvent)) {
                this.doSpeakLastPreviewCharacterNow();
            }
        }

        private void doSpeakLastPreviewCharacterNow() {
            this.touchControllerAsia.getTouchUtil().speakChar(this.lastPreviewCharacterToSpeak);
            this.lastPreviewCharacterToSpeak = null;
        }

        public void disconnecting() {
            super.disconnecting();
            this.disposeDelayJob();
        }

        private void disposeDelayJob() {
            if (this.delaySpeakingOfPreviewEvent != null) {
                this.delaySpeakingOfPreviewEvent.consume();
                this.delaySpeakingOfPreviewEvent = null;
            }
            if (this.delaySpeakingOfPreviewJob != null) {
                this.delaySpeakingOfPreviewJob.cancel();
                this.delaySpeakingOfPreviewJob = null;
            }
        }
    }

    private static final class FingerTraceListenerImpl
    implements FingerTraceListener {
        private TouchController touchController = null;

        private FingerTraceListenerImpl(TouchController touchController) {
            this.touchController = touchController;
        }

        public void onVisibilityChange() {
            this.touchController.calculateCursorPosition();
        }

        public void onFingerTraceHide() {
            this.touchController.setCompositeDirty(1);
        }
    }

    private static final class SpellerListenerImplAsia
    implements ISpellerListenerAsia {
        private SpellerListenerImpl delegate = null;
        private TouchControllerAsia touchController = null;

        private SpellerListenerImplAsia(TouchControllerAsia touchControllerAsia, SpellerListenerImpl spellerListenerImpl) {
            this.touchController = touchControllerAsia;
            this.delegate = spellerListenerImpl;
        }

        public void buttonPressed(SpellerController.SpellerButtonType spellerButtonType, SpellerButtonArgument spellerButtonArgument) {
            this.delegate.buttonPressed(spellerButtonType, spellerButtonArgument);
            if (spellerButtonType.isCharsetToggleButton()) {
                this.touchController.switchToSpeller(spellerButtonType.getTargetToggleCharset());
                this.touchController.forceFocusOnItem(spellerButtonType);
            }
            if (spellerButtonType == SpellerController.SpellerButtonType.JP_TONE_LOWER_CASE_TOGGLE) {
                this.touchController.toggleCharStatusForJapan();
            }
        }

        public void characterPressed(String string, boolean bl, boolean bl2) {
            String string2 = string;
            boolean bl3 = this.touchController.isMatchspellerModel();
            boolean bl4 = AbstractWidget.isJp();
            if (bl4 && bl3) {
                String string3 = this.touchController.getMatchSpellerValidChars();
                if ((string2 = AbstractToneAndCaseTogglingTable.getFirstValidToneOrCaseCharForJPLanguageWithNVCFilter(string2, string3)) == null) {
                    string2 = string;
                }
                this.touchController.setToneLowerCaseButtonValidChars(string3);
            }
            if (bl) {
                this.handleLongPressCharacter(string2);
            } else {
                this.delegate.characterPressed(string2, bl, bl2);
            }
            if ("\b".equals(string) && this.touchController.isWordPredictionAvailable()) {
                this.touchController.updateWordPredictionContext("", false);
            }
        }

        private void handleLongPressCharacter(String string) {
            ITouchInputDataAsia iTouchInputDataAsia = (ITouchInputDataAsia)this.touchController.getInputData();
            iTouchInputDataAsia.longPressOnCharacterOccurred(string);
        }

        public void buttonLongPressed(SpellerController.SpellerButtonType spellerButtonType) {
            this.delegate.buttonLongPressed(spellerButtonType);
        }

        public void buttonReleased(SpellerController.SpellerButtonType spellerButtonType) {
            if (SpellerController.SpellerButtonType.DELETE == spellerButtonType && !this.touchController.hasNonRegularCharacters()) {
                this.touchController.handleDeletionForTruffleButton();
                this.touchController.setEmptyWordPredictionContext();
            }
            this.delegate.buttonReleased(spellerButtonType);
        }

        public void focusedCharacterChanged(String string) {
        }

        public void spellerBandStateChanged(SpellerBandState spellerBandState, SpellerBandState spellerBandState2) {
            this.touchController.showFocusStateDebugInfo();
            if (spellerBandState2 == SpellerBandState.TOUCH_PREDICTION_LINE) {
                this.touchController.clearSuggestion();
            }
            if (spellerBandState == SpellerBandState.TOUCH_PREDICTION_LINE) {
                if (spellerBandState2.isUsingDefaultSpellerBand()) {
                    this.touchController.clearSuggestion();
                }
                this.touchController.setFocusState(TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS);
            } else if (spellerBandState.isUsingTouchResultLine()) {
                this.touchController.setFocusState(TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS);
            }
            this.touchController.updateButtonStates();
        }

        public void touchWordPredictionContextUpdateNeeded(String string) {
            this.touchController.updateWordPredictionContext(string, false);
        }

        public void focusChanged(SpellerController.ISpellerItem iSpellerItem, int n) {
            this.delegate.focusChanged(iSpellerItem, n);
        }
    }

    public static interface IUserHintPartialPopupListener
    extends IPartialPopupListener {
        public boolean isUserHintShown();
    }

    private static final class RightDrawerActionReceiverImpl
    implements IRightDrawerActionReceiverTextController {
        private TouchController touchController = null;

        private RightDrawerActionReceiverImpl(TouchController touchController) {
            this.touchController = touchController;
        }

        public void executeAction(int n) {
            switch (n) {
                case 1: {
                    this.touchController.closeSpeller(false, true);
                    this.touchController.setSpellerLastMode(0);
                    this.touchController.hideFingerTrace();
                    break;
                }
                case 2: {
                    this.touchController.openSpeller(true);
                    break;
                }
                case 3: {
                    this.touchController.clear(true);
                    break;
                }
                case 5: {
                    if (TouchController.isArabia()) {
                        ((TouchControllerArabia)this.touchController).setAutoCharsetSwitch(false);
                    }
                    this.touchController.changeCharset(0);
                    break;
                }
                case 6: {
                    this.touchController.changeCharset(1);
                    break;
                }
                case 7: {
                    if (TouchController.isArabia()) {
                        ((TouchControllerArabia)this.touchController).setAutoCharsetSwitch(false);
                    }
                    this.touchController.changeCharset(2);
                    break;
                }
                default: {
                    IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchControllerAsRightDrawerActionReceiver#executeAction: unknown actionId %1", (long)n);
                }
            }
        }
    }

    private static final class UserHintPartialPopupListenerImpl
    implements IUserHintPartialPopupListener {
        private static boolean hintIsShown = false;
        private TouchController touchController = null;

        private UserHintPartialPopupListenerImpl(TouchController touchController) {
            this.touchController = touchController;
        }

        public void partialPopupVisible(int n, int n2) {
            UserHintPartialPopupListenerImpl.setHintIsShown(true);
            this.touchController.updateMenuCursorVisibility();
            this.touchController.stopCursorBlinkAnimation();
        }

        public void partialPopupHidden(int n, int n2) {
            UserHintPartialPopupListenerImpl.setHintIsShown(false);
            this.touchController.updateMenuCursorVisibility();
            this.touchController.startCursorBlinkAnimation();
        }

        public int[] getPPIDsForCallbacks() {
            return new int[]{96, 97};
        }

        private static void setHintIsShown(boolean bl) {
            hintIsShown = bl;
        }

        public boolean isUserHintShown() {
            return hintIsShown;
        }

        public void partialPopupRemoved(int n, int n2) {
        }

        public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
        }

        public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
        }
    }

    private static final class RightDrawerActionReceiverImplAsia
    implements IRightDrawerActionReceiverTextController {
        private IRightDrawerActionReceiver delegate = null;
        private TouchControllerAsia touchController = null;

        private RightDrawerActionReceiverImplAsia(TouchControllerAsia touchControllerAsia, RightDrawerActionReceiverImpl rightDrawerActionReceiverImpl) {
            this.touchController = touchControllerAsia;
            this.delegate = rightDrawerActionReceiverImpl;
        }

        public void executeAction(int n) {
            switch (n) {
                case 5: {
                    this.touchController.switchToSpeller(0);
                    break;
                }
                case 8: {
                    this.touchController.switchToSpeller(3);
                    break;
                }
                case 9: {
                    this.touchController.switchToSpeller(4);
                    break;
                }
                case 10: {
                    this.touchController.switchToSpeller(5);
                    break;
                }
                case 11: {
                    this.touchController.switchToSpeller(7);
                    break;
                }
                case 12: {
                    this.touchController.switchToSpeller(6);
                    break;
                }
                case 13: {
                    this.touchController.setRecognitionTimeOutValue(500);
                    break;
                }
                case 14: {
                    this.touchController.setRecognitionTimeOutValue(750);
                    break;
                }
                case 15: {
                    this.touchController.setRecognitionTimeOutValue(1000);
                    break;
                }
                case 2: {
                    this.touchController.clearSuggestion();
                    this.delegate.executeAction(2);
                    break;
                }
                default: {
                    this.delegate.executeAction(n);
                }
            }
        }
    }

    private static final class ConversionCandidateSelectionHandlerImpl
    implements IConversionCandidateSelectionHandler {
        private TouchControllerAsia touchController = null;

        private ConversionCandidateSelectionHandlerImpl(TouchControllerAsia touchControllerAsia) {
            this.touchController = touchControllerAsia;
        }

        public void acceptConversionCandidateSelection(String string, int n) {
            boolean bl = this.touchController.shouldUseWordPrediction();
            ITouchInputDataAsia iTouchInputDataAsia = (ITouchInputDataAsia)this.touchController.getInputData();
            if (!bl) {
                iTouchInputDataAsia.clearUnconvertedCharacters(false);
                iTouchInputDataAsia.appendRegularCharacters(string, true);
                this.touchController.setConversionLineVisible(false);
                this.touchController.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
            } else {
                this.touchController.cacheSelectedPredictionChars(string);
                IConversionDataFetcher iConversionDataFetcher = this.touchController.getConversionDataFetcher();
                if (iConversionDataFetcher instanceof ConversionDataFetcherWordPrediction) {
                    ((ConversionDataFetcherWordPrediction)iConversionDataFetcher).candidateSelected(n, 36, ConversionCandidateSelectionHandlerImpl.getPredictionContext(iTouchInputDataAsia, string, this.touchController.getPartialConversionHelper().getConvertedChars()), string);
                }
            }
        }

        private static String getPredictionContext(ITouchInputDataAsia iTouchInputDataAsia, String string, String string2) {
            Buffer buffer = new Buffer();
            if (!iTouchInputDataAsia.hasUnconvertedCharacters() || PartialConversionHelperWithUndoImpl.countSeparator(iTouchInputDataAsia.getUnconvertedCharacters()) < string.length()) {
                buffer.append(TouchInputDataAsia.getCharsBeforeLastSpaceSeperator(iTouchInputDataAsia.getCurrentText(), false));
                buffer.append(string2);
            }
            return buffer.toString();
        }

        public void acceptKeyEventInConversionMatrix(KeyEvent keyEvent) {
            ITouchInputDataAsia iTouchInputDataAsia = (ITouchInputDataAsia)this.touchController.getInputData();
            if (keyEvent.getKeyCode() == 15 && (iTouchInputDataAsia.hasUnconvertedCharacters() || this.touchController.shouldUseWordPrediction())) {
                this.touchController.setConversionLineVisible(true);
                this.touchController.setFocusState(TouchControllerFocusState.CONVERSION_LINE_FOCUS);
                keyEvent.consume();
            }
        }
    }

    public static interface IRightDrawerActionReceiverTextController
    extends IRightDrawerActionReceiver {
        public static final int ACTION_CLOSE_SPELLER = 1;
        public static final int ACTION_OPEN_SPELLER = 2;
        public static final int ACTION_CLEAR_SPELLER = 3;
        public static final int ACTION_SWITCH_CHARSET_LATIN = 5;
        public static final int ACTION_SWITCH_CHARSET_CYRILLIC = 6;
        public static final int ACTION_SWITCH_CHARSET_ARABIC = 7;
        public static final int ACTION_ASIA_SWITCH_CHARSET_PINYIN = 8;
        public static final int ACTION_ASIA_SWITCH_CHARSET_STROKE = 9;
        public static final int ACTION_ASIA_SWITCH_CHARSET_BOPOMOFO = 10;
        public static final int ACTION_ASIA_SWITCH_CHARSET_KOREA = 11;
        public static final int ACTION_ASIA_SWITCH_CHARSET_HIRAGANA = 12;
        public static final int ACTION_ASIA_SET_RECOGNITION_TIME_OUT_SHORT = 13;
        public static final int ACTION_ASIA_SET_RECOGNITION_TIME_OUT_MEDIUM = 14;
        public static final int ACTION_ASIA_SET_RECOGNITION_TIME_OUT_LONG = 15;
    }
}

