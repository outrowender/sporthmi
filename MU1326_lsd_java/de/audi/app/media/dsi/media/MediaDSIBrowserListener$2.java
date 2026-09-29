/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaBrowserSearchListListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.app.media.logger.LogUtil;
import org.dsi.ifc.media.SearchListEntry;

class MediaDSIBrowserListener$2
implements Runnable {
    private final /* synthetic */ int val$index;
    private final /* synthetic */ SearchListEntry[] val$searchlist;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$2(MediaDSIBrowserListener mediaDSIBrowserListener, int n, SearchListEntry[] searchListEntryArray) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$index = n;
        this.val$searchlist = searchListEntryArray;
    }

    @Override
    public void run() {
        MediaDSIBrowserListener.access$800(this.this$0).log(1078071040, "[%1.responseSearchList] [%2] index='%3'.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID(), (long)this.val$index);
        RequestParameterList requestParameterList = (RequestParameterList)MediaDSIBrowserListener.access$000(this.this$0).getRequestSearchResultListHandler().dataResponded();
        if (requestParameterList == null || requestParameterList.isOutdated()) {
            MediaDSIBrowserListener.access$900(this.this$0).log(-1601830656, "[%1.responseSearchList] [%2] Request is out dated. Ignore.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
            return;
        }
        if (this.val$searchlist == null) {
            MediaDSIBrowserListener.access$1000(this.this$0).log(-1601830656, "[%1.responseSearchList] [%2] Searchlist is null. Ignoring.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
            return;
        }
        LogUtil.logSearchList(MediaDSIBrowserListener.access$1100(this.this$0), this.val$searchlist);
        IMediaBrowserSearchListListener iMediaBrowserSearchListListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserSearchListListener(requestParameterList.getClientID());
        if (iMediaBrowserSearchListListener == null) {
            MediaDSIBrowserListener.access$1200(this.this$0).log(-1601830656, "[%1.responseSearchList] [%2] No client with ID '%3' available. Ignoring.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID(), (long)requestParameterList.getClientID());
            return;
        }
        iMediaBrowserSearchListListener.responseSearchList(this.val$searchlist, this.val$index);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("responseSearchList").toString();
    }
}

