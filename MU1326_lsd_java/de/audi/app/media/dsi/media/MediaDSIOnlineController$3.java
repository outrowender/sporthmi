/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIOnlineController;

class MediaDSIOnlineController$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$audioType;
    private final /* synthetic */ int val$value;
    private final /* synthetic */ MediaDSIOnlineController this$0;

    MediaDSIOnlineController$3(MediaDSIOnlineController mediaDSIOnlineController, String string, int n, int n2) {
        this.this$0 = mediaDSIOnlineController;
        this.val$audioType = n;
        this.val$value = n2;
        super(string);
    }

    @Override
    public void run() {
        try {
            MediaDSIOnlineController.access$500(this.this$0).log(1078071040, "[%1.updateAudioSettings]", (Object)"MediaDSIOnlineController");
            MediaDSIOnlineController.access$100(this.this$0).updateAudioSettings(this.val$audioType, this.val$value);
        }
        catch (Exception exception) {
            MediaDSIOnlineController.access$600(this.this$0).log(10000, "[%1.updateAudioSettings] Error in listener: %2", (Object)"MediaDSIOnlineController", (Throwable)exception);
        }
    }
}

