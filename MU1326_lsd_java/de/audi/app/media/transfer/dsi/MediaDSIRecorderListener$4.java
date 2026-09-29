/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener;

class MediaDSIRecorderListener$4
implements Runnable {
    private final /* synthetic */ long val$deletionProgress;
    private final /* synthetic */ MediaDSIRecorderListener this$0;

    MediaDSIRecorderListener$4(MediaDSIRecorderListener mediaDSIRecorderListener, long l) {
        this.this$0 = mediaDSIRecorderListener;
        this.val$deletionProgress = l;
    }

    @Override
    public void run() {
        MediaDSIRecorderListener.access$900(this.this$0).log(1078071040, "[%1.updateDeletionProgress] [%2] '%3'.", (Object)"MediaDSIRecorderListener", (Object)new Integer(MediaDSIRecorderListener.access$200(this.this$0).getInstanceID()), (Object)new Long(this.val$deletionProgress));
        IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.access$200(this.this$0).getRecorderListener();
        if (iMediaRecorderListener == null) {
            return;
        }
        iMediaRecorderListener.updateDeletionProgress(this.val$deletionProgress);
    }

    public String toString() {
        return "DSIMediaRecorder.updateDeletionProgress";
    }
}

