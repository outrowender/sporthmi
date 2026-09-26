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
    private static final String LOGCLASS;
    private final long entryID;

    public CombiJobSelectTrack(LogChannel logChannel, CombiBAPPlayViewContentAdapter combiBAPPlayViewContentAdapter, long l) {
        super(logChannel, combiBAPPlayViewContentAdapter);
        this.entryID = l;
    }

    @Override
    public int getType() {
        return 5;
    }

    @Override
    public String getName() {
        return "SELECTTRACK";
    }

    @Override
    public void start() {
        this.getCombiAdapter().getPlayer().playEntry(this.entryID);
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.log(14808325, "[%1.detailInfoChanged]", (Object)"CombiJobSelectTrack");
        this.getCombiAdapter().getState().setCurrentDetailInfo(mediaDetailInfo);
        if (!this.getCombiAdapter().getPlayer().requestPlayViewListEntryBased(this.getCombiAdapter().getClientID(), mediaDetailInfo.getEntryID(), 1)) {
            this.logger.log(1078071040, "[%1.detailInfoChanged] List request failed.", (Object)"CombiJobSelectTrack");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.sendDetailInfo();
            this.getCombiAdapter().getCombiAccessor().selectListEntryResult(true);
            this.getExecutionContext().jobFinished();
        }
    }

    @Override
    public void abort(boolean bl) {
        if (!bl) {
            return;
        }
        this.logger.log(1078071040, "[%1.abort]", (Object)"CombiJobSelectTrack");
        this.getCombiAdapter().getCombiAccessor().selectListEntryResult(false);
    }

    @Override
    public void responsePlayViewList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(14808325, "[%1.responsePlayViewList]", (Object)"CombiJobSelectTrack");
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID(), this.getCombiAdapter().getState().getCurrentDetailInfo().getContentType(), mediaListEntryArray, n));
        this.sendDetailInfo();
        this.getCombiAdapter().getCombiAccessor().selectListEntryResult(true);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void errorListRequestAborted() {
        this.logger.log(1078071040, "[%1.errorListRequestAborted]", (Object)"CombiJobSelectTrack");
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

