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
    private static final String LOGCLASS;
    private final long[] entryIds;
    private final int clientId;

    public JobBrowseListRequestPickList(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl, long[] lArray, int n) {
        super(logChannel, iMediaDSIBrowserController, browseListContextImpl);
        this.entryIds = lArray;
        this.clientId = n;
    }

    @Override
    public int getType() {
        return 6;
    }

    @Override
    public String getName() {
        return "requestPickList";
    }

    @Override
    public void start() {
        this.logChannel.log(1078071040, "[%1.start]", (Object)"JobBrowseListRequestPickList");
        this.dsiMediaBrowser.requestPickList(this.entryIds, this.clientId);
    }

    @Override
    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
        this.logChannel.log(1078071040, "[%1.responsePickList]", (Object)"JobBrowseListRequestPickList");
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void updateListSize(int n, int n2) {
        this.logChannel.log(14808325, "[%1.updateListSize]", (Object)"JobBrowseListRequestPickList");
        this.browseListContext.getState().setCurrentListSize(n);
        this.browseListContext.notifyListUpdated(n);
    }
}

