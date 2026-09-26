/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$29
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$videoFormat;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$29(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$videoFormat = n;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$6500(this.this$0).log(1078071040, "[%1.updateVideoFormat] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID(), (long)this.val$videoFormat);
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updateVideoFormat(this.val$videoFormat);
    }
}

