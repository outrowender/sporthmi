/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$25
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$playbackMode;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$25(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$playbackMode = n;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$5600(this.this$0).log(1078071040, "[%1.updatePlaybackMode] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID(), (long)this.val$playbackMode);
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updatePlaybackMode(this.val$playbackMode);
    }
}

