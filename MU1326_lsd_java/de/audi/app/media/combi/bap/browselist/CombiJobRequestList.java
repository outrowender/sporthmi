/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.combi.bap.browselist.AbstractCombiBrowserJob;
import de.audi.app.media.combi.bap.browselist.CombiBAPDataBrowserContentAdapter;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class CombiJobRequestList
extends AbstractCombiBrowserJob {
    private final String LOGCLASS;
    private final long entryID;
    private final int index;
    private final int count;
    private final int contentType;
    private final int transactionID;

    public CombiJobRequestList(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter, int n, long l, int n2, int n3, int n4) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.LOGCLASS = "CombiJobRequestList";
        this.transactionID = n;
        this.entryID = l;
        this.index = n2;
        this.contentType = n3;
        this.count = n4;
    }

    @Override
    public int getType() {
        return 7;
    }

    @Override
    public String getName() {
        return "REQUESTLIST";
    }

    @Override
    public void abort(boolean bl) {
        this.logger.log(1078071040, "[%1.abort]", (Object)"CombiJobRequestList");
        this.getCombiAdapter().getCombiAccessor().responseList(this.transactionID, 1, 0, new MediaListEntry[0]);
    }

    @Override
    public void start() {
        if (this.entryID != 0L) {
            this.getCombiAdapter().requestBrowseListByEntryId(this.entryID, this.contentType, this.count);
        } else {
            this.getCombiAdapter().requestBrowseListByIndex(this.index, this.count);
        }
    }

    @Override
    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(14808325, "[%1.responseList] Receive response.", (Object)"CombiJobRequestList");
        this.getCombiAdapter().getCombiAccessor().responseList(this.transactionID, 1, n, mediaListEntryArray);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void errorListRequestAborted() {
        this.logger.log(1078071040, "[%1.errorListRequestAborted] List request aborted.", (Object)"CombiJobRequestList");
        this.getCombiAdapter().getCombiAccessor().responseList(this.transactionID, 1, 0, new MediaListEntry[0]);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void browseFolderChanged(MediaListEntry[] mediaListEntryArray, int n) {
    }

    @Override
    public void errorFolderChangeAborted() {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("[entryID='");
        buffer.append(this.entryID);
        buffer.append("',idx='");
        buffer.append(this.index);
        buffer.append("',cnt='");
        buffer.append(this.count);
        buffer.append("']");
        return buffer.toString();
    }
}

