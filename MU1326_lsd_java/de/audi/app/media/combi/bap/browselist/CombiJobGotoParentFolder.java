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

public class CombiJobGotoParentFolder
extends AbstractCombiBrowserJob {
    private final String LOGCLASS;
    private static final int STATE_UNDEFINED = 0;
    private static final int STATE_CALCULATE_ABSOLUTE_POSITION_IN_PARENT_FOLDER = 1;
    private static final int STATE_CHANGE_TO_DESTINATION_FOLDER = 2;
    private static final int STATE_CALCULATE_ABSOLUTE_POSITION_PLAYING_TRACK = 3;
    private volatile MediaListEntry[] currentBrowsingFolder;
    private volatile MediaListEntry destinationFolder = null;
    private volatile int destinationFolderAbsolutePosition = 0;
    private volatile int state = 0;

    public CombiJobGotoParentFolder(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.LOGCLASS = "CombiJobGotoParentFolder";
    }

    public int getType() {
        return 2;
    }

    public String getName() {
        return "GOTOPARENTFOLDER";
    }

    public void abort(boolean bl) {
        this.logger.log(1000000, "[%1.abort]", (Object)"CombiJobGotoParentFolder");
        this.sendParentFolderResult(false);
    }

    public void start() {
        this.currentBrowsingFolder = this.getCombiAdapter().getState().getCurrentBrowsingFolder();
        if (this.currentBrowsingFolder.length < 2) {
            this.logger.log(10000000, "[%1.start] Root level already reached.", (Object)"CombiJobGotoParentFolder");
            this.sendParentFolderResult(false);
            this.getExecutionContext().jobFinished();
            return;
        }
        if (this.currentBrowsingFolder.length == 2) {
            this.logger.log(10000000, "[%1.start] First sublevel.", (Object)"CombiJobGotoParentFolder");
            this.changeToDestinationFolder();
            return;
        }
        this.logger.log(100000000, "[%1.start] Change to parent of destination folder", (Object)"CombiJobGotoParentFolder");
        this.state = 1;
        this.destinationFolder = this.currentBrowsingFolder[this.currentBrowsingFolder.length - 2];
        this.getCombiAdapter().changeFolder(MediaUtils.getParentFolderStack(this.currentBrowsingFolder, 2));
    }

    private void changeToDestinationFolder() {
        this.state = 2;
        this.getCombiAdapter().changeFolder(MediaUtils.getParentFolderStack(this.currentBrowsingFolder, 1));
    }

    public void browseFolderChanged(MediaListEntry[] mediaListEntryArray, int n) {
        switch (this.state) {
            case 1: {
                this.logger.log(1000000, "[%1.browseFolderChanged] List request for absolute position for parent folder", (Object)"CombiJobGotoParentFolder");
                this.getCombiAdapter().requestBrowseListByEntryId(this.destinationFolder.getEntryID(), this.destinationFolder.getContentType(), 1);
                break;
            }
            case 2: {
                this.logger.log(1000000, "[%1.browseFolderChanged] Destination folder reached (pos='%3'). ", (Object)"CombiJobGotoParentFolder", (long)this.destinationFolderAbsolutePosition);
                this.sendBrowseFolder(this.getCombiAdapter().getState().getCurrentBrowsingFolder(), this.destinationFolderAbsolutePosition);
                this.sendListSize(this.getCombiAdapter().getState().getCurrentListSize());
                if (!this.getCombiAdapter().getState().isBrowsingPlaybackFolder()) {
                    this.logger.log(1000000, "[%1.browseFolderChanged] Not browsing playback folder.", (Object)"CombiJobGotoParentFolder");
                    this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
                    this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(false);
                    this.sendDetailInfo();
                    this.sendParentFolderResult(true);
                    this.getExecutionContext().jobFinished();
                    return;
                }
                this.logger.log(1000000, "[%1.browseFolderChanged] Browsing playback folder.", (Object)"CombiJobGotoParentFolder");
                this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(true);
                MediaDetailInfo mediaDetailInfo = this.getCombiAdapter().getState().getCurrentDetailInfo();
                if (mediaDetailInfo == null) {
                    this.logger.log(1000000, "[%1.browseFolderChanged] No detail info available.", (Object)"CombiJobGotoParentFolder");
                    this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
                    this.sendDetailInfo();
                    this.sendParentFolderResult(true);
                    this.getExecutionContext().jobFinished();
                    return;
                }
                this.state = 3;
                this.getCombiAdapter().requestBrowseListByEntryId(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), 1);
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.browseFolderChanged] Wrong state.", (Object)"CombiJobGotoParentFolder");
            }
        }
    }

    public void errorFolderChangeAborted() {
        if (this.state == 2) {
            this.logger.log(1000000, "[%1.errorFolderChangeAborted] STATE_CHANGE_TO_DESTINATION_FOLDER", (Object)"CombiJobGotoParentFolder");
            if (this.currentBrowsingFolder.length - this.getCombiAdapter().getState().getCurrentBrowsingFolder().length == 2) {
                this.logger.log(1000000, "[%1.errorFolderChangeAborted] Leave on the parent folder.", (Object)"CombiJobGotoParentFolder");
                this.sendBrowseFolder(this.getCombiAdapter().getState().getCurrentBrowsingFolder(), 0);
                this.sendListSize(this.getCombiAdapter().getState().getCurrentListSize());
                this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
                this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(false);
                this.sendDetailInfo();
                this.sendParentFolderResult(true);
                this.getExecutionContext().jobFinished();
                return;
            }
        }
        this.logger.log(1000000, "[%1.errorFolderChangeAborted] GoUp failed.", (Object)"CombiJobGotoParentFolder");
        this.sendParentFolderResult(false);
        this.getExecutionContext().jobFinished();
    }

    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        switch (this.state) {
            case 1: {
                this.logger.log(1000000, "[%1.responseList] Calculate absolute position of parent folder", (Object)"CombiJobGotoParentFolder");
                this.destinationFolderAbsolutePosition = CombiBAPUtils.getAbsolutePosition(this.destinationFolder.getEntryID(), this.destinationFolder.getContentType(), mediaListEntryArray, n);
                this.logger.log(1000000, "[%1.responseList] absolutePosition='%2'", (Object)"CombiJobGotoParentFolder", (long)this.destinationFolderAbsolutePosition);
                this.changeToDestinationFolder();
                break;
            }
            case 3: {
                this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID(), this.getCombiAdapter().getState().getCurrentDetailInfo().getContentType(), mediaListEntryArray, n));
                this.sendDetailInfo();
                this.sendParentFolderResult(true);
                this.getExecutionContext().jobFinished();
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.responseList] Wrong state.", (Object)"CombiJobGotoParentFolder");
            }
        }
    }

    public void errorListRequestAborted() {
        if (this.state == 1) {
            this.logger.log(1000000, "[%1.errorListRequestAborted] STATE_CALCULATE_ABSOLUTE_POSITION_PARENT_FOLDER", (Object)"CombiJobGotoParentFolder");
            this.changeToDestinationFolder();
            return;
        }
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
        this.sendDetailInfo();
        this.sendParentFolderResult(true);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        return "";
    }
}

