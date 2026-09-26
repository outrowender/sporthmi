/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$15
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$activeVideoAngle;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$15(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$activeVideoAngle = n;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$3800(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$3900(this.this$0).log(1078071040, "[%1.updateActiveVideoAngle] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (long)this.val$activeVideoAngle);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updateActiveVideoAngle(this.val$activeVideoAngle);
    }
}

