/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.browselist.AbstractCombiBrowserJob;
import de.audi.app.media.combi.bap.browselist.CombiBAPDataBrowserContentAdapter;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class CombiJobGotoPlayingTrack
extends AbstractCombiBrowserJob {
    private final String LOGCLASS;
    private static final int STATE_UNDEFINED;
    private static final int STATE_CHANGE_TO_PARENT_OF_PLAYBACK_FOLDER;
    private static final int STATE_CALCULATE_ABSOLUTE_POSITION_OF_PLAYBACK_FOLDER;
    private static final int STATE_CHANGE_TO_PLAYBACK_FOLDER;
    private static final int STATE_CALCULATE_ABSOLUTE_POSITION_PLAYING_TRACK;
    private volatile MediaListEntry[] playbackFolderStack;
    private volatile MediaListEntry playbackFolder;
    private volatile int state = 0;
    private int absolutePositionPlaybackFolder = 0;

    public CombiJobGotoPlayingTrack(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.LOGCLASS = "CombiJobGotoPlayingTrack";
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public String getName() {
        return "GOTOPLAYINGTRACK";
    }

    @Override
    public void abort(boolean bl) {
        this.logger.log(1078071040, "[%1.abort]", (Object)"CombiJobGotoPlayingTrack");
        this.sendCurrentPlayingTrackResult(false);
    }

    @Override
    public void start() {
        if (this.getCombiAdapter().getState().getCurrentDetailInfo() == null) {
            this.logger.log(1078071040, "[%1.start] No detail info.", (Object)"CombiJobGotoPlayingTrack");
            this.sendCurrentPlayingTrackResult(false);
            this.getExecutionContext().jobFinished();
            return;
        }
        this.playbackFolderStack = this.getCombiAdapter().getState().getPlaybackFolder();
        this.playbackFolder = this.playbackFolderStack[this.playbackFolderStack.length - 1];
        if (this.playbackFolderStack.length == 1) {
            this.logger.log(-2137614336, "[%1.start] Playback folder on root level.", (Object)"CombiJobGotoPlayingTrack");
            this.setState(3);
            return;
        }
        this.logger.log(-2137614336, "[%1.start] Calculate absolute position of folder.", (Object)"CombiJobGotoPlayingTrack");
        this.setState(1);
    }

    private void setState(int n) {
        this.state = n;
        switch (this.state) {
            case 3: {
                this.logger.log(1078071040, "[%1.setState] STATE_CHANGE_TO_PLAYBACK_FOLDER", (Object)"CombiJobGotoPlayingTrack");
                this.getCombiAdapter().changeFolder(this.playbackFolderStack);
                break;
            }
            case 1: {
                this.logger.log(1078071040, "[%1.setState] STATE_CHANGE_TO_PARENT_OF_PLAYBACK_FOLDER", (Object)"CombiJobGotoPlayingTrack");
                this.getCombiAdapter().changeFolder(MediaUtils.getParentFolderStack(this.playbackFolderStack, 1));
                break;
            }
            case 2: {
                this.logger.log(1078071040, "[%1.setState] STATE_CALCULATE_ABSOLUTE_POSITION_OF_PLAYBACK_FOLDER", (Object)"CombiJobGotoPlayingTrack");
                this.getCombiAdapter().requestBrowseListByEntryId(this.playbackFolder.getEntryID(), this.playbackFolder.getContentType(), 1);
                break;
            }
            case 4: {
                this.logger.log(1078071040, "[%1.setState] STATE_CALCULATE_ABSOLUTE_POSITION_PLAYING_TRACK", (Object)"CombiJobGotoPlayingTrack");
                MediaDetailInfo mediaDetailInfo = this.getCombiAdapter().getState().getCurrentDetailInfo();
                this.getCombiAdapter().requestBrowseListByEntryId(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), 1);
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.setState] Wrong state.", (Object)"CombiJobGotoPlayingTrack");
            }
        }
    }

    @Override
    public void browseFolderChanged(MediaListEntry[] mediaListEntryArray, int n) {
        if (this.state == 1) {
            this.logger.log(14808325, "[%1.browseFolderChanged] Reached parent of playback folder.", (Object)"CombiJobGotoPlayingTrack");
            this.setState(2);
            return;
        }
        if (this.state == 3) {
            this.logger.log(14808325, "[%1.browseFolderChanged] Reached playback folder.", (Object)"CombiJobGotoPlayingTrack");
            this.sendBrowseFolder(mediaListEntryArray, this.absolutePositionPlaybackFolder);
            this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(true);
            this.sendListSize(n);
            this.setState(4);
            return;
        }
    }

    @Override
    public void errorFolderChangeAborted() {
        this.logger.log(1078071040, "[%1.errorFolderChangeAborted] Folder change failed.", (Object)"CombiJobGotoPlayingTrack");
        if (this.state == 1) {
            this.setState(3);
            return;
        }
        this.sendCurrentPlayingTrackResult(false);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        if (this.state == 2) {
            this.absolutePositionPlaybackFolder = CombiBAPUtils.getAbsolutePosition(this.playbackFolder.getEntryID(), this.playbackFolder.getContentType(), mediaListEntryArray, n);
            this.logger.log(14808325, "[%1.responseList] playback folder absolutePosition='%2'", (Object)"CombiJobGotoPlayingTrack", (long)this.absolutePositionPlaybackFolder);
            this.setState(3);
            return;
        }
        if (this.state == 4) {
            MediaDetailInfo mediaDetailInfo = this.getCombiAdapter().getState().getCurrentDetailInfo();
            int n2 = CombiBAPUtils.getAbsolutePosition(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), mediaListEntryArray, n);
            this.logger.log(14808325, "[%1.responseList] playing track absolutePosition='%2'", (Object)"CombiJobGotoPlayingTrack", (long)n2);
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(n2);
            this.sendDetailInfo();
            this.sendCurrentPlayingTrackResult(true);
            this.getExecutionContext().jobFinished();
            return;
        }
    }

    @Override
    public void errorListRequestAborted() {
        this.logger.log(1078071040, "[%1.errorListRequestAborted] List request aborted.", (Object)"CombiJobGotoPlayingTrack");
        if (this.state == 2) {
            this.setState(3);
            return;
        }
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
        this.sendDetailInfo();
        this.sendCurrentPlayingTrackResult(true);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("entryID='");
        buffer.append(this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID());
        buffer.append("'");
        return buffer.toString();
    }
}

