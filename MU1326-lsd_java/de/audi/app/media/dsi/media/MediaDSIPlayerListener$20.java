/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$20
extends AbstractDispatcherRunnable {
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$20(MediaDSIPlayerListener mediaDSIPlayerListener, String string) {
        this.this$0 = mediaDSIPlayerListener;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$4800(this.this$0).log(1078071040, "[%1.updatePlayPosition] [%2] Invalidation.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()));
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().playPositionInvalidated();
    }
}

