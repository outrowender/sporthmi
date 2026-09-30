/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.atip.log.LogChannel;

class JobBrowseListResetSelection
extends AbstractJobBrowseList {
    private static final String LOGCLASS = "JobBrowseListResetSelection";

    public JobBrowseListResetSelection(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl) {
        super(logChannel, iMediaDSIBrowserController, browseListContextImpl);
    }

    public int getType() {
        return 3;
    }

    public String getName() {
        return "ResetSelection";
    }

    public void start() {
        this.logChannel.log(100000000, "[%1.start]", (Object)LOGCLASS);
        this.dsiMediaBrowser.resetSelection();
    }

    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        this.logChannel.log(100000000, "[%1.selectionResult]", (Object)LOGCLASS);
        this.browseListContext.notifySelectionReset(false, n);
        this.getExecutionContext().jobFinished();
    }

    public void errorSelection() {
        this.logChannel.log(1000000, "[%1.errorSelection]", (Object)LOGCLASS);
        this.browseListContext.notifySelectionReset(true, 0);
        this.getExecutionContext().jobFinished();
    }

    public void updateListSize(int n, int n2) {
        this.logChannel.log(100000000, "[%1.updateListSize]", (Object)LOGCLASS);
        this.browseListContext.getState().setCurrentListSize(n);
        this.browseListContext.notifyListUpdated(n);
    }

    public String toString() {
        return "";
    }
}

