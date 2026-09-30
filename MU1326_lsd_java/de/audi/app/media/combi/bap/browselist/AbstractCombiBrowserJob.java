/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.combi.bap.browselist.CombiBAPDataBrowserContentAdapter;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.log.LogChannel;

public abstract class AbstractCombiBrowserJob
extends AbstractQueueJob {
    private static final String LOGCLASS = "AbstractCombiBrowserJob";
    protected final LogChannel logger;
    private final CombiBAPDataBrowserContentAdapter combiAdapter;

    public AbstractCombiBrowserJob(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter) {
        this.logger = logChannel;
        this.combiAdapter = combiBAPDataBrowserContentAdapter;
    }

    public abstract void responseList(int var1, MediaListEntry[] var2);

    public abstract void errorListRequestAborted();

    public abstract void browseFolderChanged(MediaListEntry[] var1, int var2);

    public abstract void errorFolderChangeAborted();

    public void addSelectionResult(boolean bl) {
    }

    protected final CombiBAPDataBrowserContentAdapter getCombiAdapter() {
        return this.combiAdapter;
    }

    protected final void sendDetailInfo() {
        this.logger.log(100000000, "[%1.sendDetailInfo] Send detail info.", (Object)LOGCLASS);
        MediaDetailInfo mediaDetailInfo = this.getCombiAdapter().getState().getCurrentDetailInfo();
        if (mediaDetailInfo == null) {
            this.logger.log(1000000, "[%1.sendDetailInfo] No detail information.", (Object)LOGCLASS);
            return;
        }
        this.getCombiAdapter().getCombiAccessor().updateCurrentPlayingTrack(1, mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), mediaDetailInfo.getEntryFlags(), mediaDetailInfo.getTitle(), mediaDetailInfo.getFilename(), mediaDetailInfo.getArtist(), mediaDetailInfo.getAlbum(), this.getCombiAdapter().getState().isBrowsingPlaybackFolder(), this.getCombiAdapter().getState().getAbsolutePositionCurrentTrack(), this.getCombiAdapter().getState().getCurrentCoverart());
    }

    protected final void sendListSize(int n) {
        this.logger.log(100000000, "[%1.sendListSize] size='%2'.", (Object)LOGCLASS, (long)n);
        this.getCombiAdapter().getCombiAccessor().updateListSize(n);
    }

    protected final void sendRootFolderResult(boolean bl) {
        this.logger.log(100000000, "[%2.sendRootFolderResult] result='%1'.", bl, (Object)LOGCLASS);
        this.getCombiAdapter().getCombiAccessor().gotoRootFolderResult(bl);
    }

    protected final void sendCurrentPlayingTrackResult(boolean bl) {
        this.logger.log(100000000, "[%2.sendCurrentPlayingTrackResult] result='%1'.", bl, (Object)LOGCLASS);
        this.getCombiAdapter().getCombiAccessor().gotoCurrentPlayingTrackResult(bl);
    }

    protected final void sendParentFolderResult(boolean bl) {
        this.logger.log(100000000, "[%2.sendParentFolderResult] result='%1'.", bl, (Object)LOGCLASS);
        this.getCombiAdapter().getCombiAccessor().gotoParentFolderResult(bl);
    }

    protected final void sendSubFolderResult(boolean bl) {
        this.logger.log(100000000, "[%2.sendSubFolderResult] result='%1'.", bl, (Object)LOGCLASS);
        this.getCombiAdapter().getCombiAccessor().gotoSubFolderResult(bl);
    }

    protected final void sendBrowseFolder(MediaListEntry[] mediaListEntryArray, int n) {
        this.getCombiAdapter().getCombiAccessor().updateBrowseFolder(mediaListEntryArray, n);
    }

    public void abort(boolean bl) {
    }
}

