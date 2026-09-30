/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.AbstractDataBrowseListJob;
import de.audi.app.media.evo.content.data.DataBrowserList;
import de.audi.app.media.evo.content.data.DataBrowserListLocator;
import de.audi.app.media.evo.content.data.DataBrowserListSelectionData;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class DataBrowserListJobAddSelection
extends AbstractDataBrowseListJob
implements IPlayerSelectionRequest {
    private static final String LOGCLASS = "DataBrowserListJobAddSelection";
    private final MediaListEntry folder;
    private final long selectedEntryID;
    private final DataBrowserListSelectionData selectionData;
    private final int browserID;

    public DataBrowserListJobAddSelection(LogChannel logChannel, DataBrowserList dataBrowserList, MediaListEntry mediaListEntry, long l, boolean bl, DataBrowserListLocator dataBrowserListLocator, int n, int n2) {
        super(logChannel, dataBrowserList);
        this.selectionData = new DataBrowserListSelectionData(dataBrowserListLocator.getCategory(), 0, n);
        this.folder = mediaListEntry;
        this.selectedEntryID = l;
        this.browserID = n2;
    }

    public String getName() {
        return "SELECT";
    }

    public void start() {
        this.getDataBrowserList().addSelection(0, this.folder);
    }

    public void addSelectionFinished(boolean bl, long l) {
        if (!bl) {
            this.logChannel.log(1000000, "[%1.addSelectionFinished] NOT OK.", (Object)LOGCLASS);
            this.selectionError();
            return;
        }
        if (l == 0L) {
            this.logChannel.log(1000000, "[%1.addSelectionFinished] No entries selected.", (Object)LOGCLASS);
            this.selectionError();
            return;
        }
        this.logChannel.log(1000000, "[%1.addSelectionFinished] Set player selection.", (Object)LOGCLASS);
        this.getDataBrowserList().playSelection(this);
    }

    private void selectionError() {
        this.logChannel.log(1000000, "[%1.selectionError] Error on selection. Abort.", (Object)LOGCLASS);
        this.getDataBrowserList().unblockList();
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(" folderID='").append(this.folder.getEntryID()).append("',titleID='").append(this.selectedEntryID).append("'");
        return buffer.toString();
    }

    public int getBrowserID() {
        return this.browserID;
    }

    public long getEntryID() {
        return this.selectedEntryID;
    }

    public boolean isSeamless() {
        return false;
    }

    public boolean waitForPlayposition() {
        return false;
    }

    public void responseSetSelection(boolean bl) {
        this.logChannel.log(1000000, "[%1.responseSetSelection] '%2'", (Object)LOGCLASS, (Object)(bl ? "OK" : "NOK"));
        if (bl) {
            this.getDataBrowserList().triggerLeaveBrowserListAfterSelection();
        }
        this.getDataBrowserList().unblockList();
        this.getDataBrowserList().setLastSelection(this.selectionData);
        this.getExecutionContext().jobFinished();
    }
}

