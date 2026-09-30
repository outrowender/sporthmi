/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.sdis.IMediaSDISNotifier;
import de.audi.app.media.sdis.MediaUtilsSDIS;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaI18NString;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.dsi.ifc.media.Capabilities;

public class MediaSDISNotifier
implements IMediaSDISNotifier {
    private static final String LOGCLASS = "MediaSDISNotifier";
    private final LogChannel logger;
    private volatile ASIHMISyncMediaAbstractBaseService asiProvider;
    private volatile MediaActiveSourceState activeSourceState;
    private final boolean iPodIsSupportedOnSDIS;

    public MediaSDISNotifier(LogChannel logChannel, boolean bl) {
        this.logger = logChannel;
        this.iPodIsSupportedOnSDIS = bl;
    }

    public void init(ASIHMISyncMediaAbstractBaseService aSIHMISyncMediaAbstractBaseService) {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.asiProvider = aSIHMISyncMediaAbstractBaseService;
        try {
            this.asiProvider.updateASIVersion("4.8.2");
        }
        catch (MethodException methodException) {
            this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
    }

    public void updateSourceList(Map map) {
        this.logger.log(1000000, "[%1.updateSourceList]", (Object)LOGCLASS);
        Set set = map.keySet();
        ArrayList arrayList = new ArrayList();
        int n = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer n2 = (Integer)iterator.next();
            List list = (List)map.get(n2);
            Iterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                MediaSourceSlot mediaSourceSlot = this.getSDISSlotFromSlot((ISourceSlot)iterator2.next());
                if (mediaSourceSlot.getSource() == 0) continue;
                arrayList.add(mediaSourceSlot);
                if (this.logger.isInfo()) {
                    this.logger.log(1000000, "[%1.updateSourceList] [%2] %3", (Object)LOGCLASS, (Object)Integer.toString(n), (Object)mediaSourceSlot);
                }
                ++n;
            }
        }
        try {
            this.asiProvider.updateSourceList((MediaSourceSlot[])arrayList.toArray(new MediaSourceSlot[arrayList.size()]));
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updateSourceList] Exception during call", (Throwable)exception);
        }
    }

    public void updateActiveSourceState(ActiveSourceState activeSourceState) {
        try {
            this.logger.log(1000000, "[%1.updateActiveSourceState] pState: '%2'.", (Object)LOGCLASS, (Object)activeSourceState);
            MediaActiveSourceState mediaActiveSourceState = new MediaActiveSourceState();
            mediaActiveSourceState.setSlot(this.getSDISSlotFromSlot(activeSourceState.getSlot()));
            switch (activeSourceState.getState()) {
                case 2: {
                    mediaActiveSourceState.state = 2;
                    break;
                }
                case 3: {
                    mediaActiveSourceState.state = 3;
                    break;
                }
                case 1: {
                    mediaActiveSourceState.state = 1;
                    break;
                }
                default: {
                    mediaActiveSourceState.state = 4;
                }
            }
            this.activeSourceState = mediaActiveSourceState;
            this.logger.log(1000000, "[%1.updateActiveSourceState] sourceState: '%2'.", (Object)LOGCLASS, (Object)mediaActiveSourceState);
            this.asiProvider.updateActiveSlotState(mediaActiveSourceState);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updateActiveSourceState]", (Throwable)exception);
        }
    }

    public void updateMix(boolean bl) {
        this.logger.log(1000000, "[%1.updateMix]", (Object)LOGCLASS);
        try {
            this.asiProvider.updateMix(bl);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updateMix]", (Throwable)exception);
        }
    }

    public void updateRepeatTitle(boolean bl) {
        this.logger.log(1000000, "[%1.updateRepeatTitle]", (Object)LOGCLASS);
        try {
            this.asiProvider.updateRepeatTitle(bl);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updateRepeatTitle]", (Throwable)exception);
        }
    }

    public void updateRepeatMode(int n) {
        int n2;
        this.logger.log(1000000, "[%1.updateRepeatMode] mode=%2", (Object)LOGCLASS, (long)n);
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            default: {
                this.logger.log(100000, "[%1.updateRepeatMode] Unknown repeat mode! (Default: OFF)", (Object)LOGCLASS);
                n2 = 0;
            }
        }
        try {
            this.logger.log(1000000, "[%1.updateASIRepeatMode: %2]", (Object)LOGCLASS, (long)n2);
            this.asiProvider.updateRepeatState(n);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updateRepeatMode] Exception during call", (Throwable)exception);
        }
    }

    public void updatePlaybackState(int n) {
        int n2;
        this.logger.log(1000000, "[%1.updatePlaybackState]", (Object)LOGCLASS);
        switch (n) {
            case 2: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 0;
                break;
            }
            case 5: {
                n2 = 6;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 3;
                break;
            }
            case 6: {
                n2 = 4;
                break;
            }
            default: {
                n2 = 5;
            }
        }
        try {
            this.logger.log(1000000, "[%1.updateASIPlaybackState: %2]", (Object)LOGCLASS, (long)n2);
            this.asiProvider.updatePlaybackState((byte)n2);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updatePlaybackState] Exception during call", (Throwable)exception);
        }
    }

    public void updatePlayingPosition(PlayingTrack playingTrack, PlayTime playTime) {
        this.logger.log(10000000, "[%1.updatePlayingPosition] %2, %3", (Object)LOGCLASS, (Object)playingTrack, (Object)playTime);
        MediaPlayTime mediaPlayTime = new MediaPlayTime();
        if (playingTrack != null && playTime != null) {
            mediaPlayTime.setId(playingTrack.getEntryID());
            mediaPlayTime.setTime(playTime.getRestrictedPlayTime());
            mediaPlayTime.setTotalTime(playTime.getRestrictedTotalTime());
        } else {
            mediaPlayTime.setId(0L);
            mediaPlayTime.setTime(0);
            mediaPlayTime.setTotalTime(0);
        }
        try {
            this.asiProvider.updatePlayPosition(mediaPlayTime);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updatePlayingPosition] Exception during call", (Throwable)exception);
        }
    }

    public void updatePlayerCapabilities(Capabilities capabilities) {
        int n = 0;
        if (capabilities.browseWhilePlay) {
            n |= 4;
        }
        if (capabilities.detailInfos) {
            n |= 0x10000;
        }
        if (capabilities.extendedPlayView) {
            n |= 0x100000;
        }
        if (capabilities.fastBwd) {
            n |= 0x10;
        }
        if (capabilities.fastFwd) {
            n |= 8;
        }
        if (capabilities.pause) {
            n |= 0x800;
        }
        if (capabilities.play) {
            n |= 0x200;
        }
        if (capabilities.playbackModes) {
            n |= 0x8000;
        }
        if (capabilities.playSimilarEntries) {
            n |= 0x40000;
        }
        if (capabilities.playTime) {
            n |= 0x200000;
        }
        if (capabilities.playView) {
            n |= 0x20000;
        }
        if (capabilities.resume) {
            n |= 0x400;
        }
        if (capabilities.setEntry) {
            n |= 0x2000;
        }
        if (capabilities.setTimePos) {
            n |= 0x4000;
        }
        if (capabilities.skipBwd) {
            n |= 2;
        }
        if (capabilities.skipFwd) {
            n |= 1;
        }
        if (capabilities.sloMoBwd) {
            n |= 0x40;
        }
        if (capabilities.sloMoFwd) {
            n |= 0x20;
        }
        if (capabilities.stillBwd) {
            n |= 0x100;
        }
        if (capabilities.stillFwd) {
            n |= 0x80;
        }
        if (capabilities.stop) {
            n |= 0x1000;
        }
        if (capabilities.totalPlaytime) {
            n |= 0x80000;
        }
        if (capabilities.playbackModeToggle) {
            n |= 0x400000;
        }
        try {
            this.asiProvider.updatePlayerCapabilities(n);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updatePlayerCapabilities] Exception during call", (Throwable)exception);
        }
    }

    public void updatePlayingTrack(MediaDetailInfo mediaDetailInfo, String string) {
        this.logger.log(1000000, "[%1.updatePlayingTrack] pDetailInfo:'%2', pCoverURL:'%3'.", (Object)LOGCLASS, (Object)mediaDetailInfo, (Object)string);
        MediaEntry mediaEntry = new MediaEntry();
        if (mediaDetailInfo != null) {
            mediaEntry.id = mediaDetailInfo.getEntryID();
            mediaEntry.title = mediaDetailInfo.getTitle().isEmpty() ? new MediaI18NString(mediaDetailInfo.getFilename().getI18NKey(), mediaDetailInfo.getFilename().getI18NString()) : new MediaI18NString(mediaDetailInfo.getTitle().getI18NKey(), mediaDetailInfo.getTitle().getI18NString());
            mediaEntry.album = new MediaI18NString(mediaDetailInfo.getAlbum().getI18NKey(), mediaDetailInfo.getAlbum().getI18NString());
            mediaEntry.albumID = mediaDetailInfo.getAlbumID();
            mediaEntry.artist = new MediaI18NString(mediaDetailInfo.getArtist().getI18NKey(), mediaDetailInfo.getArtist().getI18NString());
            mediaEntry.artistID = mediaDetailInfo.getArtistID();
            mediaEntry.genreID = mediaDetailInfo.getGenreID();
            mediaEntry.type = MediaUtilsSDIS.getMediaEntryType(mediaDetailInfo.getContentType(), mediaDetailInfo.getEntryFlags());
            mediaEntry.coverUrl = string;
        } else {
            MediaI18NString mediaI18NString = new MediaI18NString(0, "");
            mediaEntry.id = 0L;
            mediaEntry.title = mediaI18NString;
            mediaEntry.album = mediaI18NString;
            mediaEntry.artist = mediaI18NString;
            mediaEntry.artistID = 0L;
            mediaEntry.albumID = 0L;
            mediaEntry.genreID = 0L;
            mediaEntry.type = 0;
            mediaEntry.coverUrl = "";
        }
        try {
            this.logger.log(1000000, "[%1.updatePlayingTrack] ASI entry:'%2'.", (Object)LOGCLASS, (Object)mediaEntry);
            this.asiProvider.updatePlayingTrack(mediaEntry);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updatePlayingTrack]", (Throwable)exception);
        }
    }

    public void updatePlayListState(boolean bl, long l, int n, int n2) {
        this.logger.log(1000000, "[%1.updatePlayListState]", (Object)LOGCLASS);
        MediaPlaylistState mediaPlaylistState = new MediaPlaylistState();
        mediaPlaylistState.flags = 256;
        if ((n2 & 4) == 4) {
            mediaPlaylistState.flags |= 4;
        }
        if ((n2 & 2) == 2) {
            mediaPlaylistState.flags |= 8;
        }
        if (bl) {
            mediaPlaylistState.flags |= 1;
        }
        mediaPlaylistState.id = l;
        mediaPlaylistState.size = n;
        try {
            this.logger.log(1000000, "[%1.updatePlayListState] state: '%2'.", (Object)LOGCLASS, (Object)mediaPlaylistState);
            this.asiProvider.updateListState(mediaPlaylistState);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updatePlayListState] Exception during call", (Throwable)exception);
        }
    }

    public void updatePlayListInvalidState() {
        this.logger.log(1000000, "[%1.updatePlayListInvalidState]", (Object)LOGCLASS);
        MediaPlaylistState mediaPlaylistState = new MediaPlaylistState();
        mediaPlaylistState.flags = 258;
        mediaPlaylistState.id = 0L;
        mediaPlaylistState.size = 0;
        try {
            this.logger.log(1000000, "[%1.updatePlayListInvalidState] state: '%2'.", (Object)LOGCLASS, (Object)mediaPlaylistState);
            this.asiProvider.updateListState(mediaPlaylistState);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updatePlayListInvalidState] Exception during call", (Throwable)exception);
        }
    }

    public void updatePlaybackPossible(boolean bl) {
        try {
            this.logger.log(1000000, "[%1.updatePlaybackPossible] possible: '%2'.", (Object)LOGCLASS, (Object)(bl ? "TRUE" : "FALSE"));
            this.asiProvider.updatePlaybackPossible(bl ? 0 : -1);
        }
        catch (Exception exception) {
            this.logger.log(10000, "[updatePlaybackPossible] Exception during call", (Throwable)exception);
        }
    }

    private MediaSourceSlot getSDISSlotFromSlot(ISourceSlot iSourceSlot) {
        MediaSourceSlot mediaSourceSlot = new MediaSourceSlot();
        mediaSourceSlot.name = iSourceSlot.getName();
        mediaSourceSlot.slotIdx = iSourceSlot.getIndex();
        mediaSourceSlot.deviceIdx = iSourceSlot.getDeviceIndex();
        mediaSourceSlot.state = this.getSDISStateOfSlot(iSourceSlot);
        mediaSourceSlot.source = MediaSDISNotifier.getSDISSourceOfSlot(iSourceSlot);
        mediaSourceSlot.mediaType = MediaSDISNotifier.getSDISMediaTypeOfSlot(iSourceSlot);
        mediaSourceSlot.flags = MediaSDISNotifier.getSDISFlagsOfSlot(iSourceSlot);
        return mediaSourceSlot;
    }

    private static int getSDISFlagsOfSlot(ISourceSlot iSourceSlot) {
        int n = 0;
        if (iSourceSlot.getFlags().isFilesystemSyncComplete()) {
            n |= 1;
        }
        if (iSourceSlot.getFlags().isMetaDataSyncComplete()) {
            n |= 2;
        }
        if (iSourceSlot.getFlags().isSyncComplete()) {
            n |= 8;
        }
        if (iSourceSlot.getFlags().isCoverSyncComplete()) {
            n |= 4;
        }
        return n & 0xFF;
    }

    private int getSDISStateOfSlot(ISourceSlot iSourceSlot) {
        int n;
        block0 : switch (iSourceSlot.getState()) {
            case 0: {
                n = 1;
                break;
            }
            case 3: {
                if (iSourceSlot.getMediaType() == 24 && !this.iPodIsSupportedOnSDIS) {
                    this.logger.log(1000000, "[%1.getSDISStateOfSlot] iPod is not supported on SDIS. (idx='%2'). Set SDIS state: 'SOURCE_STATE_NOT_SUPPORTED'.", (Object)LOGCLASS, (long)iSourceSlot.getIndex());
                    n = 5;
                    break;
                }
                switch (iSourceSlot.getError()) {
                    case 0: {
                        n = 3;
                        break block0;
                    }
                    case 16: {
                        n = 4;
                        break block0;
                    }
                    case 17: 
                    case 18: {
                        n = 5;
                        break block0;
                    }
                    case 5: {
                        n = 8;
                        break block0;
                    }
                    case 22: {
                        n = 9;
                        break block0;
                    }
                    case 1: 
                    case 2: {
                        n = 6;
                        break block0;
                    }
                    case 3: {
                        n = 7;
                        break block0;
                    }
                }
                n = 10;
                break;
            }
            case 1: 
            case 2: {
                n = 2;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private static int getSDISSourceOfSlot(ISourceSlot iSourceSlot) {
        int n;
        switch (iSourceSlot.getSource().getType()) {
            case 2: {
                n = 1;
                break;
            }
            case 3: {
                n = 5;
                break;
            }
            case 6: {
                n = 3;
                break;
            }
            case 5: {
                n = 2;
                break;
            }
            case 10: {
                n = 4;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private static int getSDISMediaTypeOfSlot(ISourceSlot iSourceSlot) {
        int n;
        switch (iSourceSlot.getMediaType()) {
            case 5: 
            case 6: {
                n = 3;
                break;
            }
            case 1: {
                n = 2;
                break;
            }
            case 2: 
            case 7: 
            case 9: 
            case 10: 
            case 12: {
                n = 1;
                break;
            }
            case 13: {
                n = 5;
                break;
            }
            case 24: {
                n = 4;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    public void enableTemporalChildLock(boolean bl) {
        this.logger.log(1000000, "[%1.enableTemporalChildLock] isEnabled: %2", (Object)LOGCLASS, (Object)bl);
        try {
            MediaActiveSourceState mediaActiveSourceState = new MediaActiveSourceState();
            mediaActiveSourceState.setSlot(this.activeSourceState.getSlot());
            if (bl) {
                mediaActiveSourceState.setState(5);
            } else {
                mediaActiveSourceState.setState(this.activeSourceState.getState());
            }
            this.asiProvider.updateActiveSlotState(mediaActiveSourceState);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[enableTemporalChildLock]", (Throwable)methodException);
        }
    }
}

