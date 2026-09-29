/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaDSIBrowserListener;
import de.esolutions.fw.util.commons.Buffer;

class MediaDSIBrowserListener$4
implements Runnable {
    private final /* synthetic */ long val$searchID;
    private final /* synthetic */ long val$entryID;
    private final /* synthetic */ boolean val$result;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$4(MediaDSIBrowserListener mediaDSIBrowserListener, long l, long l2, boolean bl) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$searchID = l;
        this.val$entryID = l2;
        this.val$result = bl;
    }

    @Override
    public void run() {
        Object object;
        if (MediaDSIBrowserListener.access$1800(this.this$0).isInfo()) {
            object = new Buffer();
            ((Buffer)object).append("seachID='").append(this.val$searchID).append("',entryID='").append(this.val$entryID).append("',result='").append(this.val$result).append("'");
            MediaDSIBrowserListener.access$1900(this.this$0).log(1078071040, "[%1.responseSelectSearchResult] [%3] %2", (Object)"MediaDSIBrowserListener", object, (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
        }
        if ((object = MediaDSIBrowserListener.access$000(this.this$0).getBrowserSearchListener()) == null) {
            MediaDSIBrowserListener.access$2000(this.this$0).log(-1601830656, "[%1.responseSelectSearchResult] No search listener registered!", (Object)"MediaDSIBrowserListener");
            return;
        }
        object.responseSelectSearchResult(this.val$searchID, this.val$entryID, this.val$result);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("responseSelectSearchResult").toString();
    }
}

