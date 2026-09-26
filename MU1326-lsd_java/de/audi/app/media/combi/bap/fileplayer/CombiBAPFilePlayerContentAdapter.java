/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.fileplayer;

import de.audi.app.media.combi.bap.AbstractCombiBAPContentAdapter;
import de.audi.app.media.combi.bap.ICombiBAPContentAccessor;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentMedia;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class CombiBAPFilePlayerContentAdapter
extends AbstractCombiBAPContentAdapter
implements IPlayerTrackListener {
    private static final String LOGCLASS;
    private IPlayer filePlayer;

    public CombiBAPFilePlayerContentAdapter(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public void activate(IContent iContent, ICombiBAPContentAccessor iCombiBAPContentAccessor) {
        this.logger.log(1078071040, "[%1.activate]", (Object)"CombiBAPFilePlayerContentAdapter");
        super.activate(iContent, iCombiBAPContentAccessor);
        this.filePlayer = ((IContentMedia)iContent).getPlayer();
        this.filePlayer.addTrackListener(this);
        this.getCombiAccessor().updateListState(false, 4);
        MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(0L, 0, null)};
        iCombiBAPContentAccessor.updateBrowseFolder(mediaListEntryArray, 0);
        iCombiBAPContentAccessor.updatePlaybackFolder(false);
    }

    @Override
    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"CombiBAPFilePlayerContentAdapter");
        this.filePlayer.removeTrackListener(this);
        super.deactivate();
    }

    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.log(14808325, "[%1.detailInfoChanged]", (Object)"CombiBAPFilePlayerContentAdapter");
        if (mediaDetailInfo.isAudio()) {
            this.getCombiAccessor().updateActiveFileplayerPlaybackType(0);
        } else {
            this.getCombiAccessor().updateActiveFileplayerPlaybackType(1);
        }
    }

    @Override
    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
    }

    @Override
    public void coverArtChanged(ResourceLocator resourceLocator) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("CombiBAPFilePlayerContentAdapter").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }
}

