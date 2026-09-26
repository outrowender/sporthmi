/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$23
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pvCount;
    private final /* synthetic */ int val$pvFlags;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$23(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n, int n2) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$pvCount = n;
        this.val$pvFlags = n2;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$5000(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$5100(this.this$0).log(1078071040, "[%1.updatePlayViewSize] [%2] count='%3', flags='%4'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)new Integer(this.val$pvCount), (Object)new Integer(this.val$pvFlags));
        }
        if (this.val$pvCount < 0) {
            MediaDSIPlayerListener.access$5200(this.this$0).log(-1601830656, "[%1.updatePlayViewSize] Receive invalid count '%2'. Ignore.", (Object)"MediaDSIPlayerListener", (long)this.val$pvCount);
            return;
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updatePlayViewSize(this.val$pvCount, this.val$pvFlags);
    }
}

