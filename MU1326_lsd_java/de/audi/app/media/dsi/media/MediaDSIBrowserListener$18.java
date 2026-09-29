/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaBrowserListListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.dsi.media.requests.RequestPickListParameterList;
import de.audi.app.media.logger.LogUtil;
import org.dsi.ifc.media.ListEntry;

class MediaDSIBrowserListener$18
implements Runnable {
    private final /* synthetic */ ListEntry[] val$entrylist;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$18(MediaDSIBrowserListener mediaDSIBrowserListener, ListEntry[] listEntryArray) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$entrylist = listEntryArray;
    }

    @Override
    public void run() {
        MediaDSIBrowserListener.access$5900(this.this$0).log(1078071040, "[%1.responsePickList] [%2] ", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
        RequestPickListParameterList requestPickListParameterList = (RequestPickListParameterList)MediaDSIBrowserListener.access$000(this.this$0).getRequestPickListHandler().dataResponded();
        if (requestPickListParameterList == null || requestPickListParameterList.isOutdated()) {
            MediaDSIBrowserListener.access$6000(this.this$0).log(-1601830656, "[%1.responsePickList] [%2] Request is out dated. Ignore.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
            return;
        }
        if (this.val$entrylist == null) {
            MediaDSIBrowserListener.access$6100(this.this$0).log(-1601830656, "[%1.responsePickList] [%2] Response list is null. Ignore.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
            return;
        }
        LogUtil.logEntryList(MediaDSIBrowserListener.access$6200(this.this$0), MediaDSIBrowserListener.access$6300(this.this$0), this.val$entrylist);
        IMediaBrowserListListener iMediaBrowserListListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserListListener(requestPickListParameterList.getClientID());
        if (iMediaBrowserListListener == null) {
            MediaDSIBrowserListener.access$6400(this.this$0).log(-1601830656, "[%1.responsePickList] [%2] No client with ID '%3' registered. Ignore.", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID(), (long)requestPickListParameterList.getClientID());
            return;
        }
        iMediaBrowserListListener.responsePickList(MediaListEntry.convert(this.val$entrylist));
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("responsePickList").toString();
    }
}

