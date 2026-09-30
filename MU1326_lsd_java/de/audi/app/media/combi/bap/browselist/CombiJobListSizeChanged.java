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
import de.esolutions.fw.util.commons.Buffer;

public class CombiJobListSizeChanged
extends AbstractCombiBrowserJob {
    private final String LOGCLASS;
    private final int newListSize;

    public CombiJobListSizeChanged(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter, int n) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.LOGCLASS = "CombiJobListSizeChanged";
        this.newListSize = n;
    }

    public int getType() {
        return 6;
    }

    public String getName() {
        return "LISTSIZE";
    }

    public void start() {
        this.sendListSize(this.newListSize);
        if (!this.getCombiAdapter().getState().isBrowsingPlaybackFolder()) {
            this.logger.log(1000000, "[%1.start] Not browsing playback folder.", (Object)"CombiJobListSizeChanged");
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(100000000, "[%1.start] Browsing playback folder.", (Object)"CombiJobListSizeChanged");
        if (this.newListSize == 0) {
            this.logger.log(1000000, "[%1.start] Empty list.", (Object)"CombiJobListSizeChanged");
            this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
            this.sendDetailInfo();
            this.getExecutionContext().jobFinished();
            return;
        }
        MediaDetailInfo mediaDetailInfo = this.getCombiAdapter().getState().getCurrentDetailInfo();
        if (mediaDetailInfo == null) {
            this.logger.log(1000000, "[%1.start] No detail information.", (Object)"CombiJobListSizeChanged");
            this.getExecutionContext().jobFinished();
            return;
        }
        this.getCombiAdapter().requestBrowseListByEntryId(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), 1);
    }

    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(100000000, "[%1.responseList] Receive response.", (Object)"CombiJobListSizeChanged");
        MediaDetailInfo mediaDetailInfo = this.getCombiAdapter().getState().getCurrentDetailInfo();
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), mediaListEntryArray, n));
        this.sendDetailInfo();
        this.getExecutionContext().jobFinished();
    }

    public void errorListRequestAborted() {
        this.logger.log(1000000, "[%1.errorListRequestAborted] List request aborted.", (Object)"CombiJobListSizeChanged");
        this.getCombiAdapter().getState().setAbsolutePositionCurrentTrack(0);
        this.sendDetailInfo();
        this.getExecutionContext().jobFinished();
    }

    public void browseFolderChanged(MediaListEntry[] mediaListEntryArray, int n) {
    }

    public void errorFolderChangeAborted() {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("size='");
        buffer.append(this.newListSize);
        buffer.append("'");
        return buffer.toString();
    }
}

