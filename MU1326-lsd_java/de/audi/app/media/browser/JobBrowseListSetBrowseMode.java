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
    private static final String LOGCLASS;
    private final int browseModeToSet;
    private volatile int currentListSize;
    private volatile MediaListEntry[] activeBrowsingFolder;
    private volatile int setBrowseMode;

    public JobBrowseListSetBrowseMode(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl, int n) {
        super(logChannel, iMediaDSIBrowserController, browseListContextImpl);
        this.browseModeToSet = n;
        this.currentListSize = -1;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public String getName() {
        return "setBrowseMode";
    }

    @Override
    public void start() {
        this.logChannel.log(14808325, "[%1.start]", (Object)"JobBrowseListSetBrowseMode");
        if (this.browseModeToSet == this.browseListContext.getBrowseMode()) {
            this.logChannel.log(1078071040, "[%1.start] Browse mode already set. Not changing.", (Object)"JobBrowseListSetBrowseMode");
            this.setBrowseMode = this.browseModeToSet;
            this.currentListSize = this.browseListContext.getListSize();
            this.activeBrowsingFolder = this.browseListContext.getBrowseFolder();
            this.finishJob();
        } else {
            this.dsiMediaBrowser.setBrowseMode(JobBrowseListSetBrowseMode.getDSIBrowseMode(this.browseModeToSet));
        }
    }

    @Override
    public void updateBrowseMode(int n) {
        this.setBrowseMode = JobBrowseListSetBrowseMode.getBrowseModeOfDSI(n);
        this.logChannel.log(1078071040, "[%1.updateBrowseMode] '%2'", (Object)"JobBrowseListSetBrowseMode", (Object)(this.setBrowseMode == 0 ? "RAW" : "DATABASE"));
        this.dsiMediaBrowser.setContentFilter(7);
    }

    @Override
    public void updateListSize(int n, int n2) {
        this.logChannel.log(1078071040, "[%1.updateListSize]", (Object)"JobBrowseListSetBrowseMode");
        this.currentListSize = n;
        this.dsiMediaBrowser.enableRecurseSubdirectories(true);
        if (this.activeBrowsingFolder != null) {
            this.finishJob();
        }
    }

    @Override
    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        this.logChannel.log(1078071040, "[%1.updateBrowseFolder]", (Object)"JobBrowseListSetBrowseMode");
        this.activeBrowsingFolder = mediaListEntryArray;
    }

    @Override
    public void errorBrowseMode() {
        this.logChannel.log(10000, "[%1.errorBrowseMode]", (Object)"JobBrowseListSetBrowseMode");
        this.browseListContext.notifyBrowseModeChanged(true, -1);
        this.getExecutionContext().jobFinished();
    }

    private void finishJob() {
        this.logChannel.log(14808325, "[%1.finishJob]", (Object)"JobBrowseListSetBrowseMode");
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

