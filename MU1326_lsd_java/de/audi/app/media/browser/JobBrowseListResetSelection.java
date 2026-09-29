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
    private static final String LOGCLASS;

    public JobBrowseListResetSelection(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl) {
        super(logChannel, iMediaDSIBrowserController, browseListContextImpl);
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public String getName() {
        return "ResetSelection";
    }

    @Override
    public void start() {
        this.logChannel.log(14808325, "[%1.start]", (Object)"JobBrowseListResetSelection");
        this.dsiMediaBrowser.resetSelection();
    }

    @Override
    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        this.logChannel.log(14808325, "[%1.selectionResult]", (Object)"JobBrowseListResetSelection");
        this.browseListContext.notifySelectionReset(false, n);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void errorSelection() {
        this.logChannel.log(1078071040, "[%1.errorSelection]", (Object)"JobBrowseListResetSelection");
        this.browseListContext.notifySelectionReset(true, 0);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void updateListSize(int n, int n2) {
        this.logChannel.log(14808325, "[%1.updateListSize]", (Object)"JobBrowseListResetSelection");
        this.browseListContext.getState().setCurrentListSize(n);
        this.browseListContext.notifyListUpdated(n);
    }

    public String toString() {
        return "";
    }
}

