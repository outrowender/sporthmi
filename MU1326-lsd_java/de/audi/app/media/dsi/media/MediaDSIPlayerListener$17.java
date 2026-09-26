/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import org.dsi.ifc.media.Capabilities;

class MediaDSIPlayerListener$17
extends AbstractDispatcherRunnable {
    private final /* synthetic */ Capabilities val$capabilities;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$17(MediaDSIPlayerListener mediaDSIPlayerListener, String string, Capabilities capabilities) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$capabilities = capabilities;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$4200(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$4300(this.this$0).log(1078071040, "[%1.updateCapabilities] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)this.val$capabilities);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updateCapabilities(this.val$capabilities);
    }
}

