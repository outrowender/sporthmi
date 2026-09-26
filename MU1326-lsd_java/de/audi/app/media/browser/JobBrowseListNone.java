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
    private static final String LOGCLASS;

    public JobBrowseListNone(LogChannel logChannel, BrowseListContextImpl browseListContextImpl) {
        super(logChannel, null, browseListContextImpl);
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getName() {
        return "None";
    }

    @Override
    public void start() {
        this.logChannel.log(14808325, "[%1.start]", (Object)"JobBrowseListNone");
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void updateListSize(int n, int n2) {
        this.logChannel.log(14808325, "[%1.updateListSize]", (Object)"JobBrowseListNone");
        this.browseListContext.getState().setCurrentListSize(n);
        this.browseListContext.notifyListUpdated(n);
    }

    @Override
    public void abort(boolean bl) {
        super.abort(bl);
        this.logChannel.log(-2137614336, "[%1.abort]", (Object)"JobBrowseListNone");
    }

    @Override
    public void updateBrowseMode(int n) {
        super.updateBrowseMode(n);
        this.logChannel.log(-2137614336, "[%1.updateBrowseMode]", (Object)"JobBrowseListNone");
    }

    @Override
    public void updateContentFilter(int n) {
        super.updateContentFilter(n);
        this.logChannel.log(-2137614336, "[%1.updateContentFilter]", (Object)"JobBrowseListNone");
    }

    @Override
    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        super.updateBrowseFolder(mediaListEntryArray);
        this.logChannel.log(-2137614336, "[%1.updateBrowseFolder]", (Object)"JobBrowseListNone");
    }

    @Override
    public void errorFolderChange() {
        super.errorFolderChange();
        this.logChannel.log(-2137614336, "[%1.errorFolderChange]", (Object)"JobBrowseListNone");
    }

    @Override
    public void errorBrowseMode() {
        super.errorBrowseMode();
        this.logChannel.log(-2137614336, "[%1.errorBrowseMode]", (Object)"JobBrowseListNone");
    }

    @Override
    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        super.selectionResult(n, n2, bl, l, l2, l3, l4, l5);
        this.logChannel.log(-2137614336, "[%1.errorSelection]", (Object)"JobBrowseListNone");
    }

    @Override
    public void errorSelection() {
        super.errorSelection();
        this.logChannel.log(-2137614336, "[%1.errorSelection]", (Object)"JobBrowseListNone");
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        super.responseList(bl, mediaListEntryArray, n);
        this.logChannel.log(-2137614336, "[%1.responsePickList]", (Object)"JobBrowseListNone");
    }

    @Override
    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
        super.responsePickList(bl, mediaListEntryArray);
        this.logChannel.log(-2137614336, "[%1.responsePickList]", (Object)"JobBrowseListNone");
    }
}

