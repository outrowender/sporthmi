/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.queue.IQueueCommand;
import de.audi.app.media.queue.IQueueJob;
import java.util.Iterator;
import java.util.List;

class BrowseListContextImpl$1
implements IQueueCommand {
    private final /* synthetic */ BrowseListContextImpl this$0;

    BrowseListContextImpl$1(BrowseListContextImpl browseListContextImpl) {
        this.this$0 = browseListContextImpl;
    }

    @Override
    public void execute(IQueueJob iQueueJob, List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractJobBrowseList abstractJobBrowseList = (AbstractJobBrowseList)iterator.next();
            if (abstractJobBrowseList.getType() != 4) continue;
            BrowseListContextImpl.access$000(this.this$0).log(-2137614336, "[%1.resetSelection] Remove AddSelection ('%2').", (Object)"BrowseListContextImpl", (Object)abstractJobBrowseList);
            iterator.remove();
        }
    }
}

