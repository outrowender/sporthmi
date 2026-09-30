/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;

class JobBrowseListSetBrowseMode
extends AbstractJobBrowseList {
    private static final String LOGCLASS = "JobBrowseListSetBrowseMode";
    private final int browseModeToSet;
    private volatile int currentListSize;
    private volatile MediaListEntry[] activeBrowsingFolder;
    private volatile int setBrowseMode;

    public JobBrowseListSetBrowseMode(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl, int n) {
        super(logChannel, iMediaDSIBrowserController, browseListContextImpl);
        this.browseModeToSet = n;
        this.currentListSize = -1;
    }

    public int getType() {
        return 1;
    }

    public String getName() {
        return "setBrowseMode";
    }

    public void start() {
        this.logChannel.log(100000000, "[%1.start]", (Object)LOGCLASS);
        if (this.browseModeToSet == this.browseListContext.getBrowseMode()) {
            this.logChannel.log(1000000, "[%1.start] Browse mode already set. Not changing.", (Object)LOGCLASS);
            this.setBrowseMode = this.browseModeToSet;
            this.currentListSize = this.browseListContext.getListSize();
            this.activeBrowsingFolder = this.browseListContext.getBrowseFolder();
            this.finishJob();
        } else {
            this.dsiMediaBrowser.setBrowseMode(JobBrowseListSetBrowseMode.getDSIBrowseMode(this.browseModeToSet));
        }
    }

    public void updateBrowseMode(int n) {
        this.setBrowseMode = JobBrowseListSetBrowseMode.getBrowseModeOfDSI(n);
        this.logChannel.log(1000000, "[%1.updateBrowseMode] '%2'", (Object)LOGCLASS, (Object)(this.setBrowseMode == 0 ? "RAW" : "DATABASE"));
        this.dsiMediaBrowser.setContentFilter(7);
    }

    public void updateListSize(int n, int n2) {
        this.logChannel.log(1000000, "[%1.updateListSize]", (Object)LOGCLASS);
        this.currentListSize = n;
        this.dsiMediaBrowser.enableRecurseSubdirectories(true);
        if (this.activeBrowsingFolder != null) {
            this.finishJob();
        }
    }

    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        this.logChannel.log(1000000, "[%1.updateBrowseFolder]", (Object)LOGCLASS);
        this.activeBrowsingFolder = mediaListEntryArray;
    }

    public void errorBrowseMode() {
        this.logChannel.log(10000, "[%1.errorBrowseMode]", (Object)LOGCLASS);
        this.browseListContext.notifyBrowseModeChanged(true, -1);
        this.getExecutionContext().jobFinished();
    }

    private void finishJob() {
        this.logChannel.log(100000000, "[%1.finishJob]", (Object)LOGCLASS);
        this.browseListContext.getState().setCurrentListSize(this.currentListSize);
        this.browseListContext.getState().setCurrentBrowseFolder(this.activeBrowsingFolder);
        this.browseListContext.getState().setCurrentBrowseMode(this.setBrowseMode);
        this.browseListContext.notifyBrowseFolderChanged(false, this.activeBrowsingFolder, this.currentListSize);
        this.browseListContext.notifyBrowseModeChanged(false, this.setBrowseMode);
        this.getExecutionContext().jobFinished();
    }

    private static int getDSIBrowseMode(int n) {
        return n == 0 ? 0 : 1;
    }

    private static int getBrowseModeOfDSI(int n) {
        return n == 0 ? 0 : 1;
    }

    public String toString() {
        return this.browseModeToSet == 0 ? "RAW" : "DATABASE";
    }
}

