/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener;

class MediaDSIRecorderListener$9
implements Runnable {
    private final /* synthetic */ int val$encodingQuality;
    private final /* synthetic */ MediaDSIRecorderListener this$0;

    MediaDSIRecorderListener$9(MediaDSIRecorderListener mediaDSIRecorderListener, int n) {
        this.this$0 = mediaDSIRecorderListener;
        this.val$encodingQuality = n;
    }

    @Override
    public void run() {
        MediaDSIRecorderListener.access$1500(this.this$0).log(1078071040, "[%1.responseSetEncodingQuality] [%2] '%3'.", (Object)"MediaDSIRecorderListener", (long)MediaDSIRecorderListener.access$200(this.this$0).getInstanceID(), (long)this.val$encodingQuality);
        IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.access$200(this.this$0).getRecorderListener();
        if (iMediaRecorderListener == null) {
            return;
        }
        iMediaRecorderListener.responseSetEncodingQuality(this.val$encodingQuality);
    }

    public String toString() {
        return "DSIMediaRecorder.responseSetEncodingQuality";
    }
}

