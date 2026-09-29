/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.playview;

import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.playview.AbstractCombiPlayViewJob;
import de.audi.app.media.combi.bap.playview.CombiBAPPlayViewContentAdapter;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class CombiJobRequestList
extends AbstractCombiPlayViewJob {
    private final String LOGCLASS;
    private final long entryID;
    private final int index;
    private final int count;
    private final int transactionID;

    public CombiJobRequestList(LogChannel logChannel, CombiBAPPlayViewContentAdapter combiBAPPlayViewContentAdapter, int n, long l, int n2, int n3) {
        super(logChannel, combiBAPPlayViewContentAdapter);
        this.LOGCLASS = "CombiJobRequestList";
        this.transactionID = n;
        this.entryID = l;
        this.index = n2;
        this.count = n3;
    }

    @Override
    public int getType() {
        return 2;
    }

    @Override
    public String getName() {
        return "REQUESTLIST";
    }

    @Override
    public void abort(boolean bl) {
        this.logger.log(1078071040, "[%1.abort]", (Object)"CombiJobRequestList");
        this.getCombiAdapter().getCombiAccessor().responseList(this.transactionID, this.getCombiAdapter().getContentType(), 0, new MediaListEntry[0]);
    }

    @Override
    public void start() {
        boolean bl = this.entryID != 0L ? this.getCombiAdapter().getPlayer().requestPlayViewListEntryBased(this.getCombiAdapter().getClientID(), this.entryID, this.count) : this.getCombiAdapter().getPlayer().requestPlayViewListIndexBased(this.getCombiAdapter().getClientID(), this.index, this.count);
        if (!bl) {
            this.logger.log(1078071040, "[%1.start] List request failed.", (Object)"CombiJobRequestList");
            this.getCombiAdapter().getCombiAccessor().responseList(this.transactionID, this.getCombiAdapter().getContentType(), 0, new MediaListEntry[0]);
            this.getExecutionContext().jobFinished();
            return;
        }
    }

    @Override
    public void responsePlayViewList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1078071040, "[%1.responsePlayViewList]", (Object)"CombiJobRequestList");
        if (this.getCombiAdapter().getState().getAbsolutePositionCurrentTrack() == 0) {
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID(), this.getCombiAdapter().getState().getCurrentDetailInfo().getContentType(), mediaListEntryArray, n));
            this.logger.log(-2137614336, "[%1.responsePlayViewList] Track position not set; Updated to '%2'", (Object)"CombiJobRequestList", (long)this.getCombiAdapter().getState().getAbsolutePositionCurrentTrack());
        }
        this.getCombiAdapter().getCombiAccessor().responseList(this.transactionID, this.getCombiAdapter().getContentType(), n, mediaListEntryArray);
        if (this.getCombiAdapter().getState().isCoverUpdateBlocked() && this.getCombiAdapter().getState().getAbsolutePositionCurrentTrack() != 0) {
            this.getCombiAdapter().getState().setCoverUpdateBlocked(false);
            this.sendDetailInfo();
        }
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void errorListRequestAborted() {
        this.logger.log(1078071040, "[%1.errorListRequestAborted] List request aborted.", (Object)"CombiJobRequestList");
        this.getCombiAdapter().getCombiAccessor().responseList(this.transactionID, this.getCombiAdapter().getContentType(), 0, new MediaListEntry[0]);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("[entryID='");
        buffer.append(this.entryID);
        buffer.append("',idx='");
        buffer.append(this.index);
        buffer.append("',count='");
        buffer.append(this.count);
        buffer.append("',transactionID='");
        buffer.append(this.transactionID);
        buffer.append("']");
        return buffer.toString();
    }
}

