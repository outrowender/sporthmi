/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$19
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$numVideoAngles;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$19(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$numVideoAngles = n;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$4600(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$4700(this.this$0).log(1078071040, "[%1.updateNumVideoAngles] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (long)this.val$numVideoAngles);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updateNumVideoAngles(this.val$numVideoAngles);
    }
}

