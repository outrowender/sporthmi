/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaBrowserSearchListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;

class MediaDSIBrowserListener$8
implements Runnable {
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ int val$searchSpellerState;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$8(MediaDSIBrowserListener mediaDSIBrowserListener, int n, int n2) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$validFlag = n;
        this.val$searchSpellerState = n2;
    }

    @Override
    public void run() {
        if (!MediaDSIBrowserListener.access$3000(this.this$0, "updateSearchSpellerState", MediaDSIBrowserListener.access$000(this.this$0).getInstanceID(), this.val$validFlag)) {
            return;
        }
        MediaDSIBrowserListener.access$3100(this.this$0).log(1078071040, "[%1.updateSearchSpellerState] [%2] '%3'.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID(), (long)this.val$searchSpellerState);
        IMediaBrowserSearchListener iMediaBrowserSearchListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserSearchListener();
        if (iMediaBrowserSearchListener == null) {
            MediaDSIBrowserListener.access$3200(this.this$0).log(-1601830656, "[%1.updateSearchSpellerState] No search listener registered!", (Object)"MediaDSIBrowserListener");
            return;
        }
        iMediaBrowserSearchListener.updateSearchSpellerState(this.val$searchSpellerState);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("updateSearchSpellerState").toString();
    }
}

