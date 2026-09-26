/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaBrowserSearchListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;

class MediaDSIBrowserListener$6
implements Runnable {
    private final /* synthetic */ String val$searchString;
    private final /* synthetic */ boolean val$result;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$6(MediaDSIBrowserListener mediaDSIBrowserListener, String string, boolean bl) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$searchString = string;
        this.val$result = bl;
    }

    @Override
    public void run() {
        MediaDSIBrowserListener.access$2400(this.this$0).log(1078071040, "[%1.responseSetSearchString] [%3] '%2'", (Object)"MediaDSIBrowserListener", (Object)this.val$searchString, (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
        IMediaBrowserSearchListener iMediaBrowserSearchListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserSearchListener();
        if (iMediaBrowserSearchListener == null) {
            MediaDSIBrowserListener.access$2500(this.this$0).log(-1601830656, "[%1.responseSetSearchString] No search listener registered!", (Object)"MediaDSIBrowserListener");
            return;
        }
        iMediaBrowserSearchListener.responseSetSearchString(this.val$searchString, this.val$result);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("responseSetSearchString").toString();
    }
}

