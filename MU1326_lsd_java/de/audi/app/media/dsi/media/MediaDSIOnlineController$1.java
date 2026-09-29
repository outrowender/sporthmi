/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIOnlineController;

class MediaDSIOnlineController$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$state;
    private final /* synthetic */ MediaDSIOnlineController this$0;

    MediaDSIOnlineController$1(MediaDSIOnlineController mediaDSIOnlineController, String string, int n) {
        this.this$0 = mediaDSIOnlineController;
        this.val$state = n;
        super(string);
    }

    @Override
    public void run() {
        try {
            MediaDSIOnlineController.access$000(this.this$0).log(1078071040, "[%1.updateBufferState]", (Object)"MediaDSIOnlineController");
            MediaDSIOnlineController.access$100(this.this$0).updateBufferState(this.val$state);
        }
        catch (Exception exception) {
            MediaDSIOnlineController.access$200(this.this$0).log(10000, "[%1.updateBufferState] Error in listener: %2", (Object)"MediaDSIOnlineController", (Throwable)exception);
        }
    }
}

