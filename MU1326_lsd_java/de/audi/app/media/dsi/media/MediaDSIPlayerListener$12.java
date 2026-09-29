/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$12
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$activeAudioStream;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$12(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$activeAudioStream = n;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$3100(this.this$0).log(1078071040, "[%1.updateActiveAudioStream] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID(), (long)this.val$activeAudioStream);
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updateActiveAudioStream(this.val$activeAudioStream);
    }
}

