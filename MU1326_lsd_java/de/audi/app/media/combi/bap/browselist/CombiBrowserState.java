/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;

public class CombiBrowserState {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private volatile int absolutePositionCurrentTrack;
    private volatile boolean isBrowsingPlaybackFolder;
    private volatile MediaListEntry[] currentBrowsingFolder;
    private volatile MediaDetailInfo currentDetailInfo;
    private volatile int currentListSize;
    private volatile ResourceLocator currentCoverart;
    private volatile MediaListEntry[] currentPlaybackFolder;

    public CombiBrowserState(LogChannel logChannel) {
        this.logger = logChannel;
        this.reset();
    }

    public void reset() {
        this.absolutePositionCurrentTrack = 0;
        this.currentListSize = 0;
        this.isBrowsingPlaybackFolder = false;
        this.currentBrowsingFolder = new MediaListEntry[0];
        this.currentPlaybackFolder = PlayingTrack.EMPTY_PLAYBACK_FOLDER;
        this.currentDetailInfo = null;
    }

    public void setAbsolutePositionCurrentTrack(int n) {
        this.logger.log(-2137614336, "[%1.setAbsolutePositionCurrentTrack] pos='%2'", (Object)"CombiBrowserState", (long)n);
        this.absolutePositionCurrentTrack = n < 0 ? 0 : n;
    }

    public int getAbsolutePositionCurrentTrack() {
        return this.absolutePositionCurrentTrack;
    }

    public boolean isBrowsingPlaybackFolder() {
        return this.isBrowsingPlaybackFolder;
    }

    private void setBrowsingPlaybackFolder(boolean bl) {
        this.isBrowsingPlaybackFolder = bl;
    }

    public MediaListEntry[] getCurrentBrowsingFolder() {
        return this.currentBrowsingFolder;
    }

    public void setCurrentBrowsingFolder(MediaListEntry[] mediaListEntryArray) {
        this.currentBrowsingFolder = mediaListEntryArray;
        if (this.currentDetailInfo == null) {
            return;
        }
        this.setBrowsingPlaybackFolder(MediaUtils.isSameFolder(this.currentBrowsingFolder, this.currentPlaybackFolder));
    }

    public void setCurrentListSize(int n) {
        this.currentListSize = n;
    }

    public int getCurrentListSize() {
        return this.currentListSize;
    }

    public void setCurrentDetailInfo(MediaDetailInfo mediaDetailInfo) {
        this.currentDetailInfo = mediaDetailInfo;
        if (this.currentBrowsingFolder == null) {
            return;
        }
    }

    public MediaDetailInfo getCurrentDetailInfo() {
        return this.currentDetailInfo;
    }

    public ResourceLocator getCurrentCoverart() {
        return this.currentCoverart;
    }

    public void setCurrentCoverart(ResourceLocator resourceLocator) {
        this.currentCoverart = resourceLocator;
    }

    public MediaListEntry[] getPlaybackFolder() {
        return this.currentPlaybackFolder;
    }

    public void setPlaybackFolder(MediaListEntry[] mediaListEntryArray) {
        this.currentPlaybackFolder = mediaListEntryArray;
        if (this.currentPlaybackFolder != PlayingTrack.EMPTY_PLAYBACK_FOLDER) {
            this.setBrowsingPlaybackFolder(MediaUtils.isSameFolder(this.currentPlaybackFolder, this.currentBrowsingFolder));
        }
    }
}

