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

public class CombiJobUpdateDetailInfo
extends AbstractCombiPlayViewJob {
    private final String LOGCLASS;
    private final MediaDetailInfo detailInfo;

    public CombiJobUpdateDetailInfo(LogChannel logChannel, CombiBAPPlayViewContentAdapter combiBAPPlayViewContentAdapter, MediaDetailInfo mediaDetailInfo) {
        super(logChannel, combiBAPPlayViewContentAdapter);
        this.LOGCLASS = "CombiJobUpdateDetailInfo";
        this.detailInfo = mediaDetailInfo;
    }

    public int getType() {
        return 3;
    }

    public void abort(boolean bl) {
        this.logger.log(1000000, "[%1.abort]", (Object)"CombiJobUpdateDetailInfo");
    }

    public String getName() {
        return "DETAILINFO";
    }

    public void start() {
        if (this.getCombiAdapter().getState().getCurrentDetailInfo() != null && this.getCombiAdapter().getState().getCurrentDetailInfo().equals(this.detailInfo)) {
            this.logger.log(100000000, "[%1.start] Detail info updated. Do not update the absolute position.", (Object)"CombiJobUpdateDetailInfo");
            this.sendNewDetailInfoAndFinishJob();
            return;
        }
        if (!this.detailInfo.isValid()) {
            this.logger.log(100000, "[%1.start] Detail info invalid. Set absolute position to '0'.", (Object)"CombiJobUpdateDetailInfo");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.sendNewDetailInfoAndFinishJob();
            return;
        }
        this.logger.log(1000000, "[%1.start] New track. Request playview to calculate absolute position.", (Object)"CombiJobUpdateDetailInfo");
        if (!this.getCombiAdapter().getPlayer().requestPlayViewListEntryBased(this.getCombiAdapter().getClientID(), this.detailInfo.getEntryID(), 1)) {
            this.logger.log(100000, "[%1.start] List request failed. Set absolute position to '0'.", (Object)"CombiJobUpdateDetailInfo");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.sendNewDetailInfoAndFinishJob();
        }
    }

    public void responsePlayViewList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(100000000, "[%1.responsePlayViewList] Update absolute position and send new detail info.", (Object)"CombiJobUpdateDetailInfo");
        int n2 = CombiBAPUtils.getAbsolutePosition(this.detailInfo.getEntryID(), this.detailInfo.getContentType(), mediaListEntryArray, n);
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(n2);
        this.sendNewDetailInfoAndFinishJob();
    }

    public void errorListRequestAborted() {
        this.logger.log(1000000, "[%1.errorListRequestAborted] Set absolute position to '0' and send new detail info.", (Object)"CombiJobUpdateDetailInfo");
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
        this.sendNewDetailInfoAndFinishJob();
    }

    private void sendNewDetailInfoAndFinishJob() {
        this.getCombiAdapter().getState().setCurrentDetailInfo(this.detailInfo);
        this.sendDetailInfo();
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("entryID='");
        buffer.append(this.detailInfo.getEntryID());
        buffer.append("'");
        return buffer.toString();
    }
}

