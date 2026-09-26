/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

class JobBrowseListAddSelection
extends AbstractJobBrowseList {
    static final String LOGCLASS;
    private final boolean selection;
    private final int range;
    private final long entryID;
    private final int contentType;
    private final boolean sizeCheck;

    public JobBrowseListAddSelection(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, BrowseListContextImpl browseListContextImpl, boolean bl, int n, long l, int n2, boolean bl2) {
        super(logChannel, iMediaDSIBrowserController, browseListContextImpl);
        this.selection = bl;
        this.range = n;
        this.entryID = l;
        this.contentType = n2;
        this.sizeCheck = bl2;
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public String getName() {
        return "AddSelection";
    }

    @Override
    public void start() {
        this.logChannel.log(14808325, "[%1.start]", (Object)"JobBrowseListAddSelection");
        this.dsiMediaBrowser.addSelection(this.selection, this.range, this.entryID, this.contentType, this.sizeCheck);
    }

    @Override
    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        this.logChannel.log(14808325, "[%1.selectionResult]", (Object)"JobBrowseListAddSelection");
        this.browseListContext.notifySelectionResult(false, n, n2, bl, l, l2, l3, l4, l5);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void errorSelection() {
        this.logChannel.log(14808325, "[%1.errorSelection]", (Object)"JobBrowseListAddSelection");
        this.browseListContext.notifySelectionResult(true, 0, 0, false, -1L, 0L, -1L, 0L, 0L);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void updateListSize(int n, int n2) {
        this.logChannel.log(14808325, "[%1.updateListSize]", (Object)"JobBrowseListAddSelection");
        this.browseListContext.getState().setCurrentListSize(n);
        this.browseListContext.notifyListUpdated(n);
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("'eId=");
        buffer.append(this.entryID);
        buffer.append(", cT=");
        buffer.append(this.contentType);
        buffer.append("'");
        return buffer.toString();
    }
}

