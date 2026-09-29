/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import de.audi.app.media.logger.LogUtil;

class MediaDSIPlayerListener$27
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$playbackState;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$27(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$playbackState = n;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$6000(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$6100(this.this$0).log(1078071040, "[%1.updatePlaybackState] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)LogUtil.getPlaybackStateStr(this.val$playbackState));
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updatePlaybackState(this.val$playbackState);
    }
}

