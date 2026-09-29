/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;

class MediaDSIBrowserListener$11
extends AbstractDispatcherRunnable {
    private final /* synthetic */ long val$deviceID;
    private final /* synthetic */ long val$mediaID;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$11(MediaDSIBrowserListener mediaDSIBrowserListener, String string, long l, long l2) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$deviceID = l;
        this.val$mediaID = l2;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIBrowserListener.access$4100(this.this$0).log(1078071040, "[%1.updateBrowseMedia] [%2] Invalidation.", (Object)"MediaDSIBrowserListener", (Object)new Integer(MediaDSIBrowserListener.access$000(this.this$0).getInstanceID()));
        MediaDSIBrowserListener.access$000(this.this$0).browserInvalidated(this.val$deviceID, this.val$mediaID);
    }
}

