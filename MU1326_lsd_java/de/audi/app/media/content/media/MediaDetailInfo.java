/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import org.dsi.ifc.media.ChapterInfo;
import org.dsi.ifc.media.EntryInfo;

public class MediaDetailInfo {
    public static final int INVALID_ID = 0;
    private final PlayingTrack playingTrack;
    private final int contentType;
    private final int entryFlags;
    private final I18NString title;
    private final I18NString filename;
    private final I18NString artist;
    private final I18NString album;
    private final long artistEntryID;
    private final long albumEntryID;
    private final long genreEntryID;
    private final I18NString genre;
    private final int activeChapter;
    private final int numChapters;

    public MediaDetailInfo(EntryInfo entryInfo, PlayingTrack playingTrack) {
        Object object;
        boolean bl;
        if (entryInfo.getEntryID() != playingTrack.getEntryID()) {
            throw new IllegalArgumentException("EntryID mismatch.");
        }
        this.contentType = entryInfo.getContentType();
        this.entryFlags = entryInfo.getFlags();
        this.artistEntryID = entryInfo.getArtistID();
        this.albumEntryID = entryInfo.getAlbumID();
        this.genreEntryID = entryInfo.getGenreID();
        this.playingTrack = playingTrack;
        boolean bl2 = bl = (entryInfo.getFlags() & 0x10) == 16;
        if (entryInfo.getTitle() == null) {
            object = MediaUtils.removeFileExtension(entryInfo.getFilename());
            this.title = new I18NString((String)object, bl);
        } else {
            this.title = new I18NString(entryInfo.getTitle(), bl);
        }
        this.filename = new I18NString(entryInfo.getFilename(), bl);
        this.artist = new I18NString(entryInfo.getArtist(), bl);
        this.album = new I18NString(entryInfo.getAlbum(), bl);
        this.genre = new I18NString(entryInfo.getGenre(), bl);
        object = entryInfo.getChapterInfo();
        if (object != null) {
            this.activeChapter = ((ChapterInfo)object).getActiveChapter();
            this.numChapters = ((ChapterInfo)object).getNumChapters();
        } else {
            this.activeChapter = 0;
            this.numChapters = 0;
        }
    }

    public MediaDetailInfo() {
        I18NString i18NString;
        this.playingTrack = new PlayingTrack(-1L, new MediaListEntry[0]);
        this.contentType = 0;
        this.entryFlags = 0;
        this.artistEntryID = 0L;
        this.albumEntryID = 0L;
        this.genreEntryID = 0L;
        this.filename = i18NString = new I18NString("", false);
        this.title = i18NString;
        this.artist = i18NString;
        this.album = i18NString;
        this.genre = i18NString;
        this.activeChapter = 0;
        this.numChapters = 0;
    }

    public boolean isValid() {
        return this.playingTrack.getEntryID() != -1L;
    }

    public long getEntryID() {
        return this.playingTrack.getEntryID();
    }

    public PlayingTrack getPlayingTrack() {
        return this.playingTrack;
    }

    public int getContentType() {
        return this.contentType;
    }

    public int getEntryFlags() {
        return this.entryFlags;
    }

    public long getArtistID() {
        return this.artistEntryID;
    }

    public long getAlbumID() {
        return this.albumEntryID;
    }

    public long getGenreID() {
        return this.genreEntryID;
    }

    public I18NString getTitle() {
        return this.title;
    }

    public I18NString getFilename() {
        return this.filename;
    }

    public I18NString getArtist() {
        return this.artist;
    }

    public I18NString getAlbum() {
        return this.album;
    }

    public I18NString getGenre() {
        return this.genre;
    }

    public boolean isAudio() {
        return this.contentType == 1;
    }

    public boolean isVideo() {
        return this.contentType == 2;
    }

    public boolean isDRMProtected() {
        return (this.entryFlags & 2) == 2;
    }

    public boolean isImportRunning() {
        return (this.entryFlags & 0x80) == 128;
    }

    public boolean isCorrupt() {
        return (this.entryFlags & 4) == 4;
    }

    public boolean isDeadlink() {
        return (this.entryFlags & 8) == 8;
    }

    public boolean isChapterAvailable() {
        return this.numChapters > 0;
    }

    public int getNumChapters() {
        return this.numChapters;
    }

    public int getActiveChapter() {
        return this.activeChapter;
    }

    public boolean equals(Object object) {
        try {
            MediaDetailInfo mediaDetailInfo = (MediaDetailInfo)object;
            return mediaDetailInfo.getEntryID() == this.getEntryID() && mediaDetailInfo.getContentType() == this.getContentType() && MediaUtils.isSameFolder(mediaDetailInfo.getPlayingTrack().getPlaybackFolder(), this.getPlayingTrack().getPlaybackFolder());
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int hashCode() {
        return super.hashCode();
    }
}

