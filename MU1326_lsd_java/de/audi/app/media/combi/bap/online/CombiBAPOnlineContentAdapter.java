/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.online;

import de.audi.app.media.combi.bap.AbstractCombiBAPContentAdapter;
import de.audi.app.media.combi.bap.ICombiBAPContentAccessor;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.online.content.IContentOnlineMedia;
import de.audi.app.media.content.media.online.content.IOnlineMusicStateListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;

public class CombiBAPOnlineContentAdapter
extends AbstractCombiBAPContentAdapter
implements IPlayerTrackListener,
IPlayerListener,
IOnlineMusicStateListener {
    private static final String LOGCLASS;
    IContentOnlineMedia onlineContent;
    private static final int COMBI_STARTUP_INVALID;
    private static final int COMBI_STARTUP_WAITFOR_DETAIL_INFO;
    private static final int COMBI_STARTUP_RECEIVE_DETAIL_INFO;
    private static final int COMBI_STARTUP_FINISHED;
    private volatile int startupState = 0;
    private volatile MediaDetailInfo startupDetailInfo = null;
    private volatile MediaDetailInfo currentDetailInfo = null;
    private ResourceLocator onlineCoverart = null;

    public CombiBAPOnlineContentAdapter(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public void activate(IContent iContent, ICombiBAPContentAccessor iCombiBAPContentAccessor) {
        this.logger.log(1078071040, "[%1.activate]", (Object)"CombiBAPOnlineContentAdapter");
        super.activate(iContent, iCombiBAPContentAccessor);
        this.onlineContent = (IContentOnlineMedia)iContent;
        this.onlineContent.getPlayer().addTrackListener(this);
        this.onlineContent.getPlayer().addPlayerListener(this);
        this.onlineContent.setOnlineMusicStateListener(this);
        this.getCombiAccessor().updateListState(false, 4);
        MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(0L, 0, null)};
        iCombiBAPContentAccessor.updateBrowseFolder(mediaListEntryArray, 0);
        this.setStartupState(1);
        iCombiBAPContentAccessor.updatePlaybackFolder(false);
        this.getCombiAccessor().updateCurrentPlayingTrack(-1, 0L, 0, 0, new I18NString("", false), new I18NString("", false), new I18NString("", false), new I18NString("", false), false, 0, null);
    }

    private void setStartupState(int n) {
        this.startupState = n;
        switch (n) {
            case 0: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_INVALID", (Object)"CombiBAPOnlineContentAdapter");
                break;
            }
            case 1: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_DETAIL_INFO", (Object)"CombiBAPOnlineContentAdapter");
                break;
            }
            case 2: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_RECEIVE_DETAIL_INFO", (Object)"CombiBAPOnlineContentAdapter");
                this.setDetailInfo(this.startupDetailInfo, this.onlineCoverart);
                this.setStartupState(3);
                break;
            }
            case 3: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_FINISHED", (Object)"CombiBAPOnlineContentAdapter");
                this.getCombiAccessor().contentAdapterStartupFinished();
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1.setStartupState] UNKNOWN STATE", (Object)"CombiBAPOnlineContentAdapter");
            }
        }
    }

    @Override
    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"CombiBAPOnlineContentAdapter");
        this.onlineContent.getPlayer().removeTrackListener(this);
        this.onlineContent.getPlayer().removePlayerListener(this);
        this.onlineContent.setOnlineMusicStateListener(null);
        this.startupState = 0;
        super.deactivate();
    }

    @Override
    public boolean skip(boolean bl, int n) {
        return this.onlineContent.getPlayer().skip(bl, n);
    }

    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        if (this.startupState == 1) {
            this.startupDetailInfo = mediaDetailInfo;
            this.setStartupState(2);
        } else {
            this.setDetailInfo(mediaDetailInfo, this.onlineCoverart);
        }
    }

    @Override
    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        int n = playTime.getTotalTimeOfTrack() == 0 ? -65536 : playTime.getTotalTimeOfTrack();
        int n2 = n == -65536 ? -65536 : playTime.getPlayTime();
        this.getCombiAccessor().updatePlayPosition(new PlayTime(n2, n));
    }

    @Override
    public void coverArtChanged(ResourceLocator resourceLocator) {
        this.onlineCoverart = resourceLocator;
        if (this.currentDetailInfo != null) {
            this.setDetailInfo(this.currentDetailInfo, this.onlineCoverart);
        }
    }

    @Override
    public void repeatScopeChanged(int n, boolean bl) {
        this.logger.log(1078071040, "[%1.repeatScopeChanged] Scope changed (scope='%2',mix='%3').", (Object)"CombiBAPOnlineContentAdapter", (Object)String.valueOf(n), (Object)String.valueOf(bl));
        this.getCombiAccessor().updateActiveRepeatScope(n, bl);
    }

    @Override
    public void repeatModeChanged(int n) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("CombiBAPOnlineContentAdapter").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    public void playerStartupComplete() {
    }

    @Override
    public void playbackStateChanged(int n) {
    }

    @Override
    public void capabilitiesChanged(Capabilities capabilities) {
    }

    @Override
    public void commandBlocked() {
    }

    @Override
    public void currentPMLevelChanged(int n) {
    }

    private void setDetailInfo(MediaDetailInfo mediaDetailInfo, ResourceLocator resourceLocator) {
        this.logger.log(14808325, "[%1.setDetailInfo]", (Object)"CombiBAPOnlineContentAdapter");
        this.currentDetailInfo = mediaDetailInfo;
        this.getCombiAccessor().updateCurrentPlayingTrack(8, mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), mediaDetailInfo.getEntryFlags(), mediaDetailInfo.getTitle(), mediaDetailInfo.getFilename(), mediaDetailInfo.getArtist(), mediaDetailInfo.getAlbum(), false, 0, resourceLocator);
    }

    @Override
    public void updateMusicState(int n, int n2, int n3) {
        this.getCombiAccessor().updateOnlineMusicState(n, n2, n3);
    }
}

