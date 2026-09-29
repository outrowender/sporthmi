/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$dvdEvent;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$1(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$dvdEvent = n;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$100(this.this$0).log(1078071040, "[%1.indicationDvdEvent] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID(), (long)this.val$dvdEvent);
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().indicationDvdEvent(this.val$dvdEvent);
    }
}

