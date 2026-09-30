/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.log.LogChannel;

public abstract class AbstractJobBrowseList
extends AbstractQueueJob {
    protected static final int BROWSE_JOB_NONE = 0;
    protected static final int BROWSE_JOB_SETMODE = 1;
    protected static final int BROWSE_JOB_CHANGEFOLDER = 2;
    protected static final int BROWSE_JOB_RESET_SELECTION = 3;
    protected static final int BROWSE_JOB_ADD_SELECTION = 4;
    protected static final int BROWSE_JOB_REQUESTLIST = 5;
    protected static final int BROWSE_JOB_REQUESTPICKLIST = 6;
    protected static final int BROWSE_JOB_RESET = 7;
    protected final LogChannel logChannel;
    protected final IMediaDSIBrowserController dsiMediaBrowser;
    protected final BrowseListContextImpl browseListContext;

    public AbstractJobBrowseList(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl) {
        this.logChannel = logChannel;
        this.dsiMediaBrowser = iMediaDSIBrowserController;
        this.browseListContext = browseListContextImpl;
    }

    public void abort(boolean bl) {
    }

    public void updateBrowseMode(int n) {
    }

    public void updateContentFilter(int n) {
    }

    public void updateListSize(int n, int n2) {
    }

    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
    }

    public void errorFolderChange() {
    }

    public void errorBrowseMode() {
    }

    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
    }

    public void errorSelection() {
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
    }
}

