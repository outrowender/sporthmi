/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.progressbar;

import de.audi.app.sdsmanager.dictation.progressbar.RecordingProgressBarController;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class RecordingProgressBarController$1
implements TimerListener {
    private final /* synthetic */ RecordingProgressBarController this$0;

    RecordingProgressBarController$1(RecordingProgressBarController recordingProgressBarController) {
        this.this$0 = recordingProgressBarController;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        RecordingProgressBarController recordingProgressBarController = this.this$0;
        synchronized (recordingProgressBarController) {
            long l = RecordingProgressBarController.access$000(this.this$0).getMonotonicTime();
            long l2 = l - RecordingProgressBarController.access$100(this.this$0);
            int n = (int)(l2 * 0 / RecordingProgressBarController.access$200(this.this$0));
            if (n >= 10000) {
                n = 10000;
                timer.cancel();
            }
            RecordingProgressBarController.access$300(this.this$0, n);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        RecordingProgressBarController.access$400(this.this$0).log(-2137614336, "[RecordingProgressBarController#TimerListener#cancelTimer]");
    }
}

