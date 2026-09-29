/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.progressbar;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.progressbar.IRecordingProgressBarController;
import de.audi.app.sdsmanager.dictation.progressbar.RecordingProgressBarController$1;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;

public final class RecordingProgressBarController
extends AbstractDictationComponent
implements IRecordingProgressBarController,
IDictationStateObserver {
    private static final long UPDATE_INTERVAL;
    private static final int PROGRESS_BAR_MAX_VALUE;
    private volatile long dictationMaxDuration = 0L;
    private final RangeModelApp dictationProgressRange = this.framework.getHmiServiceApp().getRangeModel(3878);
    private Timer timer;
    private long startTime = 0L;

    public RecordingProgressBarController(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    @Override
    public synchronized void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.dictationProgressRange.setLimits(0, 10000, 1);
        this.timer = this.createTimer();
        this.setProgress(0);
        dictationComponentManager.getDictationStateManager().addObserver(this);
    }

    @Override
    public synchronized void dispose() {
        super.dispose();
        this.timer.cancel();
        this.setProgress(0);
    }

    private synchronized void recordingStarted() {
        this.log.log(-2137614336, "[RecordingProgressBarController#recordingStarted] dictationMaxDuration = %1", this.dictationMaxDuration);
        if (RecordingProgressBarController.isValidDictationMaxDuration(this.dictationMaxDuration)) {
            this.setProgress(0);
            this.startTime = this.framework.getMonotonicTime();
            this.timer.start();
        } else {
            this.log.log(10000, "[RecordingProgressBarController#recordingStarted] Unsuitable maximum duration, ignoring call.");
        }
    }

    private synchronized void recordingFinished() {
        this.log.log(-2137614336, "[RecordingProgressBarController#recordingFinished]");
        this.timer.cancel();
    }

    private Timer createTimer() {
        RecordingProgressBarController$1 recordingProgressBarController$1 = new RecordingProgressBarController$1(this);
        return new Timer("[RecordingProgressBarControllerTimer]", 0, false, recordingProgressBarController$1);
    }

    private synchronized void setProgress(int n) {
        if (this.log.isDebug()) {
            int n2 = n * 100 / 10000;
            this.log.log(-2137614336, "[RecordingProgressBarController#setProgress] progress = %1 (%2%)", (long)n, (long)n2);
        }
        this.dictationProgressRange.setValue(n);
    }

    private static boolean isValidDictationMaxDuration(long l) {
        return l > 0L;
    }

    @Override
    public void updateDictationState(int n) {
    }

    @Override
    public synchronized void updateDictationMaxDuration(long l) {
        this.log.log(-2137614336, "[RecordingProgressBarController#updateDictationMaxDuration] dictationMaxDuration = %1", l);
        if (this.dictationMaxDuration != l) {
            if (RecordingProgressBarController.isValidDictationMaxDuration(l)) {
                this.dictationMaxDuration = l;
            } else {
                this.log.log(10000, "[RecordingProgressBarController#updateDictationMaxDuration] Unsuitable maximum duration, ignoring call.");
            }
        }
    }

    @Override
    public void indicateRecordingStarted() {
        this.log.log(-2137614336, "[RecordingProgressBarController#indicateRecordingStarted]");
        this.recordingStarted();
    }

    @Override
    public void indicateRecordingStopped() {
        this.log.log(-2137614336, "[RecordingProgressBarController#indicateRecordingStarted]");
        this.recordingFinished();
    }

    static /* synthetic */ IFrameworkAccess access$000(RecordingProgressBarController recordingProgressBarController) {
        return recordingProgressBarController.framework;
    }

    static /* synthetic */ long access$100(RecordingProgressBarController recordingProgressBarController) {
        return recordingProgressBarController.startTime;
    }

    static /* synthetic */ long access$200(RecordingProgressBarController recordingProgressBarController) {
        return recordingProgressBarController.dictationMaxDuration;
    }

    static /* synthetic */ void access$300(RecordingProgressBarController recordingProgressBarController, int n) {
        recordingProgressBarController.setProgress(n);
    }

    static /* synthetic */ LogChannel access$400(RecordingProgressBarController recordingProgressBarController) {
        return recordingProgressBarController.log;
    }
}

