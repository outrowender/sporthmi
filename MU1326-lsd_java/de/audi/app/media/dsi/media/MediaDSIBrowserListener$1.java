/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaBrowserListListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.app.media.logger.LogUtil;
import org.dsi.ifc.media.ListEntry;

class MediaDSIBrowserListener$1
implements Runnable {
    private final /* synthetic */ int val$index;
    private final /* synthetic */ ListEntry[] val$entrylist;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$1(MediaDSIBrowserListener mediaDSIBrowserListener, int n, ListEntry[] listEntryArray) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$index = n;
        this.val$entrylist = listEntryArray;
    }

    @Override
    public void run() {
        MediaDSIBrowserListener.access$100(this.this$0).log(1078071040, "[%1.responseList] [%3] index='%2'.", (Object)"MediaDSIBrowserListener", (long)this.val$index, (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
        RequestParameterList requestParameterList = (RequestParameterList)MediaDSIBrowserListener.access$000(this.this$0).getRequestListHandler().dataResponded();
        if (requestParameterList == null || requestParameterList.isOutdated()) {
            MediaDSIBrowserListener.access$200(this.this$0).log(-1601830656, "[%1.responseList] [%2] Request is out dated. Ignore.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
            return;
        }
        if (this.val$entrylist == null) {
            MediaDSIBrowserListener.access$300(this.this$0).log(-1601830656, "[%1.responseList] [%2] Response list is null. Ignore.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
            return;
        }
        LogUtil.logEntryList(MediaDSIBrowserListener.access$400(this.this$0), MediaDSIBrowserListener.access$500(this.this$0), this.val$entrylist);
        IMediaBrowserListListener iMediaBrowserListListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserListListener(requestParameterList.getClientID());
        if (iMediaBrowserListListener == null) {
            MediaDSIBrowserListener.access$600(this.this$0).log(-1601830656, "[%1.responseList] [%2] No client with ID '%3' registered. Ignore.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID(), (long)requestParameterList.getClientID());
            return;
        }
        iMediaBrowserListListener.responseList(MediaListEntry.convert(this.val$entrylist), this.val$index);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("responseList").toString();
    }
}

