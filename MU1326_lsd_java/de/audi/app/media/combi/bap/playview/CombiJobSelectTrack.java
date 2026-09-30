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

public class CombiJobSelectTrack
extends AbstractCombiPlayViewJob {
    private static final String LOGCLASS = "CombiJobSelectTrack";
    private final long entryID;

    public CombiJobSelectTrack(LogChannel logChannel, CombiBAPPlayViewContentAdapter combiBAPPlayViewContentAdapter, long l) {
        super(logChannel, combiBAPPlayViewContentAdapter);
        this.entryID = l;
    }

    public int getType() {
        return 5;
    }

    public String getName() {
        return "SELECTTRACK";
    }

    public void start() {
        this.getCombiAdapter().getPlayer().playEntry(this.entryID);
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.log(100000000, "[%1.detailInfoChanged]", (Object)LOGCLASS);
        this.getCombiAdapter().getState().setCurrentDetailInfo(mediaDetailInfo);
        if (!this.getCombiAdapter().getPlayer().requestPlayViewListEntryBased(this.getCombiAdapter().getClientID(), mediaDetailInfo.getEntryID(), 1)) {
            this.logger.log(1000000, "[%1.detailInfoChanged] List request failed.", (Object)LOGCLASS);
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.sendDetailInfo();
            this.getCombiAdapter().getCombiAccessor().selectListEntryResult(true);
            this.getExecutionContext().jobFinished();
        }
    }

    public void abort(boolean bl) {
        if (!bl) {
            return;
        }
        this.logger.log(1000000, "[%1.abort]", (Object)LOGCLASS);
        this.getCombiAdapter().getCombiAccessor().selectListEntryResult(false);
    }

    public void responsePlayViewList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(100000000, "[%1.responsePlayViewList]", (Object)LOGCLASS);
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID(), this.getCombiAdapter().getState().getCurrentDetailInfo().getContentType(), mediaListEntryArray, n));
        this.sendDetailInfo();
        this.getCombiAdapter().getCombiAccessor().selectListEntryResult(true);
        this.getExecutionContext().jobFinished();
    }

    public void errorListRequestAborted() {
        this.logger.log(1000000, "[%1.errorListRequestAborted]", (Object)LOGCLASS);
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
        this.sendDetailInfo();
        this.getCombiAdapter().getCombiAccessor().selectListEntryResult(true);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("[entryID='");
        buffer.append(this.entryID);
        buffer.append("']");
        return buffer.toString();
    }
}

