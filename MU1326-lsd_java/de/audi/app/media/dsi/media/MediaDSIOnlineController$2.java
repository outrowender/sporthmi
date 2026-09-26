/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIOnlineController;

class MediaDSIOnlineController$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$downloaded;
    private final /* synthetic */ int val$total;
    private final /* synthetic */ MediaDSIOnlineController this$0;

    MediaDSIOnlineController$2(MediaDSIOnlineController mediaDSIOnlineController, String string, int n, int n2) {
        this.this$0 = mediaDSIOnlineController;
        this.val$downloaded = n;
        this.val$total = n2;
        super(string);
    }

    @Override
    public void run() {
        try {
            MediaDSIOnlineController.access$300(this.this$0).log(1078071040, "[%1.updateBufferFillInfo]", (Object)"MediaDSIOnlineController");
            MediaDSIOnlineController.access$100(this.this$0).updateBufferFillInfo(this.val$downloaded, this.val$total);
        }
        catch (Exception exception) {
            MediaDSIOnlineController.access$400(this.this$0).log(10000, "[%1.updateBufferFillInfo] Error in listener: %2", (Object)"MediaDSIOnlineController", (Throwable)exception);
        }
    }
}

