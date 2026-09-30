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
    private static final String LOGCLASS = "CombiBAPOnlineContentAdapter";
    IContentOnlineMedia onlineContent;
    private static final int COMBI_STARTUP_INVALID = 0;
    private static final int COMBI_STARTUP_WAITFOR_DETAIL_INFO = 1;
    private static final int COMBI_STARTUP_RECEIVE_DETAIL_INFO = 2;
    private static final int COMBI_STARTUP_FINISHED = 3;
    private volatile int startupState = 0;
    private volatile MediaDetailInfo startupDetailInfo = null;
    private volatile MediaDetailInfo currentDetailInfo = null;
    private ResourceLocator onlineCoverart = null;

    public CombiBAPOnlineContentAdapter(LogChannel logChannel) {
        super(logChannel);
    }

    public void activate(IContent iContent, ICombiBAPContentAccessor iCombiBAPContentAccessor) {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
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
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_INVALID", (Object)LOGCLASS);
                break;
            }
            case 1: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_DETAIL_INFO", (Object)LOGCLASS);
                break;
            }
            case 2: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_RECEIVE_DETAIL_INFO", (Object)LOGCLASS);
                this.setDetailInfo(this.startupDetailInfo, this.onlineCoverart);
                this.setStartupState(3);
                break;
            }
            case 3: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_FINISHED", (Object)LOGCLASS);
                this.getCombiAccessor().contentAdapterStartupFinished();
                break;
            }
            default: {
                this.logger.log(100000, "[%1.setStartupState] UNKNOWN STATE", (Object)LOGCLASS);
            }
        }
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.onlineContent.getPlayer().removeTrackListener(this);
        this.onlineContent.getPlayer().removePlayerListener(this);
        this.onlineContent.setOnlineMusicStateListener(null);
        this.startupState = 0;
        super.deactivate();
    }

    public boolean skip(boolean bl, int n) {
        return this.onlineContent.getPlayer().skip(bl, n);
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        if (this.startupState == 1) {
            this.startupDetailInfo = mediaDetailInfo;
            this.setStartupState(2);
        } else {
            this.setDetailInfo(mediaDetailInfo, this.onlineCoverart);
        }
    }

    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        int n = playTime.getTotalTimeOfTrack() == 0 ? 65535 : playTime.getTotalTimeOfTrack();
        int n2 = n == 65535 ? 65535 : playTime.getPlayTime();
        this.getCombiAccessor().updatePlayPosition(new PlayTime(n2, n));
    }

    public void coverArtChanged(ResourceLocator resourceLocator) {
        this.onlineCoverart = resourceLocator;
        if (this.currentDetailInfo != null) {
            this.setDetailInfo(this.currentDetailInfo, this.onlineCoverart);
        }
    }

    public void repeatScopeChanged(int n, boolean bl) {
        this.logger.log(1000000, "[%1.repeatScopeChanged] Scope changed (scope='%2',mix='%3').", (Object)LOGCLASS, (Object)String.valueOf(n), (Object)String.valueOf(bl));
        this.getCombiAccessor().updateActiveRepeatScope(n, bl);
    }

    public void repeatModeChanged(int n) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    public void playerStartupComplete() {
    }

    public void playbackStateChanged(int n) {
    }

    public void capabilitiesChanged(Capabilities capabilities) {
    }

    public void commandBlocked() {
    }

    public void currentPMLevelChanged(int n) {
    }

    private void setDetailInfo(MediaDetailInfo mediaDetailInfo, ResourceLocator resourceLocator) {
        this.logger.log(100000000, "[%1.setDetailInfo]", (Object)LOGCLASS);
        this.currentDetailInfo = mediaDetailInfo;
        this.getCombiAccessor().updateCurrentPlayingTrack(8, mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType(), mediaDetailInfo.getEntryFlags(), mediaDetailInfo.getTitle(), mediaDetailInfo.getFilename(), mediaDetailInfo.getArtist(), mediaDetailInfo.getAlbum(), false, 0, resourceLocator);
    }

    public void updateMusicState(int n, int n2, int n3) {
        this.getCombiAccessor().updateOnlineMusicState(n, n2, n3);
    }
}

