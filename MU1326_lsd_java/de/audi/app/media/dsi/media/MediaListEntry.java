/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.i18n.I18NString;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.ListEntry;

public class MediaListEntry {
    public static final int INVALID_ID = -1;
    private final I18NString filename;
    private final I18NString title;
    private final I18NString album;
    private final long albumID;
    private final I18NString artist;
    private final long artistID;
    private final ResourceLocator coverart;
    private final ListEntry listEntry;
    private final int secLength;
    private final int fileCount;
    private final int folderCount;
    private final int playlistCount;

    public MediaListEntry(ListEntry listEntry) {
        this.listEntry = listEntry;
        this.filename = new I18NString(listEntry.getFilename(), this.isI18N());
        if (listEntry.getTitle() != null) {
            this.title = "".equals(listEntry.getTitle()) ? this.filename : new I18NString(listEntry.getTitle(), this.isI18N());
        } else {
            String string = MediaUtils.removeFileExtension(listEntry.getFilename());
            this.title = new I18NString(string, this.isI18N());
        }
        this.secLength = listEntry.getSecLength();
        if (listEntry.getExtInfo() != null) {
            if (listEntry.getExtInfo().getAlbum() != null) {
                this.album = new I18NString(listEntry.getExtInfo().getAlbum(), this.isI18N());
                this.albumID = listEntry.getExtInfo().getAlbumID();
            } else {
                this.album = null;
                this.albumID = -1L;
            }
            if (listEntry.getExtInfo().getArtist() != null) {
                this.artist = new I18NString(listEntry.getExtInfo().getArtist(), this.isI18N());
                this.artistID = listEntry.getExtInfo().getArtistID();
            } else {
                this.artist = null;
                this.artistID = -1L;
            }
            this.coverart = listEntry.getExtInfo().getCoverArtResource() != null ? listEntry.getExtInfo().getCoverArtResource() : null;
            this.fileCount = listEntry.getExtInfo().getFileCount();
            this.folderCount = listEntry.getExtInfo().getFolderCount();
            this.playlistCount = listEntry.getExtInfo().getPlaylistCount();
        } else {
            this.album = null;
            this.albumID = -1L;
            this.artist = null;
            this.artistID = -1L;
            this.coverart = null;
            this.fileCount = -1;
            this.folderCount = -1;
            this.playlistCount = -1;
        }
    }

    public MediaListEntry(long l, int n, String string) {
        this(l, n, string, null);
    }

    public MediaListEntry(long l, int n, String string, String string2, boolean bl) {
        this.listEntry = new ListEntry(l, string != null ? string : "", null != string2 ? string2 : "", n, 0, bl ? 16 : 0, null);
        this.filename = new I18NString(this.listEntry.getFilename(), bl);
        this.title = new I18NString(this.listEntry.getTitle(), bl);
        this.album = null;
        this.albumID = -1L;
        this.artist = null;
        this.artistID = -1L;
        this.secLength = -1;
        this.coverart = null;
        this.fileCount = -1;
        this.folderCount = -1;
        this.playlistCount = -1;
    }

    public MediaListEntry(long l, int n, String string, String string2) {
        this(l, n, string, string2, false);
    }

    public I18NString getFilename() {
        return this.filename;
    }

    public I18NString getTitle() {
        return this.title;
    }

    public I18NString getAlbum() {
        return this.album;
    }

    public long getAlbumID() {
        return this.albumID;
    }

    public I18NString getArtist() {
        return this.artist;
    }

    public long getArtistID() {
        return this.artistID;
    }

    public ResourceLocator getCovertArt() {
        return this.coverart;
    }

    public int getSecLength() {
        return this.secLength;
    }

    public int getFileCount() {
        return this.fileCount;
    }

    public int getFolderCount() {
        return this.folderCount;
    }

    public int getPlaylistCount() {
        return this.playlistCount;
    }

    public long getEntryID() {
        return this.listEntry.getEntryID();
    }

    public int getContentType() {
        return this.listEntry.getContentType();
    }

    public int getEntryFlags() {
        return this.listEntry.getFlags();
    }

    public long getTitleId() {
        return this.listEntry.getExtInfo().getTitleID();
    }

    public boolean isFile() {
        return MediaUtils.isFileContentType(this.getContentType());
    }

    public boolean isAudioFile() {
        return this.getContentType() == 1;
    }

    public boolean isVideoFile() {
        return this.getContentType() == 2;
    }

    public boolean isFolder() {
        return MediaUtils.isFolderContentType(this.getContentType());
    }

    public boolean isPlaylist() {
        return this.getContentType() == 10 || this.getContentType() == 6 || this.getContentType() == 5;
    }

    public boolean hasEntries() {
        return (this.listEntry.getFlags() & 1) != 1;
    }

    public boolean isProtected() {
        return (this.listEntry.getFlags() & 2) == 2;
    }

    public boolean isCorrupt() {
        return (this.listEntry.getFlags() & 4) == 4;
    }

    public boolean isDeadLink() {
        return (this.listEntry.getFlags() & 8) == 8;
    }

    public boolean isSelected() {
        return (this.listEntry.getFlags() & 0x20) == 32;
    }

    public boolean isPartlySelected() {
        return (this.listEntry.getFlags() & 0x40) == 64;
    }

    public boolean isImportRunning() {
        return (this.listEntry.getFlags() & 0x80) == 128;
    }

    public boolean isImportPending() {
        return (this.listEntry.getFlags() & 0x100) == 256;
    }

    public boolean isNoPlaybackDuringImport() {
        return (this.listEntry.getFlags() & 0x200) == 512;
    }

    public boolean isImported() {
        return (this.listEntry.getFlags() & 0x400) == 1024;
    }

    public boolean isPartiallyImported() {
        return (this.listEntry.getFlags() & 0x800) == 2048;
    }

    public boolean isOnline() {
        return (this.listEntry.getFlags() & 0x2000) == 8192;
    }

    private boolean isI18N() {
        return (this.listEntry.getFlags() & 0x10) == 16;
    }

    public static MediaListEntry[] convert(ListEntry[] listEntryArray) {
        MediaListEntry[] mediaListEntryArray = new MediaListEntry[listEntryArray.length];
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            mediaListEntryArray[i2] = new MediaListEntry(listEntryArray[i2]);
        }
        return mediaListEntryArray;
    }

    public static ListEntry[] convert(MediaListEntry[] mediaListEntryArray) {
        ListEntry[] listEntryArray = new ListEntry[mediaListEntryArray.length];
        for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
            MediaListEntry mediaListEntry = mediaListEntryArray[i2];
            listEntryArray[i2] = mediaListEntry.listEntry;
        }
        return listEntryArray;
    }

    public String toString() {
        Buffer buffer = new Buffer(40);
        buffer.append("[MediaListEntry: '").append(this.getEntryID()).append("','").append(this.getContentType()).append("','").append(this.getTitle()).append("','").append(this.getFilename()).append("']");
        return buffer.toString();
    }
}

