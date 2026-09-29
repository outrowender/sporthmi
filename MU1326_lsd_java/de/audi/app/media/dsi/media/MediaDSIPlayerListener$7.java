/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.app.media.logger.LogUtil;
import org.dsi.ifc.media.ListEntry;

class MediaDSIPlayerListener$7
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pIndex;
    private final /* synthetic */ int val$pOrderCriteria;
    private final /* synthetic */ ListEntry[] val$pEntrylist;
    private final /* synthetic */ int val$pClientID;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$7(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n, int n2, ListEntry[] listEntryArray, int n3) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$pIndex = n;
        this.val$pOrderCriteria = n2;
        this.val$pEntrylist = listEntryArray;
        this.val$pClientID = n3;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$1900(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$2000(this.this$0).log(1078071040, "[%1.responsePlayView] [%2] index='%3', order='%4'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)new Integer(this.val$pIndex), (Object)new Integer(this.val$pOrderCriteria));
        }
        RequestParameterList requestParameterList = (RequestParameterList)MediaDSIPlayerListener.access$000(this.this$0).getRequestListHandler().dataResponded();
        LogUtil.logEntryList(MediaDSIPlayerListener.access$2100(this.this$0), MediaDSIPlayerListener.access$2200(this.this$0), this.val$pEntrylist);
        MediaListEntry[] mediaListEntryArray = MediaListEntry.convert(this.val$pEntrylist);
        this.this$0.exceptionController.responseReceived(this.val$pClientID);
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responsePlayView(requestParameterList, mediaListEntryArray, this.val$pOrderCriteria, this.val$pIndex);
    }
}

