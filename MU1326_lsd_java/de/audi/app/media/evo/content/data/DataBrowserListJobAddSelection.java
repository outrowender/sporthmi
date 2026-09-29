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
    private static final String LOGCLASS;
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

    @Override
    public String getName() {
        return "SELECT";
    }

    @Override
    public void start() {
        this.getDataBrowserList().addSelection(0, this.folder);
    }

    @Override
    public void addSelectionFinished(boolean bl, long l) {
        if (!bl) {
            this.logChannel.log(1078071040, "[%1.addSelectionFinished] NOT OK.", (Object)"DataBrowserListJobAddSelection");
            this.selectionError();
            return;
        }
        if (l == 0L) {
            this.logChannel.log(1078071040, "[%1.addSelectionFinished] No entries selected.", (Object)"DataBrowserListJobAddSelection");
            this.selectionError();
            return;
        }
        this.logChannel.log(1078071040, "[%1.addSelectionFinished] Set player selection.", (Object)"DataBrowserListJobAddSelection");
        this.getDataBrowserList().playSelection(this);
    }

    private void selectionError() {
        this.logChannel.log(1078071040, "[%1.selectionError] Error on selection. Abort.", (Object)"DataBrowserListJobAddSelection");
        this.getDataBrowserList().unblockList();
        this.getExecutionContext().jobFinished();
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(" folderID='").append(this.folder.getEntryID()).append("',titleID='").append(this.selectedEntryID).append("'");
        return buffer.toString();
    }

    @Override
    public int getBrowserID() {
        return this.browserID;
    }

    @Override
    public long getEntryID() {
        return this.selectedEntryID;
    }

    @Override
    public boolean isSeamless() {
        return false;
    }

    @Override
    public boolean waitForPlayposition() {
        return false;
    }

    @Override
    public void responseSetSelection(boolean bl) {
        this.logChannel.log(1078071040, "[%1.responseSetSelection] '%2'", (Object)"DataBrowserListJobAddSelection", (Object)(bl ? "OK" : "NOK"));
        if (bl) {
            this.getDataBrowserList().triggerLeaveBrowserListAfterSelection();
        }
        this.getDataBrowserList().unblockList();
        this.getDataBrowserList().setLastSelection(this.selectionData);
        this.getExecutionContext().jobFinished();
    }
}

