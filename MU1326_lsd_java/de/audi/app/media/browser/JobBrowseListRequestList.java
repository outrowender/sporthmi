/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class JobBrowseListRequestList
extends AbstractJobBrowseList {
    private static final String LOGCLASS = "JobBrowseListRequestList";
    private final long entryId;
    private final int contentType;
    private final int index;
    private final int size;
    private final int clientId;

    public JobBrowseListRequestList(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl, long l, int n, int n2, int n3, int n4) {
        super(logChannel, iMediaDSIBrowserController, browseListContextImpl);
        this.entryId = l;
        this.contentType = n;
        this.index = n2;
        this.size = n3;
        this.clientId = n4;
    }

    public int getType() {
        return 5;
    }

    public String getName() {
        return "requestList";
    }

    public void start() {
        this.logChannel.log(1000000, "[%1.start]", (Object)LOGCLASS);
        this.dsiMediaBrowser.requestList(this.entryId, this.contentType, this.index, this.size, this.clientId);
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logChannel.log(1000000, "[%1.responseList]", (Object)LOGCLASS);
        this.getExecutionContext().jobFinished();
    }

    public int getClientId() {
        return this.clientId;
    }

    public void abort(boolean bl) {
        if (bl) {
            this.getExecutionContext().jobFinished();
        }
    }

    public void updateListSize(int n, int n2) {
        this.logChannel.log(100000000, "[%1.updateListSize]", (Object)LOGCLASS);
        this.browseListContext.getState().setCurrentListSize(n);
        this.browseListContext.notifyListUpdated(n);
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("'");
        buffer.append("entryId=").append(this.entryId).append(", ");
        buffer.append("contentType=").append(this.contentType).append(", ");
        buffer.append("index=").append(this.index).append(", ");
        buffer.append("size='").append(this.size);
        buffer.append("'");
        return buffer.toString();
    }
}

