/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.MediaCoverartEntry;
import de.audi.atip.interapp.media.MediaSDSEntry;

public interface IMediaSDSServiceListener {
    public static final byte G2P_SUCCESSFUL = 0;
    public static final byte G2P_FAILED = 1;
    public static final byte G2P_SYNCING = 2;
    public static final byte G2P_DISABLED = 3;
    public static final byte SDS_COMMAND_SUCCESSFUL = 0;
    public static final byte SDS_COMMAND_NOT_SUPPORTED = 1;
    public static final byte SDS_COMMAND_SLOT_NOT_READY = 2;
    public static final byte ACTIVATESOURCE_SUCCESSFUL = 0;
    public static final byte ACTIVATESOURCE_ERROR_NOT_AVAILABLE = 3;
    public static final byte ACTIVATESOURCE_ERROR_SOURCE_NOT_SUPPORTED = 1;
    public static final byte ACTIVATESOURCE_ERROR_SLOT_EMPTY = 4;
    public static final byte ACTIVATESOURCE_ERROR_SLOT_NOT_READABLE = 5;
    public static final byte ACTIVATESOURCE_ERROR_SLOT_NOT_PLAYABLE = 6;
    public static final byte ACTIVATESOURCE_ERROR_SLOT_IDX_OUT_OF_RANGE = 7;
    public static final byte ACTIVATESOURCE_ERROR_IMPORT_RUNNING = 8;
    public static final byte ACTIVATESOURCE_ERROR_GENERIC = 9;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_DEACTIVATED = 10;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_DEACTIVATED_CLAMP_OFF = 11;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_BT_RECONNECTING = 12;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_BT_AUDIOPLAYER_DEACTIVATED = 13;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_BT_AUDIOPLAYER_NOT_CONNECTED = 14;
    public static final byte ACTIVATESOURCE_ERROR_CHARGING = 15;
    public static final byte ACTIVATESOURCE_ERROR_SLOT_LOADING = 16;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_DEACTIVATED_WLAN_OFF = 17;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_DEACTIVATED_NO_CONNECTION = 18;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_DEACTIVATED_NO_APPS = 19;
    public static final byte SETTRACKNUMBER_FAILED_ACTIVE_SLOT_NOT_READY = 1;
    public static final byte SETTRACKNUMBER_TITLENUMBER_NOT_FOUND = 3;
    public static final byte SETTRACKNUMBER_TITLENUMBER_NOT_READABLE = 4;
    public static final byte SETTRACKNUMBER_NO_TITLENUMBERS_AVAILABLE = 6;
    public static final byte SETTRACKNUMBER_SUCCESSFUL = 5;
    public static final byte FOLDERUP_FAILED_ACTIVE_SLOT_NOT_READY = 1;
    public static final byte FOLDERUP_SUCCESSFUL = 2;
    public static final byte FOLDERUP_FAILED_ROOT_LEVEL_REACHED = 3;
    public static final byte FOLDERUP_FAILED_BROWSER_NOT_READY = 4;
    public static final int START_BROWSING_FAILED_SLOT_NOT_READY = 1;
    public static final int START_BROWSING_FAILED_NOT_SUPPORTED = 2;
    public static final int START_BROWSING_SUCCESSFUL = 3;
    public static final byte MIX_SUCCESSFUL = 1;
    public static final byte MIX_ALREADY_SET = 2;
    public static final byte MIX_ERROR_NOT_SUPPORTED = 3;
    public static final byte REPEAT_TRACK_ALREADY_SET = 4;
    public static final byte MORELIKETHIS_ERROR_NOT_SUPPORTED = 1;
    public static final byte MORELIKETHIS_ERROR_NOT_READY = 2;
    public static final byte MORELIKETHIS_ERROR_FAILED = 3;
    public static final byte MORELIKETHIS_SUCCESSFUL = 4;

    public void processedActivateSource(int var1);

    public void processedSetTrackNumber(int var1);

    public void processedFolderUp(int var1);

    public void processedStartBrowsing(int var1);

    public void processedMix(int var1);

    public void processedRepeatTrack(int var1);

    public void processedPlayMoreLikeThis(int var1);

    public void g2pStateChanged(int var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7);

    public void responseG2PArtistsOfGenre(byte var1, long var2, MediaSDSEntry[] var4);

    public void responseG2pAlbumsOfArtist(byte var1, long var2, long var4, MediaSDSEntry[] var6);

    public void responseG2PAlbumsOfArtist(byte var1, long var2, MediaSDSEntry[] var4);

    public void playAllTracksResult(byte var1);

    public void g2pPlayTitleResult(byte var1);

    public void g2pPlayTitleOfAlbumResult(byte var1);

    public void g2pPlayAlbumResult(byte var1);

    public void g2pPlayAlbumOfArtistResult(byte var1);

    public void g2pPlayArtistResult(byte var1);

    public void g2pPlayTitleOfArtistResult(byte var1);

    public void g2pPlayGenreResult(byte var1);

    public void g2pRequestCoverartsResult(byte var1, MediaCoverartEntry[] var2);
}

