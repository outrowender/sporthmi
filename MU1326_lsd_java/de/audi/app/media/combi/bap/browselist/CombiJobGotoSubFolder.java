/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.browselist.AbstractCombiBrowserJob;
import de.audi.app.media.combi.bap.browselist.CombiBAPDataBrowserContentAdapter;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;

public class CombiJobGotoSubFolder
extends AbstractCombiBrowserJob {
    private final String LOGCLASS;
    public static final int STATE_UNDEFINED = 0;
    public static final int STATE_ABSOLUTE_POSITION_DESITINATION_FOLDER = 1;
    public static final int STATE_ABSOLUTE_POSITION_PLAYING_TRACK = 2;
    private final CombiBAPMediaEntry subFolder;
    private int state = 0;
    private int absolutePositionFolder = 0;

    public CombiJobGotoSubFolder(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter, CombiBAPMediaEntry combiBAPMediaEntry) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.LOGCLASS = "CombiJobGotoSubFolder";
        this.subFolder = combiBAPMediaEntry;
    }

    public int getType() {
        return 5;
    }

    public String getName() {
        return "SUBFOLDER";
    }

    public void abort(boolean bl) {
        this.logger.log(1000000, "[%1.abort]", (Object)"CombiJobGotoSubFolder");
        this.sendSubFolderResult(false);
    }

    public void start() {
        this.logger.log(100000000, "[%1.start] Calculate absolute position of sub folder.", (Object)"CombiJobGotoSubFolder");
        this.state = 1;
        this.getCombiAdapter().requestBrowseListByEntryId(this.subFolder.getEntryID(), this.subFolder.getEntryContentType(), 1);
    }

    private void changeToSubFolder() {
        this.logger.log(100000000, "[%1.changeToSubFolder]", (Object)"CombiJobGotoSubFolder");
        MediaListEntry[] mediaListEntryArray = this.getCombiAdapter().getState().getCurrentBrowsingFolder();
        MediaListEntry[] mediaListEntryArray2 = new MediaListEntry[mediaListEntryArray.length + 1];
        System.arraycopy((Object)mediaListEntryArray, 0, (Object)mediaListEntryArray2, 0, mediaListEntryArray.length);
        mediaListEntryArray2[mediaListEntryArray2.length - 1] = this.subFolder.getEntry();
        this.getCombiAdapter().changeFolder(mediaListEntryArray2);
    }

    public void browseFolderChanged(MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(100000000, "[%1.browseFolderChanged] Browse folder changed.", (Object)"CombiJobGotoSubFolder");
        this.sendBrowseFolder(this.getCombiAdapter().getState().getCurrentBrowsingFolder(), this.absolutePositionFolder);
        this.sendListSize(n);
        if (!this.getCombiAdapter().getState().isBrowsingPlaybackFolder()) {
            this.logger.log(1000000, "[%1.browseFolderChanged] Browsing not playback folder.", (Object)"CombiJobGotoSubFolder");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(false);
            this.sendDetailInfo();
            this.sendSubFolderResult(true);
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(100000000, "[%1.browseFolderChanged] Browsing playback folder.", (Object)"CombiJobGotoSubFolder");
        this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(true);
        MediaDetailInfo mediaDetailInfo = this.getCombiAdapter().getState().getCurrentDetailInfo();
        if (mediaDetailInfo == null) {
            this.logger.log(1000000, "[%1.browseFolderChanged] No detail info.", (Object)"CombiJobGotoSubFolder");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.sendDetailInfo();
            this.sendSubFolderResult(true);
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(100000000, "[%1.browseFolderChanged] Calculate absolute position playing track.", (Object)"CombiJobGotoSubFolder");
        this.state = 2;
        this.getCombiAdapter().requestBrowseListByEntryId(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), 1);
    }

    public void errorFolderChangeAborted() {
        this.logger.log(1000000, "[%1.errorFolderChangeAborted] Folder change failed.", (Object)"CombiJobGotoSubFolder");
        this.sendSubFolderResult(false);
        this.getExecutionContext().jobFinished();
    }

    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        if (this.state == 1) {
            this.absolutePositionFolder = CombiBAPUtils.getAbsolutePosition(this.subFolder.getEntryID(), this.subFolder.getEntryContentType(), mediaListEntryArray, n);
            this.logger.log(1000000, "[%1.responseList] STATE_ABSOLUTE_POSITION_DESITINATION_FOLDER absolutePositionSubFolder = '%2'", (Object)"CombiJobGotoSubFolder", (long)this.absolutePositionFolder);
            this.changeToSubFolder();
            return;
        }
        if (this.state == 2) {
            this.logger.log(1000000, "[%1.responseList] STATE_ABSOLUTE_POSITION_PLAYING_TRACK", (Object)"CombiJobGotoSubFolder");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID(), this.getCombiAdapter().getState().getCurrentDetailInfo().getContentType(), mediaListEntryArray, n));
            this.sendDetailInfo();
            this.sendSubFolderResult(true);
            this.getExecutionContext().jobFinished();
            return;
        }
    }

    public void errorListRequestAborted() {
        if (this.state == 1) {
            this.logger.log(1000000, "[%1.errorListRequestAborted] STATE_ABSOLUTE_POSITION_DESITINATION_FOLDER", (Object)"CombiJobGotoSubFolder");
            this.changeToSubFolder();
            return;
        }
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
        this.sendDetailInfo();
        this.sendSubFolderResult(true);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        return this.subFolder.toString();
    }
}

