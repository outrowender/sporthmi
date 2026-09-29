/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.browselist.AbstractCombiBrowserJob;
import de.audi.app.media.combi.bap.browselist.CombiBAPDataBrowserContentAdapter;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class CombiJobPlaybackFolderChanged
extends AbstractCombiBrowserJob {
    private final String LOGCLASS;
    private final MediaListEntry[] playbackFolder;

    public CombiJobPlaybackFolderChanged(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter, MediaListEntry[] mediaListEntryArray) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.LOGCLASS = "CombiJobPlaybackFolderChanged";
        this.playbackFolder = mediaListEntryArray;
    }

    @Override
    public int getType() {
        return 13;
    }

    @Override
    public String getName() {
        return "UPDATE_PLAYBACKFOLDER";
    }

    @Override
    public void start() {
        if (this.getCombiAdapter().getState().getPlaybackFolder() != PlayingTrack.EMPTY_PLAYBACK_FOLDER || this.playbackFolder == PlayingTrack.EMPTY_PLAYBACK_FOLDER) {
            this.getExecutionContext().jobFinished();
            return;
        }
        this.getCombiAdapter().getState().setPlaybackFolder(this.playbackFolder);
        if (!this.getCombiAdapter().isBrowsingSupported()) {
            this.logger.log(-2137614336, "[%1.start] No list handling.", (Object)"CombiJobPlaybackFolderChanged");
            this.getExecutionContext().jobFinished();
            return;
        }
        if (!this.getCombiAdapter().getState().isBrowsingPlaybackFolder()) {
            this.logger.log(1078071040, "[%1.start] Not browsing playback folder.", (Object)"CombiJobPlaybackFolderChanged");
            if (this.getCombiAdapter().getState().getAbsolutePositionCurrentTrack() != 0) {
                this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
                this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(false);
            }
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(-2137614336, "[%1.start] Browsing playback folder.", (Object)"CombiJobPlaybackFolderChanged");
        this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(true);
        this.getCombiAdapter().requestBrowseListByEntryId(this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID(), this.getCombiAdapter().getState().getCurrentDetailInfo().getContentType(), 1);
    }

    @Override
    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(14808325, "[%1.responseList] Receive response.", (Object)"CombiJobPlaybackFolderChanged");
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID(), this.getCombiAdapter().getState().getCurrentDetailInfo().getContentType(), mediaListEntryArray, n));
        this.sendDetailInfo();
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void errorListRequestAborted() {
        this.logger.log(1078071040, "[%1.errorListRequestAborted] List request aborted.", (Object)"CombiJobPlaybackFolderChanged");
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
        buffer.append("PlaybackFolder='");
        buffer.append(LogUtil.listEntryToStr(this.playbackFolder));
        buffer.append("'");
        return buffer.toString();
    }
}

