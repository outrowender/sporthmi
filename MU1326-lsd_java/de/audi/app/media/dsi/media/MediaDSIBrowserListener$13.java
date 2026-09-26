/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;

class MediaDSIBrowserListener$13
implements Runnable {
    private final /* synthetic */ int val$browseMode;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$13(MediaDSIBrowserListener mediaDSIBrowserListener, int n) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$browseMode = n;
    }

    @Override
    public void run() {
        MediaDSIBrowserListener.access$4400(this.this$0).log(1078071040, "[%1.updateBrowseMode] [%3] '%2'.", (Object)"MediaDSIBrowserListener", (long)this.val$browseMode, (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
        IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserStateListener();
        if (iMediaBrowserStateListener == null) {
            MediaDSIBrowserListener.access$4500(this.this$0).log(-1601830656, "[%1.updateBrowseMode] No state listener registered!", (Object)"MediaDSIBrowserListener");
            return;
        }
        iMediaBrowserStateListener.updateBrowseMode(this.val$browseMode);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("updateBrowseMode").toString();
    }
}

