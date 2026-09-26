/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaDSIBaseListener;

class MediaDSIBaseListener$1
implements Runnable {
    private final /* synthetic */ int val$resetMode;
    private final /* synthetic */ boolean val$success;
    private final /* synthetic */ MediaDSIBaseListener this$0;

    MediaDSIBaseListener$1(MediaDSIBaseListener mediaDSIBaseListener, int n, boolean bl) {
        this.this$0 = mediaDSIBaseListener;
        this.val$resetMode = n;
        this.val$success = bl;
    }

    @Override
    public void run() {
        MediaDSIBaseListener.access$000(this.this$0).log(1078071040, "[%1.responseResetFactorySettings] resetMode='%2',success='%3'.", (Object)"MediaDSIBaseListener", (Object)String.valueOf(this.val$resetMode), (Object)String.valueOf(this.val$success));
        if (MediaDSIBaseListener.access$100(this.this$0) == null) {
            return;
        }
        MediaDSIBaseListener.access$100(this.this$0).responseResetFactorySettings(this.val$resetMode, this.val$success);
    }

    public String toString() {
        return "DSIMediaBase.responseResetFactorySettings";
    }
}

