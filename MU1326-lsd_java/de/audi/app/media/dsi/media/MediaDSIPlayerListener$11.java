/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$11
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$tempPml;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$11(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$tempPml = n;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$2900(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$3000(this.this$0).log(1078071040, "[%1.tempPMLRequest] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (long)this.val$tempPml);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responseTempPMLRequest(this.val$tempPml);
    }
}

