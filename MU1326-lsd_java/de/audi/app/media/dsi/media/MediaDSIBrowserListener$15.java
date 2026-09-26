/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;

class MediaDSIBrowserListener$15
implements Runnable {
    private final /* synthetic */ int val$listSizeCount;
    private final /* synthetic */ int val$listSizeFlags;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$15(MediaDSIBrowserListener mediaDSIBrowserListener, int n, int n2) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$listSizeCount = n;
        this.val$listSizeFlags = n2;
    }

    @Override
    public void run() {
        if (MediaDSIBrowserListener.access$4900(this.this$0).isInfo()) {
            MediaDSIBrowserListener.access$5000(this.this$0).log(1078071040, "[%1.updateListSize] [%4] size='%2', flags='%3'.", (Object)"MediaDSIBrowserListener", (Object)String.valueOf(this.val$listSizeCount), (Object)String.valueOf(this.val$listSizeFlags), (Object)String.valueOf(MediaDSIBrowserListener.access$000(this.this$0).getInstanceID()));
        }
        if (this.val$listSizeCount < 0) {
            MediaDSIBrowserListener.access$5100(this.this$0).log(-1601830656, "[%1.updateListSize] [%2] List size < 0. Ignore.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
            return;
        }
        IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserStateListener();
        if (iMediaBrowserStateListener == null) {
            MediaDSIBrowserListener.access$5200(this.this$0).log(-1601830656, "[%1.updateListSize] No state listener registered!", (Object)"MediaDSIBrowserListener");
            return;
        }
        iMediaBrowserStateListener.updateListSize(this.val$listSizeCount, this.val$listSizeFlags);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("updateListSize").toString();
    }
}

