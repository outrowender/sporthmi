/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$22
extends AbstractDispatcherRunnable {
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$22(MediaDSIPlayerListener mediaDSIPlayerListener, String string) {
        this.this$0 = mediaDSIPlayerListener;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$4900(this.this$0).log(1078071040, "[%1.updatePlayViewSize] [%2] Invalidation.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()));
        this.this$0.exceptionController.invalidate();
        MediaDSIPlayerListener.access$000(this.this$0).getRequestListHandler().reset();
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().playViewSizeInvalidated();
    }
}

