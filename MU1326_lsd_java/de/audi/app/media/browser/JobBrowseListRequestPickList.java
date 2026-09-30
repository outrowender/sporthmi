/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;

public class JobBrowseListRequestPickList
extends AbstractJobBrowseList {
    private static final String LOGCLASS = "JobBrowseListRequestPickList";
    private final long[] entryIds;
    private final int clientId;

    public JobBrowseListRequestPickList(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl, long[] lArray, int n) {
        super(logChannel, iMediaDSIBrowserController, browseListContextImpl);
        this.entryIds = lArray;
        this.clientId = n;
    }

    public int getType() {
        return 6;
    }

    public String getName() {
        return "requestPickList";
    }

    public void start() {
        this.logChannel.log(1000000, "[%1.start]", (Object)LOGCLASS);
        this.dsiMediaBrowser.requestPickList(this.entryIds, this.clientId);
    }

    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
        this.logChannel.log(1000000, "[%1.responsePickList]", (Object)LOGCLASS);
        this.getExecutionContext().jobFinished();
    }

    public void updateListSize(int n, int n2) {
        this.logChannel.log(100000000, "[%1.updateListSize]", (Object)LOGCLASS);
        this.browseListContext.getState().setCurrentListSize(n);
        this.browseListContext.notifyListUpdated(n);
    }
}

