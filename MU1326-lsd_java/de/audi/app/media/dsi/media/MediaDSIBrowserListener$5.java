/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaDSIBrowserListener;
import de.esolutions.fw.util.commons.Buffer;

class MediaDSIBrowserListener$5
implements Runnable {
    private final /* synthetic */ int val$searchCriteriaMask;
    private final /* synthetic */ boolean val$result;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$5(MediaDSIBrowserListener mediaDSIBrowserListener, int n, boolean bl) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$searchCriteriaMask = n;
        this.val$result = bl;
    }

    @Override
    public void run() {
        Object object;
        if (MediaDSIBrowserListener.access$2100(this.this$0).isInfo()) {
            object = new Buffer();
            ((Buffer)object).append("mask='").append(this.val$searchCriteriaMask).append("',result='").append(this.val$result).append("'");
            MediaDSIBrowserListener.access$2200(this.this$0).log(1078071040, "[%1.responseSetSearchCriteria] [%3] %2", (Object)"MediaDSIBrowserListener", object, (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
        }
        if ((object = MediaDSIBrowserListener.access$000(this.this$0).getBrowserSearchListener()) == null) {
            MediaDSIBrowserListener.access$2300(this.this$0).log(-1601830656, "[%1.responseSetSearchCriteria] No search listener registered!", (Object)"MediaDSIBrowserListener");
            return;
        }
        object.responseSetSearchCriteria(this.val$searchCriteriaMask, this.val$result);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("responseSetSearchCriteria").toString();
    }
}

