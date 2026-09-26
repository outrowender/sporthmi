/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.browselist.AbstractCombiBrowserJob;
import de.audi.app.media.combi.bap.browselist.CombiBAPDataBrowserContentAdapter;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;

public class CombiJobGotoRootFolder
extends AbstractCombiBrowserJob {
    private final String LOGCLASS;

    public CombiJobGotoRootFolder(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.LOGCLASS = "CombiJobGotoRootFolder";
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public String getName() {
        return "GOTOROOT";
    }

    @Override
    public void abort(boolean bl) {
        this.logger.log(1078071040, "[%1.abort]", (Object)"CombiJobGotoRootFolder");
        this.sendRootFolderResult(false);
    }

    @Override
    public void start() {
        MediaListEntry[] mediaListEntryArray = this.getCombiAdapter().getState().getCurrentBrowsingFolder();
        if (mediaListEntryArray.length < 2) {
            this.logger.log(1078071040, "[%1.start] Root folder reached.", (Object)"CombiJobGotoRootFolder");
            this.sendRootFolderResult(false);
            this.getExecutionContext().jobFinished();
            return;
        }
        MediaListEntry[] mediaListEntryArray2 = new MediaListEntry[]{mediaListEntryArray[0]};
        this.getCombiAdapter().changeFolder(mediaListEntryArray2);
    }

    @Override
    public void browseFolderChanged(MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(14808325, "[%1.browseFolderChanged] Receive browse folder.", (Object)"CombiJobGotoRootFolder");
        this.sendBrowseFolder(mediaListEntryArray, 0);
        this.sendListSize(n);
        if (!this.getCombiAdapter().getState().isBrowsingPlaybackFolder()) {
            this.logger.log(1078071040, "[%1.browseFolderChanged] Not browsing playback folder.", (Object)"CombiJobGotoRootFolder");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(false);
            this.sendDetailInfo();
            this.sendRootFolderResult(true);
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(14808325, "[%1.browseFolderChanged] Browsing playback folder.", (Object)"CombiJobGotoRootFolder");
        this.getCombiAdapter().getCombiAccessor().updatePlaybackFolder(true);
        MediaDetailInfo mediaDetailInfo = this.getCombiAdapter().getState().getCurrentDetailInfo();
        if (mediaDetailInfo == null) {
            this.logger.log(1078071040, "[%1.browseFolderChanged] No detail info available.", (Object)"CombiJobGotoRootFolder");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.sendDetailInfo();
            this.sendRootFolderResult(true);
            this.getExecutionContext().jobFinished();
            return;
        }
        this.getCombiAdapter().requestBrowseListByEntryId(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), 1);
    }

    @Override
    public void errorFolderChangeAborted() {
        this.logger.log(1078071040, "[%1.errorFolderChangeAborted] Folder change failed.", (Object)"CombiJobGotoRootFolder");
        this.sendRootFolderResult(false);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(14808325, "[%1.responseList] Receive list response.", (Object)"CombiJobGotoRootFolder");
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.getCombiAdapter().getState().getCurrentDetailInfo().getEntryID(), this.getCombiAdapter().getState().getCurrentDetailInfo().getContentType(), mediaListEntryArray, n));
        this.sendDetailInfo();
        this.sendRootFolderResult(true);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void errorListRequestAborted() {
        this.logger.log(1078071040, "[%1.errorListRequestAborted] List request aborted.", (Object)"CombiJobGotoRootFolder");
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
        this.sendDetailInfo();
        this.sendRootFolderResult(true);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        return "";
    }
}

