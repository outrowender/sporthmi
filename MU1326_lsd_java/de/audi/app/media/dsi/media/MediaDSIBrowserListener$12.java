/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaDSIBrowserListener;

class MediaDSIBrowserListener$12
implements Runnable {
    private final /* synthetic */ long val$deviceID;
    private final /* synthetic */ long val$mediaID;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$12(MediaDSIBrowserListener mediaDSIBrowserListener, long l, long l2) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$deviceID = l;
        this.val$mediaID = l2;
    }

    @Override
    public void run() {
        if (MediaDSIBrowserListener.access$4200(this.this$0).isInfo()) {
            MediaDSIBrowserListener.access$4300(this.this$0).log(1078071040, "[%1.updateBrowseMedia] [%4] deviceID='%2', mediaID='%3'.", (Object)"MediaDSIBrowserListener", (Object)String.valueOf(this.val$deviceID), (Object)String.valueOf(this.val$mediaID), (Object)String.valueOf(MediaDSIBrowserListener.access$000(this.this$0).getInstanceID()));
        }
        MediaDSIBrowserListener.access$000(this.this$0).browserActivated(this.val$deviceID, this.val$mediaID);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("updateBrowseMedia").toString();
    }
}

