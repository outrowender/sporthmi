/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;

final class JobBrowseListNone
extends AbstractJobBrowseList {
    private static final String LOGCLASS = "JobBrowseListNone";

    public JobBrowseListNone(LogChannel logChannel, BrowseListContextImpl browseListContextImpl) {
        super(logChannel, null, browseListContextImpl);
    }

    public int getType() {
        return 0;
    }

    public String getName() {
        return "None";
    }

    public void start() {
        this.logChannel.log(100000000, "[%1.start]", (Object)LOGCLASS);
        this.getExecutionContext().jobFinished();
    }

    public void updateListSize(int n, int n2) {
        this.logChannel.log(100000000, "[%1.updateListSize]", (Object)LOGCLASS);
        this.browseListContext.getState().setCurrentListSize(n);
        this.browseListContext.notifyListUpdated(n);
    }

    public void abort(boolean bl) {
        super.abort(bl);
        this.logChannel.log(10000000, "[%1.abort]", (Object)LOGCLASS);
    }

    public void updateBrowseMode(int n) {
        super.updateBrowseMode(n);
        this.logChannel.log(10000000, "[%1.updateBrowseMode]", (Object)LOGCLASS);
    }

    public void updateContentFilter(int n) {
        super.updateContentFilter(n);
        this.logChannel.log(10000000, "[%1.updateContentFilter]", (Object)LOGCLASS);
    }

    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        super.updateBrowseFolder(mediaListEntryArray);
        this.logChannel.log(10000000, "[%1.updateBrowseFolder]", (Object)LOGCLASS);
    }

    public void errorFolderChange() {
        super.errorFolderChange();
        this.logChannel.log(10000000, "[%1.errorFolderChange]", (Object)LOGCLASS);
    }

    public void errorBrowseMode() {
        super.errorBrowseMode();
        this.logChannel.log(10000000, "[%1.errorBrowseMode]", (Object)LOGCLASS);
    }

    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        super.selectionResult(n, n2, bl, l, l2, l3, l4, l5);
        this.logChannel.log(10000000, "[%1.errorSelection]", (Object)LOGCLASS);
    }

    public void errorSelection() {
        super.errorSelection();
        this.logChannel.log(10000000, "[%1.errorSelection]", (Object)LOGCLASS);
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        super.responseList(bl, mediaListEntryArray, n);
        this.logChannel.log(10000000, "[%1.responsePickList]", (Object)LOGCLASS);
    }

    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
        super.responsePickList(bl, mediaListEntryArray);
        this.logChannel.log(10000000, "[%1.responsePickList]", (Object)LOGCLASS);
    }
}

