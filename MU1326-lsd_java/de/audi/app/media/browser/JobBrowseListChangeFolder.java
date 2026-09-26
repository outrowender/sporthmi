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
    private static final String LOGCLASS;
    private static final int INVALID_LIST_SIZE;
    private final MediaListEntry[] requestedFolderpath;
    private volatile int currentListSize = -1;
    private MediaListEntry[] activeBrowsingFolder;

    public JobBrowseListChangeFolder(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl, MediaListEntry[] mediaListEntryArray) {
        super(logChannel, iMediaDSIBrowserController, browseListContextImpl);
        this.requestedFolderpath = mediaListEntryArray;
    }

    @Override
    public int getType() {
        return 2;
    }

    @Override
    public String getName() {
        return "changeFolder";
    }

    @Override
    public void start() {
        if (MediaUtils.isSameFolder(this.browseListContext.getState().getCurrentBrowseFolder(), this.requestedFolderpath)) {
            this.logChannel.log(1078071040, "[%1.start] Same folder, don't change the folder.", (Object)"JobBrowseListChangeFolder");
            this.activeBrowsingFolder = this.requestedFolderpath;
            this.currentListSize = this.browseListContext.getState().getCurrentListSize();
            this.finishJob();
        } else {
            this.logChannel.log(14808325, "[%1.start] Change folder.", (Object)"JobBrowseListChangeFolder");
            this.dsiMediaBrowser.changeFolder(this.requestedFolderpath);
        }
    }

    @Override
    public void updateListSize(int n, int n2) {
        this.logChannel.log(1078071040, "[%1.updateListSize]", (Object)"JobBrowseListChangeFolder");
        this.currentListSize = n;
        if (this.activeBrowsingFolder != null) {
            this.finishJob();
        }
    }

    @Override
    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        this.logChannel.log(1078071040, "[%1.updateBrowseFolder]", (Object)"JobBrowseListChangeFolder");
        this.activeBrowsingFolder = mediaListEntryArray;
    }

    @Override
    public void errorFolderChange() {
        this.browseListContext.notifyBrowseFolderChanged(true, null, -1);
        this.getExecutionContext().jobFinished();
    }

    private void finishJob() {
        this.logChannel.log(14808325, "[%1.finishJob]", (Object)"JobBrowseListChangeFolder");
        this.browseListContext.getState().setCurrentListSize(this.currentListSize);
        this.browseListContext.getState().setCurrentBrowseFolder(this.activeBrowsingFolder);
        this.browseListContext.notifyBrowseFolderChanged(false, this.activeBrowsingFolder, this.currentListSize);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        return LogUtil.listEntryToStr(this.requestedFolderpath);
    }
}

