/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener;
import org.dsi.ifc.media.DatabaseSpace;

class MediaDSIRecorderListener$3
implements Runnable {
    private final /* synthetic */ DatabaseSpace val$databaseSpace;
    private final /* synthetic */ MediaDSIRecorderListener this$0;

    MediaDSIRecorderListener$3(MediaDSIRecorderListener mediaDSIRecorderListener, DatabaseSpace databaseSpace) {
        this.this$0 = mediaDSIRecorderListener;
        this.val$databaseSpace = databaseSpace;
    }

    @Override
    public void run() {
        MediaDSIRecorderListener.access$800(this.this$0).log(1078071040, "[%1.updateDatabaseSpace] [%2] '%3'.", (Object)"MediaDSIRecorderListener", (Object)new Integer(MediaDSIRecorderListener.access$200(this.this$0).getInstanceID()), (Object)this.val$databaseSpace);
        IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.access$200(this.this$0).getRecorderListener();
        if (iMediaRecorderListener == null) {
            return;
        }
        iMediaRecorderListener.updateDatabaseSpace(this.val$databaseSpace);
    }

    public String toString() {
        return "DSIMediaRecorder.updateDatabaseSpace";
    }
}

