/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.browser.JobBrowseListRequestList;
import de.audi.app.media.queue.IQueueCommand;
import de.audi.app.media.queue.IQueueJob;
import java.util.Iterator;
import java.util.List;

class BrowseListContextImpl$2
implements IQueueCommand {
    private final /* synthetic */ int val$clientID;
    private final /* synthetic */ BrowseListContextImpl this$0;

    BrowseListContextImpl$2(BrowseListContextImpl browseListContextImpl, int n) {
        this.this$0 = browseListContextImpl;
        this.val$clientID = n;
    }

    @Override
    public void execute(IQueueJob iQueueJob, List list) {
        AbstractJobBrowseList abstractJobBrowseList;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            JobBrowseListRequestList jobBrowseListRequestList;
            abstractJobBrowseList = (AbstractJobBrowseList)iterator.next();
            if (!(abstractJobBrowseList instanceof JobBrowseListRequestList) || (jobBrowseListRequestList = (JobBrowseListRequestList)abstractJobBrowseList).getClientId() != this.val$clientID) continue;
            BrowseListContextImpl.access$000(this.this$0).log(-2137614336, "[%1.discardListRequest] Remove ListRequest ('%2').", (Object)"BrowseListContextImpl", (Object)abstractJobBrowseList);
            list.remove(jobBrowseListRequestList);
            iterator = list.iterator();
        }
        if (iQueueJob instanceof JobBrowseListRequestList && ((JobBrowseListRequestList)(abstractJobBrowseList = (JobBrowseListRequestList)iQueueJob)).getClientId() == this.val$clientID) {
            ((JobBrowseListRequestList)abstractJobBrowseList).abort(true);
        }
    }
}

