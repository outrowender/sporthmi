/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaPlayViewList;
import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.PlayViewListRequest;
import de.audi.app.media.dsi.media.MediaListEntry;

class AbstractMediaPlayViewList$PlayViewListDelayJob
implements Runnable {
    PlayViewListRequest request;
    private final /* synthetic */ AbstractMediaPlayViewList this$0;

    AbstractMediaPlayViewList$PlayViewListDelayJob(AbstractMediaPlayViewList abstractMediaPlayViewList, PlayViewListRequest playViewListRequest) {
        this.this$0 = abstractMediaPlayViewList;
        this.request = playViewListRequest;
    }

    @Override
    public void run() {
        if (!this.this$0.active) {
            return;
        }
        if (AbstractMediaPlayViewList.access$000(this.this$0) == -1 || !AbstractMediaPlayViewList.access$100(this.this$0)) {
            this.this$0.logger.log(1078071040, "[PlayViewListDelayJob.run] delay play view request %1]", (long)this.request.getRequestId());
            this.this$0.listRequestDelayDispatcher.execute(new AbstractMediaPlayViewList$PlayViewListDelayJob(this.this$0, this.request), 0);
            return;
        }
        AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.this$0.getCurrentFocusedRow();
        MediaListEntry mediaListEntry = null;
        int n = -1;
        if (abstractMediaPlayViewListRow != null && AbstractMediaPlayViewList.access$200(this.this$0) != null && AbstractMediaPlayViewList.access$200(this.this$0).length != 0) {
            for (int i2 = 0; i2 < AbstractMediaPlayViewList.access$200(this.this$0).length; ++i2) {
                if (AbstractMediaPlayViewList.access$200(this.this$0)[i2].getEntryID() != abstractMediaPlayViewListRow.getEntryID()) continue;
                mediaListEntry = AbstractMediaPlayViewList.access$200(this.this$0)[i2];
                n = AbstractMediaPlayViewList.access$300(this.this$0) + i2;
                break;
            }
        }
        if (mediaListEntry != null) {
            this.this$0.logger.log(1078071040, "[PlayViewListDelayJob.run] return playview with focused entry as error reply %1]", (long)this.request.getRequestId());
            this.this$0.updateList(new MediaListEntry[]{mediaListEntry}, n, 0, this.request.getRequestId());
        } else {
            this.this$0.logger.log(1078071040, "[PlayViewListDelayJob.run] return empty playview as error reply %1]", (long)this.request.getRequestId());
            this.this$0.updateList(new MediaListEntry[0], 0, 0, this.request.getRequestId());
        }
    }
}

