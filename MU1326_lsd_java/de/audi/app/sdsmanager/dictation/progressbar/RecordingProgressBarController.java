/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.progressbar;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.progressbar.IRecordingProgressBarController;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public final class RecordingProgressBarController
extends AbstractDictationComponent
implements IRecordingProgressBarController,
IDictationStateObserver {
    private static final long UPDATE_INTERVAL = 100L;
    private static final int PROGRESS_BAR_MAX_VALUE = 10000;
    private volatile long dictationMaxDuration = 0L;
    private final RangeModelApp dictationProgressRange = this.framework.getHmiServiceApp().getRangeModel(3878);
    private Timer timer;
    private long startTime = 0L;

    public RecordingProgressBarController(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    public synchronized void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.dictationProgressRange.setLimits(0, 10000, 1);
        this.timer = this.createTimer();
        this.setProgress(0);
        dictationComponentManager.getDictationStateManager().addObserver(this);
    }

    public synchronized void dispose() {
        super.dispose();
        this.timer.cancel();
        this.setProgress(0);
    }

    private synchronized void recordingStarted() {
        this.log.log(10000000, "[RecordingProgressBarController#recordingStarted] dictationMaxDuration = %1", this.dictationMaxDuration);
        if (RecordingProgressBarController.isValidDictationMaxDuration(this.dictationMaxDuration)) {
            this.setProgress(0);
            this.startTime = this.framework.getMonotonicTime();
            this.timer.start();
        } else {
            this.log.log(10000, "[RecordingProgressBarController#recordingStarted] Unsuitable maximum duration, ignoring call.");
        }
    }

    private synchronized void recordingFinished() {
        this.log.log(10000000, "[RecordingProgressBarController#recordingFinished]");
        this.timer.cancel();
    }

    private Timer createTimer() {
        TimerListener timerListener = new TimerListener(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void fireTimer(Timer timer) {
                RecordingProgressBarController recordingProgressBarController = RecordingProgressBarController.this;
                synchronized (recordingProgressBarController) {
                    long l = RecordingProgressBarController.this.framework.getMonotonicTime();
                    long l2 = l - RecordingProgressBarController.this.startTime;
                    int n = (int)(l2 * 10000L / RecordingProgressBarController.this.dictationMaxDuration);
                    if (n >= 10000) {
                        n = 10000;
                        timer.cancel();
                    }
                    RecordingProgressBarController.this.setProgress(n);
                }
            }

            public void cancelTimer(Timer timer) {
                RecordingProgressBarController.this.log.log(10000000, "[RecordingProgressBarController#TimerListener#cancelTimer]");
            }
        };
        return new Timer("[RecordingProgressBarControllerTimer]", 100L, false, timerListener);
    }

    private synchronized void setProgress(int n) {
        if (this.log.isDebug()) {
            int n2 = n * 100 / 10000;
            this.log.log(10000000, "[RecordingProgressBarController#setProgress] progress = %1 (%2%)", (long)n, (long)n2);
        }
        this.dictationProgressRange.setValue(n);
    }

    private static boolean isValidDictationMaxDuration(long l) {
        return l > 0L;
    }

    public void updateDictationState(int n) {
    }

    public synchronized void updateDictationMaxDuration(long l) {
        this.log.log(10000000, "[RecordingProgressBarController#updateDictationMaxDuration] dictationMaxDuration = %1", l);
        if (this.dictationMaxDuration != l) {
            if (RecordingProgressBarController.isValidDictationMaxDuration(l)) {
                this.dictationMaxDuration = l;
            } else {
                this.log.log(10000, "[RecordingProgressBarController#updateDictationMaxDuration] Unsuitable maximum duration, ignoring call.");
            }
        }
    }

    public void indicateRecordingStarted() {
        this.log.log(10000000, "[RecordingProgressBarController#indicateRecordingStarted]");
        this.recordingStarted();
    }

    public void indicateRecordingStopped() {
        this.log.log(10000000, "[RecordingProgressBarController#indicateRecordingStarted]");
        this.recordingFinished();
    }
}

