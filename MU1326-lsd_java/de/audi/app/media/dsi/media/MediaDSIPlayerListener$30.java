/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$30
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$videoNorm;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$30(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$videoNorm = n;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$6600(this.this$0).log(1078071040, "[%1.updateVideoNorm] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID(), (long)this.val$videoNorm);
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updateVideoNorm(this.val$videoNorm);
    }
}

