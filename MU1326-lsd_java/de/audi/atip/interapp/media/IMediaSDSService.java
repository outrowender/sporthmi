/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.AbstractSDSApplicationService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.media.IMediaSDSService$MediaSDSListEntry;

public interface IMediaSDSService
extends AbstractSDSApplicationService {
    public static final byte BROWSE_TYPE_STRUCTURE;
    public static final byte BROWSE_TYPE_ARTIST;
    public static final byte BROWSE_TYPE_ALBUM;
    public static final byte BROWSE_TYPE_TITLE;
    public static final byte BROWSE_TYPE_PLAYLIST;
    public static final byte BROWSE_TYPE_VIDEO;
    public static final byte BROWSE_TYPE_IPOD_AUDIOBOOKS;
    public static final byte BROWSE_TYPE_IPOD_COMPOSERS;
    public static final byte BROWSE_TYPE_IPOD_PODCASTS;
    public static final byte BROWSE_TYPE_GENRE;
    public static final int BROWSE_TYPE_FAVORITE;
    public static final byte PL_FILLING_OK;
    public static final byte PL_FILLING_ERROR;
    public static final byte LISTMODE_DYN_DEVICE;
    public static final byte LISTMODE_ALBUM;
    public static final byte LISTMODE_ARTIST;
    public static final byte LISTMODE_TITLE;
    public static final byte LISTMODE_GENRE;
    public static final int PARTITION_INDEX_INVALID;

    default public void activateSource(int n, int n2) {
    }

    default public void activateSource(int n, int n2, int n3) {
    }

    default public void activateSource(int n) {
    }

    default public void setTrackNumber(int n) {
    }

    default public void folderUp() {
    }

    default public void playMoreLikeThis() {
    }

    default public void mix(boolean bl) {
    }

    default public void repeatTrack(boolean bl) {
    }

    default public void startBrowsing(int n) {
    }

    default public void playAllTracks() {
    }

    default public void g2pPlayTitle(long l) {
    }

    default public void g2pPlayTitleOfAlbum(long l, long l2) {
    }

    default public void g2pPlayTitleOfArtist(long l, long l2) {
    }

    default public void g2pPlayAlbum(long l) {
    }

    default public void g2pPlayAlbumOfArtist(long l, long l2) {
    }

    default public void g2pPlayArtist(long l) {
    }

    default public void g2pPlayGenre(long l) {
    }

    default public void g2pRequestCoverarts(long[] lArray, int n) {
    }

    default public byte fillPickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public byte fillPickList(IMediaSDSService$MediaSDSListEntry[] iMediaSDSService$MediaSDSListEntryArray, byte by) {
    }

    default public void showPickList() {
    }

    default public void hidePickList() {
    }
}

