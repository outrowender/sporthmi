/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$14
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$activeSubtitle;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$14(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$activeSubtitle = n;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$3600(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$3700(this.this$0).log(1078071040, "[%1.updateActiveSubtitle] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (long)this.val$activeSubtitle);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updateActiveSubtitle(this.val$activeSubtitle);
    }
}

