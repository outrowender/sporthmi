/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.coverflow;

import de.audi.app.media.i18n.I18NString;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.albumbrowser.AlbumEntryInfo;

public class MediaAlbumInfo {
    public static final int INVALID_ALBUM_IDX;
    private final I18NString album;
    private final I18NString artist;
    private final long albumIdx;

    public MediaAlbumInfo(AlbumEntryInfo albumEntryInfo) {
        this.album = new I18NString(albumEntryInfo.getAlbum(), true);
        this.artist = new I18NString(albumEntryInfo.getArtist(), true);
        this.albumIdx = albumEntryInfo.getAlbumIdx();
    }

    public MediaAlbumInfo() {
        this.album = new I18NString("", false);
        this.artist = new I18NString("", false);
        this.albumIdx = -1L;
    }

    public I18NString getAlbum() {
        return this.album;
    }

    public I18NString getArtist() {
        return this.artist;
    }

    public long getAlbumIdx() {
        return this.albumIdx;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("idx='").append(this.albumIdx).append("',album='").append(this.album).append("',artist='").append(this.artist).append("'");
        return buffer.toString();
    }
}

