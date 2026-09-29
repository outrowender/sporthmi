/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener;

class MediaDSIRecorderListener$5
implements Runnable {
    private final /* synthetic */ int val$status;
    private final /* synthetic */ MediaDSIRecorderListener this$0;

    MediaDSIRecorderListener$5(MediaDSIRecorderListener mediaDSIRecorderListener, int n) {
        this.this$0 = mediaDSIRecorderListener;
        this.val$status = n;
    }

    @Override
    public void run() {
        MediaDSIRecorderListener.access$1000(this.this$0).log(1078071040, "[%1.updateDeletionStatus] [%2] '%3'.", (Object)"MediaDSIRecorderListener", (long)MediaDSIRecorderListener.access$200(this.this$0).getInstanceID(), (long)this.val$status);
        IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.access$200(this.this$0).getRecorderListener();
        if (iMediaRecorderListener == null) {
            return;
        }
        iMediaRecorderListener.updateDeletionStatus(this.val$status);
    }

    public String toString() {
        return "DSIMediaRecorder.updateDeletionStatus";
    }
}

