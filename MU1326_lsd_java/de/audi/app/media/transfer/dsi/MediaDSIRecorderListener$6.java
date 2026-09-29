/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener;
import org.dsi.ifc.media.ListEntry;

class MediaDSIRecorderListener$6
implements Runnable {
    private final /* synthetic */ long val$importProgress;
    private final /* synthetic */ ListEntry val$entry;
    private final /* synthetic */ MediaDSIRecorderListener this$0;

    MediaDSIRecorderListener$6(MediaDSIRecorderListener mediaDSIRecorderListener, long l, ListEntry listEntry) {
        this.this$0 = mediaDSIRecorderListener;
        this.val$importProgress = l;
        this.val$entry = listEntry;
    }

    @Override
    public void run() {
        MediaDSIRecorderListener.access$1100(this.this$0).log(1078071040, "[%1.updateImportProgress] [%2] importProgress='%3', entry='%4'.", (Object)"MediaDSIRecorderListener", (Object)new Integer(MediaDSIRecorderListener.access$200(this.this$0).getInstanceID()), (Object)new Long(this.val$importProgress), (Object)this.val$entry);
        IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.access$200(this.this$0).getRecorderListener();
        if (iMediaRecorderListener == null) {
            return;
        }
        iMediaRecorderListener.updateImportProgress(this.val$importProgress, this.val$entry);
    }

    public String toString() {
        return "DSIMediaRecorder.updateImportProgress";
    }
}

