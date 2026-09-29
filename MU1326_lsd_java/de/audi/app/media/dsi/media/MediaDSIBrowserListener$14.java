/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;

class MediaDSIBrowserListener$14
implements Runnable {
    private final /* synthetic */ int val$contentFilterMask;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$14(MediaDSIBrowserListener mediaDSIBrowserListener, int n) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$contentFilterMask = n;
    }

    @Override
    public void run() {
        IMediaBrowserStateListener iMediaBrowserStateListener;
        if (MediaDSIBrowserListener.access$4600(this.this$0).isInfo()) {
            MediaDSIBrowserListener.access$4700(this.this$0).log(1078071040, "[%1.updateContentFilter] [%3] '%2'.", (Object)"MediaDSIBrowserListener", (long)this.val$contentFilterMask, (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
        }
        if ((iMediaBrowserStateListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserStateListener()) == null) {
            MediaDSIBrowserListener.access$4800(this.this$0).log(-1601830656, "[%1.updateContentFilter] No state listener registered!", (Object)"MediaDSIBrowserListener");
            return;
        }
        iMediaBrowserStateListener.updateContentFilter(this.val$contentFilterMask);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("updateContentFilter").toString();
    }
}

