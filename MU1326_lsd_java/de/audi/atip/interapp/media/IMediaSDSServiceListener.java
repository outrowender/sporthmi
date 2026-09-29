/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.MediaCoverartEntry;
import de.audi.atip.interapp.media.MediaSDSEntry;

public interface IMediaSDSServiceListener {
    public static final byte G2P_SUCCESSFUL;
    public static final byte G2P_FAILED;
    public static final byte G2P_SYNCING;
    public static final byte G2P_DISABLED;
    public static final byte SDS_COMMAND_SUCCESSFUL;
    public static final byte SDS_COMMAND_NOT_SUPPORTED;
    public static final byte SDS_COMMAND_SLOT_NOT_READY;
    public static final byte ACTIVATESOURCE_SUCCESSFUL;
    public static final byte ACTIVATESOURCE_ERROR_NOT_AVAILABLE;
    public static final byte ACTIVATESOURCE_ERROR_SOURCE_NOT_SUPPORTED;
    public static final byte ACTIVATESOURCE_ERROR_SLOT_EMPTY;
    public static final byte ACTIVATESOURCE_ERROR_SLOT_NOT_READABLE;
    public static final byte ACTIVATESOURCE_ERROR_SLOT_NOT_PLAYABLE;
    public static final byte ACTIVATESOURCE_ERROR_SLOT_IDX_OUT_OF_RANGE;
    public static final byte ACTIVATESOURCE_ERROR_IMPORT_RUNNING;
    public static final byte ACTIVATESOURCE_ERROR_GENERIC;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_DEACTIVATED;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_DEACTIVATED_CLAMP_OFF;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_BT_RECONNECTING;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_BT_AUDIOPLAYER_DEACTIVATED;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_BT_AUDIOPLAYER_NOT_CONNECTED;
    public static final byte ACTIVATESOURCE_ERROR_CHARGING;
    public static final byte ACTIVATESOURCE_ERROR_SLOT_LOADING;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_DEACTIVATED_WLAN_OFF;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_DEACTIVATED_NO_CONNECTION;
    public static final byte ACTIVATESOURCE_SUCCESSFUL_DEACTIVATED_NO_APPS;
    public static final byte SETTRACKNUMBER_FAILED_ACTIVE_SLOT_NOT_READY;
    public static final byte SETTRACKNUMBER_TITLENUMBER_NOT_FOUND;
    public static final byte SETTRACKNUMBER_TITLENUMBER_NOT_READABLE;
    public static final byte SETTRACKNUMBER_NO_TITLENUMBERS_AVAILABLE;
    public static final byte SETTRACKNUMBER_SUCCESSFUL;
    public static final byte FOLDERUP_FAILED_ACTIVE_SLOT_NOT_READY;
    public static final byte FOLDERUP_SUCCESSFUL;
    public static final byte FOLDERUP_FAILED_ROOT_LEVEL_REACHED;
    public static final byte FOLDERUP_FAILED_BROWSER_NOT_READY;
    public static final int START_BROWSING_FAILED_SLOT_NOT_READY;
    public static final int START_BROWSING_FAILED_NOT_SUPPORTED;
    public static final int START_BROWSING_SUCCESSFUL;
    public static final byte MIX_SUCCESSFUL;
    public static final byte MIX_ALREADY_SET;
    public static final byte MIX_ERROR_NOT_SUPPORTED;
    public static final byte REPEAT_TRACK_ALREADY_SET;
    public static final byte MORELIKETHIS_ERROR_NOT_SUPPORTED;
    public static final byte MORELIKETHIS_ERROR_NOT_READY;
    public static final byte MORELIKETHIS_ERROR_FAILED;
    public static final byte MORELIKETHIS_SUCCESSFUL;

    default public void processedActivateSource(int n) {
    }

    default public void processedSetTrackNumber(int n) {
    }

    default public void processedFolderUp(int n) {
    }

    default public void processedStartBrowsing(int n) {
    }

    default public void processedMix(int n) {
    }

    default public void processedRepeatTrack(int n) {
    }

    default public void processedPlayMoreLikeThis(int n) {
    }

    default public void g2pStateChanged(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
    }

    default public void responseG2PArtistsOfGenre(byte by, long l, MediaSDSEntry[] mediaSDSEntryArray) {
    }

    default public void responseG2pAlbumsOfArtist(byte by, long l, long l2, MediaSDSEntry[] mediaSDSEntryArray) {
    }

    default public void responseG2PAlbumsOfArtist(byte by, long l, MediaSDSEntry[] mediaSDSEntryArray) {
    }

    default public void playAllTracksResult(byte by) {
    }

    default public void g2pPlayTitleResult(byte by) {
    }

    default public void g2pPlayTitleOfAlbumResult(byte by) {
    }

    default public void g2pPlayAlbumResult(byte by) {
    }

    default public void g2pPlayAlbumOfArtistResult(byte by) {
    }

    default public void g2pPlayArtistResult(byte by) {
    }

    default public void g2pPlayTitleOfArtistResult(byte by) {
    }

    default public void g2pPlayGenreResult(byte by) {
    }

    default public void g2pRequestCoverartsResult(byte by, MediaCoverartEntry[] mediaCoverartEntryArray) {
    }
}

