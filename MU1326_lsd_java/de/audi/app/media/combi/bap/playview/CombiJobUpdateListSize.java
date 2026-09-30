/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.playview;

import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.playview.AbstractCombiPlayViewJob;
import de.audi.app.media.combi.bap.playview.CombiBAPPlayViewContentAdapter;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class CombiJobUpdateListSize
extends AbstractCombiPlayViewJob {
    private final String LOGCLASS;
    private final int newListSize;
    private final long entryId;

    public CombiJobUpdateListSize(LogChannel logChannel, CombiBAPPlayViewContentAdapter combiBAPPlayViewContentAdapter, int n, long l) {
        super(logChannel, combiBAPPlayViewContentAdapter);
        this.LOGCLASS = "CombiJobUpdateListSize";
        this.newListSize = n;
        this.entryId = l;
    }

    public int getType() {
        return 4;
    }

    public String getName() {
        return "LISTSIZE";
    }

    public void start() {
        if (this.newListSize == 0) {
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.getCombiAdapter().getCombiAccessor().updateListSize(0);
            this.sendDetailInfo();
            this.getExecutionContext().jobFinished();
            return;
        }
        MediaDetailInfo mediaDetailInfo = this.getCombiAdapter().getState().getCurrentDetailInfo();
        if (mediaDetailInfo == null || -1L == this.entryId && mediaDetailInfo.getEntryID() == -1L) {
            this.logger.log(1000000, "[%1.start] No detail information %2 or entry id %3.", (Object)"CombiJobUpdateListSize", (Object)mediaDetailInfo, this.entryId);
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.getCombiAdapter().getCombiAccessor().updateListSize(0);
            this.getExecutionContext().jobFinished();
            return;
        }
        long l = this.entryId;
        if (-1L == l) {
            l = mediaDetailInfo.getEntryID();
        }
        if (!this.getCombiAdapter().getPlayer().requestPlayViewListEntryBased(this.getCombiAdapter().getClientID(), l, 1)) {
            this.logger.log(1000000, "[%1.start] List request failed.", (Object)"CombiJobUpdateListSize");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.getCombiAdapter().getCombiAccessor().updateListSize(this.newListSize);
            this.sendDetailInfo();
            this.getExecutionContext().jobFinished();
            return;
        }
    }

    public void responsePlayViewList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(100000000, "[%1.responsePlayViewList]", (Object)"CombiJobUpdateListSize");
        boolean bl = this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID(), this.getCombiAdapter().getState().getCurrentDetailInfo().getContentType(), mediaListEntryArray, n));
        this.getCombiAdapter().getCombiAccessor().updateListSize(this.newListSize);
        if (this.entryId == this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID() || bl) {
            this.sendDetailInfo();
        }
        this.getExecutionContext().jobFinished();
    }

    public void errorListRequestAborted() {
        this.logger.log(1000000, "[%1.errorListRequestAborted] List request aborted.", (Object)"CombiJobUpdateListSize");
        this.getCombiAdapter().getCombiAccessor().updateListSize(this.newListSize);
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
        this.sendDetailInfo();
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("size='");
        buffer.append(this.newListSize);
        buffer.append("'");
        return buffer.toString();
    }

    public void abort(boolean bl) {
        this.logger.log(1000000, "[%1.abort]", (Object)"CombiJobUpdateListSize");
    }
}

