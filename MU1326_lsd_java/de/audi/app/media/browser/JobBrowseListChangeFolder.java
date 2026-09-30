/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import de.audi.atip.log.LogChannel;

class JobBrowseListChangeFolder
extends AbstractJobBrowseList {
    private static final String LOGCLASS = "JobBrowseListChangeFolder";
    private static final int INVALID_LIST_SIZE = -1;
    private final MediaListEntry[] requestedFolderpath;
    private volatile int currentListSize = -1;
    private MediaListEntry[] activeBrowsingFolder;

    public JobBrowseListChangeFolder(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl, MediaListEntry[] mediaListEntryArray) {
        super(logChannel, iMediaDSIBrowserController, browseListContextImpl);
        this.requestedFolderpath = mediaListEntryArray;
    }

    public int getType() {
        return 2;
    }

    public String getName() {
        return "changeFolder";
    }

    public void start() {
        if (MediaUtils.isSameFolder(this.browseListContext.getState().getCurrentBrowseFolder(), this.requestedFolderpath)) {
            this.logChannel.log(1000000, "[%1.start] Same folder, don't change the folder.", (Object)LOGCLASS);
            this.activeBrowsingFolder = this.requestedFolderpath;
            this.currentListSize = this.browseListContext.getState().getCurrentListSize();
            this.finishJob();
        } else {
            this.logChannel.log(100000000, "[%1.start] Change folder.", (Object)LOGCLASS);
            this.dsiMediaBrowser.changeFolder(this.requestedFolderpath);
        }
    }

    public void updateListSize(int n, int n2) {
        this.logChannel.log(1000000, "[%1.updateListSize]", (Object)LOGCLASS);
        this.currentListSize = n;
        if (this.activeBrowsingFolder != null) {
            this.finishJob();
        }
    }

    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        this.logChannel.log(1000000, "[%1.updateBrowseFolder]", (Object)LOGCLASS);
        this.activeBrowsingFolder = mediaListEntryArray;
    }

    public void errorFolderChange() {
        this.browseListContext.notifyBrowseFolderChanged(true, null, -1);
        this.getExecutionContext().jobFinished();
    }

    private void finishJob() {
        this.logChannel.log(100000000, "[%1.finishJob]", (Object)LOGCLASS);
        this.browseListContext.getState().setCurrentListSize(this.currentListSize);
        this.browseListContext.getState().setCurrentBrowseFolder(this.activeBrowsingFolder);
        this.browseListContext.notifyBrowseFolderChanged(false, this.activeBrowsingFolder, this.currentListSize);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        return LogUtil.listEntryToStr(this.requestedFolderpath);
    }
}

