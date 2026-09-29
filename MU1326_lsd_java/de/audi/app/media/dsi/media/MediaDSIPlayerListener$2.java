/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$command;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$2(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$command = n;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$200(this.this$0).log(1078071040, "[%1.responseCmdBlocked] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID(), (long)this.val$command);
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responseCmdBlocked(this.val$command);
    }
}

