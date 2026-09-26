/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$10
extends AbstractDispatcherRunnable {
    private final /* synthetic */ String val$url;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$10(MediaDSIPlayerListener mediaDSIPlayerListener, String string, String string2) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$url = string2;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$2700(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$2800(this.this$0).log(1078071040, "[%1.responseSetPlaybackURL] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)this.val$url);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responseSetPlaybackURL(this.val$url);
    }
}

