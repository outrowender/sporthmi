/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.browselist.AbstractCombiBrowserJob;
import de.audi.app.media.combi.bap.browselist.CombiBAPDataBrowserContentAdapter;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class CombiJobDetailInfoChanged
extends AbstractCombiBrowserJob {
    private final String LOGCLASS;
    private final MediaDetailInfo detailInfo;

    public CombiJobDetailInfoChanged(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter, MediaDetailInfo mediaDetailInfo) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.LOGCLASS = "CombiJobDetailInfoChanged";
        this.detailInfo = mediaDetailInfo;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public String getName() {
        return "DETAILINFO";
    }

    @Override
    public void start() {
        if (this.detailInfo.equals(this.getCombiAdapter().getState().getCurrentDetailInfo())) {
            this.logger.log(-2137614336, "[%1.start] Update", (Object)"CombiJobDetailInfoChanged");
            this.getCombiAdapter().getState().setCurrentDetailInfo(this.detailInfo);
            this.sendDetailInfo();
            this.getExecutionContext().jobFinished();
            return;
        }
        this.getCombiAdapter().getState().setCurrentDetailInfo(this.detailInfo);
        if (!this.getCombiAdapter().isBrowsingSupported()) {
            this.logger.log(-2137614336, "[%1.start] No list handling.", (Object)"CombiJobDetailInfoChanged");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.sendDetailInfo();
            this.getExecutionContext().jobFinished();
            return;
        }
        if (!this.getCombiAdapter().getState().isBrowsingPlaybackFolder()) {
            this.logger.log(1078071040, "[%1.start] Not browsing playback folder.", (Object)"CombiJobDetailInfoChanged");
            if (this.getCombiAdapter().getState().getAbsolutePositionCurrentTrack() != 0) {
                this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
                this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(false);
            }
            this.sendDetailInfo();
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(-2137614336, "[%1.start] Browsing playback folder.", (Object)"CombiJobDetailInfoChanged");
        MediaListEntry[] mediaListEntryArray = this.detailInfo.getPlayingTrack().getPlaybackFolder();
        this.getCombiAdapter().getState().setPlaybackFolder(mediaListEntryArray);
        if (mediaListEntryArray != PlayingTrack.EMPTY_PLAYBACK_FOLDER) {
            this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(true);
            this.getCombiAdapter().requestBrowseListByEntryId(this.detailInfo.getEntryID(), this.detailInfo.getContentType(), 1);
            return;
        }
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(14808325, "[%1.responseList] Receive response.", (Object)"CombiJobDetailInfoChanged");
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.detailInfo.getEntryID(), this.detailInfo.getContentType(), mediaListEntryArray, n));
        this.sendDetailInfo();
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void errorListRequestAborted() {
        this.logger.log(1078071040, "[%1.errorListRequestAborted] List request aborted.", (Object)"CombiJobDetailInfoChanged");
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
        this.sendDetailInfo();
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
        buffer.append("entryID='");
        buffer.append(this.detailInfo.getEntryID());
        buffer.append("'");
        return buffer.toString();
    }
}

