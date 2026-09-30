/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.playview;

import de.audi.app.media.combi.bap.playview.CombiBAPPlayViewContentAdapter;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractCombiPlayViewJob
extends AbstractQueueJob {
    private static final String LOGCLASS = "AbstractCombiPlayViewJob";
    protected final LogChannel logger;
    private final CombiBAPPlayViewContentAdapter combiAdapter;

    public AbstractCombiPlayViewJob(LogChannel logChannel, CombiBAPPlayViewContentAdapter combiBAPPlayViewContentAdapter) {
        this.logger = logChannel;
        this.combiAdapter = combiBAPPlayViewContentAdapter;
    }

    public abstract void responsePlayViewList(int var1, MediaListEntry[] var2);

    public abstract void errorListRequestAborted();

    protected final CombiBAPPlayViewContentAdapter getCombiAdapter() {
        return this.combiAdapter;
    }

    protected final void sendDetailInfo() {
        this.logger.log(1000000, "[%1.sendDetailInfo]", (Object)LOGCLASS);
        int n = this.getCombiAdapter().getState().getAbsolutePositionCurrentTrack();
        MediaDetailInfo mediaDetailInfo = this.getCombiAdapter().getState().getCurrentDetailInfo();
        ResourceLocator resourceLocator = this.getCombiAdapter().getState().getCurrentCoverart();
        if (mediaDetailInfo == null) {
            this.logger.log(1000000, "[%1.sendDetailInfo] No detail information.", (Object)LOGCLASS);
            return;
        }
        this.getCombiAdapter().getCombiAccessor().updateCurrentPlayingTrack(this.getCombiAdapter().getContentType(), mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), mediaDetailInfo.getEntryFlags(), mediaDetailInfo.getTitle(), mediaDetailInfo.getFilename(), mediaDetailInfo.getArtist(), mediaDetailInfo.getAlbum(), true, n, resourceLocator);
    }
}

