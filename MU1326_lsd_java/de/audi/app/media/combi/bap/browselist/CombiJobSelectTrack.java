/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.browselist.AbstractCombiBrowserJob;
import de.audi.app.media.combi.bap.browselist.CombiBAPDataBrowserContentAdapter;
import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class CombiJobSelectTrack
extends AbstractCombiBrowserJob
implements IPlayerSelectionRequest {
    private static final String LOGCLASS;
    private final long entryID;
    private final int browserID;

    public CombiJobSelectTrack(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter, int n, long l) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.entryID = l;
        this.browserID = n;
    }

    @Override
    public int getType() {
        return 11;
    }

    @Override
    public String getName() {
        return "SELECTTRACK";
    }

    @Override
    public void start() {
        MediaListEntry[] mediaListEntryArray = this.getCombiAdapter().getState().getCurrentBrowsingFolder();
        if (mediaListEntryArray.length < 1) {
            this.getExecutionContext().jobFinished();
            return;
        }
        this.getCombiAdapter().addSelection(mediaListEntryArray[0]);
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
    public void addSelectionResult(boolean bl) {
        this.logger.log(1078071040, "[%2.addSelectionResult] '%1'", bl, (Object)"CombiJobSelectTrack");
        if (!bl) {
            this.getCombiAdapter().getCombiAccessor().selectListEntryResult(false);
            this.getExecutionContext().jobFinished();
            return;
        }
        this.getCombiAdapter().setPlaySelection(this);
    }

    @Override
    public int getBrowserID() {
        return this.browserID;
    }

    @Override
    public long getEntryID() {
        return this.entryID;
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
        this.logger.log(1078071040, "[%2.playerSelectionResult] '%1'", bl, (Object)"CombiJobSelectTrack");
        if (!bl) {
            this.getCombiAdapter().getCombiAccessor().selectListEntryResult(false);
            this.getExecutionContext().jobFinished();
            return;
        }
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.getCombiAdapter().getState().setCurrentDetailInfo(mediaDetailInfo);
        if (!this.getCombiAdapter().getState().isBrowsingPlaybackFolder()) {
            this.logger.log(14808325, "[%1.detailInfoChanged] Not browsing playback folder.", (Object)"CombiJobSelectTrack");
            if (this.getCombiAdapter().getState().getAbsolutePositionCurrentTrack() != 0) {
                this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
                this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(false);
            }
            this.sendDetailInfo();
            this.getCombiAdapter().getCombiAccessor().selectListEntryResult(true);
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(14808325, "[%1.detailInfoChanged] Browsing playback folder.", (Object)"CombiJobSelectTrack");
        this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(true);
        this.getCombiAdapter().requestBrowseListByEntryId(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), 1);
    }

    @Override
    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(14808325, "[%1.responseList]", (Object)"CombiJobSelectTrack");
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
        buffer.append("']");
        return buffer.toString();
    }
}

