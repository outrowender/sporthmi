/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.log.LogChannel;

public class NullMediaSDSService
extends NullService
implements IMediaSDSService {
    public NullMediaSDSService(LogChannel logChannel) {
        super(logChannel, "MediaSDSService");
    }

    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    public void setTrackNumber(int n) {
        super.log();
    }

    public void folderUp() {
        super.log();
    }

    public void startBrowsing(int n) {
        super.log();
    }

    public void playAllTracks() {
        super.log();
    }

    public void g2pPlayTitle(long l) {
        super.log();
    }

    public void g2pPlayAlbum(long l) {
        super.log();
    }

    public void g2pRequestArtistsOfGenre(long l) {
        super.log();
    }

    public void g2pRequestAlbumsOfArtist(long l, long l2) {
        super.log();
    }

    public void g2pRequestAlbumsOfArtist(long l) {
        super.log();
    }

    public void showPickList() {
        super.log();
    }

    public void hidePickList() {
        super.log();
    }

    public byte fillPickList(SDSListEntry[] sDSListEntryArray) {
        return 0;
    }

    public void g2pPlayTitleOfAlbum(long l, long l2) {
        super.log();
    }

    public void g2pPlayTitleOfArtist(long l, long l2) {
        super.log();
    }

    public void g2pPlayAlbumOfArtist(long l, long l2) {
        super.log();
    }

    public void playMoreLikeThis() {
        super.log();
    }

    public void activateSource(int n) {
        super.log();
    }

    public void mix(boolean bl) {
        super.log();
    }

    public void repeatTrack(boolean bl) {
        super.log();
    }

    public void activateSource(int n, int n2) {
        super.log();
    }

    public void g2pPlayArtist(long l) {
        super.log();
    }

    public byte fillPickList(IMediaSDSService.MediaSDSListEntry[] mediaSDSListEntryArray, byte by) {
        super.log();
        return 0;
    }

    public void activateSource(int n, int n2, int n3) {
        super.log();
    }

    public void g2pRequestCoverarts(long[] lArray, int n) {
        super.log();
    }

    public void g2pPlayGenre(long l) {
        super.log();
    }
}

