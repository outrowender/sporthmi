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
    private static final String LOGCLASS = "CombiJobSelectTrack";
    private final long entryID;
    private final int browserID;

    public CombiJobSelectTrack(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter, int n, long l) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.entryID = l;
        this.browserID = n;
    }

    public int getType() {
        return 11;
    }

    public String getName() {
        return "SELECTTRACK";
    }

    public void start() {
        MediaListEntry[] mediaListEntryArray = this.getCombiAdapter().getState().getCurrentBrowsingFolder();
        if (mediaListEntryArray.length < 1) {
            this.getExecutionContext().jobFinished();
            return;
        }
        this.getCombiAdapter().addSelection(mediaListEntryArray[0]);
    }

    public void abort(boolean bl) {
        if (!bl) {
            return;
        }
        this.logger.log(1000000, "[%1.abort]", (Object)LOGCLASS);
        this.getCombiAdapter().getCombiAccessor().selectListEntryResult(false);
    }

    public void addSelectionResult(boolean bl) {
        this.logger.log(1000000, "[%2.addSelectionResult] '%1'", bl, (Object)LOGCLASS);
        if (!bl) {
            this.getCombiAdapter().getCombiAccessor().selectListEntryResult(false);
            this.getExecutionContext().jobFinished();
            return;
        }
        this.getCombiAdapter().setPlaySelection(this);
    }

    public int getBrowserID() {
        return this.browserID;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public boolean isSeamless() {
        return false;
    }

    public boolean waitForPlayposition() {
        return false;
    }

    public void responseSetSelection(boolean bl) {
        this.logger.log(1000000, "[%2.playerSelectionResult] '%1'", bl, (Object)LOGCLASS);
        if (!bl) {
            this.getCombiAdapter().getCombiAccessor().selectListEntryResult(false);
            this.getExecutionContext().jobFinished();
            return;
        }
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.getCombiAdapter().getState().setCurrentDetailInfo(mediaDetailInfo);
        if (!this.getCombiAdapter().getState().isBrowsingPlaybackFolder()) {
            this.logger.log(100000000, "[%1.detailInfoChanged] Not browsing playback folder.", (Object)LOGCLASS);
            if (this.getCombiAdapter().getState().getAbsolutePositionCurrentTrack() != 0) {
                this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
                this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(false);
            }
            this.sendDetailInfo();
            this.getCombiAdapter().getCombiAccessor().selectListEntryResult(true);
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(100000000, "[%1.detailInfoChanged] Browsing playback folder.", (Object)LOGCLASS);
        this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(true);
        this.getCombiAdapter().requestBrowseListByEntryId(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), 1);
    }

    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(100000000, "[%1.responseList]", (Object)LOGCLASS);
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

    public void browseFolderChanged(MediaListEntry[] mediaListEntryArray, int n) {
    }

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

