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

    public int getType() {
        return 7;
    }

    public String getName() {
        return "REQUESTLIST";
    }

    public void abort(boolean bl) {
        this.logger.log(1000000, "[%1.abort]", (Object)"CombiJobRequestList");
        this.getCombiAdapter().getCombiAccessor().responseList(this.transactionID, 1, 0, new MediaListEntry[0]);
    }

    public void start() {
        if (this.entryID != 0L) {
            this.getCombiAdapter().requestBrowseListByEntryId(this.entryID, this.contentType, this.count);
        } else {
            this.getCombiAdapter().requestBrowseListByIndex(this.index, this.count);
        }
    }

    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(100000000, "[%1.responseList] Receive response.", (Object)"CombiJobRequestList");
        this.getCombiAdapter().getCombiAccessor().responseList(this.transactionID, 1, n, mediaListEntryArray);
        this.getExecutionContext().jobFinished();
    }

    public void errorListRequestAborted() {
        this.logger.log(1000000, "[%1.errorListRequestAborted] List request aborted.", (Object)"CombiJobRequestList");
        this.getCombiAdapter().getCombiAccessor().responseList(this.transactionID, 1, 0, new MediaListEntry[0]);
        this.getExecutionContext().jobFinished();
    }

    public void browseFolderChanged(MediaListEntry[] mediaListEntryArray, int n) {
    }

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

